package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ AgooFactory c;

    a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.c = agooFactory;
        this.a = bArr;
        this.b = str;
    }

    public void run() {
        StringBuilder stringBuilder;
        try {
            String str = new String(this.a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String str2 = null;
                CharSequence charSequence = str2;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        str2 = jSONObject.getString("i");
                        charSequence = jSONObject.getString("p");
                    }
                }
                if (ALog.isPrintLog(Level.I)) {
                    stringBuilder = new StringBuilder("saveMsg msgId:");
                    stringBuilder.append(str2);
                    stringBuilder.append(",message=");
                    stringBuilder.append(str);
                    stringBuilder.append(",currentPack=");
                    stringBuilder.append(charSequence);
                    stringBuilder.append(",reportTimes=");
                    stringBuilder.append(Config.e(AgooFactory.access$000()));
                    ALog.i("AgooFactory", stringBuilder.toString(), new Object[0]);
                }
                if (!TextUtils.isEmpty(charSequence) && TextUtils.equals(charSequence, AgooFactory.access$000().getPackageName())) {
                    if (TextUtils.isEmpty(this.b)) {
                        AgooFactory.access$100(this.c).a(str2, str, "0");
                        return;
                    }
                    AgooFactory.access$100(this.c).a(str2, str, this.b);
                }
            }
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("saveMsg fail:");
            stringBuilder.append(th.toString());
            ALog.e("AgooFactory", stringBuilder.toString(), new Object[0]);
        }
    }
}
