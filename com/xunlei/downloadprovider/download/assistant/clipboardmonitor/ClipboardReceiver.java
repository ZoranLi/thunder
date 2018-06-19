package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ClipboardReceiver extends BroadcastReceiver {
    private static final String a = "ClipboardReceiver";

    public void onReceive(Context context, Intent intent) {
        f.b().a(intent.getStringExtra("url"), intent.getBooleanExtra("isAutoComplemented", false), intent.getIntExtra("type", 3), "umeng");
    }
}
