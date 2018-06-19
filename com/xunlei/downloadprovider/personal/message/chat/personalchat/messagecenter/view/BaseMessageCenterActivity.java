package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.content.Context;
import android.os.Bundle;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.xllib.android.XLIntent;

public abstract class BaseMessageCenterActivity extends BaseActivity {
    private boolean a = false;

    public void a(Bundle bundle) {
    }

    public void g() {
    }

    public void h() {
    }

    public void r_() {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = LaunchActivity.a;
        if (this.a) {
            a(bundle);
            return;
        }
        bundle = new XLIntent((Context) this, LaunchActivity.class);
        bundle.setFlags(32768);
        startActivity(bundle);
        finish();
    }

    protected final void onStart() {
        super.onStart();
        if (!this.a) {
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (!this.a) {
        }
    }

    protected final void onResume() {
        super.onResume();
        if (this.a) {
            g();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.a) {
            h();
        }
    }

    protected final void onStop() {
        super.onStop();
        if (!this.a) {
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.a) {
            r_();
        }
    }
}
