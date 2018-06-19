package com.xiaomi.push.service;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.text.TextUtils;

class q implements OnAccountsUpdateListener {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public void onAccountsUpdated(Account[] accountArr) {
        if (accountArr != null && accountArr.length > 0) {
            p pVar;
            String str;
            Object obj = null;
            for (Account account : accountArr) {
                if (account != null && TextUtils.equals("com.xiaomi", account.type)) {
                    break;
                }
            }
            Account account2 = null;
            if (!(account2 == null || TextUtils.isEmpty(account2.name))) {
                obj = 1;
            }
            boolean c = r.a(p.a(this.a)).c();
            if (obj != null && !c) {
                r.a(p.a(this.a)).a(account2.name);
                pVar = this.a;
                str = account2.name;
            } else if (obj == null && c) {
                r.a(p.a(this.a)).a();
                pVar = this.a;
                str = "0";
            } else if (!(obj == null || !c || TextUtils.equals(r.a(p.a(this.a)).b(), account2.name))) {
                r.a(p.a(this.a)).a(account2.name);
                p.a(this.a, account2.name);
            }
            p.a(pVar, str);
        }
    }
}
