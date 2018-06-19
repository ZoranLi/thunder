package com.tencent.bugly.proguard;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: BUGLY */
public class a {
    public static String a(ArrayList<String> arrayList) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, a((String) arrayList.get(i)));
        }
        Collections.reverse(arrayList);
        for (i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if (str.equals("list")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            } else if (str.equals("map")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            } else if (str.equals("Array")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            }
        }
        Collections.reverse(arrayList);
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            stringBuffer.append((String) arrayList.next());
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (!str.equals("java.lang.Integer")) {
            if (!str.equals("int")) {
                if (!str.equals("java.lang.Boolean")) {
                    if (!str.equals("boolean")) {
                        if (!str.equals("java.lang.Byte")) {
                            if (!str.equals("byte")) {
                                if (!str.equals("java.lang.Double")) {
                                    if (!str.equals("double")) {
                                        if (!str.equals("java.lang.Float")) {
                                            if (!str.equals("float")) {
                                                if (!str.equals("java.lang.Long")) {
                                                    if (!str.equals("long")) {
                                                        if (!str.equals("java.lang.Short")) {
                                                            if (!str.equals("short")) {
                                                                if (str.equals("java.lang.Character")) {
                                                                    throw new IllegalArgumentException("can not support java.lang.Character");
                                                                } else if (str.equals("java.lang.String")) {
                                                                    return "string";
                                                                } else {
                                                                    if (str.equals("java.util.List")) {
                                                                        return "list";
                                                                    }
                                                                    return str.equals("java.util.Map") ? "map" : str;
                                                                }
                                                            }
                                                        }
                                                        return "short";
                                                    }
                                                }
                                                return "int64";
                                            }
                                        }
                                        return "float";
                                    }
                                }
                                return "double";
                            }
                        }
                        return "char";
                    }
                }
                return "bool";
            }
        }
        return "int32";
    }
}
