package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCanceledListener;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* compiled from: LoaderManager */
class LoaderManagerImpl extends LoaderManager {
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    boolean mCreatingLoader;
    FragmentHostCallback mHost;
    final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
    final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;

    /* compiled from: LoaderManager */
    final class LoaderInfo implements OnLoadCanceledListener<Object>, OnLoadCompleteListener<Object> {
        final Bundle mArgs;
        LoaderCallbacks<Object> mCallbacks;
        Object mData;
        boolean mDeliveredData;
        boolean mDestroyed;
        boolean mHaveData;
        final int mId;
        boolean mListenerRegistered;
        Loader<Object> mLoader;
        LoaderInfo mPendingLoader;
        boolean mReportNextStart;
        boolean mRetaining;
        boolean mRetainingStarted;
        boolean mStarted;

        public LoaderInfo(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
            this.mId = i;
            this.mArgs = bundle;
            this.mCallbacks = loaderCallbacks;
        }

        final void start() {
            if (this.mRetaining && this.mRetainingStarted) {
                this.mStarted = true;
            } else if (!this.mStarted) {
                this.mStarted = true;
                if (LoaderManagerImpl.DEBUG) {
                    new StringBuilder("  Starting: ").append(this);
                }
                if (this.mLoader == null && this.mCallbacks != null) {
                    this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
                }
                if (this.mLoader != null) {
                    if (!this.mLoader.getClass().isMemberClass() || Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                        if (!this.mListenerRegistered) {
                            this.mLoader.registerListener(this.mId, this);
                            this.mLoader.registerOnLoadCanceledListener(this);
                            this.mListenerRegistered = true;
                        }
                        this.mLoader.startLoading();
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Object returned from onCreateLoader must not be a non-static inner member class: ");
                        stringBuilder.append(this.mLoader);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
        }

        final void retain() {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  Retaining: ").append(this);
            }
            this.mRetaining = true;
            this.mRetainingStarted = this.mStarted;
            this.mStarted = false;
            this.mCallbacks = null;
        }

        final void finishRetain() {
            if (this.mRetaining) {
                if (LoaderManagerImpl.DEBUG) {
                    new StringBuilder("  Finished Retaining: ").append(this);
                }
                this.mRetaining = false;
                if (!(this.mStarted == this.mRetainingStarted || this.mStarted)) {
                    stop();
                }
            }
            if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
                callOnLoadFinished(this.mLoader, this.mData);
            }
        }

        final void reportStart() {
            if (this.mStarted && this.mReportNextStart) {
                this.mReportNextStart = false;
                if (this.mHaveData && !this.mRetaining) {
                    callOnLoadFinished(this.mLoader, this.mData);
                }
            }
        }

        final void stop() {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.mStarted = false;
            if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
                this.mListenerRegistered = false;
                this.mLoader.unregisterListener(this);
                this.mLoader.unregisterOnLoadCanceledListener(this);
                this.mLoader.stopLoading();
            }
        }

        final boolean cancel() {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("  Canceling: ").append(this);
            }
            if (!this.mStarted || this.mLoader == null || !this.mListenerRegistered) {
                return false;
            }
            boolean cancelLoad = this.mLoader.cancelLoad();
            if (!cancelLoad) {
                onLoadCanceled(this.mLoader);
            }
            return cancelLoad;
        }

