package com.xunlei.downloadprovider.vod.dlna;

public interface OnDLNADialogListener {

    public enum MediaPlayerPlayCMD {
        Play_None,
        Play_Prepare,
        Play_Prepare_Start,
        Play_OnResume_Start
    }

    void a();

    void a(boolean z);

    void b();
}
