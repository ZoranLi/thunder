package android.support.v4.util;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import java.util.Objects;

public class ObjectsCompat {
    private static final ImplBase IMPL;

    private static class ImplBase {
        private ImplBase() {
        }

        public boolean equals(Object obj, Object obj2) {
            if (obj != obj2) {
                if (obj == null || obj.equals(obj2) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    @RequiresApi(19)
    private static class ImplApi19 extends ImplBase {
        private ImplApi19() {
            super();
        }

        public boolean equals(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            IMPL = new ImplApi19();
        } else {
            IMPL = new ImplBase();
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return IMPL.equals(obj, obj2);
    }
}
