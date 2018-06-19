package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.downloadprovider.launch.LaunchActivity;

public class BaseMessageCenterFragment extends BaseFragment {
    private boolean a = false;

    public void a(Bundle bundle) {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = LaunchActivity.a;
        if (this.a != null) {
        }
    }

    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.a) {
            a(bundle);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.a) {
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.a) {
            k();
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.a) {
            l();
        }
    }

    public final void onStop() {
        super.onStop();
        if (!this.a) {
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.a) {
            m();
        }
    }
}
