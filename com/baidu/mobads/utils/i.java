package com.baidu.mobads.utils;

import java.io.File;
import java.util.Arrays;

class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public void run() {
        try {
            File file = new File(this.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                Arrays.sort(listFiles, new j(this));
                long j = 0;
                for (int length = listFiles.length - 1; length >= 0; length--) {
                    File file2 = listFiles[length];
                    if (file2.exists()) {
                        if (System.currentTimeMillis() - file2.lastModified() > 2592000000L) {
                            file2.delete();
                        } else if (j + file2.length() > h.a) {
                            file2.delete();
                        } else {
                            j += file2.length();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
