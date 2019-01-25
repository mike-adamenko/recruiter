package com.heavenhr.recruiter.dao;

import com.heavenhr.recruiter.domain.Offer;

import java.util.List;

/**
 *
 */
public interface OfferDAO {

    List<Offer> findAll();

    List<Offer> findByJobTitle(String jobTitle);
}
