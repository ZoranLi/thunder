package com.alibaba.mtl.log.e;

/* compiled from: ReflectUtils */
public final class o {
    private static Object a(Class cls, String str) {
        try {
            cls = cls.getDeclaredMethod(str, new Class[0]);
            cls.setAccessible(true);
            return cls.invoke(null, new Object[0]);
        } catch (Class cls2) {
            cls2.printStackTrace();
            return null;
        } catch (Class cls22) {
            cls22.printStackTrace();
            return null;
        } catch (Class cls222) {
            cls222.printStackTrace();
            return null;
        } catch (Class cls2222) {
            cls2222.printStackTrace();
            return null;
        } catch (Class cls22222) {
            cls22222.printStackTrace();
            return null;
        }
    }

    public static Object a(Object obj, String str, Object[] objArr, Class... clsArr) {
        try {
            str = obj.getClass().getDeclaredMethod(str, clsArr);
            str.setAccessible(1);
            return str.invoke(obj, objArr);
        } catch (Object obj2) {
            obj2.printStackTrace();
            return null;
        } catch (Object obj22) {
            obj22.printStackTrace();
            return null;
        } catch (Object obj222) {
            obj222.printStackTrace();
            return null;
        } catch (Object obj2222) {
            obj2222.printStackTrace();
            return null;
        } catch (Object obj22222) {
            obj22222.printStackTrace();
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        try {
            str = obj.getClass().getDeclaredMethod(str, new Class[0]);
            str.setAccessible(true);
            return str.invoke(obj, new Object[0]);
        } catch (Object obj2) {
            obj2.printStackTrace();
            return null;
        } catch (Object obj22) {
            obj22.printStackTrace();
            return null;
        } catch (Object obj222) {
            obj222.printStackTrace();
            return null;
        } catch (Object obj2222) {
            obj2222.printStackTrace();
            return null;
        } catch (Object obj22222) {
            obj22222.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object a(java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x000d }
        if (r1 == 0) goto L_0x000c;
    L_0x0007:
        r1 = a(r1, r2);
        return r1;
    L_0x000c:
        return r0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.o.a(java.lang.String, java.lang.String):java.lang.Object");
    }
}
