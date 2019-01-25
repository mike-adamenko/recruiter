package com.heavenhr.recruiter;

import com.heavenhr.recruiter.domain.Offer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping(value = "offer/{jobTitle}", method = RequestMethod.GET)
    public Offer getOffer(@PathVariable String jobTitle) {
        return new ();
    }

    @RequestMapping(value = "mock1", method = RequestMethod.POST)
    public MockEntity1 getMockEntity1(@RequestBody MockEntity1 mockEntity1) {
        return new MockEntity1(mockEntity1.getProperty1(), mockEntity1.getProperty2());
    }
}
