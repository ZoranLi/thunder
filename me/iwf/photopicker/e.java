package me.iwf.photopicker;

import android.widget.Toast;
import me.iwf.photopicker.c.a;

/* compiled from: PhotoPickerActivity */
final class e implements a {
    final /* synthetic */ PhotoPickerActivity a;

    e(PhotoPickerActivity photoPickerActivity) {
        this.a = photoPickerActivity;
    }

    public final boolean a(me.iwf.photopicker.b.a aVar, int i) {
        this.a.d.setEnabled(i > 0);
        if (this.a.e <= 1) {
            i = this.a.c.a.f();
            if (i.contains(aVar.a) == null) {
                i.clear();
                this.a.c.a.notifyDataSetChanged();
            }
            return true;
        } else if (i > this.a.e) {
            Toast.makeText(this.a, this.a.getString(R.string.__picker_over_max_count_tips, new Object[]{Integer.valueOf(this.a.e)}), 1).show();
            return false;
        } else {
            this.a.d.setTitle(this.a.getString(R.string.__picker_done_with_count, new Object[]{Integer.valueOf(i), Integer.valueOf(this.a.e)}));
            return true;
        }
    }
}
