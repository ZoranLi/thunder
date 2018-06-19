package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build.VERSION;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@TargetApi(11)
public class RequestManagerFragment extends Fragment {
    private static final String TAG = "RMFragment";
    private final HashSet<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        private FragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            Set hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet();
        this.lifecycle = activityFragmentLifecycle;
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    ActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
    }

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    @TargetApi(17)
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (this.rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment != null) {
            if (VERSION.SDK_INT >= 17) {
                Set hashSet = new HashSet();
                for (RequestManagerFragment requestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                    if (isDescendant(requestManagerFragment.getParentFragment())) {
                        hashSet.add(requestManagerFragment);
                    }
                }
                return Collections.unmodifiableSet(hashSet);
            }
        }
        return Collections.emptySet();
    }

    @TargetApi(17)
    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return null;
    }

    public void onAttach(android.app.Activity r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        super.onAttach(r2);
        r2 = com.bumptech.glide.manager.RequestManagerRetriever.get();	 Catch:{ IllegalStateException -> 0x001f }
        r0 = r1.getActivity();	 Catch:{ IllegalStateException -> 0x001f }
        r0 = r0.getFragmentManager();	 Catch:{ IllegalStateException -> 0x001f }
        r2 = r2.getRequestManagerFragment(r0);	 Catch:{ IllegalStateException -> 0x001f }
        r1.rootRequestManagerFragment = r2;	 Catch:{ IllegalStateException -> 0x001f }
        r2 = r1.rootRequestManagerFragment;	 Catch:{ IllegalStateException -> 0x001f }
        if (r2 == r1) goto L_0x001e;	 Catch:{ IllegalStateException -> 0x001f }
    L_0x0019:
        r2 = r1.rootRequestManagerFragment;	 Catch:{ IllegalStateException -> 0x001f }
        r2.addChildRequestManagerFragment(r1);	 Catch:{ IllegalStateException -> 0x001f }
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerFragment.onAttach(android.app.Activity):void");
    }

    public void onDetach() {
        super.onDetach();
        if (this.rootRequestManagerFragment != null) {
            this.rootRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }

    public void onTrimMemory(int i) {
        if (this.requestManager != null) {
            this.requestManager.onTrimMemory(i);
        }
    }

    public void onLowMemory() {
        if (this.requestManager != null) {
            this.requestManager.onLowMemory();
        }
    }
}
