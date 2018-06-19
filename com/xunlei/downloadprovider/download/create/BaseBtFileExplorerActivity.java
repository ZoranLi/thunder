package com.xunlei.downloadprovider.download.create;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.androidutil.HandlerUtil$MessageListener;
import com.xunlei.common.androidutil.HandlerUtil$StaticHandler;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.SimpleLoadingPageView;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.download.TorrentParser;
import com.xunlei.download.TorrentParser$OnTorrentParserListener;
import com.xunlei.download.TorrentParser.ParseResult;
import com.xunlei.download.TorrentParser.ParseResult.Code;
import com.xunlei.download.proguard.c;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.util.e;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseBtFileExplorerActivity extends BaseActivity implements TorrentParser$OnTorrentParserListener {
    protected TextView a;
    protected long c = -1;
    protected String d;
    protected String e;
    XLAlertDialog f = null;
    protected String g = DLCenterEntry.file_bt_in.toString();
    protected int h;
    protected HandlerUtil$StaticHandler i = new HandlerUtil$StaticHandler(this.u);
    private TextView j;
    private SimpleLoadingPageView k;
    private ListView l;
    private a m;
    private DownloadCenterSelectFileTitleView n;
    private TextView o;
    private View p;
    private String q;
    private int[] r;
    private List<c> s = new ArrayList();
    private List<c> t = new ArrayList();
    private HandlerUtil$MessageListener u = new a(this);
    private String v;

    public abstract void a();

    public void a(Message message) {
    }

    public abstract void a(long[] jArr);

    public boolean g() {
        return true;
    }

    public void onTorrentParseBegin() {
    }

    public static Bundle a(String str, long j, int i, String str2, String str3, String str4) {
        Bundle bundle = new Bundle(9);
        bundle.putLong("taskId", j);
        bundle.putInt("reportType", i);
        j = "createOriginFrom";
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString(j, str2);
        j = "refurl";
        if (str3 == null) {
            str3 = "";
        }
        bundle.putString(j, str3);
        j = "website";
        if (str4 == null) {
            str4 = "";
        }
        bundle.putString(j, str4);
        j = "backup_torrent_path";
        if (str == null) {
            str = "";
        }
        bundle.putString(j, str);
        return bundle;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_download_bt_explorer);
        bundle = getIntent();
        this.c = bundle.getLongExtra("taskId", -1);
        this.h = bundle.getIntExtra("reportType", -1);
        this.v = bundle.getStringExtra("quit_way");
        this.q = bundle.getStringExtra("backup_torrent_path");
        if ("android.intent.action.VIEW".equals(bundle.getAction()) != null) {
            this.g = DLCenterEntry.file_bt.toString();
        }
        this.a = (TextView) findViewById(R.id.download_btn);
        this.a.setOnClickListener(new g(this));
        this.n = (DownloadCenterSelectFileTitleView) findViewById(R.id.download_bt_select_file_title);
        this.n.setCancelListener(new d(this));
        this.n.setSelectAllListener(new e(this));
        this.n.b(false);
        this.l = (ListView) findViewById(R.id.bt_file_explorer_list);
        this.l.setOnItemClickListener(new f(this));
        this.o = (TextView) findViewById(R.id.storage_info);
        bundle = ConvertUtil.byteConvert(DownloadConfig.getStorageAvailableSize(this));
        this.o.setText(getString(R.string.download_bt_list_select, new Object[]{"0B", bundle}));
        this.p = findViewById(R.id.bt_file_explorer_progress);
        this.k = (SimpleLoadingPageView) findViewById(R.id.loading_view);
        this.j = (TextView) findViewById(R.id.mask_view);
        this.j.setOnClickListener(new c(this));
        bundle = new TorrentParser(this, this);
        try {
            File file = new File(URI.create(getIntent().getDataString()));
            if (!(file.exists() || TextUtils.isEmpty(this.q))) {
                file = new File(this.q);
            }
            bundle.parse(file, this.c, true);
        } catch (Bundle bundle2) {
            bundle2.printStackTrace();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    private void a(boolean z) {
        if (z) {
            this.a.setClickable(true);
            this.a.setBackgroundDrawable(getResources().getDrawable(R.drawable.task_btn_normal_blue_bg));
            return;
        }
        this.a.setClickable(false);
        this.a.setBackgroundDrawable(getResources().getDrawable(R.drawable.task_bt_list_disable_bg));
    }

    protected final void b() {
        this.k.setVisibility(8);
        this.j.setVisibility(8);
    }

    private void h() {
        String byteConvert = ConvertUtil.byteConvert(DownloadConfig.getStorageAvailableSize(this));
        if (this.t.size() != 0) {
            String byteConvert2 = ConvertUtil.byteConvert(c());
            DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView = this.n;
            StringBuilder stringBuilder = new StringBuilder("已选择");
            stringBuilder.append(this.t.size());
            stringBuilder.append("个项目");
            downloadCenterSelectFileTitleView.setTitle(stringBuilder.toString());
            this.o.setText(getString(R.string.download_bt_list_select, new Object[]{byteConvert2, byteConvert}));
            a(true);
        } else {
            this.n.setTitle("请选择文件");
            this.o.setText(getString(R.string.download_bt_list_select, new Object[]{"0B", byteConvert}));
            a(false);
        }
        if (this.t.size() == this.s.size()) {
            this.n.a(false);
        } else {
            this.n.a(true);
        }
    }

    protected final long c() {
        long j = 0;
        for (c cVar : this.t) {
            j += cVar.mFileSize;
        }
        return j;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.s != null) {
            this.s.clear();
        }
        if (this.t != null) {
            this.t.clear();
        }
        this.i.removeCallbacksAndMessages(null);
    }

    public void onTorrentParseCompleted(ParseResult parseResult) {
        if (parseResult.code == Code.NO_ERROR) {
            this.d = parseResult.torrentInfo.mInfoHash;
            this.r = parseResult.selectedSet.mIndexSet;
            this.e = parseResult.torrentInfo.mMultiFileBaseFolder;
            XLThreadPool.execute(new j(this, parseResult.torrentInfo.mSubFileInfo, parseResult));
            return;
        }
        Toast.makeText(this, "种子文件解析失败", 0).show();
        finish();
    }

    protected final void d() {
        a.g(NotificationADInfo.REPORT_STATUS_CLICK);
        this.k.setVisibility(0);
        this.k.setTip("正在创建");
        this.j.setVisibility(0);
        this.k.show();
        XLThreadPool.execute(new b(this));
    }

    private boolean a(int i) {
        if (this.c != -1 && g()) {
            for (int i2 : this.r) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void onNewIntent(Intent intent) {
        this.l.setVisibility(8);
        this.p.setVisibility(0);
        h();
        setIntent(intent);
    }

    static /* synthetic */ void a(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        baseBtFileExplorerActivity.finish();
        if (!"finish_only".equals(baseBtFileExplorerActivity.v)) {
            baseBtFileExplorerActivity.a();
        }
    }

    static /* synthetic */ void c(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        List arrayList = new ArrayList();
        int i = 0;
        long j = 0;
        int i2 = 0;
        long j2 = j;
        while (i2 < baseBtFileExplorerActivity.s.size()) {
            c cVar = (c) baseBtFileExplorerActivity.s.get(i2);
            long j3 = j2 + cVar.mFileSize;
            String toLowerCase = XLFileTypeUtil.extractFileExt(cVar.mFileName).toLowerCase();
            if (baseBtFileExplorerActivity.a(cVar.mFileIndex)) {
                baseBtFileExplorerActivity.t.add(cVar);
            }
            if (!(TextUtils.isEmpty(toLowerCase) || toLowerCase.equals(".") || toLowerCase.equals(".torrent") || toLowerCase.equals(".url") || toLowerCase.equals(c.m) || toLowerCase.equals(".htm") || toLowerCase.equals(".mht") || cVar.mFileName.startsWith("__padding_file") || cVar.mFileName.equalsIgnoreCase("thumbs.db"))) {
                EFileCategoryType fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(cVar.mFileName);
                if (fileCategoryTypeByName == EFileCategoryType.E_PICTURE_CATEGORY) {
                    arrayList.add(cVar);
                    j += cVar.mFileSize;
                } else if (fileCategoryTypeByName != EFileCategoryType.E_BOOK_CATEGORY || cVar.mFileSize >= 15360) {
                    baseBtFileExplorerActivity.t.add(cVar);
                }
            }
            i2++;
            j2 = j3;
        }
        if (((double) j) > 0.1d * ((double) j2)) {
            while (i < arrayList.size()) {
                baseBtFileExplorerActivity.t.add(arrayList.get(i));
                i++;
            }
        }
    }

    static /* synthetic */ void a(BaseBtFileExplorerActivity baseBtFileExplorerActivity, boolean z) {
        if (z) {
            baseBtFileExplorerActivity.t.clear();
            for (c cVar : baseBtFileExplorerActivity.s) {
                if (!baseBtFileExplorerActivity.t.contains(cVar)) {
                    baseBtFileExplorerActivity.t.add(cVar);
                }
            }
        } else {
            baseBtFileExplorerActivity.t.clear();
        }
        if (baseBtFileExplorerActivity.m) {
            baseBtFileExplorerActivity.m.notifyDataSetChanged();
        }
        baseBtFileExplorerActivity.h();
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
            e.a a = e.a(cVar.mFileName);
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
}
