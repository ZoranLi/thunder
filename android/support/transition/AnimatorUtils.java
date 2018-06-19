package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

class AnimatorUtils {
    private static final AnimatorUtilsImpl IMPL;

    AnimatorUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            IMPL = new AnimatorUtilsApi19();
        } else {
            IMPL = new AnimatorUtilsApi14();
        }
    }

    static void addPauseListener(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        IMPL.addPauseListener(animator, animatorListenerAdapter);
    }

    static void pause(@NonNull Animator animator) {
        IMPL.pause(animator);
    }

    static void resume(@NonNull Animator animator) {
        IMPL.resume(animator);
    }
}
