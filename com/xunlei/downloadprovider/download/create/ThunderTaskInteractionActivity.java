package com.xunlei.downloadprovider.download.create;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.d;

public final class ThunderTaskInteractionActivity extends FragmentActivity implements au {
    private static c c;
    ThunderTaskInteractionFragment a = ThunderTaskInteractionFragment.a();
    private d b = new d(new ak(this));
    private DownData d;
    private TaskStatInfo e;
    private c f;

    static void a(Context context, @NonNull DownData downData, @NonNull TaskStatInfo taskStatInfo, @Nullable c cVar) {
        new StringBuilder("startInteractionActivity url = ").append(downData.b);
        c = cVar;
        cVar = new Intent(context, ThunderTaskInteractionActivity.class);
        if (!(context instanceof Activity)) {
            cVar.addFlags(268435456);
        }
        cVar.putExtra("downdata", downData);
        cVar.putExtra("report_info", taskStatInfo);
        context.startActivity(cVar);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_thunder_task_interaction);
        this.a.a(getSupportFragmentManager(), (au) this);
        bundle = getIntent();
        this.d = (DownData) bundle.getParcelableExtra("downdata");
        this.e = (TaskStatInfo) bundle.getParcelableExtra("report_info");
        this.f = c;
        c = null;
        if (this.d != null) {
            if (this.e != null) {
                this.a.a(this.d, this.e, this.b);
                return;
            }
        }
        finish();
    }

    protected final void onResume() {
        super.onResume();
    }

    public final void a(boolean z) {
        if (!z) {
            finish();
        }
    }

    protected final void onDestroy() {
        if (this.a != null) {
            this.a.a = null;
        }
        if (this.b != null) {
            this.b.a();
        }
        this.f = null;
        super.onDestroy();
    }
}
