package com.xunlei.downloadprovider.personal.lixianspace.ui.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskType;
import java.util.List;
import java.util.Locale;

/* compiled from: LXSpaceTaskAdapter */
public final class a extends com.xunlei.downloadprovider.member.payment.ui.a.a.a<LXTaskInfo, e> {

    /* compiled from: LXSpaceTaskAdapter */
    public static abstract class e extends com.xunlei.downloadprovider.member.payment.ui.a.a.d {
        protected TextView d;
        protected TextView e;
        protected TextView f;
        protected TextView g;
        protected ImageView h;

        @CallSuper
        public void a(Context context, LXTaskInfo lXTaskInfo, int i) {
            this.d.setText(lXTaskInfo.f);
            this.e.setText(lXTaskInfo.g > 0 ? com.xunlei.downloadprovider.download.util.a.c(lXTaskInfo.g) : "未知大小");
            context = this.g;
            if (lXTaskInfo.e <= 0) {
                i = "已失效";
            } else {
                if (!(lXTaskInfo.i == CollectState.porn_resource || lXTaskInfo.i == CollectState.reactionary_resource)) {
                    if (lXTaskInfo.i != CollectState.piracy_resource) {
                        if (lXTaskInfo.i == CollectState.complete && lXTaskInfo.j == 0) {
                            i = String.format(Locale.getDefault(), "有效期还剩%d天 离线下载完成", new Object[]{Integer.valueOf(lXTaskInfo.e)});
                        } else {
                            if (lXTaskInfo.i != CollectState.downloading) {
                                if (lXTaskInfo.j == 0) {
                                    i = "离线失败";
                                }
                            }
                            i = "离线下载中";
                        }
                    }
                }
                i = lXTaskInfo.i == CollectState.piracy_resource ? "因涉及版权问题无法离线下载" : "因涉及敏感信息无法离线下载";
            }
            context.setText(i);
            this.f.setText(a(lXTaskInfo.d));
            context = this.h;
            if (lXTaskInfo.k == LXTaskType.BT) {
                lXTaskInfo = R.drawable.ic_dl_bt;
            } else {
                i = XLFileTypeUtil.getFileIconResId(lXTaskInfo.f);
                lXTaskInfo = (i != R.drawable.ic_dl_other || k.g(lXTaskInfo.b) == null) ? i : R.drawable.ic_dl_magnet;
            }
            context.setImageResource(lXTaskInfo);
        }

        public e(View view) {
            super(view);
            this.d = (TextView) view.findViewById(R.id.lx_space_task_name_tv);
            this.e = (TextView) view.findViewById(R.id.lx_space_task_size_tv);
            this.f = (TextView) view.findViewById(R.id.lx_space_task_create_time_tv);
            this.g = (TextView) view.findViewById(R.id.lx_space_task_state_tv);
            this.h = (ImageView) view.findViewById(R.id.lx_space_task_icon_iv);
        }

