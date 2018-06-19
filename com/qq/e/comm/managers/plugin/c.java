package com.qq.e.comm.managers.plugin;

import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.a;
import java.io.File;

final class c {
    final File a;
    final File b;
    String c;
    int d;

    public c(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    final boolean a() {
        try {
            if (this.b.exists() && this.a.exists()) {
                String[] split = StringUtil.readAll(this.b).split("#####");
                if (split.length == 2) {
                    boolean b;
                    String str = split[1];
                    int parseInteger = StringUtil.parseInteger(split[0], 0);
                    a a = a.a();
                    File file = this.a;
                    if (file != null) {
                        if (file.exists()) {
                            b = a.b(str, Md5Util.encode(file));
                            if (b) {
                                this.c = str;
                                this.d = parseInteger;
                                return true;
                            }
                        }
                    }
                    b = false;
                    if (b) {
                        this.c = str;
                        this.d = parseInteger;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.report("Exception while checking plugin", th);
            return false;
        }
    }
}
