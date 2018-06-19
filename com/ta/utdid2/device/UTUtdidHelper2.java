package com.ta.utdid2.device;

import com.ta.utdid2.android.utils.AESUtils;
import com.ta.utdid2.android.utils.Base64;

public class UTUtdidHelper2 {
    private String mAESKey;

    public UTUtdidHelper2() {
        this.mAESKey = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.mAESKey = Base64.encodeToString(this.mAESKey.getBytes(), 0);
    }

    public String dePack(String str) {
        return AESUtils.decrypt(this.mAESKey, str);
    }

    public java.lang.String dePackWithBase64(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mAESKey;
        r3 = com.ta.utdid2.android.utils.AESUtils.decrypt(r0, r3);
        r0 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r3);
        r1 = 0;
        if (r0 != 0) goto L_0x0019;
    L_0x000d:
        r0 = 0;
        r3 = com.ta.utdid2.android.utils.Base64.decode(r3, r0);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r0 = new java.lang.String;	 Catch:{ IllegalArgumentException -> 0x0018 }
        r0.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0018 }
        return r0;
    L_0x0018:
        return r1;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTUtdidHelper2.dePackWithBase64(java.lang.String):java.lang.String");
    }
}
