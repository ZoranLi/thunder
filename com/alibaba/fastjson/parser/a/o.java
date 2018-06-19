package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.serializer.af;
import com.alibaba.fastjson.serializer.ao;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* compiled from: Jdk8DateCodec */
public final class o implements r, ao {
    public static final o a = new o();

    public final int e_() {
        return 4;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        aVar = aVar.e;
        if (aVar.a() == 4) {
            obj = aVar.l();
            aVar.d();
            if (type == LocalDateTime.class) {
                return LocalDateTime.parse(obj);
            }
            if (type == LocalDate.class) {
                return LocalDate.parse(obj);
            }
            if (type == LocalTime.class) {
                return LocalTime.parse(obj);
            }
            if (type == ZonedDateTime.class) {
                return ZonedDateTime.parse(obj);
            }
            if (type == OffsetDateTime.class) {
                return OffsetDateTime.parse(obj);
            }
            if (type == OffsetTime.class) {
                return OffsetTime.parse(obj);
            }
            if (type == ZoneId.class) {
                return ZoneId.of(obj);
            }
            if (type == Period.class) {
                return Period.parse(obj);
            }
            if (type == Duration.class) {
                return Duration.parse(obj);
            }
            return type == Instant.class ? Instant.parse(obj) : null;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj == null) {
            afVar.write("null");
        } else {
            afVar.b(obj.toString());
        }
    }
}
