package com.airbnb.lottie.model.layer;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.widget.AutoScrollHelper;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.i;
import com.airbnb.lottie.model.a.j;
import com.airbnb.lottie.model.a.k;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.a.n;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.content.b;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class Layer {
    private static final String v = "Layer";
    final List<b> a;
    final i b;
    final String c;
    public final long d;
    public final LayerType e;
    final long f;
    @Nullable
    final String g;
    final List<Mask> h;
    final l i;
    final int j;
    final int k;
    final int l;
    final float m;
    final float n;
    final int o;
    final int p;
    @Nullable
    final j q;
    @Nullable
    final k r;
    @Nullable
    final com.airbnb.lottie.model.a.b s;
    final List<com.airbnb.lottie.a.a<Float>> t;
    final MatteType u;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public static class a {
        public static Layer a(JSONObject jSONObject, i iVar) {
            LayerType layerType;
            int optInt;
            int optInt2;
            int parseColor;
            JSONObject optJSONObject;
            int hashCode;
            j jVar;
            k kVar;
            int optInt3;
            int optInt4;
            com.airbnb.lottie.a.a aVar;
            Float f;
            float f2;
            com.airbnb.lottie.model.a.b bVar;
            Float f3;
            float f4;
            String str;
            float f5;
            List list;
            List list2;
            float f6;
            float f7;
            JSONObject jSONObject2 = jSONObject;
            i iVar2 = iVar;
            String optString = jSONObject2.optString("nm");
            String optString2 = jSONObject2.optString("refId");
            if (optString.endsWith(".ai") || jSONObject2.optString("cl", "").equals("ai")) {
                iVar2.a("Convert your Illustrator layers to shape layers.");
            }
            long optLong = jSONObject2.optLong("ind");
            int optInt5 = jSONObject2.optInt(com.alipay.sdk.sys.a.g, -1);
            if (optInt5 < LayerType.Unknown.ordinal()) {
                layerType = LayerType.values()[optInt5];
            } else {
                layerType = LayerType.Unknown;
            }
            if (layerType == LayerType.Text && !g.a(iVar2, 8)) {
                layerType = LayerType.Unknown;
                iVar2.a("Text is only supported on bodymovin >= 4.8.0");
            }
            LayerType layerType2 = layerType;
            long optLong2 = jSONObject2.optLong("parent", -1);
            if (layerType2 == LayerType.Solid) {
                optInt = (int) (((float) jSONObject2.optInt(IXAdRequestInfo.SCREEN_WIDTH)) * iVar2.k);
                optInt2 = (int) (((float) jSONObject2.optInt(IXAdRequestInfo.SCREEN_HEIGHT)) * iVar2.k);
                parseColor = Color.parseColor(jSONObject2.optString("sc"));
            } else {
                optInt = 0;
                optInt2 = 0;
                parseColor = 0;
            }
            l a = com.airbnb.lottie.model.a.l.a.a(jSONObject2.optJSONObject("ks"), iVar2);
            MatteType matteType = MatteType.values()[jSONObject2.optInt("tt")];
            List arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject2.optJSONArray("masksProperties");
            if (optJSONArray != null) {
                int i = 0;
                while (i < optJSONArray.length()) {
                    Object obj;
                    MaskMode maskMode;
                    JSONArray jSONArray;
                    optJSONObject = optJSONArray.optJSONObject(i);
                    String optString3 = optJSONObject.optString(Constants.KEY_MODE);
                    hashCode = optString3.hashCode();
                    if (hashCode != 97) {
                        if (hashCode != 105) {
                            if (hashCode == 115) {
                                if (optString3.equals("s")) {
                                    obj = 1;
                                    switch (obj) {
                                        case null:
                                            maskMode = MaskMode.MaskModeAdd;
                                            break;
                                        case 1:
                                            maskMode = MaskMode.MaskModeSubtract;
                                            break;
                                        case 2:
                                            maskMode = MaskMode.MaskModeIntersect;
                                            break;
                                        default:
                                            maskMode = MaskMode.MaskModeUnknown;
                                            break;
                                    }
                                    jSONArray = optJSONArray;
                                    arrayList.add(new Mask(maskMode, com.airbnb.lottie.model.a.h.a.a(optJSONObject.optJSONObject("pt"), iVar2), com.airbnb.lottie.model.a.d.a.a(optJSONObject.optJSONObject("o"), iVar2)));
                                    i++;
                                    optJSONArray = jSONArray;
                                }
                            }
                        } else if (optString3.equals("i")) {
                            obj = 2;
                            switch (obj) {
                                case null:
                                    maskMode = MaskMode.MaskModeAdd;
                                    break;
                                case 1:
                                    maskMode = MaskMode.MaskModeSubtract;
                                    break;
                                case 2:
                                    maskMode = MaskMode.MaskModeIntersect;
                                    break;
                                default:
                                    maskMode = MaskMode.MaskModeUnknown;
                                    break;
                            }
                            jSONArray = optJSONArray;
                            arrayList.add(new Mask(maskMode, com.airbnb.lottie.model.a.h.a.a(optJSONObject.optJSONObject("pt"), iVar2), com.airbnb.lottie.model.a.d.a.a(optJSONObject.optJSONObject("o"), iVar2)));
                            i++;
                            optJSONArray = jSONArray;
                        }
                    } else if (optString3.equals("a")) {
                        obj = null;
                        switch (obj) {
                            case null:
                                maskMode = MaskMode.MaskModeAdd;
                                break;
                            case 1:
                                maskMode = MaskMode.MaskModeSubtract;
                                break;
                            case 2:
                                maskMode = MaskMode.MaskModeIntersect;
                                break;
                            default:
                                maskMode = MaskMode.MaskModeUnknown;
                                break;
                        }
                        jSONArray = optJSONArray;
                        arrayList.add(new Mask(maskMode, com.airbnb.lottie.model.a.h.a.a(optJSONObject.optJSONObject("pt"), iVar2), com.airbnb.lottie.model.a.d.a.a(optJSONObject.optJSONObject("o"), iVar2)));
                        i++;
                        optJSONArray = jSONArray;
                    }
                    obj = -1;
                    switch (obj) {
                        case null:
                            maskMode = MaskMode.MaskModeAdd;
                            break;
                        case 1:
                            maskMode = MaskMode.MaskModeSubtract;
                            break;
                        case 2:
                            maskMode = MaskMode.MaskModeIntersect;
                            break;
                        default:
                            maskMode = MaskMode.MaskModeUnknown;
                            break;
                    }
                    jSONArray = optJSONArray;
                    arrayList.add(new Mask(maskMode, com.airbnb.lottie.model.a.h.a.a(optJSONObject.optJSONObject("pt"), iVar2), com.airbnb.lottie.model.a.d.a.a(optJSONObject.optJSONObject("o"), iVar2)));
                    i++;
                    optJSONArray = jSONArray;
                }
            }
            List arrayList2 = new ArrayList();
            optJSONArray = jSONObject2.optJSONArray("shapes");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    b a2 = com.airbnb.lottie.model.content.j.a(optJSONArray.optJSONObject(i2), iVar2);
                    if (a2 != null) {
                        arrayList2.add(a2);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(DispatchConstants.TIMESTAMP);
            if (optJSONObject2 != null) {
                k kVar2;
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(d.a);
                if (optJSONObject3 != null && optJSONObject3.has("x")) {
                    iVar2.a("Lottie doesn't support expressions.");
                }
                a a3 = n.a(optJSONObject3, 1.0f, iVar2, a.a).a();
                j jVar2 = new j(a3.a, (com.airbnb.lottie.model.d) a3.b);
                optJSONObject2 = optJSONObject2.optJSONArray("a").optJSONObject(0);
                if (optJSONObject2 != null) {
                    if (optJSONObject2.has("a")) {
                        com.airbnb.lottie.model.a.b a4;
                        com.airbnb.lottie.model.a.b a5;
                        optJSONObject2 = optJSONObject2.optJSONObject("a");
                        optJSONObject3 = optJSONObject2.optJSONObject("fc");
                        com.airbnb.lottie.model.a.a a6 = optJSONObject3 != null ? com.airbnb.lottie.model.a.a.a.a(optJSONObject3, iVar2) : null;
                        optJSONObject = optJSONObject2.optJSONObject("sc");
                        com.airbnb.lottie.model.a.a a7 = optJSONObject != null ? com.airbnb.lottie.model.a.a.a.a(optJSONObject, iVar2) : null;
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject(IXAdRequestInfo.SCREEN_WIDTH);
                        if (optJSONObject4 != null) {
                            jVar = jVar2;
                            a4 = com.airbnb.lottie.model.a.b.a.a(optJSONObject4, iVar2, true);
                        } else {
                            jVar = jVar2;
                            a4 = null;
                        }
                        optJSONObject2 = optJSONObject2.optJSONObject(DispatchConstants.TIMESTAMP);
                        if (optJSONObject2 != null) {
                            a5 = com.airbnb.lottie.model.a.b.a.a(optJSONObject2, iVar2, true);
                        } else {
                            a5 = null;
                        }
                        kVar2 = new k(a6, a7, a4, a5);
                        kVar = kVar2;
                    }
                }
                jVar = jVar2;
                kVar2 = new k(null, null, null, null);
                kVar = kVar2;
            } else {
                kVar = null;
                jVar = kVar;
            }
            if (jSONObject2.has("ef")) {
                optJSONArray = jSONObject2.optJSONArray("ef");
                String[] strArr = new String[optJSONArray.length()];
                for (hashCode = 0; hashCode < optJSONArray.length(); hashCode++) {
                    strArr[hashCode] = optJSONArray.optJSONObject(hashCode).optString("nm");
                }
                StringBuilder stringBuilder = new StringBuilder("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
                stringBuilder.append(Arrays.toString(strArr));
                iVar2.a(stringBuilder.toString());
            }
            float optDouble = (float) jSONObject2.optDouble("sr", 1.0d);
            float optDouble2 = ((float) jSONObject2.optDouble(SocializeProtocolConstants.PROTOCOL_KEY_ST)) / iVar.b();
            if (layerType2 == LayerType.PreComp) {
                optInt3 = (int) (((float) jSONObject2.optInt(IXAdRequestInfo.WIDTH)) * iVar2.k);
                optInt4 = (int) (((float) jSONObject2.optInt(IXAdRequestInfo.HEIGHT)) * iVar2.k);
            } else {
                optInt3 = 0;
                optInt4 = 0;
            }
            float optLong3 = ((float) jSONObject2.optLong("ip")) / optDouble;
            float optLong4 = ((float) jSONObject2.optLong("op")) / optDouble;
            ArrayList arrayList3 = new ArrayList();
            if (optLong3 > 0.0f) {
                Float valueOf = Float.valueOf(0.0f);
                Float valueOf2 = Float.valueOf(0.0f);
                Float valueOf3 = Float.valueOf(optLong3);
                com.airbnb.lottie.a.a aVar2 = aVar;
                ArrayList arrayList4 = arrayList3;
                f = valueOf;
                f2 = optLong3;
                bVar = null;
                f3 = valueOf2;
                f4 = optDouble;
                str = optString2;
                f5 = 1.0f;
                list = arrayList;
                list2 = arrayList2;
                aVar = new com.airbnb.lottie.a.a(iVar2, f, f3, null, 0.0f, valueOf3);
                arrayList2 = arrayList4;
                arrayList2.add(aVar);
                f6 = 0.0f;
            } else {
                f2 = optLong3;
                f4 = optDouble;
                list = arrayList;
                list2 = arrayList2;
                str = optString2;
                f5 = 1.0f;
                bVar = null;
                arrayList2 = arrayList3;
                f6 = 0.0f;
            }
            if (optLong4 > f6) {
                f7 = optLong4;
            } else {
                f7 = (float) iVar2.j;
            }
            optDouble = f7 + f5;
            f = Float.valueOf(f5);
            i iVar3 = iVar2;
            long j = optLong2;
            com.airbnb.lottie.a.a aVar3 = aVar;
            f3 = Float.valueOf(f5);
            f5 = optDouble;
            float f8 = f6;
            List list3 = arrayList2;
            aVar = new com.airbnb.lottie.a.a(iVar3, f, f3, null, f2, Float.valueOf(optDouble));
            list3.add(aVar3);
            list3.add(new com.airbnb.lottie.a.a(iVar3, Float.valueOf(0.0f), Float.valueOf(0.0f), null, f5, Float.valueOf(AutoScrollHelper.NO_MAX)));
            if (jSONObject2.has(IXAdRequestInfo.MAX_TITLE_LENGTH)) {
                bVar = com.airbnb.lottie.model.a.b.a.a(jSONObject2.optJSONObject(IXAdRequestInfo.MAX_TITLE_LENGTH), iVar2, false);
            }
            return new Layer(list2, iVar2, optString, optLong, layerType2, j, str, list, a, optInt, optInt2, parseColor, f4, optDouble2, optInt3, optInt4, jVar, kVar, list3, matteType, bVar);
        }
    }

    private Layer(List<b> list, i iVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.a.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.a.b bVar) {
        this.a = list;
        this.b = iVar;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
    }

    public String toString() {
        return a("");
    }

    public final String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.c);
        stringBuilder.append("\n");
        Layer a = this.b.a(this.f);
        if (a != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(a.c);
            a = this.b.a(a.f);
            while (a != null) {
                stringBuilder.append("->");
                stringBuilder.append(a.c);
                a = this.b.a(a.f);
            }
            stringBuilder.append(str);
            stringBuilder.append("\n");
        }
        if (!this.h.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(this.h.size());
            stringBuilder.append("\n");
        }
        if (!(this.j == 0 || this.k == 0)) {
            stringBuilder.append(str);
            stringBuilder.append("\tBackground: ");
            stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l)}));
        }
        if (!this.a.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tShapes:\n");
            for (Object next : this.a) {
                stringBuilder.append(str);
                stringBuilder.append("\t\t");
                stringBuilder.append(next);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
