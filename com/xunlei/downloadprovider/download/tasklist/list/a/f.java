package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.xunlei.downloadprovider.download.tasklist.list.a;

/* compiled from: TaskCardViewHolder */
public class f extends ViewHolder {
    protected boolean isVisibleToUser;
    protected a mAdapter;
    protected com.xunlei.downloadprovider.download.control.a mDownloadCenterControl;
    protected boolean mEditMode;

    public void fillData(e eVar) {
    }

    public void onViewAttachedToWindow() {
    }

    public void onViewDetachedFromWindow() {
    }

    public void onViewRecycled() {
    }

    public f(View view) {
        super(view);
    }

    public final boolean isEditMode() {
        return this.mEditMode;
    }

    public final void setEditMode(boolean z) {
        this.mEditMode = z;
    }

    public Context getContext() {
        return this.itemView.getContext();
    }

    public com.xunlei.downloadprovider.download.control.a getDownloadCenterControl() {
        com.xunlei.downloadprovider.download.control.a aVar = this.mDownloadCenterControl;
        return (aVar != null || this.mAdapter == null) ? aVar : this.mAdapter.l;
    }

    public void setDownloadCenterControl(com.xunlei.downloadprovider.download.control.a aVar) {
        this.mDownloadCenterControl = aVar;
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(a aVar) {
        this.mAdapter = aVar;
    }

    public void setVisibleToUser(boolean z) {
        this.isVisibleToUser = z;
    }
}
