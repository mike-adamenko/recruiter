package com.heavenhr.recruiter;

import com.heavenhr.recruiter.dao.ApplicationDAO;
import com.heavenhr.recruiter.dao.OfferDAO;
import com.heavenhr.recruiter.domain.Application;
import com.heavenhr.recruiter.domain.Offer;
import com.heavenhr.recruiter.service.eventsystem.impl.DefaultEventManager;
import com.heavenhr.recruiter.service.eventsystem.impl.StatusUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
@RestController
public class WebController {

    @Autowired
    OfferDAO offerDAO;

    @Autowired
    ApplicationDAO applicationDAO;

    @Autowired
    DefaultEventManager eventManager;

    //GET

    @GetMapping(value = "offers/{id}")
    public Offer getOfferById(@PathVariable Integer id) {
        return offerDAO.findById(id).get();
    }

    @GetMapping(value = "offer")
    public Offer getOfferByJobTitle(String jobTitle) {
        return offerDAO.findByJobTitle(jobTitle).get();
    }

    @GetMapping(value = "offers")
    public Iterable<Offer> getOffers() {
        return offerDAO.findAll();
    }

    @GetMapping(value = "numberOfApplications/{jobTitle}")
    public Integer getNumberOfApplications(@PathVariable String jobTitle) {
        return offerDAO.findByJobTitle(jobTitle).get().getApplications().size();
    }

    @GetMapping(value = "applications/offer/{jobTitle}")
    public Iterable<Application> getApplications(@PathVariable String jobTitle) {
        return applicationDAO.findByOffer(jobTitle);
    }

    @GetMapping(value = "applications/{id}")
    public Application getApplicationById(@PathVariable Integer id) {
        return applicationDAO.findById(id).get();
    }

    @GetMapping(value = "application")
    public Application getApplicationByEmail(String candidateEmail) {
        return applicationDAO.findByCandidateEmail(candidateEmail).get();
    }

    //PUT

    @PutMapping(value = "offer")
    public void createOffer(@RequestBody Offer offer) {
        offerDAO.save(offer);
    }

    @PutMapping(value = "offer/{jobTitle}")
    public void applyForOfferByJobTitle(@PathVariable String jobTitle, @RequestBody Application application) {
        Offer offer = offerDAO.findByJobTitle(jobTitle).get();
        application.setApplicationStatus(Application.ApplicationStatus.APPLIED);
        application.setOffer(offer);
        offer.getApplications().add(application);
        offerDAO.save(offer);
    }

    //POST

    @PostMapping(value = "application/{candidateEmail}")
    public void updateApplicationStatus(@PathVariable String candidateEmail, String applicationStatus) {
        Application application = applicationDAO.findByCandidateEmail(candidateEmail).get();
        Application.ApplicationStatus applicationStatusBefore = application.getApplicationStatus();
        Application.ApplicationStatus applicationStatusAfter = Application.ApplicationStatus.valueOf(applicationStatus);
        application.setApplicationStatus(applicationStatusAfter);
        applicationDAO.save(application);
        eventManager.publishEvent(new StatusUpdateEvent(applicationStatusBefore, applicationStatusAfter));
    }


}
