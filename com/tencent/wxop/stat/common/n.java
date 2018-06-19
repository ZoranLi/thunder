package com.tencent.wxop.stat.common;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class n implements FileFilter {
    n() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
