package com.ali.auth.third.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ali.auth.third.core.c.a;
import com.taobao.applink.util.TBAppLinkUtil;

final class d extends AsyncTask<Void, Void, String> {
    final /* synthetic */ String a;
    final /* synthetic */ Activity b;
    final /* synthetic */ a c;

    d(a aVar, String str, Activity activity) {
        this.c = aVar;
        this.a = str;
        this.b = activity;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            a.b(this.b);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(TBAppLinkUtil.ACTION_CUSTOM);
        StringBuilder stringBuilder = new StringBuilder("tbopen://m.taobao.com/getway/oauth?&appkey=");
        stringBuilder.append(a.a());
        stringBuilder.append("&pluginName=taobao.oauth.code.create&apkSign=");
        stringBuilder.append(this.a);
        stringBuilder.append("&sign=");
        stringBuilder.append(str);
        intent.setData(Uri.parse(stringBuilder.toString()));
        if (this.b.getPackageManager().queryIntentActivities(intent, 0).size() > null) {
            this.b.startActivityForResult(intent, c.a);
        } else {
            a.b(this.b);
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return TextUtils.isEmpty(this.a) != null ? "" : a.a(this.a);
    }
}
