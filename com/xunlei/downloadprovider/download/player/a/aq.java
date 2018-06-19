package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.drawable.LevelListDrawable;
import android.media.MediaScannerConnection;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.player.views.right.PlayerRecordButtonView;
import com.xunlei.downloadprovider.g.a.b;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.vod.manager.j;
import com.xunlei.downloadprovider.vod.manager.k;
import com.xunlei.downloadprovider.vod.manager.m;
import com.xunlei.downloadprovider.vod.recordpublish.RecordVideoPreviewActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RecordPublishController */
public class aq extends f {
    static int a = 0;
    private static final String p = "aq";
    private static int q;
    ProgressBar b;
    TextView c;
    View d;
    PlayerRecordButtonView g;
    Runnable h;
    Handler i;
    int j = 0;
    String k = "";
    boolean l = false;
    int m = 0;
    public boolean n = false;
    Runnable o = new ar(this);
    private View r;
    private LevelListDrawable s;
    private boolean t = false;
    private BroadcastReceiver u;

    public aq(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        a = downloadVodPlayerView.getResources().getInteger(R.integer.min_record_time);
        q = downloadVodPlayerView.getResources().getInteger(R.integer.max_record_time);
        this.i = new Handler();
        this.r = this.e.findViewById(R.id.lyt_record_bar);
        this.b = (ProgressBar) this.r.findViewById(R.id.pbr_record_progress);
        this.d = this.r.findViewById(R.id.v_line);
        this.c = (TextView) this.r.findViewById(R.id.tv_recording_tip);
        this.s = (LevelListDrawable) this.c.getCompoundDrawables()[0];
        this.b.setMax(n().getResources().getInteger(R.integer.max_record_time) * 1000);
        this.b.setProgress(0);
        this.b.setSecondaryProgress(0);
        this.g = (PlayerRecordButtonView) this.e.findViewById(R.id.player_record_button);
        this.g.setRecordButtonOnClickListener(new at(this));
        if (n() != null) {
            this.u = new as(this);
            c.a(n(), "Action_Broadcast_RecordVideoPreviewActivity", this.u);
            c.a(n(), "Action_Broadcast_VodPlayerPublishActivity", this.u);
            c.a(n(), "DownloadVodPlayerController.ACTION_PLAY_COMPLETION", this.u);
        }
    }

    public static boolean m() {
        return VERSION.SDK_INT >= 23 ? d.a().i.a() : false;
    }

    public final void b(boolean z) {
        this.l = z;
        if (this.l) {
            e(true);
            this.g.setRecordBtnSelected(false);
            this.g.setRecordBtnEnabled(false);
            this.r.setVisibility(0);
            this.b.setProgress(0);
            this.b.setSecondaryProgress(0);
            this.c.setText(String.format("录制%s秒即可分享", new Object[]{Integer.valueOf(a)}));
            this.i.post(new av(this));
            if (q()) {
                q().d();
                q().d.a();
                if (q().getPlayerCenterViewGroup()) {
                    q().getPlayerCenterViewGroup().setShouldDetectorGesture(false);
                    return;
                }
            }
        }
        e(false);
        this.g.setRecordBtnSelected(false);
        this.g.setRecordBtnEnabled(true);
        this.r.setVisibility(8);
        this.c.setText("录制结束");
        this.i.removeCallbacks(this.h);
        if (q() && q().getPlayerCenterViewGroup()) {
            q().getPlayerCenterViewGroup().setShouldDetectorGesture(true);
        }
    }

    final boolean r() {
        return f() != null ? f().m_() : false;
    }

