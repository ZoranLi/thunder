package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Callback {
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final Handler handler = new Handler(Looper.getMainLooper(), this);
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();

    public static RequestManagerRetriever get() {
        return INSTANCE;
    }

    RequestManagerRetriever() {
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = new RequestManager(context.getApplicationContext(), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
                }
            }
        }
        return this.applicationManager;
    }

    public RequestManager get(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.isOnMainThread() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return get((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return get((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return get(((ContextWrapper) context).getBaseContext());
            }
        }
        return getApplicationManager(context);
    }

    public RequestManager get(FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    public RequestManager get(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        } else {
            return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
        }
    }

    @TargetApi(11)
    public RequestManager get(Activity activity) {
        if (!Util.isOnBackgroundThread()) {
            if (VERSION.SDK_INT >= 11) {
                assertNotDestroyed(activity);
                return fragmentGet(activity, activity.getFragmentManager());
            }
        }
        return get(activity.getApplicationContext());
    }

    @TargetApi(17)
    private static void assertNotDestroyed(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed() != null) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    public RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (!Util.isOnBackgroundThread()) {
            if (VERSION.SDK_INT >= 17) {
                return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
            }
        }
        return get(fragment.getActivity().getApplicationContext());
    }

    @TargetApi(17)
    RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        requestManagerFragment = (RequestManagerFragment) this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        android.app.Fragment requestManagerFragment2 = new RequestManagerFragment();
        this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment2);
        fragmentManager.beginTransaction().add(requestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment2;
    }

    @TargetApi(11)
    RequestManager fragmentGet(Context context, FragmentManager fragmentManager) {
        fragmentManager = getRequestManagerFragment(fragmentManager);
        RequestManager requestManager = fragmentManager.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        requestManager = new RequestManager(context, fragmentManager.getLifecycle(), fragmentManager.getRequestManagerTreeNode());
        fragmentManager.setRequestManager(requestManager);
        return requestManager;
    }

    SupportRequestManagerFragment getSupportRequestManagerFragment(android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        supportRequestManagerFragment = (SupportRequestManagerFragment) this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        Fragment supportRequestManagerFragment2 = new SupportRequestManagerFragment();
        this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment2);
        fragmentManager.beginTransaction().add(supportRequestManagerFragment2, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment2;
    }

    RequestManager supportFragmentGet(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        fragmentManager = getSupportRequestManagerFragment(fragmentManager);
        RequestManager requestManager = fragmentManager.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        requestManager = new RequestManager(context, fragmentManager.getLifecycle(), fragmentManager.getRequestManagerTreeNode());
        fragmentManager.setRequestManager(requestManager);
        return requestManager;
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                message = this.pendingRequestManagerFragments.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                message = this.pendingSupportRequestManagerFragments.remove(obj);
                break;
            default:
                z = false;
                message = null;
                break;
        }
        if (z && r4 == null && Log.isLoggable(TAG, 5) != null) {
            new StringBuilder("Failed to remove expected request manager fragment, manager: ").append(obj);
        }
        return z;
    }
}
