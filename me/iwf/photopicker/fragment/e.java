package me.iwf.photopicker.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import me.iwf.photopicker.b.b;

/* compiled from: PhotoPickerFragment */
final class e implements OnItemClickListener {
    final /* synthetic */ Button a;
    final /* synthetic */ PhotoPickerFragment b;

    e(PhotoPickerFragment photoPickerFragment, Button button) {
        this.b = photoPickerFragment;
        this.a = button;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.b.i.dismiss();
        this.a.setText(((b) this.b.f.get(i)).c);
        this.b.a.h = i;
        this.b.a.notifyDataSetChanged();
    }
}
