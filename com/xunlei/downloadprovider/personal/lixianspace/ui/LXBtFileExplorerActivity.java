package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.BaseBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.d.h.a;
import com.xunlei.xllib.android.XLIntent;

public final class LXBtFileExplorerActivity extends BaseBtFileExplorerActivity {
    private b j = new a(this);

    protected final void a() {
    }

    protected final boolean g() {
        return false;
    }

    protected final void a(long[] jArr) {
        Message obtainMessage = this.i.obtainMessage(65537);
        obtainMessage.obj = jArr;
        this.i.sendMessage(obtainMessage);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a.a(this.j);
        findViewById(R.id.storage_info_layout).setVisibility(8);
        this.a.setText("确认添加");
    }

    protected final void a(Message message) {
        if (message.what == 65537) {
            long[] jArr = (long[]) message.obj;
            a aVar = new a(l.a(this.d));
            aVar.b = c();
            aVar.a = this.e;
            aVar.c = jArr;
            l.a("lx_tag:default", aVar);
        }
    }

    protected final void onResume() {
        super.onResume();
        m.a().b = true;
    }

    public static void a(Context context, String str, int i) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(context, LXBtFileExplorerActivity.class);
        xLIntent.setData(Uri.parse(str));
        str = a("", -1, i, null, null, null);
        str.putString("quit_way", "finish_only");
        xLIntent.putExtras(str);
        if ((context instanceof Activity) == null) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }

    protected final void onDestroy() {
        a.a.b(this.j);
        b();
        VolleyRequestManager.getRequestQueue().a("lx_tag:default");
        super.onDestroy();
    }
}
