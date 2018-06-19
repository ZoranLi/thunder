package com.alibaba.baichuan.android.auth;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.alibaba.baichuan.android.trade.utils.l;
import com.umeng.message.proguard.k;
import org.android.agoo.common.AgooConstants;

public class AlibcAuthActivity extends Activity implements OnClickListener {
    static int a;
    private boolean b = false;

    private class a implements g {
        com.alibaba.baichuan.android.auth.c.a a;
        final /* synthetic */ AlibcAuthActivity b;

        private a(AlibcAuthActivity alibcAuthActivity) {
            this.b = alibcAuthActivity;
            this.a = (com.alibaba.baichuan.android.auth.c.a) c.a.get(Integer.valueOf(AlibcAuthActivity.a));
        }

        public final void a() {
            this.a.c.a();
            c.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            this.b.finish();
        }

        public final void a(String str, String str2) {
            if (TextUtils.equals("FAIL_SYS_ACCESS_TOKEN_STOP_SERVICE", str)) {
                this.a.c.a(str, str2);
                c.a.remove(Integer.valueOf(AlibcAuthActivity.a));
                return;
            }
            this.b.b = true;
            this.b.a();
        }

        public final void b() {
            this.a.c.b();
            c.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            this.b.finish();
        }
    }

    private class b implements g {
        com.alibaba.baichuan.android.auth.c.a a;
        final /* synthetic */ AlibcAuthActivity b;

        private b(AlibcAuthActivity alibcAuthActivity) {
            this.b = alibcAuthActivity;
            this.a = (com.alibaba.baichuan.android.auth.c.a) c.a.get(Integer.valueOf(AlibcAuthActivity.a));
        }

        public final void a() {
            this.b.b = false;
            this.b.a();
        }

        public final void a(String str, String str2) {
            this.b.b = true;
            this.b.a();
        }

