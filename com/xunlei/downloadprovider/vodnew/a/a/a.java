package com.xunlei.downloadprovider.vodnew.a.a;

import android.os.ParcelFileDescriptor;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import java.io.FileDescriptor;

/* compiled from: PlayerDataSource */
public abstract class a {
    protected String g;
    protected ParcelFileDescriptor h;
    protected FileDescriptor i;

    public abstract TaskPlayInfo a();

    public String d() {
        return this.g;
    }

    public final FileDescriptor k() {
        return this.i;
    }

    public final ParcelFileDescriptor l() {
        return this.h;
    }
}
