package com.xunlei.tdlive.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.modal.a.a;
import com.xunlei.tdlive.route.XLLiveRouteDispatcher;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.sdk.b;

public class FocusFloatingLayerView extends FrameLayout implements OnClickListener, a {
    private int a;
    private String b;
    private TextView c;
    private FloatingLayerAnchorInfoView d;
    private FloatingLayerAnchorNumView e;

    public FocusFloatingLayerView(Context context) {
        super(context);
    }

    public FocusFloatingLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FocusFloatingLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.c = (TextView) findViewById(R.id.floating_layer_normal);
        this.d = (FloatingLayerAnchorInfoView) findViewById(R.id.floating_layer_anchor_info);
        this.e = (FloatingLayerAnchorNumView) findViewById(R.id.floating_layer_anchor_num);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        findViewById(R.id.info_close).setOnClickListener(this);
        a();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.xunlei.tdlive.modal.a.a().a(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.xunlei.tdlive.modal.a.a().b(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.info_close) {
            view = com.xunlei.tdlive.modal.a.a().i();
            if (view != null) {
                com.xunlei.tdlive.sdk.a.d("attentionhost_pro_down").a("hostid", view.getString("userid", "")).b(new String[0]);
            }
            com.xunlei.tdlive.modal.a.a().j();
            return;
        }
        if (this.a != null) {
            if (this.a != 2) {
                if (this.a == 1) {
                    b.a().a(getContext(), "", new b.a(this) {
                        final /* synthetic */ FocusFloatingLayerView a;

                        {
                            this.a = r1;
                        }

                        public void a(boolean z) {
                            if (z) {
                                z = com.xunlei.tdlive.modal.a.a().i();
                                if (z) {
                                    JsonWrapper object = z.getObject(PushResult.ROOM_INFO, "{}");
                                    XLLiveRouteDispatcher.getInstance().room(object.getString("roomid", ""), z.getString("userid", ""), object.getString("stream_pull", ""), z.getString("avatar", ""), z.getString("image", ""), "zb_home_livefloat_item");
                                }
                                com.xunlei.tdlive.modal.a.a().j();
                            }
                        }
                    });
                }
                return;
            }
        }
        b.a().a(getContext(), "", new b.a(this) {
            final /* synthetic */ FocusFloatingLayerView a;

            {
                this.a = r1;
            }

            public void a(boolean z) {
                if (z) {
                    com.xunlei.tdlive.sdk.a.d("zb_home_follow_icon").a("from", this.a.a == 0 ? "home_nonelive_float" : "home_manylive_float").b(new String[0]);
                    XLLiveRouteDispatcher.getInstance().followlist(b.a().e(), b.a().i(), b.a().j(), "live");
                }
            }
        });
    }

    public void onFocusLiveRemindStateChanged() {
        a();
    }

    private void a() {
        JsonWrapper i;
        this.a = 0;
        if (b.a().b()) {
            i = com.xunlei.tdlive.modal.a.a().i();
            if (i != null) {
                this.a = 1;
            } else if (com.xunlei.tdlive.modal.a.a().f() > 0) {
                this.a = 2;
            }
        } else {
            i = null;
        }
        switch (this.a) {
            case 0:
                this.c.setVisibility(0);
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                break;
            case 1:
                this.d.refreshView(i.getString("avatar", ""), com.xunlei.tdlive.modal.a.a().h(), i.getString("nickname", ""), i.getObject(PushResult.ROOM_INFO, "{}").getString("title", "快来看看我吧"));
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setVisibility(8);
                break;
            case 2:
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                this.e.refreshView(com.xunlei.tdlive.modal.a.a().g());
                setVisibility(0);
                break;
            default:
                break;
        }
        if (i != null && !i.getString("userid", "").equals(this.b)) {
            this.b = i.getString("userid", "");
            com.xunlei.tdlive.sdk.a.d("attentionhost_pro_show").a("hostid", this.b).b(new String[0]);
        }
    }
}
