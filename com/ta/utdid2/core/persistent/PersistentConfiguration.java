package com.ta.utdid2.core.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.core.persistent.MySharedPreferences.MyEditor;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

public class PersistentConfiguration {
    private static final String KEY_TIMESTAMP = "t";
    private static final String KEY_TIMESTAMP2 = "t2";
    private boolean mCanRead = false;
    private boolean mCanWrite = false;
    private String mConfigName = "";
    private Context mContext = null;
    private Editor mEditor = null;
    private String mFolderName = "";
    private boolean mIsLessMode = false;
    private boolean mIsSafety = false;
    private MyEditor mMyEditor = null;
    private MySharedPreferences mMySP = null;
    private SharedPreferences mSp = null;
    private TransactionXMLFile mTxf = null;

    public PersistentConfiguration(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12, boolean r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r8.<init>();
        r0 = "";
        r8.mConfigName = r0;
        r0 = "";
        r8.mFolderName = r0;
        r0 = 0;
        r8.mIsSafety = r0;
        r8.mCanRead = r0;
        r8.mCanWrite = r0;
        r1 = 0;
        r8.mSp = r1;
        r8.mMySP = r1;
        r8.mEditor = r1;
        r8.mMyEditor = r1;
        r8.mContext = r1;
        r8.mTxf = r1;
        r8.mIsLessMode = r0;
        r8.mIsSafety = r12;
        r8.mIsLessMode = r13;
        r8.mConfigName = r11;
        r8.mFolderName = r10;
        r8.mContext = r9;
        r2 = 0;
        if (r9 == 0) goto L_0x003e;
    L_0x002f:
        r12 = r9.getSharedPreferences(r11, r0);
        r8.mSp = r12;
        r12 = r8.mSp;
        r4 = "t";
        r4 = r12.getLong(r4, r2);
        goto L_0x003f;
    L_0x003e:
        r4 = r2;
    L_0x003f:
        r12 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x0044 }
        goto L_0x0049;
    L_0x0044:
        r12 = move-exception;
        r12.printStackTrace();
        r12 = r1;
    L_0x0049:
        r1 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r12);
        if (r1 != 0) goto L_0x006a;
    L_0x004f:
        r1 = "mounted";
        r1 = r12.equals(r1);
        r6 = 1;
        if (r1 == 0) goto L_0x005d;
    L_0x0058:
        r8.mCanWrite = r6;
        r8.mCanRead = r6;
        goto L_0x006e;
    L_0x005d:
        r1 = "mounted_ro";
        r12 = r12.equals(r1);
        if (r12 == 0) goto L_0x006a;
    L_0x0065:
        r8.mCanRead = r6;
        r8.mCanWrite = r0;
        goto L_0x006e;
    L_0x006a:
        r8.mCanWrite = r0;
        r8.mCanRead = r0;
    L_0x006e:
        r12 = r8.mCanRead;
        if (r12 != 0) goto L_0x0076;
    L_0x0072:
        r12 = r8.mCanWrite;
        if (r12 == 0) goto L_0x0159;
    L_0x0076:
        if (r9 == 0) goto L_0x0159;
    L_0x0078:
        r12 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r10);
        if (r12 != 0) goto L_0x0159;
    L_0x007e:
        r10 = r8.getTransactionXMLFile(r10);
        r8.mTxf = r10;
        r10 = r8.mTxf;
        if (r10 == 0) goto L_0x0159;
    L_0x0088:
        r10 = r8.mTxf;	 Catch:{ Exception -> 0x0159 }
        r10 = r10.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0159 }
        r8.mMySP = r10;	 Catch:{ Exception -> 0x0159 }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0159 }
        r12 = "t";	 Catch:{ Exception -> 0x0159 }
        r6 = r10.getLong(r12, r2);	 Catch:{ Exception -> 0x0159 }
        if (r13 != 0) goto L_0x00d7;
    L_0x009a:
        r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r10 <= 0) goto L_0x00af;
    L_0x009e:
        r9 = r8.mSp;	 Catch:{ Exception -> 0x015a }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x015a }
        r8.copySPToMySP(r9, r10);	 Catch:{ Exception -> 0x015a }
        r9 = r8.mTxf;	 Catch:{ Exception -> 0x015a }
        r9 = r9.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x015a }
        r8.mMySP = r9;	 Catch:{ Exception -> 0x015a }
        goto L_0x015a;	 Catch:{ Exception -> 0x015a }
    L_0x00af:
        r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x015a }
        if (r10 >= 0) goto L_0x00c2;	 Catch:{ Exception -> 0x015a }
    L_0x00b3:
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x015a }
        r12 = r8.mSp;	 Catch:{ Exception -> 0x015a }
        r8.copyMySPToSP(r10, r12);	 Catch:{ Exception -> 0x015a }
        r9 = r9.getSharedPreferences(r11, r0);	 Catch:{ Exception -> 0x015a }
        r8.mSp = r9;	 Catch:{ Exception -> 0x015a }
        goto L_0x015a;	 Catch:{ Exception -> 0x015a }
    L_0x00c2:
        r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x015a }
        if (r9 != 0) goto L_0x015a;	 Catch:{ Exception -> 0x015a }
    L_0x00c6:
        r9 = r8.mSp;	 Catch:{ Exception -> 0x015a }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x015a }
        r8.copySPToMySP(r9, r10);	 Catch:{ Exception -> 0x015a }
        r9 = r8.mTxf;	 Catch:{ Exception -> 0x015a }
        r9 = r9.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x015a }
        r8.mMySP = r9;	 Catch:{ Exception -> 0x015a }
        goto L_0x015a;	 Catch:{ Exception -> 0x015a }
    L_0x00d7:
        r10 = r8.mSp;	 Catch:{ Exception -> 0x015a }
        r12 = "t2";	 Catch:{ Exception -> 0x015a }
        r12 = r10.getLong(r12, r2);	 Catch:{ Exception -> 0x015a }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0157 }
        r1 = "t2";	 Catch:{ Exception -> 0x0157 }
        r4 = r10.getLong(r1, r2);	 Catch:{ Exception -> 0x0157 }
        r10 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));
        if (r10 >= 0) goto L_0x00ff;
    L_0x00eb:
        r10 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r10 <= 0) goto L_0x00ff;
    L_0x00ef:
        r9 = r8.mSp;	 Catch:{ Exception -> 0x0156 }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0156 }
        r8.copySPToMySP(r9, r10);	 Catch:{ Exception -> 0x0156 }
        r9 = r8.mTxf;	 Catch:{ Exception -> 0x0156 }
        r9 = r9.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0156 }
        r8.mMySP = r9;	 Catch:{ Exception -> 0x0156 }
        goto L_0x0156;	 Catch:{ Exception -> 0x0156 }
    L_0x00ff:
        r10 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r10 <= 0) goto L_0x0115;	 Catch:{ Exception -> 0x0156 }
    L_0x0103:
        r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r10 <= 0) goto L_0x0115;	 Catch:{ Exception -> 0x0156 }
    L_0x0107:
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0156 }
        r1 = r8.mSp;	 Catch:{ Exception -> 0x0156 }
        r8.copyMySPToSP(r10, r1);	 Catch:{ Exception -> 0x0156 }
        r9 = r9.getSharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0156 }
        r8.mSp = r9;	 Catch:{ Exception -> 0x0156 }
        goto L_0x0156;	 Catch:{ Exception -> 0x0156 }
    L_0x0115:
        r10 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r10 != 0) goto L_0x012b;	 Catch:{ Exception -> 0x0156 }
    L_0x0119:
        r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r10 <= 0) goto L_0x012b;	 Catch:{ Exception -> 0x0156 }
    L_0x011d:
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0156 }
        r1 = r8.mSp;	 Catch:{ Exception -> 0x0156 }
        r8.copyMySPToSP(r10, r1);	 Catch:{ Exception -> 0x0156 }
        r9 = r9.getSharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0156 }
        r8.mSp = r9;	 Catch:{ Exception -> 0x0156 }
        goto L_0x0156;	 Catch:{ Exception -> 0x0156 }
    L_0x012b:
        r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r9 != 0) goto L_0x0143;	 Catch:{ Exception -> 0x0156 }
    L_0x012f:
        r9 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r9 <= 0) goto L_0x0143;	 Catch:{ Exception -> 0x0156 }
    L_0x0133:
        r9 = r8.mSp;	 Catch:{ Exception -> 0x0156 }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0156 }
        r8.copySPToMySP(r9, r10);	 Catch:{ Exception -> 0x0156 }
        r9 = r8.mTxf;	 Catch:{ Exception -> 0x0156 }
        r9 = r9.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0156 }
        r8.mMySP = r9;	 Catch:{ Exception -> 0x0156 }
        goto L_0x0156;	 Catch:{ Exception -> 0x0156 }
    L_0x0143:
        r9 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));	 Catch:{ Exception -> 0x0156 }
        if (r9 != 0) goto L_0x0156;	 Catch:{ Exception -> 0x0156 }
    L_0x0147:
        r9 = r8.mSp;	 Catch:{ Exception -> 0x0156 }
        r10 = r8.mMySP;	 Catch:{ Exception -> 0x0156 }
        r8.copySPToMySP(r9, r10);	 Catch:{ Exception -> 0x0156 }
        r9 = r8.mTxf;	 Catch:{ Exception -> 0x0156 }
        r9 = r9.getMySharedPreferences(r11, r0);	 Catch:{ Exception -> 0x0156 }
        r8.mMySP = r9;	 Catch:{ Exception -> 0x0156 }
    L_0x0156:
        r6 = r4;
    L_0x0157:
        r4 = r12;
        goto L_0x015a;
    L_0x0159:
        r6 = r2;
    L_0x015a:
        r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r9 != 0) goto L_0x0166;
    L_0x015e:
        r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r9 != 0) goto L_0x019f;
    L_0x0162:
        r9 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r9 != 0) goto L_0x019f;
    L_0x0166:
        r9 = java.lang.System.currentTimeMillis();
        r11 = r8.mIsLessMode;
        if (r11 == 0) goto L_0x017a;
    L_0x016e:
        r11 = r8.mIsLessMode;
        if (r11 == 0) goto L_0x019f;
    L_0x0172:
        r11 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r11 != 0) goto L_0x019f;
    L_0x0176:
        r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r11 != 0) goto L_0x019f;
    L_0x017a:
        r11 = r8.mSp;
        if (r11 == 0) goto L_0x018c;
    L_0x017e:
        r11 = r8.mSp;
        r11 = r11.edit();
        r12 = "t2";
        r11.putLong(r12, r9);
        r11.commit();
    L_0x018c:
        r11 = r8.mMySP;	 Catch:{ Exception -> 0x019f }
        if (r11 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x019f }
    L_0x0190:
        r11 = r8.mMySP;	 Catch:{ Exception -> 0x019f }
        r11 = r11.edit();	 Catch:{ Exception -> 0x019f }
        r12 = "t2";	 Catch:{ Exception -> 0x019f }
        r11.putLong(r12, r9);	 Catch:{ Exception -> 0x019f }
        r11.commit();	 Catch:{ Exception -> 0x019f }
        return;
    L_0x019f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.PersistentConfiguration.<init>(android.content.Context, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    private TransactionXMLFile getTransactionXMLFile(String str) {
        str = getRootFolder(str);
        if (str == null) {
            return null;
        }
        this.mTxf = new TransactionXMLFile(str.getAbsolutePath());
        return this.mTxf;
    }

    private File getRootFolder(String str) {
        if (Environment.getExternalStorageDirectory() == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    private void copySPToMySP(SharedPreferences sharedPreferences, MySharedPreferences mySharedPreferences) {
        if (sharedPreferences != null && mySharedPreferences != null) {
            mySharedPreferences = mySharedPreferences.edit();
            if (mySharedPreferences != null) {
                mySharedPreferences.clear();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        mySharedPreferences.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        mySharedPreferences.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        mySharedPreferences.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        mySharedPreferences.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        mySharedPreferences.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                mySharedPreferences.commit();
            }
        }
    }

    private void copyMySPToSP(MySharedPreferences mySharedPreferences, SharedPreferences sharedPreferences) {
        if (mySharedPreferences != null && sharedPreferences != null) {
            sharedPreferences = sharedPreferences.edit();
            if (sharedPreferences != null) {
                sharedPreferences.clear();
                for (Entry entry : mySharedPreferences.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        sharedPreferences.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        sharedPreferences.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        sharedPreferences.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        sharedPreferences.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        sharedPreferences.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                sharedPreferences.commit();
            }
        }
    }

    private boolean checkSDCardXMLFile() {
        if (this.mMySP == null) {
            return false;
        }
        boolean checkFile = this.mMySP.checkFile();
        if (!checkFile) {
            commit();
        }
        return checkFile;
    }

    private void initEditor() {
        if (this.mEditor == null && this.mSp != null) {
            this.mEditor = this.mSp.edit();
        }
        if (this.mCanWrite && this.mMyEditor == null && this.mMySP != null) {
            this.mMyEditor = this.mMySP.edit();
        }
        checkSDCardXMLFile();
    }

    public void putInt(String str, int i) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.putInt(str, i);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.putInt(str, i);
            }
        }
    }

    public void putLong(String str, long j) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.putLong(str, j);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.putLong(str, j);
            }
        }
    }

    public void putBoolean(String str, boolean z) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.putBoolean(str, z);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.putBoolean(str, z);
            }
        }
    }

    public void putFloat(String str, float f) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.putFloat(str, f);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.putFloat(str, f);
            }
        }
    }

    public void putString(String str, String str2) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.putString(str, str2);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.putString(str, str2);
            }
        }
    }

    public void remove(String str) {
        if (!StringUtils.isEmpty(str) && !str.equals("t")) {
            initEditor();
            if (this.mEditor != null) {
                this.mEditor.remove(str);
            }
            if (this.mMyEditor != null) {
                this.mMyEditor.remove(str);
            }
        }
    }

    public void reload() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.mSp;
        r1 = 0;
        if (r0 == 0) goto L_0x0013;
    L_0x0005:
        r0 = r3.mContext;
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r0 = r3.mContext;
        r2 = r3.mConfigName;
        r0 = r0.getSharedPreferences(r2, r1);
        r3.mSp = r0;
    L_0x0013:
        r0 = 0;
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x001a }
        r0 = r2;
        goto L_0x001e;
    L_0x001a:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x001e:
        r2 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x0047;
    L_0x0024:
        r2 = "mounted";
        r2 = r0.equals(r2);
        if (r2 != 0) goto L_0x0038;
    L_0x002c:
        r2 = "mounted_ro";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0047;
    L_0x0034:
        r0 = r3.mMySP;
        if (r0 == 0) goto L_0x0047;
    L_0x0038:
        r0 = r3.mTxf;	 Catch:{ Exception -> 0x0047 }
        if (r0 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x003c:
        r0 = r3.mTxf;	 Catch:{ Exception -> 0x0047 }
        r2 = r3.mConfigName;	 Catch:{ Exception -> 0x0047 }
        r0 = r0.getMySharedPreferences(r2, r1);	 Catch:{ Exception -> 0x0047 }
        r3.mMySP = r0;	 Catch:{ Exception -> 0x0047 }
        return;
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.PersistentConfiguration.reload():void");
    }

    public void clear() {
        initEditor();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mEditor != null) {
            this.mEditor.clear();
            this.mEditor.putLong("t", currentTimeMillis);
        }
        if (this.mMyEditor != null) {
            this.mMyEditor.clear();
            this.mMyEditor.putLong("t", currentTimeMillis);
        }
    }

    public boolean commit() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = java.lang.System.currentTimeMillis();
        r2 = r5.mEditor;
        r3 = 0;
        if (r2 == 0) goto L_0x0022;
    L_0x0009:
        r2 = r5.mIsLessMode;
        if (r2 != 0) goto L_0x0018;
    L_0x000d:
        r2 = r5.mSp;
        if (r2 == 0) goto L_0x0018;
    L_0x0011:
        r2 = r5.mEditor;
        r4 = "t";
        r2.putLong(r4, r0);
    L_0x0018:
        r0 = r5.mEditor;
        r0 = r0.commit();
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        r0 = r3;
        goto L_0x0023;
    L_0x0022:
        r0 = 1;
    L_0x0023:
        r1 = r5.mSp;
        if (r1 == 0) goto L_0x0035;
    L_0x0027:
        r1 = r5.mContext;
        if (r1 == 0) goto L_0x0035;
    L_0x002b:
        r1 = r5.mContext;
        r2 = r5.mConfigName;
        r1 = r1.getSharedPreferences(r2, r3);
        r5.mSp = r1;
    L_0x0035:
        r1 = 0;
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x003c }
        r1 = r2;
        goto L_0x0040;
    L_0x003c:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0040:
        r2 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x00ad;
    L_0x0046:
        r2 = "mounted";
        r2 = r1.equals(r2);
        if (r2 == 0) goto L_0x008b;
    L_0x004e:
        r2 = r5.mMySP;
        if (r2 != 0) goto L_0x007e;
    L_0x0052:
        r2 = r5.mFolderName;
        r2 = r5.getTransactionXMLFile(r2);
        if (r2 == 0) goto L_0x008b;
    L_0x005a:
        r4 = r5.mConfigName;
        r2 = r2.getMySharedPreferences(r4, r3);
        r5.mMySP = r2;
        r2 = r5.mIsLessMode;
        if (r2 != 0) goto L_0x006e;
    L_0x0066:
        r2 = r5.mSp;
        r4 = r5.mMySP;
        r5.copySPToMySP(r2, r4);
        goto L_0x0075;
    L_0x006e:
        r2 = r5.mMySP;
        r4 = r5.mSp;
        r5.copyMySPToSP(r2, r4);
    L_0x0075:
        r2 = r5.mMySP;
        r2 = r2.edit();
        r5.mMyEditor = r2;
        goto L_0x008b;
    L_0x007e:
        r2 = r5.mMyEditor;
        if (r2 == 0) goto L_0x008b;
    L_0x0082:
        r2 = r5.mMyEditor;
        r2 = r2.commit();
        if (r2 != 0) goto L_0x008b;
    L_0x008a:
        r0 = r3;
    L_0x008b:
        r2 = "mounted";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x009f;
    L_0x0093:
        r2 = "mounted_ro";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x00ad;
    L_0x009b:
        r1 = r5.mMySP;
        if (r1 == 0) goto L_0x00ad;
    L_0x009f:
        r1 = r5.mTxf;	 Catch:{ Exception -> 0x00ad }
        if (r1 == 0) goto L_0x00ad;	 Catch:{ Exception -> 0x00ad }
    L_0x00a3:
        r1 = r5.mTxf;	 Catch:{ Exception -> 0x00ad }
        r2 = r5.mConfigName;	 Catch:{ Exception -> 0x00ad }
        r1 = r1.getMySharedPreferences(r2, r3);	 Catch:{ Exception -> 0x00ad }
        r5.mMySP = r1;	 Catch:{ Exception -> 0x00ad }
    L_0x00ad:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.PersistentConfiguration.commit():boolean");
    }

    public String getString(String str) {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            String string = this.mSp.getString(str, "");
            if (!StringUtils.isEmpty(string)) {
                return string;
            }
        }
        return this.mMySP != null ? this.mMySP.getString(str, "") : "";
    }

    public int getInt(String str) {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            return this.mSp.getInt(str, 0);
        }
        if (this.mMySP != null) {
            return this.mMySP.getInt(str, 0);
        }
        return 0;
    }

    public long getLong(String str) {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            return this.mSp.getLong(str, 0);
        }
        if (this.mMySP != null) {
            return this.mMySP.getLong(str, 0);
        }
        return 0;
    }

    public float getFloat(String str) {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            return this.mSp.getFloat(str, 0.0f);
        }
        if (this.mMySP != null) {
            return this.mMySP.getFloat(str, 0.0f);
        }
        return 0.0f;
    }

    public boolean getBoolean(String str) {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            return this.mSp.getBoolean(str, false);
        }
        if (this.mMySP != null) {
            return this.mMySP.getBoolean(str, false);
        }
        return false;
    }

    public Map<String, ?> getAll() {
        checkSDCardXMLFile();
        if (this.mSp != null) {
            return this.mSp.getAll();
        }
        return this.mMySP != null ? this.mMySP.getAll() : null;
    }
}
