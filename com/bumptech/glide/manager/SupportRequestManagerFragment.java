package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final HashSet<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private SupportRequestManagerFragment rootRequestManagerFragment;

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        private SupportFragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            Set hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
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

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        if (this.rootRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (this.rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        Set hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(supportRequestManagerFragment.getParentFragment())) {
                hashSet.add(supportRequestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        super.onAttach(r2);
        r2 = com.bumptech.glide.manager.RequestManagerRetriever.get();	 Catch:{ IllegalStateException -> 0x001f }
        r0 = r1.getActivity();	 Catch:{ IllegalStateException -> 0x001f }
        r0 = r0.getSupportFragmentManager();	 Catch:{ IllegalStateException -> 0x001f }
        r2 = r2.getSupportRequestManagerFragment(r0);	 Catch:{ IllegalStateException -> 0x001f }
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.SupportRequestManagerFragment.onAttach(android.app.Activity):void");
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

    public void onLowMemory() {
        super.onLowMemory();
        if (this.requestManager != null) {
            this.requestManager.onLowMemory();
        }
    }
}
