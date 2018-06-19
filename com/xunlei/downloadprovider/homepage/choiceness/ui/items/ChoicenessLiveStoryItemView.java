package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.j;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.Character.UnicodeBlock;
import java.util.List;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;

public class ChoicenessLiveStoryItemView extends FrameLayout {
    public List<j> a;
    public a b;
    private RecyclerView c;
    private PreferenceHelper d;

    private class a extends Adapter<b> {
        public List<j> a;
        public boolean b;
        public boolean c;
        final /* synthetic */ ChoicenessLiveStoryItemView d;

        private a(ChoicenessLiveStoryItemView choicenessLiveStoryItemView) {
            this.d = choicenessLiveStoryItemView;
        }

        public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
            int i2 = i;
            b bVar = (b) viewHolder;
            if (this.a != null) {
                j jVar = (j) r0.a.get(i2);
                int i3 = 0;
                if (i2 >= 5) {
                    r0.b = false;
                }
                boolean z = r0.b;
                boolean z2 = r0.c;
                com.xunlei.downloadprovider.homepage.choiceness.b.a().a(jVar.b(), bVar.b, null);
                bVar.c.setText(ChoicenessLiveStoryItemView.a(j.a(jVar.a, "nickname")));
                bVar.d.setText(jVar.d());
                TextView textView = bVar.d;
                if (!z2) {
                    i3 = 8;
                }
                textView.setVisibility(i3);
                bVar.e.setSelected(bVar.a(jVar.e()));
                if (i2 >= 5 || !z) {
                    bVar.a(i2, jVar);
                } else {
                    bVar.e.setVisibility(8);
                    Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
                    scaleAnimation.setDuration(960);
                    scaleAnimation.setInterpolator(bVar.f);
                    bVar.b.setAnimation(scaleAnimation);
                    bVar.b.startAnimation(scaleAnimation);
                    bVar.g.postDelayed(new l(bVar, i2, jVar), 400);
                }
                bVar.a.setOnClickListener(new m(bVar, jVar, i2));
            }
        }

