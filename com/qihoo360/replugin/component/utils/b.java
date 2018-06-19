package com.qihoo360.replugin.component.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.qihoo360.mobilesafe.parser.manifest.ManifestParser;
import com.qihoo360.replugin.b.c;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: IntentMatcherHelper */
public final class b {
    public static String a(Context context, Intent intent, Map<String, List<IntentFilter>> map) {
        if (map == null) {
            return null;
        }
        String action = intent.getAction();
        context = intent.resolveTypeIfNeeded(context.getContentResolver());
        Uri data = intent.getData();
        String scheme = intent.getScheme();
        intent = intent.getCategories();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            List<IntentFilter> list = (List) entry.getValue();
            if (list != null) {
                for (IntentFilter match : list) {
                    int match2 = match.match(action, context, scheme, data, intent, "ComponentList");
                    if (match2 >= 0) {
                        if (c.a != null) {
                            String str2 = ManifestParser.TAG;
                            intent = new StringBuilder("IntentFilter 匹配成功: ");
                            intent.append((String) entry.getKey());
                            c.a(str2, intent.toString());
                        }
                        return str;
                    } else if (c.a) {
                        String str3;
                        switch (match2) {
                            case -4:
                                str3 = "category";
                                break;
                            case -3:
                                str3 = "action";
                                break;
                            case -2:
                                str3 = "data";
                                break;
                            case -1:
                                str3 = "type";
                                break;
                            default:
                                str3 = "unknown reason";
                                break;
                        }
                        String str4 = ManifestParser.TAG;
                        StringBuilder stringBuilder = new StringBuilder("  Filter did not match: ");
                        stringBuilder.append(str3);
                        c.a(str4, stringBuilder.toString());
                    }
                }
                continue;
            }
        }
        return "";
    }
}
