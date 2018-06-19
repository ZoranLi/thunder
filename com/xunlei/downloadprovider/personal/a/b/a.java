package com.xunlei.downloadprovider.personal.a.b;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.a.b.b.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONArray;

/* compiled from: UserGridDataManager */
public class a {
    public static String a = d;
    public static String b = "http://xlkf.xunlei.com/cxfz/chatClient/chatbox.jsp?companyID=8950&configID=21&enterurl=m.help.xunlei.com&policyId=10&live800_domain=m.help.xunlei.com&live800_robot_ud_Android=Android";
    private static final String c = "a";
    private static final String d;
    private static final String e;
    private static a k;
    private List<String> f = Arrays.asList(new String[]{"积分中心", "我的礼包", "直播福利", "帮助反馈"});
    private List<String> g = Arrays.asList(new String[]{"score_center", "my_gift", "live_welfare", "help_feedback"});
    private List<Integer> h = Arrays.asList(new Integer[]{Integer.valueOf(R.drawable.ic_user_center_score), Integer.valueOf(R.drawable.ic_user_center_gift), Integer.valueOf(R.drawable.ic_user_live_welfare), Integer.valueOf(R.drawable.ic_user_center_help)});
    private List<String> i = Arrays.asList(new String[]{e, "", "", b});
    private ArrayList<h> j = new ArrayList();
    private Executor l = Executors.newSingleThreadExecutor();

    static {
        StringBuilder stringBuilder = new StringBuilder("http://m.sjzhushou.com/h5/client/page/dist/?t=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("#/sign?clint=android");
        String stringBuilder2 = stringBuilder.toString();
        d = stringBuilder2;
        e = stringBuilder2;
    }

    private a() {
        d();
    }

    public static a a() {
        if (k == null) {
            synchronized (a.class) {
                if (k == null) {
                    k = new a();
                }
            }
        }
        return k;
    }

    private void d() {
        for (int i = 0; i < this.f.size(); i++) {
            h hVar = new h();
            String str = (String) this.g.get(i);
            hVar.c = str;
            hVar.d = (String) this.f.get(i);
            hVar.j = ((Integer) this.h.get(i)).intValue();
            hVar.g = (String) this.i.get(i);
            if ("score_center".equals(str)) {
                hVar.b = 2;
            } else if ("dl_center".equals(str)) {
                hVar.b = 3;
            } else {
                hVar.b = 1;
            }
            this.j.add(hVar);
        }
    }

    public final ArrayList<h> b() {
        int size = 3 - (this.j.size() % 3);
        if (!(size == 0 || size % 3 == 0)) {
            for (int i = 0; i < size; i++) {
                this.j.add(new h());
            }
        }
        return this.j;
    }

    static /* synthetic */ void a(a aVar, JSONArray jSONArray) {
        jSONArray = h.a(jSONArray);
        aVar.j = (ArrayList) jSONArray;
        new StringBuilder("handleRequestSuccess = ").append(aVar.j.toString());
        aVar.l.execute(new f(aVar, new ArrayList(jSONArray)));
    }

    static /* synthetic */ void a(a aVar) {
        List arrayList = new ArrayList();
        for (b bVar : com.xunlei.downloadprovider.personal.a.b.b.a.a()) {
            h hVar = new h();
            hVar.b = bVar.b.intValue();
            hVar.c = bVar.c;
            hVar.d = bVar.d;
            hVar.e = bVar.e;
            hVar.f = bVar.f;
            hVar.g = bVar.g;
            hVar.h = bVar.h;
            hVar.i = bVar.i;
            hVar.j = bVar.j.intValue();
            hVar.k = bVar.k.intValue();
            hVar.l = bVar.l;
            hVar.m = bVar.m;
            arrayList.add(hVar);
        }
        new StringBuilder("handleRequestError gridListDataFromDb = ").append(arrayList.size());
        if (arrayList.size() != 0) {
            aVar.j.clear();
            aVar.j = (ArrayList) arrayList;
            new StringBuilder("handleRequestError mList = ").append(aVar.j.size());
        }
    }
}
