package com.huawei.hms.update.e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.hms.base.R;

/* compiled from: ConfirmDialogs */
public final class e {

    /* compiled from: ConfirmDialogs */
    private static abstract class a extends b {
        protected abstract int h();

        protected abstract int i();

        protected abstract int j();

        private a() {
        }

        public AlertDialog a() {
            Builder builder = new Builder(f(), g());
            builder.setMessage(h());
            builder.setPositiveButton(i(), new f(this));
            builder.setNegativeButton(j(), new g(this));
            return builder.create();
        }
    }

    /* compiled from: ConfirmDialogs */
    public static class b extends a {
        public b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        protected int h() {
            return R.string.hms_download_retry;
        }

        protected int i() {
            return R.string.hms_retry;
        }

        protected int j() {
            return R.string.hms_cancel;
        }
    }

    /* compiled from: ConfirmDialogs */
    public static class c extends a {
        public c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        protected int h() {
            return R.string.hms_abort_message;
        }

        protected int i() {
            return R.string.hms_abort;
        }

        protected int j() {
            return R.string.hms_cancel;
        }
    }
}
