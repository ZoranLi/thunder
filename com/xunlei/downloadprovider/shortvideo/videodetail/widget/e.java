package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.thunder.commonui.widget.CircleImageView;

/* compiled from: PersonalSpaceFollowDialog */
public final class e extends XLBaseDialog {
    public CircleImageView a;
    public CircleImageView b;
    public TextView c;
    public VideoUserInfo d;
    public Button e;
    private View f = LayoutInflater.from(this.mCtx).inflate(R.layout.personal_follow_popview, null);

    public e(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        setContentView(this.f);
        context = getWindow();
        LayoutParams attributes = context.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        context.setAttributes(attributes);
        attributes = getWindow().getAttributes();
        attributes.alpha = 1.0f;
        attributes.dimAmount = 0.6f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        context.setWindowAnimations(R.style.bottom_dialog_animation);
        this.d = new VideoUserInfo();
        this.a = (CircleImageView) findViewById(R.id.iv_avatar);
        this.b = (CircleImageView) findViewById(R.id.iv_avatar_type);
        this.c = (TextView) findViewById(R.id.tv_nickname);
        this.e = (Button) findViewById(R.id.btn_follow);
        this.b.setVisibility(8);
    }

    public final View findViewById(int i) {
        return this.f.findViewById(i);
    }
}
