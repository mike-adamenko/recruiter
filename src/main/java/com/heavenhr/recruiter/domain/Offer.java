package com.heavenhr.recruiter.domain;

import java.time.LocalDate;

/**
 *
 */
public class Offer {
    private String jobTitle;
    private LocalDate startDate;
    private Integer numberOfApplications;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(Integer numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }
}
