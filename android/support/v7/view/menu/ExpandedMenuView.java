package android.support.v7.view.menu;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
    private static final int[] TINT_ATTRS = new int[]{16842964, 16843049};
    private int mAnimations;
    private MenuBuilder mMenu;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        context = TintTypedArray.obtainStyledAttributes(context, attributeSet, TINT_ATTRS, i, 0);
        if (context.hasValue(0) != null) {
            setBackgroundDrawable(context.getDrawable(0));
        }
        if (context.hasValue(1) != 0) {
            setDivider(context.getDrawable(1));
        }
        context.recycle();
    }

    public final void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((MenuItemImpl) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.mAnimations;
    }
}
