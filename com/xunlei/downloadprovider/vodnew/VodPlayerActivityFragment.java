package com.xunlei.downloadprovider.vodnew;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;
import com.xunlei.xllib.android.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class VodPlayerActivityFragment extends Fragment {
    private static final String e = "VodPlayerActivityFragment";
    DownloadVodPlayerView a;
    a b;
    i c;
    String d;
    private HashMap f;
    private SubtitleManifest g;
    private com.xunlei.downloadprovider.database.a.a h;
    private m.a i = new a(this);
    private e j = new b(this);
    private BroadcastReceiver k = new d(this);

    static /* synthetic */ void b() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        c.a(getContext(), "DownloadVodPlayerController.ACTION_PLAY_COMPLETION", this.k);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.a = (DownloadVodPlayerView) layoutInflater.inflate(R.layout.downloadvod_player_view, viewGroup, false);
        return this.a;
    }

    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.b();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.c();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.b != null) {
            this.b.n_();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (!(this.b == null || this.b.f() == null)) {
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_float_player_close_position", this.b.f().k_());
            if (!(this.b.h() == null || this.b.h().c == null)) {
                bundle.putSerializable("KEY_FLOAT_PLAYER_SubtitleManifest", this.b.h().c);
            }
            if (!com.xunlei.downloadprovider.vod.floatwindow.a.a) {
                c.a(getActivity(), "float_player_close_action", bundle);
            }
        }
        if (b.d(getContext()) && this.c != null) {
            long taskId = this.c.a.getTaskId();
            n.a();
            n.a(taskId);
        }
        if (this.b != null) {
            this.b.d();
        }
        c.a(getContext(), this.k);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.b != null) {
            this.b.a(i, i2, intent);
        }
    }

    private void a(TaskInfo taskInfo) {
        long taskId = taskInfo.getTaskId();
        long a = com.xunlei.downloadprovider.download.util.m.a(taskId);
        if (a > -1 && taskId != a) {
            taskInfo = h.e().a(a);
            if (taskInfo != null) {
                taskInfo.i();
                taskInfo.j();
                TaskInfo taskInfo2 = taskInfo.b;
                if (taskInfo2 != null) {
                    if (k.e(taskInfo2)) {
                        DownloadTaskInfo downloadTaskInfo = taskInfo.b;
                        v.a().a(downloadTaskInfo.mInfoHash, new e(this, taskInfo, downloadTaskInfo));
                    } else if (k.c(taskInfo2) != null) {
                        m f = this.b.f();
                        if (f != null) {
                            f.a("auto_next");
                            a(new i(taskInfo2, null, ""), f);
                        }
                    }
                }
            }
        }
    }

    private void a(i iVar, m mVar) {
        if (mVar != null) {
            boolean z;
            this.c = iVar;
            mVar.A();
            mVar.a(iVar);
            iVar = iVar.a;
            if (iVar != null) {
                boolean exists;
                if (iVar != null) {
                    if (!TextUtils.isEmpty(iVar.mLocalFileName)) {
                        exists = new File(iVar.mLocalFileName).exists();
                        if (!(!exists || iVar.getTaskStatus() == 4 || iVar.getTaskStatus() == 16)) {
                            z = true;
                            if (z != null) {
                                mVar.b(false);
                            }
                            mVar.c(z);
                        }
                    }
                }
                exists = false;
                z = true;
                if (z != null) {
                    mVar.b(false);
                }
                mVar.c(z);
            }
            z = null;
            if (z != null) {
                mVar.b(false);
            }
            mVar.c(z);
        }
    }

    private void a(i iVar) {
        m f = this.b.f();
        if (f != null) {
            f.a("auto_next");
            a(iVar, f);
        }
    }

    public final void a(i iVar, HashMap hashMap, boolean z, int i, SubtitleManifest subtitleManifest) {
        this.d = iVar.d;
        this.f = hashMap;
        this.g = subtitleManifest;
        this.b = new a(this.a);
        this.b.f().c = this.i;
        this.b.f().a(this.j);
        this.b.f().z();
        this.b.f().a(iVar);
        if (z) {
            this.b.f().a("auto");
        } else {
            this.b.f().a("manul");
        }
        this.b.f().c(z);
        this.b.f().g = i;
        this.b.f().j = new c(this);
        a.a(getActivity(), this.b, true);
    }

    static /* synthetic */ void a(VodPlayerActivityFragment vodPlayerActivityFragment, TaskInfo taskInfo) {
        BTSubTaskInfo bTSubTaskInfo = vodPlayerActivityFragment.c.b;
        s a = h.e().a(taskInfo.getTaskId());
        BTSubTaskInfo bTSubTaskInfo2 = null;
        if (!(bTSubTaskInfo == null || a == null)) {
            List g = a.g();
            if (g != null) {
                int i = -1;
                for (int i2 = 0; i2 < g.size(); i2++) {
                    if (((BTSubTaskInfo) g.get(i2)).mBTSubIndex == bTSubTaskInfo.mBTSubIndex) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    while (true) {
                        i++;
                        if (i >= g.size()) {
                            break;
                        }
                        bTSubTaskInfo = (BTSubTaskInfo) g.get(i);
                        if (!TextUtils.isEmpty(bTSubTaskInfo.mLocalFileName)) {
                            File file = new File(bTSubTaskInfo.mLocalFileName);
                            if (k.c(bTSubTaskInfo) && file.exists()) {
                                break;
                            }
                        }
                    }
                    bTSubTaskInfo2 = bTSubTaskInfo;
                }
                bTSubTaskInfo = null;
                bTSubTaskInfo2 = bTSubTaskInfo;
            }
        }
        if (bTSubTaskInfo2 != null) {
            vodPlayerActivityFragment.a(new i(a.b, bTSubTaskInfo2, ""));
        } else {
            vodPlayerActivityFragment.a(taskInfo);
        }
    }
}
