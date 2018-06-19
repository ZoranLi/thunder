package com.qihoo360.replugin.component.dummy;

import android.app.Activity;
import android.os.Bundle;
import com.qihoo360.loader2.n;

public class ForwardActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(null);
        n.a(this, getIntent());
    }
}
