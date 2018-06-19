package com.xunlei.downloadprovider.discovery.kuainiao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.BaseFragment;
import com.xunlei.xllib.android.XLIntent;

public class KuaiNiaoActivity extends BaseActivity {
    public static final String a = "KuaiNiaoActivity";
    private int c = R.id.activity_content_flay;
    private BaseFragment d;

    public static Intent a(Context context, String str) {
        Bundle bundle = new Bundle(2);
        bundle.putBoolean("from_where", false);
        bundle.putString("referfrom", str);
        str = new XLIntent(context, KuaiNiaoActivity.class);
        str.putExtras(bundle);
        return str;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.homepage_main_entry);
        d.a().c = true;
        a(getIntent());
    }

    public void onResume() {
        super.onResume();
    }

    protected void onNewIntent(Intent intent) {
        a(intent);
    }

    private void a(Intent intent) {
        if (intent != null) {
            d.a().e = intent.getStringExtra("referfrom");
            setIntent(intent);
            intent = getIntent();
            if (intent != null) {
                this.d = new KuaiNiaoFragment();
                if (intent.getExtras() != null) {
                    this.d.setExtras(intent.getExtras());
                }
                intent = getSupportFragmentManager().beginTransaction();
                intent.replace(this.c, this.d);
                intent.commitAllowingStateLoss();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.d != null && this.d.onBackPressed()) {
            return true;
        }
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        d.a().c = false;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }
}
