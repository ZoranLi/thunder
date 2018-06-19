package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final Class<? extends Date> dateType;
    private final DateFormat enUsFormat;
    private final DateFormat localFormat;

    DefaultDateTypeAdapter(Class<? extends Date> cls) {
        this((Class) cls, DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        this((Class) cls, new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, int i) {
        this((Class) cls, DateFormat.getDateInstance(i, Locale.US), DateFormat.getDateInstance(i));
    }

    public DefaultDateTypeAdapter(int i, int i2) {
        this(Date.class, DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        this((Class) cls, DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    DefaultDateTypeAdapter(Class<? extends Date> cls, DateFormat dateFormat, DateFormat dateFormat2) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            this.dateType = cls;
            this.enUsFormat = dateFormat;
            this.localFormat = dateFormat2;
            return;
        }
        dateFormat2 = new StringBuilder("Date type must be one of ");
        dateFormat2.append(Date.class);
        dateFormat2.append(", ");
        dateFormat2.append(Timestamp.class);
        dateFormat2.append(", or ");
        dateFormat2.append(java.sql.Date.class);
        dateFormat2.append(" but was ");
        dateFormat2.append(cls);
        throw new IllegalArgumentException(dateFormat2.toString());
    }

    public final void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.localFormat) {
            jsonWriter.value(this.enUsFormat.format(date));
        }
    }

    public final Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader = deserializeToDate(jsonReader.nextString());
        if (this.dateType == Date.class) {
            return jsonReader;
        }
        if (this.dateType == Timestamp.class) {
            return new Timestamp(jsonReader.getTime());
        }
        if (this.dateType == java.sql.Date.class) {
            return new java.sql.Date(jsonReader.getTime());
        }
        throw new AssertionError();
    }

    private java.util.Date deserializeToDate(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.localFormat;
        monitor-enter(r0);
        r1 = r3.localFormat;	 Catch:{ ParseException -> 0x000d }
        r1 = r1.parse(r4);	 Catch:{ ParseException -> 0x000d }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;
    L_0x000b:
        r4 = move-exception;
        goto L_0x0028;
    L_0x000d:
        r1 = r3.enUsFormat;	 Catch:{ ParseException -> 0x0015 }
        r1 = r1.parse(r4);	 Catch:{ ParseException -> 0x0015 }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;
    L_0x0015:
        r1 = new java.text.ParsePosition;	 Catch:{ ParseException -> 0x0021 }
        r2 = 0;	 Catch:{ ParseException -> 0x0021 }
        r1.<init>(r2);	 Catch:{ ParseException -> 0x0021 }
        r1 = com.google.gson.internal.bind.util.ISO8601Utils.parse(r4, r1);	 Catch:{ ParseException -> 0x0021 }
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        return r1;	 Catch:{ all -> 0x000b }
    L_0x0021:
        r1 = move-exception;	 Catch:{ all -> 0x000b }
        r2 = new com.google.gson.JsonSyntaxException;	 Catch:{ all -> 0x000b }
        r2.<init>(r4, r1);	 Catch:{ all -> 0x000b }
        throw r2;	 Catch:{ all -> 0x000b }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x000b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.DefaultDateTypeAdapter.deserializeToDate(java.lang.String):java.util.Date");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SIMPLE_NAME);
        stringBuilder.append('(');
        stringBuilder.append(this.localFormat.getClass().getSimpleName());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
