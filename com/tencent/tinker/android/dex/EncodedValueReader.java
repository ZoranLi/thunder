package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;

/* compiled from: BUGLY */
public final class EncodedValueReader {
    public static final int ENCODED_ANNOTATION = 29;
    public static final int ENCODED_ARRAY = 28;
    public static final int ENCODED_BOOLEAN = 31;
    public static final int ENCODED_BYTE = 0;
    public static final int ENCODED_CHAR = 3;
    public static final int ENCODED_DOUBLE = 17;
    public static final int ENCODED_ENUM = 27;
    public static final int ENCODED_FIELD = 25;
    public static final int ENCODED_FLOAT = 16;
    public static final int ENCODED_INT = 4;
    public static final int ENCODED_LONG = 6;
    public static final int ENCODED_METHOD = 26;
    public static final int ENCODED_NULL = 30;
    public static final int ENCODED_SHORT = 2;
    public static final int ENCODED_STRING = 23;
    public static final int ENCODED_TYPE = 24;
    private static final int MUST_READ = -1;
    private int annotationType;
    private int arg;
    protected final ByteInput in;
    private int type;

    public EncodedValueReader(ByteInput byteInput) {
        this.type = -1;
        this.in = byteInput;
    }

    public EncodedValueReader(EncodedValue encodedValue) {
        this(encodedValue.asByteInput());
    }

    public EncodedValueReader(ByteInput byteInput, int i) {
        this.type = -1;
        this.in = byteInput;
        this.type = i;
    }

    public EncodedValueReader(EncodedValue encodedValue, int i) {
        this(encodedValue.asByteInput(), i);
    }

    public final int peek() {
        if (this.type == -1) {
            int readByte = this.in.readByte() & 255;
            this.type = readByte & 31;
            this.arg = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public final int readArray() {
        checkType(28);
        this.type = -1;
        return Leb128.readUnsignedLeb128(this.in);
    }

    public final int readAnnotation() {
        checkType(29);
        this.type = -1;
        this.annotationType = Leb128.readUnsignedLeb128(this.in);
        return Leb128.readUnsignedLeb128(this.in);
    }

    public final int getAnnotationType() {
        return this.annotationType;
    }

    public final int readAnnotationName() {
        return Leb128.readUnsignedLeb128(this.in);
    }

    public final byte readByte() {
        checkType(0);
        this.type = -1;
        return (byte) EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public final short readShort() {
        checkType(2);
        this.type = -1;
        return (short) EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public final char readChar() {
        checkType(3);
        this.type = -1;
        return (char) EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final int readInt() {
        checkType(4);
        this.type = -1;
        return EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public final long readLong() {
        checkType(6);
        this.type = -1;
        return EncodedValueCodec.readSignedLong(this.in, this.arg);
    }

    public final float readFloat() {
        checkType(16);
        this.type = -1;
        return Float.intBitsToFloat(EncodedValueCodec.readUnsignedInt(this.in, this.arg, true));
    }

    public final double readDouble() {
        checkType(17);
        this.type = -1;
        return Double.longBitsToDouble(EncodedValueCodec.readUnsignedLong(this.in, this.arg, true));
    }

    public final int readString() {
        checkType(23);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final int readType() {
        checkType(24);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final int readField() {
        checkType(25);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final int readEnum() {
        checkType(27);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final int readMethod() {
        checkType(26);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public final void readNull() {
        checkType(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        checkType(31);
        this.type = -1;
        return this.arg != 0;
    }

    public final void skipValue() {
        int peek = peek();
        if (peek == 0) {
            readByte();
        } else if (peek != 6) {
            switch (peek) {
                case 2:
                    readShort();
                    return;
                case 3:
                    readChar();
                    return;
                case 4:
                    readInt();
                    return;
                default:
                    switch (peek) {
                        case 16:
                            readFloat();
                            return;
                        case 17:
                            readDouble();
                            return;
                        default:
                            int i = 0;
                            switch (peek) {
                                case 23:
                                    readString();
                                    return;
                                case 24:
                                    readType();
                                    return;
                                case 25:
                                    readField();
                                    return;
                                case 26:
                                    readMethod();
                                    return;
                                case 27:
                                    readEnum();
                                    return;
                                case 28:
                                    peek = readArray();
                                    while (i < peek) {
                                        skipValue();
                                        i++;
                                    }
                                    return;
                                case 29:
                                    peek = readAnnotation();
                                    while (i < peek) {
                                        readAnnotationName();
                                        skipValue();
                                        i++;
                                    }
                                    return;
                                case 30:
                                    readNull();
                                    return;
                                case 31:
                                    readBoolean();
                                    return;
                                default:
                                    StringBuilder stringBuilder = new StringBuilder("Unexpected type: ");
                                    stringBuilder.append(Integer.toHexString(this.type));
                                    throw new DexException(stringBuilder.toString());
                            }
                    }
            }
        } else {
            readLong();
        }
    }

    private void checkType(int i) {
        if (peek() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i), Integer.valueOf(peek())}));
        }
    }
}
