package com.qihoo360.replugin.utils;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -146927496096066153L;
    private final StringBuilder builder;

    public void close() {
    }

    public void flush() {
    }

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(int i) {
        this.builder = new StringBuilder(i);
    }

    public StringBuilderWriter(StringBuilder stringBuilder) {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        this.builder = stringBuilder;
    }

    public Writer append(char c) {
        this.builder.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.builder.append(charSequence, i, i2);
        return this;
    }

    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.builder.append(cArr, i, i2);
        }
    }

    public StringBuilder getBuilder() {
        return this.builder;
    }

    public String toString() {
        return this.builder.toString();
    }
}
