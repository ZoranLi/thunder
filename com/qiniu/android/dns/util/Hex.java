package com.qiniu.android.dns.util;

import java.io.IOException;

public final class Hex {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static class HexDecodeException extends IOException {
        public HexDecodeException(String str) {
            super(str);
        }
    }
}
