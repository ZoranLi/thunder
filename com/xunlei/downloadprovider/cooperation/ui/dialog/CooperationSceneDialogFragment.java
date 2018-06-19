package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.a;

public class CooperationSceneDialogFragment extends DialogFragment {
    public a a;
    private CooperationData b;
    private SceneUiStyle c = SceneUiStyle.OTHER;

    public static CooperationSceneDialogFragment a(CooperationData cooperationData, SceneUiStyle sceneUiStyle) {
        CooperationSceneDialogFragment cooperationSceneDialogFragment = new CooperationSceneDialogFragment();
        cooperationSceneDialogFragment.b = cooperationData;
        cooperationSceneDialogFragment.c = sceneUiStyle;
        return cooperationSceneDialogFragment;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        bundle = new f(getContext(), this.c);
        if (this.b != null) {
            bundle.a(this.b.mCooperationScene, this.b.mCooperationItem, "继续播放");
        }
        bundle.b = new e(this);
        return bundle;
    }
}