        public final int getItemCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(this.d, LayoutInflater.from(this.d.getContext()).inflate(R.layout.choiceness_live_story_item_view, viewGroup, false));
        }
    }

    private class b extends ViewHolder {
        View a;
        ImageView b;
        TextView c;
        TextView d;
        ImageView e;
        Interpolator f = new p(this);
        final /* synthetic */ ChoicenessLiveStoryItemView g;
        private View h;
        private ImageView i;
        private ImageView j;
        private AnimationDrawable k;
        private ImageView l;
        private AnimationDrawable m;

        public b(ChoicenessLiveStoryItemView choicenessLiveStoryItemView, View view) {
            this.g = choicenessLiveStoryItemView;
            super(view);
            this.a = view;
            this.b = (ImageView) view.findViewById(R.id.avatar);
            this.c = (TextView) view.findViewById(R.id.nickname);
            this.d = (TextView) view.findViewById(R.id.extra);
            this.e = (ImageView) view.findViewById(R.id.ring);
            this.l = (ImageView) view.findViewById(R.id.ani_view);
            this.h = view.findViewById(R.id.tag_layout);
            this.i = (ImageView) view.findViewById(R.id.tag);
            this.j = (ImageView) view.findViewById(R.id.tag_light);
            this.k = (AnimationDrawable) this.j.getDrawable();
        }

        final void a(int i, j jVar) {
            if (i >= 2 || this.e.isSelected() != 0) {
                this.l.setVisibility(8);
                this.e.setVisibility(0);
                if (!(this.m == 0 || this.m.isRunning() == 0)) {
                    this.m.stop();
                }
            } else {
                this.l.setImageDrawable(this.g.getResources().getDrawable(R.drawable.live_story_ring_ani));
                this.m = (AnimationDrawable) this.l.getDrawable();
                this.m.start();
                this.l.setVisibility(0);
                this.e.setVisibility(8);
            }
            if (TextUtils.isEmpty(jVar.c()) == 0) {
                this.h.setVisibility(0);
                this.j.setVisibility(8);
                this.i.setImageDrawable(new BitmapDrawable(this.i.getResources(), null));
                Glide.with(this.i.getContext()).load(jVar.c()).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(new n(this, this.i, jVar));
                return;
            }
            this.h.setVisibility(8);
            this.k.stop();
        }

        final boolean a(String str) {
            PreferenceHelper b = this.g.getPfHelper();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            stringBuilder.append("live_story_room_click");
            stringBuilder.append(str);
            return b.getBoolean(stringBuilder.toString(), false);
        }

        static /* synthetic */ void a(b bVar, String str) {
            if (bVar.a(str) == null) {
                bVar.l.setImageDrawable(bVar.g.getResources().getDrawable(R.drawable.live_story_loading_ani));
                bVar.m = (AnimationDrawable) bVar.l.getDrawable();
                bVar.l.setVisibility(0);
                bVar.e.setVisibility(8);
                bVar.m.start();
                bVar.g.postDelayed(new o(bVar), 2000);
                return;
            }
            bVar.e.setSelected(true);
            bVar.e.setVisibility(0);
            bVar.j.setVisibility(8);
            bVar.k.stop();
        }

        static /* synthetic */ void b(b bVar, String str) {
            bVar = bVar.g.getPfHelper();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            stringBuilder.append("live_story_room_click");
            stringBuilder.append(str);
            bVar.putBoolean(stringBuilder.toString(), true);
        }
    }

    public ChoicenessLiveStoryItemView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ChoicenessLiveStoryItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessLiveStoryItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.choiceness_live_story_view, this, true);
        ((AnimationDrawable) ((ImageView) findViewById(R.id.liveing_tag)).getDrawable()).start();
        this.c = (RecyclerView) findViewById(R.id.live_story_recycle_view);
        this.c.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.b = new a();
        this.c.addItemDecoration(new i(this));
        this.c.setAdapter(this.b);
        this.c.setOnScrollListener(new j(this));
        findViewById(R.id.story_top).setOnClickListener(new k(this));
    }

    private PreferenceHelper getPfHelper() {
        if (this.d == null) {
            this.d = new PreferenceHelper(getContext(), "live_story_sp");
        }
        return this.d;
    }

    public final void a(int i, int i2, String str) {
        if (this.a != null && this.a.size() > i2) {
            StringBuilder stringBuilder = new StringBuilder();
            while (i <= i2) {
                String a = ((j) this.a.get(i)).a();
                StringBuilder stringBuilder2 = new StringBuilder(AgooConstants.MESSAGE_ID);
                stringBuilder2.append(i);
                stringBuilder2.append("_");
                stringBuilder2.append(a);
                stringBuilder2.append("_");
                stringBuilder.append(stringBuilder2.toString());
                i++;
            }
            i = stringBuilder.toString();
            i2 = HubbleEventBuilder.build("android_home", "home_zb_story_show");
            i2.add("hostid_list", i);
            i2.add("action", str);
            ThunderReport.reportEvent(i2);
        }
    }

    public static String a(String str) {
        String str2 = "...";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i = 0;
        int i2 = i;
        while (i < str.length()) {
            int i3;
            int i4 = i + 1;
            CharSequence substring = str.substring(i, i4);
            char[] toCharArray = substring.toCharArray();
            int i5 = 0;
            while (true) {
                i3 = 1;
                if (i5 >= toCharArray.length) {
                    break;
                }
                UnicodeBlock of = UnicodeBlock.of(toCharArray[i5]);
                if (!(of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION)) {
                    if (of != UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                        i3 = 0;
                    }
                }
                if (i3 == 0) {
                    break;
                }
                i5++;
            }
            i3 = 0;
            if (i3 == 0) {
                if (!Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66).matcher(substring).find()) {
                    i2++;
                    if (i2 <= 10) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str.substring(0, i));
                        stringBuilder.append(str2);
                        return stringBuilder.toString();
                    }
                    i = i4;
                }
            }
            i2 += 2;
            if (i2 <= 10) {
                i = i4;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str.substring(0, i));
                stringBuilder2.append(str2);
                return stringBuilder2.toString();
            }
        }
        return str;
    }
}
