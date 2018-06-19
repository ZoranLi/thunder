package com.taobao.agoo.a.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.e$a;

/* compiled from: Taobao */
public class a extends b {
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_SETALIAS = "setAlias";
    public static final String JSON_PUSH_USER_TOKEN = "pushAliasToken";
    public String a;
    public String b;
    public String c;
    public String d;

    public byte[] a() {
        try {
            ALog.i("AliasDO", "buildData", "data", new e$a().a(b.JSON_CMD, this.e).a("appKey", this.a).a("deviceId", this.b).a("alias", this.c).a(JSON_PUSH_USER_TOKEN, this.d).a().toString());
            return new e$a().a(b.JSON_CMD, this.e).a("appKey", this.a).a("deviceId", this.b).a("alias", this.c).a(JSON_PUSH_USER_TOKEN, this.d).a().toString().getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.e = JSON_CMD_SETALIAS;
        return aVar.a();
    }

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.d = str3;
        aVar.e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }
}
