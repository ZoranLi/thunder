package com.ta.utdid2.core.persistent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.xmlpull.v1.XmlSerializer;

class FastXmlSerializer implements XmlSerializer {
    private static final int BUFFER_LEN = 8192;
    private static final String[] ESCAPE_TABLE;
    private ByteBuffer mBytes = ByteBuffer.allocate(8192);
    private CharsetEncoder mCharset;
    private boolean mInTag;
    private OutputStream mOutputStream;
    private int mPos;
    private final char[] mText = new char[8192];
    private Writer mWriter;

    FastXmlSerializer() {
    }

    static {
        String[] strArr = new String[64];
        strArr[34] = "&quot;";
        strArr[38] = "&amp;";
        strArr[60] = "&lt;";
        strArr[62] = "&gt;";
        ESCAPE_TABLE = strArr;
    }

    private void append(char c) throws IOException {
        int i = this.mPos;
        if (i >= 8191) {
            flush();
            i = this.mPos;
        }
        this.mText[i] = c;
        this.mPos = i + 1;
    }

    private void append(String str, int i, int i2) throws IOException {
        int i3;
        if (i2 > 8192) {
            i3 = i + i2;
            while (i < i3) {
                i2 = i + 8192;
                append(str, i, i2 < i3 ? 8192 : i3 - i);
                i = i2;
            }
            return;
        }
        i3 = this.mPos;
        if (i3 + i2 > 8192) {
            flush();
            i3 = this.mPos;
        }
        str.getChars(i, i + i2, this.mText, i3);
        this.mPos = i3 + i2;
    }

    private void append(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (i2 > 8192) {
            i3 = i + i2;
            while (i < i3) {
                i2 = i + 8192;
                append(cArr, i, i2 < i3 ? 8192 : i3 - i);
                i = i2;
            }
            return;
        }
        i3 = this.mPos;
        if (i3 + i2 > 8192) {
            flush();
            i3 = this.mPos;
        }
        System.arraycopy(cArr, i, this.mText, i3, i2);
        this.mPos = i3 + i2;
    }

    private void append(String str) throws IOException {
        append(str, 0, str.length());
    }

    private void escapeAndAppendString(String str) throws IOException {
        int length = str.length();
        int i = 0;
        char length2 = (char) ESCAPE_TABLE.length;
        String[] strArr = ESCAPE_TABLE;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < length2) {
                String str2 = strArr[charAt];
                if (str2 != null) {
                    if (i2 < i) {
                        append(str, i2, i - i2);
                    }
                    i2 = i + 1;
                    append(str2);
                }
            }
            i++;
        }
        if (i2 < i) {
            append(str, i2, i - i2);
        }
    }

    private void escapeAndAppendString(char[] cArr, int i, int i2) throws IOException {
        char length = (char) ESCAPE_TABLE.length;
        String[] strArr = ESCAPE_TABLE;
        i2 += i;
        int i3 = i;
        while (i < i2) {
            char c = cArr[i];
            if (c < length) {
                String str = strArr[c];
                if (str != null) {
                    if (i3 < i) {
                        append(cArr, i3, i - i3);
                    }
                    i3 = i + 1;
                    append(str);
                }
            }
            i++;
        }
        if (i3 < i) {
            append(cArr, i3, i - i3);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        append("=\"");
        escapeAndAppendString(str3);
        append('\"');
        return this;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.mInTag) {
            append(" />\n");
        } else {
            append("</");
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            append(">\n");
        }
        this.mInTag = null;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void flushBytes() throws IOException {
        int position = this.mBytes.position();
        if (position > 0) {
            this.mBytes.flip();
            this.mOutputStream.write(this.mBytes.array(), 0, position);
            this.mBytes.clear();
        }
    }

    public void flush() throws IOException {
        if (this.mPos > 0) {
            if (this.mOutputStream != null) {
                CharBuffer wrap = CharBuffer.wrap(this.mText, 0, this.mPos);
                CoderResult encode = this.mCharset.encode(wrap, this.mBytes, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        flushBytes();
                        encode = this.mCharset.encode(wrap, this.mBytes, true);
                    } else {
                        flushBytes();
                        this.mOutputStream.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.mWriter.write(this.mText, 0, this.mPos);
            this.mWriter.flush();
            this.mPos = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (str.equals("http://xmlpull.org/v1/doc/features.html#indent-output") == null) {
            throw new UnsupportedOperationException();
        }
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.mCharset = Charset.forName(str).newEncoder();
            this.mOutputStream = outputStream;
        } catch (OutputStream outputStream2) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(outputStream2));
        } catch (OutputStream outputStream22) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(outputStream22));
        }
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mWriter = writer;
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        str = new StringBuilder("<?xml version='1.0' encoding='utf-8' standalone='");
        str.append(bool.booleanValue() != null ? "yes" : "no");
        str.append("' ?>\n");
        append(str.toString());
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.mInTag) {
            append(">\n");
        }
        append('<');
        if (str != null) {
            append(str);
            append(':');
        }
        append(str2);
        this.mInTag = true;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.mInTag) {
            append(">");
            this.mInTag = false;
        }
        escapeAndAppendString(cArr, i, i2);
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.mInTag) {
            append(">");
            this.mInTag = false;
        }
        escapeAndAppendString(str);
        return this;
    }
}
