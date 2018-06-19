package com.xunlei.downloadprovider.download.create;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.contentpublish.website.az;
import com.xunlei.downloadprovider.dialog.f;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.web.website.g.b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ThunderTaskActivity extends BaseActivity {
    private f a;
    private d c = new d(new ag(this));
    private d d = new d(new ah(this));
    protected ad e;
    public Bundle f;

    public static Bundle a(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            bundle.putBundle("sdk_arguments", bundle2);
        }
        return bundle;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void a(String str, String str2, String str3, TaskStatInfo taskStatInfo, c cVar) {
        DownData downData = new DownData();
        downData.b = str;
        downData.a = str2;
        downData.c = null;
        downData.a(str3);
        com.xunlei.downloadprovider.download.c.a((Context) this, downData, taskStatInfo, cVar);
    }

    protected final void a(Intent intent) {
        ad adVar;
        String a;
        String b;
        String c;
        TaskStatInfo taskStatInfo;
        Bundle bundleExtra = intent.getBundleExtra("sdk_arguments");
        if (bundleExtra != null) {
            this.f = bundleExtra;
            ArrayList parcelableArrayList = bundleExtra.getParcelableArrayList("tasks");
            if (!(parcelableArrayList == null || parcelableArrayList.isEmpty())) {
                DownData downData = (DownData) parcelableArrayList.get(0);
                TaskStatInfo taskStatInfo2 = new TaskStatInfo(downData.b, null);
                taskStatInfo2.a = "BHO/BHO_SDK";
                taskStatInfo2.i = this.f.getString(Constants.APP_ID);
                taskStatInfo2.j = this.f.getString("partner_id");
                com.xunlei.downloadprovider.download.c.a((Context) this, downData, taskStatInfo2, this.d);
            }
        }
        intent = intent.getBundleExtra("create_arguments");
        if (intent != null) {
            adVar = new ad(intent);
            if (TextUtils.isEmpty(adVar.a()) == null) {
                this.e = adVar;
                if (this.e != null) {
                    a = this.e.a();
                    if (TextUtils.isEmpty(a) == null) {
                        b = this.e.b();
                        c = this.e.c();
                        taskStatInfo = new TaskStatInfo(a, b);
                        intent = this.e.c("");
                        taskStatInfo.a = intent;
                        taskStatInfo.d = this.e.d();
                        taskStatInfo.e = this.e.e();
                        taskStatInfo.f = this.e.f();
                        taskStatInfo.g = this.e.a.getBoolean("fromMagnetComplete");
                        if (!TextUtils.isEmpty(b) || (!"BHO/thunder".equals(intent) && "BHO/other".equals(intent) == null)) {
                            a(a, c, b, taskStatInfo, null);
                        } else {
                            a(a, c, b, taskStatInfo, this.c);
                            return;
                        }
                    }
                }
            }
        }
        adVar = null;
        this.e = adVar;
        if (this.e != null) {
            a = this.e.a();
            if (TextUtils.isEmpty(a) == null) {
                b = this.e.b();
                c = this.e.c();
                taskStatInfo = new TaskStatInfo(a, b);
                intent = this.e.c("");
                taskStatInfo.a = intent;
                taskStatInfo.d = this.e.d();
                taskStatInfo.e = this.e.e();
                taskStatInfo.f = this.e.f();
                taskStatInfo.g = this.e.a.getBoolean("fromMagnetComplete");
                if (TextUtils.isEmpty(b)) {
                }
                a(a, c, b, taskStatInfo, null);
            }
        }
    }

    public static Bundle a(Bundle bundle, ad adVar) {
        if (adVar != null) {
            bundle.putBundle("create_arguments", adVar.a);
        }
        return bundle;
    }

    static /* synthetic */ void a(ThunderTaskActivity thunderTaskActivity, String str) {
        if (!TextUtils.isEmpty(str) && !b.a().a(str) && m.a().d(str)) {
            az.a().a(str, new ai(thunderTaskActivity, str));
        }
    }

    static /* synthetic */ void a(ThunderTaskActivity thunderTaskActivity) {
        JSONException jSONException;
        if (thunderTaskActivity.a != null && thunderTaskActivity.a.isShowing()) {
            thunderTaskActivity.a.dismiss();
        }
        Object obj = "";
        Object obj2 = "";
        if (thunderTaskActivity.f != null) {
            String string = thunderTaskActivity.f.getString("sdk_key");
            if (string != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(string).optJSONObject("hostApp");
                    String optString = optJSONObject.optString("appLabel");
                    try {
                        obj2 = optJSONObject.optString(com.taobao.accs.common.Constants.KEY_PACKAGE_NAME);
                        obj = optString;
                    } catch (JSONException e) {
                        jSONException = e;
                        obj = optString;
                        jSONException.printStackTrace();
                        if (!TextUtils.isEmpty(obj2)) {
                            return;
                        }
                    }
                } catch (JSONException e2) {
                    jSONException = e2;
                    jSONException.printStackTrace();
                    if (!TextUtils.isEmpty(obj2)) {
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(obj2) && !TextUtils.isEmpty(obj)) {
                OnClickListener ajVar = new aj(thunderTaskActivity, obj2);
                thunderTaskActivity.a = new f(thunderTaskActivity);
                thunderTaskActivity.a.b("创建任务成功");
                f fVar = thunderTaskActivity.a;
                StringBuilder stringBuilder = new StringBuilder("返回");
                stringBuilder.append(obj);
                fVar.c(stringBuilder.toString());
                thunderTaskActivity.a.d("留在迅雷");
                thunderTaskActivity.a.a(ajVar);
                thunderTaskActivity.a.show();
            }
        }
    }
}
