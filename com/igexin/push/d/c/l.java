package com.igexin.push.d.c;

public class l extends e {
    public byte a;
    public Object b;

    public void a(byte[] bArr) {
    }

    public byte[] d() {
        Object obj;
        if (this.a != (byte) 1) {
            if (this.a != (byte) 2) {
                if (this.a == (byte) 3 || this.a != (byte) 4) {
                    obj = null;
                    if (obj != null) {
                        return null;
                    }
                    Object obj2 = new byte[(obj.length + 2)];
                    obj2[0] = this.a;
                    obj2[1] = (byte) obj.length;
                    System.arraycopy(obj, 0, obj2, 2, obj.length);
                    return obj2;
                }
            }
        }
        obj = ((String) this.b).getBytes();
        if (obj != null) {
            return null;
        }
        Object obj22 = new byte[(obj.length + 2)];
        obj22[0] = this.a;
        obj22[1] = (byte) obj.length;
        System.arraycopy(obj, 0, obj22, 2, obj.length);
        return obj22;
    }
}
