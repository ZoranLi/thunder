package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), (ModelLoader) modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    public com.bumptech.glide.load.data.DataFetcher<T> getResourceFetcher(java.lang.Integer r6, int r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ NotFoundException -> 0x0040 }
        r2 = "android.resource://";	 Catch:{ NotFoundException -> 0x0040 }
        r1.<init>(r2);	 Catch:{ NotFoundException -> 0x0040 }
        r2 = r5.resources;	 Catch:{ NotFoundException -> 0x0040 }
        r3 = r6.intValue();	 Catch:{ NotFoundException -> 0x0040 }
        r2 = r2.getResourcePackageName(r3);	 Catch:{ NotFoundException -> 0x0040 }
        r1.append(r2);	 Catch:{ NotFoundException -> 0x0040 }
        r2 = 47;	 Catch:{ NotFoundException -> 0x0040 }
        r1.append(r2);	 Catch:{ NotFoundException -> 0x0040 }
        r3 = r5.resources;	 Catch:{ NotFoundException -> 0x0040 }
        r4 = r6.intValue();	 Catch:{ NotFoundException -> 0x0040 }
        r3 = r3.getResourceTypeName(r4);	 Catch:{ NotFoundException -> 0x0040 }
        r1.append(r3);	 Catch:{ NotFoundException -> 0x0040 }
        r1.append(r2);	 Catch:{ NotFoundException -> 0x0040 }
        r2 = r5.resources;	 Catch:{ NotFoundException -> 0x0040 }
        r3 = r6.intValue();	 Catch:{ NotFoundException -> 0x0040 }
        r2 = r2.getResourceEntryName(r3);	 Catch:{ NotFoundException -> 0x0040 }
        r1.append(r2);	 Catch:{ NotFoundException -> 0x0040 }
        r1 = r1.toString();	 Catch:{ NotFoundException -> 0x0040 }
        r1 = android.net.Uri.parse(r1);	 Catch:{ NotFoundException -> 0x0040 }
        goto L_0x0054;
    L_0x0040:
        r1 = "ResourceLoader";
        r2 = 5;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0053;
    L_0x0049:
        r1 = new java.lang.StringBuilder;
        r2 = "Received invalid resource id: ";
        r1.<init>(r2);
        r1.append(r6);
    L_0x0053:
        r1 = r0;
    L_0x0054:
        if (r1 == 0) goto L_0x005d;
    L_0x0056:
        r6 = r5.uriLoader;
        r6 = r6.getResourceFetcher(r1, r7, r8);
        return r6;
    L_0x005d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.ResourceLoader.getResourceFetcher(java.lang.Integer, int, int):com.bumptech.glide.load.data.DataFetcher<T>");
    }
}
