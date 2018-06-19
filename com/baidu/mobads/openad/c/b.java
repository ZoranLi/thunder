package com.baidu.mobads.openad.c;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import java.util.HashMap;

public class b implements IOAdEvent {
    public static final String COMPLETE = "complete";
    public static final String EVENT_MESSAGE = "message";
    private final String a;
    private final HashMap<String, Object> b;
    private final int c;
    private Object d;

    public b(String str) {
        this(str, 0, new HashMap());
    }

    public b(String str, String str2) {
        this(str, 0, str2);
    }

    public b(String str, HashMap<String, Object> hashMap) {
        this(str, 0, (HashMap) hashMap);
    }

    public b(String str, int i) {
        this(str, i, new HashMap());
    }

    public b(String str, int i, HashMap<String, Object> hashMap) {
        this.a = str;
        this.c = i;
        this.b = hashMap;
    }

    public b(String str, int i, String str2) {
        this(str, i, new HashMap());
        this.b.put("message", str2);
    }

    public String getType() {
        return this.a;
    }

    public int getCode() {
        return this.c;
    }

    public HashMap<String, Object> getData() {
        return this.b;
    }

    public void setTarget(Object obj) {
        this.d = obj;
    }

    public Object getTarget() {
        return this.d;
    }

    public java.lang.String getMessage() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.b;	 Catch:{ Exception -> 0x000b }
        r1 = "message";	 Catch:{ Exception -> 0x000b }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x000b }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x000b }
        return r0;
    L_0x000b:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.b.getMessage():java.lang.String");
    }
}
