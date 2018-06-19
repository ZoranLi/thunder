package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.d;
import java.lang.reflect.Type;
import java.sql.Time;

/* compiled from: TimeDeserializer */
public final class y implements r {
    public static final y a = new y();

    public final int e_() {
        return 2;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        type = aVar.e;
        if (type.a() == 16) {
            type.a(4);
            if (type.a() != 4) {
                throw new JSONException("syntax error");
            }
            type.p();
            if (type.a() != 2) {
                throw new JSONException("syntax error");
            }
            long s = type.s();
            type.a(13);
            if (type.a() != 13) {
                throw new JSONException("syntax error");
            }
            type.a(16);
            return new Time(s);
        }
        aVar = aVar.a(null);
        if (aVar == null) {
            return null;
        }
        if ((aVar instanceof Time) != null) {
            return aVar;
        }
        if ((aVar instanceof Number) != null) {
            return new Time(((Number) aVar).longValue());
        }
        if ((aVar instanceof String) != null) {
            String str = (String) aVar;
            if (str.length() == null) {
                return null;
            }
            long timeInMillis;
            type = new d(str);
            if (type.D() != null) {
                timeInMillis = type.C().getTimeInMillis();
            } else {
                obj = null;
                int i = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt < '0') {
                        break;
                    } else if (charAt > '9') {
                        break;
                    } else {
                        i++;
                    }
                }
                obj = true;
                if (obj == null) {
                    type.close();
                    return Time.valueOf(str);
                }
                timeInMillis = Long.parseLong(str);
            }
            type.close();
            return new Time(timeInMillis);
        }
        throw new JSONException("parse error");
    }
}
