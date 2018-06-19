package com.baidu.mobads.utils;

import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;

class c implements IXAdBitmapUtils {
    c() {
    }

    @android.annotation.TargetApi(8)
    public java.lang.String bitmap2tring(android.graphics.Bitmap r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0016 }
        r0.<init>();	 Catch:{ Exception -> 0x0016 }
        r1 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0016 }
        r2 = 100;	 Catch:{ Exception -> 0x0016 }
        r4.compress(r1, r2, r0);	 Catch:{ Exception -> 0x0016 }
        r4 = r0.toByteArray();	 Catch:{ Exception -> 0x0016 }
        r0 = 0;	 Catch:{ Exception -> 0x0016 }
        r4 = android.util.Base64.encodeToString(r4, r0);	 Catch:{ Exception -> 0x0016 }
        return r4;
    L_0x0016:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.c.bitmap2tring(android.graphics.Bitmap):java.lang.String");
    }

    @android.annotation.TargetApi(8)
    public android.graphics.Bitmap string2bitmap(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r3 = android.util.Base64.decode(r3, r0);	 Catch:{ Exception -> 0x000b }
        r1 = r3.length;	 Catch:{ Exception -> 0x000b }
        r3 = android.graphics.BitmapFactory.decodeByteArray(r3, r0, r1);	 Catch:{ Exception -> 0x000b }
        goto L_0x000c;
    L_0x000b:
        r3 = 0;
    L_0x000c:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.c.string2bitmap(java.lang.String):android.graphics.Bitmap");
    }
}
