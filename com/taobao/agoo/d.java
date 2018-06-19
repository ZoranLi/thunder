package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.a.a.c;
import com.taobao.agoo.a.b;
import org.android.agoo.common.Config;

/* compiled from: Taobao */
final class d extends IAgooAppReceiver {
    final /* synthetic */ Context a;
    final /* synthetic */ IACCSManager b;
    final /* synthetic */ IRegister c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    d(Context context, IACCSManager iACCSManager, IRegister iRegister, String str, String str2) {
        this.a = context;
        this.b = iACCSManager;
        this.c = iRegister;
        this.d = str;
        this.e = str2;
    }

    public final void onBindApp(int i, String str) {
        try {
            ALog.i("TaobaoRegister", "onBindApp", "errorCode", Integer.valueOf(i));
            if (i == 200) {
                if (TaobaoRegister.mRequestListener == 0) {
                    TaobaoRegister.mRequestListener = new b(this.a);
                }
                this.b.registerDataListener(this.a, TaobaoConstants.SERVICE_ID_DEVICECMD, TaobaoRegister.mRequestListener);
                TaobaoRegister.mRequestListener;
                if (b.b.b(this.a.getPackageName()) != 0) {
                    ALog.i("TaobaoRegister", "agoo aready Registered return ", new Object[0]);
                    if (this.c != 0) {
                        this.c.onSuccess(Config.g(this.a));
                    }
                    return;
                }
                i = c.a(this.a, this.d, this.e);
                if (i == 0) {
                    if (this.c != 0) {
                        this.c.onFailure(TaobaoConstants.REGISTER_ERROR, "req data null");
                    }
                    return;
                }
                i = this.b.sendRequest(this.a, new AccsRequest(null, TaobaoConstants.SERVICE_ID_DEVICECMD, i, null));
                if (TextUtils.isEmpty(i)) {
                    if (this.c != 0) {
                        this.c.onFailure(TaobaoConstants.REGISTER_ERROR, "accs channel disabled!");
                        return;
                    }
                } else if (this.c != null) {
                    TaobaoRegister.mRequestListener.a.put(i, this.c);
                }
                return;
            }
            if (this.c != null) {
                this.c.onFailure(String.valueOf(i), "accs bindapp error!");
            }
        } catch (int i2) {
            ALog.e("TaobaoRegister", "register onBindApp", i2, new Object[0]);
        }
    }

    public final String getAppkey() {
        return this.d;
    }
}
