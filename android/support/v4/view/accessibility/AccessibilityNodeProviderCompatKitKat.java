package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@RequiresApi(19)
class AccessibilityNodeProviderCompatKitKat {

    final class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ AccessibilityNodeInfoBridge val$bridge;

        AnonymousClass1(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
            this.val$bridge = accessibilityNodeInfoBridge;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.val$bridge.createAccessibilityNodeInfo(i);
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.val$bridge.findAccessibilityNodeInfosByText(str, i);
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.val$bridge.performAction(i, i2, bundle);
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            return (AccessibilityNodeInfo) this.val$bridge.findFocus(i);
        }
    }

    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        Object findFocus(int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static Object newAccessibilityNodeProviderBridge(AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AnonymousClass1(accessibilityNodeInfoBridge);
    }
}
