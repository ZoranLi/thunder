package com.xunlei.downloadprovider.web.website.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.b.e;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.d;

/* compiled from: WebsiteMoreOperationDialog */
public final class h extends XLBaseDialog {
    public e a;
    public String b;
    public int c;
    private View d;
    private TextView e;
    private a f;
    private Context g;
    private Button h;

    /* compiled from: WebsiteMoreOperationDialog */
    public interface a {
        void a();
    }

    public h(Context context, a aVar) {
        super(context, R.style.bt_create_dialog);
        this.g = context;
        this.f = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.download_collection_more_operation_view_layout);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.d = findViewById(R.id.container);
        this.d.setOnClickListener(new i(this));
        this.e = (TextView) findViewById(R.id.deleteButton);
        this.e.setOnClickListener(new j(this));
        this.h = (Button) findViewById(R.id.cancelButton);
        this.h.setOnClickListener(new n(this));
        if (this.b == "collect") {
            a();
        }
        bundle = getWindow();
        LayoutParams attributes = bundle.getAttributes();
        attributes.gravity = 81;
        attributes.width = d.a(getContext().getApplicationContext());
        attributes.height = -2;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        attributes.windowAnimations = R.style.PopupBottomInAnim;
        bundle.setAttributes(attributes);
    }

    public final void a() {
        if (this.e != null && this.h != null) {
            this.e.setText("取消收藏");
            this.h.setText("取消");
        }
    }
}
