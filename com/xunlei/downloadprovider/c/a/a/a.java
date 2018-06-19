package com.xunlei.downloadprovider.c.a.a;

import android.database.DataSetObserver;
import android.widget.BaseAdapter;

/* compiled from: XLBaseAdapter */
public abstract class a extends BaseAdapter {
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            try {
                super.unregisterDataSetObserver(dataSetObserver);
            } catch (DataSetObserver dataSetObserver2) {
                dataSetObserver2.printStackTrace();
            }
        }
    }
}
