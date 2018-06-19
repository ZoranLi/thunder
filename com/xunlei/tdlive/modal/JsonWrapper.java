package com.xunlei.tdlive.modal;

import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonWrapper implements Serializable {
    private static final long serialVersionUID = -3918552506396099585L;
    private JSONArray mJsonArr;
    private JSONObject mJsonObj;

    public String toString() {
        if (this.mJsonObj != null) {
            return this.mJsonObj.toString();
        }
        return this.mJsonArr != null ? this.mJsonArr.toString() : "";
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.mJsonObj != null) {
            objectOutputStream.write(this.mJsonObj.toString().getBytes());
            return;
        }
        if (this.mJsonArr != null) {
            objectOutputStream.write(this.mJsonArr.toString().getBytes());
        }
    }

    private void readObject(java.io.ObjectInputStream r6) throws java.io.IOException, java.lang.ClassNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r2 = "UTF-8";
        r1.<init>(r6, r2);
        r0.<init>(r1);
        r6 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r6 = new char[r6];
        r1 = "";
    L_0x0012:
        r2 = r0.read(r6);
        r3 = -1;
        if (r2 == r3) goto L_0x0024;
    L_0x0019:
        r3 = new java.lang.String;
        r4 = 0;
        r3.<init>(r6, r4, r2);
        r1 = r1.concat(r3);
        goto L_0x0012;
    L_0x0024:
        r0.close();
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x002f }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x002f }
        r5.mJsonObj = r6;	 Catch:{ Throwable -> 0x002f }
        return;
    L_0x002f:
        r6 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0037 }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x0037 }
        r5.mJsonArr = r6;	 Catch:{ Throwable -> 0x0037 }
        return;
    L_0x0037:
        r6 = move-exception;
        r0 = new java.io.IOException;
        r6 = r6.toString();
        r0.<init>(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.readObject(java.io.ObjectInputStream):void");
    }

    public JsonWrapper(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>();
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x000b }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x000b }
        r1.mJsonObj = r0;	 Catch:{ Throwable -> 0x000b }
        return;
    L_0x000b:
        r0 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x0013 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0013 }
        r1.mJsonArr = r0;	 Catch:{ Throwable -> 0x0013 }
        return;
    L_0x0013:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.<init>(java.lang.String):void");
    }

    public JsonWrapper(JSONObject jSONObject) {
        this.mJsonObj = jSONObject;
    }

    public JsonWrapper(JSONArray jSONArray) {
        this.mJsonArr = jSONArray;
    }

    public JsonWrapper(Object obj) {
        this(new Gson().toJson(obj));
    }

    public static JsonWrapper fromIntent(Intent intent, String str) {
        if (intent != null) {
            return fromBundle(intent.getExtras(), str);
        }
        return new JsonWrapper(str);
    }

    public static com.xunlei.tdlive.modal.JsonWrapper fromBundle(android.os.Bundle r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xunlei.tdlive.modal.JsonWrapper;
        r0.<init>(r4);
        if (r3 == 0) goto L_0x0023;
    L_0x0007:
        r4 = r3.keySet();	 Catch:{ Throwable -> 0x0023 }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0023 }
    L_0x000f:
        r1 = r4.hasNext();	 Catch:{ Throwable -> 0x0023 }
        if (r1 == 0) goto L_0x0023;	 Catch:{ Throwable -> 0x0023 }
    L_0x0015:
        r1 = r4.next();	 Catch:{ Throwable -> 0x0023 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0023 }
        r2 = r3.get(r1);	 Catch:{ Throwable -> 0x0023 }
        r0.putObject(r1, r2);	 Catch:{ Throwable -> 0x0023 }
        goto L_0x000f;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.fromBundle(android.os.Bundle, java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public static com.xunlei.tdlive.modal.JsonWrapper loadFromStream(java.io.InputStream r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = new byte[r0];
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r2 = "";
    L_0x000b:
        r3 = r5.read(r0);	 Catch:{ Throwable -> 0x0024 }
        r4 = -1;	 Catch:{ Throwable -> 0x0024 }
        if (r3 == r4) goto L_0x0017;	 Catch:{ Throwable -> 0x0024 }
    L_0x0012:
        r4 = 0;	 Catch:{ Throwable -> 0x0024 }
        r1.write(r0, r4, r3);	 Catch:{ Throwable -> 0x0024 }
        goto L_0x000b;	 Catch:{ Throwable -> 0x0024 }
    L_0x0017:
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x0024 }
        r0 = r1.toByteArray();	 Catch:{ Throwable -> 0x0024 }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0024 }
        r1.close();	 Catch:{ Throwable -> 0x0025 }
        goto L_0x0025;
    L_0x0024:
        r5 = r2;
    L_0x0025:
        r0 = r5.length();
        if (r0 > 0) goto L_0x002c;
    L_0x002b:
        r5 = r6;
    L_0x002c:
        r6 = new com.xunlei.tdlive.modal.JsonWrapper;
        r6.<init>(r5);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.loadFromStream(java.io.InputStream, java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public boolean writeToStream(java.io.OutputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x0025 }
    L_0x0004:
        r0 = r1.mJsonArr;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0025 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0025 }
        r2.write(r0);	 Catch:{ Exception -> 0x0025 }
        goto L_0x0023;	 Catch:{ Exception -> 0x0025 }
    L_0x0012:
        r0 = r1.mJsonObj;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x0025 }
    L_0x0016:
        r0 = r1.mJsonObj;	 Catch:{ Exception -> 0x0025 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0025 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0025 }
        r2.write(r0);	 Catch:{ Exception -> 0x0025 }
    L_0x0023:
        r2 = 1;
        return r2;
    L_0x0025:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.writeToStream(java.io.OutputStream):boolean");
    }

    public static com.xunlei.tdlive.modal.JsonWrapper loadFromFile(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = new char[r0];
        r1 = "";
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0035 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0035 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x0035 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0035 }
        r6 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0035 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0035 }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x0035 }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x0035 }
        r6.<init>(r3);	 Catch:{ Exception -> 0x0035 }
    L_0x001c:
        r3 = r6.read(r0);	 Catch:{ Exception -> 0x0035 }
        r4 = -1;	 Catch:{ Exception -> 0x0035 }
        if (r3 == r4) goto L_0x002f;	 Catch:{ Exception -> 0x0035 }
    L_0x0023:
        r4 = new java.lang.String;	 Catch:{ Exception -> 0x0035 }
        r5 = 0;	 Catch:{ Exception -> 0x0035 }
        r4.<init>(r0, r5, r3);	 Catch:{ Exception -> 0x0035 }
        r3 = r1.concat(r4);	 Catch:{ Exception -> 0x0035 }
        r1 = r3;	 Catch:{ Exception -> 0x0035 }
        goto L_0x001c;	 Catch:{ Exception -> 0x0035 }
    L_0x002f:
        r6.close();	 Catch:{ Exception -> 0x0035 }
        r2.close();	 Catch:{ Exception -> 0x0035 }
    L_0x0035:
        r6 = new com.xunlei.tdlive.modal.JsonWrapper;
        r6.<init>(r1);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.loadFromFile(java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public boolean writeToFile(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x003a;
    L_0x0008:
        r0 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x003a }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x003a }
        r1.<init>(r3);	 Catch:{ Exception -> 0x003a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x003a }
        r3 = r2.mJsonArr;	 Catch:{ Exception -> 0x003a }
        if (r3 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x003a }
    L_0x0016:
        r3 = r2.mJsonArr;	 Catch:{ Exception -> 0x003a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x003a }
        r3 = r3.getBytes();	 Catch:{ Exception -> 0x003a }
        r0.write(r3);	 Catch:{ Exception -> 0x003a }
        goto L_0x0035;	 Catch:{ Exception -> 0x003a }
    L_0x0024:
        r3 = r2.mJsonObj;	 Catch:{ Exception -> 0x003a }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x003a }
    L_0x0028:
        r3 = r2.mJsonObj;	 Catch:{ Exception -> 0x003a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x003a }
        r3 = r3.getBytes();	 Catch:{ Exception -> 0x003a }
        r0.write(r3);	 Catch:{ Exception -> 0x003a }
    L_0x0035:
        r0.close();	 Catch:{ Exception -> 0x003a }
        r3 = 1;
        return r3;
    L_0x003a:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.writeToFile(java.lang.String):boolean");
    }

    public boolean isValid() {
        if (this.mJsonArr == null) {
            if (this.mJsonObj == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isArray() {
        return this.mJsonArr != null;
    }

    public int getLength() {
        if (isArray()) {
            return this.mJsonArr.length();
        }
        if (this.mJsonObj == null) {
            return 0;
        }
        return this.mJsonObj.length();
    }

    public boolean getBoolean(java.lang.String r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x000b }
        r2 = r0.getBoolean(r2);	 Catch:{ Throwable -> 0x000b }
        return r2;
    L_0x000b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getBoolean(java.lang.String, boolean):boolean");
    }

    public String getStringNotEmpty(String str, String str2) {
        str = getString(str, null);
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public String getStringNotEmpty(int i, String str) {
        i = getString(i, null);
        return TextUtils.isEmpty(i) ? str : i;
    }

    public java.lang.String getString(java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0016 }
        r2 = r0.getString(r2);	 Catch:{ Throwable -> 0x0016 }
        r0 = "null";	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x0016 }
        if (r0 == 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0016 }
    L_0x0012:
        r2 = "";	 Catch:{ Throwable -> 0x0016 }
        return r2;
    L_0x0015:
        return r2;
    L_0x0016:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getString(java.lang.String, java.lang.String):java.lang.String");
    }

    public java.lang.String getString(int r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0016 }
        r2 = r0.getString(r2);	 Catch:{ Throwable -> 0x0016 }
        r0 = "null";	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x0016 }
        if (r0 == 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0016 }
    L_0x0012:
        r2 = "";	 Catch:{ Throwable -> 0x0016 }
        return r2;
    L_0x0015:
        return r2;
    L_0x0016:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getString(int, java.lang.String):java.lang.String");
    }

    public int getInt(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x000b }
        r2 = r0.getInt(r2);	 Catch:{ Throwable -> 0x000b }
        return r2;
    L_0x000b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getInt(java.lang.String, int):int");
    }

    public int getInt(int r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x000b }
        r2 = r0.getInt(r2);	 Catch:{ Throwable -> 0x000b }
        return r2;
    L_0x000b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getInt(int, int):int");
    }

    public long getLong(java.lang.String r3, long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mJsonObj;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getLong(r3);	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getLong(java.lang.String, long):long");
    }

    public long getLong(int r3, long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mJsonArr;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getLong(r3);	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getLong(int, long):long");
    }

    public float getFloat(String str, float f) {
        return (float) getDouble(str, (double) f);
    }

    public float getFloat(int i, float f) {
        return (float) getDouble(i, (double) f);
    }

    public double getDouble(java.lang.String r3, double r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mJsonObj;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getDouble(r3);	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getDouble(java.lang.String, double):double");
    }

    public double getDouble(int r3, double r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r0 = r2.mJsonArr;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getDouble(r3);	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getDouble(int, double):double");
    }

    public com.xunlei.tdlive.modal.JsonWrapper getArray(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = new com.xunlei.tdlive.modal.JsonWrapper;	 Catch:{ Throwable -> 0x0010 }
        r1 = r2.mJsonObj;	 Catch:{ Throwable -> 0x0010 }
        r3 = r1.getJSONArray(r3);	 Catch:{ Throwable -> 0x0010 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getArray(java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public JsonWrapper getArray(String str, String str2) {
        str = getArray(str);
        return str == null ? new JsonWrapper(str2) : str;
    }

    public com.xunlei.tdlive.modal.JsonWrapper getArray(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = new com.xunlei.tdlive.modal.JsonWrapper;	 Catch:{ Throwable -> 0x0010 }
        r1 = r2.mJsonArr;	 Catch:{ Throwable -> 0x0010 }
        r3 = r1.getJSONArray(r3);	 Catch:{ Throwable -> 0x0010 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getArray(int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public JsonWrapper getArray(int i, String str) {
        i = getArray(i);
        return i == 0 ? new JsonWrapper(str) : i;
    }

    public com.xunlei.tdlive.modal.JsonWrapper getObject(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = new com.xunlei.tdlive.modal.JsonWrapper;	 Catch:{ Throwable -> 0x0010 }
        r1 = r2.mJsonObj;	 Catch:{ Throwable -> 0x0010 }
        r3 = r1.getJSONObject(r3);	 Catch:{ Throwable -> 0x0010 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getObject(java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public JsonWrapper getObject(String str, String str2) {
        str = getObject(str);
        return str == null ? new JsonWrapper(str2) : str;
    }

    public com.xunlei.tdlive.modal.JsonWrapper getObject(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = new com.xunlei.tdlive.modal.JsonWrapper;	 Catch:{ Throwable -> 0x0010 }
        r1 = r2.mJsonArr;	 Catch:{ Throwable -> 0x0010 }
        r3 = r1.getJSONObject(r3);	 Catch:{ Throwable -> 0x0010 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.getObject(int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public JsonWrapper getObject(int i, String str) {
        i = getObject(i);
        return i == 0 ? new JsonWrapper(str) : i;
    }

    public com.xunlei.tdlive.modal.JsonWrapper remove(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonArr;
        if (r0 == 0) goto L_0x0027;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0027 }
        r1 = 19;	 Catch:{ Throwable -> 0x0027 }
        if (r0 < r1) goto L_0x0010;	 Catch:{ Throwable -> 0x0027 }
    L_0x000a:
        r0 = r2.mJsonArr;	 Catch:{ Throwable -> 0x0027 }
        r0.remove(r3);	 Catch:{ Throwable -> 0x0027 }
        goto L_0x0027;	 Catch:{ Throwable -> 0x0027 }
    L_0x0010:
        r0 = org.json.JSONArray.class;	 Catch:{ Throwable -> 0x0027 }
        r1 = "values";	 Catch:{ Throwable -> 0x0027 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Throwable -> 0x0027 }
        r1 = 1;	 Catch:{ Throwable -> 0x0027 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0027 }
        r1 = r2.mJsonArr;	 Catch:{ Throwable -> 0x0027 }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x0027 }
        r0 = (java.util.List) r0;	 Catch:{ Throwable -> 0x0027 }
        r0.remove(r3);	 Catch:{ Throwable -> 0x0027 }
    L_0x0027:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.remove(int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper remove(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.remove(r2);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.remove(java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper add(com.xunlei.tdlive.modal.JsonWrapper r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.mJsonArr;
        if (r0 == 0) goto L_0x0026;
    L_0x0004:
        r0 = r4.isArray();
        if (r0 == 0) goto L_0x001f;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        r1 = r4.getLength();
        if (r0 >= r1) goto L_0x0026;
    L_0x0011:
        r1 = r3.mJsonArr;	 Catch:{ Throwable -> 0x001c }
        r2 = r4.mJsonArr;	 Catch:{ Throwable -> 0x001c }
        r2 = r2.get(r0);	 Catch:{ Throwable -> 0x001c }
        r1.put(r2);	 Catch:{ Throwable -> 0x001c }
    L_0x001c:
        r0 = r0 + 1;
        goto L_0x000b;
    L_0x001f:
        r0 = r3.mJsonArr;
        r4 = r4.mJsonObj;
        r0.put(r4);
    L_0x0026:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.add(com.xunlei.tdlive.modal.JsonWrapper):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper replace(com.xunlei.tdlive.modal.JsonWrapper r5, int r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.mJsonArr;
        if (r0 == 0) goto L_0x0054;
    L_0x0004:
        r0 = new org.json.JSONArray;
        r0.<init>();
        r1 = 0;
        r2 = r1;
    L_0x000b:
        if (r2 >= r6) goto L_0x0021;
    L_0x000d:
        r3 = r4.mJsonArr;
        r3 = r3.length();
        if (r2 >= r3) goto L_0x0021;
    L_0x0015:
        r3 = r4.mJsonArr;	 Catch:{ Throwable -> 0x001e }
        r3 = r3.get(r2);	 Catch:{ Throwable -> 0x001e }
        r0.put(r3);	 Catch:{ Throwable -> 0x001e }
    L_0x001e:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x0021:
        r6 = r5.isArray();
        if (r6 == 0) goto L_0x0039;
    L_0x0027:
        r6 = r5.getLength();
        if (r1 >= r6) goto L_0x003e;
    L_0x002d:
        r6 = r5.mJsonArr;	 Catch:{ Throwable -> 0x0036 }
        r6 = r6.get(r1);	 Catch:{ Throwable -> 0x0036 }
        r0.put(r6);	 Catch:{ Throwable -> 0x0036 }
    L_0x0036:
        r1 = r1 + 1;
        goto L_0x0027;
    L_0x0039:
        r5 = r5.mJsonObj;
        r0.put(r5);
    L_0x003e:
        r5 = r4.mJsonArr;
        r5 = r5.length();
        if (r7 >= r5) goto L_0x0052;
    L_0x0046:
        r5 = r4.mJsonArr;	 Catch:{ Throwable -> 0x004f }
        r5 = r5.get(r7);	 Catch:{ Throwable -> 0x004f }
        r0.put(r5);	 Catch:{ Throwable -> 0x004f }
    L_0x004f:
        r7 = r7 + 1;
        goto L_0x003e;
    L_0x0052:
        r4.mJsonArr = r0;
    L_0x0054:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.replace(com.xunlei.tdlive.modal.JsonWrapper, int, int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public JsonWrapper put(JsonWrapper jsonWrapper) {
        return put(-1, jsonWrapper);
    }

    public com.xunlei.tdlive.modal.JsonWrapper put(int r2, com.xunlei.tdlive.modal.JsonWrapper r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0031;
    L_0x0004:
        if (r2 >= 0) goto L_0x001c;
    L_0x0006:
        r2 = r3.isArray();	 Catch:{ Exception -> 0x0031 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0031 }
    L_0x000c:
        r2 = r1.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r3 = r3.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r2.put(r3);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x0014:
        r2 = r1.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r3 = r3.mJsonObj;	 Catch:{ Exception -> 0x0031 }
        r2.put(r3);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x001c:
        r0 = r3.isArray();	 Catch:{ Exception -> 0x0031 }
        if (r0 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x0031 }
    L_0x0022:
        r0 = r1.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r3 = r3.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x0031 }
        goto L_0x0031;	 Catch:{ Exception -> 0x0031 }
    L_0x002a:
        r0 = r1.mJsonArr;	 Catch:{ Exception -> 0x0031 }
        r3 = r3.mJsonObj;	 Catch:{ Exception -> 0x0031 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.put(int, com.xunlei.tdlive.modal.JsonWrapper):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper put(java.lang.String r3, com.xunlei.tdlive.modal.JsonWrapper r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mJsonObj;
        if (r0 == 0) goto L_0x001c;
    L_0x0004:
        r0 = r4.mJsonArr;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r4.mJsonObj;
        if (r0 == 0) goto L_0x001c;
    L_0x000c:
        r0 = r2.mJsonObj;	 Catch:{ Throwable -> 0x001c }
        r1 = r4.isArray();	 Catch:{ Throwable -> 0x001c }
        if (r1 == 0) goto L_0x0017;	 Catch:{ Throwable -> 0x001c }
    L_0x0014:
        r4 = r4.mJsonArr;	 Catch:{ Throwable -> 0x001c }
        goto L_0x0019;	 Catch:{ Throwable -> 0x001c }
    L_0x0017:
        r4 = r4.mJsonObj;	 Catch:{ Throwable -> 0x001c }
    L_0x0019:
        r0.put(r3, r4);	 Catch:{ Throwable -> 0x001c }
    L_0x001c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.put(java.lang.String, com.xunlei.tdlive.modal.JsonWrapper):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putString(java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putString(java.lang.String, java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putString(int r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        if (r2 >= 0) goto L_0x000c;
    L_0x0006:
        r2 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r2.put(r3);	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0011;	 Catch:{ Throwable -> 0x0011 }
    L_0x000c:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putString(int, java.lang.String):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putBoolean(java.lang.String r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putBoolean(java.lang.String, boolean):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putInt(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putInt(java.lang.String, int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putInt(int r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        if (r2 >= 0) goto L_0x000c;
    L_0x0006:
        r2 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r2.put(r3);	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0011;	 Catch:{ Throwable -> 0x0011 }
    L_0x000c:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putInt(int, int):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putLong(java.lang.String r2, long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putLong(java.lang.String, long):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putLong(int r2, long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        if (r2 >= 0) goto L_0x000c;
    L_0x0006:
        r2 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r2.put(r3);	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0011;	 Catch:{ Throwable -> 0x0011 }
    L_0x000c:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putLong(int, long):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putObject(java.lang.String r2, java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonObj;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.mJsonObj;	 Catch:{ Throwable -> 0x0009 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0009 }
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putObject(java.lang.String, java.lang.Object):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public com.xunlei.tdlive.modal.JsonWrapper putObject(int r2, java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mJsonArr;
        if (r0 == 0) goto L_0x0011;
    L_0x0004:
        if (r2 >= 0) goto L_0x000c;
    L_0x0006:
        r2 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r2.put(r3);	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0011;	 Catch:{ Throwable -> 0x0011 }
    L_0x000c:
        r0 = r1.mJsonArr;	 Catch:{ Throwable -> 0x0011 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.JsonWrapper.putObject(int, java.lang.Object):com.xunlei.tdlive.modal.JsonWrapper");
    }

    public Iterator<String> keys() {
        return this.mJsonObj != null ? this.mJsonObj.keys() : null;
    }

    public <T> T toObject(Class<T> cls) {
        return new Gson().fromJson(toString(), cls);
    }
}
