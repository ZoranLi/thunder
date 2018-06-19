package com.xunlei.download;

import android.content.ContentUris;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import com.xunlei.download.Downloads.Impl;
import java.io.File;

public class DownloadManager$CursorTranslator extends CursorWrapper {
    private Uri a;

    public DownloadManager$CursorTranslator(Cursor cursor, Uri uri) {
        super(cursor);
        this.a = uri;
    }

    public int getInt(int i) {
        return (int) getLong(i);
    }

    public long getLong(int i) {
        if (getColumnName(i).equals(DownloadManager.COLUMN_REASON)) {
            return DownloadManager.getReason(super.getInt(getColumnIndex("status")));
        }
        if (getColumnName(i).equals("status")) {
            return (long) DownloadManager.translateStatus(super.getInt(getColumnIndex("status")));
        }
        if (getColumnName(i).equals("lx_status")) {
            return (long) DownloadManager.translateStatus(super.getInt(getColumnIndex("lx_status")));
        }
        if (getColumnName(i).equals("vip_status")) {
            return (long) DownloadManager.translateStatus(super.getInt(getColumnIndex("vip_status")));
        }
        if (getColumnName(i).equals(DownloadManager.COLUMN_STATUS_ORIGINAL)) {
            return (long) super.getInt(getColumnIndex("status"));
        }
        return super.getLong(i);
    }

    public String getString(int i) {
        return getColumnName(i).equals(DownloadManager.COLUMN_LOCAL_URI) ? a() : super.getString(i);
    }

    private String a() {
        long j = getLong(getColumnIndex(Impl.COLUMN_DESTINATION));
        if (!(j == 4 || j == 0)) {
            if (j != 6) {
                return ContentUris.withAppendedId(this.a, getLong(getColumnIndex("_id"))).toString();
            }
        }
        String string = getString(getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
        if (string == null) {
            return null;
        }
        return Uri.fromFile(new File(string)).toString();
    }
}
