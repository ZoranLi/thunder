package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.downloadlist.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import org.android.agoo.message.MessageService;

/* compiled from: TaskDetailStyleDownloadListAdView */
public class j extends a {
    private static final String k = "j";
    protected ViewGroup c;
    protected ImageView d;
    protected TextView e;
    protected RatingBar f;
    protected TextView g;
    protected View h;
    protected TextView i;
    protected TextView j;
    private View l = null;

    public String getAdUIStyle() {
        return MessageService.MSG_DB_COMPLETE;
    }

    public j(Context context) {
        super(context);
        a();
    }

    protected final void b() {
        super.b();
        this.l = LayoutInflater.from(this.a).inflate(R.layout.layout_task_detail_ad_style_download_list, this);
        this.l.setLayoutParams(new LayoutParams(-1, -2));
        this.c = (ViewGroup) this.l.findViewById(R.id.parent_view);
        this.d = (ImageView) this.l.findViewById(R.id.iconImageView);
        this.e = (TextView) this.l.findViewById(R.id.titleTextView);
        this.h = this.l.findViewById(R.id.closeButton);
        this.i = (TextView) this.l.findViewById(R.id.actionButton);
        this.j = (TextView) this.l.findViewById(R.id.tagView);
        this.f = (RatingBar) this.l.findViewById(R.id.score_rb);
        this.g = (TextView) this.l.findViewById(R.id.install_count);
    }

    protected final void c() {
        super.c();
        setOnClickListener(new k(this));
        this.h.setOnClickListener(new l(this));
    }

    public final void a(@NonNull l lVar) {
        CharSequence trim;
        String k;
        this.b = lVar;
        a(getBottomMarginWhileShow());
        this.e.setText(this.b.m());
        this.f.setRating(this.b.q());
        lVar = this.i;
        l lVar2 = this.b;
        if (lVar2.x() != null) {
            if (!lVar2.x().trim().equals("")) {
                trim = lVar2.x().trim();
                lVar.setText(trim);
                lVar = a.a(this.b.n());
                if (!TextUtils.isEmpty(lVar)) {
                    if (lVar.equals("0")) {
                        this.g.setText(lVar);
                        this.g.setVisibility(0);
                        this.j.setText(f.a(this.b, R.string.choiceness_ad_source_guanggao));
                        lVar = getContext();
                        k = this.b.k();
                        c.b(lVar, k).placeholder(R.drawable.task_detail_image_ad_default_icon).error(R.drawable.task_detail_image_ad_default_icon).fallback(R.drawable.task_detail_image_ad_default_icon).listener(null).into(this.d);
                        setLayoutVisibility(0);
                        b(this.b);
                    }
                }
                this.g.setVisibility(8);
                this.j.setText(f.a(this.b, R.string.choiceness_ad_source_guanggao));
                lVar = getContext();
                k = this.b.k();
                c.b(lVar, k).placeholder(R.drawable.task_detail_image_ad_default_icon).error(R.drawable.task_detail_image_ad_default_icon).fallback(R.drawable.task_detail_image_ad_default_icon).listener(null).into(this.d);
                setLayoutVisibility(0);
                b(this.b);
            }
        }
        if (lVar2.u() == 2) {
            int D = lVar2.D();
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            String string = BrothersApplication.getApplicationInstance().getString(R.string.ad_app_status_undownload_short);
            switch (D) {
                case 1:
                    trim = applicationInstance.getString(R.string.ad_app_status_undownload_short);
                    break;
                case 2:
                    trim = applicationInstance.getString(R.string.ad_app_status_downloading_short);
                    break;
                case 3:
                    trim = applicationInstance.getString(R.string.ad_app_status_uninstall_short);
                    break;
                case 4:
                    trim = applicationInstance.getString(R.string.ad_app_status_intalled_short);
                    break;
                default:
                    trim = string;
                    break;
            }
        }
        trim = BrothersApplication.getApplicationInstance().getString(R.string.ad_web_action_name_short);
        lVar.setText(trim);
        lVar = a.a(this.b.n());
        if (TextUtils.isEmpty(lVar)) {
            if (lVar.equals("0")) {
                this.g.setText(lVar);
                this.g.setVisibility(0);
                this.j.setText(f.a(this.b, R.string.choiceness_ad_source_guanggao));
                lVar = getContext();
                k = this.b.k();
                c.b(lVar, k).placeholder(R.drawable.task_detail_image_ad_default_icon).error(R.drawable.task_detail_image_ad_default_icon).fallback(R.drawable.task_detail_image_ad_default_icon).listener(null).into(this.d);
                setLayoutVisibility(0);
                b(this.b);
            }
        }
        this.g.setVisibility(8);
        this.j.setText(f.a(this.b, R.string.choiceness_ad_source_guanggao));
        lVar = getContext();
        k = this.b.k();
        c.b(lVar, k).placeholder(R.drawable.task_detail_image_ad_default_icon).error(R.drawable.task_detail_image_ad_default_icon).fallback(R.drawable.task_detail_image_ad_default_icon).listener(null).into(this.d);
        setLayoutVisibility(0);
        b(this.b);
    }

    private void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = i;
        }
    }

    public final void d() {
        this.b = null;
        a(getBottomMarginWhileHide());
        setLayoutVisibility(8);
        this.d.setImageResource(R.drawable.download_ad_background);
    }

    private void setLayoutVisibility(int i) {
        this.c.setVisibility(i);
    }
}
