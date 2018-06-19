package com.xunlei.tdlive.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.protocol.XLLiveGetLiveListRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.b;
import com.xunlei.tdlive.util.b.c;
import com.xunlei.tdlive.util.d;

/* compiled from: SDKLiveListAdapter */
public class g extends b<String> implements OnScrollListener {
    protected int b = 20;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected boolean g = false;
    protected boolean h = false;
    protected String i;
    protected JsonWrapper j = new JsonWrapper("[]");
    protected String k = "0";

    /* compiled from: SDKLiveListAdapter */
    class a {
        View a;
        View b;
        TextView c;
        ImageView d;
        RoundImageView e;
        TextView f;
        TextView g;
        TextView h;
        TextView i;
        TextView j;
        ImageView k;
        int l;
        final /* synthetic */ g m;

        a(g gVar) {
            this.m = gVar;
        }
    }

    public g(String str, String str2, com.xunlei.tdlive.a.c.a aVar) {
        this.a = aVar;
        this.i = str2;
        this.k = str;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }

    public void a(String str) {
        a(false, str);
    }

    public void a(boolean z, String str) {
        this.h = z;
        super.a((Object) str);
    }

    public void a(String str, boolean z, boolean z2) {
        if (a()) {
            int i = 0;
            if (this.a != null) {
                this.a.a(str, false, z2);
            }
            int i2 = this.b;
            if (z2) {
                i = getCount();
            } else if (!z) {
                i = this.e * this.b;
            } else if (this.h) {
                i = this.b * this.e;
                i2 = getCount() > 0 ? 2 * this.b : this.b;
            }
            final int i3 = i;
            final boolean z3 = z;
            final boolean z4 = z2;
            final String str2 = str;
            new XLLiveGetLiveListRequest(this.i, i3, i2, this.k).send(new JsonCallBack(this) {
                final /* synthetic */ g e;

                public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                    this.e.c = jsonWrapper.getInt("grayid", 0);
                    if (i == 0) {
                        int i2;
                        JsonWrapper object;
                        str = jsonWrapper.getArray("data", "[]");
                        if (z3 != null) {
                            if (z4 == null) {
                                if (str.getLength() > null) {
                                    jsonWrapper = this.e.c();
                                    if (!this.e.h || jsonWrapper == null || jsonWrapper.getLength() <= 0) {
                                        this.e.a((JsonWrapper) str);
                                    } else {
                                        for (i2 = 0; i2 < str.getLength(); i2++) {
                                            String string;
                                            int i3;
                                            object = str.getObject(i2, "{}");
                                            if (object.getInt("item_type", 0) != 0) {
                                                if (object.getInt("item_type", 0) != 2) {
                                                    string = object.getString("channel_id", "");
                                                    for (i3 = 0; i3 < jsonWrapper.getLength(); i3++) {
                                                        if (string.equals(jsonWrapper.getObject(i3, "{}").getString("channel_id", ""))) {
                                                            jsonWrapper.remove(i3);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            string = object.getString("roomid", "");
                                            for (i3 = 0; i3 < jsonWrapper.getLength(); i3++) {
                                                if (string.equals(jsonWrapper.getObject(i3, "{}").getString("roomid", ""))) {
                                                    jsonWrapper.remove(i3);
                                                    break;
                                                }
                                            }
                                        }
                                        this.e.a(str, i3, i3 + this.e.b);
                                    }
                                }
                                this.e.g();
                            }
                        }
                        jsonWrapper = this.e.c();
                        if (jsonWrapper != null) {
                            if (jsonWrapper.getLength() > 0) {
                                for (i2 = 0; i2 < str.getLength(); i2++) {
                                    String string2;
                                    int i4;
                                    object = str.getObject(i2, "{}");
                                    if (object.getInt("item_type", 0) != 0) {
                                        if (object.getInt("item_type", 0) != 2) {
                                            string2 = object.getString("channel_id", "");
                                            i4 = 0;
                                            while (i4 < jsonWrapper.getLength()) {
                                                if (string2.equals(jsonWrapper.getObject(i4, "{}").getString("channel_id", ""))) {
                                                    jsonWrapper.put(i4, object);
                                                    break;
                                                }
                                                i4++;
                                            }
                                            if (i4 >= jsonWrapper.getLength() && z4) {
                                                jsonWrapper.add(object);
                                            }
                                        }
                                    }
                                    string2 = object.getString("roomid", "");
                                    i4 = 0;
                                    while (i4 < jsonWrapper.getLength()) {
                                        if (string2.equals(jsonWrapper.getObject(i4, "{}").getString("roomid", ""))) {
                                            jsonWrapper.put(i4, object);
                                            break;
                                        }
                                        i4++;
                                    }
                                    jsonWrapper.add(object);
                                }
                                this.e.notifyDataSetChanged();
                                this.e.g();
                            }
                        }
                        this.e.a((JsonWrapper) str);
                        this.e.g();
                    }
                    if (this.e.a != null) {
                        this.e.a.a(str2, true, z4);
                    }
                    this.e.b();
                    com.xunlei.tdlive.sdk.a.d("perform_homepage_load").a("result", i == 0 ? "success" : "fail").a("errcode", i).b(new String[0]);
                }
            });
        }
    }

    private void g() {
        JsonWrapper jsonWrapper = new JsonWrapper("[]");
        if (getCount() > 5) {
            JsonWrapper a = a(4);
            JsonWrapper a2 = a(5);
            if (b(a) && b(a2)) {
                JsonWrapper jsonWrapper2 = new JsonWrapper("{}");
                jsonWrapper2.put("accept_player", a);
                jsonWrapper2.put("defier_player", a2);
                jsonWrapper.add(jsonWrapper2);
                if (getCount() > 7) {
                    a = a(6);
                    a2 = a(7);
                    if (b(a) && b(a2)) {
                        jsonWrapper2 = new JsonWrapper("{}");
                        jsonWrapper2.put("accept_player", a);
                        jsonWrapper2.put("defier_player", a2);
                        jsonWrapper.add(jsonWrapper2);
                    }
                }
            }
        }
        this.j = jsonWrapper;
    }

    public JsonWrapper f() {
        return this.j;
    }

    private boolean b(JsonWrapper jsonWrapper) {
        if (jsonWrapper == null) {
            return false;
        }
        int i = jsonWrapper.getInt("status", 0);
        if (jsonWrapper.getInt("item_type", 0) == 2 && (i == 1 || i == 3)) {
            return true;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        JsonWrapper a;
        String string;
        String string2;
        int i2;
        String string3;
        if (this.d == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) viewGroup.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.d = displayMetrics.widthPixels;
        }
        if (view != null) {
            if (view.getTag() != null) {
                aVar = (a) view.getTag();
                aVar.l = i;
                a = a(i);
                if (a != null) {
                    a.putInt("position", i);
                    i = a.getObject("userinfo", "{}").getString("nickname", a.getString("userid", ""));
                    string = a.getObject("userinfo", "{}").getString("avatar", "");
                    string2 = a.getString("image", string);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = string;
                    }
                    aVar.k.setLayoutParams(new LayoutParams(this.d, this.d));
                    aVar.a.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) d.a(viewGroup.getContext(), 45.0f)));
                    aVar.f.setTextColor(-13816531);
                    aVar.f.setTextSize(12.0f);
                    aVar.e.setType(0);
                    aVar.e.setBorderRadius(0);
                    aVar.e.setLayoutParams(new LinearLayout.LayoutParams((int) d.a(viewGroup.getContext(), 24.0f), (int) d.a(viewGroup.getContext(), 24.0f)));
                    aVar.j.setVisibility(8);
                    i2 = a.getInt("status", 0);
                    if (i2 != 1) {
                        if (i2 == 3) {
                            if (i2 != 2) {
                                aVar.c.setVisibility(0);
                                aVar.h.setText(a.getString("onlinenum", "0"));
                                aVar.i.setText("人看过");
                            } else {
                                aVar.b.setVisibility(8);
                                aVar.c.setVisibility(8);
                                aVar.h.setText("");
                                aVar.i.setText("");
                            }
                            aVar.a.setTag(aVar);
                            aVar.f.setText(i);
                            i = a.getString("title", "");
                            if (TextUtils.isEmpty(i)) {
                                aVar.g.setText(i);
                                aVar.g.setVisibility(0);
                            } else {
                                aVar.g.setVisibility(8);
                            }
                            string3 = a.getString("tag", "");
                            if (string3.length() <= 0) {
                                b.a(viewGroup.getContext()).a(aVar.d, string3, new c<ImageView>(this) {
                                    final /* synthetic */ g a;

                                    public void a(ImageView imageView, String str, Drawable drawable) {
                                    }

                                    {
                                        this.a = r1;
                                    }

                                    public void a(ImageView imageView, String str, Bitmap bitmap, b.b bVar) {
                                        imageView.setVisibility(null);
                                        str = ((float) d.a(imageView.getContext()).x) / 1149698048;
                                        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                                        if (layoutParams != null) {
                                            layoutParams.width = (int) (((float) bitmap.getWidth()) * str);
                                            layoutParams.height = (int) (str * ((float) bitmap.getHeight()));
                                            imageView.setLayoutParams(layoutParams);
                                        }
                                    }
                                });
                            } else {
                                aVar.d.setVisibility(8);
                            }
                            b.a(viewGroup.getContext()).a(aVar.e, string, b.a(viewGroup.getContext(), R.drawable.xllive_avatar_default));
                            b.a(viewGroup.getContext()).a(aVar.k, string2, b.a(viewGroup.getContext(), R.drawable.xllive_img_loding));
                        }
                    }
                    aVar.b.setVisibility(0);
                    aVar.c.setVisibility(8);
                    aVar.h.setText(a.getString("onlinenum", "0"));
                    aVar.i.setText("人在看");
                    aVar.a.setTag(aVar);
                    aVar.f.setText(i);
                    i = a.getString("title", "");
                    if (TextUtils.isEmpty(i)) {
                        aVar.g.setText(i);
                        aVar.g.setVisibility(0);
                    } else {
                        aVar.g.setVisibility(8);
                    }
                    string3 = a.getString("tag", "");
                    if (string3.length() <= 0) {
                        aVar.d.setVisibility(8);
                    } else {
                        b.a(viewGroup.getContext()).a(aVar.d, string3, /* anonymous class already generated */);
                    }
                    b.a(viewGroup.getContext()).a(aVar.e, string, b.a(viewGroup.getContext(), R.drawable.xllive_avatar_default));
                    b.a(viewGroup.getContext()).a(aVar.k, string2, b.a(viewGroup.getContext(), R.drawable.xllive_img_loding));
                }
                return view;
            }
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xllive_live_list_item_sdk, viewGroup, false);
        aVar = new a(this);
        view.setTag(aVar);
        aVar.a = view.findViewById(R.id.head);
        aVar.b = view.findViewById(R.id.xllive_list_mask);
        aVar.d = (ImageView) view.findViewById(R.id.tag);
        aVar.c = (TextView) view.findViewById(R.id.xllive_live_flag);
        aVar.e = (RoundImageView) view.findViewById(R.id.useravatar);
        aVar.f = (TextView) view.findViewById(R.id.username);
        aVar.g = (TextView) view.findViewById(R.id.title);
        aVar.k = (ImageView) view.findViewById(R.id.playthumb);
        aVar.h = (TextView) view.findViewById(R.id.count);
        aVar.i = (TextView) view.findViewById(R.id.audience);
        aVar.j = (TextView) view.findViewById(R.id.addown);
        aVar.l = i;
        a = a(i);
        if (a != null) {
            a.putInt("position", i);
            i = a.getObject("userinfo", "{}").getString("nickname", a.getString("userid", ""));
            string = a.getObject("userinfo", "{}").getString("avatar", "");
            string2 = a.getString("image", string);
            if (TextUtils.isEmpty(string2)) {
                string2 = string;
            }
            aVar.k.setLayoutParams(new LayoutParams(this.d, this.d));
            aVar.a.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) d.a(viewGroup.getContext(), 45.0f)));
            aVar.f.setTextColor(-13816531);
            aVar.f.setTextSize(12.0f);
            aVar.e.setType(0);
            aVar.e.setBorderRadius(0);
            aVar.e.setLayoutParams(new LinearLayout.LayoutParams((int) d.a(viewGroup.getContext(), 24.0f), (int) d.a(viewGroup.getContext(), 24.0f)));
            aVar.j.setVisibility(8);
            i2 = a.getInt("status", 0);
            if (i2 != 1) {
                if (i2 == 3) {
                    if (i2 != 2) {
                        aVar.b.setVisibility(8);
                        aVar.c.setVisibility(8);
                        aVar.h.setText("");
                        aVar.i.setText("");
                    } else {
                        aVar.c.setVisibility(0);
                        aVar.h.setText(a.getString("onlinenum", "0"));
                        aVar.i.setText("人看过");
                    }
                    aVar.a.setTag(aVar);
                    aVar.f.setText(i);
                    i = a.getString("title", "");
                    if (TextUtils.isEmpty(i)) {
                        aVar.g.setVisibility(8);
                    } else {
                        aVar.g.setText(i);
                        aVar.g.setVisibility(0);
                    }
                    string3 = a.getString("tag", "");
                    if (string3.length() <= 0) {
                        b.a(viewGroup.getContext()).a(aVar.d, string3, /* anonymous class already generated */);
                    } else {
                        aVar.d.setVisibility(8);
                    }
                    b.a(viewGroup.getContext()).a(aVar.e, string, b.a(viewGroup.getContext(), R.drawable.xllive_avatar_default));
                    b.a(viewGroup.getContext()).a(aVar.k, string2, b.a(viewGroup.getContext(), R.drawable.xllive_img_loding));
                }
            }
            aVar.b.setVisibility(0);
            aVar.c.setVisibility(8);
            aVar.h.setText(a.getString("onlinenum", "0"));
            aVar.i.setText("人在看");
            aVar.a.setTag(aVar);
            aVar.f.setText(i);
            i = a.getString("title", "");
            if (TextUtils.isEmpty(i)) {
                aVar.g.setText(i);
                aVar.g.setVisibility(0);
            } else {
                aVar.g.setVisibility(8);
            }
            string3 = a.getString("tag", "");
            if (string3.length() <= 0) {
                aVar.d.setVisibility(8);
            } else {
                b.a(viewGroup.getContext()).a(aVar.d, string3, /* anonymous class already generated */);
            }
            b.a(viewGroup.getContext()).a(aVar.e, string, b.a(viewGroup.getContext(), R.drawable.xllive_avatar_default));
            b.a(viewGroup.getContext()).a(aVar.k, string2, b.a(viewGroup.getContext(), R.drawable.xllive_img_loding));
        }
        return view;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.f = i;
        if (this.f == null && this.g != null) {
            this.g = null;
            c(null);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f > null) {
            this.g = (i2 + i) + 3 >= i3 ? true : null;
            this.e = i / this.b;
        }
    }
}
