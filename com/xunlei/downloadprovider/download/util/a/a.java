package com.xunlei.downloadprovider.download.util.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.tasklist.list.download.a.f;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;
import com.xunlei.downloadprovider.download.util.DownloadError.SpeedupFailureCode;
import com.xunlei.downloadprovider.download.util.a.a.e;
import com.xunlei.downloadprovider.download.util.r;
import java.util.List;

/* compiled from: TaskImageLoader */
public class a {
    private static a a;

    /* compiled from: TaskImageLoader */
    private static class a extends ImageViewTarget<Bitmap> {
        private String a;

        protected final /* synthetic */ void setResource(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            String tag = ((ImageView) this.view).getTag(R.id.tag_image_id);
            if (tag == this.a || (this.a != null && this.a.equals(tag))) {
                obj = RoundedBitmapDrawableFactory.create(((ImageView) this.view).getResources(), bitmap);
                obj.setCornerRadius(10.0f);
                obj.setAntiAlias(true);
                ((ImageView) this.view).setImageDrawable(obj);
            }
        }

        a(ImageView imageView, String str) {
            super(imageView);
            this.a = str;
        }
    }

    /* compiled from: TaskImageLoader */
    private static class b extends ImageViewTarget<Bitmap> {
        private String a;
        private f b;
        private com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a c;

        public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
            super.onResourceReady((Bitmap) obj, glideAnimation);
            if (this.b != null) {
                this.b.a(null);
            }
            if (this.c != null) {
                this.c.a();
            }
        }

        protected final /* synthetic */ void setResource(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            String tag = ((ImageView) this.view).getTag(R.id.tag_image_id);
            if (tag == this.a || (this.a != null && this.a.equals(tag))) {
                ((ImageView) this.view).setImageBitmap(bitmap);
            }
        }

        b(ImageView imageView, String str, f fVar, com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a aVar) {
            super(imageView);
            this.a = str;
            this.b = fVar;
            this.c = aVar;
        }

        public final void onLoadStarted(Drawable drawable) {
            super.onLoadStarted(drawable);
        }

        public final void onLoadFailed(Exception exception, Drawable drawable) {
            super.onLoadFailed(exception, drawable);
        }

