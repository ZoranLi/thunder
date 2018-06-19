package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.e$a;

/* compiled from: Taobao */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String a;
    public String b;
    public String c;

    public byte[] a() {
        try {
            e$a com_taobao_accs_utl_e_a = new e$a();
            com_taobao_accs_utl_e_a.a(b.JSON_CMD, this.e).a("appKey", this.a);
            if (TextUtils.isEmpty(this.b)) {
                com_taobao_accs_utl_e_a.a("utdid", this.c);
            } else {
                com_taobao_accs_utl_e_a.a("deviceId", this.b);
            }
            ALog.i("SwitchDO", "buildData", "data", com_taobao_accs_utl_e_a.a().toString());
            return com_taobao_accs_utl_e_a.a().toString().getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z) {
        d dVar = new d();
        dVar.a = str;
        dVar.b = str2;
        dVar.c = str3;
        if (z) {
            dVar.e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
