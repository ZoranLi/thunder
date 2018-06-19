package com.xunlei.common.commonview.anim;

import android.app.Activity;
import com.xunlei.common.R;

public class AnimationManager {
    public static void playStartRightInLeftOutAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    public static void playStartLeftInRightOutAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    public static void playStartBottomInAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_alpha_out);
    }

    public static void playFinishBottomOutAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.translate_alpha_in, R.anim.translate_between_interface_bottom_out);
    }
}
