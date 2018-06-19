package com.xunlei.downloadprovider.download;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.create.av;
import com.xunlei.downloadprovider.download.create.widget.FileManagerListView;
import com.xunlei.xllib.android.e;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class XLFileExploreActivity extends BaseActivity implements OnClickListener {
    private static ArrayList<String> e;
    private final FileFilter A = new d(this);
    private int B = 0;
    protected String a = null;
    protected boolean c = false;
    private final List<String> d = new ArrayList();
    private boolean f = true;
    private a g = null;
    private int h = 0;
    private b i = null;
    private int j = -1;
    private volatile boolean k = false;
    private TitleBar l = null;
    private String m;
    private boolean n;
    private RelativeLayout o = null;
    private TextView p = null;
    private TextView q = null;
    private RelativeLayout r = null;
    private TextView s = null;
    private View t;
    private View u;
    private TextView v = null;
    private FileManagerListView w = null;
    private String x = com.xunlei.xllib.android.e.a.a();
    private String y = com.xunlei.xllib.android.e.a.b();
    private String z = null;

    private static final class a extends Handler {
        private WeakReference<XLFileExploreActivity> a = null;

        public a(XLFileExploreActivity xLFileExploreActivity) {
            this.a = new WeakReference(xLFileExploreActivity);
        }

        public final void handleMessage(Message message) {
            XLFileExploreActivity xLFileExploreActivity = (XLFileExploreActivity) this.a.get();
            if (xLFileExploreActivity != null) {
                if (!xLFileExploreActivity.isFinishing()) {
                    switch (message.what) {
                        case 4096:
                            xLFileExploreActivity.o.getVisibility();
                            return;
                        case 4097:
                            xLFileExploreActivity.p.setText(xLFileExploreActivity.getString(R.string.bt_create_new_scanning));
                            xLFileExploreActivity.q.setText(xLFileExploreActivity.getString(R.string.bt_create_new_zero_file, new Object[]{Integer.valueOf(xLFileExploreActivity.h)}));
                            return;
                        case 4098:
                            TextView b = xLFileExploreActivity.p;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(xLFileExploreActivity.getString(R.string.bt_create_new_scanning));
                            stringBuilder.append((String) message.obj);
                            b.setText(stringBuilder.toString());
                            xLFileExploreActivity.q.setText(xLFileExploreActivity.getString(R.string.bt_create_new_zero_file, new Object[]{Integer.valueOf(message.arg1)}));
                            return;
                        case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                            if (xLFileExploreActivity.j != null) {
                                xLFileExploreActivity.i = null;
                                if (xLFileExploreActivity.f != null) {
                                    xLFileExploreActivity.f = false;
                                }
                                xLFileExploreActivity.o.setVisibility(8);
                                xLFileExploreActivity.l.mRightIv.setVisibility(0);
                                xLFileExploreActivity.a(1);
                                if (XLFileExploreActivity.e.isEmpty() != null) {
                                    xLFileExploreActivity.r.setVisibility(0);
                                }
                                xLFileExploreActivity.w.c();
                                xLFileExploreActivity.w.b(XLFileExploreActivity.e);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private final class b extends Thread {
        final /* synthetic */ XLFileExploreActivity a;

        private b(XLFileExploreActivity xLFileExploreActivity) {
            this.a = xLFileExploreActivity;
        }

        public final void run() {
            XLFileExploreActivity.e = this.a.a(XLFileExploreActivity.m(this.a));
            this.a.g.removeMessages(4098);
            this.a.g.sendEmptyMessage(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent(activity, XLFileExploreActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("hide_bottom", true);
        activity.startActivityForResult(intent, 790);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent(), false);
        setContentView(R.layout.activity_xlfile_explore);
        this.l = new TitleBar((Activity) this);
        this.l.mLeft.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        if (TextUtils.isEmpty(this.m) != null) {
            this.l.mTitle.setText(R.string.createtask_addbt);
        } else {
            this.l.mTitle.setText(this.m);
        }
        this.l.mRightIv.setImageResource(R.drawable.bt_btn_refresh_selector);
        this.l.mRightIv.setVisibility(4);
        this.o = (RelativeLayout) findViewById(R.id.bt_create_new_wait_layout);
        this.p = (TextView) findViewById(R.id.bt_create_new_scanpath);
        this.q = (TextView) findViewById(R.id.bt_create_new_scannum);
        this.p.setTextColor(-16777216);
        this.q.setTextColor(-16777216);
        this.r = (RelativeLayout) findViewById(R.id.bt_create_new_empty_layout);
        this.s = (TextView) findViewById(R.id.bt_create_new_cancel);
        this.s.setTextColor(-12171706);
        this.s.setOnClickListener(this);
        this.u = findViewById(R.id.file_scan_auto);
        this.u.setOnClickListener(this);
        this.t = findViewById(R.id.file_scan_manual);
        this.t.setOnClickListener(this);
        bundle = findViewById(R.id.file_explore_bottom_op);
        if (this.n) {
            bundle.setVisibility(8);
        }
        this.l.mLeft.setOnClickListener(this);
        this.l.mRightIv.setOnClickListener(this);
        String str = this.z;
        this.v = (TextView) findViewById(R.id.file_scan_path);
        this.w = (FileManagerListView) findViewById(R.id.file_list);
        this.w.setPathView(this.v);
        this.w.setNeedMoreInfo(false);
        if (!(this.y == null || this.y.length() == 0)) {
            if (e.b(this.y) != 0) {
                if (!(this.x == null || this.x.length() == 0)) {
                    if (e.b(this.x) != 0) {
                        FileManagerListView fileManagerListView = this.w;
                        List arrayList = new ArrayList();
                        File file = new File(this.x);
                        av avVar = new av();
                        StringBuilder stringBuilder = new StringBuilder("/");
                        stringBuilder.append(getString(R.string.primary_sdcard));
                        avVar.h = stringBuilder.toString();
                        avVar.b(getString(R.string.primary_sdcard_name));
                        avVar.c = file.getAbsolutePath();
                        if (file.isDirectory()) {
                            avVar.f = EFileCategoryType.E_XLDIR_CATEGORY;
                        }
                        arrayList.add(avVar);
                        if (this.y != null) {
                            file = new File(this.y);
                            avVar = new av();
                            stringBuilder = new StringBuilder("/");
                            stringBuilder.append(getString(R.string.saved_sdcard));
                            avVar.h = stringBuilder.toString();
                            avVar.b(getString(R.string.saved_sdcard_name));
                            avVar.c = file.getAbsolutePath();
                            if (file.isDirectory()) {
                                avVar.f = EFileCategoryType.E_XLDIR_CATEGORY;
                            }
                            arrayList.add(avVar);
                        }
                        fileManagerListView.setHomePageData(arrayList);
                        this.w.setLimitInDirectory("///homepage");
                        if (str == null) {
                            str = "///homepage";
                        }
                        this.w.a(str, this.d);
                        this.w.setOnFileOperateListener(new e(this));
                        this.h = 0;
                        if (e != null) {
                            e = new ArrayList();
                        } else if (e.isEmpty() == null) {
                            this.f = false;
                        }
                        this.g = new a(this);
                        a(0);
                    }
                }
                this.w.setLimitInDirectory(this.y);
                if (str == null) {
                    str = this.y;
                }
                this.w.a(str, this.d);
                this.w.setOnFileOperateListener(new e(this));
                this.h = 0;
                if (e != null) {
                    e = new ArrayList();
                } else if (e.isEmpty() == null) {
                    this.f = false;
                }
                this.g = new a(this);
                a(0);
            }
        }
        this.w.setLimitInDirectory(this.x);
        if (str == null) {
            str = this.x;
        }
        this.w.a(str, this.d);
        this.w.setOnFileOperateListener(new e(this));
        this.h = 0;
        if (e != null) {
            e = new ArrayList();
        } else if (e.isEmpty() == null) {
            this.f = false;
        }
        this.g = new a(this);
        a(0);
    }

    protected void onNewIntent(Intent intent) {
        this.c = false;
        setIntent(intent);
        a(intent, true);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    protected void onDestroy() {
        super.onDestroy();
        a(false);
        this.g.removeMessages(4098);
        this.g.removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }

    public void onBackPressed() {
        int i = 1;
        if (this.j == 0) {
            i = 1 ^ this.w.b();
        }
        if (i != 0) {
            finish();
        }
    }

    private void a(Intent intent, boolean z) {
        this.z = intent.getStringExtra("last_torrent_open_path");
        this.m = intent.getStringExtra("title");
        Collection stringArrayListExtra = intent.getStringArrayListExtra("filters");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            this.d.addAll(stringArrayListExtra);
        }
        this.n = intent.getBooleanExtra("hide_bottom", false);
        intent = intent.getData();
        if (intent != null) {
            this.a = intent.getPath();
            if (b(this.a) != null) {
                if (z) {
                    moveTaskToBack(true);
                    return;
                }
                finish();
            }
        }
    }

    private void a(int i) {
        if (this.j != i) {
            if (this.B == 0) {
                this.B = DipPixelUtil.dip2px(10.0f);
            }
            this.j = i;
            switch (i) {
                case 0:
                    this.v.setVisibility(0);
                    this.t.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_hover);
                    this.u.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_normal);
                    this.r.setVisibility(8);
                    this.l.mRightIv.setVisibility(4);
                    return;
                case 1:
                    this.v.setVisibility(8);
                    this.t.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_normal);
                    this.u.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_hover);
                    if (this.f == 0) {
                        this.l.mRightIv.setVisibility(0);
                        return;
                    }
                    break;
                case 2:
                    this.w.c();
                    break;
                default:
                    break;
            }
        }
    }

    private ArrayList<String> a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size && !Thread.currentThread().isInterrupted() && this.k; i++) {
            String str = (String) list.get(i);
            if (!(str == null || str.length() == 0 || Thread.currentThread().isInterrupted() || !this.k)) {
                File file = new File(str);
                if (file.exists() && !file.getName().startsWith(".")) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(this.A);
                        if (listFiles != null && listFiles.length > 0) {
                            int i2 = 0;
                            while (i2 < listFiles.length && !Thread.currentThread().isInterrupted() && this.k) {
                                if (listFiles[i2].isDirectory()) {
                                    if (!(listFiles[i2].getName().startsWith(".") || listFiles[i2].getName().equals("com.android.fileexplorer"))) {
                                        List arrayList2 = new ArrayList();
                                        arrayList2.add(listFiles[i2].getPath());
                                        Collection a = a(arrayList2);
                                        if (!a.isEmpty()) {
                                            arrayList.addAll(a);
                                        }
                                    }
                                } else if (listFiles[i2].isFile() && b(listFiles[i2].getName())) {
                                    arrayList.add(listFiles[i2].getPath());
                                    this.h++;
                                }
                                i2++;
                            }
                        }
                        this.g.obtainMessage(4098, this.h, 0, file.getPath()).sendToTarget();
                    } else if (file.isFile() && b(file.getName().toLowerCase(Locale.getDefault()))) {
                        arrayList.add(file.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean b(String str) {
        return this.d.contains(com.xunlei.downloadprovider.h.e.a(str));
    }

    private void b() {
        if (this.i == null) {
            this.h = 0;
            this.g.sendEmptyMessage(4097);
            this.i = new b();
            this.i.start();
            this.k = true;
        }
    }

    private void a(boolean z) {
        if (!(this.i == null || this.i.isInterrupted())) {
            this.i.interrupt();
            if (!z) {
                this.o.setVisibility(8);
            }
        }
        this.k = false;
        this.i = null;
        this.h = e.size();
        if (z) {
            this.o.setVisibility(8);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_create_new_cancel:
                a(true);
                a(1);
                break;
            case R.id.file_scan_manual:
                com.xunlei.downloadprovider.download.report.a.g("task_create");
                if (this.j == 1 || this.j == 2) {
                    a(false);
                    a(0);
                    this.w.c();
                    this.w.setNeedMoreInfo(false);
                    if (!(this.y == null || this.y.length() == null)) {
                        if (e.b(this.y) != 0) {
                            if (!(this.x == null || this.x.length() == null)) {
                                if (e.b(this.x) != 0) {
                                    this.w.b("///homepage", this.d);
                                    return;
                                }
                            }
                            this.w.b(this.y, this.d);
                            return;
                        }
                    }
                    this.w.b(this.x, this.d);
                    return;
                }
            case R.id.file_scan_auto:
                com.xunlei.downloadprovider.download.report.a.g("task_auto");
                if (this.j == null) {
                    a(1);
                    this.w.setNeedMoreInfo(true);
                    if (this.f == null) {
                        if (e.isEmpty() != null) {
                            this.r.setVisibility(0);
                        }
                        this.w.a(e);
                        return;
                    } else if (e.isEmpty() != null) {
                        this.w.a(e);
                        this.r.setVisibility(8);
                        this.g.sendEmptyMessage(4096);
                        this.o.setVisibility(0);
                        this.l.mRightIv.setVisibility(4);
                        a(2);
                        b();
                        return;
                    } else {
                        this.r.setVisibility(8);
                        this.l.mRightIv.setVisibility(0);
                        this.f = false;
                        this.w.a(e);
                        return;
                    }
                }
                break;
            case R.id.titlebar_left:
                finish();
                return;
            case R.id.titlebar_right_iv:
                this.f = false;
                this.l.mRightIv.setVisibility(4);
                this.o.setVisibility(0);
                this.r.setVisibility(8);
                this.w.a(e);
                a(2);
                this.g.sendEmptyMessage(4096);
                b();
                return;
            default:
                break;
        }
    }

    protected final void a(String str) {
        Intent intent = new Intent();
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        intent.setData(Uri.fromFile(new File(str)));
        setResult(-1, intent);
        finish();
    }

    static /* synthetic */ ArrayList m(XLFileExploreActivity xLFileExploreActivity) {
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        Object obj2 = (xLFileExploreActivity.y == null || xLFileExploreActivity.y.length() == 0 || e.b(xLFileExploreActivity.y) <= 0) ? null : 1;
        if (!(xLFileExploreActivity.x == null || xLFileExploreActivity.x.length() == 0 || e.b(xLFileExploreActivity.x) <= 0)) {
            obj = 1;
        }
        if (obj2 == null || obj == null) {
            if (obj != null) {
                arrayList.add(xLFileExploreActivity.x);
            } else if (obj2 != null) {
                arrayList.add(xLFileExploreActivity.y);
            }
        } else if (xLFileExploreActivity.x.contains(xLFileExploreActivity.y)) {
            arrayList.add(xLFileExploreActivity.y);
        } else if (xLFileExploreActivity.y.contains(xLFileExploreActivity.x)) {
            arrayList.add(xLFileExploreActivity.x);
        } else {
            arrayList.add(xLFileExploreActivity.x);
            arrayList.add(xLFileExploreActivity.y);
        }
        return arrayList;
    }
}
