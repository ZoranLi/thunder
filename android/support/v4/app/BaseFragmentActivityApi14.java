package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;

@RequiresApi(14)
abstract class BaseFragmentActivityApi14 extends SupportActivity {
    boolean mStartedIntentSenderFromFragment;

    abstract View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet);

    BaseFragmentActivityApi14() {
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4) throws SendIntentException {
        if (!(this.mStartedIntentSenderFromFragment || i == -1)) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    static void checkForValidRequestCode(int i) {
        if ((i & SupportMenu.CATEGORY_MASK) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }
}
