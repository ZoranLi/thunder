package com.huawei.hms.update.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.android.hms.base.R;
import java.text.NumberFormat;

/* compiled from: ProgressNoCancel */
public class l extends b {
    private ProgressBar a;
    private TextView b;
    private OnKeyListener c = new a();

    /* compiled from: ProgressNoCancel */
    private static class a implements OnKeyListener {
        private a() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return (i == 4 && keyEvent.getRepeatCount() == null) ? true : null;
        }
    }

    public AlertDialog a() {
        Builder builder = new Builder(f(), g());
        View inflate = View.inflate(f(), R.layout.hms_download_progress, null);
        builder.setView(inflate);
        builder.setCancelable(false);
        builder.setOnKeyListener(this.c);
        this.a = (ProgressBar) inflate.findViewById(R.id.download_info_progress);
        this.b = (TextView) inflate.findViewById(R.id.hms_progress_text);
        a(0);
        return builder.create();
    }

    void a(int i) {
        Activity f = f();
        if (f != null) {
            if (!f.isFinishing()) {
                if (this.b != null) {
                    if (this.a != null) {
                        this.a.setProgress(i);
                        this.b.setText(NumberFormat.getPercentInstance().format((double) (((float) i) / 1120403456)));
                        return;
                    }
                }
                return;
            }
        }
        com.huawei.hms.support.log.a.c("ProgressNoCancel", "In setDownloading, The activity is null or finishing.");
    }
}
