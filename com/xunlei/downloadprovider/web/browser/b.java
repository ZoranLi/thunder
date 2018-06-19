package com.xunlei.downloadprovider.web.browser;

import android.view.ActionMode;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

/* compiled from: ActionModeHelper */
final class b implements OnMenuItemClickListener {
    final /* synthetic */ ActionMode a;
    final /* synthetic */ a b;

    b(a aVar, ActionMode actionMode) {
        this.b = aVar;
        this.a = actionMode;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.b.a.a(menuItem.getTitle().toString());
        this.a.finish();
        return true;
    }
}
