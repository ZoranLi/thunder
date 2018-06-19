package com.qq.e.comm.managers.status;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DeviceStatus {
    private String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private volatile String k;
    private volatile String l;
    private volatile float m;
    public final String model = Build.MODEL;
    private Context n;

    private int a(float f, int i) {
        return (this.n.getApplicationInfo().flags & 8192) != 0 ? (int) (((float) i) / f) : i;
    }

    public Carrier getCarrier() {
        String operator = getOperator();
        if (operator != null) {
            if (!(operator.equals("46000") || operator.equals("46002") || operator.equals("46007"))) {
                if (!operator.equals("46020")) {
                    if (!operator.equals("46001")) {
                        if (!operator.equals("46006")) {
                            if (operator.equals("46003") || operator.equals("46005")) {
                                return Carrier.TELECOM;
                            }
                        }
                    }
                    return Carrier.UNICOM;
                }
            }
            return Carrier.CMCC;
        }
        return Carrier.UNKNOWN;
    }

    public java.lang.String getDataNet() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.n;	 Catch:{ Exception -> 0x0010 }
        r2 = "connectivity";	 Catch:{ Exception -> 0x0010 }
        r1 = r1.getSystemService(r2);	 Catch:{ Exception -> 0x0010 }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ Exception -> 0x0010 }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r1 = r0;
    L_0x0011:
        if (r1 != 0) goto L_0x0014;
    L_0x0013:
        return r0;
    L_0x0014:
        r0 = r1.getType();
        switch(r0) {
            case 0: goto L_0x0021;
            case 1: goto L_0x001e;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = "unknow";
        goto L_0x0023;
    L_0x001e:
        r0 = "wi";
        goto L_0x0023;
    L_0x0021:
        r0 = "ed";
    L_0x0023:
        r3.i = r0;
        r0 = r3.i;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.getDataNet():java.lang.String");
    }

    public int getDeviceDensity() {
        return this.e;
    }

    public int getDeviceHeight() {
        return this.d;
    }

    public int getDeviceWidth() {
        return this.c;
    }

    public String getDid() {
        String plainDid = getPlainDid();
        return StringUtil.isEmpty(plainDid) ? "" : Md5Util.encode(plainDid.toLowerCase());
    }

    public Map<String, String> getLacAndCeilId() {
        String operator = getOperator();
        Map<String, String> hashMap = new HashMap();
        if (!(StringUtil.isEmpty(operator) || "null".equalsIgnoreCase(operator))) {
            int i = 0;
            try {
                int parseInt = Integer.parseInt(operator.substring(0, 3));
                int parseInt2 = Integer.parseInt(operator.substring(3));
                if (parseInt == 460) {
                    TelephonyManager telephonyManager = (TelephonyManager) this.n.getSystemService("phone");
                    if (parseInt2 != 3) {
                        if (parseInt2 != 5) {
                            GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                            if (gsmCellLocation != null) {
                                i = gsmCellLocation.getLac();
                                parseInt2 = gsmCellLocation.getCid();
                            } else {
                                parseInt2 = 0;
                            }
                            hashMap.put("lac", String.valueOf(i));
                            hashMap.put("cellid", String.valueOf(parseInt2));
                            return hashMap;
                        }
                    }
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                    i = cdmaCellLocation.getNetworkId();
                    parseInt2 = cdmaCellLocation.getBaseStationId();
                    hashMap.put("lac", String.valueOf(i));
                    hashMap.put("cellid", String.valueOf(parseInt2));
                    return hashMap;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    public String getLanguage() {
        if (this.b == null) {
            this.b = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
            if (this.b.length() == 0) {
                this.b = SocializeProtocolConstants.PROTOCOL_KEY_EN;
            }
        }
        return this.b;
    }

    public String getLat() {
        return this.k;
    }

    public String getLng() {
        return this.l;
    }

    public float getLocationAccuracy() {
        return this.m;
    }

    public com.qq.e.comm.managers.status.NetworkType getNetworkType() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.getDataNet();
        r1 = r3.getPhoneNet();	 Catch:{ NumberFormatException -> 0x000d }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r1 = 0;
    L_0x000e:
        if (r0 == 0) goto L_0x001b;
    L_0x0010:
        r2 = "wi";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0 = com.qq.e.comm.managers.status.NetworkType.WIFI;
        return r0;
    L_0x001b:
        switch(r1) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0027;
            case 3: goto L_0x0024;
            case 4: goto L_0x0024;
            case 5: goto L_0x0024;
            case 6: goto L_0x0024;
            case 7: goto L_0x0024;
            case 8: goto L_0x0024;
            case 9: goto L_0x0024;
            case 10: goto L_0x0024;
            case 11: goto L_0x0024;
            case 12: goto L_0x0024;
            case 13: goto L_0x0021;
            case 14: goto L_0x0024;
            case 15: goto L_0x0021;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = com.qq.e.comm.managers.status.NetworkType.UNKNOWN;
        return r0;
    L_0x0021:
        r0 = com.qq.e.comm.managers.status.NetworkType.NET_4G;
        return r0;
    L_0x0024:
        r0 = com.qq.e.comm.managers.status.NetworkType.NET_3G;
        return r0;
    L_0x0027:
        r0 = com.qq.e.comm.managers.status.NetworkType.NET_2G;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.getNetworkType():com.qq.e.comm.managers.status.NetworkType");
    }

    public java.lang.String getOperator() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.n;	 Catch:{ Exception -> 0x0010 }
        r1 = "phone";	 Catch:{ Exception -> 0x0010 }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0010 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0010 }
        r0 = r0.getNetworkOperator();	 Catch:{ Exception -> 0x0010 }
        r2.g = r0;	 Catch:{ Exception -> 0x0010 }
    L_0x0010:
        r0 = r2.g;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.getOperator():java.lang.String");
    }

    public java.lang.String getPhoneNet() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.n;	 Catch:{ Exception -> 0x001c }
        r1 = "phone";	 Catch:{ Exception -> 0x001c }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x001c }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x001c }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001c }
        r1.<init>();	 Catch:{ Exception -> 0x001c }
        r0 = r0.getNetworkType();	 Catch:{ Exception -> 0x001c }
        r1.append(r0);	 Catch:{ Exception -> 0x001c }
        r0 = r1.toString();	 Catch:{ Exception -> 0x001c }
        r2.h = r0;	 Catch:{ Exception -> 0x001c }
    L_0x001c:
        r0 = r2.h;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.getPhoneNet():java.lang.String");
    }

    public String getPlainDid() {
        if (!StringUtil.isEmpty(this.j)) {
            return this.j;
        }
        try {
            this.j = ((TelephonyManager) this.n.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("Get imei encounter error: ");
            stringBuilder.append(e.getMessage());
            GDTLogger.d(stringBuilder.toString());
        }
        return StringUtil.isEmpty(this.j) ? "" : this.j;
    }

    public String getScreenOrientation() {
        String str;
        if (this.n.getResources().getConfiguration().orientation == 2) {
            str = "l";
        } else {
            if (this.n.getResources().getConfiguration().orientation == 1) {
                str = "p";
            }
            return this.f;
        }
        this.f = str;
        return this.f;
    }

    public String getUid() {
        if (this.a == null) {
            String string = Secure.getString(this.n.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            if (string == null) {
                string = "emulator";
            }
            this.a = Md5Util.encode(string);
        }
        return this.a;
    }

    public int getVersion() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0003 }
        return r0;
    L_0x0003:
        r0 = 3;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.getVersion():int");
    }

    public DeviceStatus(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r6.<init>();
        r0 = android.os.Build.MODEL;
        r6.model = r0;
        r0 = r7.getApplicationContext();
        r6.n = r0;
        r7 = r7.getResources();
        r7 = r7.getDisplayMetrics();
        r0 = r6.getVersion();
        r1 = 3;
        if (r0 <= r1) goto L_0x001f;
    L_0x001c:
        r0 = r7.densityDpi;
        goto L_0x0021;
    L_0x001f:
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
    L_0x0021:
        r6.e = r0;
        r0 = r6.getVersion();
        if (r0 <= r1) goto L_0x0032;
    L_0x0029:
        r0 = r7.density;
        r2 = r7.widthPixels;
        r0 = r6.a(r0, r2);
        goto L_0x0034;
    L_0x0032:
        r0 = r7.widthPixels;
    L_0x0034:
        r6.c = r0;
        r0 = r6.getVersion();
        if (r0 <= r1) goto L_0x0045;
    L_0x003c:
        r0 = r7.density;
        r7 = r7.heightPixels;
        r7 = r6.a(r0, r7);
        goto L_0x0047;
    L_0x0045:
        r7 = r7.heightPixels;
    L_0x0047:
        r6.d = r7;
        r7 = r6.n;	 Catch:{ Throwable -> 0x00b0 }
        r0 = "location";	 Catch:{ Throwable -> 0x00b0 }
        r7 = r7.getSystemService(r0);	 Catch:{ Throwable -> 0x00b0 }
        r0 = r7;	 Catch:{ Throwable -> 0x00b0 }
        r0 = (android.location.LocationManager) r0;	 Catch:{ Throwable -> 0x00b0 }
        if (r0 != 0) goto L_0x0057;	 Catch:{ Throwable -> 0x00b0 }
    L_0x0056:
        return;	 Catch:{ Throwable -> 0x00b0 }
    L_0x0057:
        r7 = new android.location.Criteria;	 Catch:{ Throwable -> 0x00b0 }
        r7.<init>();	 Catch:{ Throwable -> 0x00b0 }
        r1 = 2;	 Catch:{ Throwable -> 0x00b0 }
        r7.setAccuracy(r1);	 Catch:{ Throwable -> 0x00b0 }
        r1 = 0;	 Catch:{ Throwable -> 0x00b0 }
        r7.setAltitudeRequired(r1);	 Catch:{ Throwable -> 0x00b0 }
        r7.setBearingRequired(r1);	 Catch:{ Throwable -> 0x00b0 }
        r1 = 1;	 Catch:{ Throwable -> 0x00b0 }
        r7.setCostAllowed(r1);	 Catch:{ Throwable -> 0x00b0 }
        r7.setPowerRequirement(r1);	 Catch:{ Throwable -> 0x00b0 }
        r1 = r0.getBestProvider(r7, r1);	 Catch:{  }
        r7 = r0.getLastKnownLocation(r1);	 Catch:{  }
        if (r7 == 0) goto L_0x00a3;	 Catch:{  }
    L_0x0078:
        r0 = new java.lang.StringBuilder;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r1 = r7.getLatitude();	 Catch:{  }
        r0.append(r1);	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r6.k = r0;	 Catch:{  }
        r0 = new java.lang.StringBuilder;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r1 = r7.getLongitude();	 Catch:{  }
        r0.append(r1);	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r6.l = r0;	 Catch:{  }
        r7 = r7.getAccuracy();	 Catch:{  }
        r6.m = r7;	 Catch:{  }
        return;	 Catch:{  }
    L_0x00a3:
        r5 = new com.qq.e.comm.managers.status.DeviceStatus$1;	 Catch:{  }
        r5.<init>(r6, r0);	 Catch:{  }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r4 = 1171963904; // 0x45dac000 float:7000.0 double:5.79027103E-315;
        r0.requestLocationUpdates(r1, r2, r4, r5);	 Catch:{  }
    L_0x00b0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus.<init>(android.content.Context):void");
    }
}
