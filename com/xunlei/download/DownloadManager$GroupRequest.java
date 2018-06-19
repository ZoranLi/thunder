package com.xunlei.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.xunlei.download.proguard.an;
import java.util.ArrayList;

public class DownloadManager$GroupRequest extends DownloadManager$Request {
    private ArrayList<DownloadManager$Request> g;

    public DownloadManager$GroupRequest() {
        this(null);
    }

    public DownloadManager$GroupRequest(String[] strArr) {
        super("");
        this.g = new ArrayList();
        if (strArr != null) {
            if (this.d == null) {
                this.d = DownloadManager.a(strArr);
            }
            for (String str : strArr) {
                if (str.startsWith("file://")) {
                    an.d("DownloadManager", "BTTask can not be added as a subtask.");
                } else {
                    this.g.add(new DownloadManager$Request(Uri.parse(str)));
                }
            }
        }
        strArr = new StringBuilder();
        strArr.append(System.currentTimeMillis());
        strArr.append(this);
        strArr = strArr.toString();
        StringBuilder stringBuilder = new StringBuilder(DownloadManager.TASK_GROUP_URI_PREFIX);
        stringBuilder.append(String.valueOf(strArr.hashCode()));
        this.a = Uri.parse(stringBuilder.toString());
    }

    public DownloadManager$GroupRequest addSubRequest(DownloadManager$Request downloadManager$Request) {
        if (downloadManager$Request == null) {
            throw new IllegalArgumentException("null argument");
        } else if (downloadManager$Request instanceof DownloadManager$GroupRequest) {
            throw new IllegalArgumentException("GroupTask can not be added as a subtask.");
        } else if (downloadManager$Request.a.toString().startsWith("file://")) {
            an.d("DownloadManager", "BTTask can not be added as a subtask.");
            return this;
        } else {
            this.g.add(downloadManager$Request);
            return this;
        }
    }

    public ArrayList<DownloadManager$Request> getSubList() {
        return this.g;
    }

    ContentValues a(Context context, String str) {
        if (this.d == null) {
            StringBuilder stringBuilder = new StringBuilder("TaskGroup");
            stringBuilder.append(this.a.getHost());
            this.d = stringBuilder.toString();
        }
        return super.a(context, str);
    }
}
