package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class ADActivity extends Activity {
    private ACTD a;

    public void onBackPressed() {
        super.onBackPressed();
        if (this.a != null) {
            this.a.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.a != null) {
            this.a.onConfigurationChanged(configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        String string = intent.getExtras().getString(ACTD.DELEGATE_NAME_KEY);
        String string2 = intent.getExtras().getString("appid");
        if (!StringUtil.isEmpty(string)) {
            if (!StringUtil.isEmpty(string2)) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                        this.a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                        if (this.a == null) {
                            StringBuilder stringBuilder = new StringBuilder("Init ADActivity Delegate return null,delegateName");
                            stringBuilder.append(string);
                            string2 = stringBuilder.toString();
                        }
                    } else {
                        string2 = "Init GDTADManager fail in AdActivity";
                    }
                    GDTLogger.e(string2);
                } catch (Throwable th) {
                    StringBuilder stringBuilder2 = new StringBuilder("Init ADActivity Delegate Faile,DelegateName:");
                    stringBuilder2.append(string);
                    GDTLogger.e(stringBuilder2.toString(), th);
                }
            }
        }
        if (this.a != null) {
            this.a.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        if (this.a != null) {
            this.a.onAfterCreate(bundle);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.onDestroy();
        }
    }

    public void onPause() {
        if (this.a != null) {
            this.a.onPause();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.a != null) {
            this.a.onResume();
        }
    }

    protected void onStop() {
        if (this.a != null) {
            this.a.onStop();
        }
        super.onStop();
    }
}
