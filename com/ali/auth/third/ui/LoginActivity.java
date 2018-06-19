package com.ali.auth.third.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.ali.auth.third.core.j.e;
import com.ali.auth.third.ui.a.a;
import org.android.agoo.common.AgooConstants;

public class LoginActivity extends Activity {
    LinearLayout a;
    private Context b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((LinearLayout) getLayoutInflater().inflate(e.a(this, "layout", "login_hidden"), null));
        this.b = this;
        this.a = (LinearLayout) findViewById(e.a(this, AgooConstants.MESSAGE_ID, "login_layout"));
        this.a.setOnClickListener(new a(this));
        this.a.setClickable(false);
        this.a.setLongClickable(false);
        a.a((Activity) this);
        bundle = com.ali.auth.third.core.config.a.a;
        com.ali.auth.third.a.a.b.a((Activity) this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.a.setClickable(true);
        this.a.setLongClickable(true);
        boolean z = com.ali.auth.third.core.config.a.a;
        super.onActivityResult(i, i2, intent);
        if (a.a == 0) {
            a.a((Activity) this);
        }
        a.a(i);
    }
}
