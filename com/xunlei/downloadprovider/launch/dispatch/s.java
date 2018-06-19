package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: VodPlayerDISP */
public class s extends b {
    private static final String a = "s";
    private Intent b;

    protected final boolean a(Intent intent) {
        this.b = intent;
        if (this.b == null || this.b.getIntExtra("dispatch_from_key", -1) != 1107) {
            return false;
        }
        return true;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
        if ("android.intent.action.VIEW".equals(this.b.getAction()) && this.b.getData() != null) {
            Uri data = this.b.getData();
            new StringBuilder("fileUri=>").append(data);
            String str = "";
            String str2 = "";
            if ("content".equals(data.getScheme())) {
                Cursor query = context.getContentResolver().query(data, null, null, null, null);
                if (query != null) {
                    String string;
                    query.moveToFirst();
                    String string2 = query.getString(query.getColumnIndex("_display_name"));
                    query.getLong(query.getColumnIndex("_size"));
                    int columnIndex = query.getColumnIndex(Impl._DATA);
                    if (columnIndex >= 0) {
                        string = query.getString(columnIndex);
                    } else {
                        string = data.toString();
                    }
                    str = string;
                    query.close();
                    str2 = string2;
                }
            } else {
                str = data.getPath();
            }
            TaskPlayInfo taskPlayInfo = new TaskPlayInfo(str);
            taskPlayInfo.mTitle = str2;
            VodPlayerActivityNew.a(context, taskPlayInfo, "app_other", null, true, 0, null);
        }
        c.a("file_video", true);
    }
}
