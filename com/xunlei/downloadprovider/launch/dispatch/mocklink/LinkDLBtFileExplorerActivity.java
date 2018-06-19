package com.xunlei.downloadprovider.launch.dispatch.mocklink;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.launch.LaunchActivity;

public class LinkDLBtFileExplorerActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle == null) {
            bundle = new Intent(this, LaunchActivity.class);
        } else {
            bundle.setClass(this, LaunchActivity.class);
        }
        bundle.putExtra("dispatch_from_key", SecExceptionCode.SEC_ERROE_OPENSDK_DECODE_FAILED);
        startActivity(bundle);
        finish();
    }
}
