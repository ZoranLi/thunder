package com.xunlei.downloadprovider.download.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.at;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.util.n.a;

/* compiled from: TaskShareHelper */
final class p implements Runnable {
    final /* synthetic */ a a;

    p(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        EFileCategoryType eFileCategoryType;
        if (this.a.e == null) {
            this.a.e = new at(this.a.d);
            this.a.e.setOnDismissListener(new q(this));
        }
        at atVar = this.a.e;
        Bitmap bitmap = this.a.f;
        TaskInfo taskInfo = this.a.c;
        atVar.b.setText(taskInfo.mTitle);
        ImageView imageView = atVar.c;
        int i = 0;
        String str = taskInfo.mTitle;
        if (taskInfo.mLocalFileName != null) {
            EFileCategoryType fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
            eFileCategoryType = fileCategoryTypeByName;
            str = taskInfo.mLocalFileName;
        } else {
            eFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
        }
        TaskType taskType = taskInfo.mTaskType;
        TaskType taskType2 = TaskType.BT;
        int i2 = R.drawable.ic_dl_other;
        if (taskType != taskType2) {
            if (taskInfo.mTaskType != TaskType.MAGNET) {
                if (str != null) {
                    i = XLFileTypeUtil.getFileIconResId(str.trim());
                }
                if (i != R.drawable.ic_dl_other) {
                    if (i != 0) {
                        i2 = i;
                    }
                }
                switch (l.a[eFileCategoryType.ordinal()]) {
                    case 1:
                        i2 = R.drawable.ic_dl_mp4;
                        if (str != null) {
                            i2 = XLFileTypeUtil.getFileIconResId(str);
                            break;
                        }
                        break;
                    case 2:
                        i2 = R.drawable.ic_dl_music;
                        break;
                    case 3:
                        i2 = R.drawable.ic_dl_text;
                        break;
                    case 4:
                        i2 = R.drawable.ic_dl_image;
                        break;
                    case 5:
                        i2 = R.drawable.ic_dl_rar;
                        break;
                    case 6:
                        i2 = R.drawable.ic_dl_torrent;
                        break;
                    case 7:
                        break;
                    default:
                        break;
                }
            }
            i2 = R.drawable.ic_dl_magnet;
        } else {
            i2 = R.drawable.ic_dl_bt;
        }
        imageView.setImageResource(i2);
        if (bitmap == null) {
            atVar.a.setImageResource(R.drawable.qrcode_fail_icon);
        } else {
            atVar.a.setImageBitmap(bitmap);
        }
        atVar.show();
    }
}
