package me.iwf.photopicker.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import me.iwf.photopicker.R;
import me.iwf.photopicker.a.a;
import me.iwf.photopicker.a.g;
import me.iwf.photopicker.b.b;
import me.iwf.photopicker.d.c;
import me.iwf.photopicker.d.f;

public class PhotoPickerFragment extends Fragment {
    public static int c = 4;
    public a a;
    int b;
    private c d;
    private g e;
    private List<b> f;
    private ArrayList<String> g;
    private int h = 30;
    private ListPopupWindow i;
    private RequestManager j;

    public static PhotoPickerFragment a(boolean z, boolean z2, boolean z3, int i, int i2, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("camera", z);
        bundle.putBoolean("gif", z2);
        bundle.putBoolean("PREVIEW_ENABLED", z3);
        bundle.putInt("column", i);
        bundle.putInt("count", i2);
        bundle.putStringArrayList("origin", arrayList);
        z = new PhotoPickerFragment();
        z.setArguments(bundle);
        return z;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.j = Glide.with(this);
        this.f = new ArrayList();
        this.g = getArguments().getStringArrayList("origin");
        this.b = getArguments().getInt("column", 3);
        boolean z = getArguments().getBoolean("camera", true);
        bundle = getArguments().getBoolean("PREVIEW_ENABLED", true);
        this.a = new a(getActivity(), this.j, this.f, this.g, this.b);
        this.a.d = z;
        this.a.e = bundle;
        bundle = new Bundle();
        bundle.putBoolean("SHOW_GIF", getArguments().getBoolean("gif"));
        Context activity = getActivity();
        activity.getSupportLoaderManager().initLoader(0, bundle, new a(activity, new d(this)));
        this.d = new c(getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.__picker_fragment_photo_picker, viewGroup, false);
        this.e = new g(this.j, this.f);
        RecyclerView recyclerView = (RecyclerView) layoutInflater.findViewById(R.id.rv_photos);
        bundle = new StaggeredGridLayoutManager(this.b, 1);
        bundle.setGapStrategy(2);
        recyclerView.setLayoutManager(bundle);
        recyclerView.setAdapter(this.a);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Button button = (Button) layoutInflater.findViewById(R.id.button);
        this.i = new ListPopupWindow(getActivity());
        this.i.setWidth(-1);
        this.i.setAnchorView(button);
        this.i.setAdapter(this.e);
        this.i.setModal(true);
        this.i.setDropDownGravity(80);
        this.i.setOnItemClickListener(new e(this, button));
        this.a.b = new f(this);
        this.a.c = new g(this);
        button.setOnClickListener(new h(this));
        recyclerView.addOnScrollListener(new i(this));
        return layoutInflater;
    }

    private void b() {
        try {
            c cVar = this.d;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(cVar.b.getPackageManager()) != null) {
                String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ENGLISH).format(new Date());
                StringBuilder stringBuilder = new StringBuilder("JPEG_");
                stringBuilder.append(format);
                stringBuilder.append(".jpg");
                format = stringBuilder.toString();
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                if (externalStoragePublicDirectory.exists() || externalStoragePublicDirectory.mkdir()) {
                    Parcelable uriForFile;
                    File file = new File(externalStoragePublicDirectory, format);
                    cVar.a = file.getAbsolutePath();
                    if (VERSION.SDK_INT >= 24) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(cVar.b.getApplicationInfo().packageName);
                        stringBuilder2.append(".provider");
                        uriForFile = FileProvider.getUriForFile(cVar.b.getApplicationContext(), stringBuilder2.toString(), file);
                    } else {
                        uriForFile = Uri.fromFile(file);
                    }
                    if (uriForFile != null) {
                        intent.putExtra("output", uriForFile);
                    }
                } else {
                    throw new IOException();
                }
            }
            startActivityForResult(intent, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            if (this.d == 0) {
                this.d = new c(getActivity());
            }
            i = this.d;
            i2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            if (TextUtils.isEmpty(i.a) == null) {
                i2.setData(Uri.fromFile(new File(i.a)));
                i.b.sendBroadcast(i2);
            }
            if (this.f.size() > 0) {
                i = this.d.a;
                b bVar = (b) this.f.get(0);
                bVar.e.add(0, new me.iwf.photopicker.b.a(i.hashCode(), i));
                bVar.b = i;
                this.a.notifyDataSetChanged();
            }
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (iArr.length > null && iArr[null] == null) {
            if (i != 1 && i != 3) {
                return;
            }
            if (f.a(this) != 0 && f.b(this) != 0) {
                b();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        c cVar = this.d;
        if (!(bundle == null || cVar.a == null)) {
            bundle.putString("mCurrentPhotoPath", cVar.a);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onViewStateRestored(Bundle bundle) {
        c cVar = this.d;
        if (bundle != null && bundle.containsKey("mCurrentPhotoPath")) {
            cVar.a = bundle.getString("mCurrentPhotoPath");
        }
        super.onViewStateRestored(bundle);
    }

    public final void a() {
        if (this.e != null) {
            int count = this.e.getCount();
            if (count >= c) {
                count = c;
            }
            if (this.i != null) {
                this.i.setHeight(count * getResources().getDimensionPixelOffset(R.dimen.__picker_item_directory_height));
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            for (b bVar : this.f) {
                bVar.a().clear();
                bVar.e.clear();
            }
            this.f.clear();
            this.f = null;
        }
    }

    static /* synthetic */ void h(PhotoPickerFragment photoPickerFragment) {
        boolean z;
        if (photoPickerFragment == null) {
            z = true;
        } else {
            z = me.iwf.photopicker.d.a.a(photoPickerFragment.getActivity());
        }
        if (z) {
            photoPickerFragment.j.resumeRequests();
        }
    }
}
