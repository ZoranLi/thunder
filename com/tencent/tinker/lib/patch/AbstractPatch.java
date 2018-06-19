package com.tencent.tinker.lib.patch;

import android.content.Context;
import com.tencent.tinker.lib.service.PatchResult;

/* compiled from: BUGLY */
public abstract class AbstractPatch {
    public abstract boolean tryPatch(Context context, String str, PatchResult patchResult);
}
