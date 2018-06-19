package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.e;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

/* compiled from: CalendarCodec */
public final class n implements r, ao {
    public static final n a = new n();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        af afVar2 = afVar;
        ax axVar = afVar2.a;
        if (obj == null) {
            axVar.write("null");
            return;
        }
        Calendar calendar = (Calendar) obj;
        if (axVar.b(SerializerFeature.UseISO8601DateFormat)) {
            char[] toCharArray;
            int i2 = axVar.b(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            axVar.write(i2);
            int i3 = calendar.get(1);
            int i4 = calendar.get(2) + 1;
            int i5 = calendar.get(5);
            int i6 = calendar.get(11);
            int i7 = calendar.get(12);
            int i8 = calendar.get(13);
            int i9 = calendar.get(14);
            if (i9 != 0) {
                toCharArray = "0000-00-00T00:00:00.000".toCharArray();
                e.a(i9, 23, toCharArray);
                e.a(i8, 19, toCharArray);
                e.a(i7, 16, toCharArray);
                e.a(i6, 13, toCharArray);
                e.a(i5, 10, toCharArray);
                e.a(i4, 7, toCharArray);
                e.a(i3, 4, toCharArray);
            } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                toCharArray = "0000-00-00".toCharArray();
                e.a(i5, 10, toCharArray);
                e.a(i4, 7, toCharArray);
                e.a(i3, 4, toCharArray);
            } else {
                toCharArray = "0000-00-00T00:00:00".toCharArray();
                e.a(i8, 19, toCharArray);
                e.a(i7, 16, toCharArray);
                e.a(i6, 13, toCharArray);
                e.a(i5, 10, toCharArray);
                e.a(i4, 7, toCharArray);
                e.a(i3, 4, toCharArray);
            }
            axVar.write(toCharArray);
            int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
            if (rawOffset == 0) {
                axVar.a((CharSequence) "Z");
            } else if (rawOffset > 0) {
                axVar.a((CharSequence) "+").a(String.format("%02d", new Object[]{Integer.valueOf(rawOffset)})).a((CharSequence) ":00");
            } else {
                axVar.a((CharSequence) "-").a(String.format("%02d", new Object[]{Integer.valueOf(-rawOffset)})).a((CharSequence) ":00");
            }
            axVar.write(i2);
            return;
        }
        afVar2.c(calendar.getTime());
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        type = v.a.a(aVar, type, obj);
        if ((type instanceof Calendar) != null) {
            return type;
        }
        Date date = (Date) type;
        if (date == null) {
            return null;
        }
        aVar = aVar.e;
        aVar = Calendar.getInstance(aVar.x(), aVar.y());
        aVar.setTime(date);
        return aVar;
    }
}
