package com.xunlei.downloadprovider.app;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.h.i;
import com.xunlei.downloadprovider.homepage.follow.ac;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.XLIntent;

public class PollingService extends IntentService {
    private static final String a = "PollingService";
    private final long b = i.a();
    private final long c = (this.b * 8);
    private boolean d = false;
    private boolean e = false;

    static class a {
        boolean a = false;
        boolean b = false;
        int c = 0;

        a() {
        }
    }

    public PollingService() {
        super(a);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            intent = intent.getAction();
            if (i.b(intent)) {
                ac a = ac.a();
                long b;
                long b2;
                long currentTimeMillis;
                boolean z;
                if ("com.xunlei.downloadprovider.app.action.CHECK_FOLLOW_UPDATE".equals(intent)) {
                    if (a.a.getBoolean("is_follow_tab_red_point_show", false) == null) {
                        if (a.b() == null) {
                            LoginHelper.a();
                            if (l.c() != null) {
                                b = f.b(getApplicationContext(), "last_follow_check_time", 0);
                                b2 = f.b(getApplicationContext(), "next_follow_check_interval", this.b);
                                currentTimeMillis = System.currentTimeMillis();
                                if (b + b2 <= currentTimeMillis) {
                                    intent = new StringBuilder("checkFollowUpdate:lastCheckTime=>");
                                    intent.append(b);
                                    intent.append("\nnextCheckInterval=>");
                                    intent.append(b2 / 60000);
                                    intent.append("min");
                                    if (this.e == null) {
                                        this.e = true;
                                        intent = b();
                                        z = intent[0];
                                        intent = intent[1];
                                        if (z) {
                                            f.a(getApplicationContext(), "last_follow_check_time", currentTimeMillis);
                                            b = b2 == 0 ? this.b : b2 + 60000;
                                            if (b > this.c) {
                                                b = this.c;
                                            }
                                            if (intent != null) {
                                                f.a(getApplicationContext(), "next_follow_check_interval", this.b);
                                            } else {
                                                f.a(getApplicationContext(), "next_follow_check_interval", b);
                                            }
                                        }
                                        if (intent != null) {
                                            intent = new XLIntent();
                                            intent.setAction("com.xunlei.downloadprovider.app.action.FOLLOW_DATA_UPDATED");
                                            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                                        }
                                        this.e = false;
                                    }
                                }
                            }
                        }
                    }
                } else if ("com.xunlei.downloadprovider.app.action.CHECK_LIVE_UPDATE".equals(intent) != null && (a.b() == null || a.a.getBoolean("is_live_tab_red_point_show", false) == null)) {
                    LoginHelper.a();
                    if (l.c() != null) {
                        b = f.b(getApplicationContext(), "last_live_check_time", 0);
                        b2 = f.b(getApplicationContext(), "next_live_check_interval", this.b);
                        currentTimeMillis = System.currentTimeMillis();
                        if (b + b2 <= currentTimeMillis) {
                            intent = new StringBuilder("checkLiveUpdate:lastCheckTime=>");
                            intent.append(b);
                            intent.append("\nnextCheckInterval=>");
                            intent.append(b2 / 60000);
                            intent.append("min");
                            if (this.d == null) {
                                this.d = true;
                                intent = a();
                                z = intent.a;
                                boolean z2 = intent.b;
                                intent = intent.c;
                                if (z) {
                                    f.a(getApplicationContext(), "last_live_check_time", currentTimeMillis);
                                    long j = b2 == 0 ? this.b : b2 + 60000;
                                    if (j > this.c) {
                                        j = this.c;
                                    }
                                    if (z2) {
                                        f.a(getApplicationContext(), "next_live_check_interval", this.b);
                                    } else {
                                        f.a(getApplicationContext(), "next_live_check_interval", j);
                                    }
                                }
                                if (z2) {
                                    Intent xLIntent = new XLIntent();
                                    xLIntent.setAction("com.xunlei.downloadprovider.app.action.LIVE_DATA_UPDATED");
                                    xLIntent.putExtra("follow_live_count", intent);
                                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(xLIntent);
                                }
                                this.d = false;
                            }
                        }
                    }
                }
            }
        }
    }

    private com.xunlei.downloadprovider.app.PollingService.a a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.lang.Object;
        r0.<init>();
        r1 = new com.xunlei.downloadprovider.app.PollingService$a;
        r1.<init>();
        r2 = com.xunlei.downloadprovider.homepage.follow.b.a();
        r3 = new com.xunlei.downloadprovider.app.f;
        r3.<init>(r8, r0, r1);
        r4 = r2.c;
        r4 = r4.a;
        r5 = "latest_p_time";
        r6 = 0;
        r4 = r4.getLong(r5, r6);
        r6 = r2.d;
        r7 = new com.xunlei.downloadprovider.homepage.follow.q;
        r7.<init>(r2, r3);
        r2 = new java.lang.StringBuilder;
        r3 = "http://api-shoulei-ssl.xunlei.com/follow/live_sign";
        r2.<init>(r3);
        r3 = "?ptime=";
        r2.append(r3);
        r2.append(r4);
        r3 = new java.lang.StringBuilder;
        r4 = "getFollowingLatestLiveStatus:url=>";
        r3.<init>(r4);
        r3.append(r2);
        r3 = new com.xunlei.downloadprovider.homepage.follow.c.al;
        r3.<init>(r6, r2, r7);
        com.xunlei.common.concurrent.XLThreadPool.execute(r3);
        monitor-enter(r0);
        r0.wait();	 Catch:{ InterruptedException -> 0x004e }
        goto L_0x004e;
    L_0x004c:
        r1 = move-exception;
        goto L_0x005e;
    L_0x004e:
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        r0 = new java.lang.StringBuilder;
        r2 = "checkLiveUpdateSync:result=>";
        r0.<init>(r2);
        r2 = r1.toString();
        r0.append(r2);
        return r1;
    L_0x005e:
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.app.PollingService.a():com.xunlei.downloadprovider.app.PollingService$a");
    }

    private boolean[] b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new java.lang.Object;
        r0.<init>();
        r1 = 2;
        r1 = new boolean[r1];
        r2 = com.xunlei.downloadprovider.homepage.follow.b.a();
        r3 = new com.xunlei.downloadprovider.app.g;
        r3.<init>(r7, r0, r1);
        r4 = r2.c;
        r4 = r4.a;
        r5 = "latest_feed_id";
        r6 = "";
        r4 = r4.getString(r5, r6);
        r5 = r2.d;
        r6 = new com.xunlei.downloadprovider.homepage.follow.o;
        r6.<init>(r2, r3);
        r2 = new java.lang.StringBuilder;
        r3 = "http://api-shoulei-ssl.xunlei.com/dynamic/if_new";
        r2.<init>(r3);
        r3 = "?latest_feed_id=";
        r2.append(r3);
        r2.append(r4);
        r3 = new java.lang.StringBuilder;
        r4 = "getFollowingLatestVideoFeedStatus:url=>";
        r3.<init>(r4);
        r3.append(r2);
        r3 = new com.xunlei.downloadprovider.homepage.follow.c.q;
        r3.<init>(r5, r2, r6);
        com.xunlei.common.concurrent.XLThreadPool.execute(r3);
        monitor-enter(r0);
        r0.wait();	 Catch:{ InterruptedException -> 0x004c }
        goto L_0x004c;
    L_0x004a:
        r1 = move-exception;
        goto L_0x005c;
    L_0x004c:
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        r0 = new java.lang.StringBuilder;
        r2 = "checkFollowingUpdateSync:result=>";
        r0.<init>(r2);
        r2 = java.util.Arrays.toString(r1);
        r0.append(r2);
        return r1;
    L_0x005c:
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.app.PollingService.b():boolean[]");
    }
}
