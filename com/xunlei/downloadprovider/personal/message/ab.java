package com.xunlei.downloadprovider.personal.message;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: MessageMenuDialog */
public final class ab extends Dialog {
    Button a = ((Button) this.g.findViewById(R.id.btn_zan));
    Button b = ((Button) this.g.findViewById(R.id.btn_report));
    Button c = ((Button) this.g.findViewById(R.id.btn_delete));
    Button d = ((Button) this.g.findViewById(R.id.btn_cancel));
    Button e = ((Button) this.g.findViewById(R.id.btn_link));
    CommentInfo f;
    private View g;

    public ab(Context context) {
        super(context);
        this.g = LayoutInflater.from(context).inflate(R.layout.menu_message_dialog, null);
        this.d.setOnClickListener(new ac(this));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        getContext();
        setContentView(this.g);
        bundle = getWindow();
        bundle.setGravity(81);
        bundle.setWindowAnimations(R.style.bottom_dialog_animation);
        bundle.setBackgroundDrawable(new ColorDrawable(0));
        bundle.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        bundle.setAttributes(attributes);
    }

    public final void show() {
        super.show();
    }
}
