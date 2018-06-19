package com.qihoo360.replugin.model;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo360.replugin.b.b;
import com.qihoo360.replugin.utils.a;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: PluginInfoList */
public final class c implements Iterable<PluginInfo> {
    public final List<PluginInfo> a = new ArrayList();
    private final ConcurrentHashMap<String, PluginInfo> b = new ConcurrentHashMap();
    private JSONArray c = new JSONArray();

    public final void a(PluginInfo pluginInfo) {
        if (((PluginInfo) this.b.get(pluginInfo.getName())) == null) {
            this.c.put(pluginInfo.getJSON());
            b(pluginInfo);
        }
    }

    private void b(PluginInfo pluginInfo) {
        this.b.put(pluginInfo.getName(), pluginInfo);
        this.b.put(pluginInfo.getAlias(), pluginInfo);
        this.a.add(pluginInfo);
    }

    public final void a(String str) {
        for (int i = 0; i < this.c.length(); i++) {
            if (TextUtils.equals(str, this.c.optJSONObject(i).optString(com.alipay.sdk.cons.c.e))) {
                b.a(this.c, i);
            }
        }
        if (this.b.containsKey(str)) {
            this.b.remove(str);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, ((PluginInfo) it.next()).getName())) {
                it.remove();
            }
        }
    }

    public final boolean a(Context context) {
        int i = 0;
        try {
            File file = new File(context.getDir("p_a", 0), "p.l");
            if (file.exists() != null) {
                context = com.qihoo360.replugin.utils.c.a(file, a.a);
                if (TextUtils.isEmpty(context)) {
                    if (com.qihoo360.replugin.b.c.a != null) {
                        com.qihoo360.replugin.b.c.d("PluginInfoList", "load: Read Json error!");
                    }
                    return false;
                }
                this.c = new JSONArray(context);
                while (i < this.c.length()) {
                    context = this.c.optJSONObject(i);
                    if (context != null) {
                        PluginInfo createByJO = PluginInfo.createByJO(context);
                        if (createByJO != null) {
                            b(createByJO);
                        } else if (com.qihoo360.replugin.b.c.a) {
                            StringBuilder stringBuilder = new StringBuilder("load: PluginInfo Invalid. Ignore! jo=");
                            stringBuilder.append(context);
                            com.qihoo360.replugin.b.c.d("PluginInfoList", stringBuilder.toString());
                        }
                    }
                    i++;
                }
                return true;
            } else if (file.createNewFile() == null) {
                if (com.qihoo360.replugin.b.c.a != null) {
                    com.qihoo360.replugin.b.c.d("PluginInfoList", "load: Create error!");
                }
                return false;
            } else {
                if (com.qihoo360.replugin.b.c.a != null) {
                    com.qihoo360.replugin.b.c.b("PluginInfoList", "load: Create a new list file");
                }
                return true;
            }
        } catch (Context context2) {
            if (com.qihoo360.replugin.b.c.a) {
                com.qihoo360.replugin.b.c.b("PluginInfoList", "load: Load error!", context2);
            }
            return false;
        } catch (Context context22) {
            if (com.qihoo360.replugin.b.c.a) {
                com.qihoo360.replugin.b.c.b("PluginInfoList", "load: Parse Json Error!", context22);
            }
            return false;
        }
    }

    public final boolean b(Context context) {
        try {
            File file = new File(context.getDir("p_a", 0), "p.l");
            context = this.c.toString();
            Charset charset = a.a;
            Closeable b;
            try {
                b = com.qihoo360.replugin.utils.c.b(file);
                if (context != null) {
                    try {
                        b.write(context.getBytes(a.a(charset)));
                    } catch (Throwable th) {
                        context = th;
                        com.qihoo360.replugin.utils.b.a(b);
                        throw context;
                    }
                }
                b.close();
                com.qihoo360.replugin.utils.b.a(b);
                return true;
            } catch (Throwable th2) {
                context = th2;
                b = null;
                com.qihoo360.replugin.utils.b.a(b);
                throw context;
            }
        } catch (Context context2) {
            if (com.qihoo360.replugin.b.c.a) {
                context2.printStackTrace();
            }
            return false;
        }
    }

    public final Iterator<PluginInfo> iterator() {
        return this.a.iterator();
    }
}
