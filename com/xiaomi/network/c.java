package com.xiaomi.network;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class c implements Comparable<c> {
    String a;
    protected int b;
    private final LinkedList<AccessHistory> c;
    private long d;

    public c() {
        this(null, 0);
    }

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        this.c = new LinkedList();
        this.d = 0;
        this.a = str;
        this.b = i;
    }

    public int a(c cVar) {
        return cVar == null ? 1 : cVar.b - this.b;
    }

    public synchronized c a(JSONObject jSONObject) {
        this.d = jSONObject.getLong("tt");
        this.b = jSONObject.getInt("wt");
        this.a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.c.add(new AccessHistory().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.d);
        jSONObject.put("wt", this.b);
        jSONObject.put("host", this.a);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(((AccessHistory) it.next()).b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    protected synchronized void a(AccessHistory accessHistory) {
        if (accessHistory != null) {
            this.c.add(accessHistory);
            int a = accessHistory.a();
            if (a > 0) {
                this.b += accessHistory.a();
            } else {
                int i = 0;
                int size = this.c.size() - 1;
                while (size >= 0 && ((AccessHistory) this.c.get(size)).a() < 0) {
                    i++;
                    size--;
                }
                this.b += a * i;
            }
            if (this.c.size() > 30) {
                this.b -= ((AccessHistory) this.c.remove()).a();
            }
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((c) obj);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
