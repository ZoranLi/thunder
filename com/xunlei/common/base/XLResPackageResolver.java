package com.xunlei.common.base;

import android.content.Context;

public class XLResPackageResolver {
    public static int getIdByName(Context context, String str, String str2) {
        context = context.getPackageName();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context);
            stringBuilder.append(".R");
            context = Class.forName(stringBuilder.toString()).getClasses();
            Class cls = null;
            for (int i = 0; i < context.length; i++) {
                if (context[i].getName().split("\\$")[1].equals(str)) {
                    cls = context[i];
                    break;
                }
            }
            if (cls != null) {
                return cls.getField(str2).getInt(cls);
            }
            return 0;
        } catch (Context context2) {
            context2.printStackTrace();
            return 0;
        } catch (Context context22) {
            context22.printStackTrace();
            return 0;
        } catch (Context context222) {
            context222.printStackTrace();
            return 0;
        } catch (Context context2222) {
            context2222.printStackTrace();
            return 0;
        } catch (Context context22222) {
            context22222.printStackTrace();
            return 0;
        }
    }
}
