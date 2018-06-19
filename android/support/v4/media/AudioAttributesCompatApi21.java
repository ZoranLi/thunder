package android.support.v4.media;

import android.media.AudioAttributes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class AudioAttributesCompatApi21 {
    private static final String TAG = "AudioAttributesCompat";
    private static Method sAudioAttributesToLegacyStreamType;

    static final class Wrapper {
        private AudioAttributes mWrapped;

        private Wrapper(AudioAttributes audioAttributes) {
            this.mWrapped = audioAttributes;
        }

        public static Wrapper wrap(@NonNull AudioAttributes audioAttributes) {
            if (audioAttributes != null) {
                return new Wrapper(audioAttributes);
            }
            throw new IllegalArgumentException("AudioAttributesApi21.Wrapper cannot wrap null");
        }

        public final AudioAttributes unwrap() {
            return this.mWrapped;
        }
    }

    AudioAttributesCompatApi21() {
    }

    public static int toLegacyStreamType(android.support.v4.media.AudioAttributesCompatApi21.Wrapper r6) {
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
        r6 = r6.unwrap();
        r0 = sAudioAttributesToLegacyStreamType;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r1 = 0;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        if (r0 != 0) goto L_0x001a;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
    L_0x000a:
        r0 = android.media.AudioAttributes.class;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r3 = "toLegacyStreamType";	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r5 = android.media.AudioAttributes.class;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r0 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        sAudioAttributesToLegacyStreamType = r0;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
    L_0x001a:
        r0 = sAudioAttributesToLegacyStreamType;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r2[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = r0.invoke(r3, r2);	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = (java.lang.Integer) r6;	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        r6 = r6.intValue();	 Catch:{ NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c, NoSuchMethodException -> 0x002c }
        return r6;
    L_0x002c:
        r6 = -1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.AudioAttributesCompatApi21.toLegacyStreamType(android.support.v4.media.AudioAttributesCompatApi21$Wrapper):int");
    }
}
