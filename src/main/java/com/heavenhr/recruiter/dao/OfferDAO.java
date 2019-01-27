package com.heavenhr.recruiter.dao;

import com.heavenhr.recruiter.domain.Offer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *@author Mike Adamenko (mnadamenko@gmail.com)
 */
public interface OfferDAO extends CrudRepository<Offer, Integer> {

    Optional<Offer> findByJobTitle(String jobTitle);
}
