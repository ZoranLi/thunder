package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManager */
final class FragmentManagerImpl extends FragmentManager implements Factory2 {
    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    SparseArray<Fragment> mActive;
    final ArrayList<Fragment> mAdded = new ArrayList();
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState = 0;
    boolean mDestroyed;
    Runnable mExecCommit = new Runnable() {
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private final CopyOnWriteArrayList<Pair<FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks = new CopyOnWriteArrayList();
    boolean mNeedMenuInvalidate;
    int mNextFragmentIndex = 0;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<OpGenerator> mPendingActions;
    ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    Fragment mPrimaryNav;
    FragmentManagerNonConfig mSavedNonConfig;
    SparseArray<Parcelable> mStateArray = null;
    Bundle mStateBundle = null;
    boolean mStateSaved;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<BackStackRecord> mTmpRecords;

    /* compiled from: FragmentManager */
    private static class AnimationListenerWrapper implements AnimationListener {
        private final AnimationListener mWrapped;

        private AnimationListenerWrapper(AnimationListener animationListener) {
            this.mWrapped = animationListener;
        }

        @CallSuper
        public void onAnimationStart(Animation animation) {
            if (this.mWrapped != null) {
                this.mWrapped.onAnimationStart(animation);
            }
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.mWrapped != null) {
                this.mWrapped.onAnimationEnd(animation);
            }
        }

        @CallSuper
        public void onAnimationRepeat(Animation animation) {
            if (this.mWrapped != null) {
                this.mWrapped.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    private static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        private AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManager */
    private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
        View mView;

        AnimatorOnHWLayerIfNeededListener(View view) {
            this.mView = view;
        }

        public void onAnimationStart(Animator animator) {
            this.mView.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.mView.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* compiled from: FragmentManager */
    static class FragmentTag {
        public static final int[] Fragment = new int[]{16842755, 16842960, 16842961};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    /* compiled from: FragmentManager */
    interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    private static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {
        View mView;

        AnimateOnHWLayerIfNeededListener(View view, AnimationListener animationListener) {
            super(animationListener);
            this.mView = view;
        }

        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (!ViewCompat.isAttachedToWindow(this.mView)) {
                if (VERSION.SDK_INT < 24) {
                    this.mView.setLayerType(0, null);
                    super.onAnimationEnd(animation);
                }
            }
            this.mView.post(new Runnable() {
                public void run() {
                    AnimateOnHWLayerIfNeededListener.this.mView.setLayerType(0, null);
                }
            });
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager */
    private class PopBackStackState implements OpGenerator {
        final int mFlags;
        final int mId;
        final String mName;

        PopBackStackState(String str, int i, int i2) {
            this.mName = str;
            this.mId = i;
            this.mFlags = i2;
        }

        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManagerImpl.this.mPrimaryNav != null && this.mId < 0 && this.mName == null) {
                FragmentManager peekChildFragmentManager = FragmentManagerImpl.this.mPrimaryNav.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                    return null;
                }
            }
            return FragmentManagerImpl.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
    }

    /* compiled from: FragmentManager */
    static class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        private final boolean mIsBack;
        private int mNumPostponed;
        private final BackStackRecord mRecord;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.mIsBack = z;
            this.mRecord = backStackRecord;
        }

        public void onStartEnterTransition() {
            this.mNumPostponed--;
            if (this.mNumPostponed == 0) {
                this.mRecord.mManager.scheduleCommit();
            }
        }

        public void startListening() {
            this.mNumPostponed++;
        }

        public boolean isReady() {
            return this.mNumPostponed == 0;
        }

        public void completeTransaction() {
            int i = 0;
            int i2 = this.mNumPostponed > 0 ? 1 : 0;
            FragmentManagerImpl fragmentManagerImpl = this.mRecord.mManager;
            int size = fragmentManagerImpl.mAdded.size();
            while (i < size) {
                Fragment fragment = (Fragment) fragmentManagerImpl.mAdded.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (i2 != 0 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
                i++;
            }
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, i2 ^ true, true);
        }

        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }
    }

    public static int reverseTransit(int i) {
        return i != 4097 ? i != FragmentTransaction.TRANSIT_FRAGMENT_FADE ? i != 8194 ? 0 : 4097 : FragmentTransaction.TRANSIT_FRAGMENT_FADE : 8194;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        return i != 4097 ? i != FragmentTransaction.TRANSIT_FRAGMENT_FADE ? i != 8194 ? -1 : z ? 3 : 4 : z ? 5 : 6 : z ? 1 : 2;
    }

    public final boolean execPendingActions() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = 1;
        r4.ensureExecReady(r0);
        r1 = 0;
    L_0x0005:
        r2 = r4.mTmpRecords;
        r3 = r4.mTmpIsPop;
        r2 = r4.generateOpsForPendingActions(r2, r3);
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r4.mExecutingActions = r0;
        r1 = r4.mTmpRecords;	 Catch:{ all -> 0x001d }
        r2 = r4.mTmpIsPop;	 Catch:{ all -> 0x001d }
        r4.removeRedundantOperationsAndExecute(r1, r2);	 Catch:{ all -> 0x001d }
        r4.cleanupExec();
        r1 = r0;
        goto L_0x0005;
    L_0x001d:
        r0 = move-exception;
        r4.cleanupExec();
        throw r0;
    L_0x0022:
        r4.doPendingDeferredStart();
        r4.burpActive();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.execPendingActions():boolean");
    }

    final Factory2 getLayoutInflaterFactory() {
        return this;
    }

    FragmentManagerImpl() {
    }

