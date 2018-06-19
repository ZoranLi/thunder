package android.arch.lifecycle;

import android.arch.a.a.b;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.Lifecycle.State;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: LifecycleRegistry */
public final class c extends Lifecycle {
    public State a;
    private android.arch.a.a.a<a, a> b = new android.arch.a.a.a();
    private final b c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<State> g = new ArrayList();

    /* compiled from: LifecycleRegistry */
    static class a {
        State a;
        GenericLifecycleObserver b;

        a(a aVar, State state) {
            this.b = f.a((Object) aVar);
            this.a = state;
        }

        final void a(b bVar, Event event) {
            State b = c.b(event);
            this.a = c.a(this.a, b);
            this.b.a(bVar, event);
            this.a = b;
        }
    }

    public c(@NonNull b bVar) {
        this.c = bVar;
        this.a = State.INITIALIZED;
    }

    public final void a(Event event) {
        this.a = b(event);
        if (this.e == null) {
            if (this.d == null) {
                this.e = true;
                c();
                this.e = null;
                return;
            }
        }
        this.f = true;
    }

    private State b(a aVar) {
        android.arch.a.a.a aVar2 = this.b;
        State state = null;
        aVar = aVar2.b(aVar) ? ((c) aVar2.a.get(aVar)).d : null;
        aVar = aVar != null ? ((a) aVar.getValue()).a : null;
        if (!this.g.isEmpty()) {
            state = (State) this.g.get(this.g.size() - 1);
        }
        return a(a(this.a, aVar), state);
    }

    public final void a(a aVar) {
        a aVar2 = new a(aVar, this.a == State.DESTROYED ? State.DESTROYED : State.INITIALIZED);
        if (((a) this.b.a(aVar, aVar2)) == null) {
            int i;
            Enum b;
            if (this.d == 0) {
                if (!this.e) {
                    i = 0;
                    b = b(aVar);
                    this.d++;
                    while (aVar2.a.compareTo(b) < 0 && this.b.b(aVar)) {
                        a(aVar2.a);
                        aVar2.a(this.c, b(aVar2.a));
                        a();
                        b = b(aVar);
                    }
                    if (i == 0) {
                        c();
                    }
                    this.d -= 1;
                }
            }
            i = 1;
            b = b(aVar);
            this.d++;
            while (aVar2.a.compareTo(b) < 0) {
                a(aVar2.a);
                aVar2.a(this.c, b(aVar2.a));
                a();
                b = b(aVar);
            }
            if (i == 0) {
                c();
            }
            this.d -= 1;
        }
    }

    private void a() {
        this.g.remove(this.g.size() - 1);
    }

    private void a(State state) {
        this.g.add(state);
    }

    static State b(Event event) {
        switch (d.a[event.ordinal()]) {
            case 1:
            case 2:
                return State.CREATED;
            case 3:
            case 4:
                return State.STARTED;
            case 5:
                return State.RESUMED;
            case 6:
                return State.DESTROYED;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unexpected event value ");
                stringBuilder.append(event);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private static Event b(State state) {
        switch (d.b[state.ordinal()]) {
            case 1:
            case 5:
                return Event.ON_CREATE;
            case 2:
                return Event.ON_START;
            case 3:
                return Event.ON_RESUME;
            case 4:
                throw new IllegalArgumentException();
            default:
                StringBuilder stringBuilder = new StringBuilder("Unexpected state value ");
                stringBuilder.append(state);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    private void b() {
        b bVar = this.b;
        Iterator dVar = new d();
        bVar.d.put(dVar, Boolean.valueOf(false));
        while (dVar.hasNext() && !this.f) {
            Entry entry = (Entry) dVar.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.a) < 0 && !this.f && this.b.b(entry.getKey())) {
                a(aVar.a);
                aVar.a(this.c, b(aVar.a));
                a();
            }
        }
    }

    static State a(@NonNull State state, @Nullable State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void c() {
        while (true) {
            State state;
            boolean z = true;
            if (this.b.e != 0) {
                State state2 = ((a) this.b.b.getValue()).a;
                state = ((a) this.b.c.getValue()).a;
                if (state2 != state || this.a != state) {
                    z = false;
                }
            }
            if (z) {
                this.f = false;
                return;
            }
            Entry entry;
            this.f = false;
            if (this.a.compareTo(((a) this.b.b.getValue()).a) < 0) {
                b bVar = this.b;
                Iterator bVar2 = new b(bVar.c, bVar.b);
                bVar.d.put(bVar2, Boolean.valueOf(false));
                while (bVar2.hasNext() && !this.f) {
                    entry = (Entry) bVar2.next();
                    a aVar = (a) entry.getValue();
                    while (aVar.a.compareTo(this.a) > 0 && !this.f && this.b.b(entry.getKey())) {
                        Event event;
                        state = aVar.a;
                        switch (d.b[state.ordinal()]) {
                            case 1:
                                throw new IllegalArgumentException();
                            case 2:
                                event = Event.ON_DESTROY;
                                break;
                            case 3:
                                event = Event.ON_STOP;
                                break;
                            case 4:
                                event = Event.ON_PAUSE;
                                break;
                            case 5:
                                throw new IllegalArgumentException();
                            default:
                                StringBuilder stringBuilder = new StringBuilder("Unexpected state value ");
                                stringBuilder.append(state);
                                throw new IllegalArgumentException(stringBuilder.toString());
                        }
                        a(b(event));
                        aVar.a(this.c, event);
                        a();
                    }
                }
            }
            entry = this.b.c;
            if (!(this.f || entry == null || this.a.compareTo(((a) entry.getValue()).a) <= 0)) {
                b();
            }
        }
    }
}
