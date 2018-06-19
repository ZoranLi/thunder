package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants.KEYS;
import com.qq.e.comm.constants.Constants.SETTING;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import org.json.JSONObject;

public class SM {
    private a a;
    private String b;
    private a c;
    private a d;
    private String e;
    private c f;
    private c g;
    private String h;
    private String i = "";
    private Context j;

    public SM(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = "";
        r3.i = r0;
        r3.j = r4;
        r4 = new com.qq.e.comm.managers.setting.a;
        r4.<init>();
        r3.a = r4;
        r4 = new com.qq.e.comm.managers.setting.a;
        r4.<init>();
        r3.d = r4;
        r4 = new com.qq.e.comm.managers.setting.b;
        r4.<init>();
        r3.g = r4;
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x0035 }
        r0 = r3.j;	 Catch:{ Throwable -> 0x0035 }
        r1 = "e_qq_com_setting";	 Catch:{ Throwable -> 0x0035 }
        r2 = 0;	 Catch:{ Throwable -> 0x0035 }
        r0 = r0.getDir(r1, r2);	 Catch:{ Throwable -> 0x0035 }
        r1 = "gdt_suid";	 Catch:{ Throwable -> 0x0035 }
        r4.<init>(r0, r1);	 Catch:{ Throwable -> 0x0035 }
        r4 = com.qq.e.comm.util.StringUtil.readAll(r4);	 Catch:{ Throwable -> 0x0035 }
        r3.h = r4;	 Catch:{ Throwable -> 0x0035 }
        goto L_0x003d;
    L_0x0035:
        r4 = 0;
        r3.h = r4;
        r4 = "IO Exception while loading suid";
        com.qq.e.comm.util.GDTLogger.e(r4);
    L_0x003d:
        r3.a();
        r3.b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.SM.<init>(android.content.Context):void");
    }

    private void a() {
        d b = a.b(this.j);
        if (b != null) {
            this.e = b.a();
            this.f = b.b();
            return;
        }
        GDTLogger.d("Load Local SDK Cloud setting fail");
    }

    private void b() {
        a a = a.a(this.j);
        if (a != null) {
            this.c = a.b();
            this.b = a.a();
            return;
        }
        GDTLogger.d("Load Local DEV Cloud setting fail");
    }

    public Object get(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            Object a;
            if (this.a.a(str) != null) {
                a = this.a.a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.c != null) {
                a = this.c.a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.d != null) {
                a = this.d.a(str);
                if (a != null) {
                    return a;
                }
            }
            if (this.f != null) {
                a = this.f.a(str);
                if (a != null) {
                    return a;
                }
            }
            return this.g != null ? this.g.a(str) : null;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Exception in settingManager.get Setting for key:");
            stringBuilder.append(str);
            GDTLogger.report(stringBuilder.toString(), th);
            return null;
        }
    }

    public String getDevCloudSettingSig() {
        return this.b;
    }

    public Object getForPlacement(String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return null;
        }
        try {
            Object a;
            if (this.a != null) {
                a = this.a.a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.c != null) {
                a = this.c.a(str, str2);
                if (a != null) {
                    return a;
                }
            }
            if (this.d != null) {
                Object a2 = this.d.a(str, str2);
                if (a2 != null) {
                    return a2;
                }
            }
            return get(str);
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.getForPlacement", th);
            return null;
        }
    }

    public int getInteger(String str, int i) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i : ((Integer) forPlacement).intValue();
    }

    public String getSdkCloudSettingSig() {
        return this.e;
    }

    public String getSid() {
        return this.i;
    }

    public String getString(String str) {
        Object obj = get(str);
        return obj == null ? null : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        return forPlacement == null ? null : forPlacement.toString();
    }

    public String getSuid() {
        return this.h;
    }

    public void updateContextSetting(String str) {
        try {
            a aVar = new a();
            if (!StringUtil.isEmpty(str)) {
                aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.a = aVar;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (a.b(this.j, str, str2)) {
            b();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (a.a(this.j, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        this.i = str;
    }

    public void updateSUID(String str) {
        if (!(StringUtil.isEmpty(str) || str.equals(this.h))) {
            this.h = str;
            try {
                StringUtil.writeTo(str, new File(this.j.getDir(SETTING.SETTINGDIR, 0), SETTING.SUID_FILE));
            } catch (Throwable e) {
                GDTLogger.report("Exception while persit suid", e);
            }
        }
    }

    public void setDEVCodeSetting(String str, Object obj) {
        try {
            this.d.a.putOpt(str, obj);
        } catch (String str2) {
            GDTLogger.e("Exception while update setting", str2);
        }
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        a aVar = this.d;
        try {
            JSONObject optJSONObject = aVar.a.optJSONObject(KEYS.PLACEMENTS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                aVar.a.putOpt(KEYS.PLACEMENTS, optJSONObject);
            }
            JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
                optJSONObject.putOpt(str2, optJSONObject2);
            }
            if (obj == null) {
                optJSONObject2.remove(str);
            } else {
                optJSONObject2.putOpt(str, obj);
            }
        } catch (String str3) {
            GDTLogger.e("Exception while update setting", str3);
        }
    }
}
