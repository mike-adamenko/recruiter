package com.heavenhr.recruiter.domain;

/**
 *
 */
public class Application {
    private  Offer offer;
    private  String candidateEmail;
    private  String resumeText;
    private ApplicationStatus applicationStatus;

    public enum ApplicationStatus{
            APPLIED, INVITED, REJECTED, HIRED
        }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
