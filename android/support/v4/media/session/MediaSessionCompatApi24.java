package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@RequiresApi(24)
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String str, Bundle bundle);

        void onPrepareFromSearch(String str, Bundle bundle);

        void onPrepareFromUri(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromMediaId(str, bundle);
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromSearch(str, bundle);
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPrepareFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static java.lang.String getCallingPackage(java.lang.Object r4) {
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
        r4 = (android.media.session.MediaSession) r4;
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r1 = "getCallingPackage";	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r2 = 0;	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r4 = r0.invoke(r4, r1);	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        r4 = (java.lang.String) r4;	 Catch:{ NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018, NoSuchMethodException -> 0x0018 }
        return r4;
    L_0x0018:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompatApi24.getCallingPackage(java.lang.Object):java.lang.String");
    }
}
