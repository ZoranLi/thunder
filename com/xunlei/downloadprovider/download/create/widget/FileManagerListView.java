package com.xunlei.downloadprovider.download.create.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.av;
import com.xunlei.xllib.android.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileManagerListView extends ListView {
    public static final Comparator<File> a = new a();
    private Context b;
    private c c;
    private boolean d = false;
    private List<av> e;
    private String f = null;
    private int g;
    private String h = e.a();
    private List<String> i = new ArrayList();
    private List<av> j;
    private ArrayList<String> k = null;
    private boolean l = false;
    private String m = null;
    private b n;
    private TextView o;
    private Comparator<File> p = new b(this);

    private static final class a implements Comparator<File> {
        private a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((File) obj).getName().compareToIgnoreCase(((File) obj2).getName());
        }
    }

    public class b extends BaseAdapter {
        final /* synthetic */ FileManagerListView a;

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public b(FileManagerListView fileManagerListView) {
            this.a = fileManagerListView;
        }

        public final int getCount() {
            return this.a.j.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            View inflate;
            av avVar = (av) this.a.j.get(i);
            Object b = avVar.b();
            String str = avVar.h;
            EFileCategoryType eFileCategoryType = avVar.f;
            CharSequence c = avVar.c();
            String str2 = null;
            if (view == null) {
                dVar = new d(r0.a);
                inflate = LayoutInflater.from(r0.a.b).inflate(R.layout.file_manage_view_item, null);
                dVar.a = inflate.findViewById(R.id.creat_task_container);
                dVar.b = inflate.findViewById(R.id.path_choice_container);
                dVar.c = (ImageView) inflate.findViewById(R.id.bt_item_local_file_icon);
                dVar.d = (TextView) inflate.findViewById(R.id.bt_item_local_file_name);
                dVar.h = (TextView) inflate.findViewById(R.id.bt_item_local_file_desc);
                dVar.e = (TextView) inflate.findViewById(R.id.tv_file_name);
                dVar.f = (TextView) inflate.findViewById(R.id.tv_file_size);
                dVar.g = (TextView) inflate.findViewById(R.id.tv_file_date);
                inflate.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
                inflate = view;
            }
            if (r0.a.l && eFileCategoryType == EFileCategoryType.E_XLDIR_CATEGORY) {
                dVar.a.setVisibility(8);
                dVar.b.setVisibility(0);
                dVar.e.setText(b);
                dVar.g.setText(c);
                if (avVar.c != null) {
                    if (new File(avVar.c).isDirectory()) {
                        str2 = avVar.c;
                    } else {
                        str2 = avVar.c.substring(0, avVar.c.lastIndexOf("/") + 1);
                    }
                }
                if (avVar.a) {
                    dVar.f.setVisibility(0);
                    long b2 = e.b(str2);
                    long a = b2 - e.a(str2);
                    StringBuilder stringBuilder = new StringBuilder("可用:");
                    stringBuilder.append(ConvertUtil.convertFileSize(a, 2));
                    stringBuilder.append("  总大小:");
                    stringBuilder.append(ConvertUtil.convertFileSize(b2, 2));
                    dVar.f.setText(stringBuilder.toString());
                    dVar.g.setVisibility(8);
                } else {
                    dVar.f.setVisibility(8);
                    dVar.g.setVisibility(0);
                }
            } else {
                dVar.a.setVisibility(0);
                dVar.b.setVisibility(8);
                dVar.d.setText(b);
            }
            if (EFileCategoryType.E_XLFILE_UPPER != eFileCategoryType) {
                if (EFileCategoryType.E_XLDIR_CATEGORY != eFileCategoryType) {
                    switch (c.a[XLFileTypeUtil.getFileCategoryTypeByName(b).ordinal()]) {
                        case 1:
                            dVar.c.setImageResource(R.drawable.ic_dl_music);
                            break;
                        case 2:
                            dVar.c.setImageResource(R.drawable.ic_dl_video);
                            break;
                        case 3:
                            dVar.c.setImageResource(R.drawable.ic_dl_apk);
                            break;
                        case 4:
                            dVar.c.setImageResource(R.drawable.ic_dl_rar);
                            break;
                        case 5:
                            dVar.c.setImageResource(R.drawable.ic_dl_text);
                            break;
                        case 6:
                            dVar.c.setImageResource(R.drawable.ic_dl_image);
                            break;
                        case 7:
                            dVar.c.setImageResource(R.drawable.ic_dl_torrent);
                            break;
                        case 8:
                            dVar.c.setImageResource(R.drawable.ic_dl_other);
                            break;
                        default:
                            break;
                    }
                } else if (str.equals("../")) {
                    dVar.c.setImageResource(R.drawable.file_manage_up);
                } else {
                    if (!str.equals(r0.a.b.getString(R.string.primary_sdcard))) {
                        if (!str.equals(r0.a.b.getString(R.string.saved_sdcard))) {
                            dVar.c.setImageResource(R.drawable.ic_dl_folder);
                        }
                    }
                    dVar.c.setImageResource(R.drawable.fileexplorer_nosdcard);
                }
            } else {
                dVar.c.setImageResource(R.drawable.file_manage_up);
            }
            if (r0.a.d) {
                CharSequence charSequence = avVar.c;
                int lastIndexOf = charSequence.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    charSequence = charSequence.substring(0, lastIndexOf);
                }
                dVar.h.setVisibility(0);
                dVar.h.setText(charSequence);
            } else {
                dVar.h.setVisibility(8);
            }
            return inflate;
        }
    }

    public interface c {
        boolean a(String str);
    }

    public final class d {
        public View a;
        public View b;
        public ImageView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        final /* synthetic */ FileManagerListView i;

        public d(FileManagerListView fileManagerListView) {
            this.i = fileManagerListView;
        }
    }

    public FileManagerListView(Context context) {
        super(context);
        this.b = context;
    }

    public FileManagerListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
    }

    public FileManagerListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
    }

    public void setJustShowDir(boolean z) {
        this.l = z;
    }

    public void setNeedMoreInfo(boolean z) {
        this.d = z;
    }

    public void setHomePageData(List<av> list) {
        this.e = list;
    }

    private boolean b(String str) {
        if (this.e != null) {
            if (str != null) {
                for (av avVar : this.e) {
                    if (avVar != null) {
                        String str2 = avVar.c;
                        if (str2 != null && com.xunlei.downloadprovider.h.e.c(str2, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final void a(String str, List<String> list) {
        if ("///homepage".equals(str)) {
            this.g = 1003;
            this.f = null;
        } else if (this.m == null || !com.xunlei.downloadprovider.h.e.c("///homepage", this.m)) {
            this.g = 1000;
        } else {
            this.g = 1003;
            this.f = str;
        }
        this.h = str;
        this.i.clear();
        if (list != null) {
            this.i.addAll(list);
        }
        setFadingEdgeLength(0);
        setScrollingCacheEnabled(false);
        this.j = getData();
        this.n = new b(this);
        setAdapter(this.n);
        a();
        setOnItemClickListener(new a(this));
        this.f = null;
    }

    public final void a(String str) {
        this.h = str;
        if (this.g == 1003) {
            if ("///homepage".equals(this.h) != null) {
                this.f = null;
            } else if (b(this.h) != null && this.f == null) {
                new StringBuilder("get entrance : ").append(this.h);
                this.f = this.h;
            }
        }
        if (TextUtils.isEmpty(this.h) == null) {
            a();
        }
    }

    public final void a() {
        CharSequence charSequence;
        String a;
        String b;
        String str;
        Object obj;
        Object obj2;
        StringBuilder stringBuilder;
        this.j = getData();
        if (this.g != 1000) {
            if (this.g != 1003) {
                charSequence = this.g == 1002 ? this.m.startsWith("///homepage") ? "/" : this.m : null;
                if (this.o != null) {
                    a = com.xunlei.xllib.android.e.a.a();
                    b = com.xunlei.xllib.android.e.a.b();
                    str = charSequence != null ? "" : charSequence;
                    obj = null;
                    obj2 = (a != null || a.length() <= 0 || e.b(a) <= 0) ? null : 1;
                    if (b != null && b.length() > 0 && e.b(b) > 0) {
                        obj = 1;
                    }
                    if (obj2 != null || obj == null) {
                        if (obj2 == null) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            }
                        } else if (obj != null) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            }
                        }
                    } else if (a.length() > b.length()) {
                        if (str.startsWith(b)) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            }
                        }
                        if (str.startsWith(a)) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            }
                        }
                    } else {
                        if (str.startsWith(a)) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.primary_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(a, stringBuilder.toString());
                            }
                        }
                        if (str.startsWith(b)) {
                            if (this.l) {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard_name));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            } else {
                                stringBuilder = new StringBuilder("/");
                                stringBuilder.append(this.b.getString(R.string.saved_sdcard));
                                stringBuilder.append("/");
                                charSequence = str.replaceFirst(b, stringBuilder.toString());
                            }
                        }
                    }
                    this.o.setText(charSequence);
                }
                this.n.notifyDataSetChanged();
            }
        }
        if (this.h.equals("///homepage")) {
            charSequence = "/";
        } else {
            charSequence = this.h;
            if (!(charSequence == null || charSequence.endsWith("/"))) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(charSequence);
                stringBuilder2.append("/");
                charSequence = stringBuilder2.toString();
            }
        }
        if (this.o != null) {
            a = com.xunlei.xllib.android.e.a.a();
            b = com.xunlei.xllib.android.e.a.b();
            if (charSequence != null) {
            }
            obj = null;
            if (a != null) {
            }
            obj = 1;
            if (obj2 != null) {
            }
            if (obj2 == null) {
                if (obj != null) {
                    if (this.l) {
                        stringBuilder = new StringBuilder("/");
                        stringBuilder.append(this.b.getString(R.string.saved_sdcard));
                        stringBuilder.append("/");
                        charSequence = str.replaceFirst(b, stringBuilder.toString());
                    } else {
                        stringBuilder = new StringBuilder("/");
                        stringBuilder.append(this.b.getString(R.string.saved_sdcard_name));
                        stringBuilder.append("/");
                        charSequence = str.replaceFirst(b, stringBuilder.toString());
                    }
                }
            } else if (this.l) {
                stringBuilder = new StringBuilder("/");
                stringBuilder.append(this.b.getString(R.string.primary_sdcard));
                stringBuilder.append("/");
                charSequence = str.replaceFirst(a, stringBuilder.toString());
            } else {
                stringBuilder = new StringBuilder("/");
                stringBuilder.append(this.b.getString(R.string.primary_sdcard_name));
                stringBuilder.append("/");
                charSequence = str.replaceFirst(a, stringBuilder.toString());
            }
            this.o.setText(charSequence);
        }
        this.n.notifyDataSetChanged();
    }

    private List<av> getData() {
        new StringBuilder("mType = ").append(this.g);
        switch (this.g) {
            case 1000:
                return getDataFromFilePathAndFilter();
            case 1002:
                return c(this.k);
            case 1003:
                new StringBuilder("entrance = ").append(this.f);
                if (this.f == null) {
                    return this.e;
                }
                return getDataFromFilePathAndFilter();
            default:
                return null;
        }
    }

    @SuppressLint({"DefaultLocale"})
    private List<av> getDataFromFilePathAndFilter() {
        List<av> dataFromFilePath = getDataFromFilePath();
        if (this.i != null) {
            if (this.i.size() != 0) {
                List<av> arrayList = new ArrayList();
                for (av avVar : dataFromFilePath) {
                    if (avVar != null) {
                        EFileCategoryType eFileCategoryType = avVar.f;
                        if (eFileCategoryType != EFileCategoryType.E_XLDIR_CATEGORY) {
                            if (eFileCategoryType != EFileCategoryType.E_XLFILE_UPPER) {
                                if (this.i.contains(com.xunlei.downloadprovider.h.e.a(avVar.b()))) {
                                    arrayList.add(avVar);
                                }
                            }
                        }
                        arrayList.add(avVar);
                    }
                }
                return arrayList;
            }
        }
        return dataFromFilePath;
    }

    @SuppressLint({"DefaultLocale"})
    private List<av> getDataFromFilePath() {
        List<av> arrayList = new ArrayList();
        File file = new File(this.h);
        File[] listFiles = file.listFiles();
        new StringBuilder("getDataFromFilePath mDir = ").append(this.h);
        if (d()) {
            arrayList.add(a(file));
        }
        if (listFiles != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DownloadConfig.getDownloadDirName().toLowerCase());
            stringBuilder.append("/");
            CharSequence stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.h);
            stringBuilder3.append("/");
            if (stringBuilder3.toString().toLowerCase().contains(stringBuilder2)) {
                Arrays.sort(listFiles, this.p);
            } else {
                Arrays.sort(listFiles, a);
            }
            for (File file2 : listFiles) {
                if (!(file2 == null || file2.getName().startsWith(".") || (this.l && !file2.isDirectory()))) {
                    av avVar = new av();
                    avVar.a(file2.getPath());
                    if (file2.isDirectory()) {
                        avVar.f = EFileCategoryType.E_XLDIR_CATEGORY;
                    }
                    String path = file2.getPath();
                    if (!(path == null || path.endsWith("/"))) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(path);
                        stringBuilder4.append("/");
                    }
                    arrayList.add(avVar);
                }
            }
        }
        return arrayList;
    }

    private av a(File file) {
        av avVar = new av();
        if (this.f != null && com.xunlei.downloadprovider.h.e.c(this.f, this.h)) {
            file = "///homepage";
        } else if (b(this.h)) {
            file = "///homepage";
            this.f = this.h;
        } else {
            file = file.getParent();
            if (!(file == null || file.endsWith("/"))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file);
                stringBuilder.append("/");
                file = stringBuilder.toString();
            }
        }
        avVar.c = file;
        avVar.h = "../";
        avVar.b("返回上一级");
        avVar.f = EFileCategoryType.E_XLFILE_UPPER;
        return avVar;
    }

    private boolean d() {
        if (this.m != null) {
            if (this.h != null) {
                if (com.xunlei.downloadprovider.h.e.c(this.m, this.h)) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    private static List<av> c(ArrayList<String> arrayList) {
        List<av> arrayList2 = new ArrayList();
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str = (String) arrayList.next();
            av avVar = new av();
            avVar.a(str);
            arrayList2.add(avVar);
        }
        return arrayList2;
    }

    public void setPathView(TextView textView) {
        this.o = textView;
    }

    public void setLimitInDirectory(String str) {
        if (str != null) {
            this.m = str;
            if (this.m.endsWith("/") == null) {
                str = new StringBuilder();
                str.append(this.m);
                str.append("/");
                this.m = str.toString();
            }
        }
    }

    public void setOnFileOperateListener(c cVar) {
        this.c = cVar;
    }

    public final boolean b() {
        if (d()) {
            if (this.j == null || this.j.size() <= 0 || !"///homepage".equals(((av) this.j.get(0)).c)) {
                String a = a(new File(this.h)).a();
                if (!TextUtils.isEmpty(a)) {
                    a(a);
                    return true;
                }
            }
            a("///homepage");
            return true;
        }
        return false;
    }

    public final void c() {
        if (this.j != null) {
            this.j.clear();
            this.n.notifyDataSetChanged();
        }
    }

    public final void a(ArrayList<String> arrayList) {
        this.g = 1002;
        this.k = arrayList;
        this.h = null;
        a();
    }

    public final void b(String str, List<String> list) {
        if ("///homepage".equals(str)) {
            this.g = 1003;
            this.f = null;
        } else {
            this.g = 1000;
        }
        this.h = str;
        if (list != null) {
            this.i.addAll(list);
        } else {
            this.i.clear();
        }
        a();
    }

    public final void b(ArrayList<String> arrayList) {
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                String str = (String) arrayList.next();
                av avVar = new av();
                avVar.a(str);
                this.j.add(avVar);
            }
            this.n.notifyDataSetChanged();
        }
    }

    public String getCurrentPath() {
        return this.h;
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.download.create.widget.FileManagerListView r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;
        r0.<init>(r3);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0015;
    L_0x000b:
        r2 = r2.getContext();
        r3 = "文件不存在";
        com.xunlei.common.commonview.XLToast.showToast(r2, r3);
        return;
    L_0x0015:
        r0 = r2.c;
        if (r0 == 0) goto L_0x001f;
    L_0x0019:
        r2 = r2.c;
        r2.a(r3);
        return;
    L_0x001f:
        r0 = r2.b;	 Catch:{ IllegalArgumentException -> 0x0030, ActivityNotFoundException -> 0x0026 }
        r1 = 0;	 Catch:{ IllegalArgumentException -> 0x0030, ActivityNotFoundException -> 0x0026 }
        com.xunlei.downloadprovider.download.openwith.d.a(r0, r3, r1);	 Catch:{ IllegalArgumentException -> 0x0030, ActivityNotFoundException -> 0x0026 }
        return;
    L_0x0026:
        r2 = r2.getContext();
        r3 = "找不到适合的应用打开文件";
        com.xunlei.common.commonview.XLToast.showToast(r2, r3);
        return;
    L_0x0030:
        r2 = r2.getContext();
        r3 = "找不到适合的应用打开文件";
        com.xunlei.common.commonview.XLToast.showToast(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.create.widget.FileManagerListView.a(com.xunlei.downloadprovider.download.create.widget.FileManagerListView, java.lang.String):void");
    }
}