    static boolean modifiesAlpha(AnimationOrAnimator animationOrAnimator) {
        if (animationOrAnimator.animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animationOrAnimator.animation instanceof AnimationSet)) {
            return modifiesAlpha(animationOrAnimator.animator);
        }
        animationOrAnimator = ((AnimationSet) animationOrAnimator.animation).getAnimations();
        for (int i = 0; i < animationOrAnimator.size(); i++) {
            if (animationOrAnimator.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean modifiesAlpha(Animator animator) {
        if (animator == null) {
            return false;
        }
        int i;
        if (animator instanceof ValueAnimator) {
            animator = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : animator) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            animator = ((AnimatorSet) animator).getChildAnimations();
            for (i = 0; i < animator.size(); i++) {
                if (modifiesAlpha((Animator) animator.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean shouldRunOnHWLayer(View view, AnimationOrAnimator animationOrAnimator) {
        if (view != null) {
            if (animationOrAnimator != null) {
                if (VERSION.SDK_INT < 19 || view.getLayerType() != 0 || ViewCompat.hasOverlappingRendering(view) == null || modifiesAlpha(animationOrAnimator) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void throwException(java.lang.RuntimeException r6) {
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
        r5 = this;
        r6.getMessage();
        r0 = new android.support.v4.util.LogWriter;
        r1 = "FragmentManager";
        r0.<init>(r1);
        r1 = new java.io.PrintWriter;
        r1.<init>(r0);
        r0 = r5.mHost;
        r2 = 0;
        r3 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x0015:
        r0 = r5.mHost;	 Catch:{ Exception -> 0x0026 }
        r4 = "  ";	 Catch:{ Exception -> 0x0026 }
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0026 }
        r0.onDump(r4, r3, r1, r2);	 Catch:{ Exception -> 0x0026 }
        goto L_0x0026;	 Catch:{ Exception -> 0x0026 }
    L_0x001f:
        r0 = "  ";	 Catch:{ Exception -> 0x0026 }
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0026 }
        r5.dump(r0, r3, r1, r2);	 Catch:{ Exception -> 0x0026 }
    L_0x0026:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.throwException(java.lang.RuntimeException):void");
    }

    public final FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    public final boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        forcePostponedTransactions();
        return execPendingActions;
    }

    public final void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    public final boolean popBackStackImmediate() {
        checkStateLoss();
        return popBackStackImmediate(null, -1, 0);
    }

    public final void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), null);
    }

    public final boolean popBackStackImmediate(String str, int i) {
        checkStateLoss();
        return popBackStackImmediate(str, -1, i);
    }

    public final void popBackStack(int i, int i2) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("Bad id: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        enqueueAction(new PopBackStackState(null, i, i2), 0);
    }

    public final boolean popBackStackImmediate(int i, int i2) {
        checkStateLoss();
        execPendingActions();
        if (i >= 0) {
            return popBackStackImmediate(null, i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder("Bad id: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private boolean popBackStackImmediate(String str, int i, int i2) {
        execPendingActions();
        ensureExecReady(true);
        if (this.mPrimaryNav != null && i < 0 && str == null) {
            FragmentManager peekChildFragmentManager = this.mPrimaryNav.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.popBackStackImmediate()) {
                return true;
            }
        }
        str = popBackStackState(this.mTmpRecords, this.mTmpIsPop, str, i, i2);
        if (str != null) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        doPendingDeferredStart();
        burpActive();
        return str;
    }

    public final int getBackStackEntryCount() {
        return this.mBackStack != null ? this.mBackStack.size() : 0;
    }

    public final BackStackEntry getBackStackEntryAt(int i) {
        return (BackStackEntry) this.mBackStack.get(i);
    }

    public final void addOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList();
        }
        this.mBackStackChangeListeners.add(onBackStackChangedListener);
    }

    public final void removeOnBackStackChangedListener(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(onBackStackChangedListener);
        }
    }

    public final void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment getFragment(Bundle bundle, String str) {
        bundle = bundle.getInt(str, -1);
        if (bundle == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.mActive.get(bundle);
        if (fragment == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment no longer exists for key ");
            stringBuilder.append(str);
            stringBuilder.append(": index ");
            stringBuilder.append(bundle);
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        return fragment;
    }

    public final List<Fragment> getFragments() {
        if (this.mAdded.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Fragment> list;
        synchronized (this.mAdded) {
            list = (List) this.mAdded.clone();
        }
        return list;
    }

    final List<Fragment> getActiveFragments() {
        if (this.mActive == null) {
            return null;
        }
        int size = this.mActive.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.mActive.valueAt(i));
        }
        return arrayList;
    }

    final int getActiveFragmentCount() {
        if (this.mActive == null) {
            return 0;
        }
        return this.mActive.size();
    }

    public final SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            throwException(new IllegalStateException(stringBuilder.toString()));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        fragment = saveFragmentBasicState(fragment);
        if (fragment != null) {
            return new SavedState(fragment);
        }
        return null;
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, stringBuilder);
        } else {
            DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        int i2 = 0;
        if (this.mActive != null) {
            size = this.mActive.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(Constants.COLON_SEPARATOR);
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mActive.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.mAdded.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                fragment = (Fragment) this.mAdded.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.mCreatedMenus != null) {
            size = this.mCreatedMenus.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.mCreatedMenus.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.mBackStack != null) {
            size = this.mBackStack.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null) {
                fileDescriptor = this.mBackStackIndices.size();
                if (fileDescriptor > null) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (strArr = null; strArr < fileDescriptor; strArr++) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStackIndices.get(strArr);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(strArr);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > null) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
        }
        if (this.mPendingActions != null) {
            fileDescriptor = this.mPendingActions.size();
            if (fileDescriptor > null) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < fileDescriptor) {
                    OpGenerator opGenerator = (OpGenerator) this.mPendingActions.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate != null) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
    }

    static AnimationOrAnimator makeOpenCloseAnimation(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        scaleAnimation.setInterpolator(DECELERATE_QUINT);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        Animation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    static AnimationOrAnimator makeFadeAnimation(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(DECELERATE_CUBIC);
        alphaAnimation.setDuration(3.08E-43f);
        return new AnimationOrAnimator(alphaAnimation);
    }

    final android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator loadAnimation(android.support.v4.app.Fragment r6, int r7, boolean r8, int r9) {
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
        r5 = this;
        r0 = r6.getNextAnim();
        r1 = r6.onCreateAnimation(r7, r8, r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0011;
    L_0x000b:
        r6 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r6.<init>(r1);
        return r6;
    L_0x0011:
        r6 = r6.onCreateAnimator(r7, r8, r0);
        if (r6 == 0) goto L_0x001d;
    L_0x0017:
        r7 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r7.<init>(r6);
        return r7;
    L_0x001d:
        if (r0 == 0) goto L_0x0076;
    L_0x001f:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = r6.getResources();
        r6 = r6.getResourceTypeName(r0);
        r1 = "anim";
        r6 = r1.equals(r6);
        r1 = 0;
        if (r6 == 0) goto L_0x004c;
    L_0x0036:
        r3 = r5.mHost;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r3 = r3.getContext();	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r3 = android.view.animation.AnimationUtils.loadAnimation(r3, r0);	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        if (r3 == 0) goto L_0x0048;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
    L_0x0042:
        r4 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        r4.<init>(r3);	 Catch:{ NotFoundException -> 0x004a, RuntimeException -> 0x004c }
        return r4;
    L_0x0048:
        r1 = 1;
        goto L_0x004c;
    L_0x004a:
        r6 = move-exception;
        throw r6;
    L_0x004c:
        if (r1 != 0) goto L_0x0076;
    L_0x004e:
        r1 = r5.mHost;	 Catch:{ RuntimeException -> 0x0060 }
        r1 = r1.getContext();	 Catch:{ RuntimeException -> 0x0060 }
        r1 = android.animation.AnimatorInflater.loadAnimator(r1, r0);	 Catch:{ RuntimeException -> 0x0060 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ RuntimeException -> 0x0060 }
    L_0x005a:
        r3 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ RuntimeException -> 0x0060 }
        r3.<init>(r1);	 Catch:{ RuntimeException -> 0x0060 }
        return r3;
    L_0x0060:
        r1 = move-exception;
        if (r6 == 0) goto L_0x0064;
    L_0x0063:
        throw r1;
    L_0x0064:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = android.view.animation.AnimationUtils.loadAnimation(r6, r0);
        if (r6 == 0) goto L_0x0076;
    L_0x0070:
        r7 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r7.<init>(r6);
        return r7;
    L_0x0076:
        if (r7 != 0) goto L_0x0079;
    L_0x0078:
        return r2;
    L_0x0079:
        r6 = transitToStyleIndex(r7, r8);
        if (r6 >= 0) goto L_0x0080;
    L_0x007f:
        return r2;
    L_0x0080:
        r7 = 1064933786; // 0x3f79999a float:0.975 double:5.26147199E-315;
        r8 = 0;
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r6) {
            case 1: goto L_0x00d4;
            case 2: goto L_0x00c9;
            case 3: goto L_0x00be;
            case 4: goto L_0x00b0;
            case 5: goto L_0x00a5;
            case 6: goto L_0x009a;
            default: goto L_0x0089;
        };
    L_0x0089:
        if (r9 != 0) goto L_0x00e1;
    L_0x008b:
        r6 = r5.mHost;
        r6 = r6.onHasWindowAnimations();
        if (r6 == 0) goto L_0x00e1;
    L_0x0093:
        r6 = r5.mHost;
        r9 = r6.onGetWindowAnimations();
        goto L_0x00e1;
    L_0x009a:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = makeFadeAnimation(r6, r0, r8);
        return r6;
    L_0x00a5:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = makeFadeAnimation(r6, r8, r0);
        return r6;
    L_0x00b0:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r7 = 1065982362; // 0x3f89999a float:1.075 double:5.26665264E-315;
        r6 = makeOpenCloseAnimation(r6, r0, r7, r0, r8);
        return r6;
    L_0x00be:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = makeOpenCloseAnimation(r6, r7, r0, r8, r0);
        return r6;
    L_0x00c9:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r6 = makeOpenCloseAnimation(r6, r0, r7, r0, r8);
        return r6;
    L_0x00d4:
        r6 = r5.mHost;
        r6 = r6.getContext();
        r7 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r6 = makeOpenCloseAnimation(r6, r7, r0, r8, r0);
        return r6;
    L_0x00e1:
        if (r9 != 0) goto L_0x00e4;
    L_0x00e3:
        return r2;
    L_0x00e4:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.loadAnimation(android.support.v4.app.Fragment, int, boolean, int):android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator");
    }

    public final void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.mExecutingActions) {
                this.mHavePendingDeferredStart = true;
                return;
            }
            fragment.mDeferStart = false;
            moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }

    private static void setHWLayerAnimListenerIfAlpha(View view, AnimationOrAnimator animationOrAnimator) {
        if (view != null) {
            if (animationOrAnimator != null) {
                if (shouldRunOnHWLayer(view, animationOrAnimator)) {
                    if (animationOrAnimator.animator != null) {
                        animationOrAnimator.animator.addListener(new AnimatorOnHWLayerIfNeededListener(view));
                        return;
                    }
                    AnimationListener animationListener = getAnimationListener(animationOrAnimator.animation);
                    view.setLayerType(2, null);
                    animationOrAnimator.animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, animationListener));
                }
            }
        }
    }

    private static android.view.animation.Animation.AnimationListener getAnimationListener(android.view.animation.Animation r2) {
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
        r0 = sAnimationListenerField;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        if (r0 != 0) goto L_0x0012;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
    L_0x0004:
        r0 = android.view.animation.Animation.class;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r1 = "mListener";	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        sAnimationListenerField = r0;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
    L_0x0012:
        r0 = sAnimationListenerField;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r2 = r0.get(r2);	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        r2 = (android.view.animation.Animation.AnimationListener) r2;	 Catch:{ NoSuchFieldException -> 0x001b, NoSuchFieldException -> 0x001b }
        goto L_0x001c;
    L_0x001b:
        r2 = 0;
    L_0x001c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.getAnimationListener(android.view.animation.Animation):android.view.animation.Animation$AnimationListener");
    }

    final boolean isStateAtLeast(int i) {
        return this.mCurState >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void moveToState(android.support.v4.app.Fragment r16, int r17, int r18, int r19, boolean r20) {
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
        r15 = this;
        r6 = r15;
        r7 = r16;
        r0 = r7.mAdded;
        r8 = 1;
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r7.mDetached;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0010;
    L_0x000d:
        r0 = r17;
        goto L_0x0015;
    L_0x0010:
        r0 = r17;
        if (r0 <= r8) goto L_0x0015;
    L_0x0014:
        r0 = r8;
    L_0x0015:
        r1 = r7.mRemoving;
        if (r1 == 0) goto L_0x002b;
    L_0x0019:
        r1 = r7.mState;
        if (r0 <= r1) goto L_0x002b;
    L_0x001d:
        r0 = r7.mState;
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = r16.isInBackStack();
        if (r0 == 0) goto L_0x0029;
    L_0x0027:
        r0 = r8;
        goto L_0x002b;
    L_0x0029:
        r0 = r7.mState;
    L_0x002b:
        r1 = r7.mDeferStart;
        r9 = 4;
        r10 = 3;
        if (r1 == 0) goto L_0x0039;
    L_0x0031:
        r1 = r7.mState;
        if (r1 >= r9) goto L_0x0039;
    L_0x0035:
        if (r0 <= r10) goto L_0x0039;
    L_0x0037:
        r11 = r10;
        goto L_0x003a;
    L_0x0039:
        r11 = r0;
    L_0x003a:
        r0 = r7.mState;
        r12 = 2;
        r13 = 0;
        r14 = 0;
        if (r0 > r11) goto L_0x02ac;
    L_0x0041:
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x004a;
    L_0x0045:
        r0 = r7.mInLayout;
        if (r0 != 0) goto L_0x004a;
    L_0x0049:
        return;
    L_0x004a:
        r0 = r16.getAnimatingAway();
        if (r0 != 0) goto L_0x0056;
    L_0x0050:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x0068;
    L_0x0056:
        r7.setAnimatingAway(r13);
        r7.setAnimator(r13);
        r2 = r16.getStateAfterAnimating();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r1 = r7;
        r0.moveToState(r1, r2, r3, r4, r5);
    L_0x0068:
        r0 = r7.mState;
        switch(r0) {
            case 0: goto L_0x006f;
            case 1: goto L_0x018b;
            case 2: goto L_0x0276;
            case 3: goto L_0x027a;
            case 4: goto L_0x0290;
            default: goto L_0x006d;
        };
    L_0x006d:
        goto L_0x03d5;
    L_0x006f:
        if (r11 <= 0) goto L_0x018b;
    L_0x0071:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x007f;
    L_0x0075:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto CREATED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x007f:
        r0 = r7.mSavedFragmentState;
        if (r0 == 0) goto L_0x00c7;
    L_0x0083:
        r0 = r7.mSavedFragmentState;
        r1 = r6.mHost;
        r1 = r1.getContext();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r7.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r7.mSavedViewState = r0;
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r6.getFragment(r0, r1);
        r7.mTarget = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x00b4;
    L_0x00aa:
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r14);
        r7.mTargetRequestCode = r0;
    L_0x00b4:
        r0 = r7.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r8);
        r7.mUserVisibleHint = r0;
        r0 = r7.mUserVisibleHint;
        if (r0 != 0) goto L_0x00c7;
    L_0x00c2:
        r7.mDeferStart = r8;
        if (r11 <= r10) goto L_0x00c7;
    L_0x00c6:
        r11 = r10;
    L_0x00c7:
        r0 = r6.mHost;
        r7.mHost = r0;
        r0 = r6.mParent;
        r7.mParentFragment = r0;
        r0 = r6.mParent;
        if (r0 == 0) goto L_0x00d8;
    L_0x00d3:
        r0 = r6.mParent;
        r0 = r0.mChildFragmentManager;
        goto L_0x00de;
    L_0x00d8:
        r0 = r6.mHost;
        r0 = r0.getFragmentManagerImpl();
    L_0x00de:
        r7.mFragmentManager = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x0125;
    L_0x00e4:
        r0 = r6.mActive;
        r1 = r7.mTarget;
        r1 = r1.mIndex;
        r0 = r0.get(r1);
        r1 = r7.mTarget;
        if (r0 == r1) goto L_0x0115;
    L_0x00f2:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " declared target fragment ";
        r1.append(r2);
        r2 = r7.mTarget;
        r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0115:
        r0 = r7.mTarget;
        r0 = r0.mState;
        if (r0 > 0) goto L_0x0125;
    L_0x011b:
        r1 = r7.mTarget;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r0.moveToState(r1, r2, r3, r4, r5);
    L_0x0125:
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentPreAttached(r7, r0, r14);
        r7.mCalled = r14;
        r0 = r6.mHost;
        r0 = r0.getContext();
        r7.onAttach(r0);
        r0 = r7.mCalled;
        if (r0 != 0) goto L_0x0156;
    L_0x013d:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0156:
        r0 = r7.mParentFragment;
        if (r0 != 0) goto L_0x0160;
    L_0x015a:
        r0 = r6.mHost;
        r0.onAttachFragment(r7);
        goto L_0x0165;
    L_0x0160:
        r0 = r7.mParentFragment;
        r0.onAttachFragment(r7);
    L_0x0165:
        r0 = r6.mHost;
        r0 = r0.getContext();
        r6.dispatchOnFragmentAttached(r7, r0, r14);
        r0 = r7.mIsCreated;
        if (r0 != 0) goto L_0x0182;
    L_0x0172:
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentPreCreated(r7, r0, r14);
        r0 = r7.mSavedFragmentState;
        r7.performCreate(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentCreated(r7, r0, r14);
        goto L_0x0189;
    L_0x0182:
        r0 = r7.mSavedFragmentState;
        r7.restoreChildFragmentState(r0);
        r7.mState = r8;
    L_0x0189:
        r7.mRetaining = r14;
    L_0x018b:
        r15.ensureInflatedFragmentView(r16);
        if (r11 <= r8) goto L_0x0276;
    L_0x0190:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x019e;
    L_0x0194:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x019e:
        r0 = r7.mFromLayout;
        if (r0 != 0) goto L_0x0261;
    L_0x01a2:
        r0 = r7.mContainerId;
        if (r0 == 0) goto L_0x0210;
    L_0x01a6:
        r0 = r7.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x01c6;
    L_0x01ab:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Cannot create fragment ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " for a container view with no id";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r6.throwException(r0);
    L_0x01c6:
        r0 = r6.mContainer;
        r1 = r7.mContainerId;
        r0 = r0.onFindViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r7.mRestored;
        if (r1 != 0) goto L_0x0211;
    L_0x01d6:
        r1 = r16.getResources();	 Catch:{ NotFoundException -> 0x01e1 }
        r2 = r7.mContainerId;	 Catch:{ NotFoundException -> 0x01e1 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x01e1 }
        goto L_0x01e3;
    L_0x01e1:
        r1 = "unknown";
    L_0x01e3:
        r2 = new java.lang.IllegalArgumentException;
        r3 = new java.lang.StringBuilder;
        r4 = "No view found for id 0x";
        r3.<init>(r4);
        r4 = r7.mContainerId;
        r4 = java.lang.Integer.toHexString(r4);
        r3.append(r4);
        r4 = " (";
        r3.append(r4);
        r3.append(r1);
        r1 = ") for fragment ";
        r3.append(r1);
        r3.append(r7);
        r1 = r3.toString();
        r2.<init>(r1);
        r6.throwException(r2);
        goto L_0x0211;
    L_0x0210:
        r0 = r13;
    L_0x0211:
        r7.mContainer = r0;
        r1 = r7.mSavedFragmentState;
        r1 = r7.performGetLayoutInflater(r1);
        r2 = r7.mSavedFragmentState;
        r1 = r7.performCreateView(r1, r0, r2);
        r7.mView = r1;
        r1 = r7.mView;
        if (r1 == 0) goto L_0x025f;
    L_0x0225:
        r1 = r7.mView;
        r7.mInnerView = r1;
        r1 = r7.mView;
        r1.setSaveFromParentEnabled(r14);
        if (r0 == 0) goto L_0x0235;
    L_0x0230:
        r1 = r7.mView;
        r0.addView(r1);
    L_0x0235:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x0240;
    L_0x0239:
        r0 = r7.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0240:
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r1);
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentViewCreated(r7, r0, r1, r14);
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x025b;
    L_0x0256:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x025b;
    L_0x025a:
        goto L_0x025c;
    L_0x025b:
        r8 = r14;
    L_0x025c:
        r7.mIsNewlyAdded = r8;
        goto L_0x0261;
    L_0x025f:
        r7.mInnerView = r13;
    L_0x0261:
        r0 = r7.mSavedFragmentState;
        r7.performActivityCreated(r0);
        r0 = r7.mSavedFragmentState;
        r6.dispatchOnFragmentActivityCreated(r7, r0, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0274;
    L_0x026f:
        r0 = r7.mSavedFragmentState;
        r7.restoreViewState(r0);
    L_0x0274:
        r7.mSavedFragmentState = r13;
    L_0x0276:
        if (r11 <= r12) goto L_0x027a;
    L_0x0278:
        r7.mState = r10;
    L_0x027a:
        if (r11 <= r10) goto L_0x0290;
    L_0x027c:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x028a;
    L_0x0280:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto STARTED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x028a:
        r16.performStart();
        r6.dispatchOnFragmentStarted(r7, r14);
    L_0x0290:
        if (r11 <= r9) goto L_0x03d5;
    L_0x0292:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02a0;
    L_0x0296:
        r0 = new java.lang.StringBuilder;
        r1 = "moveto RESUMED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x02a0:
        r16.performResume();
        r6.dispatchOnFragmentResumed(r7, r14);
        r7.mSavedFragmentState = r13;
        r7.mSavedViewState = r13;
        goto L_0x03d5;
    L_0x02ac:
        r0 = r7.mState;
        if (r0 <= r11) goto L_0x03d5;
    L_0x02b0:
        r0 = r7.mState;
        switch(r0) {
            case 1: goto L_0x036b;
            case 2: goto L_0x02f7;
            case 3: goto L_0x02e4;
            case 4: goto L_0x02ce;
            case 5: goto L_0x02b7;
            default: goto L_0x02b5;
        };
    L_0x02b5:
        goto L_0x03d5;
    L_0x02b7:
        r0 = 5;
        if (r11 >= r0) goto L_0x02ce;
    L_0x02ba:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02c8;
    L_0x02be:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom RESUMED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x02c8:
        r16.performPause();
        r6.dispatchOnFragmentPaused(r7, r14);
    L_0x02ce:
        if (r11 >= r9) goto L_0x02e4;
    L_0x02d0:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02de;
    L_0x02d4:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STARTED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x02de:
        r16.performStop();
        r6.dispatchOnFragmentStopped(r7, r14);
    L_0x02e4:
        if (r11 >= r10) goto L_0x02f7;
    L_0x02e6:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x02f4;
    L_0x02ea:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom STOPPED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x02f4:
        r16.performReallyStop();
    L_0x02f7:
        if (r11 >= r12) goto L_0x036b;
    L_0x02f9:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0307;
    L_0x02fd:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom ACTIVITY_CREATED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x0307:
        r0 = r7.mView;
        if (r0 == 0) goto L_0x031a;
    L_0x030b:
        r0 = r6.mHost;
        r0 = r0.onShouldSaveFragmentState(r7);
        if (r0 == 0) goto L_0x031a;
    L_0x0313:
        r0 = r7.mSavedViewState;
        if (r0 != 0) goto L_0x031a;
    L_0x0317:
        r15.saveFragmentViewState(r16);
    L_0x031a:
        r16.performDestroyView();
        r6.dispatchOnFragmentViewDestroyed(r7, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0363;
    L_0x0324:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x0363;
    L_0x0328:
        r0 = r7.mView;
        r0.clearAnimation();
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.endViewTransition(r1);
        r0 = r6.mCurState;
        r1 = 0;
        if (r0 <= 0) goto L_0x0354;
    L_0x0339:
        r0 = r6.mDestroyed;
        if (r0 != 0) goto L_0x0354;
    L_0x033d:
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0354;
    L_0x0345:
        r0 = r7.mPostponedAlpha;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0354;
    L_0x034b:
        r0 = r18;
        r2 = r19;
        r0 = r6.loadAnimation(r7, r0, r14, r2);
        goto L_0x0355;
    L_0x0354:
        r0 = r13;
    L_0x0355:
        r7.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x035c;
    L_0x0359:
        r6.animateRemoveFragment(r7, r0, r11);
    L_0x035c:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.removeView(r1);
    L_0x0363:
        r7.mContainer = r13;
        r7.mView = r13;
        r7.mInnerView = r13;
        r7.mInLayout = r14;
    L_0x036b:
        if (r11 > 0) goto L_0x03d5;
    L_0x036d:
        r0 = r6.mDestroyed;
        if (r0 == 0) goto L_0x0392;
    L_0x0371:
        r0 = r16.getAnimatingAway();
        if (r0 == 0) goto L_0x0382;
    L_0x0377:
        r0 = r16.getAnimatingAway();
        r7.setAnimatingAway(r13);
        r0.clearAnimation();
        goto L_0x0392;
    L_0x0382:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x0392;
    L_0x0388:
        r0 = r16.getAnimator();
        r7.setAnimator(r13);
        r0.cancel();
    L_0x0392:
        r0 = r16.getAnimatingAway();
        if (r0 != 0) goto L_0x03d1;
    L_0x0398:
        r0 = r16.getAnimator();
        if (r0 == 0) goto L_0x039f;
    L_0x039e:
        goto L_0x03d1;
    L_0x039f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x03ad;
    L_0x03a3:
        r0 = new java.lang.StringBuilder;
        r1 = "movefrom CREATED: ";
        r0.<init>(r1);
        r0.append(r7);
    L_0x03ad:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x03b8;
    L_0x03b1:
        r16.performDestroy();
        r6.dispatchOnFragmentDestroyed(r7, r14);
        goto L_0x03ba;
    L_0x03b8:
        r7.mState = r14;
    L_0x03ba:
        r16.performDetach();
        r6.dispatchOnFragmentDetached(r7, r14);
        if (r20 != 0) goto L_0x03d5;
    L_0x03c2:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x03ca;
    L_0x03c6:
        r15.makeInactive(r16);
        goto L_0x03d5;
    L_0x03ca:
        r7.mHost = r13;
        r7.mParentFragment = r13;
        r7.mFragmentManager = r13;
        goto L_0x03d5;
    L_0x03d1:
        r7.setStateAfterAnimating(r11);
        goto L_0x03d6;
    L_0x03d5:
        r8 = r11;
    L_0x03d6:
        r0 = r7.mState;
        if (r0 == r8) goto L_0x03f8;
    L_0x03da:
        r0 = new java.lang.StringBuilder;
        r1 = "moveToState: Fragment state for ";
        r0.<init>(r1);
        r0.append(r7);
        r1 = " not updated inline; expected state ";
        r0.append(r1);
        r0.append(r8);
        r1 = " found ";
        r0.append(r1);
        r1 = r7.mState;
        r0.append(r1);
        r7.mState = r8;
    L_0x03f8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.moveToState(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void animateRemoveFragment(@NonNull final Fragment fragment, @NonNull AnimationOrAnimator animationOrAnimator, int i) {
        final View view = fragment.mView;
        fragment.setStateAfterAnimating(i);
        if (animationOrAnimator.animation != 0) {
            i = animationOrAnimator.animation;
            fragment.setAnimatingAway(fragment.mView);
            i.setAnimationListener(new AnimationListenerWrapper(getAnimationListener(i)) {
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (fragment.getAnimatingAway() != null) {
                        fragment.setAnimatingAway(null);
                        FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                    }
                }
            });
            setHWLayerAnimListenerIfAlpha(view, animationOrAnimator);
            fragment.mView.startAnimation(i);
            return;
        }
        i = animationOrAnimator.animator;
        fragment.setAnimator(animationOrAnimator.animator);
        final ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        i.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (fragment.getAnimator() != null) {
                    fragment.setAnimator(null);
                    FragmentManagerImpl.this.moveToState(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        i.setTarget(fragment.mView);
        setHWLayerAnimListenerIfAlpha(fragment.mView, animationOrAnimator);
        i.start();
    }

    final void moveToState(Fragment fragment) {
        moveToState(fragment, this.mCurState, 0, 0, false);
    }

    final void ensureInflatedFragmentView(Fragment fragment) {
        if (fragment.mFromLayout && !fragment.mPerformedCreateView) {
            fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            if (fragment.mView != null) {
                fragment.mInnerView = fragment.mView;
                fragment.mView.setSaveFromParentEnabled(false);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
                dispatchOnFragmentViewCreated(fragment, fragment.mView, fragment.mSavedFragmentState, false);
                return;
            }
            fragment.mInnerView = null;
        }
    }

    final void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            AnimationOrAnimator loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), fragment.mHidden ^ true, fragment.getNextTransitionStyle());
            if (loadAnimation == null || loadAnimation.animator == null) {
                if (loadAnimation != null) {
                    setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                    fragment.mView.startAnimation(loadAnimation.animation);
                    loadAnimation.animation.start();
                }
                int i = (!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8;
                fragment.mView.setVisibility(i);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                loadAnimation.animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    loadAnimation.animator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (fragment.mView != null) {
                                fragment.mView.setVisibility(8);
                            }
                        }
                    });
                }
                setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.animator.start();
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    final void moveFragmentToExpectedState(Fragment fragment) {
        if (fragment != null) {
            int i = this.mCurState;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            moveToState(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                Fragment findFragmentUnder = findFragmentUnder(fragment);
                if (findFragmentUnder != null) {
                    View view = findFragmentUnder.mView;
                    ViewGroup viewGroup = fragment.mContainer;
                    i = viewGroup.indexOfChild(view);
                    int indexOfChild = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(fragment.mView, i);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    AnimationOrAnimator loadAnimation = loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        if (loadAnimation.animation != null) {
                            fragment.mView.startAnimation(loadAnimation.animation);
                        } else {
                            loadAnimation.animator.setTarget(fragment.mView);
                            loadAnimation.animator.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                completeShowHideFragment(fragment);
            }
        }
    }

    final void moveToState(int i, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != 0) {
                Fragment fragment;
                i = this.mAdded.size();
                int i2 = 0;
                int i3 = i2;
                while (i2 < i) {
                    fragment = (Fragment) this.mAdded.get(i2);
                    moveFragmentToExpectedState(fragment);
                    if (fragment.mLoaderManager != null) {
                        i3 |= fragment.mLoaderManager.hasRunningLoaders();
                    }
                    i2++;
                }
                i = this.mActive.size();
                for (i2 = 0; i2 < i; i2++) {
                    fragment = (Fragment) this.mActive.valueAt(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        moveFragmentToExpectedState(fragment);
                        if (fragment.mLoaderManager != null) {
                            i3 |= fragment.mLoaderManager.hasRunningLoaders();
                        }
                    }
                }
                if (i3 == 0) {
                    startPendingDeferredFragments();
                }
                if (!(this.mNeedMenuInvalidate == 0 || this.mHost == 0 || this.mCurState != 5)) {
                    this.mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }

    final void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    performPendingDeferredStart(fragment);
                }
            }
        }
    }

    final void makeActive(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.mNextFragmentIndex;
            this.mNextFragmentIndex = i + 1;
            fragment.setIndex(i, this.mParent);
            if (this.mActive == null) {
                this.mActive = new SparseArray();
            }
            this.mActive.put(fragment.mIndex, fragment);
            if (DEBUG) {
                new StringBuilder("Allocated fragment index ").append(fragment);
            }
        }
    }

    final void makeInactive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (DEBUG) {
                new StringBuilder("Freeing fragment index ").append(fragment);
            }
            this.mActive.put(fragment.mIndex, null);
            this.mHost.inactivateFragment(fragment.mWho);
            fragment.initState();
        }
    }

    public final void addFragment(Fragment fragment, boolean z) {
        if (DEBUG) {
            new StringBuilder("add: ").append(fragment);
        }
        makeActive(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                StringBuilder stringBuilder = new StringBuilder("Fragment already added: ");
                stringBuilder.append(fragment);
                throw new IllegalStateException(stringBuilder.toString());
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (z) {
                moveToState(fragment);
            }
        }
    }

    public final void removeFragment(Fragment fragment) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
        }
        int isInBackStack = fragment.isInBackStack() ^ 1;
        if (!fragment.mDetached || isInBackStack != 0) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public final void hideFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("hide: ").append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    public final void showFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("show: ").append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= 1;
        }
    }

    public final void detachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("detach: ").append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (DEBUG) {
                    new StringBuilder("remove from detach: ").append(fragment);
                }
                synchronized (this.mAdded) {
                    this.mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (DEBUG) {
            new StringBuilder("attach: ").append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.mAdded.contains(fragment)) {
                    StringBuilder stringBuilder = new StringBuilder("Fragment already added: ");
                    stringBuilder.append(fragment);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (DEBUG) {
                    new StringBuilder("add from attach: ").append(fragment);
                }
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible != null) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public final Fragment findFragmentById(int i) {
        int size;
        for (size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        if (this.mActive != null) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return 0;
    }

    public final Fragment findFragmentByTag(String str) {
        int size;
        Fragment fragment;
        if (str != null) {
            for (size = this.mAdded.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.mActive == null || str == null)) {
            for (size = this.mActive.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        if (!(this.mActive == null || str == null)) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.mActive.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mNoTransactionsBecause != null) {
            StringBuilder stringBuilder = new StringBuilder("Can not perform this action inside of ");
            stringBuilder.append(this.mNoTransactionsBecause);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final boolean isStateSaved() {
        return this.mStateSaved;
    }

    public final void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            checkStateLoss();
        }
        synchronized (this) {
            if (!this.mDestroyed) {
                if (this.mHost != null) {
                    if (!this.mPendingActions) {
                        this.mPendingActions = new ArrayList();
                    }
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                    return;
                }
            }
            if (z) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    private void scheduleCommit() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) ? null : 1;
            if (this.mPendingActions != null && this.mPendingActions.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && r1 == null)) {
                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                this.mHost.getHandler().post(this.mExecCommit);
            }
        }
    }

    public final int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            int intValue;
            if (this.mAvailBackStackIndices != null) {
                if (this.mAvailBackStackIndices.size() > 0) {
                    intValue = ((Integer) this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1)).intValue();
                    if (DEBUG) {
                        StringBuilder stringBuilder = new StringBuilder("Adding back stack index ");
                        stringBuilder.append(intValue);
                        stringBuilder.append(" with ");
                        stringBuilder.append(backStackRecord);
                    }
                    this.mBackStackIndices.set(intValue, backStackRecord);
                    return intValue;
                }
            }
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            intValue = this.mBackStackIndices.size();
            if (DEBUG) {
                stringBuilder = new StringBuilder("Setting back stack index ");
                stringBuilder.append(intValue);
                stringBuilder.append(" to ");
                stringBuilder.append(backStackRecord);
            }
            this.mBackStackIndices.add(backStackRecord);
            return intValue;
        }
    }

    public final void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList();
            }
            int size = this.mBackStackIndices.size();
            StringBuilder stringBuilder;
            if (i < size) {
                if (DEBUG) {
                    stringBuilder = new StringBuilder("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList();
                    }
                    this.mAvailBackStackIndices.add(Integer.valueOf(size));
                    size++;
                }
                if (DEBUG) {
                    stringBuilder = new StringBuilder("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }

    public final void freeBackStackIndex(int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList();
            }
            this.mAvailBackStackIndices.add(Integer.valueOf(i));
        }
    }

    private void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                checkStateLoss();
            }
            if (!this.mTmpRecords) {
                this.mTmpRecords = new ArrayList();
                this.mTmpIsPop = new ArrayList();
            }
            this.mExecutingActions = true;
            try {
                executePostponedTransaction(null, null);
            } finally {
                this.mExecutingActions = false;
            }
        }
    }

    public final void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            if (opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop) != null) {
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            }
            doPendingDeferredStart();
            burpActive();
        }
    }

    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    private void executePostponedTransaction(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int size = this.mPostponedTransactions == null ? 0 : this.mPostponedTransactions.size();
        int i = 0;
        while (i < size) {
            int indexOf;
            StartEnterTransitionListener startEnterTransitionListener = (StartEnterTransitionListener) this.mPostponedTransactions.get(i);
            if (!(arrayList == null || startEnterTransitionListener.mIsBack)) {
                indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    startEnterTransitionListener.cancelTransaction();
                    i++;
                }
            }
            if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.mRecord.interactsWith(arrayList, 0, arrayList.size()))) {
                this.mPostponedTransactions.remove(i);
                i--;
                size--;
                if (!(arrayList == null || startEnterTransitionListener.mIsBack)) {
                    indexOf = arrayList.indexOf(startEnterTransitionListener.mRecord);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        startEnterTransitionListener.cancelTransaction();
                    }
                }
                startEnterTransitionListener.completeTransaction();
            }
            i++;
        }
    }

    private void removeRedundantOperationsAndExecute(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                if (arrayList2 != null) {
                    if (arrayList.size() == arrayList2.size()) {
                        executePostponedTransaction(arrayList, arrayList2);
                        int size = arrayList.size();
                        int i = 0;
                        int i2 = 0;
                        while (i < size) {
                            if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                                if (i2 != i) {
                                    executeOpsTogether(arrayList, arrayList2, i2, i);
                                }
                                i2 = i + 1;
                                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                                        i2++;
                                    }
                                }
                                executeOpsTogether(arrayList, arrayList2, i, i2);
                                i = i2 - 1;
                            }
                            i++;
                        }
                        if (i2 != size) {
                            executeOpsTogether(arrayList, arrayList2, i2, size);
                        }
                        return;
                    }
                }
                throw new IllegalStateException("Internal error with the back stack records");
            }
        }
    }

    private void executeOpsTogether(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = ((BackStackRecord) arrayList3.get(i5)).mReorderingAllowed;
        if (this.mTmpAddedFragments == null) {
            r6.mTmpAddedFragments = new ArrayList();
        } else {
            r6.mTmpAddedFragments.clear();
        }
        r6.mTmpAddedFragments.addAll(r6.mAdded);
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (i3 = i5; i3 < i6; i3++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i3);
            if (((Boolean) arrayList4.get(i3)).booleanValue()) {
                primaryNavigationFragment = backStackRecord.trackAddedFragmentsInPop(r6.mTmpAddedFragments, primaryNavigationFragment);
            } else {
                primaryNavigationFragment = backStackRecord.expandOps(r6.mTmpAddedFragments, primaryNavigationFragment);
            }
            if (!z2) {
                if (!backStackRecord.mAddToBackStack) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        r6.mTmpAddedFragments.clear();
        if (!z) {
            FragmentTransition.startTransitions(r6, arrayList3, arrayList4, i5, i6, false);
        }
        executeOps(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet arraySet = new ArraySet();
            addAddedFragments(arraySet);
            i3 = postponePostponableTransactions(arrayList3, arrayList4, i5, i6, arraySet);
            makeRemovedFragmentsInvisible(arraySet);
            i4 = i3;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z) {
            FragmentTransition.startTransitions(r6, arrayList3, arrayList4, i5, i4, true);
            moveToState(r6.mCurState, true);
        }
        while (i5 < i6) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue() && backStackRecord2.mIndex >= 0) {
                freeBackStackIndex(backStackRecord2.mIndex);
                backStackRecord2.mIndex = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i5++;
        }
        if (z2) {
            reportBackStackChanged();
        }
    }

    private void makeRemovedFragmentsInvisible(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) arraySet.valueAt(i);
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    private int postponePostponableTransactions(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i4);
            boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            boolean z = backStackRecord.isPostponed() && !backStackRecord.interactsWith(arrayList, i4 + 1, i2);
            if (z) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList();
                }
                OnStartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                backStackRecord.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.executeOps();
                } else {
                    backStackRecord.executePopOps(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                addAddedFragments(arraySet);
            }
        }
        return i3;
    }

    private void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.startTransitions(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            moveToState(this.mCurState, true);
        }
        if (this.mActive) {
            z = this.mActive.size();
            for (boolean z4 = false; z4 < z; z4++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(z4);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.interactsWith(fragment.mContainerId)) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private Fragment findFragmentUnder(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null) {
            if (view != null) {
                for (fragment = this.mAdded.indexOf(fragment) - 1; fragment >= null; fragment--) {
                    Fragment fragment2 = (Fragment) this.mAdded.get(fragment);
                    if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                        return fragment2;
                    }
                }
                return null;
            }
        }
        return null;
    }

    private static void executeOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                backStackRecord.bumpBackStackNesting(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.executePopOps(z);
            } else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            i++;
        }
    }

    private void addAddedFragments(ArraySet<Fragment> arraySet) {
        if (this.mCurState > 0) {
            int min = Math.min(this.mCurState, 4);
            int size = this.mAdded.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.mAdded.get(i);
                if (fragment.mState < min) {
                    moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                ((StartEnterTransitionListener) this.mPostponedTransactions.remove(0)).completeTransaction();
            }
        }
    }

    private void endAnimatingAwayFragments() {
        int i = 0;
        int size = this.mActive == null ? 0 : this.mActive.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.mActive.valueAt(i);
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    fragment.setAnimatingAway(null);
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    moveToState(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
            i++;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean generateOpsForPendingActions(java.util.ArrayList<android.support.v4.app.BackStackRecord> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r1 = 0;
        if (r0 == 0) goto L_0x003a;
    L_0x0006:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x003a;
    L_0x000f:
        r0 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r0 = r0.size();	 Catch:{ all -> 0x003c }
        r2 = r1;
    L_0x0016:
        if (r1 >= r0) goto L_0x0028;
    L_0x0018:
        r3 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r3 = r3.get(r1);	 Catch:{ all -> 0x003c }
        r3 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) r3;	 Catch:{ all -> 0x003c }
        r3 = r3.generateOps(r5, r6);	 Catch:{ all -> 0x003c }
        r2 = r2 | r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0028:
        r5 = r4.mPendingActions;	 Catch:{ all -> 0x003c }
        r5.clear();	 Catch:{ all -> 0x003c }
        r5 = r4.mHost;	 Catch:{ all -> 0x003c }
        r5 = r5.getHandler();	 Catch:{ all -> 0x003c }
        r6 = r4.mExecCommit;	 Catch:{ all -> 0x003c }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003c }
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r2;
    L_0x003a:
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        return r1;
    L_0x003c:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003c }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.generateOpsForPendingActions(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            int i = 0;
            int i2 = i;
            while (i < this.mActive.size()) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    i2 |= fragment.mLoaderManager.hasRunningLoaders();
                }
                i++;
            }
            if (i2 == 0) {
                this.mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            }
        }
    }

    final void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
                ((OnBackStackChangedListener) this.mBackStackChangeListeners.get(i)).onBackStackChanged();
            }
        }
    }

    final void addBackStackState(BackStackRecord backStackRecord) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList();
        }
        this.mBackStack.add(backStackRecord);
    }

    final boolean popBackStackState(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.mBackStack == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            str = this.mBackStack.size() - 1;
            if (str < null) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(str));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int i3;
            if (str == null) {
                if (i < 0) {
                    i3 = -1;
                    if (i3 == this.mBackStack.size() - 1) {
                        return false;
                    }
                    for (str = this.mBackStack.size() - 1; str > i3; str--) {
                        arrayList.add(this.mBackStack.remove(str));
                        arrayList2.add(Boolean.valueOf(true));
                    }
                }
            }
            i3 = this.mBackStack.size() - 1;
            while (i3 >= 0) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                    break;
                }
                i3--;
            }
            if (i3 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                i3--;
                while (i3 >= 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(i3);
                    if ((str == null || !str.equals(backStackRecord2.getName())) && (i < 0 || i != backStackRecord2.mIndex)) {
                        break;
                    }
                    i3--;
                }
            }
            if (i3 == this.mBackStack.size() - 1) {
                return false;
            }
            for (str = this.mBackStack.size() - 1; str > i3; str--) {
                arrayList.add(this.mBackStack.remove(str));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    final FragmentManagerNonConfig retainNonConfig() {
        setRetaining(this.mSavedNonConfig);
        return this.mSavedNonConfig;
    }

    private static void setRetaining(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig != null) {
            List<Fragment> fragments = fragmentManagerNonConfig.getFragments();
            if (fragments != null) {
                for (Fragment fragment : fragments) {
                    fragment.mRetaining = true;
                }
            }
            FragmentManagerNonConfig<FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
            if (childNonConfigs != null) {
                for (FragmentManagerNonConfig retaining : childNonConfigs) {
                    setRetaining(retaining);
                }
            }
        }
    }

    final void saveNonConfig() {
        List list;
        List list2;
        if (this.mActive != null) {
            list = null;
            list2 = list;
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    Object obj;
                    if (fragment.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(fragment);
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (DEBUG) {
                            new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        fragment.mChildFragmentManager.saveNonConfig();
                        obj = fragment.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        obj = fragment.mChildNonConfig;
                    }
                    if (list2 == null && obj != null) {
                        list2 = new ArrayList(this.mActive.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj);
                    }
                }
            }
        } else {
            list = null;
            list2 = list;
        }
        if (list == null && list2 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new FragmentManagerNonConfig(list, list2);
        }
    }

    final void saveFragmentViewState(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = new SparseArray();
            } else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }

    final Bundle saveFragmentBasicState(Fragment fragment) {
        Bundle bundle;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (this.mStateBundle.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            saveFragmentViewState(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, fragment.mUserVisibleHint);
        }
        return bundle;
    }

    final Parcelable saveAllState() {
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions();
        this.mStateSaved = true;
        BackStackState[] backStackStateArr = null;
        this.mSavedNonConfig = null;
        if (this.mActive != null) {
            if (this.mActive.size() > 0) {
                int size = this.mActive.size();
                FragmentState[] fragmentStateArr = new FragmentState[size];
                int i = 0;
                int i2 = 0;
                int i3 = i2;
                while (i2 < size) {
                    Fragment fragment = (Fragment) this.mActive.valueAt(i2);
                    if (fragment != null) {
                        StringBuilder stringBuilder;
                        if (fragment.mIndex < 0) {
                            stringBuilder = new StringBuilder("Failure saving state: active ");
                            stringBuilder.append(fragment);
                            stringBuilder.append(" has cleared index: ");
                            stringBuilder.append(fragment.mIndex);
                            throwException(new IllegalStateException(stringBuilder.toString()));
                        }
                        FragmentState fragmentState = new FragmentState(fragment);
                        fragmentStateArr[i2] = fragmentState;
                        if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                        } else {
                            fragmentState.mSavedFragmentState = saveFragmentBasicState(fragment);
                            if (fragment.mTarget != null) {
                                if (fragment.mTarget.mIndex < 0) {
                                    StringBuilder stringBuilder2 = new StringBuilder("Failure saving state: ");
                                    stringBuilder2.append(fragment);
                                    stringBuilder2.append(" has target not in fragment manager: ");
                                    stringBuilder2.append(fragment.mTarget);
                                    throwException(new IllegalStateException(stringBuilder2.toString()));
                                }
                                if (fragmentState.mSavedFragmentState == null) {
                                    fragmentState.mSavedFragmentState = new Bundle();
                                }
                                putFragment(fragmentState.mSavedFragmentState, TARGET_STATE_TAG, fragment.mTarget);
                                if (fragment.mTargetRequestCode != 0) {
                                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, fragment.mTargetRequestCode);
                                }
                            }
                        }
                        if (DEBUG) {
                            stringBuilder = new StringBuilder("Saved state of ");
                            stringBuilder.append(fragment);
                            stringBuilder.append(": ");
                            stringBuilder.append(fragmentState.mSavedFragmentState);
                        }
                        i3 = true;
                    }
                    i2++;
                }
                if (i3 == 0) {
                    return null;
                }
                int[] iArr;
                int size2 = this.mAdded.size();
                if (size2 > 0) {
                    iArr = new int[size2];
                    for (i2 = 0; i2 < size2; i2++) {
                        iArr[i2] = ((Fragment) this.mAdded.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            StringBuilder stringBuilder3 = new StringBuilder("Failure saving state: active ");
                            stringBuilder3.append(this.mAdded.get(i2));
                            stringBuilder3.append(" has cleared index: ");
                            stringBuilder3.append(iArr[i2]);
                            throwException(new IllegalStateException(stringBuilder3.toString()));
                        }
                        if (DEBUG) {
                            StringBuilder stringBuilder4 = new StringBuilder("saveAllState: adding fragment #");
                            stringBuilder4.append(i2);
                            stringBuilder4.append(": ");
                            stringBuilder4.append(this.mAdded.get(i2));
                        }
                    }
                } else {
                    iArr = null;
                }
                if (this.mBackStack != null) {
                    size2 = this.mBackStack.size();
                    if (size2 > 0) {
                        backStackStateArr = new BackStackState[size2];
                        while (i < size2) {
                            backStackStateArr[i] = new BackStackState((BackStackRecord) this.mBackStack.get(i));
                            if (DEBUG) {
                                StringBuilder stringBuilder5 = new StringBuilder("saveAllState: adding back stack #");
                                stringBuilder5.append(i);
                                stringBuilder5.append(": ");
                                stringBuilder5.append(this.mBackStack.get(i));
                            }
                            i++;
                        }
                    }
                }
                Parcelable fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.mActive = fragmentStateArr;
                fragmentManagerState.mAdded = iArr;
                fragmentManagerState.mBackStack = backStackStateArr;
                if (this.mPrimaryNav != null) {
                    fragmentManagerState.mPrimaryNavActiveIndex = this.mPrimaryNav.mIndex;
                }
                fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
                saveNonConfig();
                return fragmentManagerState;
            }
        }
        return null;
    }

    final void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                List childNonConfigs;
                if (fragmentManagerNonConfig != null) {
                    List fragments = fragmentManagerNonConfig.getFragments();
                    childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                    int size = fragments != null ? fragments.size() : 0;
                    for (int i = 0; i < size; i++) {
                        Fragment fragment = (Fragment) fragments.get(i);
                        if (DEBUG) {
                            new StringBuilder("restoreAllState: re-attaching retained ").append(fragment);
                        }
                        int i2 = 0;
                        while (i2 < fragmentManagerState.mActive.length && fragmentManagerState.mActive[i2].mIndex != fragment.mIndex) {
                            i2++;
                        }
                        if (i2 == fragmentManagerState.mActive.length) {
                            StringBuilder stringBuilder = new StringBuilder("Could not find active fragment with index ");
                            stringBuilder.append(fragment.mIndex);
                            throwException(new IllegalStateException(stringBuilder.toString()));
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[i2];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                    }
                } else {
                    childNonConfigs = null;
                }
                this.mActive = new SparseArray(fragmentManagerState.mActive.length);
                int i3 = 0;
                while (i3 < fragmentManagerState.mActive.length) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i3];
                    if (fragmentState2 != null) {
                        FragmentManagerNonConfig fragmentManagerNonConfig2 = (childNonConfigs == null || i3 >= childNonConfigs.size()) ? null : (FragmentManagerNonConfig) childNonConfigs.get(i3);
                        Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mContainer, this.mParent, fragmentManagerNonConfig2);
                        if (DEBUG) {
                            StringBuilder stringBuilder2 = new StringBuilder("restoreAllState: active #");
                            stringBuilder2.append(i3);
                            stringBuilder2.append(": ");
                            stringBuilder2.append(instantiate);
                        }
                        this.mActive.put(instantiate.mIndex, instantiate);
                        fragmentState2.mInstance = null;
                    }
                    i3++;
                }
                if (fragmentManagerNonConfig != null) {
                    fragmentManagerNonConfig = fragmentManagerNonConfig.getFragments();
                    i3 = fragmentManagerNonConfig != null ? fragmentManagerNonConfig.size() : 0;
                    for (int i4 = 0; i4 < i3; i4++) {
                        Fragment fragment2 = (Fragment) fragmentManagerNonConfig.get(i4);
                        if (fragment2.mTargetIndex >= 0) {
                            fragment2.mTarget = (Fragment) this.mActive.get(fragment2.mTargetIndex);
                            if (fragment2.mTarget == null) {
                                StringBuilder stringBuilder3 = new StringBuilder("Re-attaching retained fragment ");
                                stringBuilder3.append(fragment2);
                                stringBuilder3.append(" target no longer exists: ");
                                stringBuilder3.append(fragment2.mTargetIndex);
                            }
                        }
                    }
                }
                this.mAdded.clear();
                if (fragmentManagerState.mAdded != null) {
                    for (fragmentManagerNonConfig = null; fragmentManagerNonConfig < fragmentManagerState.mAdded.length; fragmentManagerNonConfig++) {
                        Fragment fragment3 = (Fragment) this.mActive.get(fragmentManagerState.mAdded[fragmentManagerNonConfig]);
                        if (fragment3 == null) {
                            StringBuilder stringBuilder4 = new StringBuilder("No instantiated fragment for index #");
                            stringBuilder4.append(fragmentManagerState.mAdded[fragmentManagerNonConfig]);
                            throwException(new IllegalStateException(stringBuilder4.toString()));
                        }
                        fragment3.mAdded = true;
                        if (DEBUG) {
                            StringBuilder stringBuilder5 = new StringBuilder("restoreAllState: added #");
                            stringBuilder5.append(fragmentManagerNonConfig);
                            stringBuilder5.append(": ");
                            stringBuilder5.append(fragment3);
                        }
                        if (this.mAdded.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.mAdded) {
                            this.mAdded.add(fragment3);
                        }
                    }
                }
                if (fragmentManagerState.mBackStack != null) {
                    this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
                    for (fragmentManagerNonConfig = null; fragmentManagerNonConfig < fragmentManagerState.mBackStack.length; fragmentManagerNonConfig++) {
                        BackStackRecord instantiate2 = fragmentManagerState.mBackStack[fragmentManagerNonConfig].instantiate(this);
                        if (DEBUG) {
                            StringBuilder stringBuilder6 = new StringBuilder("restoreAllState: back stack #");
                            stringBuilder6.append(fragmentManagerNonConfig);
                            stringBuilder6.append(" (index ");
                            stringBuilder6.append(instantiate2.mIndex);
                            stringBuilder6.append("): ");
                            stringBuilder6.append(instantiate2);
                            PrintWriter printWriter = new PrintWriter(new LogWriter(TAG));
                            instantiate2.dump("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.mBackStack.add(instantiate2);
                        if (instantiate2.mIndex >= 0) {
                            setBackStackIndex(instantiate2.mIndex, instantiate2);
                        }
                    }
                } else {
                    this.mBackStack = null;
                }
                if (fragmentManagerState.mPrimaryNavActiveIndex >= null) {
                    this.mPrimaryNav = (Fragment) this.mActive.get(fragmentManagerState.mPrimaryNavActiveIndex);
                }
                this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
            }
        }
    }

    private void burpActive() {
        if (this.mActive != null) {
            for (int size = this.mActive.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    this.mActive.delete(this.mActive.keyAt(size));
                }
            }
        }
    }

    public final void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = fragmentHostCallback;
        this.mContainer = fragmentContainer;
        this.mParent = fragment;
    }

    public final void noteStateNotSaved() {
        this.mSavedNonConfig = null;
        int i = 0;
        this.mStateSaved = false;
        int size = this.mAdded.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
            i++;
        }
    }

    public final void dispatchCreate() {
        this.mStateSaved = false;
        dispatchStateChange(1);
    }

    public final void dispatchActivityCreated() {
        this.mStateSaved = false;
        dispatchStateChange(2);
    }

    public final void dispatchStart() {
        this.mStateSaved = false;
        dispatchStateChange(4);
    }

    public final void dispatchResume() {
        this.mStateSaved = false;
        dispatchStateChange(5);
    }

    public final void dispatchPause() {
        dispatchStateChange(4);
    }

    public final void dispatchStop() {
        this.mStateSaved = true;
        dispatchStateChange(3);
    }

    public final void dispatchReallyStop() {
        dispatchStateChange(2);
    }

    public final void dispatchDestroyView() {
        dispatchStateChange(1);
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    private void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            moveToState(i, false);
            execPendingActions();
        } finally {
            this.mExecutingActions = false;
        }
    }

    public final void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.mAdded.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final void dispatchConfigurationChanged(Configuration configuration) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void dispatchLowMemory() {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        boolean z = false;
        ArrayList arrayList = null;
        for (int i2 = z; i2 < this.mAdded.size(); i2++) {
            Fragment fragment = (Fragment) this.mAdded.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            while (i < this.mCreatedMenus.size()) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || arrayList.contains(fragment2) == null) {
                    fragment2.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        int i = 0;
        boolean z = false;
        while (i < this.mAdded.size()) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        for (int i = 0; i < this.mAdded.size(); i++) {
            Fragment fragment = (Fragment) this.mAdded.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.mActive.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            this.mPrimaryNav = fragment;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" is not an active fragment of FragmentManager ");
        stringBuilder.append(this);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Fragment getPrimaryNavigationFragment() {
        return this.mPrimaryNav;
    }

    public final void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mLifecycleCallbacks.add(new Pair(fragmentLifecycleCallbacks, Boolean.valueOf(z)));
    }

    public final void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            for (int i = 0; i < size; i++) {
                if (((Pair) this.mLifecycleCallbacks.get(i)).first == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i);
                    break;
                }
            }
        }
    }

    final void dispatchOnFragmentPreAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    final void dispatchOnFragmentAttached(Fragment fragment, Context context, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentAttached(this, fragment, context);
            }
        }
    }

    final void dispatchOnFragmentPreCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPreCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    final void dispatchOnFragmentCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    final void dispatchOnFragmentActivityCreated(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    final void dispatchOnFragmentViewCreated(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    final void dispatchOnFragmentStarted(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentStarted(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentResumed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentResumed(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentPaused(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentPaused(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentStopped(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentStopped(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentSaveInstanceState(Fragment fragment, Bundle bundle, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    final void dispatchOnFragmentViewDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentDestroyed(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentDestroyed(this, fragment);
            }
        }
    }

    final void dispatchOnFragmentDetached(Fragment fragment, boolean z) {
        if (this.mParent != null) {
            FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (!z || ((Boolean) pair.second).booleanValue()) {
                ((FragmentLifecycleCallbacks) pair.first).onFragmentDetached(this, fragment);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        FragmentManagerImpl fragmentManagerImpl = this;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, FragmentTag.Fragment);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(fragmentManagerImpl.mHost.getContext(), str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Fragment fragment;
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && i != -1) {
            findFragmentById = findFragmentById(i);
        }
        if (DEBUG) {
            stringBuilder = new StringBuilder("onCreateView: id=0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(" fname=");
            stringBuilder.append(str2);
            stringBuilder.append(" existing=");
            stringBuilder.append(findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = fragmentManagerImpl.mContainer.instantiate(context2, str2, null);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : i;
            instantiate.mContainerId = i;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = fragmentManagerImpl;
            instantiate.mHost = fragmentManagerImpl.mHost;
            instantiate.onInflate(fragmentManagerImpl.mHost.getContext(), attributeSet2, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (findFragmentById.mInLayout) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            findFragmentById.mInLayout = true;
            findFragmentById.mHost = fragmentManagerImpl.mHost;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(fragmentManagerImpl.mHost.getContext(), attributeSet2, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        }
        if (fragmentManagerImpl.mCurState > 0 || !fragment.mFromLayout) {
            moveToState(fragment);
        } else {
            moveToState(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            StringBuilder stringBuilder2 = new StringBuilder("Fragment ");
            stringBuilder2.append(str2);
            stringBuilder2.append(" did not create a view.");
            throw new IllegalStateException(stringBuilder2.toString());
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
