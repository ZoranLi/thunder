package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.cooperation.ui.widgets.CenterTextView;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: CooperationSceneTipDialog */
public final class f extends XLBaseDialog implements OnClickListener {
    protected String a = getClass().getSimpleName();
    a b = null;
    private Context c;
    private TextView d;
    private CenterTextView e;
    private RelativeLayout f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private CooperationScene m;
    private CooperationItem n;
    private SceneUiStyle o;

    public f(Context context, SceneUiStyle sceneUiStyle) {
        super(context, R.style.ThunderTheme.Dialog);
        setContentView(R.layout.layout_change_amount_scene_tip_dialog);
        setCanceledOnTouchOutside(true);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        getWindow().setAttributes(attributes);
        this.c = context;
        this.o = sceneUiStyle;
        this.d = (TextView) findViewById(R.id.tv_tip_title);
        this.e = (CenterTextView) findViewById(R.id.tv_tip_content);
        this.f = (RelativeLayout) findViewById(R.id.rl_three_button_layout);
        this.g = (LinearLayout) findViewById(R.id.ll_two_button_layout);
        this.h = (TextView) findViewById(R.id.tv_go_to_change_amount_corp_apk);
        this.i = (TextView) findViewById(R.id.tv_cancle);
        this.j = (TextView) findViewById(R.id.tv_continue);
        this.k = (TextView) findViewById(R.id.tv_cancle_btn);
        this.l = (TextView) findViewById(R.id.tv_confirm_btn);
        int i = 8;
        this.f.setVisibility(this.o.equals(SceneUiStyle.THREE_BUTTON) != null ? null : 8);
        context = this.g;
        if (this.o.equals(SceneUiStyle.TWO_BUTTON) != null) {
            i = 0;
        }
        context.setVisibility(i);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    public final void a(CooperationScene cooperationScene, CooperationItem cooperationItem, String str) {
        this.m = cooperationScene;
        this.n = cooperationItem;
        if (TextUtils.isEmpty(cooperationScene.getTitle()) == null) {
            this.d.setText(cooperationScene.getTitle());
        }
        if (TextUtils.isEmpty(cooperationScene.getContent()) == null) {
            this.e.setText(cooperationScene.getContent());
        }
        if (TextUtils.isEmpty(cooperationScene.getThirdDescription()) == null) {
            this.h.setText(cooperationScene.getThirdDescription());
        }
        if (TextUtils.isEmpty(cooperationScene.getLeftDescription()) == null) {
            if (this.o.equals(SceneUiStyle.THREE_BUTTON) != null) {
                this.i.setText(cooperationScene.getLeftDescription());
            } else if (this.o.equals(SceneUiStyle.TWO_BUTTON) != null) {
                this.k.setText(cooperationScene.getLeftDescription());
            }
        }
        if (TextUtils.isEmpty(cooperationScene.getRightDescription()) == null) {
            if (this.o.equals(SceneUiStyle.THREE_BUTTON) != null) {
                this.j.setText(cooperationScene.getRightDescription());
            } else if (this.o.equals(SceneUiStyle.TWO_BUTTON) != null) {
                this.l.setText(cooperationScene.getRightDescription());
            }
        } else if (this.o.equals(SceneUiStyle.THREE_BUTTON) != null && TextUtils.isEmpty(str) == null) {
            this.j.setText(str);
        }
        com.xunlei.downloadprovider.cooperation.a.a.b(l.c(this.m.getLocation()));
        if (this.n != null) {
            com.xunlei.downloadprovider.cooperation.a.a.a(l.c(this.n.getDisplayLocation()), this.n.getAppPackageName(), this.n.isShowInstallTip());
        }
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_go_to_change_amount_corp_apk:
            case R.id.tv_confirm_btn:
                if (this.b != null) {
                    this.b.b();
                }
                if (this.n != null) {
                    b.a().a(this.c, this.n, "");
                }
                dismiss();
                view = 2;
                break;
            case R.id.tv_continue:
                if (this.b != null) {
                    this.b.a();
                }
                dismiss();
                view = true;
                break;
            case R.id.tv_cancle:
            case R.id.tv_cancle_btn:
                if (this.b != null) {
                    this.b.onCancel();
                }
                dismiss();
                view = null;
                break;
            default:
                view = -1;
                break;
        }
        if (view >= null) {
            com.xunlei.downloadprovider.cooperation.a.a.b(l.c(this.m.getLocation()), String.valueOf(view));
        }
    }
}
