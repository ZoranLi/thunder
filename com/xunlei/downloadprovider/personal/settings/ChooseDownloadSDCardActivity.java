package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.personal.settings.ui.SDCardViewHolder;
import com.xunlei.downloadprovider.publiser.per.br;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.e;
import com.xunlei.xllib.android.e.a;
import java.io.File;

public class ChooseDownloadSDCardActivity extends BaseActivity {
    private String a = getClass().getSimpleName();
    private View c;
    private View d;
    private SDCardViewHolder e;
    private SDCardViewHolder f;
    private String g;
    private String h;
    private String i = DispatchConstants.OTHER;

    public static void a(Context context) {
        context.startActivity(new XLIntent(context, ChooseDownloadSDCardActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_choose_download_sdcard);
        new TitleBar((Activity) this).mTitle.setText(R.string.sett_choose_sdcard);
        this.c = findViewById(R.id.filemanager_nosdcard_layout);
        this.d = findViewById(R.id.sdcard_layout);
        this.g = a.a();
        this.h = a.b();
        new StringBuilder("storage primary:").append(this.g);
        new StringBuilder("storage secondary:").append(this.h);
        if (TextUtils.isEmpty(this.g) == null || TextUtils.isEmpty(this.h) == null) {
            String str;
            String str2;
            boolean startsWith;
            SDCardViewHolder sDCardViewHolder;
            SDCardViewHolder sDCardViewHolder2;
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            bundle = SettingStateController.getInstance().getDownloadDirStorage();
            boolean z = true;
            if (bundle == 1) {
                this.i = "in";
            } else if (bundle == 2) {
                this.i = "out";
            } else {
                this.i = DispatchConstants.OTHER;
            }
            if (bundle == 2 && TextUtils.isEmpty(this.h)) {
                SettingStateController.getInstance().setDownloadDirStorage(1);
                bundle = 1;
            }
            if (!e.a(this.g, this.h)) {
                str = this.g;
                str2 = this.h;
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        StringBuilder stringBuilder;
                        if (!str.endsWith(File.separator)) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(File.separator);
                            str = stringBuilder.toString();
                        }
                        if (!str2.endsWith(File.separator)) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append(File.separator);
                            str2 = stringBuilder.toString();
                        }
                        startsWith = str.startsWith(str2);
                        if (startsWith) {
                            startsWith = true;
                            this.e = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card1);
                            this.e.a(this.g, 1, bundle == 1, startsWith);
                            this.f = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card2);
                            if (AndroidConfig.getAndroidVersion() >= 19) {
                                this.f.setAllowChoosePath(false);
                                this.f.k = true;
                                this.f.l = false;
                            }
                            if (e.a(this.g, this.h)) {
                                sDCardViewHolder = this.f;
                                str2 = "";
                                if (bundle == 2) {
                                    z = false;
                                }
                                sDCardViewHolder.a(str2, 2, z, false);
                                this.f.setVisibility(8);
                            } else {
                                this.f.setVisibility(0);
                                sDCardViewHolder2 = this.f;
                                str = this.h;
                                if (bundle == 2) {
                                    z = false;
                                }
                                sDCardViewHolder2.a(str, 2, z, false);
                            }
                            this.e.setOnSelectChangedListener(new k(this));
                            this.f.setOnSelectChangedListener(new l(this));
                            a();
                            return;
                        }
                    }
                }
                startsWith = false;
                if (startsWith) {
                    startsWith = true;
                    this.e = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card1);
                    if (bundle == 1) {
                    }
                    this.e.a(this.g, 1, bundle == 1, startsWith);
                    this.f = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card2);
                    if (AndroidConfig.getAndroidVersion() >= 19) {
                        this.f.setAllowChoosePath(false);
                        this.f.k = true;
                        this.f.l = false;
                    }
                    if (e.a(this.g, this.h)) {
                        this.f.setVisibility(0);
                        sDCardViewHolder2 = this.f;
                        str = this.h;
                        if (bundle == 2) {
                            z = false;
                        }
                        sDCardViewHolder2.a(str, 2, z, false);
                    } else {
                        sDCardViewHolder = this.f;
                        str2 = "";
                        if (bundle == 2) {
                            z = false;
                        }
                        sDCardViewHolder.a(str2, 2, z, false);
                        this.f.setVisibility(8);
                    }
                    this.e.setOnSelectChangedListener(new k(this));
                    this.f.setOnSelectChangedListener(new l(this));
                    a();
                    return;
                }
            }
            startsWith = false;
            this.e = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card1);
            if (bundle == 1) {
            }
            this.e.a(this.g, 1, bundle == 1, startsWith);
            this.f = (SDCardViewHolder) findViewById(R.id.sett_choose_sdcard_card2);
            if (AndroidConfig.getAndroidVersion() >= 19) {
                this.f.setAllowChoosePath(false);
                this.f.k = true;
                this.f.l = false;
            }
            if (e.a(this.g, this.h)) {
                sDCardViewHolder = this.f;
                str2 = "";
                if (bundle == 2) {
                    z = false;
                }
                sDCardViewHolder.a(str2, 2, z, false);
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                sDCardViewHolder2 = this.f;
                str = this.h;
                if (bundle == 2) {
                    z = false;
                }
                sDCardViewHolder2.a(str, 2, z, false);
            }
            this.e.setOnSelectChangedListener(new k(this));
            this.f.setOnSelectChangedListener(new l(this));
            a();
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        a();
    }

    public void onBackPressed() {
        int downloadDirStorage = SettingStateController.getInstance().getDownloadDirStorage();
        String str = downloadDirStorage == 1 ? "in" : downloadDirStorage == 2 ? "out" : DispatchConstants.OTHER;
        br.a(this.i, str);
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        SettingStateController.getInstance().setHadCreateTask();
        super.onDestroy();
    }

    private void a() {
        String savedRealDownloadPath = DownloadConfig.getSavedRealDownloadPath(this, 1, true);
        String savedRealDownloadPath2 = DownloadConfig.getSavedRealDownloadPath(this, 2, true);
        if (!(this.e == null || TextUtils.isEmpty(this.g))) {
            SDCardViewHolder sDCardViewHolder = this.e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            stringBuilder.append(savedRealDownloadPath);
            sDCardViewHolder.setSDCardPath(stringBuilder.toString());
        }
        if (this.f != null && !TextUtils.isEmpty(this.h)) {
            SDCardViewHolder sDCardViewHolder2 = this.f;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.h);
            stringBuilder2.append(savedRealDownloadPath2);
            sDCardViewHolder2.setSDCardPath(stringBuilder2.toString());
        }
    }
}
