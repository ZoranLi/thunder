package com.qihoo360.replugin.component.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qihoo360.i.Factory2;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;

public class DynamicClassProxyActivity extends Activity {
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getComponent();
        if (bundle != null) {
            bundle = bundle.getClassName();
            String pluginByDynamicClass = Factory2.getPluginByDynamicClass(bundle);
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("DynamicClassProxyActivity.onCreate(), plugin = ");
                stringBuilder.append(pluginByDynamicClass);
                stringBuilder.append(", class = ");
                stringBuilder.append(bundle);
                c.a("loadClass", stringBuilder.toString());
            }
            if (!(TextUtils.isEmpty(pluginByDynamicClass) || RePlugin.isPluginInstalled(pluginByDynamicClass))) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(pluginByDynamicClass, bundle));
                RePlugin.getConfig().a.a(pluginByDynamicClass, intent);
            }
        }
        finish();
    }
}