        final void destroy() {
            String str;
            LoaderInfo loaderInfo = this;
            while (true) {
                if (LoaderManagerImpl.DEBUG) {
                    new StringBuilder("  Destroying: ").append(loaderInfo);
                }
                loaderInfo.mDestroyed = true;
                boolean z = loaderInfo.mDeliveredData;
                loaderInfo.mDeliveredData = false;
                if (loaderInfo.mCallbacks != null && loaderInfo.mLoader != null && loaderInfo.mHaveData && z) {
                    if (LoaderManagerImpl.DEBUG) {
                        new StringBuilder("  Resetting: ").append(loaderInfo);
                    }
                    if (LoaderManagerImpl.this.mHost != null) {
                        str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    try {
                        loaderInfo.mCallbacks.onLoaderReset(loaderInfo.mLoader);
                    } finally {
                        if (LoaderManagerImpl.this.mHost != null) {
                            loaderInfo = LoaderManagerImpl.this.mHost.mFragmentManager;
                            loaderInfo.mNoTransactionsBecause = str;
                        }
                    }
                }
                loaderInfo.mCallbacks = null;
                loaderInfo.mData = null;
                loaderInfo.mHaveData = false;
                if (loaderInfo.mLoader != null) {
                    if (loaderInfo.mListenerRegistered) {
                        loaderInfo.mListenerRegistered = false;
                        loaderInfo.mLoader.unregisterListener(loaderInfo);
                        loaderInfo.mLoader.unregisterOnLoadCanceledListener(loaderInfo);
                    }
                    loaderInfo.mLoader.reset();
                }
                if (loaderInfo.mPendingLoader != null) {
                    loaderInfo = loaderInfo.mPendingLoader;
                } else {
                    return;
                }
            }
        }

        public final void onLoadCanceled(Loader<Object> loader) {
            if (LoaderManagerImpl.DEBUG != null) {
                new StringBuilder("onLoadCanceled: ").append(this);
            }
            if (this.mDestroyed != null) {
                loader = LoaderManagerImpl.DEBUG;
            } else if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
                loader = LoaderManagerImpl.DEBUG;
            } else {
                loader = this.mPendingLoader;
                if (loader != null) {
                    if (LoaderManagerImpl.DEBUG) {
                        new StringBuilder("  Switching to pending loader: ").append(loader);
                    }
                    this.mPendingLoader = null;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                    destroy();
                    LoaderManagerImpl.this.installLoader(loader);
                }
            }
        }

        public final void onLoadComplete(Loader<Object> loader, Object obj) {
            if (LoaderManagerImpl.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (this.mDestroyed) {
                loader = LoaderManagerImpl.DEBUG;
            } else if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this) {
                loader = LoaderManagerImpl.DEBUG;
            } else {
                LoaderInfo loaderInfo = this.mPendingLoader;
                if (loaderInfo != null) {
                    if (LoaderManagerImpl.DEBUG != null) {
                        new StringBuilder("  Switching to pending loader: ").append(loaderInfo);
                    }
                    this.mPendingLoader = null;
                    LoaderManagerImpl.this.mLoaders.put(this.mId, null);
                    destroy();
                    LoaderManagerImpl.this.installLoader(loaderInfo);
                    return;
                }
                if (!(this.mData == obj && this.mHaveData)) {
                    this.mData = obj;
                    this.mHaveData = true;
                    if (this.mStarted) {
                        callOnLoadFinished(loader, obj);
                    }
                }
                LoaderInfo loaderInfo2 = (LoaderInfo) LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
                if (!(loaderInfo2 == null || loaderInfo2 == this)) {
                    loaderInfo2.mDeliveredData = null;
                    loaderInfo2.destroy();
                    LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
                }
                if (LoaderManagerImpl.this.mHost != null && LoaderManagerImpl.this.hasRunningLoaders() == null) {
                    LoaderManagerImpl.this.mHost.mFragmentManager.startPendingDeferredFragments();
                }
            }
        }

