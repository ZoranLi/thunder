package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;

/* compiled from: BUGLY */
public class StringData extends Item<StringData> {
    public String value;

    public StringData(int i, String str) {
        super(i);
        this.value = str;
    }

    public int compareTo(StringData stringData) {
        return this.value.compareTo(stringData.value);
    }

    public int byteCountInDex() {
        try {
            return (Leb128.unsignedLeb128Size(this.value.length()) + ((int) Mutf8.countBytes(this.value, true))) + 1;
        } catch (Throwable e) {
            throw new DexException(e);
        }
    }
}
