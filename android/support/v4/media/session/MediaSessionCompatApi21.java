package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes.Builder;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSetRating(Object obj, Bundle bundle);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    static class CallbackProxy<T extends Callback> extends android.media.session.MediaSession.Callback {
        protected final T mCallback;

        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.mCallback.onCommand(str, bundle, resultReceiver);
        }

        public boolean onMediaButtonEvent(Intent intent) {
            if (!this.mCallback.onMediaButtonEvent(intent)) {
                if (super.onMediaButtonEvent(intent) == null) {
                    return null;
                }
            }
            return true;
        }

        public void onPlay() {
            this.mCallback.onPlay();
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
            this.mCallback.onPlayFromMediaId(str, bundle);
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
            this.mCallback.onPlayFromSearch(str, bundle);
        }

        public void onSkipToQueueItem(long j) {
            this.mCallback.onSkipToQueueItem(j);
        }

        public void onPause() {
            this.mCallback.onPause();
        }

        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        public void onRewind() {
            this.mCallback.onRewind();
        }

        public void onStop() {
            this.mCallback.onStop();
        }

        public void onSeekTo(long j) {
            this.mCallback.onSeekTo(j);
        }

        public void onSetRating(Rating rating) {
            this.mCallback.onSetRating(rating);
        }

        public void onCustomAction(String str, Bundle bundle) {
            this.mCallback.onCustomAction(str, bundle);
        }
    }

    static class QueueItem {
        QueueItem() {
        }

        public static Object createItem(Object obj, long j) {
            return new android.media.session.MediaSession.QueueItem((MediaDescription) obj, j);
        }

        public static Object getDescription(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getDescription();
        }

        public static long getQueueId(Object obj) {
            return ((android.media.session.MediaSession.QueueItem) obj).getQueueId();
        }
    }

    MediaSessionCompatApi21() {
    }

    public static Object createSession(Context context, String str) {
        return new MediaSession(context, str);
    }

    public static Object verifySession(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    public static Object verifyToken(Object obj) {
        if (obj instanceof Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static void setCallback(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((android.media.session.MediaSession.Callback) obj2, handler);
    }

    public static void setFlags(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    public static void setPlaybackToLocal(Object obj, int i) {
        Builder builder = new Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    public static void setPlaybackToRemote(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    public static void setActive(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    public static void release(Object obj) {
        ((MediaSession) obj).release();
    }

    public static Parcelable getSessionToken(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    public static void setPlaybackState(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    public static void setMetadata(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    public static void setQueue(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue(null);
            return;
        }
        List arrayList = new ArrayList();
        list = list.iterator();
        while (list.hasNext()) {
            arrayList.add((android.media.session.MediaSession.QueueItem) list.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    public static void setExtras(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    public static boolean hasCallback(java.lang.Object r3) {
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
        r0 = 0;
        r1 = r3.getClass();	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        r2 = "mCallback";	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        if (r1 == 0) goto L_0x0019;	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
    L_0x000d:
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        r3 = r1.get(r3);	 Catch:{ NoSuchFieldException -> 0x0019, NoSuchFieldException -> 0x0019 }
        if (r3 == 0) goto L_0x0018;
    L_0x0017:
        return r2;
    L_0x0018:
        return r0;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompatApi21.hasCallback(java.lang.Object):boolean");
    }
}
