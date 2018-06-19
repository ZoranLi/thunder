package com.qihoo360.replugin.packages;

import com.qihoo360.replugin.b.c;
import java.io.File;

/* compiled from: RePluginInstaller */
public final class g {
    public static File a(File file, File file2) {
        if (file.getParentFile().equals(file2)) {
            if (c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("copyPnToInstallPathIfNeeded: Already p-n file in install path. Ignore. path=");
                stringBuilder.append(file.getAbsolutePath());
                c.b("RePluginInstaller", stringBuilder.toString());
            }
            return file;
        }
        File file3 = new File(file2, file.getName());
        if (c.a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("copyPnToInstallPathIfNeeded: Already p-n file, copy to install path. src=");
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append("; dest=");
            stringBuilder2.append(file3.getAbsolutePath());
            c.b("RePluginInstaller", stringBuilder2.toString());
        }
        try {
            com.qihoo360.replugin.utils.c.b(file, file3);
            return file3;
        } catch (File file4) {
            if (c.a != null) {
                c.b("RePluginInstaller", "copyPnToInstallPathIfNeeded: Copy fail!", file4);
            }
            return null;
        }
    }
}
