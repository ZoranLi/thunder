package com.xiaomi.metoknlp.devicediscover;

import android.os.AsyncTask;

class k extends AsyncTask {
    final /* synthetic */ n a;
    private boolean b;

    private k(n nVar) {
        this.a = nVar;
        this.b = true;
    }

    private java.lang.String b(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r3 = com.xiaomi.metoknlp.a.b.a(r3, r0);
        if (r3 == 0) goto L_0x0013;
    L_0x0007:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0013 }
        r1.<init>(r3);	 Catch:{ JSONException -> 0x0013 }
        r3 = "real-ip";	 Catch:{ JSONException -> 0x0013 }
        r3 = r1.getString(r3);	 Catch:{ JSONException -> 0x0013 }
        return r3;
    L_0x0013:
        r3 = r0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.k.b(java.lang.String):java.lang.String");
    }

    protected java.lang.String a(java.lang.String... r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.b;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = 0;
        r2 = r2[r0];	 Catch:{ Exception -> 0x000c }
        r2 = r1.b(r2);	 Catch:{ Exception -> 0x000c }
        return r2;
    L_0x000c:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.k.a(java.lang.String[]):java.lang.String");
    }

    protected void a(String str) {
        if (this.b) {
            this.a.j.sendMessage(this.a.j.obtainMessage(3, str));
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected void onCancelled() {
        this.b = false;
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((String) obj);
    }
}
