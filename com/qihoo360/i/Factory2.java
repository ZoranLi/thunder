package com.qihoo360.i;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qihoo360.loader2.aa;
import com.qihoo360.loader2.ac;
import com.qihoo360.loader2.k;
import com.qihoo360.loader2.l;
import com.qihoo360.loader2.n;
import com.qihoo360.loader2.o;
import com.qihoo360.loader2.t;
import com.qihoo360.loader2.u;
import com.qihoo360.loader2.y;
import com.qihoo360.loader2.z;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.activity.ActivityInjector;
import java.util.Set;
import org.json.JSONArray;

public final class Factory2 {
    public static z sPLProxy;

    public static final Context createActivityContext(Activity activity, Context context) {
        o a = sPLProxy.a.a(activity.getClass().getClassLoader());
        if (a == null) {
            if (c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("PACM: createActivityContext: can't found plugin object for activity=");
                stringBuilder.append(activity.getClass().getName());
                c.a("ws001", stringBuilder.toString());
            }
            return null;
        }
        l lVar = a.n;
        return new u(context, lVar.g, lVar.e, lVar.a, lVar);
    }

    public static final void handleActivityCreate(Activity activity, Bundle bundle) {
        String a;
        z zVar = sPLProxy;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("activity create: ");
            stringBuilder.append(activity.getClass().getName());
            stringBuilder.append(" this=");
            stringBuilder.append(activity.hashCode());
            stringBuilder.append(" taskid=");
            stringBuilder.append(activity.getTaskId());
            c.a("ws001", stringBuilder.toString());
        }
        if (activity.getIntent() != null) {
            try {
                Intent intent = new Intent(activity.getIntent());
                y yVar = new y(intent);
                a = yVar.a();
                String b = yVar.b();
                int c = yVar.c();
                String e = yVar.e();
                int a2 = yVar.a("counter:", 0);
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("activity create: name=");
                    stringBuilder2.append(a);
                    stringBuilder2.append(" activity=");
                    stringBuilder2.append(b);
                    stringBuilder2.append(" process=");
                    stringBuilder2.append(c);
                    stringBuilder2.append(" container=");
                    stringBuilder2.append(e);
                    stringBuilder2.append(" counter=");
                    stringBuilder2.append(a2);
                    c.a("ws001", stringBuilder2.toString());
                }
                if (!TextUtils.equals(b, activity.getClass().getName())) {
                    stringBuilder = new StringBuilder("a.c.1: a=");
                    stringBuilder.append(b);
                    stringBuilder.append(" l=");
                    stringBuilder.append(activity.getClass().getName());
                    n.a(activity, intent);
                    return;
                } else if (c.a) {
                    stringBuilder = new StringBuilder("perfect: container=");
                    stringBuilder.append(e);
                    stringBuilder.append(" plugin=");
                    stringBuilder.append(a);
                    stringBuilder.append(" activity=");
                    stringBuilder.append(b);
                    c.b("ws001", stringBuilder.toString());
                }
            } catch (Throwable th) {
                new StringBuilder("a.c.2: exception: ").append(th.getMessage());
            }
        }
        a aVar = null;
        if (activity.getComponentName() != null) {
            aVar = zVar.a.m.b.a(activity.getComponentName().getClassName());
        }
        if (aVar == null) {
            new StringBuilder("a.c1: l=").append(activity.getClass().getName());
            return;
        }
        t tVar = zVar.a.m.b;
        String str = aVar.c;
        a = aVar.a;
        ComponentName componentName = activity.getComponentName();
        if (componentName != null) {
            a = componentName.getClassName();
        }
        if (c.a) {
            StringBuilder stringBuilder3 = new StringBuilder("PACM: activity created h=");
            stringBuilder3.append(activity.hashCode());
            stringBuilder3.append(" class=");
            stringBuilder3.append(activity.getClass().getName());
            stringBuilder3.append(" container=");
            stringBuilder3.append(a);
            c.a("ws001", stringBuilder3.toString());
        }
        synchronized (tVar.a) {
            a aVar2 = (a) tVar.b.get(a);
            if (aVar2 != null) {
                StringBuilder stringBuilder4;
                if (aVar2.b != 1) {
                    if (aVar2.b != 2) {
                        if (aVar2.b == 0) {
                            if (c.a) {
                                c.b("ws001", "PACM: create: relaunch activity: blank");
                            }
                        } else if (c.a) {
                            stringBuilder4 = new StringBuilder("PACM: create: invalid s=");
                            stringBuilder4.append(a.a(aVar2.b));
                            stringBuilder4.append(" e=registered c=");
                            stringBuilder4.append(aVar2.a);
                            c.c("ws001", stringBuilder4.toString());
                        }
                    }
                }
                if (TextUtils.equals(aVar2.c, str)) {
                    if (TextUtils.equals(aVar2.d, activity.getClass().getName())) {
                        if (aVar2.b == 2 && c.a) {
                            stringBuilder3 = new StringBuilder("PACM: create: relaunch activity: history: container=");
                            stringBuilder3.append(aVar2.a);
                            stringBuilder3.append(" plugin=");
                            stringBuilder3.append(str);
                            stringBuilder3.append(" activity=");
                            stringBuilder3.append(activity);
                            c.b("ws001", stringBuilder3.toString());
                        }
                        aVar2.a(activity);
                        aVar2.e = System.currentTimeMillis();
                    } else if (c.a) {
                        stringBuilder4 = new StringBuilder("PACM: create: invalid a=");
                        stringBuilder4.append(activity.getClass().getName());
                        stringBuilder4.append(" this.a=");
                        stringBuilder4.append(aVar2.d);
                        c.c("ws001", stringBuilder4.toString());
                    }
                } else if (c.a) {
                    stringBuilder3 = new StringBuilder("PACM: create: invalid plugin=");
                    stringBuilder3.append(str);
                    stringBuilder3.append(" this.plugin=");
                    stringBuilder3.append(aVar2.c);
                    c.c("ws001", stringBuilder3.toString());
                }
            }
        }
        try {
            ac.c().a(aa.b, aVar.c, aVar.a, activity.getClass().getName());
        } catch (Throwable th2) {
            new StringBuilder("a.c2: ").append(th2.getMessage());
        }
        if (bundle != null) {
            bundle.setClassLoader(activity.getClassLoader());
        }
        bundle = activity.getIntent();
        if (bundle != null) {
            if (c.a) {
                stringBuilder = new StringBuilder("set activity intent cl=");
                stringBuilder.append(activity.getClassLoader());
                c.a("ws001", stringBuilder.toString());
            }
            bundle.setExtrasClassLoader(activity.getClassLoader());
        }
        ActivityInjector.inject(activity, aVar.c, aVar.d);
    }

    public static final void handleActivityDestroy(Activity activity) {
        z zVar = sPLProxy;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("activity destroy: ");
            stringBuilder.append(activity.getClass().getName());
            stringBuilder.append(" this=");
            stringBuilder.append(activity.hashCode());
            stringBuilder.append(" taskid=");
            stringBuilder.append(activity.getTaskId());
            c.a("ws001", stringBuilder.toString());
        }
        t tVar = zVar.a.m.b;
        ComponentName componentName = activity.getComponentName();
        a aVar = null;
        String className = componentName != null ? componentName.getClassName() : null;
        if (c.a) {
            StringBuilder stringBuilder2 = new StringBuilder("PACM: activity destroy h=");
            stringBuilder2.append(activity.hashCode());
            stringBuilder2.append(" class=");
            stringBuilder2.append(activity.getClass().getName());
            stringBuilder2.append(" container=");
            stringBuilder2.append(className);
            c.a("ws001", stringBuilder2.toString());
        }
        if (className != null) {
            synchronized (tVar.a) {
                a aVar2 = (a) tVar.b.get(className);
                if (aVar2 != null) {
                    aVar2.b(activity);
                }
            }
        }
        if (activity.getComponentName() != null) {
            aVar = zVar.a.m.b.a(activity.getComponentName().getClassName());
        }
        if (aVar == null) {
            new StringBuilder("p a h a d c f p a ").append(activity.getClass().getName());
            return;
        }
        try {
            ac.c().b(aa.b, aVar.c, aVar.a, activity.getClass().getName());
        } catch (Activity activity2) {
            new StringBuilder("ur.a: ").append(activity2.getMessage());
        }
        RePlugin.getConfig();
    }

    public static final void handleServiceCreate(Service service) {
        try {
            ac.c().a(aa.b, sPLProxy.a.i.h.getName(), service.getClass().getName());
        } catch (Service service2) {
            new StringBuilder("r.s: ").append(service2.getMessage());
        }
    }

    public static final void handleServiceDestroy(Service service) {
        try {
            ac.c().b(aa.b, sPLProxy.a.i.h.getName(), service.getClass().getName());
        } catch (Service service2) {
            new StringBuilder("ur.s: ").append(service2.getMessage());
        }
    }

    public static final boolean startActivity(Context context, Intent intent) {
        return sPLProxy.a(context, intent);
    }

    public static final boolean startActivity(Activity activity, Intent intent) {
        return sPLProxy.a((Context) activity, intent);
    }

    public static final boolean startActivity(Context context, Intent intent, String str, String str2, int i, boolean z) {
        return sPLProxy.a(context, intent, str, str2, i, z);
    }

    public static final boolean startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        return z.a(activity, intent, i, bundle);
    }

    public static final JSONArray fetchPlugins(String str) {
        return z.a(str);
    }

    public static final boolean registerDynamicClass(String str, String str2, String str3, String str4) {
        return sPLProxy.a.a(str, str2, str3, str4, null);
    }

    public static final boolean registerDynamicClass(String str, String str2, String str3, Class cls) {
        return sPLProxy.a.a(str, str2, "", str3, cls);
    }

    public static final boolean isDynamicClass(String str, String str2) {
        return sPLProxy.a(str, str2);
    }

    public static void unregisterDynamicClass(String str) {
        sPLProxy.a.g.remove(str);
    }

    public static final String getPluginByDynamicClass(String str) {
        a aVar = (a) sPLProxy.a.g.get(str);
        return aVar != null ? aVar.a : "";
    }

    public static final void handleActivityCreateBefore(Activity activity, Bundle bundle) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("activity create before: ");
            stringBuilder.append(activity.getClass().getName());
            stringBuilder.append(" this=");
            stringBuilder.append(activity.hashCode());
            stringBuilder.append(" taskid=");
            stringBuilder.append(activity.getTaskId());
            c.a("ws001", stringBuilder.toString());
        }
        if (bundle != null) {
            bundle.setClassLoader(activity.getClassLoader());
            try {
                bundle.remove("android:support:fragments");
            } catch (Bundle bundle2) {
                new StringBuilder("a.c.b1: ").append(bundle2.getMessage());
            }
        }
        bundle2 = activity.getIntent();
        if (bundle2 != null) {
            bundle2.setExtrasClassLoader(activity.getClassLoader());
            int a = z.a(activity);
            bundle2 = bundle2.getIntExtra("__themeId", 0);
            if (bundle2 == null) {
                bundle2 = activity.getApplicationInfo().theme;
            }
            int a2 = z.a();
            if (k.a(bundle2)) {
                a2 = 16973840;
            }
            if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("defaultThemeId = ");
                stringBuilder2.append(a2);
                c.a("theme", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("dynamicThemeId = ");
                stringBuilder2.append(a);
                c.a("theme", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("manifestThemeId = ");
                stringBuilder2.append(bundle2);
                c.a("theme", stringBuilder2.toString());
            }
            if (a != -1) {
                if (a != a2) {
                    bundle2 = a;
                } else if (bundle2 != null) {
                }
                if (c.a) {
                    stringBuilder = new StringBuilder("themeId = ");
                    stringBuilder.append(bundle2);
                    c.a("theme", stringBuilder.toString());
                }
                activity.setTheme(bundle2);
            } else if (bundle2 != null) {
                if (c.a) {
                    stringBuilder = new StringBuilder("themeId = ");
                    stringBuilder.append(bundle2);
                    c.a("theme", stringBuilder.toString());
                }
                activity.setTheme(bundle2);
            }
            bundle2 = a2;
            if (c.a) {
                stringBuilder = new StringBuilder("themeId = ");
                stringBuilder.append(bundle2);
                c.a("theme", stringBuilder.toString());
            }
            activity.setTheme(bundle2);
        }
    }

    public static final void handleRestoreInstanceState(Activity activity, Bundle bundle) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("activity restore instance state: ");
            stringBuilder.append(activity.getClass().getName());
            c.a("ws001", stringBuilder.toString());
        }
        if (bundle != null) {
            bundle.setClassLoader(activity.getClassLoader());
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                for (String str : keySet) {
                    Object obj = bundle.get(str);
                    if (obj instanceof Bundle) {
                        ((Bundle) obj).setClassLoader(activity.getClassLoader());
                    }
                }
            }
        }
    }
}
