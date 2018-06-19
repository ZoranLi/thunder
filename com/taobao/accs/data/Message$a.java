package com.taobao.accs.data;

/* compiled from: Taobao */
public class Message$a {
    public static final int INVALID = -1;
    public static final int NEED_ACK = 1;
    public static final int NO_ACK = 0;

    public static int a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 1;
        }
    }

    public static String b(int i) {
        switch (i) {
            case 0:
                return "NO_ACK";
            case 1:
                return "NEED_ACK";
            default:
                return "INVALID";
        }
    }
}
