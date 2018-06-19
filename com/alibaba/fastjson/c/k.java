package com.alibaba.fastjson.c;

import com.aplayer.aplayerandroid.FF2AndroidMapper;
import com.taobao.accs.data.Message;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* compiled from: UTF8Decoder */
public final class k extends CharsetDecoder {
    private static final Charset a = Charset.forName("UTF-8");

    public k() {
        super(a, 1.0f, 1.0f);
    }

    private static CoderResult a(ByteBuffer byteBuffer, int i, CharBuffer charBuffer, int i2, int i3) {
        byteBuffer.position(i - byteBuffer.arrayOffset());
        int i4 = 2;
        int i5 = 1;
        switch (i3) {
            case 1:
                i3 = byteBuffer.get();
                if ((i3 >> 2) != -2) {
                    if ((i3 >> 1) == -2) {
                        if (byteBuffer.remaining() >= 5) {
                            while (i5 < 6) {
                                if ((byteBuffer.get() & 192) != 128) {
                                    i3 = CoderResult.malformedForLength(i5);
                                    break;
                                }
                                i5++;
                            }
                            i3 = CoderResult.malformedForLength(6);
                            break;
                        }
                        i3 = CoderResult.UNDERFLOW;
                        break;
                    }
                    i3 = CoderResult.malformedForLength(1);
                    break;
                } else if (byteBuffer.remaining() >= 4) {
                    while (i5 < 5) {
                        if ((byteBuffer.get() & 192) != 128) {
                            i3 = CoderResult.malformedForLength(i5);
                            break;
                        }
                        i5++;
                    }
                    i3 = CoderResult.malformedForLength(5);
                    break;
                } else {
                    i3 = CoderResult.UNDERFLOW;
                    break;
                }
            case 2:
                i3 = CoderResult.malformedForLength(1);
                break;
            case 3:
                i3 = byteBuffer.get();
                byte b = byteBuffer.get();
                if ((i3 == -32 && (b & 224) == 128) || (b & 192) != 128) {
                    i4 = 1;
                }
                i3 = CoderResult.malformedForLength(i4);
                break;
            case 4:
                i3 = byteBuffer.get() & 255;
                int i6 = byteBuffer.get() & 255;
                if (i3 <= FF2AndroidMapper.FF_PROFILE_H264_HIGH_444_PREDICTIVE && ((i3 != 240 || (i6 >= 144 && i6 <= 191)) && (i3 != FF2AndroidMapper.FF_PROFILE_H264_HIGH_444_PREDICTIVE || (i6 & 240) == 128))) {
                    if ((i6 & 192) == 128) {
                        if ((byteBuffer.get() & 192) == 128) {
                            i3 = CoderResult.malformedForLength(3);
                            break;
                        }
                        i3 = CoderResult.malformedForLength(2);
                        break;
                    }
                }
                i3 = CoderResult.malformedForLength(1);
                break;
            default:
                throw new IllegalStateException();
        }
        byteBuffer.position(i);
        charBuffer.position(i2);
        return i3;
    }

    private static CoderResult a(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4) {
        buffer.position(i);
        buffer2.position(i3);
        if (i4 != 0) {
            if (i2 - i >= i4) {
                return CoderResult.OVERFLOW;
            }
        }
        return CoderResult.UNDERFLOW;
    }

