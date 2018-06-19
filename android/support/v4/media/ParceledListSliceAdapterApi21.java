package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import android.support.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.util.List;

@RequiresApi(21)
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    ParceledListSliceAdapterApi21() {
    }

    static {
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class});
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    static Object newInstance(List<MediaItem> list) {
        try {
            return sConstructor.newInstance(new Object[]{list});
        } catch (List<MediaItem> list2) {
            list2.printStackTrace();
            return null;
        }
    }
}
