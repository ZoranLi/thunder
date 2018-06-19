package com.qihoo360.replugin.component.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.mobilesafe.api.b;
import com.qihoo360.replugin.b.c;
import java.util.HashMap;

/* compiled from: PluginReceiverHelper */
public final class a {
    public static void a(String str, String str2, HashMap<String, BroadcastReceiver> hashMap, Intent intent) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                Context queryPluginContext = Factory.queryPluginContext(str);
                if (queryPluginContext != null) {
                    String format = String.format("%s-%s", new Object[]{str, str2});
                    if (hashMap != null) {
                        if (hashMap.containsKey(format)) {
                            str = (BroadcastReceiver) hashMap.get(format);
                            if (str != null) {
                                b.a(new b(str2, str, queryPluginContext, intent));
                            }
                            return;
                        }
                    }
                    BroadcastReceiver broadcastReceiver;
                    try {
                        Class a = PluginReceiverProxy.a(queryPluginContext.getClassLoader(), str2);
                        if (a != null) {
                            broadcastReceiver = (BroadcastReceiver) a.newInstance();
                            if (hashMap != null) {
                                try {
                                    hashMap.put(format, broadcastReceiver);
                                } catch (Throwable th) {
                                    str = th;
                                    if (c.a != null) {
                                        c.a("ms-receiver", str.toString());
                                    }
                                    str = broadcastReceiver;
                                    if (str != null) {
                                        b.a(new b(str2, str, queryPluginContext, intent));
                                    }
                                    return;
                                }
                            }
                            if (c.a != null) {
                                c.a("ms-receiver", String.format("反射创建 Receiver 实例 %s", new Object[]{str2}));
                            }
                            str = broadcastReceiver;
                            if (str != null) {
                                b.a(new b(str2, str, queryPluginContext, intent));
                            }
                            return;
                        }
                        str = null;
                        if (str != null) {
                            b.a(new b(str2, str, queryPluginContext, intent));
                        }
                        return;
                    } catch (Throwable th2) {
                        str = th2;
                        broadcastReceiver = null;
                        if (c.a != null) {
                            c.a("ms-receiver", str.toString());
                        }
                        str = broadcastReceiver;
                        if (str != null) {
                            b.a(new b(str2, str, queryPluginContext, intent));
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (c.a != null) {
            c.a("ms-receiver", "plugin or receiver or intent is null, return.");
        }
    }
}
