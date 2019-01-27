package com.heavenhr.recruiter.service.eventsystem.impl;

import com.heavenhr.recruiter.service.eventsystem.Event;
import com.heavenhr.recruiter.service.eventsystem.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogListener implements EventListener {

    private final static Logger logger = LoggerFactory.getLogger(LogListener.class);

    @Override
    public void handleEvent(Event event) {
        logger.info(event.toString());
    }

    @Override
    public Class[] getHandledEventClasses() {
        return new Class[]{StatusUpdateEvent.class};
    }
}




