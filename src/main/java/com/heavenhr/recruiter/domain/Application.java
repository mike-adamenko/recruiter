package com.heavenhr.recruiter.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Application
 *
 *  @author Mike Adamenko (mnadamenko@gmail.com)
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"fk_offer", "candidateEmail"})})
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_offer")
    @JsonIgnore
    private Offer offer;
    private String candidateEmail;
    private String resumeText;
    private ApplicationStatus applicationStatus;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public enum ApplicationStatus {
        APPLIED, INVITED, REJECTED, HIRED
    }
}
