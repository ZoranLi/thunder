package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.SimpleLoadingPageView;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.util.e;
import com.xunlei.downloadprovider.personal.lixianspace.b.v;
import com.xunlei.downloadprovider.personal.lixianspace.d.k;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.List;

public class LXSpaceCreateTaskByMagnetUrlActivity extends BaseActivity {
    protected TextView a;
    protected String c;
    XLAlertDialog d = null;
    private ListView e;
    private a f;
    private DownloadCenterSelectFileTitleView g;
    private View h;
    private List<c> i = new ArrayList();
    private List<c> j = new ArrayList();
    private String k;
    private com.xunlei.downloadprovider.personal.lixianspace.b.a l = new q(this);
    private MessageListener m = new s(this);
    private StaticHandler n = new StaticHandler(this.m);
    private SimpleLoadingPageView o;

    private class a extends BaseAdapter {
        final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;
        private TorrentFileInfo[] b;

        public final long getItemId(int i) {
            return 0;
        }

        public final int getCount() {
            return this.b.length;
        }

        public a(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity, TorrentFileInfo[] torrentFileInfoArr) {
            this.a = lXSpaceCreateTaskByMagnetUrlActivity;
            this.b = torrentFileInfoArr;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.layout_task_detail_bt_list_item, null);
                bVar = new b();
                bVar.b = (ZHTextView) view.findViewById(R.id.titleTextView);
                bVar.c = (TextView) view.findViewById(R.id.tagSize);
                bVar.a = (ImageView) view.findViewById(R.id.iconImageView);
                bVar.e = (TextView) view.findViewById(R.id.tagEpisode);
                bVar.d = (ImageView) view.findViewById(R.id.edit_mode_select_btn);
                view.setTag(bVar);
            }
            bVar = (b) view.getTag();
            c cVar = (c) this.a.i.get(i);
            bVar.b.setText(cVar.mFileName);
            bVar.b.requestLayout();
            bVar.c.setText(ConvertUtil.byteConvert(cVar.mFileSize));
            bVar.a.setImageResource(XLFileTypeUtil.getFileIconResId(cVar.mFileName));
            if (this.a.j.contains(cVar)) {
                bVar.d.setImageResource(R.drawable.big_selected);
            } else {
                bVar.d.setImageResource(R.drawable.big_unselected);
            }
            if (TextUtils.isEmpty(cVar.a)) {
                bVar.e.setVisibility(8);
            } else {
                bVar.e.setVisibility(0);
                bVar.e.setText(cVar.a);
            }
            return view;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.b[i];
        }
    }

    private static class b {
        public ImageView a;
        public ZHTextView b;
        public TextView c;
        public ImageView d;
        public TextView e;

        private b() {
        }
    }

    static class c extends TorrentFileInfo {
        public String a;

        c() {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_parse_bt_activity);
        this.k = getIntent().getStringExtra("extra:url");
        this.o = (SimpleLoadingPageView) findViewById(R.id.loading_view);
        this.a = (TextView) findViewById(R.id.download_btn);
        this.a.setOnClickListener(new m(this));
        this.g = (DownloadCenterSelectFileTitleView) findViewById(R.id.download_bt_select_file_title);
        this.g.setCancelListener(new j(this));
        this.g.setSelectAllListener(new k(this));
        this.g.b(false);
        this.e = (ListView) findViewById(R.id.bt_file_explorer_list);
        this.e.setOnItemClickListener(new l(this));
        this.h = findViewById(R.id.bt_file_explorer_progress);
        a.a.a(this.l);
        new k("lx_tag:default", (byte) 0).a(this.k, new v());
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    protected final long a() {
        long j = 0;
        for (c cVar : this.j) {
            j += cVar.mFileSize;
        }
        return j;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.clear();
        }
        if (this.j != null) {
            this.j.clear();
        }
        this.n.removeCallbacksAndMessages(null);
        c();
        a.a.b(this.l);
    }

    protected final void b() {
        com.xunlei.downloadprovider.download.report.a.g(NotificationADInfo.REPORT_STATUS_CLICK);
        this.o.setVisibility(0);
        this.o.setTip("正在创建");
        this.o.show();
        a.a.a(new p(this));
    }

    public static void a(Context context, String str) {
        Intent xLIntent = new XLIntent(context, LXSpaceCreateTaskByMagnetUrlActivity.class);
        if (!(context instanceof Activity)) {
            xLIntent.addFlags(268435456);
        }
        xLIntent.putExtra("extra:url", str);
        context.startActivity(xLIntent);
    }

    private void c() {
        this.o.setVisibility(8);
    }

    protected void onNewIntent(Intent intent) {
        this.e.setVisibility(8);
        this.h.setVisibility(0);
        setIntent(intent);
    }

    static /* synthetic */ void a(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity, boolean z) {
        if (z) {
            lXSpaceCreateTaskByMagnetUrlActivity.j.clear();
            for (c cVar : lXSpaceCreateTaskByMagnetUrlActivity.i) {
                if (!lXSpaceCreateTaskByMagnetUrlActivity.j.contains(cVar)) {
                    lXSpaceCreateTaskByMagnetUrlActivity.j.add(cVar);
                }
            }
        } else {
            lXSpaceCreateTaskByMagnetUrlActivity.j.clear();
        }
        if (lXSpaceCreateTaskByMagnetUrlActivity.f) {
            lXSpaceCreateTaskByMagnetUrlActivity.f.notifyDataSetChanged();
        }
    }

    static /* synthetic */ c a(TorrentFileInfo torrentFileInfo) {
        c cVar = new c();
        cVar.mFileIndex = torrentFileInfo.mFileIndex;
        cVar.mFileName = torrentFileInfo.mFileName;
        cVar.mFileSize = torrentFileInfo.mFileSize;
        cVar.mSubPath = torrentFileInfo.mSubPath;
        return cVar;
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.a == null) {
            cVar.a = "";
            com.xunlei.downloadprovider.download.util.e.a a = e.a(cVar.mFileName);
            if (a != null) {
                Object obj = "";
                if (a.b > 0) {
                    StringBuilder stringBuilder = new StringBuilder("第");
                    stringBuilder.append(a.b);
                    stringBuilder.append("集");
                    obj = stringBuilder.toString();
                }
                StringBuilder stringBuilder2;
                if (!TextUtils.isEmpty(a.d)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a.d);
                    stringBuilder2.append(" ");
                    stringBuilder2.append(obj);
                    obj = stringBuilder2.toString();
                } else if (a.a > 0) {
                    stringBuilder2 = new StringBuilder("第");
                    stringBuilder2.append(com.xunlei.xllib.b.c.a(a.a));
                    stringBuilder2.append("季 ");
                    stringBuilder2.append(obj);
                    obj = stringBuilder2.toString();
                }
                if (!TextUtils.isEmpty(obj)) {
                    cVar.a = obj;
                }
            }
        }
    }

    static /* synthetic */ void i(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        List arrayList = new ArrayList();
        int i = 0;
        long j = 0;
        int i2 = 0;
        long j2 = j;
        while (i2 < lXSpaceCreateTaskByMagnetUrlActivity.i.size()) {
            c cVar = (c) lXSpaceCreateTaskByMagnetUrlActivity.i.get(i2);
            long j3 = j2 + cVar.mFileSize;
            String toLowerCase = XLFileTypeUtil.extractFileExt(cVar.mFileName).toLowerCase();
            if (!(TextUtils.isEmpty(toLowerCase) || toLowerCase.equals(".") || toLowerCase.equals(".torrent") || toLowerCase.equals(".url") || toLowerCase.equals(com.xunlei.download.proguard.c.m) || toLowerCase.equals(".htm") || toLowerCase.equals(".mht") || cVar.mFileName.startsWith("__padding_file") || cVar.mFileName.equalsIgnoreCase("thumbs.db"))) {
                if (XLFileTypeUtil.getFileCategoryTypeByName(cVar.mFileName) == EFileCategoryType.E_PICTURE_CATEGORY) {
                    arrayList.add(cVar);
                    j += cVar.mFileSize;
                } else {
                    EFileCategoryType eFileCategoryType = EFileCategoryType.E_BOOK_CATEGORY;
                }
            }
            i2++;
            j2 = j3;
        }
        if (((double) j) > 0.1d * ((double) j2)) {
            while (i < arrayList.size()) {
                lXSpaceCreateTaskByMagnetUrlActivity.j.add(arrayList.get(i));
                i++;
            }
        }
    }
}
