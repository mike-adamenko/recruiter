package com.heavenhr.recruiter.service.eventsystem.impl;

import com.heavenhr.recruiter.domain.Application;
import com.heavenhr.recruiter.service.eventsystem.Event;

/**
 * Application status change triggers this notification
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class StatusUpdateEvent implements Event {

    private final Application.ApplicationStatus applicationStatusBefore;
    private final Application.ApplicationStatus applicationStatusAfter;

    public StatusUpdateEvent(Application.ApplicationStatus applicationStatusBefore, Application.ApplicationStatus applicationStatusAfter) {
        this.applicationStatusBefore = applicationStatusBefore;
        this.applicationStatusAfter = applicationStatusAfter;
    }

    @Override
    public String toString() {
        return "Status was updated. Before: " + applicationStatusBefore + ", After: " + applicationStatusAfter;
    }
}
