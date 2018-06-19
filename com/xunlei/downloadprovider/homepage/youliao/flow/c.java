package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.youliao.data.YouliaoVideo;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: VideoFlowAdapter */
public final class c extends Adapter<b> {
    public final ArrayList<a> a = new ArrayList();
    a b;
    public boolean c = false;
    public HashMap<String, Boolean> d = new HashMap();
    public int e;
    public long f;
    private LinkedList<YouliaoVideo> g = new LinkedList();
    private XRecyclerView h;

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) this.a.get(i);
        ((b) viewHolder).a((a) this.a.get(i), i);
        aVar.a().setPosition(i);
        YouliaoVideo a = aVar.a();
        if (!(a == null || this.e == 2 || this.c == 0)) {
            if (System.currentTimeMillis() - this.f > 1000) {
                a(a);
            } else if (this.d.containsKey(a.getGcid()) == 0) {
                a(a);
            }
        }
    }

    public final /* synthetic */ void onViewAttachedToWindow(ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        super.onViewAttachedToWindow(bVar);
        bVar.a();
    }

    public final /* synthetic */ void onViewDetachedFromWindow(ViewHolder viewHolder) {
        b bVar = (b) viewHolder;
        super.onViewDetachedFromWindow(bVar);
        bVar.b();
    }

    public c(a aVar) {
        this.b = aVar;
        setHasStableIds(true);
    }

    public final int getItemViewType(int i) {
        return ((a) this.a.get(i)).a;
    }

    public final long getItemId(int i) {
        if (this.a.get(i) == null) {
            return super.getItemId(i);
        }
        a aVar = (a) this.a.get(i);
        long j = aVar.b;
        if (j != -1) {
            if (j <= 2147483647L) {
                return (((long) aVar.a) << 32) | (j & 2147483647L);
            }
        }
        return -1;
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.h = (XRecyclerView) recyclerView;
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.h = null;
    }

    public final void a(List<a> list) {
        if (!d.a(list)) {
            this.a.addAll(0, list);
        }
        this.f = System.currentTimeMillis();
        notifyDataSetChanged();
    }

    public final void a(List<a> list, boolean z) {
        try {
            if (this.h.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.h.getLayoutManager();
                int[] iArr = new int[2];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                int max = Math.max(iArr[0], iArr[1]) - this.h.getHeaderViewsCount();
                int[] iArr2 = new int[2];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr2);
                int min = Math.min(iArr2[0], iArr2[1]) - this.h.getHeaderViewsCount();
                int i;
                if (list == null) {
                    i = 0;
                } else {
                    i = list.size();
                }
                while (min <= max) {
                    if (min >= 0 && min < r1) {
                        YouliaoVideo youliaoVideo = null;
                        int size = list == null ? 0 : list.size();
                        if (size > 0 && min >= 0 && min < size) {
                            a aVar = (a) list.get(min);
                            if (aVar != null) {
                                youliaoVideo = aVar.a();
                            }
                        }
                        if (!z || youliaoVideo == null || !this.d.containsKey(youliaoVideo.getGcid())) {
                            a(youliaoVideo);
                        }
                    }
                    min++;
                }
            }
        } catch (List<a> list2) {
            list2.printStackTrace();
        }
    }

    private void a(YouliaoVideo youliaoVideo) {
        if (youliaoVideo != null) {
            StringBuilder stringBuilder = new StringBuilder("video expo --> movieId = ");
            stringBuilder.append(youliaoVideo.getVideoId());
            stringBuilder.append(" gcid = ");
            stringBuilder.append(youliaoVideo.getGcid());
            stringBuilder.append(" title = ");
            stringBuilder.append(youliaoVideo.getTitle());
            this.g.add(youliaoVideo);
            this.d.put(youliaoVideo.getGcid(), Boolean.valueOf(true));
            a((boolean) null);
        }
    }

    public final void a(boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.g;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        if (r9 != 0) goto L_0x0015;
    L_0x000b:
        r9 = r8.g;
        r9 = r9.size();
        r0 = 8;
        if (r9 < r0) goto L_0x00f1;
    L_0x0015:
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = new org.json.JSONArray;
        r0.<init>();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 0;
    L_0x0025:
        r3 = r8.g;
        r3 = r3.size();
        if (r2 >= r3) goto L_0x00ba;
    L_0x002d:
        r3 = r8.g;
        r3 = r3.get(r2);
        r3 = (com.xunlei.downloadprovider.homepage.youliao.data.YouliaoVideo) r3;
        r4 = r3.getVideoId();	 Catch:{ JSONException -> 0x00b6 }
        r9.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b6 }
        r4.<init>();	 Catch:{ JSONException -> 0x00b6 }
        r5 = "movieid";	 Catch:{ JSONException -> 0x00b6 }
        r6 = r3.getVideoId();	 Catch:{ JSONException -> 0x00b6 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x00b6 }
        r5 = "params";	 Catch:{ JSONException -> 0x00b6 }
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00b6 }
        r7 = r3.getServerParams();	 Catch:{ JSONException -> 0x00b6 }
        r6.<init>(r7);	 Catch:{ JSONException -> 0x00b6 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x00b6 }
        r4 = r4.toString();	 Catch:{ JSONException -> 0x00b6 }
        r4 = android.net.Uri.encode(r4);	 Catch:{ JSONException -> 0x00b6 }
        r0.put(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = "id=";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = r3.getVideoId();	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = ",sessionid=";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = com.xunlei.downloadprovider.homepage.youliao.data.i.b;	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = ",rn=";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = r3.getPosition();	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r4 = r3.isGif();	 Catch:{ JSONException -> 0x00b6 }
        if (r4 == 0) goto L_0x0091;	 Catch:{ JSONException -> 0x00b6 }
    L_0x008b:
        r4 = ",gif=yes";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        goto L_0x0096;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0091:
        r4 = ",gif=no";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
    L_0x0096:
        r4 = ",tag=";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r4);	 Catch:{ JSONException -> 0x00b6 }
        r3 = r3.getRecommendTag();	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r3);	 Catch:{ JSONException -> 0x00b6 }
        r3 = r8.g;	 Catch:{ JSONException -> 0x00b6 }
        r3 = r3.size();	 Catch:{ JSONException -> 0x00b6 }
        r3 = r3 + -1;	 Catch:{ JSONException -> 0x00b6 }
        if (r2 == r3) goto L_0x00b6;	 Catch:{ JSONException -> 0x00b6 }
    L_0x00ac:
        r3 = "_";	 Catch:{ JSONException -> 0x00b6 }
        r9.append(r3);	 Catch:{ JSONException -> 0x00b6 }
        r3 = ";";	 Catch:{ JSONException -> 0x00b6 }
        r1.append(r3);	 Catch:{ JSONException -> 0x00b6 }
    L_0x00b6:
        r2 = r2 + 1;
        goto L_0x0025;
    L_0x00ba:
        r9 = r9.toString();
        r0 = r0.toString();
        r1 = r1.toString();
        r2 = "UTF-8";
        r1 = com.xunlei.xllib.b.k.a(r1, r2);
        r2 = android.text.TextUtils.isEmpty(r9);
        if (r2 != 0) goto L_0x00ec;
    L_0x00d2:
        r2 = "android_youliao";
        r3 = "youliao_content_show";
        r2 = com.xunlei.common.report.HubbleEventBuilder.build(r2, r3);
        r3 = "movie_list";
        r2.addString(r3, r9);
        r9 = "rec_params";
        r2.addString(r9, r0);
        r9 = "contentlist";
        r2.addString(r9, r1);
        com.xunlei.common.report.ThunderReport.reportEvent(r2);
    L_0x00ec:
        r9 = r8.g;
        r9.clear();
    L_0x00f1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.youliao.flow.c.a(boolean):void");
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return 1 == i ? g.a((View) viewGroup, this.b) : null;
    }
}
