package com.heavenhr.recruiter.dao;

import com.heavenhr.recruiter.domain.Application;
import com.heavenhr.recruiter.domain.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface ApplicationDAO extends CrudRepository<Application, Integer> {

    Optional<Application> findByCandidateEmail(String candidateEmail);
}
