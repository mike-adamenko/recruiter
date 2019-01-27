package com.heavenhr.recruiter.dao;

import com.heavenhr.recruiter.domain.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 *@author Mike Adamenko (mnadamenko@gmail.com)
 */
public interface ApplicationDAO extends CrudRepository<Application, Integer> {

    Optional<Application> findByCandidateEmail(String candidateEmail);

    @Query(value = "SELECT a FROM Application a, Offer o where a.offer = o and o.jobTitle = :jobTitle")
    Iterable<Application> findByOffer(@Param("jobTitle") String jobTitle);
}
