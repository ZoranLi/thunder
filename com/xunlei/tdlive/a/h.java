package com.xunlei.tdlive.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.sdk.cons.c;
import com.tencent.open.SocialConstants;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.d;
import com.xunlei.tdlive.util.g;
import com.xunlei.tdlive.util.n;

/* compiled from: SDKLiveListAdapter2 */
public class h extends g {
    private int l;
    private int m;

    /* compiled from: SDKLiveListAdapter2 */
    class a {
        View a;
        View b;
        View c;
        View d;
        View e;
        TextView f;
        TextView g;
        TextView h;
        ImageView i;
        ImageView j;
        ImageView k;
        ImageView l;
        RoundImageView m;
        TextView n;
        TextView o;
        TextView p;
        TextView q;
        RoundImageView r;
        int s;
        final /* synthetic */ h t;

        a(h hVar) {
            this.t = hVar;
        }
    }

    public h(String str, com.xunlei.tdlive.a.c.a aVar) {
        this("0", str, aVar);
    }

    public h(String str, String str2, com.xunlei.tdlive.a.c.a aVar) {
        super(str, str2, aVar);
        this.l = -1;
        this.m = -1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        JsonWrapper a;
        int a2;
        int a3;
        int i2;
        CharSequence string;
        String string2;
        CharSequence string3;
        String string4;
        CharSequence string5;
        int i3 = i;
        final int a4 = (int) d.a(viewGroup.getContext(), 20.0f);
        Context context = viewGroup.getContext();
        if (this.d == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) viewGroup.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            r0.d = displayMetrics.widthPixels;
        }
        if (view != null) {
            if (view.getTag() != null) {
                aVar = (a) view.getTag();
                view2 = view;
                ViewGroup viewGroup2 = viewGroup;
                aVar.s = i3;
                a = a(i);
                if (a != null) {
                    aVar.a.setVisibility(0);
                    aVar.b.setVisibility(8);
                    return view2;
                }
                a2 = (int) d.a(viewGroup.getContext(), 3.0f);
                a3 = (int) d.a(viewGroup.getContext(), 1.5f);
                i2 = (i3 + 1) % 2 != 0 ? 1 : false;
                int i4 = i2 == 0 ? a3 : 0;
                if (i2 != 0) {
                    a3 = 0;
                }
                view2.setPadding(i4, a2, a3, 0);
                aVar.a.setVisibility(0);
                aVar.b.setVisibility(8);
                aVar.e.setVisibility(0);
                aVar.h.setVisibility(8);
                aVar.j.setVisibility(8);
                aVar.i.setVisibility(8);
                aVar.k.setVisibility(8);
                aVar.l.setVisibility(8);
                aVar.p.setText("");
                aVar.q.setText("");
                a3 = a.getInt("item_type", 0);
                if (a3 != 0) {
                    if (a3 == 2) {
                        aVar.a.setVisibility(8);
                        aVar.b.setVisibility(0);
                        aVar.f.setText(a.getString(c.e, "频道名字"));
                        TextView textView = aVar.g;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(a.getInt("player_num", 0));
                        stringBuilder.append("个直播");
                        textView.setText(stringBuilder.toString());
                        n.a(aVar.r).a(a.getString(SocialConstants.PARAM_IMG_URL, "")).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
                        a.putInt("position", i3);
                        return view2;
                    }
                }
                string = a.getObject("userinfo", "{}").getString("nickname", a.getString("userid", ""));
                string2 = a.getObject("userinfo", "{}").getString("avatar", "");
                string3 = a.getString("image", string2);
                if (TextUtils.isEmpty(string3)) {
                    string2 = string3;
                }
                a2 = a.getInt("status", 0);
                if (a2 != 1) {
                    if (a2 == 3) {
                        if (a2 == 2) {
                            aVar.p.setText(a.getString("onlinenum", "0"));
                            aVar.q.setText("看过");
                            aVar.h.setVisibility(0);
                        }
                        aVar.d.setTag(aVar);
                        aVar.n.setText(string);
                        string4 = a.getObject("level_info", "{}").getString("image_leve", "");
                        if (string4.length() > 0) {
                            aVar.l.setVisibility(0);
                            n.a(aVar.l).a(string4).b(R.drawable.xllive_user_grade_zero_sq).a(aVar.l);
                        }
                        string = a.getString("title", "");
                        if (TextUtils.isEmpty(string)) {
                            aVar.o.setText(string);
                            aVar.o.setVisibility(0);
                        } else {
                            aVar.o.setVisibility(8);
                        }
                        string4 = a.getString("tag", "");
                        if (string4.length() > 0) {
                            aVar.i.setVisibility(8);
                            aVar.k.setVisibility(0);
                            n.a(aVar.k).a(string4).a(g.a(context)).a(aVar.k, new com.xunlei.tdlive.util.n.a<ImageView, Bitmap>(r0) {
                                final /* synthetic */ h b;

                                protected void a(ImageView imageView, Bitmap bitmap, int i, int i2) {
                                    LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                                    if (layoutParams != null) {
                                        layoutParams.width = (int) (((((float) a4) * 1065353216) / ((float) bitmap.getHeight())) * ((float) bitmap.getWidth()));
                                        layoutParams.height = a4;
                                        imageView.setLayoutParams(layoutParams);
                                    }
                                }
                            });
                        }
                        string5 = a.getString("gif", "");
                        if (!TextUtils.isEmpty(string5) && ((a2 == 1 || a2 == 3) && (i3 == r0.l || i3 == r0.m))) {
                            string2 = string5;
                        }
                        n.a(aVar.r).a(string2).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
                        a.putInt("position", i3);
                        return view2;
                    }
                }
                aVar.p.setText(a.getString("onlinenum", "0"));
                aVar.q.setText("人在看");
                if (a.getInt("vc_type", 0) == 1) {
                    aVar.j.setVisibility(0);
                    aVar.j.setImageResource(R.drawable.xllive_icon_lianmai);
                } else if (a.getInt("vc_type", 0) == 2) {
                    aVar.j.setVisibility(0);
                    aVar.j.setImageResource(R.drawable.xllive_icon_pk);
                } else if (a.getInt("platform", 0) == 4) {
                    aVar.i.setVisibility(0);
                }
                aVar.d.setTag(aVar);
                aVar.n.setText(string);
                string4 = a.getObject("level_info", "{}").getString("image_leve", "");
                if (string4.length() > 0) {
                    aVar.l.setVisibility(0);
                    n.a(aVar.l).a(string4).b(R.drawable.xllive_user_grade_zero_sq).a(aVar.l);
                }
                string = a.getString("title", "");
                if (TextUtils.isEmpty(string)) {
                    aVar.o.setText(string);
                    aVar.o.setVisibility(0);
                } else {
                    aVar.o.setVisibility(8);
                }
                string4 = a.getString("tag", "");
                if (string4.length() > 0) {
                    aVar.i.setVisibility(8);
                    aVar.k.setVisibility(0);
                    n.a(aVar.k).a(string4).a(g.a(context)).a(aVar.k, /* anonymous class already generated */);
                }
                string5 = a.getString("gif", "");
                string2 = string5;
                n.a(aVar.r).a(string2).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
                a.putInt("position", i3);
                return view2;
            }
        }
        view2 = LayoutInflater.from(context).inflate(R.layout.xllive_live_list_item_sdk2_1, viewGroup, false);
        aVar = new a(r0);
        view2.setTag(aVar);
        aVar.a = view2.findViewById(R.id.layer_action);
        aVar.b = view2.findViewById(R.id.layer_channel);
        aVar.f = (TextView) view2.findViewById(R.id.channel_name);
        aVar.g = (TextView) view2.findViewById(R.id.channel_account);
        aVar.c = view2.findViewById(R.id.body);
        aVar.d = view2.findViewById(R.id.head);
        aVar.e = view2.findViewById(R.id.xllive_list_mask);
        aVar.k = (ImageView) view2.findViewById(R.id.tag);
        aVar.i = (ImageView) view2.findViewById(R.id.pc_flag);
        aVar.j = (ImageView) view2.findViewById(R.id.pk_flag);
        aVar.l = (ImageView) view2.findViewById(R.id.level_img);
        aVar.h = (TextView) view2.findViewById(R.id.xllive_live_flag);
        aVar.m = (RoundImageView) view2.findViewById(R.id.useravatar);
        aVar.n = (TextView) view2.findViewById(R.id.username);
        aVar.o = (TextView) view2.findViewById(R.id.title);
        aVar.r = (RoundImageView) view2.findViewById(R.id.playthumb);
        aVar.p = (TextView) view2.findViewById(R.id.count);
        aVar.q = (TextView) view2.findViewById(R.id.audience);
        aVar.r.setType(1);
        aVar.r.setBorderRadius(0);
        int i5 = r0.d / 2;
        aVar.c.setLayoutParams(new LinearLayout.LayoutParams(i5, ((int) d.a(viewGroup.getContext(), 1.5f)) + i5));
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{0, -1862270976});
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        g.a(aVar.e, gradientDrawable);
        aVar.s = i3;
        a = a(i);
        if (a != null) {
            a2 = (int) d.a(viewGroup.getContext(), 3.0f);
            a3 = (int) d.a(viewGroup.getContext(), 1.5f);
            if ((i3 + 1) % 2 != 0) {
            }
            if (i2 == 0) {
            }
            if (i2 != 0) {
                a3 = 0;
            }
            view2.setPadding(i4, a2, a3, 0);
            aVar.a.setVisibility(0);
            aVar.b.setVisibility(8);
            aVar.e.setVisibility(0);
            aVar.h.setVisibility(8);
            aVar.j.setVisibility(8);
            aVar.i.setVisibility(8);
            aVar.k.setVisibility(8);
            aVar.l.setVisibility(8);
            aVar.p.setText("");
            aVar.q.setText("");
            a3 = a.getInt("item_type", 0);
            if (a3 != 0) {
                if (a3 == 2) {
                    aVar.a.setVisibility(8);
                    aVar.b.setVisibility(0);
                    aVar.f.setText(a.getString(c.e, "频道名字"));
                    TextView textView2 = aVar.g;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a.getInt("player_num", 0));
                    stringBuilder2.append("个直播");
                    textView2.setText(stringBuilder2.toString());
                    n.a(aVar.r).a(a.getString(SocialConstants.PARAM_IMG_URL, "")).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
                    a.putInt("position", i3);
                    return view2;
                }
            }
            string = a.getObject("userinfo", "{}").getString("nickname", a.getString("userid", ""));
            string2 = a.getObject("userinfo", "{}").getString("avatar", "");
            string3 = a.getString("image", string2);
            if (TextUtils.isEmpty(string3)) {
                string2 = string3;
            }
            a2 = a.getInt("status", 0);
            if (a2 != 1) {
                if (a2 == 3) {
                    if (a2 == 2) {
                        aVar.p.setText(a.getString("onlinenum", "0"));
                        aVar.q.setText("看过");
                        aVar.h.setVisibility(0);
                    }
                    aVar.d.setTag(aVar);
                    aVar.n.setText(string);
                    string4 = a.getObject("level_info", "{}").getString("image_leve", "");
                    if (string4.length() > 0) {
                        aVar.l.setVisibility(0);
                        n.a(aVar.l).a(string4).b(R.drawable.xllive_user_grade_zero_sq).a(aVar.l);
                    }
                    string = a.getString("title", "");
                    if (TextUtils.isEmpty(string)) {
                        aVar.o.setVisibility(8);
                    } else {
                        aVar.o.setText(string);
                        aVar.o.setVisibility(0);
                    }
                    string4 = a.getString("tag", "");
                    if (string4.length() > 0) {
                        aVar.i.setVisibility(8);
                        aVar.k.setVisibility(0);
                        n.a(aVar.k).a(string4).a(g.a(context)).a(aVar.k, /* anonymous class already generated */);
                    }
                    string5 = a.getString("gif", "");
                    string2 = string5;
                    n.a(aVar.r).a(string2).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
                    a.putInt("position", i3);
                    return view2;
                }
            }
            aVar.p.setText(a.getString("onlinenum", "0"));
            aVar.q.setText("人在看");
            if (a.getInt("vc_type", 0) == 1) {
                aVar.j.setVisibility(0);
                aVar.j.setImageResource(R.drawable.xllive_icon_lianmai);
            } else if (a.getInt("vc_type", 0) == 2) {
                aVar.j.setVisibility(0);
                aVar.j.setImageResource(R.drawable.xllive_icon_pk);
            } else if (a.getInt("platform", 0) == 4) {
                aVar.i.setVisibility(0);
            }
            aVar.d.setTag(aVar);
            aVar.n.setText(string);
            string4 = a.getObject("level_info", "{}").getString("image_leve", "");
            if (string4.length() > 0) {
                aVar.l.setVisibility(0);
                n.a(aVar.l).a(string4).b(R.drawable.xllive_user_grade_zero_sq).a(aVar.l);
            }
            string = a.getString("title", "");
            if (TextUtils.isEmpty(string)) {
                aVar.o.setText(string);
                aVar.o.setVisibility(0);
            } else {
                aVar.o.setVisibility(8);
            }
            string4 = a.getString("tag", "");
            if (string4.length() > 0) {
                aVar.i.setVisibility(8);
                aVar.k.setVisibility(0);
                n.a(aVar.k).a(string4).a(g.a(context)).a(aVar.k, /* anonymous class already generated */);
            }
            string5 = a.getString("gif", "");
            string2 = string5;
            n.a(aVar.r).a(string2).a(R.anim.xllive_fade_in).b(R.drawable.xllive_img_loding).a(aVar.r);
            a.putInt("position", i3);
            return view2;
        }
        aVar.a.setVisibility(0);
        aVar.b.setVisibility(8);
        return view2;
    }

    public void g() {
        this.l = -1;
        this.m = -1;
    }

    public void a(int i, int i2) {
        this.l = -1;
        this.m = -1;
        while (i <= i2) {
            JsonWrapper a = a(i);
            if (!(a == null || TextUtils.isEmpty(a.getString("gif", "")))) {
                if (this.l == -1) {
                    this.l = i;
                } else if (this.m == -1) {
                    this.m = i;
                    break;
                }
            }
            i++;
        }
        notifyDataSetChanged();
    }
}
