package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class ActivityStubManager {
    private static final int[] NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS = new int[]{0, 0};
    private static final int[] NEXT_SINGLETASK_STUB_IDX_SLOTS = new int[]{0, 0};
    private static final int[] NEXT_SINGLETOP_STUB_IDX_SLOTS = new int[]{0, 0};
    private static final int[] NEXT_STANDARD_STUB_IDX_SLOTS = new int[]{0, 0};
    private static final int NOTRANSPARENT_SLOT_INDEX = 0;
    private static final int[] SINGLEINSTANCE_STUB_COUNT_SLOTS = new int[]{10, 3};
    private static final int[] SINGLETASK_STUB_COUNT_SLOTS = new int[]{10, 3};
    private static final int[] SINGLETOP_STUB_COUNT_SLOTS = new int[]{10, 3};
    private static final int[] STANDARD_STUB_COUNT_SLOTS = new int[]{10, 3};
    private static final String TAG = "Tinker.ActivityStubManager";
    private static final int TRANSPARENT_SLOT_INDEX = 1;
    private static Map<String, String> sTargetToStubClassNameMap = new HashMap();

    public static String assignStub(String str, int i, boolean z) {
        String str2 = (String) sTargetToStubClassNameMap.get(str);
        if (str2 != null) {
            return str2;
        }
        boolean z2;
        int[] iArr;
        int[] iArr2;
        switch (i) {
            case 1:
                z2 = ActivityStubs.SINGLETOP_STUB_CLASSNAME_FORMAT;
                iArr = NEXT_SINGLETOP_STUB_IDX_SLOTS;
                iArr2 = SINGLETOP_STUB_COUNT_SLOTS;
                break;
            case 2:
                z2 = ActivityStubs.SINGLETASK_STUB_CLASSNAME_FORMAT;
                iArr = NEXT_SINGLETASK_STUB_IDX_SLOTS;
                iArr2 = SINGLETASK_STUB_COUNT_SLOTS;
                break;
            case 3:
                z2 = ActivityStubs.SINGLEINSTANCE_STUB_CLASSNAME_FORMAT;
                iArr = NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS;
                iArr2 = SINGLEINSTANCE_STUB_COUNT_SLOTS;
                break;
            default:
                z2 = ActivityStubs.STARDARD_STUB_CLASSNAME_FORMAT;
                iArr = NEXT_STANDARD_STUB_IDX_SLOTS;
                iArr2 = STANDARD_STUB_COUNT_SLOTS;
                break;
        }
        if (z) {
            z = new StringBuilder();
            z.append(z2);
            z.append("_T");
            z = z.toString();
            i = 1;
        } else {
            z = z2;
            i = 0;
        }
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        if (i2 >= iArr2[i]) {
            iArr[i] = 0;
            i2 = 0;
        }
        i = String.format(z, new Object[]{Integer.valueOf(i2)});
        sTargetToStubClassNameMap.put(str, i);
        return i;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
