package com.xunlei.common.new_ptl.member.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.Tencent;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.l;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.c.i;
import com.xunlei.common.new_ptl.member.task.a;
import org.json.JSONObject;

public class XLQQLoginActivity extends Activity {
    private String QQ_SCOPE = "all";
    private String TAG = XLQQLoginActivity.class.getSimpleName();
    private String mQQAppId = "";
    private l mQQAuthListener = null;
    private int mTaskId = 0;
    private Tencent mTencentInstance = null;

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTaskId = getIntent().getIntExtra("qq_task_id", 0);
        this.mQQAppId = getIntent().getStringExtra("qq_app_id");
        if (this.mTaskId != null) {
            if (TextUtils.isEmpty(this.mQQAppId) == null) {
                this.mTencentInstance = Tencent.createInstance(this.mQQAppId, this);
                this.mQQAuthListener = new l(this);
                this.mTencentInstance.login((Activity) this, this.QQ_SCOPE, this.mQQAuthListener);
                bundle = this.TAG;
                StringBuilder stringBuilder = new StringBuilder("start qq login appid = ");
                stringBuilder.append(this.mQQAppId);
                XLLog.v(bundle, stringBuilder.toString());
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("-->onActivityResult ");
        stringBuilder.append(i);
        stringBuilder.append(" resultCode=");
        stringBuilder.append(i2);
        XLLog.v(str, stringBuilder.toString());
        if (i == 11101 || i == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(i, i2, intent, this.mQQAuthListener);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void notifyToTask(int i, i iVar) {
        a a = p.a().a(this.mTaskId);
        if (a != null) {
            a.a(i, iVar);
        }
        finish();
        XLLog.v(this.TAG, "finish XLQQLoginActivity");
    }

    public void acceptQQAuthResult(int i, JSONObject jSONObject) {
        i iVar = new i(jSONObject);
        notifyToTask(i, iVar);
        if (iVar.a() != 0) {
            this.mTencentInstance.setOpenId(iVar.a);
            this.mTencentInstance.setAccessToken(iVar.a, iVar.c);
        }
    }
}
