package com.xunlei.downloadprovider.cardslide.likelist;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.cardslide.likelist.a.a;
import com.xunlei.downloadprovider.cardslide.likelist.c.c;
import com.xunlei.downloadprovider.cardslide.likelist.c.d;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.Collection;
import java.util.List;

public class CardSlideLikeActivity extends BaseActivity implements MessageListener, g {
    private static final String a = "CardSlideLikeActivity";
    private RecyclerView c;
    private a d;
    private ErrorBlankView e;
    private UnifiedLoadingView f;
    private StaticHandler g;
    private List<com.xunlei.downloadprovider.cardslide.likelist.c.a> h;
    private int i;

    public final void a(int i, Object obj) {
    }

    public final void a(String str) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_card_slide_like);
        new TitleBar((Activity) this).mTitle.setText("我喜欢的");
        this.c = (RecyclerView) findViewById(R.id.recycler_view_card_like);
        this.e = (ErrorBlankView) findViewById(R.id.ev_card_like_error);
        this.e.setErrorType(0);
        this.e.a(null, null);
        this.e.setVisibility(4);
        this.f = (UnifiedLoadingView) findViewById(R.id.lv_card_like_loading);
        this.f.setType(2);
        this.f.hide();
        this.c.setLayoutManager(new LinearLayoutManager(this));
        this.c.addItemDecoration(new a(this));
        this.d = new a(this);
        this.c.setAdapter(this.d);
        this.c.addOnScrollListener(new b(this));
        this.g = new StaticHandler(this);
        this.f.show();
        this.e.setVisibility(4);
        this.i = 0;
        b(null);
    }

    private void b(String str) {
        XLThreadPool.execute(new d(c.a(), str, new c(this)));
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case SecExceptionCode.SEC_ERROE_OPENSDK_DECODE_FAILED /*1102*/:
                this.f.hide();
                this.h = (List) message.obj;
                message = this.d;
                Collection collection = this.h;
                if (collection != null && collection.size() > 0) {
                    message.a.addAll(collection);
                    message.notifyDataSetChanged();
                }
                return;
            case SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH /*1103*/:
                this.e.setErrorType(0);
                break;
            default:
                break;
        }
    }
}
