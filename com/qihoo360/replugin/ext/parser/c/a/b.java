package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: CharSequenceTranslator */
abstract class b {
    public abstract int a(CharSequence charSequence, int i, Writer writer) throws IOException;

    b() {
    }

    public final String a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            Writer stringWriter = new StringWriter(charSequence.length() * 2);
            a(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (CharSequence charSequence2) {
            throw new RuntimeException(charSequence2);
        }
    }

    private void a(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int a = a(charSequence, i, writer);
                if (a == 0) {
                    char[] toChars = Character.toChars(Character.codePointAt(charSequence, i));
                    writer.write(toChars);
                    i += toChars.length;
                } else {
                    int i2 = i;
                    for (i = 0; i < a; i++) {
                        i2 += Character.charCount(Character.codePointAt(charSequence, i2));
                    }
                    i = i2;
                }
            }
        }
    }
}
