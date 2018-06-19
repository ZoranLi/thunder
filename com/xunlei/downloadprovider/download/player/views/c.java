package com.xunlei.downloadprovider.download.player.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: ThunderCommandDialog */
public final class c extends XLBaseDialog {
    private String a;
    private com.xunlei.downloadprovidershare.a.c b;

    public c(Context context, f fVar, String str) {
        super(context);
        this.a = str;
        this.b = (com.xunlei.downloadprovidershare.a.c) fVar;
        setContentView(R.layout.thunder_command_dialog);
        findViewById(R.id.dialog_back).setOnClickListener(new d(this));
        ((TextView) findViewById(R.id.dialog_text)).setText(fVar.f);
        findViewById(R.id.dialog_copy).setOnClickListener(new e(this, fVar));
    }

    public final boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isOutOfBounds(getContext(), motionEvent)) {
            a.d(this.a, this.b.a, "close");
        }
        return super.onTouchEvent(motionEvent);
    }
}
