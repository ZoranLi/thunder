package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.util.Base64;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.IOException;

class q implements IWxCallback {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public void onError(int i, String str) {
        this.a.h.post(new s(this));
    }

    public void onProgress(int i) {
    }

    public void onSuccess(Object... objArr) {
        if (objArr != null && objArr.length == 2 && (objArr[0] instanceof String)) {
            String str = (String) objArr[0];
            int intValue = ((Integer) objArr[1]).intValue();
            try {
                byte[] a = this.a.a(new File(str));
                m mVar = new m();
                mVar.a("audioData", new String(Base64.encode(a, 0)).replaceAll("[\r|\n]", ""));
                mVar.a(SocializeProtocolConstants.DURATION, String.valueOf(intValue));
                this.a.h.post(new r(this, mVar));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
