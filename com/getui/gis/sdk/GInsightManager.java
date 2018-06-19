package com.getui.gis.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.getui.gis.sdk.a.b;
import com.getui.gtc.GtcEventBus;
import com.getui.gtc.GtcService;
import com.getui.gtc.entity.Ie;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GInsightManager {
    public static final String ACTION_GIUID_GENERATED = "com.getui.gis.action.GIUID_GENERATED";
    private static String API_NAME = "com.getui.gis.sdk.GInsightManager$SdkInfo";
    private static String APPID;

    private static class SdkInfo {
        private static int a = 2;
        private static String b;

        private SdkInfo() {
        }

        private Ie getIe(int i) {
            String valueOf = String.valueOf(i);
            List<Map> a = a(Base64.decode("", 0));
            Ie ie = null;
            if (!a.isEmpty()) {
                for (Map map : a) {
                    if (((String) map.get("i")).equals(valueOf)) {
                        ie = new Ie();
                        ie.setAid(b);
                        ie.setCs((String) map.get(IXAdRequestInfo.CS));
                        ie.setCn((String) map.get("cn"));
                        ie.setK((String) map.get("k"));
                    }
                }
            }
            return ie;
        }

        private String getSdkAppId() {
            return b;
        }

        private int getSdkId() {
            return a;
        }

        private String getSdkVersion() {
            return "GI-3.0.0";
        }

        public List<Map<String, String>> a(byte[] bArr) {
            ByteArrayInputStream byteArrayInputStream;
            ObjectInputStream objectInputStream;
            Throwable th;
            Throwable th2;
            ObjectInputStream objectInputStream2 = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        ArrayList arrayList = (ArrayList) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                            byteArrayInputStream.close();
                            return arrayList;
                        } catch (Throwable th3) {
                            com.getui.gis.sdk.b.a.a(th3);
                            return arrayList;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            com.getui.gis.sdk.b.a.a(th2);
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable th32) {
                                    com.getui.gis.sdk.b.a.a(th32);
                                    return null;
                                }
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                                return null;
                            }
                            return null;
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            objectInputStream2 = objectInputStream;
                            th32 = th6;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Throwable th52) {
                                    com.getui.gis.sdk.b.a.a(th52);
                                    throw th32;
                                }
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            throw th32;
                        }
                    }
                } catch (Throwable th7) {
                    th32 = th7;
                    if (objectInputStream2 != null) {
                        objectInputStream2.close();
                    }
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th32;
                }
            } catch (Throwable th8) {
                th32 = th8;
                byteArrayInputStream = null;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th32;
            }
        }
    }

    private static class a {
        private static final GInsightManager a = new GInsightManager();
    }

    private GInsightManager() {
    }

    public static GInsightManager getInstance() {
        return a.a;
    }

    public void init(Context context, String str) {
        try {
            GtcEventBus.register(GInsightManager.class);
        } catch (Throwable th) {
            com.getui.gis.sdk.b.a.a(th);
        }
        if (context != null) {
            try {
                SdkInfo.b = str;
                b.a = context;
                com.getui.gis.sdk.a.a.a(context).a();
                StringBuilder stringBuilder = new StringBuilder("GInsight manager init...\nversion:GI-3.0.0, is debug:false\nappid:");
                stringBuilder.append(str);
                com.getui.gis.sdk.b.a.a(stringBuilder.toString());
                if (!TextUtils.isEmpty(str)) {
                    APPID = str;
                    Intent intent = new Intent(context, GtcService.class);
                    intent.putExtra("10010", Base64.encode(API_NAME.getBytes(), 0));
                    context.startService(intent);
                }
            } catch (Throwable th2) {
                com.getui.gis.sdk.b.a.a(th2);
            }
        }
    }

    public String version() {
        com.getui.gis.sdk.b.a.a((Object) "GInsight manager version...");
        return "GI-3.0.0";
    }
}
