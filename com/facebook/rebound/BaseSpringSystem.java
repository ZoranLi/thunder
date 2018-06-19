package com.facebook.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BaseSpringSystem {
    private final Set<Spring> mActiveSprings = new CopyOnWriteArraySet();
    private boolean mIdle = true;
    private final CopyOnWriteArraySet<SpringSystemListener> mListeners = new CopyOnWriteArraySet();
    private final SpringLooper mSpringLooper;
    private final Map<String, Spring> mSpringRegistry = new HashMap();

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper == null) {
            throw new IllegalArgumentException("springLooper is required");
        }
        this.mSpringLooper = springLooper;
        this.mSpringLooper.setSpringSystem(this);
    }

    public boolean getIsIdle() {
        return this.mIdle;
    }

    public Spring createSpring() {
        Spring spring = new Spring(this);
        registerSpring(spring);
        return spring;
    }

    public Spring getSpringById(String str) {
        if (str != null) {
            return (Spring) this.mSpringRegistry.get(str);
        }
        throw new IllegalArgumentException("id is required");
    }

    public List<Spring> getAllSprings() {
        List list;
        Collection values = this.mSpringRegistry.values();
        if (values instanceof List) {
            list = (List) values;
        } else {
            list = new ArrayList(values);
        }
        return Collections.unmodifiableList(list);
    }

    void registerSpring(Spring spring) {
        if (spring == null) {
            throw new IllegalArgumentException("spring is required");
        } else if (this.mSpringRegistry.containsKey(spring.getId())) {
            throw new IllegalArgumentException("spring is already registered");
        } else {
            this.mSpringRegistry.put(spring.getId(), spring);
        }
    }

    void deregisterSpring(Spring spring) {
        if (spring == null) {
            throw new IllegalArgumentException("spring is required");
        }
        this.mActiveSprings.remove(spring);
        this.mSpringRegistry.remove(spring.getId());
    }

    void advance(double d) {
        for (Spring spring : this.mActiveSprings) {
            if (spring.systemShouldAdvance()) {
                spring.advance(d / 1000.0d);
            } else {
                this.mActiveSprings.remove(spring);
            }
        }
    }

    public void loop(double d) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((SpringSystemListener) it.next()).onBeforeIntegrate(this);
        }
        advance(d);
        if (this.mActiveSprings.isEmpty() != null) {
            this.mIdle = Double.MIN_VALUE;
        }
        d = this.mListeners.iterator();
        while (d.hasNext()) {
            ((SpringSystemListener) d.next()).onAfterIntegrate(this);
        }
        if (this.mIdle != null) {
            this.mSpringLooper.stop();
        }
    }

    void activateSpring(String str) {
        Spring spring = (Spring) this.mSpringRegistry.get(str);
        if (spring == null) {
            StringBuilder stringBuilder = new StringBuilder("springId ");
            stringBuilder.append(str);
            stringBuilder.append(" does not reference a registered spring");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mActiveSprings.add(spring);
        if (getIsIdle() != null) {
            this.mIdle = null;
            this.mSpringLooper.start();
        }
    }

    public void addListener(SpringSystemListener springSystemListener) {
        if (springSystemListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.mListeners.add(springSystemListener);
    }

    public void removeListener(SpringSystemListener springSystemListener) {
        if (springSystemListener == null) {
            throw new IllegalArgumentException("listenerToRemove is required");
        }
        this.mListeners.remove(springSystemListener);
    }

    public void removeAllListeners() {
        this.mListeners.clear();
    }
}
