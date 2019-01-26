package com.heavenhr.recruiter.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String jobTitle;
    private LocalDate startDate;
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<Application> applications;
    @Transient
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Application> getApplications() {
        if (applications == null)applications = new ArrayList<>();
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }


    @PostLoad
    private void onLoad() {
        this.numberOfApplications = getApplications().size();
    }
}
