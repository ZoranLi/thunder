package com.umeng.message;

import org.json.JSONException;

class UTrack$11 implements Runnable {
    final /* synthetic */ UTrack a;

    UTrack$11(UTrack uTrack) {
        this.a = uTrack;
    }

    public void run() {
        try {
            UTrack.b().sendAliasFailLog(UTrack.b(this.a));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
