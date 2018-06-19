package com.xunlei.downloadprovider.launch.dispatch.mocklink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.xunlei.downloadprovider.launch.LaunchActivity;

public class LinkVodPlayerActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle == null) {
            bundle = new Intent(this, LaunchActivity.class);
        } else {
            bundle.setClass(this, LaunchActivity.class);
        }
        bundle.putExtra("dispatch_from_key", 1107);
        startActivity(bundle);
        finish();
    }
}
