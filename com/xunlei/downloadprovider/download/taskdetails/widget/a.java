package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.d;

/* compiled from: TaskDetailActionSheetDialog */
public final class a extends XLBaseDialog {
    public OnClickListener a;
    public OnClickListener b;
    public OnClickListener c;
    public OnClickListener d;
    private Button e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private View j;
    private View k;
    @Nullable
    private DownloadTaskInfo l;

    public final void a(@Nullable DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            this.l = downloadTaskInfo;
            b(downloadTaskInfo);
            if (this.f != null) {
                if (k.e(downloadTaskInfo) != null) {
                    this.f.setText("全部删除");
                    return;
                }
                this.f.setText("删除任务");
            }
        }
    }

    private void b(DownloadTaskInfo downloadTaskInfo) {
        if (k.e(downloadTaskInfo) != null) {
            if (this.g != null) {
                this.g.setVisibility(0);
                this.k.setVisibility(0);
            }
            if (this.h != null) {
                this.h.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
        }
        if (this.g != null) {
            this.g.setVisibility(8);
            this.k.setVisibility(8);
        }
        if (this.h != null) {
            this.h.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        super(context, (byte) 40);
    }

    protected final void onCreate(Bundle bundle) {
        LayoutParams attributes;
        super.onCreate(bundle);
        setContentView(R.layout.download_center_detail_action_sheet_dialog);
        ((Button) findViewById(R.id.tv_cancel)).setOnClickListener(new b(this));
        this.f = (Button) findViewById(R.id.delete_Button);
        this.f.setOnClickListener(new c(this));
        this.g = (Button) findViewById(R.id.delete_bt_Button);
        this.g.setOnClickListener(new d(this));
        this.i = (Button) findViewById(R.id.copy_download_url_Button);
        this.i.setOnClickListener(new e(this));
        this.h = (Button) findViewById(R.id.add_bt_Button);
        this.h.setOnClickListener(new f(this));
        this.j = findViewById(R.id.add_bt_line);
        this.k = findViewById(R.id.delete_bt_line);
        if (this.l != null) {
            b(this.l);
            if (k.e(this.l) != null) {
                this.f.setText("全部删除");
            } else {
                this.f.setText("删除任务");
            }
        }
        this.e = (Button) findViewById(R.id.oepn_with_Button);
        if (!(this.l == null || this.l.getTaskStatus() != 8 || this.l.mTaskType == TaskType.BT)) {
            bundle = this.l;
            if (bundle.mLocalFileName != null) {
                bundle = XLFileTypeUtil.getFileCategoryTypeByName(bundle.mLocalFileName);
            } else {
                bundle = XLFileTypeUtil.getFileCategoryTypeByName(bundle.mTitle);
            }
            if (!(bundle == EFileCategoryType.E_VIDEO_CATEGORY || bundle == EFileCategoryType.E_MUSIC_CATEGORY || bundle == EFileCategoryType.E_PICTURE_CATEGORY)) {
                if (bundle != EFileCategoryType.E_ZIP_CATEGORY) {
                    bundle = null;
                    if (bundle != null) {
                        bundle = 1;
                        if (bundle != null) {
                            this.e.setVisibility(0);
                            this.e.setOnClickListener(new g(this));
                        } else {
                            this.e.setVisibility(8);
                        }
                        setCancelable(true);
                        setCanceledOnTouchOutside(true);
                        bundle = getWindow();
                        attributes = bundle.getAttributes();
                        attributes.gravity = 81;
                        attributes.width = d.a(getContext().getApplicationContext());
                        attributes.height = -2;
                        attributes.flags &= -1025;
                        attributes.flags |= 2048;
                        attributes.windowAnimations = R.style.PopupBottomInAnim;
                        bundle.setAttributes(attributes);
                    }
                }
            }
            bundle = 1;
            if (bundle != null) {
                bundle = 1;
                if (bundle != null) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setVisibility(0);
                    this.e.setOnClickListener(new g(this));
                }
                setCancelable(true);
                setCanceledOnTouchOutside(true);
                bundle = getWindow();
                attributes = bundle.getAttributes();
                attributes.gravity = 81;
                attributes.width = d.a(getContext().getApplicationContext());
                attributes.height = -2;
                attributes.flags &= -1025;
                attributes.flags |= 2048;
                attributes.windowAnimations = R.style.PopupBottomInAnim;
                bundle.setAttributes(attributes);
            }
        }
        bundle = null;
        if (bundle != null) {
            this.e.setVisibility(0);
            this.e.setOnClickListener(new g(this));
        } else {
            this.e.setVisibility(8);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bundle = getWindow();
        attributes = bundle.getAttributes();
        attributes.gravity = 81;
        attributes.width = d.a(getContext().getApplicationContext());
        attributes.height = -2;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        attributes.windowAnimations = R.style.PopupBottomInAnim;
        bundle.setAttributes(attributes);
    }

    public final void dismiss() {
        super.dismiss();
        this.l = null;
    }
}
