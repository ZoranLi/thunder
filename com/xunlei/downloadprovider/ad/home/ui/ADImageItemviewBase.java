package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.ad.home.ui.ADItemView.AD_LAYOUT_TYPE;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class ADImageItemviewBase<T extends a> extends FrameLayout implements com.xunlei.downloadprovider.ad.common.adget.c.f.a, ADItemView, t, com.xunlei.downloadprovider.homepage.choiceness.ui.a.b<e> {
    protected l a;
    protected i b;
    protected T c;
    private final String d;
    private String e;
    private XLAlertDialog f;

    protected class a {
        ImageView a;
        TextView b;
        TextView c;
        ImageView d;
        View e;
        final /* synthetic */ ADImageItemviewBase f;

        protected a(ADImageItemviewBase aDImageItemviewBase) {
            this.f = aDImageItemviewBase;
        }
    }

    protected class b extends a {
        final /* synthetic */ ADImageItemviewBase g;

        protected b(ADImageItemviewBase aDImageItemviewBase) {
            this.g = aDImageItemviewBase;
            super(aDImageItemviewBase);
        }
    }

    protected class c extends b {
        TextView h;
        TextView i;
        TextView j;
        final /* synthetic */ ADImageItemviewBase k;

        protected c(ADImageItemviewBase aDImageItemviewBase) {
            this.k = aDImageItemviewBase;
            super(aDImageItemviewBase);
        }
    }

    protected class d extends b {
        ImageView h;
        TextView i;
        final /* synthetic */ ADImageItemviewBase j;

        protected d(ADImageItemviewBase aDImageItemviewBase) {
            this.j = aDImageItemviewBase;
            super(aDImageItemviewBase);
        }
    }

    public final void a(NativeMediaADData nativeMediaADData) {
    }

    public final void a(NativeMediaADData nativeMediaADData, int i) {
    }

    protected void c() {
    }

    protected void c(l lVar) {
    }

    protected abstract T d();

    public View getContainer() {
        return this;
    }

    public ADImageItemviewBase(Context context) {
        this(context, null);
    }

    public ADImageItemviewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ADImageItemviewBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = f.a;
        this.f = null;
        LayoutInflater.from(context).inflate(getLayoutId(), this, true);
        this.c = d();
        a(context);
    }

    public final void a(int i, i iVar, int i2, View view, e eVar) {
        i = f.a;
        new StringBuilder("bindView resId: ").append(eVar.b());
        if ((view instanceof ADItemView) != 0) {
            i = getViewPositionKey();
            ADItemView aDItemView = (ADItemView) view;
            aDItemView.a(eVar.b());
            this.b = iVar;
            l a = f.a(getContext().getApplicationContext()).c.a(eVar.b());
            if (this.a == null || a == null || this.a.G() != a.G() || i.equals(eVar.b()) == 0) {
                b();
            }
            f.a(getContext()).a(eVar, aDItemView, iVar);
        } else {
            i = f.a;
        }
        view.setOnClickListener(new i(this));
    }

    public String getViewPositionKey() {
        return this.e;
    }

    public final String a(String str) {
        this.e = str;
        return str;
    }

    public AD_LAYOUT_TYPE getADType() {
        return AD_LAYOUT_TYPE.IMAGE_TYPE_VIEW;
    }

    protected void a(Context context) {
        this.c.a = (ImageView) findViewById(R.id.iv_avatar);
        this.c.b = (TextView) findViewById(R.id.tv_publisher_name);
        this.c.c = (TextView) findViewById(R.id.item_title);
        this.c.d = (ImageView) findViewById(R.id.item_icon);
    }

    public void b() {
        this.a = null;
        this.c.a.setImageResource(R.drawable.feedflow_icon_default);
        this.c.a.setTag(this.c.a.getId(), null);
        this.c.b.setText("");
        this.c.c.setText("");
        this.c.d.setImageResource(R.drawable.choiceness_icon_default);
        this.c.d.setTag(this.c.d.getId(), null);
    }

    public final void a(l lVar) {
        if (!com.xunlei.downloadprovider.ad.common.f.a(getContext())) {
            if (lVar != null) {
                this.a = lVar;
                Map hashMap = new HashMap();
                hashMap.put("contentlist", f.a(getContext().getApplicationContext()).c.b(getViewPositionKey()));
                hashMap.put("is_system_refresh", String.valueOf(lVar.B));
                lVar.E = hashMap;
                lVar.F = hashMap;
                if (this.c != null) {
                    b(lVar);
                }
                Set set = f.a(getContext()).c.c;
                StringBuilder stringBuilder = new StringBuilder("first model.source: ");
                stringBuilder.append(lVar.G());
                stringBuilder.append(" viewPositionKey: ");
                stringBuilder.append(this.e);
                stringBuilder = new StringBuilder("second record != null: ");
                boolean z = false;
                stringBuilder.append(set != null);
                stringBuilder.append("  (record != null) && !record.contains(viewPositionKey): ");
                if (!(set == null || set.contains(this.e))) {
                    z = true;
                }
                stringBuilder.append(z);
                if (!(set == null || set.contains(this.e))) {
                    set.add(this.e);
                    new StringBuilder("third onShow viewPositionKey: ").append(this.e);
                    lVar.a(this);
                }
            } else {
                lVar = f.a;
            }
            if ((this.a instanceof com.xunlei.downloadprovider.ad.common.adget.c.f) != null) {
                ((com.xunlei.downloadprovider.ad.common.adget.c.f) this.a).a = this;
            }
        }
    }

    protected void b(l lVar) {
        String[] a = u.a(lVar.j(), lVar.m());
        CharSequence charSequence = a[0];
        if (TextUtils.isEmpty(lVar.k()) || TextUtils.isEmpty(charSequence)) {
            setPublisherViewVisibility(8);
        } else {
            com.xunlei.downloadprovider.homepage.choiceness.b.a();
            com.xunlei.downloadprovider.homepage.choiceness.b.a(this.a.k(), this.c.a);
            this.c.b.setText(charSequence);
            setPublisherViewVisibility(0);
        }
        this.c.c.setText(a[1]);
        if (!TextUtils.isEmpty(lVar.l())) {
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.a.l(), this.c.d, null);
        }
        c();
        c(lVar);
    }

    private void setPublisherViewVisibility(int i) {
        this.c.a.setVisibility(i);
        this.c.b.setVisibility(i);
    }

    public final void a() {
        a(this.a);
    }

    static /* synthetic */ void a(ADImageItemviewBase aDImageItemviewBase) {
        if (aDImageItemviewBase.a != null) {
            aDImageItemviewBase.a.onClick(aDImageItemviewBase);
            if (aDImageItemviewBase.a.w() && aDImageItemviewBase.a.c() == AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG) {
                String s = aDImageItemviewBase.a.s();
                if (!TextUtils.isEmpty(s)) {
                    DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                    downloadAdditionInfo.b = aDImageItemviewBase.a.p();
                    downloadAdditionInfo.a = aDImageItemviewBase.a.o();
                    downloadAdditionInfo.f = true;
                    TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(aDImageItemviewBase.a), s, null);
                    g.a();
                    g.a(s, aDImageItemviewBase.a.o(), taskStatInfo, downloadAdditionInfo);
                }
            }
        }
    }

    static /* synthetic */ void a(ADImageItemviewBase aDImageItemviewBase, OnClickListener onClickListener) {
        if (aDImageItemviewBase.f == null) {
            aDImageItemviewBase.f = new XLAlertDialog(aDImageItemviewBase.getContext());
            aDImageItemviewBase.f.setTitle((CharSequence) "温馨提示");
            aDImageItemviewBase.f.setMessage((CharSequence) "当前为移动网络，开始下载/安装应用？");
            aDImageItemviewBase.f.setConfirmButtonText((CharSequence) "确认");
            aDImageItemviewBase.f.setCancelButtonText((CharSequence) "取消");
            aDImageItemviewBase.f.setOnClickConfirmButtonListener(onClickListener);
            aDImageItemviewBase.f.setOnClickCancelButtonListener(new k(aDImageItemviewBase));
        }
    }
}
