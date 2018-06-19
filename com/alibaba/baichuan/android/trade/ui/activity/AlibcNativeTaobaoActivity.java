package com.alibaba.baichuan.android.trade.ui.activity;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.e.a;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import com.igexin.sdk.PushConsts;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public class AlibcNativeTaobaoActivity extends Activity {
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (intent != null) {
            Intent intent2 = null;
            setIntent(null);
            String stringExtra = intent.getStringExtra("actionName");
            StringBuilder stringBuilder;
            if ("showNative".equals(stringExtra)) {
                String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_ID);
                Map map = (Map) intent.getSerializableExtra("actionParameters");
                if (intent.getSerializableExtra(PushConsts.KEY_SERVICE_PIT) != null) {
                    intent2 = (String) intent.getSerializableExtra(PushConsts.KEY_SERVICE_PIT);
                }
                String str = intent2;
                ApplinkOpenType applinkOpenType = (ApplinkOpenType) intent.getSerializableExtra("type");
                stringBuilder = new StringBuilder("AlibcNativeTaobaoActivity.start()--Back From NativeTaobao: action:showNative itemId:");
                stringBuilder.append(stringExtra2 == null ? "null" : stringExtra2);
                stringBuilder.append(" taokePid:");
                stringBuilder.append(str == null ? "null" : str);
                AlibcContext.b();
                if (!d.a(this, applinkOpenType, null, stringExtra2, a.g().f(), str, "alisdk://", map)) {
                    finish();
                }
                return;
            }
            if (isTaskRoot()) {
                stringBuilder = new StringBuilder("AlibcNativeTaobaoActivity.start()--Back From NativeTaobao(jump through scheme url): action:");
                if (stringExtra == null) {
                    stringExtra = "null";
                }
                stringBuilder.append(stringExtra);
                AlibcContext.b();
                intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
                intent.addFlags(67108864);
                startActivity(intent);
            }
            finish();
            return;
        }
        finish();
    }
}
