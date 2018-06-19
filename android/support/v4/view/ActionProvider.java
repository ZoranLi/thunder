package android.support.v4.view;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null && overridesItemVisibility()) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void subUiVisibilityChanged(boolean z) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.mSubUiVisibilityListener = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (!(this.mVisibilityListener == null || visibilityListener == null)) {
            StringBuilder stringBuilder = new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = visibilityListener;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }
}
