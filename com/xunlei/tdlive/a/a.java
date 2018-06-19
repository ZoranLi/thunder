package com.xunlei.tdlive.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.SocialConstants;
import com.xunlei.tdlive.a.a.b;
import com.xunlei.tdlive.a.a.c;
import com.xunlei.tdlive.a.a.d;
import com.xunlei.tdlive.a.a.f;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.XLLiveGetCategoryRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.sdk.R;

/* compiled from: CategoryAdapter */
public class a extends b<String, a> {

    /* compiled from: CategoryAdapter */
    static class a extends f {
        ImageView a = ((ImageView) a((int) R.id.category_avatar));
        TextView b = ((TextView) a((int) R.id.category_name));

        public a(View view, c cVar, d dVar) {
            super(view, cVar, dVar);
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a((a) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public void a(String str, boolean z, boolean z2) {
        a();
        new XLLiveGetCategoryRequest().send((JsonCallBack) new JsonCallBack(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                if (i == 0) {
                    this.a.a((JsonWrapper) jsonWrapper.getArray("data", "[]"));
                }
                this.a.b();
            }
        });
    }

    public a a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xllive_category_item, viewGroup, false), this.a, this.b);
    }

    public void a(a aVar, int i) {
        i = a(i);
        if (i != 0) {
            com.xunlei.tdlive.util.b.a(aVar.itemView.getContext()).a(aVar.a, i.getString(SocialConstants.PARAM_IMG_URL, ""));
            aVar.b.setText(i.getString(com.alipay.sdk.cons.c.e, ""));
        }
    }
}
