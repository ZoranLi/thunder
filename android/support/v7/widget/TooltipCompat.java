package android.support.v7.widget;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class TooltipCompat {
    private static final ViewCompatImpl IMPL;

    private interface ViewCompatImpl {
        void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence);
    }

    @TargetApi(26)
    private static class Api26ViewCompatImpl implements ViewCompatImpl {
        private Api26ViewCompatImpl() {
        }

        public void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private static class BaseViewCompatImpl implements ViewCompatImpl {
        private BaseViewCompatImpl() {
        }

        public void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
            TooltipCompatHandler.setTooltipText(view, charSequence);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            IMPL = new Api26ViewCompatImpl();
        } else {
            IMPL = new BaseViewCompatImpl();
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        IMPL.setTooltipText(view, charSequence);
    }

    private TooltipCompat() {
    }
}
