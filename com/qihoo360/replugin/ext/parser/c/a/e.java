package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

/* compiled from: LookupTranslator */
final class e extends b {
    private final HashMap<String, CharSequence> a = new HashMap();
    private final int b;
    private final int c;

    public e(CharSequence[]... charSequenceArr) {
        int i = 0;
        int i2 = Integer.MAX_VALUE;
        if (charSequenceArr != null) {
            int length = charSequenceArr.length;
            int i3 = 0;
            int i4 = Integer.MAX_VALUE;
            for (i2 = i3; i2 < length; i2++) {
                CharSequence[] charSequenceArr2 = charSequenceArr[i2];
                this.a.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length2 = charSequenceArr2[0].length();
                if (length2 < i4) {
                    i4 = length2;
                }
                if (length2 > i3) {
                    i3 = length2;
                }
            }
            i2 = i4;
            i = i3;
        }
        this.b = i2;
        this.c = i;
    }

    public final int a(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2 = this.c;
        if (this.c + i > charSequence.length()) {
            i2 = charSequence.length() - i;
        }
        while (i2 >= this.b) {
            CharSequence charSequence2 = (CharSequence) this.a.get(charSequence.subSequence(i, i + i2).toString());
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i2;
            }
            i2--;
        }
        return null;
    }
}
