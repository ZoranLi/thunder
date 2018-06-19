package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.create.DownData;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.d;

/* compiled from: LXSpaceTaskOperateDlg */
public final class k extends XLBaseDialog {
    public LXTaskInfo a;
    public Button b;
    public a c;
    private OnClickListener d;

    /* compiled from: LXSpaceTaskOperateDlg */
    public interface a {
        void a(LXTaskInfo lXTaskInfo);

        void b(LXTaskInfo lXTaskInfo);
    }

    public k(Context context) {
        this(context, (byte) 0);
    }

    private k(Context context, byte b) {
        super(context, (byte) 40);
        this.d = new l(this);
        context = LayoutInflater.from(context).inflate((byte) -16, null);
        this.b = (Button) context.findViewById((byte) 126);
        this.b.setOnClickListener(this.d);
        context.findViewById(Byte.MAX_VALUE).setOnClickListener(this.d);
        context.findViewById(Byte.MIN_VALUE).setOnClickListener(this.d);
        context.findViewById((byte) -127).setOnClickListener(this.d);
        setContentView(context);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        context = getWindow();
        b = context.getAttributes();
        b.gravity = 81;
        b.width = d.a(getContext().getApplicationContext());
        b.height = -2;
        b.flags &= -1025;
        b.flags |= 2048;
        b.windowAnimations = R.style.PopupBottomInAnim;
        context.setAttributes(b);
    }

    static /* synthetic */ void a(k kVar) {
        if (kVar.a.e > 0) {
            if (kVar.a.i == CollectState.complete) {
                String str = kVar.a.b;
                if (TextUtils.isEmpty(str)) {
                    XLToast.showToast(kVar.getContext(), kVar.getContext().getResources().getString(R.string.empty_download_url));
                    return;
                }
                Context context = kVar.getContext();
                String str2 = kVar.a.f;
                c mVar = new m(kVar);
                kVar = new TaskStatInfo("space/space_lixian", str, "");
                kVar.h = com.xunlei.downloadprovider.download.engine.report.a.b(str);
                DownData downData = new DownData();
                downData.b = str;
                downData.a = str2;
                downData.a("");
                downData.b();
                com.xunlei.downloadprovider.download.c.a(context, downData, kVar, mVar);
            }
        } else if (kVar.c != null) {
            kVar.c.b(kVar.a);
        }
    }

    static /* synthetic */ void b(k kVar) {
        String str = kVar.a.b;
        if (!TextUtils.isEmpty(str)) {
            m.a().a(str);
            ClipboardUtil.copyToClipboard(BrothersApplication.getApplicationInstance(), str, "");
            XLToast.showToast(kVar.getContext(), "复制链接成功");
        }
    }

    static /* synthetic */ void c(k kVar) {
        if (kVar.c != null) {
            kVar.c.a(kVar.a);
        }
    }
}
