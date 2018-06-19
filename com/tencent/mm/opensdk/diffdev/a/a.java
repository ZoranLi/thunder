package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

public final class a implements IDiffDevOAuth {
    private List<OAuthListener> Z = new ArrayList();
    private d aa;
    private OAuthListener ab = new b(this);
    private Handler handler = null;

    public final void addListener(OAuthListener oAuthListener) {
        if (!this.Z.contains(oAuthListener)) {
            this.Z.add(oAuthListener);
        }
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        if (!(str == null || str.length() <= 0 || str2 == null)) {
            if (str2.length() > 0) {
                if (this.handler == null) {
                    this.handler = new Handler(Looper.getMainLooper());
                }
                addListener(oAuthListener);
                if (this.aa != null) {
                    return true;
                }
                this.aa = new d(str, str2, str3, str4, str5, this.ab);
                d dVar = this.aa;
                if (VERSION.SDK_INT >= 11) {
                    dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return true;
                }
                dVar.execute(new Void[0]);
                return true;
            }
        }
        String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2});
        return false;
    }

    public final void detach() {
        this.Z.clear();
        stopAuth();
    }

    public final void removeAllListeners() {
        this.Z.clear();
    }

    public final void removeListener(OAuthListener oAuthListener) {
        this.Z.remove(oAuthListener);
    }

    public final boolean stopAuth() {
        boolean q;
        try {
            q = this.aa == null ? true : this.aa.q();
        } catch (Exception e) {
            new StringBuilder("stopAuth fail, ex = ").append(e.getMessage());
            q = false;
        }
        this.aa = null;
        return q;
    }
}