        public final void b() {
            this.a.c.b();
            c.a.remove(Integer.valueOf(AlibcAuthActivity.a));
            this.b.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(l.a(this, "layout", "com_alibc_auth_actiivty"));
        a = getIntent().getExtras().getInt("authId");
        com.alibaba.baichuan.android.auth.c.a aVar = (com.alibaba.baichuan.android.auth.c.a) c.a.get(Integer.valueOf(a));
        if (aVar.b == null) {
            c.a(aVar.a, new b());
        } else {
            a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r4) {
        /*
        r3 = this;
        r4 = r4.getId();
        r0 = "id";
        r1 = "open_auth_btn_cancel";
        r0 = com.alibaba.baichuan.android.trade.utils.l.a(r3, r0, r1);
        if (r4 == r0) goto L_0x0096;
    L_0x000e:
        r0 = "id";
        r1 = "open_auth_btn_close";
        r0 = com.alibaba.baichuan.android.trade.utils.l.a(r3, r0, r1);
        if (r4 != r0) goto L_0x001a;
    L_0x0018:
        goto L_0x0096;
    L_0x001a:
        r0 = "id";
        r1 = "open_auth_btn_grant";
        r0 = com.alibaba.baichuan.android.trade.utils.l.a(r3, r0, r1);
        if (r4 != r0) goto L_0x0095;
    L_0x0024:
        monitor-enter(r3);
        r4 = com.alibaba.baichuan.android.auth.c.a;	 Catch:{ all -> 0x0092 }
        r0 = a;	 Catch:{ all -> 0x0092 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0092 }
        r4 = r4.get(r0);	 Catch:{ all -> 0x0092 }
        r4 = (com.alibaba.baichuan.android.auth.c.a) r4;	 Catch:{ all -> 0x0092 }
        if (r4 != 0) goto L_0x003a;
    L_0x0035:
        r3.finish();	 Catch:{ all -> 0x0092 }
        monitor-exit(r3);	 Catch:{ all -> 0x0092 }
        return;
    L_0x003a:
        r0 = "id";
        r1 = "com_alibc_auth_progressbar";
        r0 = com.alibaba.baichuan.android.trade.utils.l.a(r3, r0, r1);	 Catch:{ all -> 0x0092 }
        r0 = r3.findViewById(r0);	 Catch:{ all -> 0x0092 }
        r1 = 0;
        r0.setVisibility(r1);	 Catch:{ all -> 0x0092 }
        r0 = "id";
        r2 = "open_auth_rl";
        r0 = com.alibaba.baichuan.android.trade.utils.l.a(r3, r0, r2);	 Catch:{ all -> 0x0092 }
        r0 = r3.findViewById(r0);	 Catch:{ all -> 0x0092 }
        r2 = 8;
        r0.setVisibility(r2);	 Catch:{ all -> 0x0092 }
        r0 = r4.a;	 Catch:{ all -> 0x0092 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0092 }
        if (r0 != 0) goto L_0x0086;
    L_0x0063:
        r0 = r4.a;	 Catch:{ all -> 0x0092 }
        r0 = com.alibaba.baichuan.android.auth.d.b(r0);	 Catch:{ all -> 0x0092 }
        if (r0 == 0) goto L_0x007b;
    L_0x006b:
        r2 = r0.size();	 Catch:{ all -> 0x0092 }
        if (r2 > 0) goto L_0x0072;
    L_0x0071:
        goto L_0x007b;
    L_0x0072:
        r4 = new com.alibaba.baichuan.android.auth.AlibcAuthActivity$a;	 Catch:{ all -> 0x0092 }
        r4.<init>();	 Catch:{ all -> 0x0092 }
        com.alibaba.baichuan.android.auth.c.a(r0, r4, r1);	 Catch:{ all -> 0x0092 }
        goto L_0x0090;
    L_0x007b:
        r4 = r4.a;	 Catch:{ all -> 0x0092 }
        r0 = new com.alibaba.baichuan.android.auth.AlibcAuthActivity$b;	 Catch:{ all -> 0x0092 }
        r0.<init>();	 Catch:{ all -> 0x0092 }
        com.alibaba.baichuan.android.auth.c.a(r4, r0);	 Catch:{ all -> 0x0092 }
        goto L_0x0090;
    L_0x0086:
        r4 = r4.b;	 Catch:{ all -> 0x0092 }
        r0 = new com.alibaba.baichuan.android.auth.AlibcAuthActivity$a;	 Catch:{ all -> 0x0092 }
        r0.<init>();	 Catch:{ all -> 0x0092 }
        com.alibaba.baichuan.android.auth.c.a(r4, r0, r1);	 Catch:{ all -> 0x0092 }
    L_0x0090:
        monitor-exit(r3);	 Catch:{ all -> 0x0092 }
        return;
    L_0x0092:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0092 }
        throw r4;
    L_0x0095:
        return;
    L_0x0096:
        monitor-enter(r3);
        r4 = com.alibaba.baichuan.android.auth.c.a;	 Catch:{ all -> 0x00bc }
        r0 = a;	 Catch:{ all -> 0x00bc }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00bc }
        r4 = r4.get(r0);	 Catch:{ all -> 0x00bc }
        r4 = (com.alibaba.baichuan.android.auth.c.a) r4;	 Catch:{ all -> 0x00bc }
        if (r4 == 0) goto L_0x00b7;
    L_0x00a7:
        r4 = r4.c;	 Catch:{ all -> 0x00bc }
        r4.b();	 Catch:{ all -> 0x00bc }
        r4 = com.alibaba.baichuan.android.auth.c.a;	 Catch:{ all -> 0x00bc }
        r0 = a;	 Catch:{ all -> 0x00bc }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00bc }
        r4.remove(r0);	 Catch:{ all -> 0x00bc }
    L_0x00b7:
        r3.finish();	 Catch:{ all -> 0x00bc }
        monitor-exit(r3);	 Catch:{ all -> 0x00bc }
        return;
    L_0x00bc:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00bc }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.auth.AlibcAuthActivity.onClick(android.view.View):void");
    }

    private void a() {
        if (!isFinishing()) {
            CharSequence charSequence;
            com.alibaba.baichuan.android.auth.c.a aVar = (com.alibaba.baichuan.android.auth.c.a) c.a.get(Integer.valueOf(a));
            String charSequence2 = getApplicationInfo().loadLabel(getPackageManager()).toString();
            TextView textView = (TextView) findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_title"));
            TextView textView2 = (TextView) findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_desc"));
            TextView textView3 = (TextView) findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_btn_grant"));
            findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_rl")).setVisibility(0);
            findViewById(l.a(this, AgooConstants.MESSAGE_ID, "com_alibc_auth_progressbar")).setVisibility(8);
            if (this.b) {
                textView.setText("淘宝授权失败");
                textView2.setText("请确认网络环境后再试试？");
                charSequence = "重试";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence2);
                stringBuilder.append("将获取");
                textView.setText(stringBuilder.toString());
                CharSequence stringBuffer = new StringBuffer();
                Object a;
                String stringBuilder2;
                StringBuilder stringBuilder3;
                if (aVar.a != null) {
                    for (String stringBuilder22 : d.b(aVar.a)) {
                        a = d.a(stringBuilder22);
                        if (TextUtils.isEmpty(a)) {
                            stringBuilder = new StringBuilder("访问您淘宝账号信息的权限(");
                            stringBuilder.append(stringBuilder22);
                            stringBuilder.append(k.t);
                            stringBuilder22 = stringBuilder.toString();
                        } else {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(a);
                            stringBuilder3.append("\n");
                            stringBuilder22 = stringBuilder3.toString();
                        }
                        stringBuffer.append(stringBuilder22);
                    }
                } else if (aVar.b != null) {
                    for (String stringBuilder222 : aVar.b) {
                        a = d.a(stringBuilder222);
                        if (TextUtils.isEmpty(a)) {
                            stringBuilder = new StringBuilder("访问您淘宝账号信息的权限(");
                            stringBuilder.append(stringBuilder222);
                            stringBuilder.append(k.t);
                            stringBuilder222 = stringBuilder.toString();
                        } else {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(a);
                            stringBuilder3.append("\n");
                            stringBuilder222 = stringBuilder3.toString();
                        }
                        stringBuffer.append(stringBuilder222);
                    }
                }
                stringBuffer.delete(stringBuffer.lastIndexOf("\n"), stringBuffer.length());
                if (TextUtils.isEmpty(stringBuffer)) {
                    stringBuffer = "访问您淘宝账号信息的权限";
                }
                textView2.setText(stringBuffer);
                charSequence = "确认授权";
            }
            textView3.setText(charSequence);
            textView3.setOnClickListener(this);
            findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_btn_cancel")).setOnClickListener(this);
            findViewById(l.a(this, AgooConstants.MESSAGE_ID, "open_auth_btn_close")).setOnClickListener(this);
        }
    }
}
