package com.huawei.hms.update.e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.hms.base.R;

/* compiled from: PromptDialogs */
public final class m {

    /* compiled from: PromptDialogs */
    private static abstract class a extends b {
        protected abstract int h();

        private a() {
        }

        public AlertDialog a() {
            Builder builder = new Builder(f(), g());
            builder.setMessage(h());
            builder.setPositiveButton(i(), new n(this));
            return builder.create();
        }

        protected int i() {
            return R.string.hms_confirm;
        }
    }

    /* compiled from: PromptDialogs */
    public static class b extends a {
        public b() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        protected int h() {
            return R.string.hms_check_failure;
        }
    }

    /* compiled from: PromptDialogs */
    public static class c extends a {
        public c() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        protected int h() {
            return R.string.hms_download_failure;
        }
    }

    /* compiled from: PromptDialogs */
    public static class d extends a {
        public d() {
            super();
        }

        public /* bridge */ /* synthetic */ AlertDialog a() {
            return super.a();
        }

        protected int h() {
            return R.string.hms_download_no_space;
        }
    }
}
