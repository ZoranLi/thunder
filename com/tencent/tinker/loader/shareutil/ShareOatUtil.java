package com.tencent.tinker.loader.shareutil;

/* compiled from: BUGLY */
public final class ShareOatUtil {
    private static final String TAG = "Tinker.OatUtil";

    /* compiled from: BUGLY */
    private enum InstructionSet {
        kNone,
        kArm,
        kArm64,
        kThumb2,
        kX86,
        kX86_64,
        kMips,
        kMips64
    }

    private ShareOatUtil() {
        throw new UnsupportedOperationException();
    }

    public static java.lang.String getOatFileInstructionSet(java.io.File r11) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new com.tencent.tinker.loader.shareutil.ShareElfFile;	 Catch:{ all -> 0x010f }
        r1.<init>(r11);	 Catch:{ all -> 0x010f }
        r11 = ".rodata";	 Catch:{ all -> 0x010d }
        r11 = r1.getSectionHeaderByName(r11);	 Catch:{ all -> 0x010d }
        if (r11 != 0) goto L_0x0016;	 Catch:{ all -> 0x010d }
    L_0x000e:
        r11 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        r0 = "Unable to find .rodata section.";	 Catch:{ all -> 0x010d }
        r11.<init>(r0);	 Catch:{ all -> 0x010d }
        throw r11;	 Catch:{ all -> 0x010d }
    L_0x0016:
        r0 = r1.getChannel();	 Catch:{ all -> 0x010d }
        r2 = r11.shOffset;	 Catch:{ all -> 0x010d }
        r0.position(r2);	 Catch:{ all -> 0x010d }
        r2 = 8;	 Catch:{ all -> 0x010d }
        r2 = new byte[r2];	 Catch:{ all -> 0x010d }
        r3 = java.nio.ByteBuffer.wrap(r2);	 Catch:{ all -> 0x010d }
        r4 = "Failed to read oat magic and version.";	 Catch:{ all -> 0x010d }
        com.tencent.tinker.loader.shareutil.ShareElfFile.readUntilLimit(r0, r3, r4);	 Catch:{ all -> 0x010d }
        r3 = 0;	 Catch:{ all -> 0x010d }
        r4 = r2[r3];	 Catch:{ all -> 0x010d }
        r5 = 111; // 0x6f float:1.56E-43 double:5.5E-322;	 Catch:{ all -> 0x010d }
        r6 = 4;	 Catch:{ all -> 0x010d }
        r7 = 2;	 Catch:{ all -> 0x010d }
        r8 = 1;	 Catch:{ all -> 0x010d }
        r9 = 3;	 Catch:{ all -> 0x010d }
        if (r4 != r5) goto L_0x00df;	 Catch:{ all -> 0x010d }
    L_0x0037:
        r4 = r2[r8];	 Catch:{ all -> 0x010d }
        r5 = 97;	 Catch:{ all -> 0x010d }
        if (r4 != r5) goto L_0x00df;	 Catch:{ all -> 0x010d }
    L_0x003d:
        r4 = r2[r7];	 Catch:{ all -> 0x010d }
        r5 = 116; // 0x74 float:1.63E-43 double:5.73E-322;	 Catch:{ all -> 0x010d }
        if (r4 != r5) goto L_0x00df;	 Catch:{ all -> 0x010d }
    L_0x0043:
        r4 = r2[r9];	 Catch:{ all -> 0x010d }
        r5 = 10;	 Catch:{ all -> 0x010d }
        if (r4 == r5) goto L_0x004b;	 Catch:{ all -> 0x010d }
    L_0x0049:
        goto L_0x00df;	 Catch:{ all -> 0x010d }
    L_0x004b:
        r3 = new java.lang.String;	 Catch:{ all -> 0x010d }
        r4 = "ASCII";	 Catch:{ all -> 0x010d }
        r4 = java.nio.charset.Charset.forName(r4);	 Catch:{ all -> 0x010d }
        r3.<init>(r2, r6, r9, r4);	 Catch:{ all -> 0x010d }
        java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x00cb }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = java.nio.ByteBuffer.allocate(r2);	 Catch:{ all -> 0x010d }
        r3 = r1.getDataOrder();	 Catch:{ all -> 0x010d }
        r2.order(r3);	 Catch:{ all -> 0x010d }
        r3 = r11.shOffset;	 Catch:{ all -> 0x010d }
        r7 = 12;	 Catch:{ all -> 0x010d }
        r9 = r3 + r7;	 Catch:{ all -> 0x010d }
        r0.position(r9);	 Catch:{ all -> 0x010d }
        r2.limit(r6);	 Catch:{ all -> 0x010d }
        r11 = "Failed to read isa num.";	 Catch:{ all -> 0x010d }
        com.tencent.tinker.loader.shareutil.ShareElfFile.readUntilLimit(r0, r2, r11);	 Catch:{ all -> 0x010d }
        r11 = r2.getInt();	 Catch:{ all -> 0x010d }
        if (r11 < 0) goto L_0x00b7;	 Catch:{ all -> 0x010d }
    L_0x007d:
        r0 = com.tencent.tinker.loader.shareutil.ShareOatUtil.InstructionSet.values();	 Catch:{ all -> 0x010d }
        r0 = r0.length;	 Catch:{ all -> 0x010d }
        if (r11 < r0) goto L_0x0085;	 Catch:{ all -> 0x010d }
    L_0x0084:
        goto L_0x00b7;	 Catch:{ all -> 0x010d }
    L_0x0085:
        r0 = com.tencent.tinker.loader.shareutil.ShareOatUtil.AnonymousClass1.$SwitchMap$com$tencent$tinker$loader$shareutil$ShareOatUtil$InstructionSet;	 Catch:{ all -> 0x010d }
        r2 = com.tencent.tinker.loader.shareutil.ShareOatUtil.InstructionSet.values();	 Catch:{ all -> 0x010d }
        r11 = r2[r11];	 Catch:{ all -> 0x010d }
        r11 = r11.ordinal();	 Catch:{ all -> 0x010d }
        r11 = r0[r11];	 Catch:{ all -> 0x010d }
        switch(r11) {
            case 1: goto L_0x00ab;
            case 2: goto L_0x00ab;
            case 3: goto L_0x00a8;
            case 4: goto L_0x00a5;
            case 5: goto L_0x00a2;
            case 6: goto L_0x009f;
            case 7: goto L_0x009c;
            case 8: goto L_0x0099;
            default: goto L_0x0096;
        };	 Catch:{ all -> 0x010d }
    L_0x0096:
        r11 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        goto L_0x00b1;	 Catch:{ all -> 0x010d }
    L_0x0099:
        r11 = "none";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x009c:
        r11 = "mips64";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x009f:
        r11 = "mips";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x00a2:
        r11 = "x86_64";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x00a5:
        r11 = "x86";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x00a8:
        r11 = "arm64";	 Catch:{ all -> 0x010d }
        goto L_0x00ad;	 Catch:{ all -> 0x010d }
    L_0x00ab:
        r11 = "arm";	 Catch:{ all -> 0x010d }
    L_0x00ad:
        r1.close();	 Catch:{ Exception -> 0x00b0 }
    L_0x00b0:
        return r11;
    L_0x00b1:
        r0 = "Should not reach here.";	 Catch:{ all -> 0x010d }
        r11.<init>(r0);	 Catch:{ all -> 0x010d }
        throw r11;	 Catch:{ all -> 0x010d }
    L_0x00b7:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r3 = "Bad isa num: ";	 Catch:{ all -> 0x010d }
        r2.<init>(r3);	 Catch:{ all -> 0x010d }
        r2.append(r11);	 Catch:{ all -> 0x010d }
        r11 = r2.toString();	 Catch:{ all -> 0x010d }
        r0.<init>(r11);	 Catch:{ all -> 0x010d }
        throw r0;	 Catch:{ all -> 0x010d }
    L_0x00cb:
        r11 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010d }
        r2 = "Bad oat version: ";	 Catch:{ all -> 0x010d }
        r0.<init>(r2);	 Catch:{ all -> 0x010d }
        r0.append(r3);	 Catch:{ all -> 0x010d }
        r0 = r0.toString();	 Catch:{ all -> 0x010d }
        r11.<init>(r0);	 Catch:{ all -> 0x010d }
        throw r11;	 Catch:{ all -> 0x010d }
    L_0x00df:
        r11 = new java.io.IOException;	 Catch:{ all -> 0x010d }
        r0 = "Bad oat magic: %x %x %x %x";	 Catch:{ all -> 0x010d }
        r4 = new java.lang.Object[r6];	 Catch:{ all -> 0x010d }
        r5 = r2[r3];	 Catch:{ all -> 0x010d }
        r5 = java.lang.Byte.valueOf(r5);	 Catch:{ all -> 0x010d }
        r4[r3] = r5;	 Catch:{ all -> 0x010d }
        r3 = r2[r8];	 Catch:{ all -> 0x010d }
        r3 = java.lang.Byte.valueOf(r3);	 Catch:{ all -> 0x010d }
        r4[r8] = r3;	 Catch:{ all -> 0x010d }
        r3 = r2[r7];	 Catch:{ all -> 0x010d }
        r3 = java.lang.Byte.valueOf(r3);	 Catch:{ all -> 0x010d }
        r4[r7] = r3;	 Catch:{ all -> 0x010d }
        r2 = r2[r9];	 Catch:{ all -> 0x010d }
        r2 = java.lang.Byte.valueOf(r2);	 Catch:{ all -> 0x010d }
        r4[r9] = r2;	 Catch:{ all -> 0x010d }
        r0 = java.lang.String.format(r0, r4);	 Catch:{ all -> 0x010d }
        r11.<init>(r0);	 Catch:{ all -> 0x010d }
        throw r11;	 Catch:{ all -> 0x010d }
    L_0x010d:
        r11 = move-exception;
        goto L_0x0111;
    L_0x010f:
        r11 = move-exception;
        r1 = r0;
    L_0x0111:
        if (r1 == 0) goto L_0x0116;
    L_0x0113:
        r1.close();	 Catch:{ Exception -> 0x0116 }
    L_0x0116:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareOatUtil.getOatFileInstructionSet(java.io.File):java.lang.String");
    }
}
