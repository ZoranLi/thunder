package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaMetadataEditor;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.MediaMetadataCompat.Builder;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.IMediaSession.Stub;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.xunlei.common.new_ptl.pay.XLPayType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {
    static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    static final String ACTION_ARGUMENT_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED";
    static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    static final String ACTION_SET_SHUFFLE_MODE_ENABLED = "android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    static final String EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler = null;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        private WeakReference<MediaSessionImpl> mSessionImpl;

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            CallbackHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Callback.this.handleMediaPlayPauseKeySingleTapIfPending();
                }
            }
        }

        @RequiresApi(21)
        private class StubApi21 implements Callback {
            StubApi21() {
            }

            public void onCommand(java.lang.String r3, android.os.Bundle r4, android.os.ResultReceiver r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r2 = this;
                r0 = "android.support.v4.media.session.command.GET_EXTRA_BINDER";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = r3.equals(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                r1 = 0;	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r0 == 0) goto L_0x0035;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0009:
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.mSessionImpl;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.get();	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r3;	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r3 == 0) goto L_0x0034;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0017:
                r4 = new android.os.Bundle;	 Catch:{ BadParcelableException -> 0x00e4 }
                r4.<init>();	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.getSessionToken();	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.getExtraBinder();	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = "android.support.v4.media.session.EXTRA_BINDER";	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r3 != 0) goto L_0x0029;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0028:
                goto L_0x002d;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0029:
                r1 = r3.asBinder();	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x002d:
                android.support.v4.app.BundleCompat.putBinder(r4, r0, r1);	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = 0;	 Catch:{ BadParcelableException -> 0x00e4 }
                r5.send(r3, r4);	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0034:
                return;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0035:
                r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = r3.equals(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r0 == 0) goto L_0x0054;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x003d:
                r3 = android.support.v4.media.MediaDescriptionCompat.class;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.getClassLoader();	 Catch:{ BadParcelableException -> 0x00e4 }
                r4.setClassLoader(r3);	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = r4.getParcelable(r5);	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = (android.support.v4.media.MediaDescriptionCompat) r4;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3.onAddQueueItem(r4);	 Catch:{ BadParcelableException -> 0x00e4 }
                return;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0054:
                r0 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = r3.equals(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r0 == 0) goto L_0x0079;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x005c:
                r3 = android.support.v4.media.MediaDescriptionCompat.class;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.getClassLoader();	 Catch:{ BadParcelableException -> 0x00e4 }
                r4.setClassLoader(r3);	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = r4.getParcelable(r5);	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = (android.support.v4.media.MediaDescriptionCompat) r5;	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = "android.support.v4.media.session.command.ARGUMENT_INDEX";	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = r4.getInt(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                r3.onAddQueueItem(r5, r4);	 Catch:{ BadParcelableException -> 0x00e4 }
                return;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0079:
                r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = r3.equals(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r0 == 0) goto L_0x0098;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0081:
                r3 = android.support.v4.media.MediaDescriptionCompat.class;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.getClassLoader();	 Catch:{ BadParcelableException -> 0x00e4 }
                r4.setClassLoader(r3);	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = r4.getParcelable(r5);	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = (android.support.v4.media.MediaDescriptionCompat) r4;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3.onRemoveQueueItem(r4);	 Catch:{ BadParcelableException -> 0x00e4 }
                return;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x0098:
                r0 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = r3.equals(r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r0 == 0) goto L_0x00de;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00a0:
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.mSessionImpl;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.get();	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) r3;	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r3 == 0) goto L_0x00dd;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00ae:
                r5 = r3.mQueue;	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r5 == 0) goto L_0x00dd;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00b4:
                r5 = "android.support.v4.media.session.command.ARGUMENT_INDEX";	 Catch:{ BadParcelableException -> 0x00e4 }
                r0 = -1;	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = r4.getInt(r5, r0);	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r4 < 0) goto L_0x00d2;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00bd:
                r5 = r3.mQueue;	 Catch:{ BadParcelableException -> 0x00e4 }
                r5 = r5.size();	 Catch:{ BadParcelableException -> 0x00e4 }
                if (r4 >= r5) goto L_0x00d2;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00c7:
                r3 = r3.mQueue;	 Catch:{ BadParcelableException -> 0x00e4 }
                r3 = r3.get(r4);	 Catch:{ BadParcelableException -> 0x00e4 }
                r1 = r3;	 Catch:{ BadParcelableException -> 0x00e4 }
                r1 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r1;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00d2:
                if (r1 == 0) goto L_0x00dd;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00d4:
                r3 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r4 = r1.getDescription();	 Catch:{ BadParcelableException -> 0x00e4 }
                r3.onRemoveQueueItem(r4);	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00dd:
                return;	 Catch:{ BadParcelableException -> 0x00e4 }
            L_0x00de:
                r0 = android.support.v4.media.session.MediaSessionCompat.Callback.this;	 Catch:{ BadParcelableException -> 0x00e4 }
                r0.onCommand(r3, r4, r5);	 Catch:{ BadParcelableException -> 0x00e4 }
                return;
            L_0x00e4:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public boolean onMediaButtonEvent(Intent intent) {
                return Callback.this.onMediaButtonEvent(intent);
            }

            public void onPlay() {
                Callback.this.onPlay();
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                Callback.this.onPlayFromMediaId(str, bundle);
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                Callback.this.onPlayFromSearch(str, bundle);
            }

            public void onSkipToQueueItem(long j) {
                Callback.this.onSkipToQueueItem(j);
            }

            public void onPause() {
                Callback.this.onPause();
            }

            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            public void onFastForward() {
                Callback.this.onFastForward();
            }

            public void onRewind() {
                Callback.this.onRewind();
            }

            public void onStop() {
                Callback.this.onStop();
            }

            public void onSeekTo(long j) {
                Callback.this.onSeekTo(j);
            }

            public void onSetRating(Object obj) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj));
            }

            public void onSetRating(Object obj, Bundle bundle) {
                Callback.this.onSetRating(RatingCompat.fromRating(obj), bundle);
            }

            public void onCustomAction(String str, Bundle bundle) {
                if (str.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    Callback.this.onPlayFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), (Bundle) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS));
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE)) {
                    Callback.this.onPrepare();
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    Callback.this.onPrepareFromMediaId(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS));
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    Callback.this.onPrepareFromSearch(bundle.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS));
                } else if (str.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    Callback.this.onPrepareFromUri((Uri) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI), bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    Callback.this.onSetCaptioningEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    Callback.this.onSetRepeatMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
                    Callback.this.onSetShuffleModeEnabled(bundle.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE_ENABLED));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    Callback.this.onSetShuffleMode(bundle.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (str.equals(MediaSessionCompat.ACTION_SET_RATING)) {
                    bundle.setClassLoader(RatingCompat.class.getClassLoader());
                    Callback.this.onSetRating((RatingCompat) bundle.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS));
                } else {
                    Callback.this.onCustomAction(str, bundle);
                }
            }
        }

        @RequiresApi(23)
        private class StubApi23 extends StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            StubApi23() {
                super();
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        @RequiresApi(24)
        private class StubApi24 extends StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24.Callback {
            StubApi24() {
                super();
            }

            public void onPrepare() {
                Callback.this.onPrepare();
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                Callback.this.onPrepareFromMediaId(str, bundle);
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                Callback.this.onPrepareFromSearch(str, bundle);
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                Callback.this.onPrepareFromUri(uri, bundle);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        @Deprecated
        public void onSetShuffleModeEnabled(boolean z) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public Callback() {
            if (VERSION.SDK_INT >= 24) {
                this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24());
            } else if (VERSION.SDK_INT >= 23) {
                this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23());
            } else if (VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = null;
            }
        }

        private void setSessionImpl(MediaSessionImpl mediaSessionImpl, Handler handler) {
            this.mSessionImpl = new WeakReference(mediaSessionImpl);
            if (this.mCallbackHandler != null) {
                this.mCallbackHandler.removeCallbacksAndMessages(null);
            }
            this.mCallbackHandler = new CallbackHandler(handler.getLooper());
        }

        public boolean onMediaButtonEvent(Intent intent) {
            MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
            if (mediaSessionImpl != null) {
                if (this.mCallbackHandler != null) {
                    KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                    if (keyEvent != null) {
                        if (keyEvent.getAction() == 0) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 79 || keyCode == 85) {
                                if (keyEvent.getRepeatCount() > null) {
                                    handleMediaPlayPauseKeySingleTapIfPending();
                                } else if (this.mMediaPlayPauseKeyPending != null) {
                                    long j;
                                    this.mCallbackHandler.removeMessages(1);
                                    this.mMediaPlayPauseKeyPending = false;
                                    intent = mediaSessionImpl.getPlaybackState();
                                    if (intent == null) {
                                        j = 0;
                                    } else {
                                        j = intent.getActions();
                                    }
                                    if ((j & 32) != 0) {
                                        onSkipToNext();
                                    }
                                } else {
                                    this.mMediaPlayPauseKeyPending = true;
                                    this.mCallbackHandler.sendEmptyMessageDelayed(1, (long) ViewConfiguration.getDoubleTapTimeout());
                                }
                                return true;
                            }
                            handleMediaPlayPauseKeySingleTapIfPending();
                            return false;
                        }
                    }
                    return false;
                }
            }
            return false;
        }

        private void handleMediaPlayPauseKeySingleTapIfPending() {
            if (this.mMediaPlayPauseKeyPending) {
                boolean z = false;
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.mSessionImpl.get();
                if (mediaSessionImpl != null) {
                    long j;
                    PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                    if (playbackState == null) {
                        j = 0;
                    } else {
                        j = playbackState.getActions();
                    }
                    int i = (playbackState == null || playbackState.getState() != 3) ? false : 1;
                    int i2 = (j & 516) != 0 ? 1 : false;
                    if ((j & 514) != 0) {
                        z = true;
                    }
                    if (i == 0 || !r0) {
                        if (i == 0 && i2 != 0) {
                            onPlay();
                        }
                        return;
                    }
                    onPause();
                }
            }
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setCaptioningEnabled(boolean z);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(PendingIntent pendingIntent);

        void setShuffleMode(int i);

        void setShuffleModeEnabled(boolean z);
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new Creator<QueueItem>() {
            public final QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public final QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        public final int describeContents() {
            return 0;
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.mDescription = mediaDescriptionCompat;
                this.mId = j;
                this.mItem = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public final MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public final long getQueueId() {
            return this.mId;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }

        public final Object getQueueItem() {
            if (this.mItem == null) {
                if (VERSION.SDK_INT >= 21) {
                    this.mItem = QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
                    return this.mItem;
                }
            }
            return this.mItem;
        }

        public static QueueItem fromQueueItem(Object obj) {
            if (obj != null) {
                if (VERSION.SDK_INT >= 21) {
                    return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(QueueItem.getDescription(obj)), QueueItem.getQueueId(obj));
                }
            }
            return null;
        }

        public static List<QueueItem> fromQueueItemList(List<?> list) {
            if (list != null) {
                if (VERSION.SDK_INT >= 21) {
                    List<QueueItem> arrayList = new ArrayList();
                    for (Object fromQueueItem : list) {
                        arrayList.add(fromQueueItem(fromQueueItem));
                    }
                    return arrayList;
                }
            }
            return null;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaSession.QueueItem {Description=");
            stringBuilder.append(this.mDescription);
            stringBuilder.append(", Id=");
            stringBuilder.append(this.mId);
            stringBuilder.append(" }");
            return stringBuilder.toString();
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new Creator<ResultReceiverWrapper>() {
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public final ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        private ResultReceiver mResultReceiver;

        public final int describeContents() {
            return 0;
        }

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new Creator<Token>() {
            public final Token createFromParcel(Parcel parcel) {
                if (VERSION.SDK_INT >= 21) {
                    parcel = parcel.readParcelable(null);
                } else {
                    parcel = parcel.readStrongBinder();
                }
                return new Token(parcel);
            }

            public final Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private final IMediaSession mExtraBinder;
        private final Object mInner;

        public final int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, null);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
        }

        public static Token fromToken(Object obj) {
            return fromToken(obj, null);
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public static Token fromToken(Object obj, IMediaSession iMediaSession) {
            return (obj == null || VERSION.SDK_INT < 21) ? null : new Token(MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.mInner, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.mInner);
            }
        }

        public final int hashCode() {
            if (this.mInner == null) {
                return 0;
            }
            return this.mInner.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.mInner == null) {
                return token.mInner == null;
            } else {
                if (token.mInner == null) {
                    return false;
                }
                return this.mInner.equals(token.mInner);
            }
        }

        public final Object getToken() {
            return this.mInner;
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public final IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }
    }

    @RequiresApi(21)
    static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        private boolean mDestroyed = false;
        private final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks = new RemoteCallbackList();
        private MediaMetadataCompat mMetadata;
        private PlaybackStateCompat mPlaybackState;
        private List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        private final Object mSessionObj;
        int mShuffleMode;
        boolean mShuffleModeEnabled;
        private final Token mToken;

        class ExtraSession extends Stub {
            public List<QueueItem> getQueue() {
                return null;
            }

            ExtraSession() {
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (!MediaSessionImplApi21.this.mDestroyed) {
                    MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback);
                }
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }

            public String getPackageName() {
                throw new AssertionError();
            }

            public String getTag() {
                throw new AssertionError();
            }

            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            public long getFlags() {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void play() throws RemoteException {
                throw new AssertionError();
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            public void next() throws RemoteException {
                throw new AssertionError();
            }

            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            public void seekTo(long j) throws RemoteException {
                throw new AssertionError();
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void setCaptioningEnabled(boolean z) throws RemoteException {
                throw new AssertionError();
            }

            public void setRepeatMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            public void setShuffleModeEnabledDeprecated(boolean z) throws RemoteException {
                throw new AssertionError();
            }

            public void setShuffleMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.getStateWithUpdatedPosition(MediaSessionImplApi21.this.mPlaybackState, MediaSessionImplApi21.this.mMetadata);
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public int getRatingType() {
                return MediaSessionImplApi21.this.mRatingType;
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            public int getRepeatMode() {
                return MediaSessionImplApi21.this.mRepeatMode;
            }

            public boolean isShuffleModeEnabledDeprecated() {
                return MediaSessionImplApi21.this.mShuffleModeEnabled;
            }

            public int getShuffleMode() {
                return MediaSessionImplApi21.this.mShuffleMode;
            }

            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public MediaSessionImplApi21(Context context, String str) {
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, str);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession());
        }

        public MediaSessionImplApi21(Object obj) {
            this.mSessionObj = MediaSessionCompatApi21.verifySession(obj);
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj), new ExtraSession());
        }

        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
            if (callback != null) {
                callback.setSessionImpl(this, handler);
            }
        }

        public void setFlags(int i) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, i);
        }

        public void setPlaybackToLocal(int i) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
        }

        public void setActive(boolean z) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, z);
        }

        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        public void sendSessionEvent(java.lang.String r3, android.os.Bundle r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = android.os.Build.VERSION.SDK_INT;
            r1 = 23;
            if (r0 >= r1) goto L_0x0023;
        L_0x0006:
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onEvent(r3, r4);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r0 = r2.mExtraControllerCallbacks;
            r0.finishBroadcast();
        L_0x0023:
            r0 = r2.mSessionObj;
            android.support.v4.media.session.MediaSessionCompatApi21.sendSessionEvent(r0, r3, r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.sendSessionEvent(java.lang.String, android.os.Bundle):void");
        }

        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r2.mPlaybackState = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000a:
            if (r0 < 0) goto L_0x001a;
        L_0x000c:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onPlaybackStateChanged(r3);	 Catch:{ RemoteException -> 0x0017 }
        L_0x0017:
            r0 = r0 + -1;
            goto L_0x000a;
        L_0x001a:
            r0 = r2.mExtraControllerCallbacks;
            r0.finishBroadcast();
            r0 = r2.mSessionObj;
            if (r3 != 0) goto L_0x0025;
        L_0x0023:
            r3 = 0;
            goto L_0x0029;
        L_0x0025:
            r3 = r3.getPlaybackState();
        L_0x0029:
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackState(r0, r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setPlaybackState(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            Object obj = this.mSessionObj;
            if (mediaMetadataCompat == null) {
                mediaMetadataCompat = null;
            } else {
                mediaMetadataCompat = mediaMetadataCompat.getMediaMetadata();
            }
            MediaSessionCompatApi21.setMetadata(obj, mediaMetadataCompat);
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        public void setQueue(List<QueueItem> list) {
            List arrayList;
            this.mQueue = list;
            if (list != null) {
                arrayList = new ArrayList();
                for (QueueItem queueItem : list) {
                    arrayList.add(queueItem.getQueueItem());
                }
            } else {
                arrayList = null;
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        public void setQueueTitle(CharSequence charSequence) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        public void setRatingType(int i) {
            if (VERSION.SDK_INT < 22) {
                this.mRatingType = i;
            } else {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, i);
            }
        }

        public void setCaptioningEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mCaptioningEnabled;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mCaptioningEnabled = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onCaptioningEnabledChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setCaptioningEnabled(boolean):void");
        }

        public void setRepeatMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mRepeatMode;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mRepeatMode = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onRepeatModeChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setRepeatMode(int):void");
        }

        public void setShuffleModeEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mShuffleModeEnabled;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mShuffleModeEnabled = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChangedDeprecated(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setShuffleModeEnabled(boolean):void");
        }

        public void setShuffleMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mShuffleMode;
            if (r0 == r3) goto L_0x0023;
        L_0x0004:
            r2.mShuffleMode = r3;
            r0 = r2.mExtraControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x000e:
            if (r0 < 0) goto L_0x001e;
        L_0x0010:
            r1 = r2.mExtraControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChanged(r3);	 Catch:{ RemoteException -> 0x001b }
        L_0x001b:
            r0 = r0 + -1;
            goto L_0x000e;
        L_0x001e:
            r3 = r2.mExtraControllerCallbacks;
            r3.finishBroadcast();
        L_0x0023:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.setShuffleMode(int):void");
        }

        public void setExtras(Bundle bundle) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        public Object getMediaSession() {
            return this.mSessionObj;
        }

        public String getCallingPackage() {
            if (VERSION.SDK_INT < 24) {
                return null;
            }
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList();
        boolean mDestroyed = false;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        int mLocalStream;
        final Object mLock = new Object();
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        boolean mShuffleModeEnabled;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private android.support.v4.media.VolumeProviderCompat.Callback mVolumeCallback = new android.support.v4.media.VolumeProviderCompat.Callback() {
            public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
                if (MediaSessionImplBase.this.mVolumeProvider == volumeProviderCompat) {
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
                }
            }
        };
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_SHUFFLE_MODE_ENABLED = 24;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void post(int i, Object obj, Bundle bundle) {
                i = obtainMessage(i, obj);
                i.setData(bundle);
                i.sendToTarget();
            }

            public void post(int i, Object obj) {
                obtainMessage(i, obj).sendToTarget();
            }

            public void post(int i) {
                post(i, null);
            }

            public void post(int i, Object obj, int i2) {
                obtainMessage(i, i2, 0, obj).sendToTarget();
            }

            public void handleMessage(Message message) {
                Callback callback = MediaSessionImplBase.this.mCallback;
                if (callback != null) {
                    switch (message.what) {
                        case 1:
                            Command command = (Command) message.obj;
                            callback.onCommand(command.command, command.extras, command.stub);
                            return;
                        case 2:
                            MediaSessionImplBase.this.adjustVolume(message.arg1, 0);
                            return;
                        case 3:
                            callback.onPrepare();
                            return;
                        case 4:
                            callback.onPrepareFromMediaId((String) message.obj, message.getData());
                            return;
                        case 5:
                            callback.onPrepareFromSearch((String) message.obj, message.getData());
                            return;
                        case 6:
                            callback.onPrepareFromUri((Uri) message.obj, message.getData());
                            return;
                        case 7:
                            callback.onPlay();
                            return;
                        case 8:
                            callback.onPlayFromMediaId((String) message.obj, message.getData());
                            return;
                        case 9:
                            callback.onPlayFromSearch((String) message.obj, message.getData());
                            return;
                        case 10:
                            callback.onPlayFromUri((Uri) message.obj, message.getData());
                            return;
                        case 11:
                            callback.onSkipToQueueItem(((Long) message.obj).longValue());
                            return;
                        case 12:
                            callback.onPause();
                            return;
                        case 13:
                            callback.onStop();
                            return;
                        case 14:
                            callback.onSkipToNext();
                            return;
                        case 15:
                            callback.onSkipToPrevious();
                            return;
                        case 16:
                            callback.onFastForward();
                            return;
                        case 17:
                            callback.onRewind();
                            return;
                        case 18:
                            callback.onSeekTo(((Long) message.obj).longValue());
                            return;
                        case 19:
                            callback.onSetRating((RatingCompat) message.obj);
                            return;
                        case 20:
                            callback.onCustomAction((String) message.obj, message.getData());
                            return;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, callback);
                                return;
                            }
                            break;
                        case 22:
                            MediaSessionImplBase.this.setVolumeTo(message.arg1, 0);
                            return;
                        case 23:
                            callback.onSetRepeatMode(message.arg1);
                            return;
                        case 24:
                            callback.onSetShuffleModeEnabled(((Boolean) message.obj).booleanValue());
                            return;
                        case 25:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj);
                            return;
                        case 26:
                            callback.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                            return;
                        case 27:
                            callback.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                            return;
                        case 28:
                            if (MediaSessionImplBase.this.mQueue != null) {
                                message = (message.arg1 < 0 || message.arg1 >= MediaSessionImplBase.this.mQueue.size()) ? null : (QueueItem) MediaSessionImplBase.this.mQueue.get(message.arg1);
                                if (message != null) {
                                    callback.onRemoveQueueItem(message.getDescription());
                                }
                                return;
                            }
                            break;
                        case 29:
                            callback.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                            return;
                        case 30:
                            callback.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            callback.onSetRating((RatingCompat) message.obj, message.getData());
                            return;
                        default:
                            break;
                    }
                }
            }

            private void onMediaButtonEvent(KeyEvent keyEvent, Callback callback) {
                if (keyEvent != null) {
                    if (keyEvent.getAction() == 0) {
                        long actions = MediaSessionImplBase.this.mState == null ? 0 : MediaSessionImplBase.this.mState.getActions();
                        keyEvent = keyEvent.getKeyCode();
                        switch (keyEvent) {
                            case 86:
                                if ((actions & 1) != 0) {
                                    callback.onStop();
                                    return;
                                }
                                break;
                            case 87:
                                if ((actions & 32) != 0) {
                                    callback.onSkipToNext();
                                    return;
                                }
                                break;
                            case 88:
                                if ((actions & 16) != 0) {
                                    callback.onSkipToPrevious();
                                    return;
                                }
                                break;
                            case 89:
                                if ((actions & 8) != 0) {
                                    callback.onRewind();
                                    break;
                                }
                                break;
                            case 90:
                                if ((actions & 64) != 0) {
                                    callback.onFastForward();
                                    return;
                                }
                                break;
                            default:
                                switch (keyEvent) {
                                    case 126:
                                        if ((actions & 4) != 0) {
                                            callback.onPlay();
                                            return;
                                        }
                                        break;
                                    case 127:
                                        if ((actions & 2) != 0) {
                                            callback.onPause();
                                            return;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                        }
                    }
                }
            }
        }

        class MediaSessionStub extends Stub {
            MediaSessionStub() {
            }

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                MediaSessionImplBase.this.postToHandler(1, new Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = true;
                if ((MediaSessionImplBase.this.mFlags & 1) == 0) {
                    z = false;
                }
                if (z) {
                    MediaSessionImplBase.this.postToHandler(21, (Object) keyEvent);
                }
                return z;
            }

            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                /*
                r1 = this;
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r0 = r0.mDestroyed;
                if (r0 == 0) goto L_0x000b;
            L_0x0006:
                r2.onSessionDestroyed();	 Catch:{ Exception -> 0x000a }
                return;
            L_0x000a:
                return;
            L_0x000b:
                r0 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                r0 = r0.mControllerCallbacks;
                r0.register(r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub.registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback):void");
            }

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }

            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = (long) MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int maxVolume;
                int currentVolume;
                int i3;
                synchronized (MediaSessionImplBase.this.mLock) {
                    i = MediaSessionImplBase.this.mVolumeType;
                    i2 = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat volumeProviderCompat = MediaSessionImplBase.this.mVolumeProvider;
                    int i4 = 2;
                    if (i == 2) {
                        i4 = volumeProviderCompat.getVolumeControl();
                        maxVolume = volumeProviderCompat.getMaxVolume();
                        currentVolume = volumeProviderCompat.getCurrentVolume();
                        i3 = maxVolume;
                    } else {
                        i3 = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(i2);
                        currentVolume = MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                    }
                    maxVolume = i4;
                }
                return new ParcelableVolumeInfo(i, i2, maxVolume, i3, currentVolume);
            }

            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            public void prepare() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(3);
            }

            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(4, (Object) str, bundle);
            }

            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(5, (Object) str, bundle);
            }

            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(6, (Object) uri, bundle);
            }

            public void play() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(7);
            }

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(8, (Object) str, bundle);
            }

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(9, (Object) str, bundle);
            }

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(10, (Object) uri, bundle);
            }

            public void skipToQueueItem(long j) {
                MediaSessionImplBase.this.postToHandler(11, Long.valueOf(j));
            }

            public void pause() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(12);
            }

            public void stop() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(13);
            }

            public void next() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(14);
            }

            public void previous() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(15);
            }

            public void fastForward() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(16);
            }

            public void rewind() throws RemoteException {
                MediaSessionImplBase.this.postToHandler(17);
            }

            public void seekTo(long j) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(18, Long.valueOf(j));
            }

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(19, (Object) ratingCompat);
            }

            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(31, (Object) ratingCompat, bundle);
            }

            public void setCaptioningEnabled(boolean z) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(29, Boolean.valueOf(z));
            }

            public void setRepeatMode(int i) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(23, i);
            }

            public void setShuffleModeEnabledDeprecated(boolean z) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(24, Boolean.valueOf(z));
            }

            public void setShuffleMode(int i) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(30, i);
            }

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                MediaSessionImplBase.this.postToHandler(20, (Object) str, bundle);
            }

            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.mLock) {
                    playbackStateCompat = MediaSessionImplBase.this.mState;
                    mediaMetadataCompat = MediaSessionImplBase.this.mMetadata;
                }
                return MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                MediaSessionImplBase.this.postToHandler(25, (Object) mediaDescriptionCompat);
            }

            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                MediaSessionImplBase.this.postToHandler(26, (Object) mediaDescriptionCompat, i);
            }

            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                MediaSessionImplBase.this.postToHandler(27, (Object) mediaDescriptionCompat);
            }

            public void removeQueueItemAt(int i) {
                MediaSessionImplBase.this.postToHandler(28, i);
            }

            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.mCaptioningEnabled;
            }

            public int getRepeatMode() {
                return MediaSessionImplBase.this.mRepeatMode;
            }

            public boolean isShuffleModeEnabledDeprecated() {
                return MediaSessionImplBase.this.mShuffleModeEnabled;
            }

            public int getShuffleMode() {
                return MediaSessionImplBase.this.mShuffleMode;
            }

            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }
        }

        public String getCallingPackage() {
            return null;
        }

        public Object getMediaSession() {
            return null;
        }

        int getRccStateFromState(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int i = (j & 1) != 0 ? 32 : 0;
            if ((j & 2) != 0) {
                i |= 16;
            }
            if ((j & 4) != 0) {
                i |= 4;
            }
            if ((j & 8) != 0) {
                i |= 2;
            }
            if ((j & 16) != 0) {
                i |= 1;
            }
            if ((j & 32) != 0) {
                i |= 128;
            }
            if ((j & 64) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        public Object getRemoteControlClient() {
            return null;
        }

        public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        }

        public MediaSessionImplBase(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = str;
            this.mMediaButtonReceiverComponentName = componentName;
            this.mMediaButtonReceiverIntent = pendingIntent;
            this.mStub = new MediaSessionStub();
            this.mToken = new Token(this.mStub);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(pendingIntent);
        }

        public void setCallback(Callback callback, Handler handler) {
            this.mCallback = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new Handler();
                }
                synchronized (this.mLock) {
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacksAndMessages(null);
                    }
                    this.mHandler = new MessageHandler(handler.getLooper());
                    this.mCallback.setSessionImpl(this, handler);
                }
            }
        }

        void postToHandler(int i) {
            postToHandler(i, null);
        }

        void postToHandler(int i, int i2) {
            postToHandler(i, null, i2);
        }

        void postToHandler(int i, Object obj) {
            postToHandler(i, obj, null);
        }

        void postToHandler(int i, Object obj, int i2) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    this.mHandler.post(i, obj, i2);
                }
            }
        }

        void postToHandler(int i, Object obj, Bundle bundle) {
            synchronized (this.mLock) {
                if (this.mHandler != null) {
                    this.mHandler.post(i, obj, bundle);
                }
            }
        }

        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i;
            }
            update();
        }

        public void setPlaybackToLocal(int i) {
            if (this.mVolumeProvider != 0) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 1;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProviderCompat;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.mVolumeCallback);
        }

        public void setActive(boolean z) {
            if (z != this.mIsActive) {
                this.mIsActive = z;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        public boolean isActive() {
            return this.mIsActive;
        }

        public void sendSessionEvent(String str, Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public Token getSessionToken() {
            return this.mToken;
        }

        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (!this.mIsActive) {
                return;
            }
            if (playbackStateCompat == null) {
                this.mRcc.setPlaybackState(0);
                this.mRcc.setTransportControlFlags(0);
                return;
            }
            setRccState(playbackStateCompat);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
        }

        public PlaybackStateCompat getPlaybackState() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        void setRccState(PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new Builder(mediaMetadataCompat, MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                if (mediaMetadataCompat == null) {
                    mediaMetadataCompat = null;
                } else {
                    mediaMetadataCompat = mediaMetadataCompat.getBundle();
                }
                buildRccMetadata(mediaMetadataCompat).apply();
            }
        }

        MetadataEditor buildRccMetadata(Bundle bundle) {
            MetadataEditor editMetadata = this.mRcc.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            Bitmap bitmap;
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ART)) {
                bitmap = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                bitmap = (Bitmap) bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                editMetadata.putString(1, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                editMetadata.putString(13, bundle.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                editMetadata.putString(2, bundle.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                editMetadata.putString(3, bundle.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                editMetadata.putString(15, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                editMetadata.putString(4, bundle.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DATE)) {
                editMetadata.putString(5, bundle.getString(MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                editMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                editMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE)) {
                editMetadata.putString(6, bundle.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE)) {
                editMetadata.putString(7, bundle.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                editMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER)) {
                editMetadata.putString(11, bundle.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return editMetadata;
        }

        public void setSessionActivity(PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        public void setQueue(List<QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        public void setShuffleModeEnabled(boolean z) {
            if (this.mShuffleModeEnabled != z) {
                this.mShuffleModeEnabled = z;
                sendShuffleModeEnabled(z);
            }
        }

        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        boolean update() {
            if (this.mIsActive) {
                if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                    registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = true;
                } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                    unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                    this.mAudioManager.registerRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = true;
                    return true;
                } else if (this.mIsRccRegistered && (this.mFlags & 2) == 0) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            } else {
                if (this.mIsMbrRegistered) {
                    unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (this.mIsRccRegistered) {
                    this.mRcc.setPlaybackState(0);
                    this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                    this.mIsRccRegistered = false;
                }
            }
            return false;
        }

        void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        void adjustVolume(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
            } else if (this.mVolumeProvider != 0) {
                this.mVolumeProvider.onAdjustVolume(i);
            }
        }

        void setVolumeTo(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
            } else if (this.mVolumeProvider != 0) {
                this.mVolumeProvider.onSetVolumeTo(i);
            }
        }

        void sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onVolumeInfoChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo):void");
        }

        private void sendSessionDestroyed() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onSessionDestroyed();	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r0 = r2.mControllerCallbacks;
            r0.finishBroadcast();
            r0 = r2.mControllerCallbacks;
            r0.kill();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendSessionDestroyed():void");
        }

        private void sendEvent(java.lang.String r3, android.os.Bundle r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onEvent(r3, r4);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendEvent(java.lang.String, android.os.Bundle):void");
        }

        private void sendState(android.support.v4.media.session.PlaybackStateCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onPlaybackStateChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendState(android.support.v4.media.session.PlaybackStateCompat):void");
        }

        private void sendMetadata(android.support.v4.media.MediaMetadataCompat r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onMetadataChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendMetadata(android.support.v4.media.MediaMetadataCompat):void");
        }

        private void sendQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onQueueChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendQueue(java.util.List):void");
        }

        private void sendQueueTitle(java.lang.CharSequence r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onQueueTitleChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendQueueTitle(java.lang.CharSequence):void");
        }

        private void sendCaptioningEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onCaptioningEnabledChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendCaptioningEnabled(boolean):void");
        }

        private void sendRepeatMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onRepeatModeChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendRepeatMode(int):void");
        }

        private void sendShuffleModeEnabled(boolean r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChangedDeprecated(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendShuffleModeEnabled(boolean):void");
        }

        private void sendShuffleMode(int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onShuffleModeChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendShuffleMode(int):void");
        }

        private void sendExtras(android.os.Bundle r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            r0 = r2.mControllerCallbacks;
            r0 = r0.beginBroadcast();
            r0 = r0 + -1;
        L_0x0008:
            if (r0 < 0) goto L_0x0018;
        L_0x000a:
            r1 = r2.mControllerCallbacks;
            r1 = r1.getBroadcastItem(r0);
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;
            r1.onExtrasChanged(r3);	 Catch:{ RemoteException -> 0x0015 }
        L_0x0015:
            r0 = r0 + -1;
            goto L_0x0008;
        L_0x0018:
            r3 = r2.mControllerCallbacks;
            r3.finishBroadcast();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.sendExtras(android.os.Bundle):void");
        }
    }

    @RequiresApi(18)
    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        MediaSessionImplApi18(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
                return;
            }
            this.mRcc.setPlaybackPositionUpdateListener(new OnPlaybackPositionUpdateListener() {
                public void onPlaybackPositionUpdate(long j) {
                    MediaSessionImplApi18.this.postToHandler(18, (Object) Long.valueOf(j));
                }
            });
        }

        void setRccState(PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (((float) j) * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        void registerMediaButtonEventReceiver(android.app.PendingIntent r2, android.content.ComponentName r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = sIsMbrPendingIntentSupported;
            if (r0 == 0) goto L_0x000d;
        L_0x0004:
            r0 = r1.mAudioManager;	 Catch:{ NullPointerException -> 0x000a }
            r0.registerMediaButtonEventReceiver(r2);	 Catch:{ NullPointerException -> 0x000a }
            goto L_0x000d;
        L_0x000a:
            r0 = 0;
            sIsMbrPendingIntentSupported = r0;
        L_0x000d:
            r0 = sIsMbrPendingIntentSupported;
            if (r0 != 0) goto L_0x0014;
        L_0x0011:
            super.registerMediaButtonEventReceiver(r2, r3);
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.registerMediaButtonEventReceiver(android.app.PendingIntent, android.content.ComponentName):void");
        }

        void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    @RequiresApi(19)
    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        public void setCallback(Callback callback, Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener(null);
                return;
            }
            this.mRcc.setMetadataUpdateListener(new OnMetadataUpdateListener() {
                public void onMetadataUpdate(int i, Object obj) {
                    if (i == XLPayType.XL_WX_PAY && (obj instanceof Rating) != 0) {
                        MediaSessionImplApi19.this.postToHandler(19, RatingCompat.fromRating(obj));
                    }
                }
            });
        }

        int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        MetadataEditor buildRccMetadata(Bundle bundle) {
            MediaMetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            if (((this.mState == null ? 0 : this.mState.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(XLPayType.XL_WX_PAY);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
                buildRccMetadata.putLong(8, bundle.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_RATING)) {
                buildRccMetadata.putObject(101, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                buildRccMetadata.putObject(XLPayType.XL_WX_PAY, bundle.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return buildRccMetadata;
        }
    }

    public MediaSessionCompat(Context context, String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this.mActiveListeners = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            if (componentName == null) {
                componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context);
            }
            if (componentName != null && pendingIntent == null) {
                pendingIntent = new Intent("android.intent.action.MEDIA_BUTTON");
                pendingIntent.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(context, 0, pendingIntent, 0);
            }
            if (VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaSessionImplApi21(context, str);
                setCallback(new Callback() {
                });
                this.mImpl.setMediaButtonReceiver(pendingIntent);
            } else if (VERSION.SDK_INT >= 19) {
                this.mImpl = new MediaSessionImplApi19(context, str, componentName, pendingIntent);
            } else if (VERSION.SDK_INT >= 18) {
                this.mImpl = new MediaSessionImplApi18(context, str, componentName, pendingIntent);
            } else {
                this.mImpl = new MediaSessionImplBase(context, str, componentName, pendingIntent);
            }
            this.mController = new MediaControllerCompat(context, this);
            if (sMaxBitmapSize == null) {
                sMaxBitmapSize = (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics());
            }
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = mediaSessionImpl;
        if (VERSION.SDK_INT >= 21 && MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession()) == null) {
            setCallback(new Callback() {
            });
        }
        this.mController = new MediaControllerCompat(context, this);
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setSessionActivity(PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setMediaButtonReceiver(PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        z = this.mActiveListeners.iterator();
        while (z.hasNext()) {
            ((OnActiveChangeListener) z.next()).onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void sendSessionEvent(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void release() {
        this.mImpl.release();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setQueue(List<QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setRepeatMode(int i) {
        this.mImpl.setRepeatMode(i);
    }

    @Deprecated
    public void setShuffleModeEnabled(boolean z) {
        this.mImpl.setShuffleModeEnabled(z);
    }

    public void setShuffleMode(int i) {
        this.mImpl.setShuffleMode(i);
    }

    public void setExtras(Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(onActiveChangeListener);
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public static MediaSessionCompat fromMediaSession(Context context, Object obj) {
        return (context == null || obj == null || VERSION.SDK_INT < 21) ? null : new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
    }

    private static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat != null) {
            long j = -1;
            if (playbackStateCompat.getPosition() != -1) {
                if (playbackStateCompat.getState() == 3 || playbackStateCompat.getState() == 4 || playbackStateCompat.getState() == 5) {
                    long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
                    if (lastPositionUpdateTime > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * ((float) (elapsedRealtime - lastPositionUpdateTime)))) + playbackStateCompat.getPosition();
                        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                            j = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                        }
                        long j2 = (j < 0 || playbackSpeed <= j) ? playbackSpeed < 0 ? 0 : playbackSpeed : j;
                        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), j2, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                    }
                }
                return playbackStateCompat;
            }
        }
        return playbackStateCompat;
    }
}
