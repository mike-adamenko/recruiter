package com.heavenhr.recruiter.service.eventsystem.impl;

import com.heavenhr.recruiter.service.eventsystem.Event;
import com.heavenhr.recruiter.service.eventsystem.EventListener;
import com.heavenhr.recruiter.service.eventsystem.EventManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Manages the firing and receiving of events.
 * <p>
 * <p>Any event passed to {@link #publishEvent} will be passed through to "interested" listeners.
 * <p>
 * <p>Event listeners can register to receive events via
 * {@link #registerListener(String, EventListener)}
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
@Service
public class DefaultEventManager implements EventManager {
    private final Map<String, EventListener> listeners = new HashMap<>();
    private final Map<Class<?>, List<EventListener>> listenersByClass = new HashMap<>();

    @PostConstruct
    public void initialize() {
        registerListener("logListener", new LogListener());
    }

    @Override
    public void publishEvent(Event event) {
        if (event == null) {
            System.err.println("Null event fired?");
            return;
        }
        sendEventTo(event, listenersByClass.get(event.getClass()));

        sendEventTo(event, listenersByClass.get(null));
    }

    @Override
    public void registerListener(String listenerKey, EventListener listener) {
        if (listenerKey == null || listenerKey.equals(""))
            throw new IllegalArgumentException("Key for the listener must not be null: " + listenerKey);

        if (listener == null)
            throw new IllegalArgumentException("The listener must not be null");

        if (listeners.containsKey(listenerKey))
            unregisterListener(listenerKey);

        Class[] classes = listener.getHandledEventClasses();

        if (classes.length == 0) {
            addToListenerList(null, listener);
        }
        for (final Class aClass : classes) {
            addToListenerList(aClass, listener);
        }

        listeners.put(listenerKey, listener);
    }

    @Override
    public void unregisterListener(String listenerKey) {
        EventListener listener = listeners.get(listenerKey);

        for (List<EventListener> list : listenersByClass.values()) {
            list.remove(listener);
        }

        listeners.remove(listenerKey);
    }

    private void sendEventTo(Event event, Collection<EventListener> listeners) {
        if (listeners == null || listeners.size() == 0)
            return;

        for (EventListener eventListener : listeners) {
            eventListener.handleEvent(event);
        }
    }

    private void addToListenerList(Class aClass, EventListener listener) {
        if (!listenersByClass.containsKey(aClass))
            listenersByClass.put(aClass, new ArrayList<>());
        listenersByClass.get(aClass).add(listener);
    }

    public Map<String, EventListener> getListeners() {
        return listeners;
    }
}
