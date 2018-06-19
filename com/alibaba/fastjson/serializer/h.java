package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.parser.a.r;
import com.alipay.sdk.cons.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: AwtCodec */
public final class h implements r, ao {
    public static final h a = new h();

    public final int e_() {
        return 12;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        ax axVar = afVar.a;
        if (obj == null) {
            axVar.write("null");
            return;
        }
        if ((obj instanceof Point) != null) {
            Point point = (Point) obj;
            axVar.a(a(axVar, Point.class, '{'), "x", point.getX());
            axVar.a(',', "y", point.getY());
        } else if ((obj instanceof Font) != null) {
            Font font = (Font) obj;
            axVar.a(a(axVar, Font.class, '{'), c.e, font.getName());
            axVar.a(',', "style", font.getStyle());
            axVar.a(',', "size", font.getSize());
        } else if ((obj instanceof Rectangle) != null) {
            Rectangle rectangle = (Rectangle) obj;
            axVar.a(a(axVar, Rectangle.class, '{'), "x", rectangle.getX());
            axVar.a(',', "y", rectangle.getY());
            axVar.a(',', SocializeProtocolConstants.WIDTH, rectangle.getWidth());
            axVar.a(',', SocializeProtocolConstants.HEIGHT, rectangle.getHeight());
        } else if ((obj instanceof Color) != null) {
            Color color = (Color) obj;
            axVar.a(a(axVar, Color.class, '{'), "r", color.getRed());
            axVar.a(',', "g", color.getGreen());
            axVar.a(',', b.a, color.getBlue());
            if (color.getAlpha() > null) {
                axVar.a(',', "alpha", color.getAlpha());
            }
        } else {
            obj2 = new StringBuilder("not support awt class : ");
            obj2.append(obj.getClass().getName());
            throw new JSONException(obj2.toString());
        }
        axVar.write(125);
    }

    private static char a(ax axVar, Class<?> cls, char c) {
        if (!axVar.b(SerializerFeature.WriteClassName)) {
            return c;
        }
        axVar.write((int) '{');
        axVar.d(a.DEFAULT_TYPE_KEY);
        axVar.b(cls.getName());
        return ',';
    }

    public final <T> T a(com.alibaba.fastjson.parser.a aVar, Type type, Object obj) {
        obj = aVar.e;
        if (obj.a() == 8) {
            obj.a(16);
            return null;
        } else if (obj.a() == 12 || obj.a() == 16) {
            obj.d();
            if (type == Point.class) {
                type = aVar.e;
                obj = null;
                int i = 0;
                while (type.a() != 13) {
                    if (type.a() == 4) {
                        String l = type.l();
                        if (a.DEFAULT_TYPE_KEY.equals(l)) {
                            l = "java.awt.Point";
                            com.alibaba.fastjson.parser.b bVar = aVar.e;
                            bVar.o();
                            if (bVar.a() != 4) {
                                throw new JSONException("type not match error");
                            } else if (l.equals(bVar.l())) {
                                bVar.d();
                                if (bVar.a() == 16) {
                                    bVar.d();
                                }
                            } else {
                                throw new JSONException("type not match error");
                            }
                        }
                        type.p();
                        if (type.a() == 2) {
                            int n = type.n();
                            type.d();
                            if (l.equalsIgnoreCase("x")) {
                                obj = n;
                            } else if (l.equalsIgnoreCase("y")) {
                                i = n;
                            } else {
                                type = new StringBuilder("syntax error, ");
                                type.append(l);
                                throw new JSONException(type.toString());
                            }
                            if (type.a() == 16) {
                                type.a(4);
                            }
                        } else {
                            obj = new StringBuilder("syntax error : ");
                            obj.append(type.b());
                            throw new JSONException(obj.toString());
                        }
                    }
                    throw new JSONException("syntax error");
                }
                type.d();
                return new Point(obj, i);
            } else if (type == Rectangle.class) {
                return c(aVar);
            } else {
                if (type == Color.class) {
                    return b(aVar);
                }
                if (type == Font.class) {
                    return a(aVar);
                }
                obj = new StringBuilder("not support awt class : ");
                obj.append(type);
                throw new JSONException(obj.toString());
            }
        } else {
            throw new JSONException("syntax error");
        }
    }

    private static Font a(com.alibaba.fastjson.parser.a aVar) {
        aVar = aVar.e;
        int i = 0;
        String str = null;
        int i2 = 0;
        while (aVar.a() != 13) {
            if (aVar.a() == 4) {
                String l = aVar.l();
                aVar.p();
                if (l.equalsIgnoreCase(c.e)) {
                    if (aVar.a() == 4) {
                        str = aVar.l();
                        aVar.d();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (l.equalsIgnoreCase("style")) {
                    if (aVar.a() == 2) {
                        i = aVar.n();
                        aVar.d();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (!l.equalsIgnoreCase("size")) {
                    StringBuilder stringBuilder = new StringBuilder("syntax error, ");
                    stringBuilder.append(l);
                    throw new JSONException(stringBuilder.toString());
                } else if (aVar.a() == 2) {
                    i2 = aVar.n();
                    aVar.d();
                } else {
                    throw new JSONException("syntax error");
                }
                if (aVar.a() == 16) {
                    aVar.a(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        aVar.d();
        return new Font(str, i, i2);
    }

    private static Color b(com.alibaba.fastjson.parser.a aVar) {
        aVar = aVar.e;
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (aVar.a() != 13) {
            if (aVar.a() == 4) {
                String l = aVar.l();
                aVar.p();
                if (aVar.a() == 2) {
                    int n = aVar.n();
                    aVar.d();
                    if (l.equalsIgnoreCase("r")) {
                        i = n;
                    } else if (l.equalsIgnoreCase("g")) {
                        i2 = n;
                    } else if (l.equalsIgnoreCase(b.a)) {
                        i3 = n;
                    } else if (l.equalsIgnoreCase("alpha")) {
                        i4 = n;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("syntax error, ");
                        stringBuilder.append(l);
                        throw new JSONException(stringBuilder.toString());
                    }
                    if (aVar.a() == 16) {
                        aVar.a(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            throw new JSONException("syntax error");
        }
        aVar.d();
        return new Color(i, i2, i3, i4);
    }

    private static Rectangle c(com.alibaba.fastjson.parser.a aVar) {
        aVar = aVar.e;
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (aVar.a() != 13) {
            if (aVar.a() == 4) {
                String l = aVar.l();
                aVar.p();
                if (aVar.a() == 2) {
                    int n = aVar.n();
                    aVar.d();
                    if (l.equalsIgnoreCase("x")) {
                        i = n;
                    } else if (l.equalsIgnoreCase("y")) {
                        i2 = n;
                    } else if (l.equalsIgnoreCase(SocializeProtocolConstants.WIDTH)) {
                        i3 = n;
                    } else if (l.equalsIgnoreCase(SocializeProtocolConstants.HEIGHT)) {
                        i4 = n;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("syntax error, ");
                        stringBuilder.append(l);
                        throw new JSONException(stringBuilder.toString());
                    }
                    if (aVar.a() == 16) {
                        aVar.a(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            }
            throw new JSONException("syntax error");
        }
        aVar.d();
        return new Rectangle(i, i2, i3, i4);
    }
}
