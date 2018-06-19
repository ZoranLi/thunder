package com.huawei.hms.update.a;

import com.huawei.hms.support.log.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckResponse */
class b {
    private final String a;
    private String b = "";
    private String c = "";

    public b(String str) {
        this.a = str;
    }

    public String a() {
        if ("0".equals(this.b) && this.c != null) {
            if (!this.c.isEmpty()) {
                return b(this.c);
            }
        }
        return null;
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000d }
        r1 = r2.a;	 Catch:{ JSONException -> 0x000d }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x000d }
        r1 = 2;	 Catch:{ JSONException -> 0x000d }
        r0 = r0.toString(r1);	 Catch:{ JSONException -> 0x000d }
        return r0;
    L_0x000d:
        r0 = r2.a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.b.toString():java.lang.String");
    }

    public static b a(String str) {
        b bVar = new b(str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.b = jSONObject.getString("status");
            if ("0".equals(bVar.b)) {
                JSONArray jSONArray = jSONObject.getJSONArray("components");
                if (jSONArray.length() > 0) {
                    bVar.c = jSONArray.getJSONObject(0).getString("url");
                }
            }
            return bVar;
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder("In parseResponse, Failed to parse json for check-update response.");
            stringBuilder.append(e.getMessage());
            a.d("CheckResponse", stringBuilder.toString());
            return new b(str);
        }
    }

    private static String b(String str) {
        int length = str.length();
        int i = -1;
        while (length > 0 && str.charAt(length - 1) == '/') {
            i = length;
            length--;
        }
        if (i != -1) {
            return str.substring(0, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
