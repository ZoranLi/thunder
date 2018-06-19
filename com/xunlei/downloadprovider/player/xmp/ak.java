package com.xunlei.downloadprovider.player.xmp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.broadcast.b;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationDialogActivity;
import com.xunlei.downloadprovider.dialog.f;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.recommend.WifiPopWindowReporter;
import com.xunlei.downloadprovider.homepage.recommend.WifiPopWindowReporter.PageFrom;
import com.xunlei.downloadprovider.player.xmp.b.c;
import com.xunlei.downloadprovider.player.xmp.b.d;
import com.xunlei.downloadprovider.player.xmp.b.e;
import com.xunlei.downloadprovider.player.xmp.b.g;
import com.xunlei.downloadprovider.player.xmp.b.g.a;
import com.xunlei.downloadprovider.player.xmp.b.h;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: XmpPlayerManager */
public class ak {
    private static ak e;
    HashMap<PlayerTag, g<Integer, ThunderXmpPlayer>> a = new HashMap();
    public SparseArray<ThunderXmpPlayer> b = new SparseArray();
    HashMap<PlayerTag, h<ThunderXmpPlayer>> c = new HashMap();
    a<Integer, ThunderXmpPlayer> d = new an(this);
    private Context f = BrothersApplication.getApplicationInstance();
    private boolean g;
    private Handler h = new Handler(Looper.getMainLooper());
    private b i = new ao(this);

    private ak() {
        String str;
        Context context = this.f;
        File externalCacheDir = BrothersApplication.getApplicationInstance().getExternalCacheDir();
        if (externalCacheDir == null) {
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(externalCacheDir.toString());
            stringBuilder.append("/preload/");
            str = stringBuilder.toString();
        }
        ShortVideoInterface.a(context, str);
        com.xunlei.downloadprovider.broadcast.a.a().a(this.i);
    }

    public static ak a() {
        if (e == null) {
            synchronized (ak.class) {
                if (e == null) {
                    e = new ak();
                }
            }
        }
        return e;
    }

    public final ThunderXmpPlayer a(PlayerTag playerTag) {
        return a(playerTag, ControlType.DEFAULT);
    }

    public final ThunderXmpPlayer a(PlayerTag playerTag, ControlType controlType) {
        StringBuilder stringBuilder = new StringBuilder("createPlayer--tag=");
        stringBuilder.append(playerTag);
        stringBuilder.append("||");
        stringBuilder.append(this);
        if (playerTag == null) {
            return null;
        }
        ThunderXmpPlayer thunderXmpPlayer = new ThunderXmpPlayer(playerTag, controlType);
        this.b.put(thunderXmpPlayer.b, thunderXmpPlayer);
        return thunderXmpPlayer;
    }

    public final ThunderXmpPlayer a(PlayerTag playerTag, String str) {
        if (playerTag != null) {
            if (!TextUtils.isEmpty(str)) {
                g gVar = (g) this.a.get(playerTag);
                if (gVar != null) {
                    if (gVar.size() != 0) {
                        for (ThunderXmpPlayer thunderXmpPlayer : gVar.snapshot().values()) {
                            if (str.equals(thunderXmpPlayer.f.d)) {
                                return thunderXmpPlayer;
                            }
                        }
                        return null;
                    }
                }
                return null;
            }
        }
        return null;
    }

    final boolean a(ThunderXmpPlayer thunderXmpPlayer) {
        new StringBuilder("removePlayerFromAttach--player=").append(thunderXmpPlayer);
        PlayerTag playerTag = thunderXmpPlayer.c;
        h hVar = (h) this.c.get(playerTag);
        boolean z = false;
        if (hVar != null) {
            if (!hVar.a.isEmpty()) {
                int i = 0;
                while (i < hVar.a.size()) {
                    ThunderXmpPlayer thunderXmpPlayer2 = (ThunderXmpPlayer) hVar.a.get(i);
                    if (thunderXmpPlayer2 == null || thunderXmpPlayer2 != thunderXmpPlayer) {
                        i++;
                    } else {
                        z = hVar.a(thunderXmpPlayer2);
                        if (hVar.a.isEmpty() != null) {
                            this.c.remove(playerTag);
                        }
                        return z;
                    }
                }
                return z;
            }
        }
        return false;
    }

    final boolean b(ThunderXmpPlayer thunderXmpPlayer) {
        new StringBuilder("removePlayerFromCache--tag=").append(thunderXmpPlayer.c);
        int i = thunderXmpPlayer.b;
        g gVar = (g) this.a.get(thunderXmpPlayer.c);
        return (gVar != null ? (ThunderXmpPlayer) gVar.remove(Integer.valueOf(i)) : null) != null ? true : null;
    }

    public final ThunderXmpPlayer b(PlayerTag playerTag) {
        if (playerTag == null) {
            return null;
        }
        h hVar = (h) this.c.get(playerTag);
        if (hVar == null) {
            return null;
        }
        while (!hVar.a.isEmpty()) {
            Object obj;
            if (hVar.a.isEmpty()) {
                obj = null;
            } else {
                obj = hVar.a.get(hVar.a.size() - 1);
            }
            ThunderXmpPlayer thunderXmpPlayer = (ThunderXmpPlayer) obj;
            if (thunderXmpPlayer.s()) {
                return thunderXmpPlayer;
            }
            if (!hVar.a.isEmpty()) {
                hVar.a.removeLast();
            }
        }
        return null;
    }

