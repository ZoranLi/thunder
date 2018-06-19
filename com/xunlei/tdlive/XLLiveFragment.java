package com.xunlei.tdlive;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.tdlive.sdk.BasePlugin;

public class XLLiveFragment extends BasePageFragment {
    private static final String TAG = "XLLiveFragmentNew";
    private FrameLayout mContainerView;
    private Handler mHandler;
    private boolean mInit = true;
    private boolean mShow;
    private View mView;

    protected String getTabId() {
        return "livestream";
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = new View(getActivity());
        layoutInflater.setBackgroundColor(getResources().getColor(R.color.status_bar_color));
        this.mContainerView = new FrameLayout(getActivity());
        this.mContainerView.setId(16908290);
        viewGroup = new LinearLayout(getActivity());
        viewGroup.setOrientation(1);
        viewGroup.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(layoutInflater, -1, j.a(getActivity()));
        viewGroup.addView(this.mContainerView, -1, -1);
        return viewGroup;
    }

    public void onViewCreated(android.view.View r3, @android.support.annotation.Nullable android.os.Bundle r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onViewCreated(r3, r4);
        r4 = r2.mView;
        if (r4 != r3) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r2.mView = r3;
        r4 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0039 }
        r0 = 1;	 Catch:{ Throwable -> 0x0039 }
        r4.<init>(r0);	 Catch:{ Throwable -> 0x0039 }
        r1 = "title";	 Catch:{ Throwable -> 0x0039 }
        r4.putBoolean(r1, r0);	 Catch:{ Throwable -> 0x0039 }
        r3 = r3.getContext();	 Catch:{ Throwable -> 0x0039 }
        r3 = com.xunlei.tdlive.LivePlugin.getInstance(r3);	 Catch:{ Throwable -> 0x0039 }
        r0 = new com.xunlei.tdlive.XLLiveFragment$1;	 Catch:{ Throwable -> 0x0039 }
        r0.<init>();	 Catch:{ Throwable -> 0x0039 }
        r3 = r3.newLiveListFragment(r4, r0);	 Catch:{ Throwable -> 0x0039 }
        r4 = r2.getChildFragmentManager();	 Catch:{ Throwable -> 0x0039 }
        r4 = r4.beginTransaction();	 Catch:{ Throwable -> 0x0039 }
        r0 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;	 Catch:{ Throwable -> 0x0039 }
        r3 = r4.replace(r0, r3);	 Catch:{ Throwable -> 0x0039 }
        r3.commit();	 Catch:{ Throwable -> 0x0039 }
        return;
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.XLLiveFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void onPageSelected() {
        super.onPageSelected();
        this.mShow = true;
        LivePlugin.getInstance(getContext()).login();
        boolean z = getExtras().getBoolean("is_red_point_show");
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(BasePlugin.HOST_NOFITY_PAGE_SELECTED, z, isVisible(), "bottom_tab").sendToTarget();
        }
    }

    public void onPageOff() {
        super.onPageOff();
        this.mShow = false;
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(BasePlugin.HOST_NOFITY_PAGE_DESELECTED, Boolean.valueOf(isVisible())).sendToTarget();
        }
    }

    public void onResume() {
        super.onResume();
        onPageSelected();
    }

    public void onPause() {
        super.onPause();
        onPageOff();
    }

    public void onMainTabClick(boolean z) {
        super.onMainTabClick(z);
        if ((this.mShow || !this.mInit) && this.mHandler) {
            this.mInit = true;
            this.mHandler.sendEmptyMessage(BasePlugin.HOST_NOFITY_REFRESH_LIST);
        }
    }
}
