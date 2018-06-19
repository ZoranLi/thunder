package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.support.v4.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

class o implements OnCompletionListener {
    final /* synthetic */ k a;

    o(k kVar) {
        this.a = kVar;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.a.b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, "onAudioComplete");
                jSONObject.put("status", "0");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.a.a(this.a.d.a(), jSONObject.toString());
        }
    }
}
