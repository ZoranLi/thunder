package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.proguard.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    private static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference(mediaBrowserServiceCallbackImpl);
        }

        public void handleMessage(android.os.Message r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r6 = this;
            r0 = r6.mCallbacksMessengerRef;
            if (r0 == 0) goto L_0x0088;
        L_0x0004:
            r0 = r6.mCallbacksMessengerRef;
            r0 = r0.get();
            if (r0 == 0) goto L_0x0088;
        L_0x000c:
            r0 = r6.mCallbackImplRef;
            r0 = r0.get();
            if (r0 != 0) goto L_0x0015;
        L_0x0014:
            goto L_0x0088;
        L_0x0015:
            r0 = r7.getData();
            r1 = android.support.v4.media.session.MediaSessionCompat.class;
            r1 = r1.getClassLoader();
            r0.setClassLoader(r1);
            r1 = r6.mCallbackImplRef;
            r1 = r1.get();
            r1 = (android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl) r1;
            r2 = r6.mCallbacksMessengerRef;
            r2 = r2.get();
            r2 = (android.os.Messenger) r2;
            r3 = r7.what;	 Catch:{ BadParcelableException -> 0x007f }
            switch(r3) {
                case 1: goto L_0x0054;
                case 2: goto L_0x0050;
                case 3: goto L_0x003a;
                default: goto L_0x0037;
            };	 Catch:{ BadParcelableException -> 0x007f }
        L_0x0037:
            r0 = new java.lang.StringBuilder;	 Catch:{ BadParcelableException -> 0x007f }
            goto L_0x006c;	 Catch:{ BadParcelableException -> 0x007f }
        L_0x003a:
            r3 = "data_media_item_id";	 Catch:{ BadParcelableException -> 0x007f }
            r3 = r0.getString(r3);	 Catch:{ BadParcelableException -> 0x007f }
            r4 = "data_media_item_list";	 Catch:{ BadParcelableException -> 0x007f }
            r4 = r0.getParcelableArrayList(r4);	 Catch:{ BadParcelableException -> 0x007f }
            r5 = "data_options";	 Catch:{ BadParcelableException -> 0x007f }
            r0 = r0.getBundle(r5);	 Catch:{ BadParcelableException -> 0x007f }
            r1.onLoadChildren(r2, r3, r4, r0);	 Catch:{ BadParcelableException -> 0x007f }
            return;	 Catch:{ BadParcelableException -> 0x007f }
        L_0x0050:
            r1.onConnectionFailed(r2);	 Catch:{ BadParcelableException -> 0x007f }
            return;	 Catch:{ BadParcelableException -> 0x007f }
        L_0x0054:
            r3 = "data_media_item_id";	 Catch:{ BadParcelableException -> 0x007f }
            r3 = r0.getString(r3);	 Catch:{ BadParcelableException -> 0x007f }
            r4 = "data_media_session_token";	 Catch:{ BadParcelableException -> 0x007f }
            r4 = r0.getParcelable(r4);	 Catch:{ BadParcelableException -> 0x007f }
            r4 = (android.support.v4.media.session.MediaSessionCompat.Token) r4;	 Catch:{ BadParcelableException -> 0x007f }
            r5 = "data_root_hints";	 Catch:{ BadParcelableException -> 0x007f }
            r0 = r0.getBundle(r5);	 Catch:{ BadParcelableException -> 0x007f }
            r1.onServiceConnected(r2, r3, r4, r0);	 Catch:{ BadParcelableException -> 0x007f }
            return;	 Catch:{ BadParcelableException -> 0x007f }
        L_0x006c:
            r3 = "Unhandled message: ";	 Catch:{ BadParcelableException -> 0x007f }
            r0.<init>(r3);	 Catch:{ BadParcelableException -> 0x007f }
            r0.append(r7);	 Catch:{ BadParcelableException -> 0x007f }
            r3 = "\n  Client version: 1\n  Service version: ";	 Catch:{ BadParcelableException -> 0x007f }
            r0.append(r3);	 Catch:{ BadParcelableException -> 0x007f }
            r3 = r7.arg1;	 Catch:{ BadParcelableException -> 0x007f }
            r0.append(r3);	 Catch:{ BadParcelableException -> 0x007f }
            return;
        L_0x007f:
            r7 = r7.what;
            r0 = 1;
            if (r7 != r0) goto L_0x0087;
        L_0x0084:
            r1.onConnectionFailed(r2);
        L_0x0087:
            return;
        L_0x0088:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.CallbackHandler.handleMessage(android.os.Message):void");
        }

        void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference(messenger);
        }
    }

    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        private class StubApi21 implements ConnectionCallback {
            StubApi21() {
            }

            public void onConnected() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            public void onConnectionSuspended() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }

            public void onConnectionFailed() {
                if (ConnectionCallback.this.mConnectionCallbackInternal != null) {
                    ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public ConnectionCallback() {
            if (VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
            } else {
                this.mConnectionCallbackObj = null;
            }
        }

        void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        private class StubApi23 implements ItemCallback {
            StubApi23() {
            }

            public void onItemLoaded(Parcel parcel) {
                if (parcel == null) {
                    ItemCallback.this.onItemLoaded(null);
                    return;
                }
                parcel.setDataPosition(0);
                MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                ItemCallback.this.onItemLoaded(mediaItem);
            }

            public void onError(@NonNull String str) {
                ItemCallback.this.onError(str);
            }
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }

        public ItemCallback() {
            if (VERSION.SDK_INT >= 23) {
                this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
            } else {
                this.mItemCallbackObj = null;
            }
        }
    }

    interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String str, @NonNull ItemCallback itemCallback);

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback);

        void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback);

        void subscribe(@NonNull String str, Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback);

        void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback);
    }

    interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle);

        void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle);
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public final MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        public int describeContents() {
            return 0;
        }

        public static MediaItem fromMediaItem(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaItem.getDescription(obj)), MediaItem.getFlags(obj));
                }
            }
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<MediaItem> arrayList = new ArrayList(list.size());
                    for (Object fromMediaItem : list) {
                        arrayList.add(fromMediaItem(fromMediaItem));
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.mFlags = i;
                this.mDescription = mediaDescriptionCompat;
            }
        }

        MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=");
            stringBuilder.append(this.mFlags);
            stringBuilder.append(", mDescription=");
            stringBuilder.append(this.mDescription);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    public static abstract class SearchCallback {
        public void onError(@NonNull String str, Bundle bundle) {
        }

        public void onSearchResult(@NonNull String str, Bundle bundle, @NonNull List<MediaItem> list) {
        }
    }

    private static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        void connect(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        void disconnect(Messenger messenger) throws RemoteException {
            sendRequest(2, null, messenger);
        }

        void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        void registerCallbackMessenger(Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
            sendRequest(7, null, messenger);
        }

        void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        private void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }
    }

    private static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public SubscriptionCallback getCallback(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (context = null; context < this.mOptionsList.size(); context++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(context), bundle)) {
                    return (SubscriptionCallback) this.mCallbacks.get(context);
                }
            }
            return null;
        }

        public void putCallback(Context context, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            for (context = null; context < this.mOptionsList.size(); context++) {
                if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(context), bundle)) {
                    this.mCallbacks.set(context, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        private final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        private final IBinder mToken;

        private class StubApi21 implements SubscriptionCallback {
            StubApi21() {
            }

            public void onChildrenLoaded(@NonNull String str, List<?> list) {
                Subscription subscription = SubscriptionCallback.this.mSubscriptionRef == null ? null : (Subscription) SubscriptionCallback.this.mSubscriptionRef.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                    return;
                }
                list = MediaItem.fromMediaItemList(list);
                List callbacks = subscription.getCallbacks();
                List optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = (Bundle) optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(str, list);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(list, bundle), bundle);
                    }
                }
            }

            public void onError(@NonNull String str) {
                SubscriptionCallback.this.onError(str);
            }

            List<MediaItem> applyOptions(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                bundle = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && bundle == -1) {
                    return list;
                }
                int i2 = bundle * i;
                int i3 = i2 + bundle;
                if (i >= 0 && bundle > null) {
                    if (i2 < list.size()) {
                        if (i3 > list.size()) {
                            i3 = list.size();
                        }
                        return list.subList(i2, i3);
                    }
                }
                return Collections.EMPTY_LIST;
            }
        }

        private class StubApi24 extends StubApi21 implements SubscriptionCallback {
            StubApi24() {
                super();
            }

            public void onChildrenLoaded(@NonNull String str, List<?> list, @NonNull Bundle bundle) {
                SubscriptionCallback.this.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
            }

            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void onError(@NonNull String str) {
        }

        public void onError(@NonNull String str, @NonNull Bundle bundle) {
        }

        public SubscriptionCallback() {
            if (VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi24.createSubscriptionCallback(new StubApi24());
                this.mToken = null;
            } else if (VERSION.SDK_INT >= 21) {
                this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
                this.mToken = new Binder();
            } else {
                this.mSubscriptionCallbackObj = null;
                this.mToken = new Binder();
            }
        }

        private void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference(subscription);
        }
    }

    private static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            if (this.mCallback != null) {
                switch (i) {
                    case -1:
                        this.mCallback.onError(this.mAction, this.mExtras, bundle);
                        return;
                    case 0:
                        this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                        return;
                    case 1:
                        this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                        return;
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown result code: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" (extras=");
                        stringBuilder.append(this.mExtras);
                        stringBuilder.append(", resultData=");
                        stringBuilder.append(bundle);
                        stringBuilder.append(k.t);
                        return;
                }
            }
        }
    }

    private static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) != 0) {
                    i = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                    if (i != 0) {
                        if ((i instanceof MediaItem) == null) {
                            this.mCallback.onError(this.mMediaId);
                            return;
                        }
                    }
                    this.mCallback.onItemLoaded((MediaItem) i);
                    return;
                }
            }
            this.mCallback.onError(this.mMediaId);
        }
    }

    @RequiresApi(21)
    static class MediaBrowserImplApi21 implements ConnectionCallbackInternal, MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap();

        public void onConnectionFailed() {
        }

        public void onConnectionFailed(Messenger messenger) {
        }

        public void onServiceConnected(Messenger messenger, String str, Token token, Bundle bundle) {
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.mContext = context;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.mRootHints = new Bundle(bundle);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(context, componentName, connectionCallback.mConnectionCallbackObj, this.mRootHints);
        }

        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        public void disconnect() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mServiceBinderWrapper;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.mCallbacksMessenger;
            if (r0 == 0) goto L_0x000f;
        L_0x0008:
            r0 = r2.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x000f }
            r1 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x000f }
            r0.unregisterCallbackMessenger(r1);	 Catch:{ RemoteException -> 0x000f }
        L_0x000f:
            r0 = r2.mBrowserObj;
            android.support.v4.media.MediaBrowserCompatApi21.disconnect(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.disconnect():void");
        }

        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @NonNull
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Nullable
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @NonNull
        public Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
            }
            return this.mMediaSessionToken;
        }

        public void subscribe(@android.support.annotation.NonNull java.lang.String r3, android.os.Bundle r4, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mSubscriptions;
            r0 = r0.get(r3);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x0014;
        L_0x000a:
            r0 = new android.support.v4.media.MediaBrowserCompat$Subscription;
            r0.<init>();
            r1 = r2.mSubscriptions;
            r1.put(r3, r0);
        L_0x0014:
            r5.setSubscription(r0);
            if (r4 != 0) goto L_0x001b;
        L_0x0019:
            r4 = 0;
            goto L_0x0021;
        L_0x001b:
            r1 = new android.os.Bundle;
            r1.<init>(r4);
            r4 = r1;
        L_0x0021:
            r1 = r2.mContext;
            r0.putCallback(r1, r4, r5);
            r0 = r2.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x0034;
        L_0x002a:
            r4 = r2.mBrowserObj;
            r5 = r5.mSubscriptionCallbackObj;
            android.support.v4.media.MediaBrowserCompatApi21.subscribe(r4, r3, r5);
            return;
        L_0x0034:
            r0 = r2.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0040 }
            r5 = r5.mToken;	 Catch:{ RemoteException -> 0x0040 }
            r1 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0040 }
            r0.addSubscription(r3, r5, r4, r1);	 Catch:{ RemoteException -> 0x0040 }
            return;
        L_0x0040:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.subscribe(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void unsubscribe(@android.support.annotation.NonNull java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r7 = this;
            r0 = r7.mSubscriptions;
            r0 = r0.get(r8);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r7.mServiceBinderWrapper;
            if (r1 != 0) goto L_0x0042;
        L_0x000f:
            if (r9 != 0) goto L_0x0017;
        L_0x0011:
            r1 = r7.mBrowserObj;
            android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(r1, r8);
            goto L_0x0077;
        L_0x0017:
            r1 = r0.getCallbacks();
            r2 = r0.getOptionsList();
            r3 = r1.size();
            r3 = r3 + -1;
        L_0x0025:
            if (r3 < 0) goto L_0x0036;
        L_0x0027:
            r4 = r1.get(r3);
            if (r4 != r9) goto L_0x0033;
        L_0x002d:
            r1.remove(r3);
            r2.remove(r3);
        L_0x0033:
            r3 = r3 + -1;
            goto L_0x0025;
        L_0x0036:
            r1 = r1.size();
            if (r1 != 0) goto L_0x0077;
        L_0x003c:
            r1 = r7.mBrowserObj;
            android.support.v4.media.MediaBrowserCompatApi21.unsubscribe(r1, r8);
            goto L_0x0077;
        L_0x0042:
            if (r9 != 0) goto L_0x004d;
        L_0x0044:
            r1 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0077 }
            r2 = 0;	 Catch:{ RemoteException -> 0x0077 }
            r3 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0077 }
            r1.removeSubscription(r8, r2, r3);	 Catch:{ RemoteException -> 0x0077 }
            goto L_0x0077;	 Catch:{ RemoteException -> 0x0077 }
        L_0x004d:
            r1 = r0.getCallbacks();	 Catch:{ RemoteException -> 0x0077 }
            r2 = r0.getOptionsList();	 Catch:{ RemoteException -> 0x0077 }
            r3 = r1.size();	 Catch:{ RemoteException -> 0x0077 }
            r3 = r3 + -1;	 Catch:{ RemoteException -> 0x0077 }
        L_0x005b:
            if (r3 < 0) goto L_0x0077;	 Catch:{ RemoteException -> 0x0077 }
        L_0x005d:
            r4 = r1.get(r3);	 Catch:{ RemoteException -> 0x0077 }
            if (r4 != r9) goto L_0x0074;	 Catch:{ RemoteException -> 0x0077 }
        L_0x0063:
            r4 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0077 }
            r5 = r9.mToken;	 Catch:{ RemoteException -> 0x0077 }
            r6 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0077 }
            r4.removeSubscription(r8, r5, r6);	 Catch:{ RemoteException -> 0x0077 }
            r1.remove(r3);	 Catch:{ RemoteException -> 0x0077 }
            r2.remove(r3);	 Catch:{ RemoteException -> 0x0077 }
        L_0x0074:
            r3 = r3 + -1;
            goto L_0x005b;
        L_0x0077:
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x007f;
        L_0x007d:
            if (r9 != 0) goto L_0x0084;
        L_0x007f:
            r9 = r7.mSubscriptions;
            r9.remove(r8);
        L_0x0084:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.unsubscribe(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void getItem(@android.support.annotation.NonNull final java.lang.String r4, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.ItemCallback r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = android.text.TextUtils.isEmpty(r4);
            if (r0 == 0) goto L_0x000e;
        L_0x0006:
            r4 = new java.lang.IllegalArgumentException;
            r5 = "mediaId is empty";
            r4.<init>(r5);
            throw r4;
        L_0x000e:
            if (r5 != 0) goto L_0x0018;
        L_0x0010:
            r4 = new java.lang.IllegalArgumentException;
            r5 = "cb is null";
            r4.<init>(r5);
            throw r4;
        L_0x0018:
            r0 = r3.mBrowserObj;
            r0 = android.support.v4.media.MediaBrowserCompatApi21.isConnected(r0);
            if (r0 != 0) goto L_0x002b;
        L_0x0020:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1;
            r1.<init>(r5, r4);
            r0.post(r1);
            return;
        L_0x002b:
            r0 = r3.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x003a;
        L_0x002f:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2;
            r1.<init>(r5, r4);
            r0.post(r1);
            return;
        L_0x003a:
            r0 = new android.support.v4.media.MediaBrowserCompat$ItemReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0049 }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0049 }
            r1.getMediaItem(r4, r0, r2);	 Catch:{ RemoteException -> 0x0049 }
            return;
        L_0x0049:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3;
            r1.<init>(r5, r4);
            r0.post(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.getItem(java.lang.String, android.support.v4.media.MediaBrowserCompat$ItemCallback):void");
        }

        public void search(@android.support.annotation.NonNull final java.lang.String r4, final android.os.Bundle r5, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.SearchCallback r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.isConnected();
            if (r0 != 0) goto L_0x000e;
        L_0x0006:
            r4 = new java.lang.IllegalStateException;
            r5 = "search() called while not connected";
            r4.<init>(r5);
            throw r4;
        L_0x000e:
            r0 = r3.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x001d;
        L_0x0012:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
            return;
        L_0x001d:
            r0 = new android.support.v4.media.MediaBrowserCompat$SearchResultReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r6, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x002c }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x002c }
            r1.search(r4, r5, r0, r2);	 Catch:{ RemoteException -> 0x002c }
            return;
        L_0x002c:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.search(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SearchCallback):void");
        }

        public void sendCustomAction(@android.support.annotation.NonNull final java.lang.String r4, final android.os.Bundle r5, @android.support.annotation.Nullable final android.support.v4.media.MediaBrowserCompat.CustomActionCallback r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.isConnected();
            if (r0 != 0) goto L_0x0027;
        L_0x0006:
            r6 = new java.lang.IllegalStateException;
            r0 = new java.lang.StringBuilder;
            r1 = "Cannot send a custom action (";
            r0.<init>(r1);
            r0.append(r4);
            r4 = ") with extras ";
            r0.append(r4);
            r0.append(r5);
            r4 = " because the browser is not connected to the service.";
            r0.append(r4);
            r4 = r0.toString();
            r6.<init>(r4);
            throw r6;
        L_0x0027:
            r0 = r3.mServiceBinderWrapper;
            if (r0 != 0) goto L_0x0037;
        L_0x002b:
            if (r6 == 0) goto L_0x0037;
        L_0x002d:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
        L_0x0037:
            r0 = new android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r6, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0046 }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0046 }
            r1.sendCustomAction(r4, r5, r0, r2);	 Catch:{ RemoteException -> 0x0046 }
            return;
        L_0x0046:
            r0 = new java.lang.StringBuilder;
            r1 = "Remote error sending a custom action: action=";
            r0.<init>(r1);
            r0.append(r4);
            r1 = ", extras=";
            r0.append(r1);
            r0.append(r5);
            if (r6 == 0) goto L_0x0064;
        L_0x005a:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
        L_0x0064:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.sendCustomAction(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$CustomActionCallback):void");
        }

        public void onConnected() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = r4.mBrowserObj;
            r0 = android.support.v4.media.MediaBrowserCompatApi21.getExtras(r0);
            if (r0 != 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r1 = "extra_messenger";
            r1 = android.support.v4.app.BundleCompat.getBinder(r0, r1);
            if (r1 == 0) goto L_0x0031;
        L_0x0011:
            r2 = new android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
            r3 = r4.mRootHints;
            r2.<init>(r1, r3);
            r4.mServiceBinderWrapper = r2;
            r1 = new android.os.Messenger;
            r2 = r4.mHandler;
            r1.<init>(r2);
            r4.mCallbacksMessenger = r1;
            r1 = r4.mHandler;
            r2 = r4.mCallbacksMessenger;
            r1.setCallbacksMessenger(r2);
            r1 = r4.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0031 }
            r2 = r4.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0031 }
            r1.registerCallbackMessenger(r2);	 Catch:{ RemoteException -> 0x0031 }
        L_0x0031:
            r1 = "extra_session_binder";
            r0 = android.support.v4.app.BundleCompat.getBinder(r0, r1);
            r0 = android.support.v4.media.session.IMediaSession.Stub.asInterface(r0);
            if (r0 == 0) goto L_0x0049;
        L_0x003d:
            r1 = r4.mBrowserObj;
            r1 = android.support.v4.media.MediaBrowserCompatApi21.getSessionToken(r1);
            r0 = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(r1, r0);
            r4.mMediaSessionToken = r0;
        L_0x0049:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.onConnected():void");
        }

        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
            if (this.mCallbacksMessenger == messenger) {
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    messenger = MediaBrowserCompat.DEBUG;
                    return;
                }
                messenger = subscription.getCallback(this.mContext, bundle);
                if (messenger != null) {
                    if (bundle == null) {
                        if (list == null) {
                            messenger.onError(str);
                        } else {
                            messenger.onChildrenLoaded(str, list);
                        }
                    } else if (list == null) {
                        messenger.onError(str, bundle);
                    } else {
                        messenger.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }
    }

    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private Token mMediaSessionToken;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState = 1;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap();

        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                postOrRun(new Runnable() {
                    public void run() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                        /*
                        r4 = this;
                        r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        if (r0 == 0) goto L_0x0021;
                    L_0x0004:
                        r0 = new java.lang.StringBuilder;
                        r1 = "MediaServiceConnection.onServiceConnected name=";
                        r0.<init>(r1);
                        r1 = r2;
                        r0.append(r1);
                        r1 = " binder=";
                        r0.append(r1);
                        r1 = r3;
                        r0.append(r1);
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0.dump();
                    L_0x0021:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = "onServiceConnected";
                        r0 = r0.isCurrent(r1);
                        if (r0 != 0) goto L_0x002c;
                    L_0x002b:
                        return;
                    L_0x002c:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = new android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper;
                        r2 = r3;
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r3 = r3.mRootHints;
                        r1.<init>(r2, r3);
                        r0.mServiceBinderWrapper = r1;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = new android.os.Messenger;
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = r2.mHandler;
                        r1.<init>(r2);
                        r0.mCallbacksMessenger = r1;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mHandler;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = r1.mCallbacksMessenger;
                        r0.setCallbacksMessenger(r1);
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = 2;
                        r0.mState = r1;
                        r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;	 Catch:{ RemoteException -> 0x0087 }
                        if (r0 == 0) goto L_0x0071;	 Catch:{ RemoteException -> 0x0087 }
                    L_0x006a:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x0087 }
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0087 }
                        r0.dump();	 Catch:{ RemoteException -> 0x0087 }
                    L_0x0071:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x0087 }
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0087 }
                        r0 = r0.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0087 }
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x0087 }
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0087 }
                        r1 = r1.mContext;	 Catch:{ RemoteException -> 0x0087 }
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;	 Catch:{ RemoteException -> 0x0087 }
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0087 }
                        r2 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0087 }
                        r0.connect(r1, r2);	 Catch:{ RemoteException -> 0x0087 }
                        return;
                    L_0x0087:
                        r0 = new java.lang.StringBuilder;
                        r1 = "RemoteException during connect for ";
                        r0.<init>(r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = r1.mServiceComponent;
                        r0.append(r1);
                        r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        if (r0 == 0) goto L_0x00a2;
                    L_0x009b:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0.dump();
                    L_0x00a2:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1.run():void");
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName componentName) {
                postOrRun(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder stringBuilder = new StringBuilder("MediaServiceConnection.onServiceDisconnected name=");
                            stringBuilder.append(componentName);
                            stringBuilder.append(" this=");
                            stringBuilder.append(this);
                            stringBuilder.append(" mServiceConnection=");
                            stringBuilder.append(MediaBrowserImplBase.this.mServiceConnection);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase.this.mServiceBinderWrapper = null;
                            MediaBrowserImplBase.this.mCallbacksMessenger = null;
                            MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
                            MediaBrowserImplBase.this.mState = 4;
                            MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }

            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            boolean isCurrent(String str) {
                if (MediaBrowserImplBase.this.mServiceConnection == this && MediaBrowserImplBase.this.mState != 0) {
                    if (MediaBrowserImplBase.this.mState != 1) {
                        return true;
                    }
                }
                if (!(MediaBrowserImplBase.this.mState == 0 || MediaBrowserImplBase.this.mState == 1)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(" for ");
                    stringBuilder.append(MediaBrowserImplBase.this.mServiceComponent);
                    stringBuilder.append(" with mServiceConnection=");
                    stringBuilder.append(MediaBrowserImplBase.this.mServiceConnection);
                    stringBuilder.append(" this=");
                    stringBuilder.append(this);
                }
                return null;
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.mServiceComponent = componentName;
                this.mCallback = connectionCallback;
                if (bundle == null) {
                    context = null;
                } else {
                    context = new Bundle(bundle);
                }
                this.mRootHints = context;
            }
        }

        public void connect() {
            if (this.mState == 0 || this.mState == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() {
                    public void run() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                        /*
                        r5 = this;
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mState;
                        if (r0 != 0) goto L_0x0007;
                    L_0x0006:
                        return;
                    L_0x0007:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = 2;
                        r0.mState = r1;
                        r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        if (r0 == 0) goto L_0x002e;
                    L_0x0010:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mServiceConnection;
                        if (r0 == 0) goto L_0x002e;
                    L_0x0016:
                        r0 = new java.lang.RuntimeException;
                        r1 = new java.lang.StringBuilder;
                        r2 = "mServiceConnection should be null. Instead it is ";
                        r1.<init>(r2);
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = r2.mServiceConnection;
                        r1.append(r2);
                        r1 = r1.toString();
                        r0.<init>(r1);
                        throw r0;
                    L_0x002e:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mServiceBinderWrapper;
                        if (r0 == 0) goto L_0x004c;
                    L_0x0034:
                        r0 = new java.lang.RuntimeException;
                        r1 = new java.lang.StringBuilder;
                        r2 = "mServiceBinderWrapper should be null. Instead it is ";
                        r1.<init>(r2);
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = r2.mServiceBinderWrapper;
                        r1.append(r2);
                        r1 = r1.toString();
                        r0.<init>(r1);
                        throw r0;
                    L_0x004c:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mCallbacksMessenger;
                        if (r0 == 0) goto L_0x006a;
                    L_0x0052:
                        r0 = new java.lang.RuntimeException;
                        r1 = new java.lang.StringBuilder;
                        r2 = "mCallbacksMessenger should be null. Instead it is ";
                        r1.<init>(r2);
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = r2.mCallbacksMessenger;
                        r1.append(r2);
                        r1 = r1.toString();
                        r0.<init>(r1);
                        throw r0;
                    L_0x006a:
                        r0 = new android.content.Intent;
                        r1 = "android.media.browse.MediaBrowserService";
                        r0.<init>(r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r1 = r1.mServiceComponent;
                        r0.setComponent(r1);
                        r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection;
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2.<init>();
                        r1.mServiceConnection = r2;
                        r1 = 0;
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ Exception -> 0x0092 }
                        r2 = r2.mContext;	 Catch:{ Exception -> 0x0092 }
                        r3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ Exception -> 0x0092 }
                        r3 = r3.mServiceConnection;	 Catch:{ Exception -> 0x0092 }
                        r4 = 1;	 Catch:{ Exception -> 0x0092 }
                        r0 = r2.bindService(r0, r3, r4);	 Catch:{ Exception -> 0x0092 }
                        goto L_0x00a1;
                    L_0x0092:
                        r0 = new java.lang.StringBuilder;
                        r2 = "Failed binding to service ";
                        r0.<init>(r2);
                        r2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r2 = r2.mServiceComponent;
                        r0.append(r2);
                        r0 = r1;
                    L_0x00a1:
                        if (r0 != 0) goto L_0x00af;
                    L_0x00a3:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0.forceCloseConnection();
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0 = r0.mCallback;
                        r0.onConnectionFailed();
                    L_0x00af:
                        r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                        if (r0 == 0) goto L_0x00b8;
                    L_0x00b3:
                        r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        r0.dump();
                    L_0x00b8:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1.run():void");
                    }
                });
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("connect() called while neigther disconnecting nor disconnected (state=");
            stringBuilder.append(getStateLabel(this.mState));
            stringBuilder.append(k.t);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() {
                public void run() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r2 = this;
                    r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r0 = r0.mCallbacksMessenger;
                    if (r0 == 0) goto L_0x0020;
                L_0x0006:
                    r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0012 }
                    r0 = r0.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0012 }
                    r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;	 Catch:{ RemoteException -> 0x0012 }
                    r1 = r1.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0012 }
                    r0.disconnect(r1);	 Catch:{ RemoteException -> 0x0012 }
                    goto L_0x0020;
                L_0x0012:
                    r0 = new java.lang.StringBuilder;
                    r1 = "RemoteException during connect for ";
                    r0.<init>(r1);
                    r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r1 = r1.mServiceComponent;
                    r0.append(r1);
                L_0x0020:
                    r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r0 = r0.mState;
                    r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r1.forceCloseConnection();
                    if (r0 == 0) goto L_0x002f;
                L_0x002b:
                    r1 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r1.mState = r0;
                L_0x002f:
                    r0 = android.support.v4.media.MediaBrowserCompat.DEBUG;
                    if (r0 == 0) goto L_0x0038;
                L_0x0033:
                    r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    r0.dump();
                L_0x0038:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2.run():void");
                }
            });
        }

        void forceCloseConnection() {
            if (this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public boolean isConnected() {
            return this.mState == 3;
        }

        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            StringBuilder stringBuilder = new StringBuilder("getServiceComponent() called while not connected (state=");
            stringBuilder.append(this.mState);
            stringBuilder.append(k.t);
            throw new IllegalStateException(stringBuilder.toString());
        }

        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            StringBuilder stringBuilder = new StringBuilder("getRoot() called while not connected(state=");
            stringBuilder.append(getStateLabel(this.mState));
            stringBuilder.append(k.t);
            throw new IllegalStateException(stringBuilder.toString());
        }

        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            StringBuilder stringBuilder = new StringBuilder("getExtras() called while not connected (state=");
            stringBuilder.append(getStateLabel(this.mState));
            stringBuilder.append(k.t);
            throw new IllegalStateException(stringBuilder.toString());
        }

        @NonNull
        public Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            StringBuilder stringBuilder = new StringBuilder("getSessionToken() called while not connected(state=");
            stringBuilder.append(this.mState);
            stringBuilder.append(k.t);
            throw new IllegalStateException(stringBuilder.toString());
        }

        public void subscribe(@android.support.annotation.NonNull java.lang.String r3, android.os.Bundle r4, @android.support.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mSubscriptions;
            r0 = r0.get(r3);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x0014;
        L_0x000a:
            r0 = new android.support.v4.media.MediaBrowserCompat$Subscription;
            r0.<init>();
            r1 = r2.mSubscriptions;
            r1.put(r3, r0);
        L_0x0014:
            if (r4 != 0) goto L_0x0018;
        L_0x0016:
            r4 = 0;
            goto L_0x001e;
        L_0x0018:
            r1 = new android.os.Bundle;
            r1.<init>(r4);
            r4 = r1;
        L_0x001e:
            r1 = r2.mContext;
            r0.putCallback(r1, r4, r5);
            r0 = r2.isConnected();
            if (r0 == 0) goto L_0x0035;
        L_0x0029:
            r0 = r2.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0035 }
            r5 = r5.mToken;	 Catch:{ RemoteException -> 0x0035 }
            r1 = r2.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0035 }
            r0.addSubscription(r3, r5, r4, r1);	 Catch:{ RemoteException -> 0x0035 }
            return;
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.subscribe(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void unsubscribe(@android.support.annotation.NonNull java.lang.String r8, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r7 = this;
            r0 = r7.mSubscriptions;
            r0 = r0.get(r8);
            r0 = (android.support.v4.media.MediaBrowserCompat.Subscription) r0;
            if (r0 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            if (r9 != 0) goto L_0x001c;
        L_0x000d:
            r1 = r7.isConnected();	 Catch:{ RemoteException -> 0x004c }
            if (r1 == 0) goto L_0x004c;	 Catch:{ RemoteException -> 0x004c }
        L_0x0013:
            r1 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x004c }
            r2 = 0;	 Catch:{ RemoteException -> 0x004c }
            r3 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x004c }
            r1.removeSubscription(r8, r2, r3);	 Catch:{ RemoteException -> 0x004c }
            goto L_0x004c;	 Catch:{ RemoteException -> 0x004c }
        L_0x001c:
            r1 = r0.getCallbacks();	 Catch:{ RemoteException -> 0x004c }
            r2 = r0.getOptionsList();	 Catch:{ RemoteException -> 0x004c }
            r3 = r1.size();	 Catch:{ RemoteException -> 0x004c }
            r3 = r3 + -1;	 Catch:{ RemoteException -> 0x004c }
        L_0x002a:
            if (r3 < 0) goto L_0x004c;	 Catch:{ RemoteException -> 0x004c }
        L_0x002c:
            r4 = r1.get(r3);	 Catch:{ RemoteException -> 0x004c }
            if (r4 != r9) goto L_0x0049;	 Catch:{ RemoteException -> 0x004c }
        L_0x0032:
            r4 = r7.isConnected();	 Catch:{ RemoteException -> 0x004c }
            if (r4 == 0) goto L_0x0043;	 Catch:{ RemoteException -> 0x004c }
        L_0x0038:
            r4 = r7.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x004c }
            r5 = r9.mToken;	 Catch:{ RemoteException -> 0x004c }
            r6 = r7.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x004c }
            r4.removeSubscription(r8, r5, r6);	 Catch:{ RemoteException -> 0x004c }
        L_0x0043:
            r1.remove(r3);	 Catch:{ RemoteException -> 0x004c }
            r2.remove(r3);	 Catch:{ RemoteException -> 0x004c }
        L_0x0049:
            r3 = r3 + -1;
            goto L_0x002a;
        L_0x004c:
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x0054;
        L_0x0052:
            if (r9 != 0) goto L_0x0059;
        L_0x0054:
            r9 = r7.mSubscriptions;
            r9.remove(r8);
        L_0x0059:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.unsubscribe(java.lang.String, android.support.v4.media.MediaBrowserCompat$SubscriptionCallback):void");
        }

        public void getItem(@android.support.annotation.NonNull final java.lang.String r4, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.ItemCallback r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = android.text.TextUtils.isEmpty(r4);
            if (r0 == 0) goto L_0x000e;
        L_0x0006:
            r4 = new java.lang.IllegalArgumentException;
            r5 = "mediaId is empty";
            r4.<init>(r5);
            throw r4;
        L_0x000e:
            if (r5 != 0) goto L_0x0018;
        L_0x0010:
            r4 = new java.lang.IllegalArgumentException;
            r5 = "cb is null";
            r4.<init>(r5);
            throw r4;
        L_0x0018:
            r0 = r3.isConnected();
            if (r0 != 0) goto L_0x0029;
        L_0x001e:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3;
            r1.<init>(r5, r4);
            r0.post(r1);
            return;
        L_0x0029:
            r0 = new android.support.v4.media.MediaBrowserCompat$ItemReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0038 }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0038 }
            r1.getMediaItem(r4, r0, r2);	 Catch:{ RemoteException -> 0x0038 }
            return;
        L_0x0038:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4;
            r1.<init>(r5, r4);
            r0.post(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.getItem(java.lang.String, android.support.v4.media.MediaBrowserCompat$ItemCallback):void");
        }

        public void search(@android.support.annotation.NonNull final java.lang.String r4, final android.os.Bundle r5, @android.support.annotation.NonNull final android.support.v4.media.MediaBrowserCompat.SearchCallback r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.isConnected();
            if (r0 != 0) goto L_0x0025;
        L_0x0006:
            r4 = new java.lang.IllegalStateException;
            r5 = new java.lang.StringBuilder;
            r6 = "search() called while not connected (state=";
            r5.<init>(r6);
            r6 = r3.mState;
            r6 = getStateLabel(r6);
            r5.append(r6);
            r6 = ")";
            r5.append(r6);
            r5 = r5.toString();
            r4.<init>(r5);
            throw r4;
        L_0x0025:
            r0 = new android.support.v4.media.MediaBrowserCompat$SearchResultReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r6, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0034 }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0034 }
            r1.search(r4, r5, r0, r2);	 Catch:{ RemoteException -> 0x0034 }
            return;
        L_0x0034:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.search(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$SearchCallback):void");
        }

        public void sendCustomAction(@android.support.annotation.NonNull final java.lang.String r4, final android.os.Bundle r5, @android.support.annotation.Nullable final android.support.v4.media.MediaBrowserCompat.CustomActionCallback r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r3.isConnected();
            if (r0 != 0) goto L_0x0027;
        L_0x0006:
            r6 = new java.lang.IllegalStateException;
            r0 = new java.lang.StringBuilder;
            r1 = "Cannot send a custom action (";
            r0.<init>(r1);
            r0.append(r4);
            r4 = ") with extras ";
            r0.append(r4);
            r0.append(r5);
            r4 = " because the browser is not connected to the service.";
            r0.append(r4);
            r4 = r0.toString();
            r6.<init>(r4);
            throw r6;
        L_0x0027:
            r0 = new android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver;
            r1 = r3.mHandler;
            r0.<init>(r4, r5, r6, r1);
            r1 = r3.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0036 }
            r2 = r3.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0036 }
            r1.sendCustomAction(r4, r5, r0, r2);	 Catch:{ RemoteException -> 0x0036 }
            return;
        L_0x0036:
            r0 = new java.lang.StringBuilder;
            r1 = "Remote error sending a custom action: action=";
            r0.<init>(r1);
            r0.append(r4);
            r1 = ", extras=";
            r0.append(r1);
            r0.append(r5);
            if (r6 == 0) goto L_0x0054;
        L_0x004a:
            r0 = r3.mHandler;
            r1 = new android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6;
            r1.<init>(r6, r4, r5);
            r0.post(r1);
        L_0x0054:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.sendCustomAction(java.lang.String, android.os.Bundle, android.support.v4.media.MediaBrowserCompat$CustomActionCallback):void");
        }

        public void onServiceConnected(android.os.Messenger r6, java.lang.String r7, android.support.v4.media.session.MediaSessionCompat.Token r8, android.os.Bundle r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = "onConnect";
            r6 = r5.isCurrent(r6, r0);
            if (r6 != 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r6 = r5.mState;
            r0 = 2;
            if (r6 == r0) goto L_0x0024;
        L_0x000e:
            r6 = new java.lang.StringBuilder;
            r7 = "onConnect from service while mState=";
            r6.<init>(r7);
            r7 = r5.mState;
            r7 = getStateLabel(r7);
            r6.append(r7);
            r7 = "... ignoring";
            r6.append(r7);
            return;
        L_0x0024:
            r5.mRootId = r7;
            r5.mMediaSessionToken = r8;
            r5.mExtras = r9;
            r6 = 3;
            r5.mState = r6;
            r6 = android.support.v4.media.MediaBrowserCompat.DEBUG;
            if (r6 == 0) goto L_0x0034;
        L_0x0031:
            r5.dump();
        L_0x0034:
            r6 = r5.mCallback;
            r6.onConnected();
            r6 = r5.mSubscriptions;	 Catch:{ RemoteException -> 0x0085 }
            r6 = r6.entrySet();	 Catch:{ RemoteException -> 0x0085 }
            r6 = r6.iterator();	 Catch:{ RemoteException -> 0x0085 }
        L_0x0043:
            r7 = r6.hasNext();	 Catch:{ RemoteException -> 0x0085 }
            if (r7 == 0) goto L_0x0084;	 Catch:{ RemoteException -> 0x0085 }
        L_0x0049:
            r7 = r6.next();	 Catch:{ RemoteException -> 0x0085 }
            r7 = (java.util.Map.Entry) r7;	 Catch:{ RemoteException -> 0x0085 }
            r8 = r7.getKey();	 Catch:{ RemoteException -> 0x0085 }
            r8 = (java.lang.String) r8;	 Catch:{ RemoteException -> 0x0085 }
            r7 = r7.getValue();	 Catch:{ RemoteException -> 0x0085 }
            r7 = (android.support.v4.media.MediaBrowserCompat.Subscription) r7;	 Catch:{ RemoteException -> 0x0085 }
            r9 = r7.getCallbacks();	 Catch:{ RemoteException -> 0x0085 }
            r7 = r7.getOptionsList();	 Catch:{ RemoteException -> 0x0085 }
            r0 = 0;	 Catch:{ RemoteException -> 0x0085 }
        L_0x0064:
            r1 = r9.size();	 Catch:{ RemoteException -> 0x0085 }
            if (r0 >= r1) goto L_0x0043;	 Catch:{ RemoteException -> 0x0085 }
        L_0x006a:
            r1 = r5.mServiceBinderWrapper;	 Catch:{ RemoteException -> 0x0085 }
            r2 = r9.get(r0);	 Catch:{ RemoteException -> 0x0085 }
            r2 = (android.support.v4.media.MediaBrowserCompat.SubscriptionCallback) r2;	 Catch:{ RemoteException -> 0x0085 }
            r2 = r2.mToken;	 Catch:{ RemoteException -> 0x0085 }
            r3 = r7.get(r0);	 Catch:{ RemoteException -> 0x0085 }
            r3 = (android.os.Bundle) r3;	 Catch:{ RemoteException -> 0x0085 }
            r4 = r5.mCallbacksMessenger;	 Catch:{ RemoteException -> 0x0085 }
            r1.addSubscription(r8, r2, r3, r4);	 Catch:{ RemoteException -> 0x0085 }
            r0 = r0 + 1;
            goto L_0x0064;
        L_0x0084:
            return;
        L_0x0085:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.onServiceConnected(android.os.Messenger, java.lang.String, android.support.v4.media.session.MediaSessionCompat$Token, android.os.Bundle):void");
        }

        public void onConnectionFailed(Messenger messenger) {
            new StringBuilder("onConnectFailed for ").append(this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed") != null) {
                if (this.mState != 2) {
                    messenger = new StringBuilder("onConnect from service while mState=");
                    messenger.append(getStateLabel(this.mState));
                    messenger.append("... ignoring");
                    return;
                }
                forceCloseConnection();
                this.mCallback.onConnectionFailed();
            }
        }

        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle) {
            if (isCurrent(messenger, "onLoadChildren") != null) {
                if (MediaBrowserCompat.DEBUG != null) {
                    messenger = new StringBuilder("onLoadChildren for ");
                    messenger.append(this.mServiceComponent);
                    messenger.append(" id=");
                    messenger.append(str);
                }
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    messenger = MediaBrowserCompat.DEBUG;
                    return;
                }
                messenger = subscription.getCallback(this.mContext, bundle);
                if (messenger != null) {
                    if (bundle == null) {
                        if (list == null) {
                            messenger.onError(str);
                        } else {
                            messenger.onChildrenLoaded(str, list);
                        }
                    } else if (list == null) {
                        messenger.onError(str, bundle);
                    } else {
                        messenger.onChildrenLoaded(str, list, bundle);
                    }
                }
            }
        }

        private static String getStateLabel(int i) {
            switch (i) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTING";
                case 1:
                    return "CONNECT_STATE_DISCONNECTED";
                case 2:
                    return "CONNECT_STATE_CONNECTING";
                case 3:
                    return "CONNECT_STATE_CONNECTED";
                case 4:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    StringBuilder stringBuilder = new StringBuilder("UNKNOWN/");
                    stringBuilder.append(i);
                    return stringBuilder.toString();
            }
        }

        private boolean isCurrent(Messenger messenger, String str) {
            if (this.mCallbacksMessenger == messenger && this.mState != null) {
                if (this.mState != 1) {
                    return true;
                }
            }
            if (!(this.mState == null || this.mState == 1)) {
                messenger = new StringBuilder();
                messenger.append(str);
                messenger.append(" for ");
                messenger.append(this.mServiceComponent);
                messenger.append(" with mCallbacksMessenger=");
                messenger.append(this.mCallbacksMessenger);
                messenger.append(" this=");
                messenger.append(this);
            }
            return null;
        }

        void dump() {
            new StringBuilder("  mServiceComponent=").append(this.mServiceComponent);
            new StringBuilder("  mCallback=").append(this.mCallback);
            new StringBuilder("  mRootHints=").append(this.mRootHints);
            new StringBuilder("  mState=").append(getStateLabel(this.mState));
            new StringBuilder("  mServiceConnection=").append(this.mServiceConnection);
            new StringBuilder("  mServiceBinderWrapper=").append(this.mServiceBinderWrapper);
            new StringBuilder("  mCallbacksMessenger=").append(this.mCallbacksMessenger);
            new StringBuilder("  mRootId=").append(this.mRootId);
            new StringBuilder("  mMediaSessionToken=").append(this.mMediaSessionToken);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        protected void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null) {
                if (bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) != 0) {
                    i = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
                    bundle = null;
                    if (i != 0) {
                        bundle = new ArrayList();
                        for (Object obj : i) {
                            bundle.add((MediaItem) obj);
                        }
                    }
                    this.mCallback.onSearchResult(this.mQuery, this.mExtras, bundle);
                    return;
                }
            }
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    @RequiresApi(23)
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                MediaBrowserCompatApi23.getItem(this.mBrowserObj, str, itemCallback.mItemCallbackObj);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    @RequiresApi(26)
    static class MediaBrowserImplApi24 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi24(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        public void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
            if (bundle == null) {
                MediaBrowserCompatApi21.subscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            } else {
                MediaBrowserCompatApi24.subscribe(this.mBrowserObj, str, bundle, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }

        public void unsubscribe(@NonNull String str, SubscriptionCallback subscriptionCallback) {
            if (subscriptionCallback == null) {
                MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, str);
            } else {
                MediaBrowserCompatApi24.unsubscribe(this.mBrowserObj, str, subscriptionCallback.mSubscriptionCallbackObj);
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (VERSION.SDK_INT >= 26) {
            this.mImpl = new MediaBrowserImplApi24(context, componentName, connectionCallback, bundle);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public final void connect() {
        this.mImpl.connect();
    }

    public final void disconnect() {
        this.mImpl.disconnect();
    }

    public final boolean isConnected() {
        return this.mImpl.isConnected();
    }

    @NonNull
    public final ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public final String getRoot() {
        return this.mImpl.getRoot();
    }

    @Nullable
    public final Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    @NonNull
    public final Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public final void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else {
            this.mImpl.subscribe(str, null, subscriptionCallback);
        }
    }

    public final void subscribe(@NonNull String str, @NonNull Bundle bundle, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        } else {
            this.mImpl.subscribe(str, bundle, subscriptionCallback);
        }
    }

    public final void unsubscribe(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public final void unsubscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        } else if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        } else {
            this.mImpl.unsubscribe(str, subscriptionCallback);
        }
    }

    public final void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    public final void search(@NonNull String str, Bundle bundle, @NonNull SearchCallback searchCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        } else if (searchCallback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        } else {
            this.mImpl.search(str, bundle, searchCallback);
        }
    }

    public final void sendCustomAction(@NonNull String str, Bundle bundle, @Nullable CustomActionCallback customActionCallback) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }
}
