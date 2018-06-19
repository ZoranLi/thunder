package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a.r;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: MiscCodec */
public final class al implements r, ao {
    public static final al a = new al();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        ax axVar = afVar.a;
        if (obj == null) {
            axVar.write("null");
            return;
        }
        String toPattern;
        i = obj.getClass();
        if (i == SimpleDateFormat.class) {
            toPattern = ((SimpleDateFormat) obj).toPattern();
            if (axVar.b(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                axVar.write(123);
                axVar.d(a.DEFAULT_TYPE_KEY);
                afVar.a(obj.getClass().getName());
                axVar.a(',', "val", toPattern);
                axVar.write(125);
                return;
            }
        } else if (i == Class.class) {
            toPattern = ((Class) obj).getName();
        } else if (i == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
            type = inetSocketAddress.getAddress();
            axVar.write(123);
            if (type != null) {
                axVar.d("address");
                afVar.c(type);
                axVar.write(44);
            }
            axVar.d("port");
            axVar.a(inetSocketAddress.getPort());
            axVar.write(125);
            return;
        } else if ((obj instanceof File) != null) {
            toPattern = ((File) obj).getPath();
        } else if ((obj instanceof InetAddress) != null) {
            toPattern = ((InetAddress) obj).getHostAddress();
        } else if ((obj instanceof TimeZone) != null) {
            toPattern = ((TimeZone) obj).getID();
        } else if ((obj instanceof c) != null) {
            ((c) obj).writeJSONString(axVar);
            return;
        } else if ((obj instanceof Iterator) != null) {
            a(afVar, axVar, (Iterator) obj);
            return;
        } else if ((obj instanceof Iterable) != null) {
            a(afVar, axVar, ((Iterable) obj).iterator());
            return;
        } else {
            toPattern = obj.toString();
        }
        axVar.b(toPattern);
    }

    private static void a(af afVar, ax axVar, Iterator<?> it) {
        axVar.write(91);
        int i = 0;
        while (it.hasNext()) {
            if (i != 0) {
                axVar.write(44);
            }
            afVar.c(it.next());
            i++;
        }
        axVar.write(93);
    }

    public final <T> T a(com.alibaba.fastjson.parser.a aVar, Type type, Object obj) {
        obj = aVar.e;
        int i = 0;
        String str;
        if (type != InetSocketAddress.class) {
            Object a;
            if (aVar.g == 2) {
                aVar.g = 0;
                aVar.a(16);
                if (obj.a() != 4) {
                    throw new JSONException("syntax error");
                } else if ("val".equals(obj.l())) {
                    obj.d();
                    aVar.a(17);
                    a = aVar.a(null);
                    aVar.a(13);
                } else {
                    throw new JSONException("syntax error");
                }
            }
            a = aVar.a(null);
            if (a == null) {
                str = null;
            } else if (a instanceof String) {
                str = (String) a;
            } else {
                throw new JSONException("expect string");
            }
            if (str != null) {
                if (str.length() != 0) {
                    if (type == UUID.class) {
                        return UUID.fromString(str);
                    }
                    if (type == URI.class) {
                        return URI.create(str);
                    }
                    if (type == URL.class) {
                        try {
                            return new URL(str);
                        } catch (com.alibaba.fastjson.parser.a aVar2) {
                            throw new JSONException("create url error", aVar2);
                        }
                    } else if (type == Pattern.class) {
                        return Pattern.compile(str);
                    } else {
                        if (type == Locale.class) {
                            aVar2 = str.split("_");
                            if (aVar2.length == 1) {
                                return new Locale(aVar2[0]);
                            }
                            if (aVar2.length == 2) {
                                return new Locale(aVar2[0], aVar2[1]);
                            }
                            return new Locale(aVar2[0], aVar2[1], aVar2[2]);
                        } else if (type == SimpleDateFormat.class) {
                            aVar2 = new SimpleDateFormat(str, obj.y());
                            aVar2.setTimeZone(obj.x());
                            return aVar2;
                        } else {
                            if (!(type == InetAddress.class || type == Inet4Address.class)) {
                                if (type != Inet6Address.class) {
                                    if (type == File.class) {
                                        return new File(str);
                                    }
                                    if (type == TimeZone.class) {
                                        return TimeZone.getTimeZone(str);
                                    }
                                    if ((type instanceof ParameterizedType) != null) {
                                        type = ((ParameterizedType) type).getRawType();
                                    }
                                    if (type == Class.class) {
                                        return j.a(str, aVar2.b().b());
                                    }
                                    obj = new StringBuilder("MiscCodec not support ");
                                    obj.append(type);
                                    throw new JSONException(obj.toString());
                                }
                            }
                            try {
                                return InetAddress.getByName(str);
                            } catch (com.alibaba.fastjson.parser.a aVar22) {
                                throw new JSONException("deserialize inet adress error", aVar22);
                            }
                        }
                    }
                }
            }
            return null;
        } else if (obj.a() == 8) {
            obj.d();
            return null;
        } else {
            aVar22.a(12);
            type = null;
            while (true) {
                str = obj.l();
                obj.a(17);
                if (str.equals("address")) {
                    aVar22.a(17);
                    type = (InetAddress) aVar22.a((Type) InetAddress.class, null);
                } else if (str.equals("port")) {
                    aVar22.a(17);
                    if (obj.a() != 2) {
                        throw new JSONException("port is not int");
                    }
                    int n = obj.n();
                    obj.d();
                    i = n;
                } else {
                    aVar22.a(17);
                    aVar22.a(null);
                }
                if (obj.a() == 16) {
                    obj.d();
                } else {
                    aVar22.a(13);
                    return new InetSocketAddress(type, i);
                }
            }
        }
    }
}
