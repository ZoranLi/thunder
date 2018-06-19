package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {
    static final Map<Class, a> a = new HashMap();
    private final Object b;
    private final a c = a(this.b.getClass());

    static class a {
        final Map<Event, List<b>> a = new HashMap();
        final Map<b, Event> b;

        a(Map<b, Event> map) {
            this.b = map;
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                Event event = (Event) entry.getValue();
                List list = (List) this.a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(event, list);
                }
                list.add(entry.getKey());
            }
        }
    }

    static class b {
        final int a;
        final Method b;

        b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    b bVar = (b) obj;
                    return this.a == bVar.a && this.b.getName().equals(bVar.b.getName()) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * this.a) + this.b.getName().hashCode();
        }
    }

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.b = obj;
    }

    public final void a(b bVar, Event event) {
        a aVar = this.c;
        a((List) aVar.a.get(event), bVar, event);
        a((List) aVar.a.get(Event.ON_ANY), bVar, event);
    }

    private void a(List<b> list, b bVar, Event event) {
        if (list != null) {
            int size = list.size() - 1;
            while (size >= 0) {
                b bVar2 = (b) list.get(size);
                try {
                    switch (bVar2.a) {
                        case 0:
                            bVar2.b.invoke(this.b, new Object[0]);
                            break;
                        case 1:
                            bVar2.b.invoke(this.b, new Object[]{bVar});
                            break;
                        case 2:
                            bVar2.b.invoke(this.b, new Object[]{bVar, event});
                            break;
                        default:
                            break;
                    }
                    size--;
                } catch (List<b> list2) {
                    throw new RuntimeException("Failed to call observer method", list2.getCause());
                } catch (List<b> list22) {
                    throw new RuntimeException(list22);
                }
            }
        }
    }

    private static a a(Class cls) {
        a aVar = (a) a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            aVar = a(superclass);
            if (aVar != null) {
                hashMap.putAll(aVar.b);
            }
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class a : cls.getInterfaces()) {
            for (Entry entry : a(a).b.entrySet()) {
                a(hashMap, (b) entry.getKey(), (Event) entry.getValue(), cls);
            }
        }
        for (Method method : declaredMethods) {
            g gVar = (g) method.getAnnotation(g.class);
            if (gVar != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(b.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Event a2 = gVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a2 != Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new b(i, method), a2, cls);
            }
        }
        aVar = new a(hashMap);
        a.put(cls, aVar);
        return aVar;
    }

    private static void a(Map<b, Event> map, b bVar, Event event, Class cls) {
        Event event2 = (Event) map.get(bVar);
        if (event2 != null && event != event2) {
            map = bVar.b;
            StringBuilder stringBuilder = new StringBuilder("Method ");
            stringBuilder.append(map.getName());
            stringBuilder.append(" in ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
            stringBuilder.append(event2);
            stringBuilder.append(", new value ");
            stringBuilder.append(event);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }
}
