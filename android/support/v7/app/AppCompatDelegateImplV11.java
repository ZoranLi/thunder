package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

@RequiresApi(14)
class AppCompatDelegateImplV11 extends AppCompatDelegateImplV9 {
    View callActivityOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    AppCompatDelegateImplV11(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public boolean hasWindowFeature(int i) {
        if (!super.hasWindowFeature(i)) {
            if (this.mWindow.hasFeature(i) == 0) {
                return false;
            }
        }
        return true;
    }
}
