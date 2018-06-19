package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.SupportActivity;
import android.support.v4.app.SupportActivity.ExtraData;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback.Stub;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {
    static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final HashSet<Callback> mRegisteredCallbacks = new HashSet();
    private final Token mToken;

    public static abstract class Callback implements DeathRecipient {
        private final Object mCallbackObj;
        MessageHandler mHandler;
        boolean mHasExtraCallback;

        private class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_SHUFFLE_MODE_DEPRECATED = 10;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered = null;

            MessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.mRegistered) {
                    switch (message.what) {
                        case 1:
                            Callback.this.onSessionEvent((String) message.obj, message.getData());
                            return;
                        case 2:
                            Callback.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            Callback.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            Callback.this.onAudioInfoChanged((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            Callback.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            Callback.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Callback.this.onExtrasChanged((Bundle) message.obj);
                            return;
                        case 8:
                            Callback.this.onSessionDestroyed();
                            break;
                        case 9:
                            Callback.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            Callback.this.onShuffleModeChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            Callback.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            Callback.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        default:
                            break;
                    }
                }
            }
        }

        private static class StubApi21 implements android.support.v4.media.session.MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> mCallback;

            StubApi21(Callback callback) {
                this.mCallback = new WeakReference(callback);
            }

            public void onSessionDestroyed() {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback == null) {
                    return;
                }
                if (!callback.mHasExtraCallback || VERSION.SDK_INT >= 23) {
                    callback.onSessionEvent(str, bundle);
                }
            }

            public void onPlaybackStateChanged(Object obj) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null && !callback.mHasExtraCallback) {
                    callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(obj));
                }
            }

            public void onMetadataChanged(Object obj) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(obj));
                }
            }

            public void onQueueChanged(List<?> list) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onQueueChanged(QueueItem.fromQueueItemList(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }

            public void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5) {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }
        }

        private static class StubCompat extends Stub {
            private final WeakReference<Callback> mCallback;

            StubCompat(Callback callback) {
                this.mCallback = new WeakReference(callback);
            }

            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(1, str, bundle);
                }
            }

            public void onSessionDestroyed() throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(8, null, null);
                }
            }

            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(2, playbackStateCompat, null);
                }
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(3, mediaMetadataCompat, null);
                }
            }

            public void onQueueChanged(List<QueueItem> list) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(5, list, null);
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(6, charSequence, null);
                }
            }

            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(11, Boolean.valueOf(z), null);
                }
            }

            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(9, Integer.valueOf(i), null);
                }
            }

            public void onShuffleModeChangedDeprecated(boolean z) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(10, Boolean.valueOf(z), null);
                }
            }

            public void onShuffleModeChanged(int i) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(12, Integer.valueOf(i), null);
                }
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    callback.postToHandler(7, bundle, null);
                }
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = (Callback) this.mCallback.get();
                if (callback != null) {
                    Object obj;
                    if (parcelableVolumeInfo != null) {
                        PlaybackInfo playbackInfo = new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
                    } else {
                        obj = null;
                    }
                    callback.postToHandler(4, obj, null);
                }
            }
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
        }

        public void onCaptioningEnabledChanged(boolean z) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        }

        public void onQueueChanged(List<QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onShuffleModeChanged(int i) {
        }

        @Deprecated
        public void onShuffleModeChanged(boolean z) {
        }

        public Callback() {
            if (VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
            } else {
                this.mCallbackObj = new StubCompat(this);
            }
        }

        public void binderDied() {
            onSessionDestroyed();
        }

        void setHandler(Handler handler) {
            if (handler != null) {
                this.mHandler = new MessageHandler(handler.getLooper());
                this.mHandler.mRegistered = true;
            } else if (this.mHandler != null) {
                this.mHandler.mRegistered = false;
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        }

        void postToHandler(int i, Object obj, Bundle bundle) {
            if (this.mHandler != null) {
                i = this.mHandler.obtainMessage(i, obj);
                i.setData(bundle);
                i.sendToTarget();
            }
        }
    }

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i);

        void adjustVolume(int i, int i2);

        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isShuffleModeEnabled();

        void registerCallback(Callback callback, Handler handler);

        void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void setVolumeTo(int i, int i2);

        void unregisterCallback(Callback callback);
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.mPlaybackType = i;
            this.mAudioStream = i2;
            this.mVolumeControl = i3;
            this.mMaxVolume = i4;
            this.mCurrentVolume = i5;
        }

        public final int getPlaybackType() {
            return this.mPlaybackType;
        }

        public final int getAudioStream() {
            return this.mAudioStream;
        }

        public final int getVolumeControl() {
            return this.mVolumeControl;
        }

        public final int getMaxVolume() {
            return this.mMaxVolume;
        }

        public final int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String str, Bundle bundle);

        public abstract void playFromSearch(String str, Bundle bundle);

        public abstract void playFromUri(Uri uri, Bundle bundle);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String str, Bundle bundle);

        public abstract void prepareFromSearch(String str, Bundle bundle);

        public abstract void prepareFromUri(Uri uri, Bundle bundle);

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void sendCustomAction(CustomAction customAction, Bundle bundle);

        public abstract void sendCustomAction(String str, Bundle bundle);

        public abstract void setCaptioningEnabled(boolean z);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void setRating(RatingCompat ratingCompat, Bundle bundle);

        public abstract void setRepeatMode(int i);

        public abstract void setShuffleMode(int i);

        @Deprecated
        public abstract void setShuffleModeEnabled(boolean z);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long j);

        public abstract void stop();

        TransportControls() {
        }
    }

    private static class MediaControllerExtraData extends ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat mediaControllerCompat) {
            this.mMediaController = mediaControllerCompat;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    @RequiresApi(21)
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap = new HashMap();
        protected final Object mControllerObj;
        private IMediaSession mExtraBinder;
        private final List<Callback> mPendingCallbacks = new ArrayList();

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21, Handler handler) {
                super(handler);
                this.mMediaControllerImpl = new WeakReference(mediaControllerImplApi21);
            }

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.mMediaControllerImpl.get();
                if (mediaControllerImplApi21 != null) {
                    if (bundle != null) {
                        mediaControllerImplApi21.mExtraBinder = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                        mediaControllerImplApi21.processPendingCallbacks();
                    }
                }
            }
        }

        private static class ExtraCallback extends StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueChanged(List<QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat mediaSessionCompat) {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, mediaSessionCompat.getSessionToken().getToken());
            this.mExtraBinder = mediaSessionCompat.getSessionToken().getExtraBinder();
            if (this.mExtraBinder == null) {
                requestExtraBinder();
            }
        }

        public MediaControllerImplApi21(Context context, Token token) throws RemoteException {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, token.getToken());
            if (this.mControllerObj == null) {
                throw new RemoteException();
            }
            this.mExtraBinder = token.getExtraBinder();
            if (this.mExtraBinder == null) {
                requestExtraBinder();
            }
        }

        public final void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback r3, android.os.Handler r4) {
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
            r0 = r2.mControllerObj;
            r1 = r3.mCallbackObj;
            android.support.v4.media.session.MediaControllerCompatApi21.registerCallback(r0, r1, r4);
            r4 = r2.mExtraBinder;
            if (r4 == 0) goto L_0x0021;
        L_0x000d:
            r4 = new android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback;
            r4.<init>(r3);
            r0 = r2.mCallbackMap;
            r0.put(r3, r4);
            r0 = 1;
            r3.mHasExtraCallback = r0;
            r3 = r2.mExtraBinder;	 Catch:{ RemoteException -> 0x0020 }
            r3.registerCallbackListener(r4);	 Catch:{ RemoteException -> 0x0020 }
            return;
        L_0x0020:
            return;
        L_0x0021:
            r4 = r2.mPendingCallbacks;
            monitor-enter(r4);
            r0 = r2.mPendingCallbacks;	 Catch:{ all -> 0x002b }
            r0.add(r3);	 Catch:{ all -> 0x002b }
            monitor-exit(r4);	 Catch:{ all -> 0x002b }
            return;	 Catch:{ all -> 0x002b }
        L_0x002b:
            r3 = move-exception;	 Catch:{ all -> 0x002b }
            monitor-exit(r4);	 Catch:{ all -> 0x002b }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.registerCallback(android.support.v4.media.session.MediaControllerCompat$Callback, android.os.Handler):void");
        }

        public final void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback r3) {
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
            r0 = r2.mControllerObj;
            r1 = r3.mCallbackObj;
            android.support.v4.media.session.MediaControllerCompatApi21.unregisterCallback(r0, r1);
            r0 = r2.mExtraBinder;
            if (r0 == 0) goto L_0x001d;
        L_0x000d:
            r0 = r2.mCallbackMap;	 Catch:{ RemoteException -> 0x001c }
            r3 = r0.remove(r3);	 Catch:{ RemoteException -> 0x001c }
            r3 = (android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.ExtraCallback) r3;	 Catch:{ RemoteException -> 0x001c }
            if (r3 == 0) goto L_0x001c;	 Catch:{ RemoteException -> 0x001c }
        L_0x0017:
            r0 = r2.mExtraBinder;	 Catch:{ RemoteException -> 0x001c }
            r0.unregisterCallbackListener(r3);	 Catch:{ RemoteException -> 0x001c }
        L_0x001c:
            return;
        L_0x001d:
            r0 = r2.mPendingCallbacks;
            monitor-enter(r0);
            r1 = r2.mPendingCallbacks;	 Catch:{ all -> 0x0027 }
            r1.remove(r3);	 Catch:{ all -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return;	 Catch:{ all -> 0x0027 }
        L_0x0027:
            r3 = move-exception;	 Catch:{ all -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.unregisterCallback(android.support.v4.media.session.MediaControllerCompat$Callback):void");
        }

        public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, keyEvent);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi21(transportControls) : null;
        }

        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
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
            r0 = r1.mExtraBinder;
            if (r0 == 0) goto L_0x000b;
        L_0x0004:
            r0 = r1.mExtraBinder;	 Catch:{ RemoteException -> 0x000b }
            r0 = r0.getPlaybackState();	 Catch:{ RemoteException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = r1.mControllerObj;
            r0 = android.support.v4.media.session.MediaControllerCompatApi21.getPlaybackState(r0);
            if (r0 == 0) goto L_0x0018;
        L_0x0013:
            r0 = android.support.v4.media.session.PlaybackStateCompat.fromPlaybackState(r0);
            return r0;
        L_0x0018:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.getPlaybackState():android.support.v4.media.session.PlaybackStateCompat");
        }

        public MediaMetadataCompat getMetadata() {
            Object metadata = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            return metadata != null ? MediaMetadataCompat.fromMediaMetadata(metadata) : null;
        }

        public List<QueueItem> getQueue() {
            List queue = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            return queue != null ? QueueItem.fromQueueItemList(queue) : null;
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, bundle, null);
        }

        public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            bundle.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, i);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, bundle, 0);
        }

        public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((getFlags() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, mediaDescriptionCompat);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, bundle, null);
        }

        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        public int getRatingType() {
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
            r1 = 22;
            if (r0 >= r1) goto L_0x0011;
        L_0x0006:
            r0 = r2.mExtraBinder;
            if (r0 == 0) goto L_0x0011;
        L_0x000a:
            r0 = r2.mExtraBinder;	 Catch:{ RemoteException -> 0x0011 }
            r0 = r0.getRatingType();	 Catch:{ RemoteException -> 0x0011 }
            return r0;
        L_0x0011:
            r0 = r2.mControllerObj;
            r0 = android.support.v4.media.session.MediaControllerCompatApi21.getRatingType(r0);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.getRatingType():int");
        }

        public boolean isCaptioningEnabled() {
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
            r0 = r1.mExtraBinder;
            if (r0 == 0) goto L_0x000b;
        L_0x0004:
            r0 = r1.mExtraBinder;	 Catch:{ RemoteException -> 0x000b }
            r0 = r0.isCaptioningEnabled();	 Catch:{ RemoteException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.isCaptioningEnabled():boolean");
        }

        public int getRepeatMode() {
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
            r0 = r1.mExtraBinder;
            if (r0 == 0) goto L_0x000b;
        L_0x0004:
            r0 = r1.mExtraBinder;	 Catch:{ RemoteException -> 0x000b }
            r0 = r0.getRepeatMode();	 Catch:{ RemoteException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.getRepeatMode():int");
        }

        public boolean isShuffleModeEnabled() {
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
            r0 = r1.mExtraBinder;
            if (r0 == 0) goto L_0x000b;
        L_0x0004:
            r0 = r1.mExtraBinder;	 Catch:{ RemoteException -> 0x000b }
            r0 = r0.isShuffleModeEnabledDeprecated();	 Catch:{ RemoteException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.isShuffleModeEnabled():boolean");
        }

        public int getShuffleMode() {
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
            r0 = r1.mExtraBinder;
            if (r0 == 0) goto L_0x000b;
        L_0x0004:
            r0 = r1.mExtraBinder;	 Catch:{ RemoteException -> 0x000b }
            r0 = r0.getShuffleMode();	 Catch:{ RemoteException -> 0x000b }
            return r0;
        L_0x000b:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.getShuffleMode():int");
        }

        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        public PlaybackInfo getPlaybackInfo() {
            Object playbackInfo = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            return playbackInfo != null ? new PlaybackInfo(android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(playbackInfo), android.support.v4.media.session.MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(playbackInfo)) : null;
        }

        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        public void setVolumeTo(int i, int i2) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, i, i2);
        }

        public void adjustVolume(int i, int i2) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, i, i2);
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, str, bundle, resultReceiver);
        }

        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        public Object getMediaController() {
            return this.mControllerObj;
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this, new Handler()));
        }

        private void processPendingCallbacks() {
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
            r5 = this;
            r0 = r5.mExtraBinder;
            if (r0 != 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r5.mPendingCallbacks;
            monitor-enter(r0);
            r1 = r5.mPendingCallbacks;	 Catch:{ all -> 0x0034 }
            r1 = r1.iterator();	 Catch:{ all -> 0x0034 }
        L_0x000e:
            r2 = r1.hasNext();	 Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x002d;	 Catch:{ all -> 0x0034 }
        L_0x0014:
            r2 = r1.next();	 Catch:{ all -> 0x0034 }
            r2 = (android.support.v4.media.session.MediaControllerCompat.Callback) r2;	 Catch:{ all -> 0x0034 }
            r3 = new android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback;	 Catch:{ all -> 0x0034 }
            r3.<init>(r2);	 Catch:{ all -> 0x0034 }
            r4 = r5.mCallbackMap;	 Catch:{ all -> 0x0034 }
            r4.put(r2, r3);	 Catch:{ all -> 0x0034 }
            r4 = 1;	 Catch:{ all -> 0x0034 }
            r2.mHasExtraCallback = r4;	 Catch:{ all -> 0x0034 }
            r2 = r5.mExtraBinder;	 Catch:{ RemoteException -> 0x002d }
            r2.registerCallbackListener(r3);	 Catch:{ RemoteException -> 0x002d }
            goto L_0x000e;
        L_0x002d:
            r1 = r5.mPendingCallbacks;	 Catch:{ all -> 0x0034 }
            r1.clear();	 Catch:{ all -> 0x0034 }
            monitor-exit(r0);	 Catch:{ all -> 0x0034 }
            return;	 Catch:{ all -> 0x0034 }
        L_0x0034:
            r1 = move-exception;	 Catch:{ all -> 0x0034 }
            monitor-exit(r0);	 Catch:{ all -> 0x0034 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21.processPendingCallbacks():void");
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private TransportControls mTransportControls;

        public Object getMediaController() {
            return null;
        }

        public MediaControllerImplBase(Token token) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.getToken());
        }

        public void registerCallback(android.support.v4.media.session.MediaControllerCompat.Callback r2, android.os.Handler r3) {
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
            if (r2 != 0) goto L_0x000a;
        L_0x0002:
            r2 = new java.lang.IllegalArgumentException;
            r3 = "callback may not be null.";
            r2.<init>(r3);
            throw r2;
        L_0x000a:
            r3 = r1.mBinder;	 Catch:{ RemoteException -> 0x0020 }
            r3 = r3.asBinder();	 Catch:{ RemoteException -> 0x0020 }
            r0 = 0;	 Catch:{ RemoteException -> 0x0020 }
            r3.linkToDeath(r2, r0);	 Catch:{ RemoteException -> 0x0020 }
            r3 = r1.mBinder;	 Catch:{ RemoteException -> 0x0020 }
            r0 = r2.mCallbackObj;	 Catch:{ RemoteException -> 0x0020 }
            r0 = (android.support.v4.media.session.IMediaControllerCallback) r0;	 Catch:{ RemoteException -> 0x0020 }
            r3.registerCallbackListener(r0);	 Catch:{ RemoteException -> 0x0020 }
            return;
        L_0x0020:
            r2.onSessionDestroyed();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.registerCallback(android.support.v4.media.session.MediaControllerCompat$Callback, android.os.Handler):void");
        }

        public void unregisterCallback(android.support.v4.media.session.MediaControllerCompat.Callback r3) {
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
            if (r3 != 0) goto L_0x000a;
        L_0x0002:
            r3 = new java.lang.IllegalArgumentException;
            r0 = "callback may not be null.";
            r3.<init>(r0);
            throw r3;
        L_0x000a:
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x0020 }
            r1 = r3.mCallbackObj;	 Catch:{ RemoteException -> 0x0020 }
            r1 = (android.support.v4.media.session.IMediaControllerCallback) r1;	 Catch:{ RemoteException -> 0x0020 }
            r0.unregisterCallbackListener(r1);	 Catch:{ RemoteException -> 0x0020 }
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x0020 }
            r0 = r0.asBinder();	 Catch:{ RemoteException -> 0x0020 }
            r1 = 0;	 Catch:{ RemoteException -> 0x0020 }
            r0.unlinkToDeath(r3, r1);	 Catch:{ RemoteException -> 0x0020 }
            return;
        L_0x0020:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.unregisterCallback(android.support.v4.media.session.MediaControllerCompat$Callback):void");
        }

        public boolean dispatchMediaButtonEvent(android.view.KeyEvent r2) {
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
            if (r2 != 0) goto L_0x000a;
        L_0x0002:
            r2 = new java.lang.IllegalArgumentException;
            r0 = "event may not be null.";
            r2.<init>(r0);
            throw r2;
        L_0x000a:
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x000f }
            r0.sendMediaButton(r2);	 Catch:{ RemoteException -> 0x000f }
        L_0x000f:
            r2 = 0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.dispatchMediaButtonEvent(android.view.KeyEvent):boolean");
        }

        public TransportControls getTransportControls() {
            if (this.mTransportControls == null) {
                this.mTransportControls = new TransportControlsBase(this.mBinder);
            }
            return this.mTransportControls;
        }

        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getPlaybackState();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getPlaybackState():android.support.v4.media.session.PlaybackStateCompat");
        }

        public android.support.v4.media.MediaMetadataCompat getMetadata() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getMetadata();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getMetadata():android.support.v4.media.MediaMetadataCompat");
        }

        public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getQueue();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getQueue():java.util.List<android.support.v4.media.session.MediaSessionCompat$QueueItem>");
        }

        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat r7) {
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
            r6 = this;
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0 = r0.getFlags();	 Catch:{ RemoteException -> 0x001e }
            r2 = 4;	 Catch:{ RemoteException -> 0x001e }
            r4 = r0 & r2;	 Catch:{ RemoteException -> 0x001e }
            r0 = 0;	 Catch:{ RemoteException -> 0x001e }
            r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ RemoteException -> 0x001e }
            if (r2 != 0) goto L_0x0018;	 Catch:{ RemoteException -> 0x001e }
        L_0x0010:
            r7 = new java.lang.UnsupportedOperationException;	 Catch:{ RemoteException -> 0x001e }
            r0 = "This session doesn't support queue management operations";	 Catch:{ RemoteException -> 0x001e }
            r7.<init>(r0);	 Catch:{ RemoteException -> 0x001e }
            throw r7;	 Catch:{ RemoteException -> 0x001e }
        L_0x0018:
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0.addQueueItem(r7);	 Catch:{ RemoteException -> 0x001e }
            return;
        L_0x001e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.addQueueItem(android.support.v4.media.MediaDescriptionCompat):void");
        }

        public void addQueueItem(android.support.v4.media.MediaDescriptionCompat r7, int r8) {
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
            r6 = this;
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0 = r0.getFlags();	 Catch:{ RemoteException -> 0x001e }
            r2 = 4;	 Catch:{ RemoteException -> 0x001e }
            r4 = r0 & r2;	 Catch:{ RemoteException -> 0x001e }
            r0 = 0;	 Catch:{ RemoteException -> 0x001e }
            r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ RemoteException -> 0x001e }
            if (r2 != 0) goto L_0x0018;	 Catch:{ RemoteException -> 0x001e }
        L_0x0010:
            r7 = new java.lang.UnsupportedOperationException;	 Catch:{ RemoteException -> 0x001e }
            r8 = "This session doesn't support queue management operations";	 Catch:{ RemoteException -> 0x001e }
            r7.<init>(r8);	 Catch:{ RemoteException -> 0x001e }
            throw r7;	 Catch:{ RemoteException -> 0x001e }
        L_0x0018:
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0.addQueueItemAt(r7, r8);	 Catch:{ RemoteException -> 0x001e }
            return;
        L_0x001e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.addQueueItem(android.support.v4.media.MediaDescriptionCompat, int):void");
        }

        public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat r7) {
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
            r6 = this;
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0 = r0.getFlags();	 Catch:{ RemoteException -> 0x001e }
            r2 = 4;	 Catch:{ RemoteException -> 0x001e }
            r4 = r0 & r2;	 Catch:{ RemoteException -> 0x001e }
            r0 = 0;	 Catch:{ RemoteException -> 0x001e }
            r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ RemoteException -> 0x001e }
            if (r2 != 0) goto L_0x0018;	 Catch:{ RemoteException -> 0x001e }
        L_0x0010:
            r7 = new java.lang.UnsupportedOperationException;	 Catch:{ RemoteException -> 0x001e }
            r0 = "This session doesn't support queue management operations";	 Catch:{ RemoteException -> 0x001e }
            r7.<init>(r0);	 Catch:{ RemoteException -> 0x001e }
            throw r7;	 Catch:{ RemoteException -> 0x001e }
        L_0x0018:
            r0 = r6.mBinder;	 Catch:{ RemoteException -> 0x001e }
            r0.removeQueueItem(r7);	 Catch:{ RemoteException -> 0x001e }
            return;
        L_0x001e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.removeQueueItem(android.support.v4.media.MediaDescriptionCompat):void");
        }

        public java.lang.CharSequence getQueueTitle() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getQueueTitle();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getQueueTitle():java.lang.CharSequence");
        }

        public android.os.Bundle getExtras() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getExtras();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getExtras():android.os.Bundle");
        }

        public int getRatingType() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getRatingType();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getRatingType():int");
        }

        public boolean isCaptioningEnabled() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.isCaptioningEnabled();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.isCaptioningEnabled():boolean");
        }

        public int getRepeatMode() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getRepeatMode();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getRepeatMode():int");
        }

        public boolean isShuffleModeEnabled() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.isShuffleModeEnabledDeprecated();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.isShuffleModeEnabled():boolean");
        }

        public int getShuffleMode() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getShuffleMode();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getShuffleMode():int");
        }

        public long getFlags() {
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
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getFlags();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getFlags():long");
        }

        public android.support.v4.media.session.MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
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
            r8 = this;
            r0 = r8.mBinder;	 Catch:{ RemoteException -> 0x0017 }
            r0 = r0.getVolumeAttributes();	 Catch:{ RemoteException -> 0x0017 }
            r7 = new android.support.v4.media.session.MediaControllerCompat$PlaybackInfo;	 Catch:{ RemoteException -> 0x0017 }
            r2 = r0.volumeType;	 Catch:{ RemoteException -> 0x0017 }
            r3 = r0.audioStream;	 Catch:{ RemoteException -> 0x0017 }
            r4 = r0.controlType;	 Catch:{ RemoteException -> 0x0017 }
            r5 = r0.maxVolume;	 Catch:{ RemoteException -> 0x0017 }
            r6 = r0.currentVolume;	 Catch:{ RemoteException -> 0x0017 }
            r1 = r7;	 Catch:{ RemoteException -> 0x0017 }
            r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x0017 }
            return r7;
        L_0x0017:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getPlaybackInfo():android.support.v4.media.session.MediaControllerCompat$PlaybackInfo");
        }

        public android.app.PendingIntent getSessionActivity() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getLaunchPendingIntent();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getSessionActivity():android.app.PendingIntent");
        }

        public void setVolumeTo(int r3, int r4) {
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
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r1 = 0;	 Catch:{ RemoteException -> 0x0007 }
            r0.setVolumeTo(r3, r4, r1);	 Catch:{ RemoteException -> 0x0007 }
            return;
        L_0x0007:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.setVolumeTo(int, int):void");
        }

        public void adjustVolume(int r3, int r4) {
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
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r1 = 0;	 Catch:{ RemoteException -> 0x0007 }
            r0.adjustVolume(r3, r4, r1);	 Catch:{ RemoteException -> 0x0007 }
            return;
        L_0x0007:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.adjustVolume(int, int):void");
        }

        public void sendCommand(java.lang.String r3, android.os.Bundle r4, android.os.ResultReceiver r5) {
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
            r0 = r2.mBinder;	 Catch:{ RemoteException -> 0x000b }
            r1 = new android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;	 Catch:{ RemoteException -> 0x000b }
            r1.<init>(r5);	 Catch:{ RemoteException -> 0x000b }
            r0.sendCommand(r3, r4, r1);	 Catch:{ RemoteException -> 0x000b }
            return;
        L_0x000b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.sendCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
        }

        public java.lang.String getPackageName() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0007 }
            r0 = r0.getPackageName();	 Catch:{ RemoteException -> 0x0007 }
            return r0;
        L_0x0007:
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.MediaControllerImplBase.getPackageName():java.lang.String");
        }
    }

    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object obj) {
            this.mControlsObj = obj;
        }

        public void prepare() {
            sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", str);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }

        public void play() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        public void pause() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        public void stop() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        public void seekTo(long j) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, j);
        }

        public void fastForward() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        public void rewind() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        public void skipToNext() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        public void skipToPrevious() {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        public void setRating(RatingCompat ratingCompat) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, ratingCompat != null ? ratingCompat.getRating() : null);
        }

        public void setRating(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", ratingCompat);
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
        }

        public void setCaptioningEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", z);
            sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
        }

        public void setRepeatMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        public void setShuffleModeEnabled(boolean z) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE_ENABLED", z);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE_ENABLED", bundle);
        }

        public void setShuffleMode(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i);
            sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        public void playFromMediaId(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, str, bundle);
        }

        public void playFromSearch(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, str, bundle);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            if (uri != null) {
                if (!Uri.EMPTY.equals(uri)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", uri);
                    bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
                    sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
                    return;
                }
            }
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        public void skipToQueueItem(long j) {
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, j);
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(customAction.getAction(), bundle);
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, customAction.getAction(), bundle);
        }

        public void sendCustomAction(String str, Bundle bundle) {
            MediaControllerCompat.validateCustomAction(str, bundle);
            android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, str, bundle);
        }
    }

    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession iMediaSession) {
            this.mBinder = iMediaSession;
        }

        public void prepare() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.prepare();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.prepare():void");
        }

        public void prepareFromMediaId(java.lang.String r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.prepareFromMediaId(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.prepareFromMediaId(java.lang.String, android.os.Bundle):void");
        }

        public void prepareFromSearch(java.lang.String r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.prepareFromSearch(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.prepareFromSearch(java.lang.String, android.os.Bundle):void");
        }

        public void prepareFromUri(android.net.Uri r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.prepareFromUri(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.prepareFromUri(android.net.Uri, android.os.Bundle):void");
        }

        public void play() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.play();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.play():void");
        }

        public void playFromMediaId(java.lang.String r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.playFromMediaId(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.playFromMediaId(java.lang.String, android.os.Bundle):void");
        }

        public void playFromSearch(java.lang.String r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.playFromSearch(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.playFromSearch(java.lang.String, android.os.Bundle):void");
        }

        public void playFromUri(android.net.Uri r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.playFromUri(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.playFromUri(android.net.Uri, android.os.Bundle):void");
        }

        public void skipToQueueItem(long r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.skipToQueueItem(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.skipToQueueItem(long):void");
        }

        public void pause() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.pause();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.pause():void");
        }

        public void stop() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.stop();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.stop():void");
        }

        public void seekTo(long r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.seekTo(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.seekTo(long):void");
        }

        public void fastForward() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.fastForward();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.fastForward():void");
        }

        public void skipToNext() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.next();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.skipToNext():void");
        }

        public void rewind() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.rewind();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.rewind():void");
        }

        public void skipToPrevious() {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.previous();	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.skipToPrevious():void");
        }

        public void setRating(android.support.v4.media.RatingCompat r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.rate(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setRating(android.support.v4.media.RatingCompat):void");
        }

        public void setRating(android.support.v4.media.RatingCompat r2, android.os.Bundle r3) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.rateWithExtras(r2, r3);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setRating(android.support.v4.media.RatingCompat, android.os.Bundle):void");
        }

        public void setCaptioningEnabled(boolean r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.setCaptioningEnabled(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setCaptioningEnabled(boolean):void");
        }

        public void setRepeatMode(int r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.setRepeatMode(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setRepeatMode(int):void");
        }

        public void setShuffleModeEnabled(boolean r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.setShuffleModeEnabledDeprecated(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setShuffleModeEnabled(boolean):void");
        }

        public void setShuffleMode(int r2) {
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
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0006 }
            r0.setShuffleMode(r2);	 Catch:{ RemoteException -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.setShuffleMode(int):void");
        }

        public void sendCustomAction(CustomAction customAction, Bundle bundle) {
            sendCustomAction(customAction.getAction(), bundle);
        }

        public void sendCustomAction(java.lang.String r2, android.os.Bundle r3) {
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
            android.support.v4.media.session.MediaControllerCompat.validateCustomAction(r2, r3);
            r0 = r1.mBinder;	 Catch:{ RemoteException -> 0x0009 }
            r0.sendCustomAction(r2, r3);	 Catch:{ RemoteException -> 0x0009 }
            return;
        L_0x0009:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.TransportControlsBase.sendCustomAction(java.lang.String, android.os.Bundle):void");
        }
    }

    @RequiresApi(23)
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public MediaControllerImplApi23(Context context, Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi23(transportControls) : null;
        }
    }

    @RequiresApi(23)
    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object obj) {
            super(obj);
        }

        public void playFromUri(Uri uri, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, uri, bundle);
        }
    }

    @RequiresApi(24)
    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat mediaSessionCompat) {
            super(context, mediaSessionCompat);
        }

        public MediaControllerImplApi24(Context context, Token token) throws RemoteException {
            super(context, token);
        }

        public TransportControls getTransportControls() {
            Object transportControls = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            return transportControls != null ? new TransportControlsApi24(transportControls) : null;
        }
    }

    @RequiresApi(24)
    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object obj) {
            super(obj);
        }

        public void prepare() {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        public void prepareFromMediaId(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, str, bundle);
        }

        public void prepareFromSearch(String str, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, str, bundle);
        }

        public void prepareFromUri(Uri uri, Bundle bundle) {
            android.support.v4.media.session.MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, uri, bundle);
        }
    }

    public static void setMediaController(@NonNull Activity activity, MediaControllerCompat mediaControllerCompat) {
        if (activity instanceof SupportActivity) {
            ((SupportActivity) activity).putExtraData(new MediaControllerExtraData(mediaControllerCompat));
        }
        if (VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (mediaControllerCompat != null) {
                obj = MediaControllerCompatApi21.fromToken(activity, mediaControllerCompat.getSessionToken().getToken());
            }
            MediaControllerCompatApi21.setMediaController(activity, obj);
        }
    }

    public static android.support.v4.media.session.MediaControllerCompat getMediaController(@android.support.annotation.NonNull android.app.Activity r3) {
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
        r0 = r3 instanceof android.support.v4.app.SupportActivity;
        r1 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x0005:
        r3 = (android.support.v4.app.SupportActivity) r3;
        r0 = android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData.class;
        r3 = r3.getExtraData(r0);
        r3 = (android.support.v4.media.session.MediaControllerCompat.MediaControllerExtraData) r3;
        if (r3 == 0) goto L_0x0016;
    L_0x0011:
        r3 = r3.getMediaController();
        return r3;
    L_0x0016:
        return r1;
    L_0x0017:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r0 < r2) goto L_0x0032;
    L_0x001d:
        r0 = android.support.v4.media.session.MediaControllerCompatApi21.getMediaController(r3);
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        return r1;
    L_0x0024:
        r0 = android.support.v4.media.session.MediaControllerCompatApi21.getSessionToken(r0);
        r2 = new android.support.v4.media.session.MediaControllerCompat;	 Catch:{ RemoteException -> 0x0032 }
        r0 = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(r0);	 Catch:{ RemoteException -> 0x0032 }
        r2.<init>(r3, r0);	 Catch:{ RemoteException -> 0x0032 }
        return r2;
    L_0x0032:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaControllerCompat.getMediaController(android.app.Activity):android.support.v4.media.session.MediaControllerCompat");
    }

    private static void validateCustomAction(String str, Bundle bundle) {
        if (str != null) {
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1348483723) {
                if (hashCode == 503011406) {
                    if (str.equals(MediaSessionCompat.ACTION_UNFOLLOW)) {
                        obj = 1;
                    }
                }
            } else if (str.equals(MediaSessionCompat.ACTION_FOLLOW)) {
                obj = null;
            }
            switch (obj) {
                case null:
                case 1:
                    if (bundle == null || bundle.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE) == null) {
                        StringBuilder stringBuilder = new StringBuilder("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ");
                        stringBuilder.append(str);
                        stringBuilder.append(".");
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                default:
                    break;
            }
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        this.mToken = mediaSessionCompat.getSessionToken();
        if (VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, mediaSessionCompat);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, mediaSessionCompat);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public MediaControllerCompat(Context context, @NonNull Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.mToken = token;
        if (VERSION.SDK_INT >= 24) {
            this.mImpl = new MediaControllerImplApi24(context, token);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerImplApi23(context, token);
        } else if (VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, token);
        } else {
            this.mImpl = new MediaControllerImplBase(this.mToken);
        }
    }

    public final TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public final boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.mImpl.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public final PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public final MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public final List<QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.addQueueItem(mediaDescriptionCompat);
    }

    public final void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        this.mImpl.addQueueItem(mediaDescriptionCompat, i);
    }

    public final void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        this.mImpl.removeQueueItem(mediaDescriptionCompat);
    }

    @Deprecated
    public final void removeQueueItemAt(int i) {
        List queue = getQueue();
        if (queue != null && i >= 0 && i < queue.size()) {
            QueueItem queueItem = (QueueItem) queue.get(i);
            if (queueItem != null) {
                removeQueueItem(queueItem.getDescription());
            }
        }
    }

    public final CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public final Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public final int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public final boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public final int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    @Deprecated
    public final boolean isShuffleModeEnabled() {
        return this.mImpl.isShuffleModeEnabled();
    }

    public final int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public final long getFlags() {
        return this.mImpl.getFlags();
    }

    public final PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public final PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public final Token getSessionToken() {
        return this.mToken;
    }

    public final void setVolumeTo(int i, int i2) {
        this.mImpl.setVolumeTo(i, i2);
    }

    public final void adjustVolume(int i, int i2) {
        this.mImpl.adjustVolume(i, i2);
    }

    public final void registerCallback(@NonNull Callback callback) {
        registerCallback(callback, null);
    }

    public final void registerCallback(@NonNull Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        callback.setHandler(handler);
        this.mImpl.registerCallback(callback, handler);
        this.mRegisteredCallbacks.add(callback);
    }

    public final void unregisterCallback(@NonNull Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        try {
            this.mRegisteredCallbacks.remove(callback);
            this.mImpl.unregisterCallback(callback);
        } finally {
            callback.setHandler(null);
        }
    }

    public final void sendCommand(@NonNull String str, Bundle bundle, ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.mImpl.sendCommand(str, bundle, resultReceiver);
    }

    public final String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public final Object getMediaController() {
        return this.mImpl.getMediaController();
    }
}
