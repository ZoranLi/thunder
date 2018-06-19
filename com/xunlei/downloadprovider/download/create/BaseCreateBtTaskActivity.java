package com.xunlei.downloadprovider.download.create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.create.widget.FileManagerListView;
import com.xunlei.xllib.android.e;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public abstract class BaseCreateBtTaskActivity extends BaseActivity implements OnClickListener {
    private static ArrayList<String> d;
    protected String a = null;
    protected boolean c = false;
    private boolean e = true;
    private a f = null;
    private int g = 0;
    private b h = null;
    private int i = -1;
    private volatile boolean j = false;
    private TitleBar k = null;
    private RelativeLayout l = null;
    private TextView m = null;
    private TextView n = null;
    private RelativeLayout o = null;
    private TextView p = null;
    private View q;
    private View r;
    private TextView s = null;
    private FileManagerListView t = null;
    private String u = com.xunlei.xllib.android.e.a.a();
    private String v = com.xunlei.xllib.android.e.a.b();
    private String w = null;
    private final FileFilter x = new k(this);
    private int y = 0;

    private static final class a extends Handler {
        private WeakReference<BaseCreateBtTaskActivity> a = null;

        public a(BaseCreateBtTaskActivity baseCreateBtTaskActivity) {
            this.a = new WeakReference(baseCreateBtTaskActivity);
        }

        public final void handleMessage(Message message) {
            BaseCreateBtTaskActivity baseCreateBtTaskActivity = (BaseCreateBtTaskActivity) this.a.get();
            if (baseCreateBtTaskActivity != null) {
                if (!baseCreateBtTaskActivity.isFinishing()) {
                    switch (message.what) {
                        case 4096:
                            baseCreateBtTaskActivity.l.getVisibility();
                            return;
                        case 4097:
                            baseCreateBtTaskActivity.m.setText(baseCreateBtTaskActivity.getString(R.string.bt_create_new_scanning));
                            baseCreateBtTaskActivity.n.setText(baseCreateBtTaskActivity.getString(R.string.bt_create_new_zero_file, new Object[]{Integer.valueOf(baseCreateBtTaskActivity.g)}));
                            return;
                        case 4098:
                            TextView b = baseCreateBtTaskActivity.m;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(baseCreateBtTaskActivity.getString(R.string.bt_create_new_scanning));
                            stringBuilder.append((String) message.obj);
                            b.setText(stringBuilder.toString());
                            baseCreateBtTaskActivity.n.setText(baseCreateBtTaskActivity.getString(R.string.bt_create_new_zero_file, new Object[]{Integer.valueOf(message.arg1)}));
                            return;
                        case FragmentTransaction.TRANSIT_FRAGMENT_FADE /*4099*/:
                            if (baseCreateBtTaskActivity.i != null) {
                                baseCreateBtTaskActivity.h = null;
                                if (baseCreateBtTaskActivity.e != null) {
                                    baseCreateBtTaskActivity.e = false;
                                }
                                baseCreateBtTaskActivity.l.setVisibility(8);
                                baseCreateBtTaskActivity.k.mRightIv.setVisibility(0);
                                baseCreateBtTaskActivity.a(1);
                                if (BaseCreateBtTaskActivity.d.isEmpty() != null) {
                                    baseCreateBtTaskActivity.o.setVisibility(0);
                                }
                                baseCreateBtTaskActivity.t.c();
                                baseCreateBtTaskActivity.t.b(BaseCreateBtTaskActivity.d);
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
        final /* synthetic */ BaseCreateBtTaskActivity a;

        private b(BaseCreateBtTaskActivity baseCreateBtTaskActivity) {
            this.a = baseCreateBtTaskActivity;
        }

        public final void run() {
            BaseCreateBtTaskActivity.d = this.a.a(BaseCreateBtTaskActivity.m(this.a));
            this.a.f.removeMessages(4098);
            this.a.f.sendEmptyMessage(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
    }

    public abstract void a(String str, int i);

    public void onCreate(Bundle bundle) {
        List arrayList;
        super.onCreate(bundle);
        a(getIntent(), false);
        setContentView(R.layout.activity_create_bt_task);
        this.k = new TitleBar((Activity) this);
        this.k.mLeft.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        this.k.mTitle.setText(R.string.createtask_addbt);
        this.k.mRightIv.setImageResource(R.drawable.bt_btn_refresh_selector);
        this.k.mRightIv.setVisibility(4);
        this.l = (RelativeLayout) findViewById(R.id.bt_create_new_wait_layout);
        this.m = (TextView) findViewById(R.id.bt_create_new_scanpath);
        this.n = (TextView) findViewById(R.id.bt_create_new_scannum);
        this.m.setTextColor(-16777216);
        this.n.setTextColor(-16777216);
        this.o = (RelativeLayout) findViewById(R.id.bt_create_new_empty_layout);
        this.p = (TextView) findViewById(R.id.bt_create_new_cancel);
        this.p.setTextColor(-12171706);
        this.p.setOnClickListener(this);
        this.r = findViewById(R.id.bt_create_auto);
        this.r.setOnClickListener(this);
        this.q = findViewById(R.id.bt_create_manual);
        this.q.setOnClickListener(this);
        this.k.mLeft.setOnClickListener(this);
        this.k.mRightIv.setOnClickListener(this);
        String str = this.w;
        this.s = (TextView) findViewById(R.id.bt_create_new_path);
        this.t = (FileManagerListView) findViewById(R.id.bt_create_new_file_list);
        this.t.setPathView(this.s);
        this.t.setNeedMoreInfo(false);
        if (!(this.v == null || this.v.length() == 0)) {
            if (e.b(this.v) != 0) {
                if (!(this.u == null || this.u.length() == 0)) {
                    if (e.b(this.u) != 0) {
                        FileManagerListView fileManagerListView = this.t;
                        List arrayList2 = new ArrayList();
                        File file = new File(this.u);
                        av avVar = new av();
                        StringBuilder stringBuilder = new StringBuilder("/");
                        stringBuilder.append(getString(R.string.primary_sdcard));
                        avVar.h = stringBuilder.toString();
                        avVar.b(getString(R.string.primary_sdcard_name));
                        avVar.c = file.getAbsolutePath();
                        if (file.isDirectory()) {
                            avVar.f = EFileCategoryType.E_XLDIR_CATEGORY;
                        }
                        arrayList2.add(avVar);
                        if (this.v != null) {
                            file = new File(this.v);
                            avVar = new av();
                            stringBuilder = new StringBuilder("/");
                            stringBuilder.append(getString(R.string.saved_sdcard));
                            avVar.h = stringBuilder.toString();
                            avVar.b(getString(R.string.saved_sdcard_name));
                            avVar.c = file.getAbsolutePath();
                            if (file.isDirectory()) {
                                avVar.f = EFileCategoryType.E_XLDIR_CATEGORY;
                            }
                            arrayList2.add(avVar);
                        }
                        fileManagerListView.setHomePageData(arrayList2);
                        this.t.setLimitInDirectory("///homepage");
                        if (str == null) {
                            str = "///homepage";
                        }
                        arrayList = new ArrayList();
                        arrayList.add(".torrent");
                        this.t.a(str, arrayList);
                        this.t.setOnFileOperateListener(new l(this));
                        this.g = 0;
                        if (d != null) {
                            d = new ArrayList();
                        } else if (d.isEmpty() == null) {
                            this.e = false;
                        }
                        this.f = new a(this);
                        a(0);
                    }
                }
                this.t.setLimitInDirectory(this.v);
                if (str == null) {
                    str = this.v;
                }
                arrayList = new ArrayList();
                arrayList.add(".torrent");
                this.t.a(str, arrayList);
                this.t.setOnFileOperateListener(new l(this));
                this.g = 0;
                if (d != null) {
                    d = new ArrayList();
                } else if (d.isEmpty() == null) {
                    this.e = false;
                }
                this.f = new a(this);
                a(0);
            }
        }
        this.t.setLimitInDirectory(this.u);
        if (str == null) {
            str = this.u;
        }
        arrayList = new ArrayList();
        arrayList.add(".torrent");
        this.t.a(str, arrayList);
        this.t.setOnFileOperateListener(new l(this));
        this.g = 0;
        if (d != null) {
            d = new ArrayList();
        } else if (d.isEmpty() == null) {
            this.e = false;
        }
        this.f = new a(this);
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

    public void onDestroy() {
        super.onDestroy();
        a(false);
        this.f.removeMessages(4098);
        this.f.removeMessages(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }

    public void onBackPressed() {
        int i = 1;
        if (this.i == 0) {
            i = 1 ^ this.t.b();
        }
        if (i != 0) {
            finish();
        }
    }

    private void a(Intent intent, boolean z) {
        this.w = intent.getStringExtra("last_torrent_open_path");
        intent = intent.getData();
        if (intent != null) {
            this.a = intent.getPath();
            if (this.a.substring(this.a.lastIndexOf(".")).equalsIgnoreCase(".torrent") == null) {
                if (z) {
                    moveTaskToBack(true);
                    return;
                }
                finish();
            }
        }
    }

    private void a(int i) {
        if (this.i != i) {
            if (this.y == 0) {
                this.y = DipPixelUtil.dip2px(10.0f);
            }
            this.i = i;
            switch (i) {
                case 0:
                    this.s.setVisibility(0);
                    this.q.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_hover);
                    this.r.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_normal);
                    this.o.setVisibility(8);
                    this.k.mRightIv.setVisibility(4);
                    return;
                case 1:
                    this.s.setVisibility(8);
                    this.q.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_normal);
                    this.r.setBackgroundResource(R.drawable.bt_new_task_bottom_bg_hover);
                    if (this.e == 0) {
                        this.k.mRightIv.setVisibility(0);
                        return;
                    }
                    break;
                case 2:
                    this.t.c();
                    break;
                default:
                    break;
            }
        }
    }

    private ArrayList<String> a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size && !Thread.currentThread().isInterrupted() && this.j; i++) {
            String str = (String) list.get(i);
            if (!(str == null || str.length() == 0 || Thread.currentThread().isInterrupted() || !this.j)) {
                File file = new File(str);
                if (file.exists() && !file.getName().startsWith(".")) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles(this.x);
                        if (listFiles != null && listFiles.length > 0) {
                            int i2 = 0;
                            while (i2 < listFiles.length && !Thread.currentThread().isInterrupted() && this.j) {
                                if (listFiles[i2].isDirectory()) {
                                    if (!(listFiles[i2].getName().startsWith(".") || listFiles[i2].getName().equals("com.android.fileexplorer"))) {
                                        List arrayList2 = new ArrayList();
                                        arrayList2.add(listFiles[i2].getPath());
                                        Collection a = a(arrayList2);
                                        if (!a.isEmpty()) {
                                            arrayList.addAll(a);
                                        }
                                    }
                                } else if (listFiles[i2].isFile() && listFiles[i2].getName().endsWith(".torrent")) {
                                    arrayList.add(listFiles[i2].getPath());
                                    this.g++;
                                }
                                i2++;
                            }
                        }
                        this.f.obtainMessage(4098, this.g, 0, file.getPath()).sendToTarget();
                    } else if (file.isFile() && file.getName().toLowerCase(Locale.getDefault()).endsWith(".torrent")) {
                        arrayList.add(file.getPath());
                    }
                }
            }
        }
        return arrayList;
    }

    private void b() {
        if (this.h == null) {
            this.g = 0;
            this.f.sendEmptyMessage(4097);
            this.h = new b();
            this.h.start();
            this.j = true;
        }
    }

    private void a(boolean z) {
        if (!(this.h == null || this.h.isInterrupted())) {
            this.h.interrupt();
            if (!z) {
                this.l.setVisibility(8);
            }
        }
        this.j = false;
        this.h = null;
        this.g = d.size();
        if (z) {
            this.l.setVisibility(8);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_create_new_cancel:
                a(true);
                a(1);
                break;
            case R.id.bt_create_manual:
                com.xunlei.downloadprovider.download.report.a.g("task_create");
                if (this.i == 1 || this.i == 2) {
                    a(false);
                    a(0);
                    this.t.c();
                    this.t.setNeedMoreInfo(false);
                    view = new ArrayList();
                    view.add(".torrent");
                    if (!(this.v == null || this.v.length() == 0)) {
                        if (e.b(this.v) != 0) {
                            if (!(this.u == null || this.u.length() == 0)) {
                                if (e.b(this.u) != 0) {
                                    this.t.b("///homepage", view);
                                    return;
                                }
                            }
                            this.t.b(this.v, view);
                            return;
                        }
                    }
                    this.t.b(this.u, view);
                    return;
                }
            case R.id.bt_create_auto:
                com.xunlei.downloadprovider.download.report.a.g("task_auto");
                if (this.i == null) {
                    a(1);
                    this.t.setNeedMoreInfo(true);
                    if (this.e == null) {
                        if (d.isEmpty() != null) {
                            this.o.setVisibility(0);
                        }
                        this.t.a(d);
                        return;
                    } else if (d.isEmpty() != null) {
                        this.t.a(d);
                        this.o.setVisibility(8);
                        this.f.sendEmptyMessage(4096);
                        this.l.setVisibility(0);
                        this.k.mRightIv.setVisibility(4);
                        a(2);
                        b();
                        return;
                    } else {
                        this.o.setVisibility(8);
                        this.k.mRightIv.setVisibility(0);
                        this.e = false;
                        this.t.a(d);
                        return;
                    }
                }
                break;
            case R.id.titlebar_left:
                finish();
                return;
            case R.id.titlebar_right_iv:
                this.e = false;
                this.k.mRightIv.setVisibility(4);
                this.l.setVisibility(0);
                this.o.setVisibility(8);
                this.t.a(d);
                a(2);
                this.f.sendEmptyMessage(4096);
                b();
                return;
            default:
                break;
        }
    }

    static /* synthetic */ ArrayList m(BaseCreateBtTaskActivity baseCreateBtTaskActivity) {
        ArrayList arrayList = new ArrayList();
        Object obj = null;
        Object obj2 = (baseCreateBtTaskActivity.v == null || baseCreateBtTaskActivity.v.length() == 0 || e.b(baseCreateBtTaskActivity.v) <= 0) ? null : 1;
        if (!(baseCreateBtTaskActivity.u == null || baseCreateBtTaskActivity.u.length() == 0 || e.b(baseCreateBtTaskActivity.u) <= 0)) {
            obj = 1;
        }
        if (obj2 == null || obj == null) {
            if (obj != null) {
                arrayList.add(baseCreateBtTaskActivity.u);
            } else if (obj2 != null) {
                arrayList.add(baseCreateBtTaskActivity.v);
            }
        } else if (baseCreateBtTaskActivity.u.contains(baseCreateBtTaskActivity.v)) {
            arrayList.add(baseCreateBtTaskActivity.v);
        } else if (baseCreateBtTaskActivity.v.contains(baseCreateBtTaskActivity.u)) {
            arrayList.add(baseCreateBtTaskActivity.u);
        } else {
            arrayList.add(baseCreateBtTaskActivity.u);
            arrayList.add(baseCreateBtTaskActivity.v);
        }
        return arrayList;
    }
}
