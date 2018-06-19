package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.util.List;
import org.json.JSONStringer;

public class AddCardToWXCardPackage {
    private static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;
    }

    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean checkArgs() {
            /*
            r5 = this;
            r0 = r5.cardArrary;
            r1 = 0;
            if (r0 == 0) goto L_0x0049;
        L_0x0005:
            r0 = r5.cardArrary;
            r0 = r0.size();
            if (r0 == 0) goto L_0x0049;
        L_0x000d:
            r0 = r5.cardArrary;
            r0 = r0.size();
            r2 = 40;
            if (r0 <= r2) goto L_0x0018;
        L_0x0017:
            return r1;
        L_0x0018:
            r0 = r5.cardArrary;
            r0 = r0.iterator();
        L_0x001e:
            r2 = r0.hasNext();
            if (r2 == 0) goto L_0x0047;
        L_0x0024:
            r2 = r0.next();
            r2 = (com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.WXCardItem) r2;
            if (r2 == 0) goto L_0x0046;
        L_0x002c:
            r3 = r2.cardId;
            if (r3 == 0) goto L_0x0046;
        L_0x0030:
            r3 = r2.cardId;
            r3 = r3.length();
            r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r3 > r4) goto L_0x0046;
        L_0x003a:
            r3 = r2.cardExtMsg;
            if (r3 == 0) goto L_0x001e;
        L_0x003e:
            r2 = r2.cardExtMsg;
            r2 = r2.length();
            if (r2 <= r4) goto L_0x001e;
        L_0x0046:
            return r1;
        L_0x0047:
            r0 = 1;
            return r0;
        L_0x0049:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Req.checkArgs():boolean");
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                new StringBuilder("Req.toBundle exception:").append(e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            if (this.cardArrary != null) {
                if (this.cardArrary.size() != 0) {
                    return true;
                }
            }
            return false;
        }

        public void fromBundle(android.os.Bundle r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            super.fromBundle(r5);
            r0 = r4.cardArrary;
            if (r0 != 0) goto L_0x000e;
        L_0x0007:
            r0 = new java.util.LinkedList;
            r0.<init>();
            r4.cardArrary = r0;
        L_0x000e:
            r0 = "_wxapi_add_card_to_wx_card_list";
            r5 = r5.getString(r0);
            if (r5 == 0) goto L_0x005d;
        L_0x0016:
            r0 = r5.length();
            if (r0 <= 0) goto L_0x005d;
        L_0x001c:
            r0 = new org.json.JSONTokener;	 Catch:{ Exception -> 0x005d }
            r0.<init>(r5);	 Catch:{ Exception -> 0x005d }
            r5 = r0.nextValue();	 Catch:{ Exception -> 0x005d }
            r5 = (org.json.JSONObject) r5;	 Catch:{ Exception -> 0x005d }
            r0 = "card_list";	 Catch:{ Exception -> 0x005d }
            r5 = r5.getJSONArray(r0);	 Catch:{ Exception -> 0x005d }
            r0 = 0;	 Catch:{ Exception -> 0x005d }
        L_0x002e:
            r1 = r5.length();	 Catch:{ Exception -> 0x005d }
            if (r0 >= r1) goto L_0x005d;	 Catch:{ Exception -> 0x005d }
        L_0x0034:
            r1 = r5.getJSONObject(r0);	 Catch:{ Exception -> 0x005d }
            r2 = new com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$WXCardItem;	 Catch:{ Exception -> 0x005d }
            r2.<init>();	 Catch:{ Exception -> 0x005d }
            r3 = "card_id";	 Catch:{ Exception -> 0x005d }
            r3 = r1.optString(r3);	 Catch:{ Exception -> 0x005d }
            r2.cardId = r3;	 Catch:{ Exception -> 0x005d }
            r3 = "card_ext";	 Catch:{ Exception -> 0x005d }
            r3 = r1.optString(r3);	 Catch:{ Exception -> 0x005d }
            r2.cardExtMsg = r3;	 Catch:{ Exception -> 0x005d }
            r3 = "is_succ";	 Catch:{ Exception -> 0x005d }
            r1 = r1.optInt(r3);	 Catch:{ Exception -> 0x005d }
            r2.cardState = r1;	 Catch:{ Exception -> 0x005d }
            r1 = r4.cardArrary;	 Catch:{ Exception -> 0x005d }
            r1.add(r2);	 Catch:{ Exception -> 0x005d }
            r0 = r0 + 1;
            goto L_0x002e;
        L_0x005d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp.fromBundle(android.os.Bundle):void");
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.key("is_succ");
                    jSONStringer.value((long) wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                new StringBuilder("Resp.toBundle exception:").append(e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }
}
