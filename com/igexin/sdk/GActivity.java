package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.b.a.c.a;
import com.igexin.push.core.a.f;

public class GActivity extends Activity {
    public static final String TAG = "com.igexin.sdk.GActivity";

    protected void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        try {
            Intent intent2 = getIntent();
            intent = new Intent(this, f.a().a(this));
            if (intent2 != null) {
                if (intent2.hasExtra("action") && intent2.hasExtra("isSlave")) {
                    intent.putExtra("action", intent2.getStringExtra("action"));
                    intent.putExtra("isSlave", intent2.getBooleanExtra("isSlave", false));
                    if (intent2.hasExtra("op_app")) {
                        intent.putExtra("op_app", intent2.getStringExtra("op_app"));
                    }
                    StringBuilder stringBuilder = new StringBuilder("GActivity action = ");
                    stringBuilder.append(intent2.getStringExtra("action"));
                    stringBuilder.append(", isSlave = ");
                    stringBuilder.append(intent2.getBooleanExtra("isSlave", false));
                    a.b(stringBuilder.toString());
                }
            }
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(TAG);
            stringBuilder.append("|put extra exception");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(TAG);
            stringBuilder2.append(th.toString());
            a.b(stringBuilder2.toString());
        }
        startService(intent);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(TAG);
        stringBuilder3.append("|start PushService from GActivity");
        a.b(stringBuilder3.toString());
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
