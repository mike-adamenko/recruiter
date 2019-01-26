package com.heavenhr.recruiter.dao;

import com.heavenhr.recruiter.domain.Offer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 *
 */
public interface OfferDAO extends CrudRepository<Offer, Integer> {

    Optional<Offer> findByJobTitle(String jobTitle);
}