    protected final CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        Buffer buffer = byteBuffer;
        Buffer buffer2 = charBuffer;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int arrayOffset2 = byteBuffer.arrayOffset() + byteBuffer.limit();
        char[] array2 = charBuffer.array();
        int arrayOffset3 = charBuffer.arrayOffset() + charBuffer.position();
        int arrayOffset4 = charBuffer.arrayOffset() + charBuffer.limit();
        int min = Math.min(arrayOffset2 - arrayOffset, arrayOffset4 - arrayOffset3) + arrayOffset3;
        while (arrayOffset3 < min && array[arrayOffset] >= (byte) 0) {
            int i = arrayOffset3 + 1;
            int i2 = arrayOffset + 1;
            array2[arrayOffset3] = (char) array[arrayOffset];
            arrayOffset3 = i;
            arrayOffset = i2;
        }
        while (arrayOffset < arrayOffset2) {
            byte b = array[arrayOffset];
            if (b < (byte) 0) {
                int i3 = 1;
                byte b2;
                if ((b >> 5) == -2) {
                    if (arrayOffset2 - arrayOffset >= 2) {
                        if (arrayOffset3 < arrayOffset4) {
                            b2 = array[arrayOffset + 1];
                            if ((b & 30) != 0) {
                                if ((b2 & 192) == 128) {
                                    i3 = 0;
                                }
                            }
                            if (i3 != 0) {
                                return a(buffer, arrayOffset, buffer2, arrayOffset3, 2);
                            }
                            i2 = arrayOffset3 + 1;
                            array2[arrayOffset3] = (char) (((b << 6) ^ b2) ^ 3968);
                            arrayOffset += 2;
                        }
                    }
                    return a(buffer, arrayOffset, arrayOffset2, buffer2, arrayOffset3, 2);
                } else if ((b >> 4) == -2) {
                    if (arrayOffset2 - arrayOffset >= 3) {
                        if (arrayOffset3 < arrayOffset4) {
                            b2 = array[arrayOffset + 1];
                            r12 = array[arrayOffset + 2];
                            if (!(b == (byte) -32 && (b2 & 224) == 128) && (b2 & 192) == 128) {
                                if ((r12 & 192) == 128) {
                                    i3 = 0;
                                }
                            }
                            if (i3 != 0) {
                                return a(buffer, arrayOffset, buffer2, arrayOffset3, 3);
                            }
                            i2 = arrayOffset3 + 1;
                            array2[arrayOffset3] = (char) ((((b << 12) ^ (b2 << 6)) ^ r12) ^ 8064);
                            arrayOffset += 3;
                        }
                    }
                    return a(buffer, arrayOffset, arrayOffset2, buffer2, arrayOffset3, 3);
                } else if ((b >> 3) != -2) {
                    return a(buffer, arrayOffset, buffer2, arrayOffset3, 1);
                } else {
                    if (arrayOffset2 - arrayOffset >= 4) {
                        if (arrayOffset4 - arrayOffset3 >= 2) {
                            b2 = array[arrayOffset + 1];
                            r12 = array[arrayOffset + 2];
                            byte b3 = array[arrayOffset + 3];
                            min = ((((b & 7) << 18) | ((b2 & 63) << 12)) | ((r12 & 63) << 6)) | (b3 & 63);
                            if ((b2 & 192) == 128 && (r12 & 192) == 128) {
                                if ((b3 & 192) == 128) {
                                    i3 = 0;
                                }
                            }
                            if (i3 == 0 && min >= 65536) {
                                if (min <= 1114111) {
                                    i2 = arrayOffset3 + 1;
                                    min -= 65536;
                                    array2[arrayOffset3] = (char) (((min >> 10) & Message.EXT_HEADER_VALUE_MAX_LEN) | 55296);
                                    arrayOffset3 = i2 + 1;
                                    array2[i2] = (char) ((min & Message.EXT_HEADER_VALUE_MAX_LEN) | 56320);
                                    arrayOffset += 4;
                                }
                            }
                            return a(buffer, arrayOffset, buffer2, arrayOffset3, 4);
                        }
                    }
                    return a(buffer, arrayOffset, arrayOffset2, buffer2, arrayOffset3, 4);
                }
                arrayOffset3 = i2;
            } else if (arrayOffset3 >= arrayOffset4) {
                return a(buffer, arrayOffset, arrayOffset2, buffer2, arrayOffset3, 1);
            } else {
                i = arrayOffset3 + 1;
                array2[arrayOffset3] = (char) b;
                arrayOffset++;
                arrayOffset3 = i;
            }
        }
        return a(buffer, arrayOffset, arrayOffset2, buffer2, arrayOffset3, 0);
    }
}
