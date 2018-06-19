package com.xunlei.downloadprovider.vodnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import java.util.HashMap;

public class VodPlayerActivityNew extends AppCompatActivity {
    private static final String a = "VodPlayerActivityNew";
    private VodPlayerActivityFragment b;

    public static void a(Context context, TaskInfo taskInfo, BTSubTaskInfo bTSubTaskInfo, String str) {
        Intent intent = new Intent();
        intent.setClass(context, VodPlayerActivityNew.class);
        intent.putExtra("INTENT_KEY_DownloadTaskInfo", taskInfo);
        if (bTSubTaskInfo != null) {
            intent.putExtra("INTENT_KEY_BTSubTaskInfo", bTSubTaskInfo);
        }
        intent.putExtra("INTENT_KEY_FROM", str);
        if ((context instanceof Activity) == null) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, TaskPlayInfo taskPlayInfo, String str, HashMap hashMap, boolean z, int i, SubtitleManifest subtitleManifest) {
        context.startActivity(b(context, taskPlayInfo, str, hashMap, z, i, subtitleManifest));
    }

    public static Intent b(Context context, TaskPlayInfo taskPlayInfo, String str, HashMap hashMap, boolean z, int i, SubtitleManifest subtitleManifest) {
        Intent intent = new Intent();
        intent.setClass(context, VodPlayerActivityNew.class);
        intent.putExtra("INTENT_KEY_TaskPlayInfo", taskPlayInfo);
        intent.putExtra("INTENT_KEY_FROM", str);
        intent.putExtra("INTENT_KEY_PLAY_DURATION", i);
        intent.putExtra("INTENT_KEY_START_PLAY", z);
        if (hashMap != null) {
            intent.putExtra("INTENT_KEY_PLAYER_CONFIG", hashMap);
        }
        if (subtitleManifest != null) {
            intent.putExtra("INTENT_KEY_SubtitleManifest", subtitleManifest);
        }
        if ((context instanceof Activity) == null) {
            intent.setFlags(268435456);
        }
        intent.setExtrasClassLoader(context.getClass().getClassLoader());
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_vod_player_new);
        this.b = (VodPlayerActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        bundle = getIntent();
        if (bundle != null) {
            bundle.setExtrasClassLoader(TaskInfo.class.getClassLoader());
            TaskInfo taskInfo = (TaskInfo) bundle.getSerializableExtra("INTENT_KEY_DownloadTaskInfo");
            bundle.setExtrasClassLoader(BTSubTaskInfo.class.getClassLoader());
            BTSubTaskInfo bTSubTaskInfo = (BTSubTaskInfo) bundle.getSerializableExtra("INTENT_KEY_BTSubTaskInfo");
            bundle.setExtrasClassLoader(TaskPlayInfo.class.getClassLoader());
            TaskPlayInfo taskPlayInfo = (TaskPlayInfo) bundle.getSerializableExtra("INTENT_KEY_TaskPlayInfo");
            int intExtra = bundle.getIntExtra("INTENT_KEY_PLAY_DURATION", 0);
            String stringExtra = bundle.getStringExtra("INTENT_KEY_FROM");
            bundle.setExtrasClassLoader(HashMap.class.getClassLoader());
            HashMap hashMap = (HashMap) bundle.getSerializableExtra("INTENT_KEY_PLAYER_CONFIG");
            bundle.setExtrasClassLoader(SubtitleManifest.class.getClassLoader());
            SubtitleManifest subtitleManifest = (SubtitleManifest) bundle.getSerializableExtra("INTENT_KEY_SubtitleManifest");
            boolean booleanExtra = bundle.getBooleanExtra("INTENT_KEY_START_PLAY", true);
            VodPlayerActivityFragment vodPlayerActivityFragment;
            if (taskInfo != null) {
                vodPlayerActivityFragment = this.b;
                vodPlayerActivityFragment.d = stringExtra;
                if (taskInfo != null) {
                    i iVar = new i(taskInfo, bTSubTaskInfo, stringExtra);
                    vodPlayerActivityFragment.c = iVar;
                    vodPlayerActivityFragment.a(iVar, hashMap, booleanExtra, intExtra, subtitleManifest);
                }
            } else if (taskPlayInfo != null) {
                vodPlayerActivityFragment = this.b;
                vodPlayerActivityFragment.d = stringExtra;
                vodPlayerActivityFragment.a(new i(taskPlayInfo, stringExtra), hashMap, booleanExtra, intExtra, subtitleManifest);
            }
        }
        c.a((Context) this, "other_player_open_action", null);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.b != null) {
            this.b.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (this.b != null) {
            Object obj;
            VodPlayerActivityFragment vodPlayerActivityFragment = this.b;
            if (vodPlayerActivityFragment.b == null || vodPlayerActivityFragment.a == null || !vodPlayerActivityFragment.a.i()) {
                obj = null;
            } else {
                if (vodPlayerActivityFragment.b.f() != null) {
                    vodPlayerActivityFragment.b.f().x();
                }
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        super.onBackPressed();
    }
}
