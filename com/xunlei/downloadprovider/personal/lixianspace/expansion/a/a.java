package com.xunlei.downloadprovider.personal.lixianspace.expansion.a;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ColumnBeanDataFactory */
public final class a {
    private static Map<String, List<Integer>> a = new HashMap();

    private static String a(int i) {
        return i == 5 ? "supper" : i == 3 ? "platinum" : "normal";
    }

    public static void a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.put("normal", a(jSONObject.getJSONArray("normal")));
                a.put("platinum", a(jSONObject.getJSONArray("platinum")));
                a.put("supper", a(jSONObject.getJSONArray("supper")));
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }

    public static List<com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.a> a(int i, int i2, boolean z) {
        List<com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.a> linkedList = new LinkedList();
        List<Integer> list = (List) a.get(a(i));
        if (list != null && list.size() > 0) {
            int i3 = 0;
            for (Integer intValue : list) {
                boolean z2 = true;
                i3++;
                int intValue2 = intValue.intValue();
                if (i == 3 && z) {
                    intValue2 += 120;
                }
                if (i == 5 && z) {
                    intValue2 += 240;
                }
                if (i2 != i3) {
                    z2 = false;
                }
                String valueOf = String.valueOf(intValue2);
                StringBuffer stringBuffer = new StringBuffer();
                if (z) {
                    stringBuffer.append("年");
                }
                if (i == 5) {
                    stringBuffer.append("SVIP");
                } else {
                    stringBuffer.append("VIP");
                }
                stringBuffer.append(i3);
                linkedList.add(new com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.a((float) intValue2, z2, valueOf, stringBuffer.toString()));
            }
            if (!(i == 5 && z)) {
                linkedList.add(new com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview.a(1139802112, false, "480", "年SVIP7"));
            }
        }
        return linkedList;
    }

    public static int b(int i, int i2, boolean z) {
        List list = (List) a.get(a(i));
        if (list == null || list.size() <= 0) {
            return 0;
        }
        i2 = ((Integer) list.get(i2 - 1)).intValue();
        if (i == 3 && z) {
            i2 += 120;
        }
        if (i == 5 && z) {
            i2 += 240;
        }
        return i2;
    }

    private static List<Integer> a(JSONArray jSONArray) {
        List<Integer> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    linkedList.add(Integer.valueOf(jSONArray.getInt(i)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return linkedList;
    }
}