        public final void onLoadCleared(Drawable drawable) {
            super.onLoadCleared(drawable);
        }
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private static void a(String str, ImageView imageView, @DrawableRes int i) {
        imageView.setTag(R.id.tag_image_id, String.valueOf(str));
        Glide.with(imageView.getContext()).using(com.xunlei.downloadprovider.download.util.a.a.b.a()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT).placeholder(i).fallback(i).error(i).dontAnimate().into(new a(imageView, str));
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, ImageView imageView, @Nullable f fVar, int i, com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a aVar) {
        int dimensionPixelSize;
        if (i == 1) {
            i = imageView.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_width);
            dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_height);
        } else {
            i = imageView.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_width);
            dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_height);
        }
        a(downloadTaskInfo, imageView, i, dimensionPixelSize, com.xunlei.downloadprovider.download.util.r.a.a(downloadTaskInfo, r.a(downloadTaskInfo)), fVar, aVar);
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, ImageView imageView, int i, int i2, int i3, @Nullable f fVar, com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a aVar) {
        TaskInfo taskInfo = downloadTaskInfo;
        ImageView imageView2 = imageView;
        int i4 = i3;
        f fVar2 = fVar;
        com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a aVar2 = aVar;
        EFileCategoryType a = r.a(taskInfo);
        if (!d.a().d.g()) {
            if (taskInfo.mIsSensitiveResource == 0) {
                taskInfo.mIsSensitiveResource = Integer.parseInt(BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_illegal_url", 0).getString(taskInfo.mUrl, "1"));
            }
            if (taskInfo.mIsSensitiveResource == 1) {
                FailureCode a2 = DownloadError.a(taskInfo);
                if (a2 != null) {
                    switch (b.a[a2.ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_illegal_url", 0).edit().putString(taskInfo.mUrl, "2").apply();
                            taskInfo.mIsSensitiveResource = 2;
                            break;
                        default:
                            break;
                    }
                }
                SpeedupFailureCode b = DownloadError.b(taskInfo);
                if (b != null && b == SpeedupFailureCode.SENSITIVE_RESOURCE_LIMITED) {
                    BrothersApplication.getApplicationInstance().getSharedPreferences("shared_save_illegal_url", 0).edit().putString(taskInfo.mUrl, "2").apply();
                    taskInfo.mIsSensitiveResource = 2;
                }
            }
            if (taskInfo.mIsSensitiveResource == 2) {
                a(imageView2);
                imageView2.setTag(R.id.tag_image_id, String.valueOf(i3));
                imageView2.setImageResource(i4);
                return;
            }
        }
        String str = null;
        e eVar;
        if (taskInfo.mTaskType == TaskType.BT) {
            n.a();
            z e = n.e(taskInfo.getTaskId());
            if (e != null) {
                List<BTSubTaskInfo> g = e.g();
                if (!(g == null || g.isEmpty())) {
                    for (BTSubTaskInfo bTSubTaskInfo : g) {
                        EFileCategoryType eFileCategoryType;
                        if (bTSubTaskInfo == null) {
                            eFileCategoryType = null;
                        } else if (TextUtils.isEmpty(bTSubTaskInfo.mLocalFileName)) {
                            eFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskInfo.mTitle);
                        } else {
                            eFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskInfo.mLocalFileName);
                        }
                        if (eFileCategoryType == EFileCategoryType.E_VIDEO_CATEGORY) {
                            str = bTSubTaskInfo.mLocalFileName;
                            if (!TextUtils.isEmpty(str)) {
                                eVar = new e(str);
                                eVar.a = taskInfo;
                                eVar.b = bTSubTaskInfo;
                                a(eVar, imageView2, i4, i, i2, new b(imageView2, str, fVar2, aVar2));
                                return;
                            }
                        }
                    }
                    BTSubTaskInfo bTSubTaskInfo2 = null;
                    if (TextUtils.isEmpty(str)) {
                        eVar = new e(str);
                        eVar.a = taskInfo;
                        eVar.b = bTSubTaskInfo2;
                        a(eVar, imageView2, i4, i, i2, new b(imageView2, str, fVar2, aVar2));
                        return;
                    }
                }
            }
        } else if (a == EFileCategoryType.E_VIDEO_CATEGORY) {
            if (taskInfo.getTaskStatus() == 8 && !TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                eVar = new e(taskInfo.mLocalFileName);
                eVar.a = taskInfo;
                a(eVar, imageView2, i4, i, i2, new b(imageView2, taskInfo.mLocalFileName, fVar2, aVar2));
                return;
            } else if (!TextUtils.isEmpty(taskInfo.mDownloadingPlayUrl)) {
                eVar = new e(taskInfo.mDownloadingPlayUrl);
                eVar.a = taskInfo;
                a(eVar, imageView2, i4, i, i2, new b(imageView2, taskInfo.mDownloadingPlayUrl, fVar2, aVar2));
                return;
            } else if (!TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                eVar = new e(taskInfo.mLocalFileName);
                eVar.a = taskInfo;
                a(eVar, imageView2, i4, i, i2, new b(imageView2, taskInfo.mLocalFileName, fVar2, aVar2));
                return;
            }
        } else if (a == EFileCategoryType.E_SOFTWARE_CATEGORY) {
            if (!TextUtils.isEmpty(taskInfo.mIconUrl)) {
                int dimensionPixelSize;
                int dimensionPixelSize2;
                if (fVar2 != null) {
                    fVar2.a(8);
                    if (aVar2 != null) {
                        aVar.a();
                    }
                }
                String str2 = taskInfo.mIconUrl;
                if (com.xunlei.downloadprovider.download.b.b.f() == 1) {
                    dimensionPixelSize = imageView2.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_width);
                    dimensionPixelSize2 = imageView2.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_height);
                } else {
                    dimensionPixelSize = imageView2.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_width);
                    dimensionPixelSize2 = imageView2.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_height);
                }
                imageView2.setTag(R.id.tag_image_id, String.valueOf(str2));
                Glide.with(imageView2.getContext()).load(str2).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT).placeholder(i4).fallback(i4).error(i4).dontAnimate().override(dimensionPixelSize, dimensionPixelSize2).into(new b(imageView2, str2, null, null));
                return;
            } else if (taskInfo.getTaskStatus() == 8 && !TextUtils.isEmpty(taskInfo.mLocalFileName)) {
                if (fVar2 != null) {
                    fVar2.a(8);
                    if (aVar2 != null) {
                        aVar.a();
                    }
                }
                a(taskInfo.mLocalFileName, imageView2, i4);
                return;
            }
        }
        if (fVar2 != null) {
            fVar2.a(8);
            if (aVar2 != null) {
                aVar.a();
            }
        }
        a(imageView2);
        imageView2.setTag(R.id.tag_image_id, String.valueOf(i3));
        imageView2.setImageResource(i4);
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, ImageView imageView) {
        downloadTaskInfo = com.xunlei.downloadprovider.download.util.r.a.a(downloadTaskInfo, r.a(downloadTaskInfo));
        a(imageView);
        imageView.setTag(R.id.tag_image_id, String.valueOf(downloadTaskInfo));
        imageView.setImageResource(downloadTaskInfo);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo r6, android.widget.ImageView r7) {
        /*
        r0 = com.xunlei.downloadprovider.download.util.r.a(r6);
        r1 = r6.mTitle;
        if (r1 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r1.trim();
    L_0x000c:
        r2 = 0;
        r3 = r6.mTaskType;
        r4 = com.xunlei.download.DownloadManager.TaskType.BT;
        r5 = 2130838474; // 0x7f0203ca float:1.7281931E38 double:1.052774087E-314;
        if (r3 != r4) goto L_0x001a;
    L_0x0016:
        r1 = 2130838454; // 0x7f0203b6 float:1.728189E38 double:1.052774077E-314;
        goto L_0x005f;
    L_0x001a:
        r3 = r6.mTaskType;
        r4 = com.xunlei.download.DownloadManager.TaskType.MAGNET;
        if (r3 != r4) goto L_0x0024;
    L_0x0020:
        r1 = 2130838464; // 0x7f0203c0 float:1.7281911E38 double:1.052774082E-314;
        goto L_0x005f;
    L_0x0024:
        if (r1 == 0) goto L_0x002a;
    L_0x0026:
        r2 = com.xunlei.common.businessutil.XLFileTypeUtil.getFileIconResId(r1);
    L_0x002a:
        if (r2 == r5) goto L_0x0031;
    L_0x002c:
        if (r2 != 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0031;
    L_0x002f:
        r1 = r2;
        goto L_0x005f;
    L_0x0031:
        r2 = com.xunlei.downloadprovider.download.util.s.a;
        r3 = r0.ordinal();
        r2 = r2[r3];
        switch(r2) {
            case 1: goto L_0x0056;
            case 2: goto L_0x0052;
            case 3: goto L_0x004e;
            case 4: goto L_0x004a;
            case 5: goto L_0x0046;
            case 6: goto L_0x0042;
            case 7: goto L_0x003e;
            default: goto L_0x003c;
        };
    L_0x003c:
        r1 = r5;
        goto L_0x005f;
    L_0x003e:
        r1 = 2130838486; // 0x7f0203d6 float:1.7281956E38 double:1.052774093E-314;
        goto L_0x005f;
    L_0x0042:
        r1 = 2130838478; // 0x7f0203ce float:1.728194E38 double:1.052774089E-314;
        goto L_0x005f;
    L_0x0046:
        r1 = 2130838461; // 0x7f0203bd float:1.7281905E38 double:1.0527740804E-314;
        goto L_0x005f;
    L_0x004a:
        r1 = 2130838449; // 0x7f0203b1 float:1.728188E38 double:1.0527740745E-314;
        goto L_0x005f;
    L_0x004e:
        r1 = 2130838484; // 0x7f0203d4 float:1.7281952E38 double:1.052774092E-314;
        goto L_0x005f;
    L_0x0052:
        r1 = 2130838472; // 0x7f0203c8 float:1.7281927E38 double:1.052774086E-314;
        goto L_0x005f;
    L_0x0056:
        r2 = 2130838468; // 0x7f0203c4 float:1.728192E38 double:1.052774084E-314;
        if (r1 == 0) goto L_0x002f;
    L_0x005b:
        r1 = com.xunlei.common.businessutil.XLFileTypeUtil.getFileIconResId(r1);
    L_0x005f:
        if (r1 != 0) goto L_0x0062;
    L_0x0061:
        r1 = r5;
    L_0x0062:
        r2 = r6.mIconUrl;
        r2 = android.text.TextUtils.isEmpty(r2);
        r3 = 2131886133; // 0x7f120035 float:1.9406836E38 double:1.053291699E-314;
        if (r2 != 0) goto L_0x00bf;
    L_0x006d:
        r6 = r6.mIconUrl;
        r0 = java.lang.String.valueOf(r6);
        r7.setTag(r3, r0);
        r0 = r7.getResources();
        r2 = 2131427864; // 0x7f0b0218 float:1.8477356E38 double:1.053065284E-314;
        r0 = r0.getDimensionPixelSize(r2);
        r2 = r7.getResources();
        r3 = 2131427859; // 0x7f0b0213 float:1.8477346E38 double:1.0530652817E-314;
        r2 = r2.getDimensionPixelSize(r3);
        r3 = r7.getContext();
        r3 = com.bumptech.glide.Glide.with(r3);
        r3 = r3.load(r6);
        r3 = r3.asBitmap();
        r4 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL;
        r3 = r3.diskCacheStrategy(r4);
        r3 = r3.placeholder(r1);
        r3 = r3.fallback(r1);
        r1 = r3.error(r1);
        r1 = r1.dontAnimate();
        r0 = r1.override(r0, r2);
        r1 = new com.xunlei.downloadprovider.download.util.a.a$a;
        r1.<init>(r7, r6);
        r0.into(r1);
        return;
    L_0x00bf:
        r2 = com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType.E_SOFTWARE_CATEGORY;
        if (r0 != r2) goto L_0x00d9;
    L_0x00c3:
        r0 = r6.getTaskStatus();
        r2 = 8;
        if (r0 != r2) goto L_0x00d9;
    L_0x00cb:
        r0 = r6.mLocalFileName;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x00d9;
    L_0x00d3:
        r6 = r6.mLocalFileName;
        a(r6, r7, r1);
        return;
    L_0x00d9:
        a(r7);
        r6 = 0;
        r7.setTag(r3, r6);
        r7.setImageResource(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.a.a.b(com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo, android.widget.ImageView):void");
    }

    private static void a(ImageView imageView) {
        Object tag = imageView.getTag();
        if (tag instanceof Request) {
            try {
                ((Request) tag).clear();
                imageView.setTag(null);
            } catch (ImageView imageView2) {
                imageView2.printStackTrace();
            }
        }
    }

    private static void a(e eVar, ImageView imageView, @DrawableRes int i, int i2, int i3, ImageViewTarget<Bitmap> imageViewTarget) {
        imageView.setTag(R.id.tag_image_id, String.valueOf(eVar.c));
        Glide.with(imageView.getContext()).using(com.xunlei.downloadprovider.download.util.a.a.f.a()).load(eVar).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT).placeholder(i).error(i).dontAnimate().override(i2, i3).centerCrop().into(imageViewTarget);
    }
}
