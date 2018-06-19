package com.taobao.accs.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexClassLoader;
import java.io.File;

/* compiled from: Taobao */
public class a {
    private static a a;
    private ClassLoader b = null;
    private boolean c = false;
    private Context d;

    /* compiled from: Taobao */
    private static class a extends DexClassLoader {
        private ClassLoader a;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader.getParent());
            this.a = classLoader;
        }

        protected java.lang.Class<?> findClass(java.lang.String r2) throws java.lang.ClassNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = super.findClass(r2);	 Catch:{ Exception -> 0x0005 }
            return r0;
        L_0x0005:
            r0 = r1.a;
            r2 = r0.loadClass(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.d.a.a.findClass(java.lang.String):java.lang.Class<?>");
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ACCSClassLoader$InnerClassLoader$");
            stringBuilder.append(hashCode());
            return stringBuilder.toString();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public synchronized ClassLoader a(Context context) {
        if (context != null) {
            this.d = context;
        }
        if (this.b == null) {
            ALog.d("ACCSClassLoader", "create new class loader", new Object[0]);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_UPDATE_FOLDER, null);
            StringBuilder stringBuilder = new StringBuilder("baseUpdateFolder:");
            stringBuilder.append(string);
            ALog.d("ACCSClassLoader", stringBuilder.toString(), new Object[0]);
            if (string != null) {
                context = context.getDir(string, 0);
                if (context.exists() && context.isDirectory()) {
                    File file = new File(context, Constants.UPDATE_DEX_FILE);
                    if (file.exists() && file.isFile() && sharedPreferences.getInt(Constants.SP_KEY_UPDATE_VERSION, 221) > 221) {
                        if (sharedPreferences.getBoolean(Constants.SP_KEY_UPDATE_DONE, false)) {
                            ALog.d("ACCSClassLoader", "dexopt already done", new Object[0]);
                            this.b = new a(file.getAbsolutePath(), context.getAbsolutePath(), new File(context.getParentFile(), ShareConstants.SO_PATH).getAbsolutePath(), a.class.getClassLoader());
                        } else {
                            ALog.d("ACCSClassLoader", "try dexopt", new Object[0]);
                            a(file.getAbsolutePath(), context.getAbsolutePath());
                        }
                    }
                }
            }
        }
        if (this.b == null) {
            ALog.d("ACCSClassLoader", "get defalut class loader", new Object[0]);
            this.b = a.class.getClassLoader();
        }
        return this.b;
    }

    public synchronized ClassLoader b() {
        if (this.b == null) {
            ALog.d("ACCSClassLoader", "get defalut class loader", new Object[0]);
            this.b = a.class.getClassLoader();
        }
        return this.b;
    }

    private synchronized void a(String str, String str2) {
        if (this.c) {
            ALog.d("ACCSClassLoader", "dexOpting, exit", new Object[0]);
            return;
        }
        this.c = true;
        new b(this, str, str2).start();
    }
}
