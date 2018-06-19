package com.xunlei.downloadprovider.frame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.XLIntent;

public class BaseFragment extends Fragment {
    public static final String TAG = "BaseFragment";
    private Bundle extras = null;
    protected FragmentActivity mActivity;
    protected TextView mDefaultText;
    protected ViewGroup mPageRoot;

    public String getFragmentTAG() {
        return TAG;
    }

    public boolean isIntercept() {
        return true;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onCreateTask(boolean z, int i) {
    }

    public boolean onMenuPressed() {
        return false;
    }

    public void onAttach(Activity activity) {
        new StringBuilder("onAttach. to ").append(activity.getClass().getSimpleName());
        this.mActivity = (FragmentActivity) activity;
        getArguments();
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPageRoot != null) {
            return this.mPageRoot;
        }
        layoutInflater = layoutInflater.inflate(R.layout.default_fragment_view, viewGroup, false);
        this.mDefaultText = (TextView) layoutInflater.findViewById(R.id.default_text);
        return layoutInflater;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected View findViewById(int i) {
        return this.mPageRoot != null ? this.mPageRoot.findViewById(i) : 0;
    }

    protected void startActivityWithAnimation(Class<?> cls, boolean z) {
        startActivity(new XLIntent(this.mActivity, cls));
    }

    protected void startActivityWithAnimation(Class<?> cls, boolean z, Intent intent) {
        intent.setClassName(this.mActivity, cls.getName());
        startActivity(intent);
    }

    protected void startActivityWithAnimation(Class<?> cls) {
        startActivityWithAnimation((Class) cls, true);
    }

    protected void startActivityWithAnimation(Intent intent) {
        if (intent != null) {
            startActivityWithAnimation(intent, true);
        }
    }

    protected void startActivityWithAnimation(Intent intent, boolean z) {
        startActivity(intent);
    }

    protected void startActivityWithExtraAnimation(Class<?> cls, int i, int i2) {
        startActivity(new XLIntent(this.mActivity, cls));
        this.mActivity.overridePendingTransition(i, i2);
    }

    public String getResouceString(int i) {
        return BrothersApplication.getApplicationInstance().getString(i);
    }

    public String getResouceString(int i, Object... objArr) {
        return BrothersApplication.getApplicationInstance().getString(i, objArr);
    }

    public Drawable getResouceDrawable(int i) {
        return BrothersApplication.getApplicationInstance().getResources().getDrawable(i);
    }

    protected Context getApplicationContext() {
        return BrothersApplication.getApplicationInstance().getApplicationContext();
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public final boolean isAlive() {
        if (isAdded() && getActivity() != null) {
            return true;
        }
        return false;
    }
}