        final void callOnLoadFinished(Loader<Object> loader, Object obj) {
            if (this.mCallbacks != null) {
                String str = null;
                if (LoaderManagerImpl.this.mHost != null) {
                    str = LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause;
                    LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
                }
                try {
                    if (LoaderManagerImpl.DEBUG) {
                        StringBuilder stringBuilder = new StringBuilder("  onLoadFinished in ");
                        stringBuilder.append(loader);
                        stringBuilder.append(": ");
                        stringBuilder.append(loader.dataToString(obj));
                    }
                    this.mCallbacks.onLoadFinished(loader, obj);
                    this.mDeliveredData = true;
                } finally {
                    if (LoaderManagerImpl.this.mHost != null) {
                        LoaderManagerImpl.this.mHost.mFragmentManager.mNoTransactionsBecause = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.mId);
            stringBuilder.append(" : ");
            DebugUtils.buildShortClassTag(this.mLoader, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            LoaderInfo loaderInfo = this;
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(loaderInfo.mId);
                printWriter.print(" mArgs=");
                printWriter.println(loaderInfo.mArgs);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(loaderInfo.mCallbacks);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(loaderInfo.mLoader);
                if (loaderInfo.mLoader != null) {
                    Loader loader = loaderInfo.mLoader;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("  ");
                    loader.dump(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
                }
                if (loaderInfo.mHaveData || loaderInfo.mDeliveredData) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(loaderInfo.mHaveData);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(loaderInfo.mDeliveredData);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(loaderInfo.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(loaderInfo.mStarted);
                printWriter.print(" mReportNextStart=");
                printWriter.print(loaderInfo.mReportNextStart);
                printWriter.print(" mDestroyed=");
                printWriter.println(loaderInfo.mDestroyed);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(loaderInfo.mRetaining);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(loaderInfo.mRetainingStarted);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(loaderInfo.mListenerRegistered);
                if (loaderInfo.mPendingLoader != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(loaderInfo.mPendingLoader);
                    printWriter.println(Constants.COLON_SEPARATOR);
                    loaderInfo = loaderInfo.mPendingLoader;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("  ");
                    str = stringBuilder2.toString();
                } else {
                    return;
                }
            }
        }
    }

    LoaderManagerImpl(String str, FragmentHostCallback fragmentHostCallback, boolean z) {
        this.mWho = str;
        this.mHost = fragmentHostCallback;
        this.mStarted = z;
    }

    void updateHostController(FragmentHostCallback fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    private LoaderInfo createLoader(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        LoaderInfo loaderInfo = new LoaderInfo(i, bundle, loaderCallbacks);
        loaderInfo.mLoader = loaderCallbacks.onCreateLoader(i, bundle);
        return loaderInfo;
    }

    private LoaderInfo createAndInstallLoader(int i, Bundle bundle, LoaderCallbacks<Object> loaderCallbacks) {
        try {
            this.mCreatingLoader = true;
            i = createLoader(i, bundle, loaderCallbacks);
            installLoader(i);
            return i;
        } finally {
            this.mCreatingLoader = false;
        }
    }

    void installLoader(LoaderInfo loaderInfo) {
        this.mLoaders.put(loaderInfo.mId, loaderInfo);
        if (this.mStarted) {
            loaderInfo.start();
        }
    }

    public <D> Loader<D> initLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i);
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder("initLoader in ");
            stringBuilder.append(this);
            stringBuilder.append(": args=");
            stringBuilder.append(bundle);
        }
        if (loaderInfo == null) {
            loaderInfo = createAndInstallLoader(i, bundle, loaderCallbacks);
            if (DEBUG != 0) {
                new StringBuilder("  Created new loader ").append(loaderInfo);
            }
        } else {
            if (DEBUG != 0) {
                new StringBuilder("  Re-using existing loader ").append(loaderInfo);
            }
            loaderInfo.mCallbacks = loaderCallbacks;
        }
        if (!(loaderInfo.mHaveData == 0 || this.mStarted == 0)) {
            loaderInfo.callOnLoadFinished(loaderInfo.mLoader, loaderInfo.mData);
        }
        return loaderInfo.mLoader;
    }

    public <D> Loader<D> restartLoader(int i, Bundle bundle, LoaderCallbacks<D> loaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i);
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder("restartLoader in ");
            stringBuilder.append(this);
            stringBuilder.append(": args=");
            stringBuilder.append(bundle);
        }
        if (loaderInfo != null) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.get(i);
            if (loaderInfo2 != null) {
                if (loaderInfo.mHaveData) {
                    if (DEBUG) {
                        new StringBuilder("  Removing last inactive loader: ").append(loaderInfo);
                    }
                    loaderInfo2.mDeliveredData = false;
                    loaderInfo2.destroy();
                } else if (loaderInfo.cancel()) {
                    if (loaderInfo.mPendingLoader != null) {
                        if (DEBUG) {
                            new StringBuilder("  Removing pending loader: ").append(loaderInfo.mPendingLoader);
                        }
                        loaderInfo.mPendingLoader.destroy();
                        loaderInfo.mPendingLoader = null;
                    }
                    loaderInfo.mPendingLoader = createLoader(i, bundle, loaderCallbacks);
                    return loaderInfo.mPendingLoader.mLoader;
                } else {
                    this.mLoaders.put(i, null);
                    loaderInfo.destroy();
                }
            } else if (DEBUG) {
                new StringBuilder("  Making last loader inactive: ").append(loaderInfo);
            }
            loaderInfo.mLoader.abandon();
            this.mInactiveLoaders.put(i, loaderInfo);
        }
        return createAndInstallLoader(i, bundle, loaderCallbacks).mLoader;
    }

    public void destroyLoader(int i) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder("destroyLoader in ");
            stringBuilder.append(this);
            stringBuilder.append(" of ");
            stringBuilder.append(i);
        }
        int indexOfKey = this.mLoaders.indexOfKey(i);
        if (indexOfKey >= 0) {
            LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(indexOfKey);
            this.mLoaders.removeAt(indexOfKey);
            loaderInfo.destroy();
        }
        i = this.mInactiveLoaders.indexOfKey(i);
        if (i >= 0) {
            LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.valueAt(i);
            this.mInactiveLoaders.removeAt(i);
            loaderInfo2.destroy();
        }
        if (this.mHost != 0 && hasRunningLoaders() == 0) {
            this.mHost.mFragmentManager.startPendingDeferredFragments();
        }
    }

    public <D> Loader<D> getLoader(int i) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.get(i);
        if (loaderInfo == null) {
            return 0;
        }
        if (loaderInfo.mPendingLoader != null) {
            return loaderInfo.mPendingLoader.mLoader;
        }
        return loaderInfo.mLoader;
    }

    void doStart() {
        if (DEBUG) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.mStarted) {
            new RuntimeException("here").fillInStackTrace();
            new StringBuilder("Called doStart when already started: ").append(this);
            return;
        }
        this.mStarted = true;
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).start();
        }
    }

    void doStop() {
        if (DEBUG) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.mStarted) {
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).stop();
            }
            this.mStarted = false;
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doStop when not started: ").append(this);
    }

    void doRetain() {
        if (DEBUG) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.mStarted) {
            this.mRetaining = true;
            this.mStarted = false;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).retain();
            }
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doRetain when not started: ").append(this);
    }

    void finishRetain() {
        if (this.mRetaining) {
            if (DEBUG) {
                new StringBuilder("Finished Retaining in ").append(this);
            }
            this.mRetaining = false;
            for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).finishRetain();
            }
        }
    }

    void doReportNextStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).mReportNextStart = true;
        }
    }

    void doReportStart() {
        for (int size = this.mLoaders.size() - 1; size >= 0; size--) {
            ((LoaderInfo) this.mLoaders.valueAt(size)).reportStart();
        }
    }

    void doDestroy() {
        int size;
        if (!this.mRetaining) {
            if (DEBUG) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (size = this.mLoaders.size() - 1; size >= 0; size--) {
                ((LoaderInfo) this.mLoaders.valueAt(size)).destroy();
            }
            this.mLoaders.clear();
        }
        if (DEBUG) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (size = this.mInactiveLoaders.size() - 1; size >= 0; size--) {
            ((LoaderInfo) this.mInactiveLoaders.valueAt(size)).destroy();
        }
        this.mInactiveLoaders.clear();
        this.mHost = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        DebugUtils.buildShortClassTag(this.mHost, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String stringBuilder;
        int i = 0;
        if (this.mLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("    ");
            stringBuilder = stringBuilder2.toString();
            for (int i2 = 0; i2 < this.mLoaders.size(); i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(loaderInfo.toString());
                loaderInfo.dump(stringBuilder, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.mInactiveLoaders.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("    ");
            stringBuilder = stringBuilder2.toString();
            while (i < this.mInactiveLoaders.size()) {
                LoaderInfo loaderInfo2 = (LoaderInfo) this.mInactiveLoaders.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.mInactiveLoaders.keyAt(i));
                printWriter.print(": ");
                printWriter.println(loaderInfo2.toString());
                loaderInfo2.dump(stringBuilder, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean hasRunningLoaders() {
        int size = this.mLoaders.size();
        int i = 0;
        boolean z = i;
        while (i < size) {
            LoaderInfo loaderInfo = (LoaderInfo) this.mLoaders.valueAt(i);
            int i2 = (!loaderInfo.mStarted || loaderInfo.mDeliveredData) ? 0 : 1;
            z |= i2;
            i++;
        }
        return z;
    }
}
