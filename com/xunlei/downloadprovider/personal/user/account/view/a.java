package com.xunlei.downloadprovider.personal.user.account.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.util.Calendar;

/* compiled from: UserDatePickerDialog */
public final class a extends Dialog {
    public a a;
    private Context b;
    private TextView c;
    private TextView d;
    private int e;
    private int f;
    private int g;
    private String h;

    /* compiled from: UserDatePickerDialog */
    public interface a {
        void a();

        void a(int i, int i2, int i3);
    }

    public a(Context context, String str) {
        super(context, R.style.datePickerDialog);
        this.b = context;
        this.h = str;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.h == null || this.h.isEmpty() != null) {
            bundle = Calendar.getInstance();
            this.e = bundle.get(1);
            this.f = bundle.get(2) + 1;
            this.g = bundle.get(5);
        } else {
            this.e = Integer.valueOf(this.h.substring(0, 4)).intValue();
            this.f = Integer.valueOf(this.h.substring(4, 6)).intValue();
            this.g = Integer.valueOf(this.h.substring(6, 8)).intValue();
        }
        bundle = LayoutInflater.from(this.b).inflate(R.layout.date_picker_dialog, null);
        DatePicker datePicker = (DatePicker) bundle.findViewById(R.id.date_picker);
        datePicker.setMaxDate(System.currentTimeMillis());
        this.c = (TextView) bundle.findViewById(R.id.tv_dlg_left_btn);
        this.d = (TextView) bundle.findViewById(R.id.tv_dlg_right_btn);
        datePicker.init(this.e, this.f - 1, this.g, new b(this));
        setContentView(bundle);
        this.c.setOnClickListener(new c(this));
        this.d.setOnClickListener(new d(this));
    }

    public final void show() {
        super.show();
    }
}
