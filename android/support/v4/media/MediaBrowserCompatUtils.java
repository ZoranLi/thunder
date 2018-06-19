package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle2 == null ? bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == -1 && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == -1 : bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1) && bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1) == bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i;
        int i2;
        int i3 = bundle == null ? -1 : bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        if (bundle2 == null) {
            i = -1;
        } else {
            i = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        }
        if (bundle == null) {
            bundle = -1;
        } else {
            bundle = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        if (bundle2 == null) {
            bundle2 = -1;
        } else {
            bundle2 = bundle2.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        }
        int i4 = Integer.MAX_VALUE;
        if (i3 != -1) {
            if (bundle != -1) {
                i3 *= bundle;
                bundle = (bundle + i3) - 1;
                if (i != -1) {
                    if (bundle2 == -1) {
                        i2 = bundle2 * i;
                        i4 = (bundle2 + i2) - 1;
                        if (i3 <= i2 || i2 > bundle) {
                            return i3 > i4 && i4 <= bundle;
                        } else {
                            return true;
                        }
                    }
                }
                i2 = 0;
                if (i3 <= i2) {
                }
                if (i3 > i4) {
                }
            }
        }
        bundle = 2147483647;
        i3 = 0;
        if (i != -1) {
            if (bundle2 == -1) {
                i2 = bundle2 * i;
                i4 = (bundle2 + i2) - 1;
                if (i3 <= i2) {
                }
                if (i3 > i4) {
                }
            }
        }
        i2 = 0;
        if (i3 <= i2) {
        }
        if (i3 > i4) {
        }
    }
}
