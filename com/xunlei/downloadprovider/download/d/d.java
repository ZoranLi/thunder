package com.xunlei.downloadprovider.download.d;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: DownloadTaskOpenAppSelectDialog */
public final class d extends XLBaseDialog implements OnClickListener {
    public Context a;
    public a b;
    public List<ResolveInfo> c;
    public ArrayList<f> d;
    public ArrayList<f> e;
    public Set<String> f;
    public f g;
    public String h;
    public a i = null;
    private TextView j;
    private FrameLayout k;
    private RecyclerView l;

    /* compiled from: DownloadTaskOpenAppSelectDialog */
    public interface a {
        void a();

        void a(f fVar, String str);
    }

    public d(Context context) {
        super(context, R.style.bt_create_dialog);
        this.a = context;
        setContentView(R.layout.download_task_open_app_select_dialog_layout);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        context = getWindow().getAttributes();
        context.gravity = 81;
        context.width = com.xunlei.xllib.android.d.a(getContext().getApplicationContext());
        context.height = -2;
        context.flags &= -1025;
        context.flags |= 2048;
        context.windowAnimations = R.style.PopupBottomInAnim;
        getWindow().setAttributes(context);
        this.j = (TextView) findViewById(R.id.tv_cancel);
        this.j.setOnClickListener(this);
        this.k = (FrameLayout) findViewById(R.id.fl_recyclerView);
        this.l = new RecyclerView(this.a);
        context = new LinearLayoutManager(this.a);
        context.setOrientation(0);
        this.l.setLayoutManager(context);
        this.l.addItemDecoration(new c(this.a.getResources().getDimensionPixelSize(R.dimen.app_select_horizotal_space)));
        this.l.setOverScrollMode(2);
        this.k.addView(this.l);
        this.b = new a(this.a);
        this.l.setAdapter(this.b);
        this.b.a = new e(this);
    }

    public final void a(List<ResolveInfo> list, String str) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (!com.xunlei.xllib.b.d.a(this.c)) {
            this.c.clear();
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (!com.xunlei.xllib.b.d.a(this.e)) {
            this.e.clear();
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (!com.xunlei.xllib.b.d.a(this.d)) {
            this.d.clear();
        }
        if (this.f == null) {
            this.f = new HashSet();
        }
        if (!com.xunlei.xllib.b.d.a(this.f)) {
            this.f.clear();
        }
        this.h = str;
        str = com.xunlei.xllib.b.d.a(list);
        if (str == null) {
            this.c.addAll(list);
        }
        a();
        if (str == null) {
            str = this.a.getPackageManager();
            for (ResolveInfo resolveInfo : list) {
                CharSequence charSequence = resolveInfo.activityInfo.packageName;
                if (TextUtils.isEmpty(charSequence) || !this.f.contains(charSequence)) {
                    f fVar = new f();
                    fVar.c = resolveInfo;
                    fVar.a = resolveInfo.loadIcon(str);
                    fVar.b = resolveInfo.loadLabel(str).toString();
                    this.e.add(fVar);
                    this.f.add(charSequence);
                }
            }
        }
        if (com.xunlei.xllib.b.d.a(this.e) != null) {
            XLToast.showToast(this.a, "找不到适合的应用打开文件");
            b();
            return;
        }
        if (this.e.size() > 3) {
            for (int i = 0; i < 3; i++) {
                this.d.add((f) this.e.remove(0));
            }
            this.g = new f();
            this.g.a = this.a.getResources().getDrawable(R.drawable.app_select_more);
            this.g.b = "更多";
            this.g.d = true;
            this.d.add(this.g);
        } else {
            this.d.addAll(this.e);
        }
        this.b.a(this.d);
    }

    private void a() {
        if (!TextUtils.isEmpty(this.h)) {
            ArrayList arrayList = new ArrayList();
            EFileCategoryType fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(this.h);
            if (fileCategoryTypeByName.equals(EFileCategoryType.E_VIDEO_CATEGORY)) {
                arrayList.add(Integer.valueOf(8));
                arrayList.add(Integer.valueOf(9));
            } else if (fileCategoryTypeByName.equals(EFileCategoryType.E_MUSIC_CATEGORY)) {
                arrayList.add(Integer.valueOf(14));
                arrayList.add(Integer.valueOf(15));
            } else if (fileCategoryTypeByName.equals(EFileCategoryType.E_PICTURE_CATEGORY)) {
                arrayList.add(Integer.valueOf(10));
                arrayList.add(Integer.valueOf(11));
            } else if (fileCategoryTypeByName.equals(EFileCategoryType.E_ZIP_CATEGORY)) {
                arrayList.add(Integer.valueOf(12));
                arrayList.add(Integer.valueOf(13));
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    CooperationItem a = c.a().a(intValue);
                    if (a != null) {
                        f fVar = new f();
                        fVar.b = a.getCopyWriting();
                        boolean z = true;
                        fVar.e = true;
                        fVar.f = a;
                        if (i != 0) {
                            z = false;
                        }
                        fVar.g = z;
                        for (ResolveInfo resolveInfo : this.c) {
                            CharSequence charSequence = resolveInfo.activityInfo.packageName;
                            if (!TextUtils.isEmpty(charSequence) && a.getAppPackageName().equals(charSequence)) {
                                fVar.c = resolveInfo;
                                this.f.add(charSequence);
                                break;
                            }
                        }
                        this.e.add(fVar);
                        com.xunlei.downloadprovider.cooperation.a.a.a(l.c(intValue), a.getAppPackageName(), a.isShowInstallTip());
                        i++;
                    }
                }
            }
        }
    }

    private void b() {
        if (this.i != null) {
            this.i.a();
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.tv_cancel) {
            dismiss();
        }
    }
}
