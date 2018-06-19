package android.support.v4.media;

import android.media.VolumeProvider;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class VolumeProviderCompatApi21 {

    final class AnonymousClass1 extends VolumeProvider {
        final /* synthetic */ Delegate val$delegate;

        AnonymousClass1(int i, int i2, int i3, Delegate delegate) {
            this.val$delegate = delegate;
            super(i, i2, i3);
        }

        public final void onSetVolumeTo(int i) {
            this.val$delegate.onSetVolumeTo(i);
        }

        public final void onAdjustVolume(int i) {
            this.val$delegate.onAdjustVolume(i);
        }
    }

    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i2, int i3, Delegate delegate) {
        return new AnonymousClass1(i, i2, i3, delegate);
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}
