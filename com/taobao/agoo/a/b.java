package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.e;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.a.a.a;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class b extends AccsAbstractDataListener {
    public static a b;
    public Map<String, ICallback> a = new HashMap();

    public void onBind(String str, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
    }

    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
    }

    public void onSendData(String str, String str2, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
    }

    public void onUnbind(String str, int i, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
    }

    public b(Context context) {
        if (b == null) {
            b = new a(context.getApplicationContext());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(java.lang.String r6, java.lang.String r7, int r8, byte[] r9, com.taobao.accs.base.TaoBaseService$ExtraInfo r10) {
        /*
        r5 = this;
        r10 = 0;
        r0 = "AgooDeviceCmd";
        r0 = r0.equals(r6);	 Catch:{ Throwable -> 0x0142 }
        if (r0 == 0) goto L_0x0132;
    L_0x0009:
        r0 = r5.a;	 Catch:{ Throwable -> 0x0142 }
        r0 = r0.get(r7);	 Catch:{ Throwable -> 0x0142 }
        r0 = (com.taobao.agoo.ICallback) r0;	 Catch:{ Throwable -> 0x0142 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 != r1) goto L_0x0127;
    L_0x0015:
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x0142 }
        r1 = "utf-8";
        r8.<init>(r9, r1);	 Catch:{ Throwable -> 0x0142 }
        r9 = "RequestListener";
        r1 = "RequestListener onResponse";
        r2 = 6;
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0142 }
        r3 = "dataId";
        r2[r10] = r3;	 Catch:{ Throwable -> 0x0142 }
        r3 = 1;
        r2[r3] = r7;	 Catch:{ Throwable -> 0x0142 }
        r3 = 2;
        r4 = "listener";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0142 }
        r3 = 3;
        r2[r3] = r0;	 Catch:{ Throwable -> 0x0142 }
        r3 = 4;
        r4 = "json";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0142 }
        r3 = 5;
        r2[r3] = r8;	 Catch:{ Throwable -> 0x0142 }
        com.taobao.accs.utl.ALog.i(r9, r1, r2);	 Catch:{ Throwable -> 0x0142 }
        r9 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0142 }
        r9.<init>(r8);	 Catch:{ Throwable -> 0x0142 }
        r8 = "resultCode";
        r1 = 0;
        r8 = com.taobao.accs.utl.e.a(r9, r8, r1);	 Catch:{ Throwable -> 0x0142 }
        r2 = "cmd";
        r2 = com.taobao.accs.utl.e.a(r9, r2, r1);	 Catch:{ Throwable -> 0x0142 }
        r3 = "success";
        r3 = r3.equals(r8);	 Catch:{ Throwable -> 0x0142 }
        if (r3 != 0) goto L_0x0070;
    L_0x0057:
        if (r0 == 0) goto L_0x0062;
    L_0x0059:
        r8 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0142 }
        r9 = "agoo server error";
        r0.onFailure(r8, r9);	 Catch:{ Throwable -> 0x0142 }
    L_0x0062:
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x006f;
    L_0x006a:
        r6 = r5.a;
        r6.remove(r7);
    L_0x006f:
        return;
    L_0x0070:
        r8 = "register";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r8 == 0) goto L_0x00c4;
    L_0x0078:
        r8 = "deviceId";
        r8 = com.taobao.accs.utl.e.a(r9, r8, r1);	 Catch:{ Throwable -> 0x0142 }
        r9 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x0142 }
        if (r9 == 0) goto L_0x008e;
    L_0x0084:
        if (r0 == 0) goto L_0x00b6;
    L_0x0086:
        r8 = "";
        r9 = "agoo server error deviceid null";
        r0.onFailure(r8, r9);	 Catch:{ Throwable -> 0x0142 }
        goto L_0x00b6;
    L_0x008e:
        r9 = com.taobao.accs.client.GlobalClientInfo.getContext();	 Catch:{ Throwable -> 0x0142 }
        org.android.agoo.common.Config.a(r9, r8);	 Catch:{ Throwable -> 0x0142 }
        r9 = b;	 Catch:{ Throwable -> 0x0142 }
        r1 = com.taobao.accs.client.GlobalClientInfo.getContext();	 Catch:{ Throwable -> 0x0142 }
        r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x0142 }
        r9.a(r1);	 Catch:{ Throwable -> 0x0142 }
        if (r0 == 0) goto L_0x00b6;
    L_0x00a4:
        r9 = r0 instanceof com.taobao.agoo.IRegister;	 Catch:{ Throwable -> 0x0142 }
        if (r9 == 0) goto L_0x00b6;
    L_0x00a8:
        r9 = "Agoo_AppStore";
        r1 = com.taobao.accs.client.GlobalClientInfo.getContext();	 Catch:{ Throwable -> 0x0142 }
        com.taobao.accs.utl.UtilityImpl.saveUtdid(r9, r1);	 Catch:{ Throwable -> 0x0142 }
        r0 = (com.taobao.agoo.IRegister) r0;	 Catch:{ Throwable -> 0x0142 }
        r0.onSuccess(r8);	 Catch:{ Throwable -> 0x0142 }
    L_0x00b6:
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x00c3;
    L_0x00be:
        r6 = r5.a;
        r6.remove(r7);
    L_0x00c3:
        return;
    L_0x00c4:
        r8 = "setAlias";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r8 == 0) goto L_0x00dd;
    L_0x00cc:
        r5.a(r9, r0);	 Catch:{ Throwable -> 0x0142 }
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x00dc;
    L_0x00d7:
        r6 = r5.a;
        r6.remove(r7);
    L_0x00dc:
        return;
    L_0x00dd:
        r8 = "removeAlias";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r8 == 0) goto L_0x0104;
    L_0x00e5:
        r8 = com.taobao.accs.client.GlobalClientInfo.getContext();	 Catch:{ Throwable -> 0x0142 }
        org.android.agoo.common.Config.b(r8, r1);	 Catch:{ Throwable -> 0x0142 }
        if (r0 == 0) goto L_0x00f1;
    L_0x00ee:
        r0.onSuccess();	 Catch:{ Throwable -> 0x0142 }
    L_0x00f1:
        r8 = b;	 Catch:{ Throwable -> 0x0142 }
        r8.a();	 Catch:{ Throwable -> 0x0142 }
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x0103;
    L_0x00fe:
        r6 = r5.a;
        r6.remove(r7);
    L_0x0103:
        return;
    L_0x0104:
        r8 = "enablePush";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r8 != 0) goto L_0x0114;
    L_0x010c:
        r8 = "disablePush";
        r8 = r8.equals(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r8 == 0) goto L_0x0132;
    L_0x0114:
        if (r0 == 0) goto L_0x0119;
    L_0x0116:
        r0.onSuccess();	 Catch:{ Throwable -> 0x0142 }
    L_0x0119:
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x0126;
    L_0x0121:
        r6 = r5.a;
        r6.remove(r7);
    L_0x0126:
        return;
    L_0x0127:
        if (r0 == 0) goto L_0x0132;
    L_0x0129:
        r8 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0142 }
        r9 = "accs channel error";
        r0.onFailure(r8, r9);	 Catch:{ Throwable -> 0x0142 }
    L_0x0132:
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x0155;
    L_0x013a:
        r6 = r5.a;
        r6.remove(r7);
        return;
    L_0x0140:
        r8 = move-exception;
        goto L_0x0156;
    L_0x0142:
        r8 = move-exception;
        r9 = "RequestListener";
        r0 = "onResponse";
        r10 = new java.lang.Object[r10];	 Catch:{ all -> 0x0140 }
        com.taobao.accs.utl.ALog.e(r9, r0, r8, r10);	 Catch:{ all -> 0x0140 }
        r8 = "AgooDeviceCmd";
        r6 = r8.equals(r6);
        if (r6 == 0) goto L_0x0155;
    L_0x0154:
        goto L_0x013a;
    L_0x0155:
        return;
    L_0x0156:
        r9 = "AgooDeviceCmd";
        r6 = r9.equals(r6);
        if (r6 == 0) goto L_0x0163;
    L_0x015e:
        r6 = r5.a;
        r6.remove(r7);
    L_0x0163:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.a.b.onResponse(java.lang.String, java.lang.String, int, byte[], com.taobao.accs.base.TaoBaseService$ExtraInfo):void");
    }

    private void a(JSONObject jSONObject, ICallback iCallback) throws JSONException {
        String a = e.a(jSONObject, a.JSON_PUSH_USER_TOKEN, null);
        if (!TextUtils.isEmpty(a)) {
            Config.b(GlobalClientInfo.getContext(), a);
            if (iCallback != null) {
                iCallback.onSuccess();
                b.c(iCallback.extra);
            }
        } else if (iCallback != null) {
            iCallback.onFailure("", "agoo server error-pushtoken null");
        }
    }
}
