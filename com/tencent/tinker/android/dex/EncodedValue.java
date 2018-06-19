package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.CompareUtils;

/* compiled from: BUGLY */
public final class EncodedValue extends Item<EncodedValue> {
    public byte[] data;

    public EncodedValue(int i, byte[] bArr) {
        super(i);
        this.data = bArr;
    }

    public final ByteInput asByteInput() {
        return new ByteInput() {
            private int position = null;

            public byte readByte() {
                byte[] bArr = EncodedValue.this.data;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            }
        };
    }

    public final int compareTo(EncodedValue encodedValue) {
        return CompareUtils.uArrCompare(this.data, encodedValue.data);
    }

    public final int byteCountInDex() {
        return 1 * this.data.length;
    }
}
