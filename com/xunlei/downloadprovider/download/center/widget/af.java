package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.b.c;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.privatespace.f;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import java.util.Iterator;

/* compiled from: DownloadTaskMoreOperationDialog */
public final class af extends XLBaseDialog {
    public a a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private DownloadTaskInfo g;
    private com.xunlei.downloadprovider.download.control.a h;
    private z i;
    private String j;
    private f k = new ap(this);

    /* compiled from: DownloadTaskMoreOperationDialog */
    public interface a {
        void a();

        void b();
    }

    public af(Context context, DownloadTaskInfo downloadTaskInfo, com.xunlei.downloadprovider.download.control.a aVar, String str) {
        super(context, R.style.bt_create_dialog);
        this.g = downloadTaskInfo;
        this.h = aVar;
        this.j = str;
    }

    protected final void onCreate(Bundle bundle) {
        TextView textView;
        c cVar;
        LayoutParams attributes;
        super.onCreate(bundle);
        setContentView(R.layout.download_task_more_operation_view_layout);
        bundle = true;
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.b = findViewById(R.id.container);
        this.b.setOnClickListener(new ag(this));
        this.c = (TextView) findViewById(R.id.shareButton);
        this.d = (TextView) findViewById(R.id.deleteButton);
        this.e = (TextView) findViewById(R.id.openwithButton);
        this.f = (TextView) findViewById(R.id.copyButton);
        this.c.setOnClickListener(new ah(this));
        View findViewById = findViewById(R.id.openwithActionLayout);
        if (!(this.g == null || this.g.getTaskStatus() != 8 || this.g.mTaskType == TaskType.BT)) {
            EFileCategoryType fileCategoryTypeByName;
            TaskInfo taskInfo = this.g;
            if (taskInfo.mLocalFileName != null) {
                fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mLocalFileName);
            } else {
                fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(taskInfo.mTitle);
            }
            if (!(fileCategoryTypeByName == EFileCategoryType.E_VIDEO_CATEGORY || fileCategoryTypeByName == EFileCategoryType.E_MUSIC_CATEGORY || fileCategoryTypeByName == EFileCategoryType.E_PICTURE_CATEGORY)) {
                if (fileCategoryTypeByName != EFileCategoryType.E_ZIP_CATEGORY) {
                    bundle = null;
                }
            }
            if (bundle != null) {
                findViewById.setVisibility(0);
                this.e.setOnClickListener(new ai(this));
                this.d.setOnClickListener(new aj(this));
                ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new am(this));
                textView = (TextView) findViewById(R.id.privateSpaceActionLayout).findViewById(R.id.privateSpaceButton);
                cVar = d.a().d;
                if (c.o()) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(PrivateSpaceMgr.a().a(this.g) ? "移出私人空间" : "放入私人空间");
                    findViewById(R.id.privateSpaceActionLayout).setOnClickListener(new an(this));
                }
                this.f.setOnClickListener(new ao(this));
                bundle = getWindow();
                attributes = bundle.getAttributes();
                attributes.gravity = 81;
                attributes.width = com.xunlei.xllib.android.d.a(getContext().getApplicationContext());
                attributes.height = -2;
                attributes.flags &= -1025;
                attributes.flags |= 2048;
                attributes.windowAnimations = R.style.PopupBottomInAnim;
                bundle.setAttributes(attributes);
            }
        }
        findViewById.setVisibility(8);
        this.d.setOnClickListener(new aj(this));
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new am(this));
        textView = (TextView) findViewById(R.id.privateSpaceActionLayout).findViewById(R.id.privateSpaceButton);
        cVar = d.a().d;
        if (c.o()) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            if (PrivateSpaceMgr.a().a(this.g)) {
            }
            textView.setText(PrivateSpaceMgr.a().a(this.g) ? "移出私人空间" : "放入私人空间");
            findViewById(R.id.privateSpaceActionLayout).setOnClickListener(new an(this));
        }
        this.f.setOnClickListener(new ao(this));
        bundle = getWindow();
        attributes = bundle.getAttributes();
        attributes.gravity = 81;
        attributes.width = com.xunlei.xllib.android.d.a(getContext().getApplicationContext());
        attributes.height = -2;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        attributes.windowAnimations = R.style.PopupBottomInAnim;
        bundle.setAttributes(attributes);
    }

    public final void dismiss() {
        this.a = null;
        super.dismiss();
    }

    static /* synthetic */ void e(af afVar) {
        if (PrivateSpaceMgr.a().a(afVar.g)) {
            PrivateSpaceMgr.a().a(afVar.g.getTaskId());
            if (afVar.a != null) {
                afVar.a.b();
            }
            if (afVar.g.getTaskStatus() == 8) {
                PrivateSpaceMgr.a().b(afVar.g.getTaskId(), afVar.g.mLocalFileName);
            }
            if (!PrivateSpaceMgr.a().f()) {
                PrivateSpaceMgr.a().a(afVar.g.getTaskId(), false);
            }
        } else {
            PrivateSpaceMgr.a().b(afVar.g);
            if (afVar.a != null) {
                afVar.a.a();
            }
            if (afVar.g.getTaskStatus() == 8) {
                PrivateSpaceMgr.a().a(afVar.g.getTaskId(), afVar.g.mLocalFileName);
            }
            if (!PrivateSpaceMgr.a().f()) {
                PrivateSpaceMgr a = PrivateSpaceMgr.a();
                long taskId = afVar.g.getTaskId();
                if (!com.xunlei.xllib.b.d.a(a.b)) {
                    Iterator it = a.b.iterator();
                    while (it.hasNext()) {
                        ((com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.a) it.next()).a(taskId);
                    }
                }
            }
        }
        PrivateSpaceMgr.a().g();
        afVar.dismiss();
    }
}