    private ArrayList<ThunderXmpPlayer> d(PlayerTag playerTag) {
        if (playerTag == null) {
            return null;
        }
        SparseArray sparseArray = this.b;
        int size = sparseArray.size();
        if (size == 0) {
            return null;
        }
        ArrayList<ThunderXmpPlayer> arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            ThunderXmpPlayer thunderXmpPlayer = (ThunderXmpPlayer) sparseArray.valueAt(i);
            if (playerTag == thunderXmpPlayer.c) {
                arrayList.add(thunderXmpPlayer);
            }
        }
        return arrayList;
    }

    public final void c(PlayerTag playerTag) {
        new StringBuilder("destroyPlayersByTag--tag=").append(playerTag);
        playerTag = d(playerTag);
        if (playerTag != null) {
            if (!playerTag.isEmpty()) {
                playerTag = playerTag.iterator();
                while (playerTag.hasNext()) {
                    ((ThunderXmpPlayer) playerTag.next()).q();
                }
            }
        }
    }

    final void a(PlayerTag playerTag, ThunderXmpPlayer thunderXmpPlayer) {
        StringBuilder stringBuilder = new StringBuilder("addAttachPlayer--tag=");
        stringBuilder.append(playerTag);
        stringBuilder.append("|xmpPlayer=");
        stringBuilder.append(thunderXmpPlayer);
        if (thunderXmpPlayer != null) {
            h hVar = (h) this.c.get(playerTag);
            if (hVar == null) {
                hVar = new h();
                this.c.put(playerTag, hVar);
            }
            if (hVar.a.size() >= playerTag.getAttachSizeLimit()) {
                ((ThunderXmpPlayer) hVar.a.remove(0)).r();
            }
            playerTag = hVar.a.indexOf(thunderXmpPlayer);
            if (playerTag >= null) {
                hVar.a.remove(playerTag);
            }
            hVar.a.add(thunderXmpPlayer);
        }
    }

    public final boolean a(String str, Context context, a aVar) {
        if (this.g) {
            return true;
        }
        if (context == null) {
            return false;
        }
        CooperationData a = com.xunlei.downloadprovider.cooperation.ui.b.a(1010, 21);
        if (a != null) {
            CooperationDialogActivity.a(context, a, SceneUiStyle.THREE_BUTTON, new al(this, aVar, context));
        } else {
            if (context instanceof ShortMovieDetailActivity) {
                WifiPopWindowReporter.a(PageFrom.VIDEO_DEITAIL, com.xunlei.xllib.android.b.c(BrothersApplication.getApplicationInstance()), str);
            } else if (context instanceof MainTabActivity) {
                WifiPopWindowReporter.a(PageFrom.FEED_FLOW, com.xunlei.xllib.android.b.c(BrothersApplication.getApplicationInstance()), str);
            }
            a amVar = new am(this, aVar, context, str);
            CharSequence string = context.getString(R.string.feed_wifi_notify_tag_has_mobile);
            aVar = context.getString(R.string.feed_wifi_notify_btn_stop);
            OnClickListener dVar = new d(amVar);
            CharSequence string2 = context.getString(R.string.feed_wifi_notify_btn_continue);
            OnClickListener eVar = new e(amVar);
            if (!(c.a != null && c.a.isShowing() && context == c.a.getOwnerActivity())) {
                if (c.a == null || c.a.getOwnerActivity() != context) {
                    c.a = new f(context);
                    if (context instanceof Activity) {
                        c.a.setOwnerActivity((Activity) context);
                    }
                }
                c.a.k = 2;
                c.a.setCancelable(false);
                c.a.setCanceledOnTouchOutside(false);
                c.a.a(string);
                c.a.c(aVar);
                c.a.a(dVar);
                c.a.d(string2);
                c.a.b(eVar);
                c.a.setOnShowListener(new com.xunlei.downloadprovider.player.xmp.b.f());
                if (c.a.isShowing() == null) {
                    c.a.show();
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AllSize=");
        stringBuilder.append(this.b.size());
        stringBuilder.append("||cachePlayer:{");
        for (PlayerTag playerTag : this.a.keySet()) {
            g gVar = (g) this.a.get(playerTag);
            stringBuilder.append("[tag=");
            stringBuilder.append(playerTag);
            stringBuilder.append(",size=");
            stringBuilder.append(gVar.size());
            stringBuilder.append("]");
        }
        stringBuilder.append(com.alipay.sdk.util.h.d);
        stringBuilder.append("||AttachPlayer:{");
        for (PlayerTag playerTag2 : this.c.keySet()) {
            h hVar = (h) this.c.get(playerTag2);
            stringBuilder.append("[tag=");
            stringBuilder.append(playerTag2);
            stringBuilder.append(",size=");
            stringBuilder.append(hVar.a.size());
            stringBuilder.append("]");
        }
        stringBuilder.append(com.alipay.sdk.util.h.d);
        return stringBuilder.toString();
    }

    public final void a(ArrayList<ShortVideoInterface.a> arrayList, ShortVideoInterface.b bVar) {
        if (!arrayList.isEmpty()) {
            if (com.xunlei.xllib.a.a.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("preloadVideo--size=");
                stringBuilder.append(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ShortVideoInterface.a aVar = (ShortVideoInterface.a) it.next();
                    stringBuilder.append("[title=");
                    stringBuilder.append(aVar.c);
                    stringBuilder.append(",url=");
                    stringBuilder.append(aVar.a);
                    stringBuilder.append(']');
                }
            }
            ShortVideoInterface a = ShortVideoInterface.a();
            ShortVideoInterface.b apVar = new ap(this, bVar);
            bVar = new ArrayList();
            bVar.addAll(arrayList);
            a.a.post(new com.xunlei.android.shortvideo.a(a, bVar, apVar));
        }
    }
}
