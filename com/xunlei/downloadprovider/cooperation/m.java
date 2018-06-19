package com.xunlei.downloadprovider.cooperation;

import android.annotation.SuppressLint;
import com.taobao.accs.common.Constants;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* compiled from: CooperationParser */
abstract class m {
    HashMap<Integer, k> b = new HashMap(3);
    HashMap<Integer, CooperationScene> c = new HashMap();
    ArrayList<CooperationItem> d = new ArrayList();
    HashSet<String> e = new HashSet();

    /* compiled from: CooperationParser */
    private class a {
        final /* synthetic */ m a;

        private a(m mVar) {
            this.a = mVar;
        }
    }

    /* compiled from: CooperationParser */
    private class b {
        final /* synthetic */ m a;

        private b(m mVar) {
            this.a = mVar;
        }

        final void a(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("scene");
            if (optJSONObject != null) {
                b bVar;
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    Iterator it;
                    String str = (String) keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                    if (optJSONObject2 != null) {
                        int parseInt = Integer.parseInt(str);
                        if (l.a(parseInt)) {
                            String optString = optJSONObject2.optString("attachment");
                            String optString2 = optJSONObject2.optString("description");
                            String optString3 = optJSONObject2.optString("title");
                            String optString4 = optJSONObject2.optString("content");
                            String optString5 = optJSONObject2.optString("right_btn_description");
                            String optString6 = optJSONObject2.optString("left_btn_description");
                            String optString7 = optJSONObject2.optString("third_btn_description");
                            JSONObject jSONObject2 = optJSONObject;
                            CooperationScene cooperationScene = r4;
                            String str2 = optString6;
                            it = keys;
                            String str3 = optString5;
                            String str4 = optString4;
                            CooperationScene cooperationScene2 = new CooperationScene(parseInt, optString, optString3, optString7, optString5, optString6, optString2, optString4);
                            StringBuilder stringBuilder = new StringBuilder("scene:loc=");
                            stringBuilder.append(parseInt);
                            stringBuilder.append(" attachment=");
                            stringBuilder.append(optString);
                            stringBuilder.append(" description=");
                            stringBuilder.append(optString2);
                            stringBuilder.append(" title=");
                            stringBuilder.append(optString3);
                            stringBuilder.append(" content=");
                            stringBuilder.append(str4);
                            stringBuilder.append(" right=");
                            stringBuilder.append(str3);
                            stringBuilder.append("  left=");
                            stringBuilder.append(str2);
                            stringBuilder.append("third=");
                            stringBuilder.append(optString7);
                            this.a.c.put(Integer.valueOf(parseInt), cooperationScene);
                            optJSONObject = jSONObject2;
                            keys = it;
                        }
                    }
                    it = keys;
                    bVar = this;
                    keys = it;
                }
                bVar = this;
            }
        }
    }

    protected abstract void a();

    m() {
    }

    protected final void a(JSONObject jSONObject) {
        m mVar = this;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            byte b = (byte) 0;
            a aVar = new a();
            JSONObject optJSONObject = jSONObject2.optJSONObject(Constants.KEY_APPS);
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject((String) keys.next());
                    if (optJSONObject2 != null) {
                        int optInt = optJSONObject2.optInt("location", Integer.MIN_VALUE);
                        if (l.b(optInt)) {
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("items");
                            if (optJSONArray != null) {
                                if (optJSONArray.length() != 0) {
                                    int i = b;
                                    while (i < optJSONArray.length()) {
                                        JSONObject jSONObject3;
                                        Iterator it;
                                        JSONArray jSONArray;
                                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                                        if (optJSONObject3 == null || optJSONObject3 == null) {
                                            jSONObject3 = optJSONObject;
                                            it = keys;
                                            jSONArray = optJSONArray;
                                        } else {
                                            boolean z;
                                            String str;
                                            String str2;
                                            String str3;
                                            String str4;
                                            new StringBuilder("parse app:").append(optJSONObject3.toString());
                                            int optInt2 = optJSONObject3.optInt(com.xiaomi.mipush.sdk.Constants.APP_ID);
                                            String optString = optJSONObject3.optString("app_name");
                                            String optString2 = optJSONObject3.optString("app_package_name");
                                            String optString3 = optJSONObject3.optString("app_download_url");
                                            String optString4 = optJSONObject3.optString("app_self_icon_url");
                                            boolean optBoolean = optJSONObject3.optBoolean("app_is_preload", b);
                                            if (optBoolean) {
                                                z = optBoolean;
                                                str = optString4;
                                                str2 = optString3;
                                                str3 = optString2;
                                                jSONObject3 = optJSONObject;
                                                str4 = optString;
                                                CooperationItem cooperationItem = new CooperationItem(optInt2, optString, str, str2, str3, z);
                                                m mVar2 = aVar.a;
                                                if (cooperationItem.isPreLoad()) {
                                                    if (mVar2.e.contains(cooperationItem.getAppPackageName())) {
                                                        StringBuilder stringBuilder = new StringBuilder("已经在预加载列表中：");
                                                        stringBuilder.append(cooperationItem.getAppName());
                                                        stringBuilder.append(cooperationItem.getAppPackageName());
                                                    } else {
                                                        StringBuilder stringBuilder2 = new StringBuilder("预加载：");
                                                        stringBuilder2.append(cooperationItem.getAppName());
                                                        stringBuilder2.append("  ");
                                                        stringBuilder2.append(cooperationItem.getAppPackageName());
                                                        mVar2.d.add(cooperationItem);
                                                        mVar2.e.add(cooperationItem.getAppPackageName());
                                                    }
                                                }
                                            } else {
                                                jSONObject3 = optJSONObject;
                                                z = optBoolean;
                                                str = optString4;
                                                str2 = optString3;
                                                str3 = optString2;
                                                str4 = optString;
                                            }
                                            StringBuilder stringBuilder3 = new StringBuilder("appName:");
                                            stringBuilder3.append(str4);
                                            stringBuilder3.append("  appPkgName:");
                                            optString = str3;
                                            stringBuilder3.append(optString);
                                            stringBuilder3.append("  appDLUrl:");
                                            optString2 = str2;
                                            stringBuilder3.append(optString2);
                                            stringBuilder3.append("  selfIconUrl:");
                                            optString3 = str;
                                            stringBuilder3.append(optString3);
                                            stringBuilder3.append(" isPreload:");
                                            boolean z2 = z;
                                            stringBuilder3.append(z2);
                                            String optString5 = optJSONObject3.optString("app_icon_urls");
                                            String optString6 = optJSONObject3.optString("app_copywritings");
                                            it = keys;
                                            jSONArray = optJSONArray;
                                            boolean optBoolean2 = optJSONObject3.optBoolean("app_install_tips", false);
                                            String optString7 = optJSONObject3.optString("app_titles");
                                            boolean z3 = z2;
                                            optString4 = optJSONObject3.optString("app_descriptions");
                                            String str5 = optString2;
                                            optString2 = optJSONObject3.optString("app_btn_descriptions");
                                            String str6 = optString;
                                            StringBuilder stringBuilder4 = new StringBuilder("location:");
                                            stringBuilder4.append(optInt);
                                            stringBuilder4.append(" copywriting:");
                                            stringBuilder4.append(optString6);
                                            stringBuilder4.append("  tip:");
                                            stringBuilder4.append(optBoolean2);
                                            stringBuilder4.append("  title:");
                                            stringBuilder4.append(optString7);
                                            stringBuilder4.append("  des:");
                                            stringBuilder4.append(optString4);
                                            stringBuilder4.append("  btnDes:");
                                            stringBuilder4.append(optString2);
                                            stringBuilder4.append("icUrl:");
                                            stringBuilder4.append(optString5);
                                            String str7 = optString4;
                                            optString4 = str4;
                                            String str8 = optString2;
                                            optString2 = optString5;
                                            CooperationItem cooperationItem2 = r9;
                                            optString = str5;
                                            String str9 = str6;
                                            CooperationItem cooperationItem3 = new CooperationItem(optInt2, optInt, optString4, optString3, optString2, optString, str9, optString6, optBoolean2, z3, optString7, str7, str8);
                                            m mVar3 = aVar.a;
                                            k kVar = (k) mVar3.b.get(Integer.valueOf(optInt));
                                            if (kVar == null) {
                                                kVar = new k(optInt);
                                                mVar3.b.put(Integer.valueOf(optInt), kVar);
                                            }
                                            kVar.b.add(cooperationItem2);
                                        }
                                        i++;
                                        optJSONObject = jSONObject3;
                                        keys = it;
                                        optJSONArray = jSONArray;
                                        jSONObject2 = jSONObject;
                                        b = (byte) 0;
                                    }
                                }
                            }
                            optJSONObject = optJSONObject;
                            keys = keys;
                            jSONObject2 = jSONObject;
                            b = (byte) 0;
                        }
                    }
                }
            }
            new b().a(jSONObject);
            a();
        }
    }
}
