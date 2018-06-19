package com.xunlei.common.encrypt;

import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;

public class CharsetConvert {
    public static final String GBK = "GBK";
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String US_ASCII = "US-ASCII";
    public static final String UTF_16 = "UTF-16";
    public static final String UTF_16BE = "UTF-16BE";
    public static final String UTF_16LE = "UTF-16LE";
    public static final String UTF_8 = "UTF-8";

    public static String inputStreamToGBK(InputStream inputStream) throws IOException {
        return inputStreamconvertToCharset(inputStream, GBK);
    }

    public static String inputStreamToGBK(byte[] bArr) throws IOException {
        return inputStreamToGBK(new ByteArrayInputStream(bArr));
    }

    public static String inputStreamToUTF8(InputStream inputStream) throws IOException {
        return inputStreamconvertToCharset(inputStream, "UTF-8");
    }

    public static String inputStreamToUTF8(byte[] bArr) throws IOException {
        return inputStreamToUTF8(new ByteArrayInputStream(bArr));
    }

    public static String StringToGBK(String str) throws IOException {
        return strconvertToCharset(str, GBK);
    }

    public static String utf8ToUnicode(String str) {
        char[] toCharArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            UnicodeBlock of = UnicodeBlock.of(toCharArray[i]);
            if (of == UnicodeBlock.BASIC_LATIN) {
                stringBuffer.append(toCharArray[i]);
            } else if (of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                stringBuffer.append((char) (toCharArray[i] - 65248));
            } else {
                String toHexString = Integer.toHexString((short) toCharArray[i]);
                StringBuilder stringBuilder = new StringBuilder("\\u");
                stringBuilder.append(toHexString);
                stringBuffer.append(stringBuilder.toString().toLowerCase());
            }
        }
        return stringBuffer.toString();
    }

    public static String unicodeToUtf8(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    int i3 = 0;
                    i2 = i;
                    i = i3;
                    while (i < 4) {
                        int i4 = i2 + 1;
                        charAt2 = str.charAt(i2);
                        switch (charAt2) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i3 = ((i3 << 4) + charAt2) - 48;
                                break;
                            default:
                                switch (charAt2) {
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        i3 = (((i3 << 4) + 10) + charAt2) - 65;
                                        break;
                                    default:
                                        switch (charAt2) {
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                i3 = (((i3 << 4) + 10) + charAt2) - 97;
                                                break;
                                            default:
                                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                                        }
                                }
                        }
                        i++;
                        i2 = i4;
                    }
                    stringBuffer.append((char) i3);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = '\r';
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                }
            } else {
                stringBuffer.append(charAt);
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    private static String strconvertToCharset(String str, String str2) throws UnsupportedEncodingException {
        return new String(str.getBytes(), str2);
    }

    private static String inputStreamconvertToCharset(InputStream inputStream, String str) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        inputStream = new StringBuffer();
        str = new char[64];
        while (true) {
            try {
                int read = inputStreamReader.read(str);
                if (read == -1) {
                    break;
                }
                inputStream.append(str, 0, read);
            } finally {
                inputStreamReader.close();
            }
        }
        return inputStream.toString();
    }

    public static String correctGBUrlCodeString(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        str = str.split("%");
        stringBuffer.append(str[0]);
        int i = 0;
        int i2 = 1;
        while (i2 < str.length) {
            stringBuffer.append("%");
            char[] toCharArray = str[i2].toCharArray();
            if (toCharArray.length <= 0) {
                return null;
            }
            if (i == 1) {
                stringBuffer.append(toCharArray);
                if (toCharArray[0] == '3') {
                    stringBuffer.append("%");
                    stringBuffer.append(str[i2 + 1]);
                    stringBuffer.append("%");
                    i2 += 2;
                    stringBuffer.append(str[i2]);
                }
                i = 0;
            } else if (toCharArray[0] >= '0' && toCharArray[0] <= '7') {
                stringBuffer.append(toCharArray);
            } else if (toCharArray.length == 2) {
                stringBuffer.append(toCharArray);
                i = 1;
            } else {
                byte[] byte_to_hex = HextoChar.byte_to_hex((byte) toCharArray[2]);
                stringBuffer.append(toCharArray, 0, 2);
                stringBuffer.append("%");
                stringBuffer.append(new String(byte_to_hex));
                stringBuffer.append(toCharArray, 3, toCharArray.length - 3);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public static boolean testUTF8(byte[] bArr) {
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= bArr.length) {
                return true;
            }
            int i3 = bArr[i] & 255;
            if ((i3 >>> 7) != 0) {
                if ((i3 >>> 6) == 2) {
                    return false;
                }
                if ((i3 >>> 5) == 6) {
                    i2 = 2;
                } else if ((i3 >>> 4) == 14) {
                    i2 = 3;
                } else if ((i3 >>> 3) == 30) {
                    i2 = 4;
                } else if ((i3 >>> 2) == 62) {
                    i2 = 5;
                } else if ((i3 >>> 1) != Opcodes.NOT_LONG) {
                    return false;
                } else {
                    i2 = 6;
                }
            }
            i2 += i;
            if (i2 - 1 >= bArr.length) {
                return false;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    break;
                } else if (((bArr[i] & 255) >>> 6) != 2) {
                    return false;
                }
            }
            i = i2;
        }
    }
}
