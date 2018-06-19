package com.xunlei.downloadprovider.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.XLIntent;

public class XLAlarmDialogActivity extends XLBaseDialogActivity {
    private static boolean j = false;
    private View a;
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private int i;
    private long k;
    private String l;

    protected final int a() {
        return 5;
    }

    public static void a(Context context, long j) {
        if (a.a().a(5)) {
            Intent xLIntent = new XLIntent(context, XLAlarmDialogActivity.class);
            xLIntent.putExtra("type", 100100);
            xLIntent.putExtra("taskId", j);
            xLIntent.setFlags(268435456);
            context.startActivity(xLIntent);
        }
    }

    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.i = intent.getIntExtra("type", 100100);
        this.k = intent.getLongExtra("taskId", -1);
        this.l = intent.getStringExtra("bandwidth");
        if (this.i == XLStatCommandID.XLCID_WX_LOGIN_BIND) {
            setTheme(R.style.ThunderTheme.Dialog);
        }
        super.onCreate(bundle);
        setContentView(R.layout.new_xl_dialog);
        this.a = findViewById(R.id.dlg_2btn_layout);
        this.c = findViewById(R.id.dlg_1btn_layout);
        this.d = (TextView) findViewById(R.id.dlg_title);
        this.e = (TextView) findViewById(R.id.dlg_content);
        this.f = (TextView) findViewById(R.id.dlg_left_btn);
        this.g = (TextView) findViewById(R.id.dlg_right_btn);
        this.h = (TextView) findViewById(R.id.dlg_bottom_btn);
        bundle = new b(this);
        this.f.setOnClickListener(bundle);
        this.h.setOnClickListener(bundle);
        switch (this.i) {
            case 100100:
                this.d.setVisibility(0);
                this.a.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setText(R.string.xa_task_existed);
                this.g.setText(R.string.xa_see);
                this.g.setOnClickListener(new c(this));
                break;
            case XLStatCommandID.XLCID_WX_LOGIN_AUTH /*100101*/:
                this.c.setVisibility(0);
                this.e.setText(R.string.xa_no_sd);
                this.h.setText(R.string.ok);
                break;
            case XLStatCommandID.XLCID_WX_LOGIN_BIND /*100102*/:
                this.c.setVisibility(0);
                this.e.setText(R.string.account_kick);
                this.h.setText(R.string.gotit);
                this.h.setOnClickListener(new d(this));
                break;
            case XLStatCommandID.XLCID_WX_LOGIN_ERROR /*100103*/:
                this.d.setVisibility(0);
                this.a.setVisibility(0);
                this.d.setText(getResources().getString(R.string.kuainiao_dialog_title));
                this.e.setText(getResources().getString(R.string.kuainiao_dialog_content, new Object[]{this.l}));
                this.g.setText(getResources().getString(R.string.kuainiao_open_member));
                this.g.setOnClickListener(new e(this));
                break;
            default:
                break;
        }
        j = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(this).getScaledWindowTouchSlop();
            View decorView = getWindow().getDecorView();
            int i = -scaledWindowTouchSlop;
            if (x >= i && y >= i && x <= decorView.getWidth() + scaledWindowTouchSlop) {
                if (y <= decorView.getHeight() + scaledWindowTouchSlop) {
                    z = false;
                    if (z && this.i == 100100) {
                        finish();
                        return true;
                    }
                }
            }
            z = true;
            finish();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onDestroy() {
        super.onDestroy();
        j = false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
