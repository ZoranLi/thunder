package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private static final AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;

    interface AccessibilityNodeProviderImpl {
        Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }

        AccessibilityNodeProviderStubImpl() {
        }
    }

    @RequiresApi(16)
    private static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeInfoBridge() {
                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    str = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (str == null) {
                        return null;
                    }
                    i = new ArrayList();
                    int size = str.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        i.add(((AccessibilityNodeInfoCompat) str.get(i2)).unwrap());
                    }
                    return i;
                }

                public Object createAccessibilityNodeInfo(int i) {
                    i = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (i == 0) {
                        return 0;
                    }
                    return i.unwrap();
                }
            });
        }
    }

    @RequiresApi(19)
    private static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderKitKatImpl() {
        }

        public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeInfoBridge() {
                public boolean performAction(int i, int i2, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i, i2, bundle);
                }

                public List<Object> findAccessibilityNodeInfosByText(String str, int i) {
                    str = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i);
                    if (str == null) {
                        return null;
                    }
                    i = new ArrayList();
                    int size = str.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        i.add(((AccessibilityNodeInfoCompat) str.get(i2)).unwrap());
                    }
                    return i;
                }

                public Object createAccessibilityNodeInfo(int i) {
                    i = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i);
                    if (i == 0) {
                        return 0;
                    }
                    return i.unwrap();
                }

                public Object findFocus(int i) {
                    i = accessibilityNodeProviderCompat.findFocus(i);
                    if (i == 0) {
                        return 0;
                    }
                    return i.unwrap();
                }
            });
        }
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityNodeProviderKitKatImpl();
        } else if (VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityNodeProviderJellyBeanImpl();
        } else {
            IMPL = new AccessibilityNodeProviderStubImpl();
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.mProvider = obj;
    }

    public Object getProvider() {
        return this.mProvider;
    }
}
