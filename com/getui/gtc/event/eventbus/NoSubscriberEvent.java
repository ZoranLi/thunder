package com.getui.gtc.event.eventbus;

public final class NoSubscriberEvent {
    public final c eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(c cVar, Object obj) {
        this.eventBus = cVar;
        this.originalEvent = obj;
    }
}
