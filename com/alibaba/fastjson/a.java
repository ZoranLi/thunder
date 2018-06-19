package com.alibaba.fastjson;

import com.alibaba.fastjson.a.d;
import com.alibaba.fastjson.c.e;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a.i;
import com.alibaba.fastjson.parser.a.j;
import com.alibaba.fastjson.parser.a.l;
import com.alibaba.fastjson.parser.a.t;
import com.alibaba.fastjson.parser.g;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.af;
import com.alibaba.fastjson.serializer.ah;
import com.alibaba.fastjson.serializer.am;
import com.alibaba.fastjson.serializer.aq;
import com.alibaba.fastjson.serializer.ar;
import com.alibaba.fastjson.serializer.av;
import com.alibaba.fastjson.serializer.aw;
import com.alibaba.fastjson.serializer.ax;
import com.alibaba.fastjson.serializer.az;
import com.alibaba.fastjson.serializer.c;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

/* compiled from: JSON */
public abstract class a implements b, c {
    public static int DEFAULT_GENERATE_FEATURE = ((((0 | SerializerFeature.QuoteFieldNames.getMask()) | SerializerFeature.SkipTransientField.getMask()) | SerializerFeature.WriteEnumUsingName.getMask()) | SerializerFeature.SortField.getMask());
    public static int DEFAULT_PARSER_FEATURE = ((((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask());
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String VERSION = "1.2.9";
    public static Locale defaultLocale = Locale.getDefault();
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    static final aw[] emptyFilters = new aw[0];

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String str, int i) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.a aVar = new com.alibaba.fastjson.parser.a(str, g.a(), i);
        str = aVar.a(null);
        aVar.g();
        aVar.close();
        return str;
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        return parse(bArr, 0, bArr.length, e.a(), featureArr);
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                int i3 = DEFAULT_PARSER_FEATURE;
                for (Feature config : featureArr) {
                    i3 = Feature.config(i3, config, true);
                }
                return parse(bArr, i, i2, charsetDecoder, i3);
            }
        }
        return null;
    }

    public static Object parse(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, int i3) {
        charsetDecoder.reset();
        char[] b = e.b((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(b);
        e.a(charsetDecoder, wrap, wrap2);
        i = new com.alibaba.fastjson.parser.a(b, wrap2.position(), g.a(), i3);
        bArr = i.a((Object) null);
        i.g();
        i.close();
        return bArr;
    }

    public static Object parse(String str, Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        return parse(str, i);
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static JSONObject parseObject(String str) {
        str = parse(str);
        if (str instanceof JSONObject) {
            return (JSONObject) str;
        }
        return (JSONObject) toJSON(str);
    }

    public static <T> T parseObject(String str, d<T> dVar, Feature... featureArr) {
        return parseObject(str, dVar.a, g.a, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return parseObject(str, cls, g.a, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, t tVar, Feature... featureArr) {
        return parseObject(str, (Type) cls, g.a, tVar, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return parseObject(str, type, g.a, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, t tVar, Feature... featureArr) {
        return parseObject(str, type, g.a, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature config : featureArr) {
            i = Feature.config(i, config, true);
        }
        featureArr = new com.alibaba.fastjson.parser.a(str, g.a(), i);
        str = featureArr.a(type, null);
        featureArr.g();
        featureArr.close();
        return str;
    }

    public static <T> T parseObject(String str, Type type, g gVar, int i, Feature... featureArr) {
        return parseObject(str, type, gVar, null, i, featureArr);
    }

    public static <T> T parseObject(String str, Type type, g gVar, t tVar, int i, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        if (featureArr != null) {
            for (Feature config : featureArr) {
                i = Feature.config(i, config, true);
            }
        }
        featureArr = new com.alibaba.fastjson.parser.a(str, gVar, i);
        if ((tVar instanceof j) != null) {
            if (featureArr.h == null) {
                featureArr.h = new ArrayList(2);
            }
            featureArr.h.add((j) tVar);
        }
        if ((tVar instanceof i) != null) {
            if (featureArr.i == null) {
                featureArr.i = new ArrayList(2);
            }
            featureArr.i.add((i) tVar);
        }
        if ((tVar instanceof l) != null) {
            featureArr.a((l) tVar);
        }
        str = featureArr.a(type, null);
        featureArr.g();
        featureArr.close();
        return str;
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return parseObject(bArr, 0, bArr.length, e.a(), type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i, int i2, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] b = e.b((int) (((double) i2) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        CharBuffer wrap2 = CharBuffer.wrap(b);
        e.a(charsetDecoder, wrap, wrap2);
        return parseObject(b, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i, Type type, Feature... featureArr) {
        if (cArr != null) {
            if (cArr.length != 0) {
                int i2 = DEFAULT_PARSER_FEATURE;
                for (Feature config : featureArr) {
                    i2 = Feature.config(i2, config, true);
                }
                featureArr = new com.alibaba.fastjson.parser.a(cArr, i, g.a(), i2);
                cArr = featureArr.a(type, null);
                featureArr.g();
                featureArr.close();
                return cArr;
            }
        }
        return null;
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, (Class) cls, new Feature[0]);
    }

    public static JSONArray parseArray(String str) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.a aVar = new com.alibaba.fastjson.parser.a(str, g.a());
        str = aVar.e;
        if (str.a() == 8) {
            str.d();
        } else if (str.a() != 20) {
            jSONArray = new JSONArray();
            aVar.b((Collection) jSONArray);
            aVar.g();
        }
        aVar.close();
        return jSONArray;
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        List<T> list = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.a aVar = new com.alibaba.fastjson.parser.a(str, g.a());
        str = aVar.e;
        int a = str.a();
        if (a == 8) {
            str.d();
        } else if (a != 20 || str.q() == null) {
            list = new ArrayList();
            aVar.a((Type) cls, (Collection) list);
            aVar.g();
        }
        aVar.close();
        return list;
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.a aVar = new com.alibaba.fastjson.parser.a(str, g.a());
        str = aVar.a(typeArr);
        if (str != null) {
            list = Arrays.asList(str);
        }
        aVar.g();
        aVar.close();
        return list;
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        ax axVar = new ax(DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new af(axVar).c(obj);
            obj = axVar.toString();
            return obj;
        } finally {
            axVar.close();
        }
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, av.a, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, aw awVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, av.a, new aw[]{awVar}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, aw[] awVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, av.a, awVarArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        ax axVar = new ax();
        try {
            af afVar = new af(axVar);
            for (SerializerFeature a : serializerFeatureArr) {
                afVar.a(a);
            }
            afVar.c(obj);
            obj = axVar.a("UTF-8");
            return obj;
        } finally {
            axVar.close();
        }
    }

    public static String toJSONString(Object obj, av avVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, avVar, null, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, av avVar, aw awVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, avVar, new aw[]{awVar}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, av avVar, aw[] awVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, avVar, awVarArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, av avVar, aw[] awVarArr, String str, int i, SerializerFeature... serializerFeatureArr) {
        ax axVar = new ax(i, serializerFeatureArr);
        try {
            i = new af(axVar, avVar);
            int i2 = 0;
            for (SerializerFeature a : serializerFeatureArr) {
                i.a(a);
            }
            if (!(str == null || str.length() == null)) {
                i.j = str;
                if (i.k != null) {
                    i.k = null;
                }
                i.a(SerializerFeature.WriteDateUseDateFormat);
            }
            if (awVarArr != null) {
                avVar = awVarArr.length;
                while (i2 < avVar) {
                    str = awVarArr[i2];
                    if (str != null) {
                        if ((str instanceof ar) != null) {
                            i.j().add((ar) str);
                        }
                        if ((str instanceof am) != null) {
                            i.i().add((am) str);
                        }
                        if ((str instanceof az) != null) {
                            i.b().add((az) str);
                        }
                        if ((str instanceof com.alibaba.fastjson.serializer.t) != null) {
                            i.c().add((com.alibaba.fastjson.serializer.t) str);
                        }
                        if ((str instanceof aq) != null) {
                            i.l().add((aq) str);
                        }
                        if ((str instanceof com.alibaba.fastjson.serializer.j) != null) {
                            i.g().add((com.alibaba.fastjson.serializer.j) str);
                        }
                        if ((str instanceof c) != null) {
                            i.h().add((c) str);
                        }
                        if ((str instanceof ah) != null) {
                            i.k().add((ah) str);
                        }
                    }
                    i2++;
                }
            }
            i.c(obj);
            obj = axVar.toString();
            return obj;
        } finally {
            axVar.close();
        }
    }

    public static String toJSONStringZ(Object obj, av avVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, avVar, emptyFilters, null, 0, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, av avVar, SerializerFeature... serializerFeatureArr) {
        ax axVar = new ax();
        try {
            af afVar = new af(axVar, avVar);
            for (SerializerFeature a : serializerFeatureArr) {
                afVar.a(a);
            }
            afVar.c(obj);
            obj = axVar.a("UTF-8");
            return obj;
        } finally {
            axVar.close();
        }
    }

    public static String toJSONString(Object obj, boolean z) {
        if (!z) {
            return toJSONString(obj);
        }
        return toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        ax axVar = new ax(writer);
        try {
            writer = new af(axVar);
            for (SerializerFeature a : serializerFeatureArr) {
                writer.a(a);
            }
            writer.c(obj);
        } finally {
            axVar.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    public String toJSONString() {
        ax axVar = new ax();
        try {
            new af(axVar).c(this);
            String axVar2 = axVar.toString();
            return axVar2;
        } finally {
            axVar.close();
        }
    }

    public void writeJSONString(Appendable appendable) {
        ax axVar = new ax();
        try {
            new af(axVar).c(this);
            appendable.append(axVar.toString());
            axVar.close();
        } catch (Appendable appendable2) {
            throw new JSONException(appendable2.getMessage(), appendable2);
        } catch (Throwable th) {
            axVar.close();
        }
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, g.a());
    }

    public static Object toJSON(Object obj, g gVar) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof a) != null) {
            return obj;
        }
        if ((obj instanceof Map) != null) {
            Map map = (Map) obj;
            gVar = new JSONObject(map.size());
            for (Entry entry : map.entrySet()) {
                gVar.put(com.alibaba.fastjson.c.j.a(entry.getKey()), toJSON(entry.getValue()));
            }
            return gVar;
        } else if ((obj instanceof Collection) != null) {
            Collection<Object> collection = (Collection) obj;
            gVar = new JSONArray(collection.size());
            for (Object toJSON : collection) {
                gVar.add(toJSON(toJSON));
            }
            return gVar;
        } else {
            Class cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            int i = 0;
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray = new JSONArray(length);
                while (i < length) {
                    jSONArray.add(toJSON(Array.get(obj, i)));
                    i++;
                }
                return jSONArray;
            } else if (g.a(cls)) {
                return obj;
            } else {
                try {
                    cls.getAnnotation(d.class);
                    g<com.alibaba.fastjson.c.d> a = com.alibaba.fastjson.c.j.a(cls, false);
                    JSONObject jSONObject = new JSONObject(a.size());
                    for (com.alibaba.fastjson.c.d dVar : a) {
                        jSONObject.put(dVar.a, toJSON(dVar.a(obj)));
                    }
                    return jSONObject;
                } catch (Object obj2) {
                    throw new JSONException("toJSON error", obj2);
                } catch (Object obj22) {
                    throw new JSONException("toJSON error", obj22);
                }
            }
        }
    }

    public static <T> T toJavaObject(a aVar, Class<T> cls) {
        return com.alibaba.fastjson.c.j.a((Object) aVar, (Class) cls, g.a());
    }

    public <T> T toJavaObject(Class<T> cls) {
        return com.alibaba.fastjson.c.j.a((Object) this, (Class) cls, g.a());
    }
}
