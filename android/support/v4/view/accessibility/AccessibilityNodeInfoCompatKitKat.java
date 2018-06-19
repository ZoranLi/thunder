package android.support.v4.view.accessibility;

import android.support.annotation.RequiresApi;

@RequiresApi(19)
class AccessibilityNodeInfoCompatKitKat {

    static class RangeInfo {
        RangeInfo() {
        }

        static float getCurrent(Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getCurrent();
        }

        static float getMax(Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getMax();
        }

        static float getMin(Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getMin();
        }

        static int getType(Object obj) {
            return ((android.view.accessibility.AccessibilityNodeInfo.RangeInfo) obj).getType();
        }
    }

    AccessibilityNodeInfoCompatKitKat() {
    }
}
