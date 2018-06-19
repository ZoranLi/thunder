package com.qihoo360.replugin.component.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.loader2.PluginBinderInfo;
import com.qihoo360.loader2.ac;
import com.qihoo360.loader2.m;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.component.utils.PluginClientHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PluginReceiverProxy extends BroadcastReceiver {
    public HashMap<String, HashMap<String, List<String>>> a;
    private final HashMap<String, Integer> b = new HashMap();

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (this.a != null) {
                context = intent.getAction();
                if (!TextUtils.isEmpty(context)) {
                    if (c.a) {
                        c.a("ms-receiver", String.format("代理 Receiver 收到 action: %s ", new Object[]{context}));
                    }
                    HashMap hashMap = (HashMap) this.a.get(context);
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            String str = (String) entry.getKey();
                            if (entry.getValue() != null) {
                                for (String str2 : new ArrayList((Collection) entry.getValue())) {
                                    try {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append(str);
                                        stringBuilder.append("-");
                                        stringBuilder.append(str2);
                                        String stringBuilder2 = stringBuilder.toString();
                                        if (!this.b.containsKey(stringBuilder2)) {
                                            ComponentList queryPluginComponentList = Factory.queryPluginComponentList(str);
                                            if (queryPluginComponentList != null) {
                                                Map receiverMap = queryPluginComponentList.getReceiverMap();
                                                if (receiverMap != null) {
                                                    ActivityInfo activityInfo = (ActivityInfo) receiverMap.get(str2);
                                                    if (activityInfo != null) {
                                                        this.b.put(stringBuilder2, PluginClientHelper.a(activityInfo.processName));
                                                    }
                                                }
                                            }
                                        }
                                        int intValue = this.b.containsKey(stringBuilder2) ? ((Integer) this.b.get(stringBuilder2)).intValue() : -1;
                                        if (intValue == -2) {
                                            ac.c().a(str, str2, intent);
                                        } else {
                                            m.a(str, intValue, new PluginBinderInfo(0)).a(str, str2, intent);
                                        }
                                    } catch (Throwable th) {
                                        if (c.a) {
                                            th.toString();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return classLoader.loadClass(str);
    }
}
