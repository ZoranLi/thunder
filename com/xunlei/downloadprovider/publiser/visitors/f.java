package com.xunlei.downloadprovider.publiser.visitors;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import com.xunlei.downloadprovider.publiser.visitors.model.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VisitActivity */
final class f implements e$e<List<b>, Integer, Long> {
    final /* synthetic */ VisitActivity a;

    f(VisitActivity visitActivity) {
        this.a = visitActivity;
    }

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3) {
        List<b> list = (List) obj;
        Integer num = (Integer) obj2;
        Long l = (Long) obj3;
        g b = this.a.f;
        int i = 1;
        if (list != null) {
            if (list.size() != 0) {
                b.a.size();
                Collection arrayList = new ArrayList();
                for (b fVar : list) {
                    arrayList.add(new com.xunlei.downloadprovider.publiser.visitors.view.f(1, fVar));
                }
                b.a.addAll(arrayList);
                b.notifyDataSetChanged();
            }
        }
        if (LoginHelper.a().g.c() != this.a.c) {
            i = 0;
        }
        obj = com.xunlei.downloadprovider.homepage.follow.b.a().b(this.a.c);
        LoginHelper.a();
        if (l.c()) {
            if (obj != null) {
                StringBuilder stringBuilder;
                if (i != 0) {
                    if (num.intValue() < 10 || this.a.f.getItemCount() >= 500) {
                        this.a.e.setLoadingMoreEnabled(false);
                        if (this.a.f.getItemCount() < this.a.j) {
                            if (this.a.j >= 500) {
                                this.a.f.a("仅展示最新的500条访问记录");
                            } else if (this.a.f.getItemCount() == null) {
                                obj = this.a.j - this.a.f.getItemCount();
                                obj2 = this.a.f;
                                stringBuilder = new StringBuilder("有");
                                stringBuilder.append(obj);
                                stringBuilder.append("个游客访问了你");
                                obj2.a(stringBuilder.toString());
                            } else {
                                obj = this.a.j - this.a.f.getItemCount();
                                obj2 = this.a.f;
                                stringBuilder = new StringBuilder("还有");
                                stringBuilder.append(obj);
                                stringBuilder.append("个游客访问了你");
                                obj2.a(stringBuilder.toString());
                            }
                        }
                    }
                } else if (num.intValue() < 10 || this.a.f.getItemCount() >= 100) {
                    this.a.e.setLoadingMoreEnabled(false);
                    if (this.a.f.getItemCount() < this.a.j) {
                        if (this.a.j >= 100) {
                            this.a.f.a("仅展示最新的100条访问记录");
                        } else if (this.a.f.getItemCount() == null) {
                            obj = this.a.j - this.a.f.getItemCount();
                            obj2 = this.a.f;
                            stringBuilder = new StringBuilder("有");
                            stringBuilder.append(obj);
                            stringBuilder.append("个游客访问");
                            obj2.a(stringBuilder.toString());
                        } else {
                            obj = this.a.j - this.a.f.getItemCount();
                            obj2 = this.a.f;
                            stringBuilder = new StringBuilder("还有");
                            stringBuilder.append(obj);
                            stringBuilder.append("个游客访问");
                            obj2.a(stringBuilder.toString());
                        }
                    }
                }
                this.a.k = l;
                this.a.i.setVisibility(8);
                this.a.e.a();
            }
        }
        if (this.a.f.getItemCount() >= 10) {
            obj = this.a.f;
            obj.a.add(new com.xunlei.downloadprovider.publiser.visitors.view.f((byte) 0));
            obj.notifyItemInserted(obj.a.size());
        } else if (this.a.f.getItemCount() < this.a.j) {
            StringBuilder stringBuilder2;
            if (this.a.f.getItemCount() == null) {
                obj = this.a.j - this.a.f.getItemCount();
                obj2 = this.a.f;
                stringBuilder2 = new StringBuilder("有");
                stringBuilder2.append(obj);
                stringBuilder2.append("个游客访问了TA");
                obj2.a(stringBuilder2.toString());
            } else {
                obj = this.a.j - this.a.f.getItemCount();
                obj2 = this.a.f;
                stringBuilder2 = new StringBuilder("还有");
                stringBuilder2.append(obj);
                stringBuilder2.append("个游客访问了TA");
                obj2.a(stringBuilder2.toString());
            }
        }
        this.a.e.setLoadingMoreEnabled(false);
        this.a.k = l;
        this.a.i.setVisibility(8);
        this.a.e.a();
    }

    public final void a() {
        this.a.i.setVisibility(8);
        this.a.e.a();
        if (this.a.k.longValue() == 0) {
            this.a.h.setVisibility(0);
        }
    }
}
