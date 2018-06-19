package me.iwf.photopicker.d;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.taobao.accs.flowcontrol.FlowControl;
import com.xunlei.download.Downloads.Impl;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;

/* compiled from: MediaStoreHelper */
public final class d {

    /* compiled from: MediaStoreHelper */
    public interface b {
        void a(List<me.iwf.photopicker.b.b> list);
    }

    /* compiled from: MediaStoreHelper */
    private static class a implements LoaderCallbacks<Cursor> {
        private Context a;
        private b b;

        public final void onLoaderReset(Loader<Cursor> loader) {
        }

        public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
            Cursor cursor = (Cursor) obj;
            if (cursor != null) {
                loader = new ArrayList();
                me.iwf.photopicker.b.b bVar = new me.iwf.photopicker.b.b();
                bVar.c = this.a.getString(R.string.__picker_all_image);
                bVar.a = FlowControl.SERVICE_ALL;
                while (cursor.moveToNext()) {
                    int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_display_name"));
                    String string3 = cursor.getString(cursor.getColumnIndexOrThrow(Impl._DATA));
                    if (((long) cursor.getInt(cursor.getColumnIndexOrThrow("_size"))) >= 1) {
                        me.iwf.photopicker.b.b bVar2 = new me.iwf.photopicker.b.b();
                        bVar2.a = string;
                        bVar2.c = string2;
                        if (loader.contains(bVar2)) {
                            ((me.iwf.photopicker.b.b) loader.get(loader.indexOf(bVar2))).a(i, string3);
                        } else {
                            bVar2.b = string3;
                            bVar2.a(i, string3);
                            bVar2.d = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                            loader.add(bVar2);
                        }
                        bVar.a(i, string3);
                    }
                }
                if (bVar.a().size() > null) {
                    bVar.b = (String) bVar.a().get(0);
                }
                loader.add(0, bVar);
                if (this.b != null) {
                    this.b.a(loader);
                }
            }
        }

        public a(Context context, b bVar) {
            this.a = context;
            this.b = bVar;
        }

        public final Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new g(this.a, bundle.getBoolean("SHOW_GIF", false));
        }
    }
}
