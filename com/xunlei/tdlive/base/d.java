package com.xunlei.tdlive.base;

import android.support.v4.app.Fragment;
import android.view.View;

/* compiled from: ViewFindHelper */
public class d {
    public static <T extends View> T a(Fragment fragment, int i) {
        return fragment.getView().findViewById(i);
    }

    public static <T extends View> T a(View view, int i) {
        return view.findViewById(i);
    }
}