        private static java.lang.String a(java.lang.String r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = new java.text.SimpleDateFormat;
            r1 = "yyyy-MM-dd HH:mm:ss";
            r2 = java.util.Locale.getDefault();
            r0.<init>(r1, r2);
            r1 = new java.text.SimpleDateFormat;
            r2 = "MM-dd HH:mm";
            r3 = java.util.Locale.getDefault();
            r1.<init>(r2, r3);
            r2 = new java.text.SimpleDateFormat;
            r3 = "yyyy-MM-dd";
            r4 = java.util.Locale.getDefault();
            r2.<init>(r3, r4);
            r3 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0045 }
            r5 = r0.parse(r5);	 Catch:{ Exception -> 0x0045 }
            r0 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0045 }
            r0.setTime(r5);	 Catch:{ Exception -> 0x0045 }
            r4 = 1;	 Catch:{ Exception -> 0x0045 }
            r3 = r3.get(r4);	 Catch:{ Exception -> 0x0045 }
            r0 = r0.get(r4);	 Catch:{ Exception -> 0x0045 }
            if (r3 != r0) goto L_0x0040;	 Catch:{ Exception -> 0x0045 }
        L_0x003b:
            r5 = r1.format(r5);	 Catch:{ Exception -> 0x0045 }
            return r5;	 Catch:{ Exception -> 0x0045 }
        L_0x0040:
            r5 = r2.format(r5);	 Catch:{ Exception -> 0x0045 }
            return r5;
        L_0x0045:
            r5 = "";
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.lixianspace.ui.b.a.e.a(java.lang.String):java.lang.String");
        }
    }

    /* compiled from: LXSpaceTaskAdapter */
    public static class a extends e {
        private TextView i;
        private ProgressBar j;
        private ValueAnimator k = ValueAnimator.ofInt(new int[]{0, 100}).setDuration(5000);

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.view.View r3) {
            /*
            r2 = this;
            r2.<init>(r3);
            r0 = 2131887996; // 0x7f12077c float:1.9410615E38 double:1.0532926196E-314;
            r0 = r3.findViewById(r0);
            r0 = (android.widget.TextView) r0;
            r2.i = r0;
            r0 = 2131887997; // 0x7f12077d float:1.9410617E38 double:1.05329262E-314;
            r3 = r3.findViewById(r0);
            r3 = (android.widget.ProgressBar) r3;
            r2.j = r3;
            r3 = 2;
            r3 = new int[r3];
            r3 = {0, 100};
            r3 = android.animation.ValueAnimator.ofInt(r3);
            r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r3 = r3.setDuration(r0);
            r2.k = r3;
            r3 = r2.k;
            r0 = new android.view.animation.AccelerateDecelerateInterpolator;
            r0.<init>();
            r3.setInterpolator(r0);
            r3 = r2.k;
            r0 = new com.xunlei.downloadprovider.personal.lixianspace.ui.b.b;
            r0.<init>(r2);
            r3.addUpdateListener(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.lixianspace.ui.b.a.a.<init>(android.view.View):void");
        }

        public final void a(Context context, LXTaskInfo lXTaskInfo, int i) {
            super.a(context, lXTaskInfo, i);
            if (this.k.isRunning() == null) {
                this.k.start();
            }
            this.i.setTag(Integer.valueOf(i));
        }
    }

    /* compiled from: LXSpaceTaskAdapter */
    public static class b extends e {
        public b(View view) {
            super(view);
        }

        public final void a(Context context, LXTaskInfo lXTaskInfo, int i) {
            super.a(context, lXTaskInfo, i);
        }
    }

    /* compiled from: LXSpaceTaskAdapter */
    public static class c extends e {
        private TextView i;
        private ProgressBar j;

        public c(View view) {
            super(view);
            this.i = (TextView) view.findViewById(R.id.lx_space_task_progress_tv);
            this.j = (ProgressBar) view.findViewById(R.id.lx_space_task_progress_pb);
        }

        public final void a(Context context, LXTaskInfo lXTaskInfo, int i) {
            super.a(context, lXTaskInfo, i);
            context = this.i;
            i = new StringBuilder();
            i.append(lXTaskInfo.c);
            i.append("%");
            context.setText(i.toString());
            this.j.setProgress(lXTaskInfo.c);
        }
    }

    /* compiled from: LXSpaceTaskAdapter */
    public static class d extends e {
        public d(View view) {
            super(view);
        }

        public final void a(Context context, LXTaskInfo lXTaskInfo, int i) {
            super.a(context, lXTaskInfo, i);
        }
    }

    protected final /* bridge */ /* synthetic */ void a(com.xunlei.downloadprovider.member.payment.ui.a.a.d dVar, Object obj, int i) {
        ((e) dVar).a(this.d, (LXTaskInfo) obj, i);
    }

    public a(Context context) {
        super(context);
    }

    protected final int b(int i) {
        LXTaskInfo lXTaskInfo = (LXTaskInfo) c(i);
        if (lXTaskInfo.e > 0) {
            if (lXTaskInfo.i == CollectState.complete) {
                return lXTaskInfo.j != 0 ? 4 : 1;
            } else {
                if (lXTaskInfo.i == CollectState.downloading) {
                    return 3;
                }
            }
        }
        return 2;
    }

    public final void a(long j) {
        int size = this.c.size();
        int i = 0;
        while (i < size) {
            LXTaskInfo lXTaskInfo = (LXTaskInfo) c(i);
            if (lXTaskInfo == null || lXTaskInfo.a != j) {
                i++;
            } else {
                b((Object) lXTaskInfo);
                return;
            }
        }
    }

    public final void a(LXTaskInfo lXTaskInfo) {
        if (lXTaskInfo != null) {
            int i = 0;
            int size = this.c.size();
            while (i < size) {
                LXTaskInfo lXTaskInfo2 = (LXTaskInfo) this.c.get(i);
                if (!TextUtils.equals(lXTaskInfo2.b, lXTaskInfo.b)) {
                    if (lXTaskInfo.a != lXTaskInfo2.a) {
                        i++;
                    }
                }
                b((Object) lXTaskInfo2);
                break;
            }
            a((Object) lXTaskInfo);
        }
    }

    public final void c(List<LXTaskInfo> list) {
        if (!com.xunlei.xllib.b.d.a(list)) {
            for (LXTaskInfo lXTaskInfo : list) {
                int size = this.c.size();
                for (int i = 0; i < size; i++) {
                    LXTaskInfo lXTaskInfo2 = (LXTaskInfo) this.c.get(i);
                    if (lXTaskInfo.a == lXTaskInfo2.a) {
                        lXTaskInfo2.i = lXTaskInfo.i;
                        lXTaskInfo2.e = lXTaskInfo.e;
                        lXTaskInfo2.c = lXTaskInfo.c;
                        this.c.set(i, lXTaskInfo2);
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    protected final /* synthetic */ com.xunlei.downloadprovider.member.payment.ui.a.a.d a(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(this.e.inflate(R.layout.lx_space_task_complete_item, viewGroup, false));
        }
        if (i == 2) {
            return new d(this.e.inflate(R.layout.lx_space_task_fail_item, viewGroup, false));
        }
        if (i == 3) {
            return new c(this.e.inflate(R.layout.lx_space_task_downloading_item, viewGroup, false));
        }
        return i == 4 ? new a(this.e.inflate(R.layout.lx_space_task_downloading_item, viewGroup, false)) : 0;
    }
}
