package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.TableOfContents.Section.Item;

/* compiled from: BUGLY */
public final class Annotation extends Item<Annotation> {
    public EncodedValue encodedAnnotation;
    public byte visibility;

    public Annotation(int i, byte b, EncodedValue encodedValue) {
        super(i);
        this.visibility = b;
        this.encodedAnnotation = encodedValue;
    }

    public final EncodedValueReader getReader() {
        return new EncodedValueReader(this.encodedAnnotation, 29);
    }

    public final int getTypeIndex() {
        EncodedValueReader reader = getReader();
        reader.readAnnotation();
        return reader.getAnnotationType();
    }

    public final int compareTo(Annotation annotation) {
        return this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
    }

    public final int byteCountInDex() {
        return 1 + this.encodedAnnotation.byteCountInDex();
    }
}
