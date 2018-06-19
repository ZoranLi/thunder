package com.xunlei.downloadprovider.vod.subtitle;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class StepAdjustView extends LinearLayout implements OnClickListener {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private Button d;
    private int e;
    private a f;

    public interface a {
    }

    public StepAdjustView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public StepAdjustView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void onClick(View view) {
        view = view.getId();
        int i;
        if (view == R.id.iv_dec) {
            i = this.e - 500;
            if (i < -600000) {
                i = -600000;
            }
            a(i);
        } else if (view == R.id.iv_add) {
            i = this.e + 500;
            if (i > 600000) {
                i = 600000;
            }
            a(i);
        } else {
            if (view == R.id.btn_reset) {
                a((int) null);
            }
        }
    }

    private void a(int i) {
        if (i != this.e) {
            this.e = i;
            if (i == 0) {
                i = "0";
            } else {
                i = String.format("%+.1fs", new Object[]{Float.valueOf(((float) i) / 1148846080)});
            }
            this.c.setText(i);
        }
    }

    public void setOnValueChangeListener(a aVar) {
        this.f = aVar;
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.step_adjust_view, this);
        this.a = (ImageView) findViewById(R.id.iv_dec);
        this.b = (ImageView) findViewById(R.id.iv_add);
        this.c = (TextView) findViewById(R.id.tv_value);
        this.d = (Button) findViewById(R.id.btn_reset);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }
}
