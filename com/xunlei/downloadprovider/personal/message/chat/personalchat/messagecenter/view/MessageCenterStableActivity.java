package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.MessageItemFragment;
import com.xunlei.downloadprovider.personal.message.d.a;

public class MessageCenterStableActivity extends BaseMessageCenterActivity implements a {
    private MessageItemFragment a = null;
    private MessageType c = null;
    private TitleBar d = null;

    public final void a() {
    }

    public static void a(Context context, MessageType messageType) {
        Intent intent = new Intent(context, MessageCenterStableActivity.class);
        intent.putExtra(PushMessageHelper.MESSAGE_TYPE, messageType);
        context.startActivity(intent);
    }

    protected final void a(Bundle bundle) {
        super.a(bundle);
        setContentView(R.layout.activity_message_center_stable);
        bundle = getIntent();
        if (bundle != null) {
            this.c = (MessageType) bundle.getSerializableExtra(PushMessageHelper.MESSAGE_TYPE);
        }
        this.d = new TitleBar((Activity) this);
        bundle = "";
        switch (q.a[this.c.ordinal()]) {
            case 1:
                bundle = "访客";
                break;
            case 2:
                bundle = "评论";
                break;
            case 3:
                bundle = "粉丝";
                break;
            case 4:
                bundle = "赞";
                break;
            default:
                break;
        }
        this.d.mTitle.setText(bundle);
        this.d.mLeft.setOnClickListener(new p(this));
        this.a = (MessageItemFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        bundle = getSupportFragmentManager().beginTransaction();
        if (this.a == null) {
            this.a = MessageItemFragment.a(this.c);
            bundle.add(R.id.fragment_container, this.a);
        }
        bundle.commit();
    }

    protected final void h() {
        super.h();
        if (this.a != null) {
            this.a.a();
        }
    }

    public final void a(Object obj) {
        if (this.a != null) {
            this.a.a(true);
        }
    }
}
