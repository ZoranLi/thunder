package com.xunlei.common.new_ptl.member.act;

import android.app.Activity;
import android.os.Bundle;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.c.b;
import com.xunlei.common.new_ptl.member.c.d;
import com.xunlei.common.new_ptl.member.task.h.a;

public class XLAlipayLoginActivity extends Activity implements d {
    private b mAlipayAuth = null;
    private XLAlipayParam mAlipayParam = null;
    private int mAlipayTaskId = 0;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlipayTaskId = getIntent().getIntExtra("ali_task", 0);
        this.mAlipayParam = (XLAlipayParam) getIntent().getParcelableExtra("ali_auth_param");
        if (this.mAlipayTaskId == null) {
            sendResultToHostTask(XLErrorCode.ALI_AUTH_PARAM_ERROR, null, null, null);
            return;
        }
        this.mAlipayAuth = new b(this, this.mAlipayParam, this);
        this.mAlipayAuth.a();
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onAlipayAuth(int i, String str, String str2, String str3) {
        sendResultToHostTask(i, str, str2, str3);
    }

    public void sendResultToHostTask(int i, String str, String str2, String str3) {
        a aVar = (a) p.a().a(this.mAlipayTaskId);
        if (aVar != null) {
            aVar.b(i, str2, str3);
        }
    }
}
