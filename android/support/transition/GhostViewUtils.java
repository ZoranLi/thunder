package android.support.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.support.transition.GhostViewImpl.Creator;
import android.view.View;
import android.view.ViewGroup;

class GhostViewUtils {
    private static final Creator CREATOR;

    GhostViewUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            CREATOR = new Creator();
        } else {
            CREATOR = new Creator();
        }
    }

    static GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        return CREATOR.addGhost(view, viewGroup, matrix);
    }

    static void removeGhost(View view) {
        CREATOR.removeGhost(view);
    }
}
