package com.xunlei.downloadprovider.plugin.a;

import android.os.Bundle;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v.b;

/* compiled from: ThunderHostFacadeImpl */
final class f implements b {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void a(VideoPlayRecord videoPlayRecord) {
        Bundle bundle = new Bundle(13);
        if (videoPlayRecord != null) {
            bundle.putString("KEY_PlayerRecord_TypeTag", videoPlayRecord.c);
            bundle.putString("KEY_PlayerRecord_Name", videoPlayRecord.d);
            bundle.putString("KEY_PlayerRecord_PlayUrl", videoPlayRecord.e);
            bundle.putString("KEY_PlayerRecord_CoverUrl", videoPlayRecord.f);
            bundle.putLong("KEY_PlayerRecord_Duration", videoPlayRecord.g);
            bundle.putLong("KEY_PlayerRecord_PlayedTime", videoPlayRecord.h);
            bundle.putLong("KEY_PlayerRecord_MaxPlayedTime", videoPlayRecord.i);
            bundle.putLong("KEY_PlayerRecord_LastPlayTimestamp", videoPlayRecord.j);
            bundle.putLong("KEY_PlayerRecord_Size", videoPlayRecord.k);
            bundle.putString("KEY_PlayerRecord_DownloadUrl", videoPlayRecord.l);
            bundle.putString("KEY_PlayerRecord_Cid", videoPlayRecord.m);
            bundle.putString("KEY_PlayerRecord_Gcid", videoPlayRecord.n);
            bundle.putString("KEY_PlayerRecord_MovieId", videoPlayRecord.o);
        }
        c.a(BrothersApplication.getApplicationInstance(), "Action_Get_Player_Record", bundle);
    }
}
