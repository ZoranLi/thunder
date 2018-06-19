package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener;

public class a implements IInitializeComponent {
    b a = new b();

    public int initialize(Context context) throws SecException {
        return loadLibrarySync(context);
    }

    public void initializeAsync(Context context) {
        try {
            loadLibraryAsync(context);
        } catch (SecException e) {
            e.printStackTrace();
        }
    }

    public boolean isSoValid(Context context) throws SecException {
        return this.a.a(context);
    }

    public void loadLibraryAsync(Context context) throws SecException {
        this.a.b(context, null, true);
    }

    public int loadLibrarySync(Context context) throws SecException {
        return this.a.a(context, null, true);
    }

    public void registerInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException {
        this.a.a(iInitFinishListener);
    }

    public void unregisterInitFinishListener(IInitFinishListener iInitFinishListener) throws SecException {
        this.a.b(iInitFinishListener);
    }
}
