package com.qq.e.comm.managers.status;

public enum Carrier {
    UNKNOWN(0),
    CMCC(1),
    UNICOM(2),
    TELECOM(3);
    
    private int a;

    private Carrier(int i) {
        this.a = i;
    }

    public final int getValue() {
        return this.a;
    }
}