    final void c(boolean z) {
        if (this.l) {
            if (r()) {
                if (f() != null) {
                    this.i.removeCallbacks(this.o);
                    m f = f();
                    if (f.a != null) {
                        f.a.y();
                    }
                    this.m = f().k_();
                    if (this.j <= 0 || this.m - this.j < a * 1000) {
                        File file = new File(this.k);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!z && n()) {
                            z = n();
                            StringBuilder stringBuilder = new StringBuilder("录制时长不足");
                            stringBuilder.append(a);
                            stringBuilder.append("秒");
                            XLToast.showToast(z, stringBuilder.toString());
                            a("short");
                        }
                    } else if (!z) {
                        this.n = true;
                        this.i.postDelayed(new aw(this), 200);
                    }
                    b(false);
                    new StringBuilder("reBackAndPausePlayer : ").append(this.j);
                    if (f()) {
                        f().a(this.j);
                        f().C();
                        if (q()) {
                            q().e();
                        }
                    }
                }
            }
        }
    }

    private String v() {
        return f() != null ? f().m() : "";
    }

    private boolean w() {
        return f() != null ? f().L() : false;
    }

    private void a(String str) {
        String str2 = "native";
        if (f() != null && f().L()) {
            str2 = "bxbb";
        }
        b.a(URLCoder.encode(v(), null), str2, ((long) (this.m - this.j)) / 1000, this.k.substring(this.k.lastIndexOf(47) + 1).replace(".tmp", ".mp4"), str);
    }

    private void b(String str) {
        String str2 = "native";
        if (w()) {
            str2 = "bxbb";
        }
        b.a(URLCoder.encode(v(), null), str2, ((long) (this.m - this.j)) / 1000, this.k.substring(this.k.lastIndexOf(47) + 1).replace(".tmp", ".mp4"), str, l.a().f() ? "yes" : "no");
    }

    public final void d(boolean z) {
        this.t = z;
        this.g.setVisibility(z ? false : true);
    }

    private void e(boolean z) {
        if (o() != null) {
            Window window;
            if (VERSION.SDK_INT >= 21) {
                window = o().getWindow();
                window.clearFlags(201326592);
                window.addFlags(Integer.MIN_VALUE);
                window.setNavigationBarColor(z ? false : true);
            } else if (VERSION.SDK_INT >= 19) {
                window = o().getWindow();
                if (z) {
                    window.addFlags(134217728);
                    return;
                }
                window.clearFlags(134217728);
            }
        }
    }

    public final void n_() {
        super.n_();
        c(true);
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z) {
            c(true);
        }
    }

    public final void d() {
        if (this.i != null) {
            this.i.removeCallbacksAndMessages(null);
        }
        if (this.u != null && n() != null) {
            c.a(n(), this.u);
        }
    }

    static /* synthetic */ String e(aq aqVar) {
        File file = new File(aqVar.k);
        Object replace = aqVar.k.replace(".tmp", ".mp4");
        File file2 = new File(replace);
        if (file.exists() ? file.renameTo(file2) : false) {
            String absolutePath = file2.getAbsolutePath();
            if (aqVar.n() != null) {
                MediaScannerConnection.scanFile(aqVar.n().getApplicationContext(), new String[]{absolutePath}, null, null);
            }
        } else {
            replace = null;
        }
        if (TextUtils.isEmpty(replace)) {
            if (aqVar.n() != null) {
                XLToast.showToast(aqVar.n(), "保存失败");
            }
            aqVar.b("save_local");
            aqVar.a("fail");
        } else {
            if (aqVar.n() != null) {
                XLToast.showToast(aqVar.n(), "保存成功");
            }
            aqVar.b("save_local");
            aqVar.a("success");
        }
        return replace;
    }

    static /* synthetic */ void a(aq aqVar, String str, String str2, String str3) {
        JSONException e;
        JSONException jSONException;
        StringBuilder stringBuilder;
        String str4 = str2;
        String str5 = str3;
        File file = new File(str5);
        if (file.exists()) {
            String a = e$a.a(new File(file.getAbsolutePath()));
            long length = file.length();
            long currentTimeMillis = System.currentTimeMillis();
            String format = String.format("#%s#%s", new Object[]{str4, str});
            j jVar = new j();
            k kVar = r1;
            String str6 = format;
            long j = currentTimeMillis;
            k kVar2 = new k(jVar, str5, length, currentTimeMillis, format, str4, new ax(aqVar, length, a, format, str4));
            e$d com_xunlei_downloadprovider_member_payment_a_e_d;
            try {
                String str7 = "http://api.tw06.xlmc.sandai.net/api/file/requestUpload";
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("gcid", a);
                jSONObject.put("path", str5);
                jSONObject.put("size", length);
                jSONObject.put("createTime", j);
                jSONObject.put("title", str6);
                jSONObject.put("tag", str4);
                jSONArray.put(jSONObject);
                String jSONArray2 = jSONArray.toString();
                Map hashMap = new HashMap();
                hashMap.put("files", jSONArray2);
                hashMap.put("uploadMethod", "jq");
                j jVar2 = jVar;
                com_xunlei_downloadprovider_member_payment_a_e_d = kVar;
                try {
                    jVar2.a.a(str7, "1.0", hashMap, new m(jVar2, com_xunlei_downloadprovider_member_payment_a_e_d));
                } catch (JSONException e2) {
                    e = e2;
                    jSONException = e;
                    new StringBuilder().append(jSONException.getMessage());
                    stringBuilder = new StringBuilder("requestToken exception : ");
                    stringBuilder.append(jSONException.getMessage());
                    com_xunlei_downloadprovider_member_payment_a_e_d.a(stringBuilder.toString());
                }
            } catch (JSONException e3) {
                e = e3;
                com_xunlei_downloadprovider_member_payment_a_e_d = kVar;
                jSONException = e;
                new StringBuilder().append(jSONException.getMessage());
                stringBuilder = new StringBuilder("requestToken exception : ");
                stringBuilder.append(jSONException.getMessage());
                com_xunlei_downloadprovider_member_payment_a_e_d.a(stringBuilder.toString());
            }
        }
    }

    static /* synthetic */ void g(aq aqVar) {
        int progress = aqVar.b.getProgress();
        int level = aqVar.s.getLevel();
        int i = 0;
        if (progress < a * 1000) {
            aqVar = aqVar.s;
            if (level == 0) {
                i = 1;
            }
            aqVar.setLevel(i);
            return;
        }
        aqVar = aqVar.s;
        if (level == 0) {
            i = a;
        }
        aqVar.setLevel(i);
    }

    static /* synthetic */ void k(aq aqVar) {
        if (aqVar.o() != null) {
            aqVar.n = true;
            Intent intent = new Intent(aqVar.o(), RecordVideoPreviewActivity.class);
            intent.putExtra("play_url", aqVar.k);
            aqVar.o().startActivity(intent);
            aqVar.o().overridePendingTransition(R.anim.preview_activity_enter, 0);
            String str = "native";
            if (aqVar.w()) {
                str = "bxbb";
            }
            b.a(URLCoder.encode(aqVar.v(), null), str, ((long) (aqVar.m - aqVar.j)) / 1000, aqVar.k.substring(aqVar.k.lastIndexOf(47) + 1).replace(".tmp", ".mp4"), l.a().f());
        }
    }

    static /* synthetic */ void b(aq aqVar, String str) {
        String str2 = "native";
        if (aqVar.w()) {
            str2 = "bxbb";
        }
        b.b(URLCoder.encode(aqVar.v(), null), str2, ((long) (aqVar.m - aqVar.j)) / 1000, aqVar.k.substring(aqVar.k.lastIndexOf(47) + 1).replace(".tmp", ".mp4"), str);
    }
}
