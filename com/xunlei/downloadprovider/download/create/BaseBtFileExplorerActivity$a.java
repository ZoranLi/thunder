package com.xunlei.downloadprovider.download.create;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.download.TorrentParser.ParseResult;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

class BaseBtFileExplorerActivity$a extends BaseAdapter {
    final /* synthetic */ BaseBtFileExplorerActivity a;
    private ParseResult b;

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.b.torrentInfo.mFileCount;
    }

    public final Object getItem(int i) {
        return this.b.torrentInfo.mSubFileInfo[i];
    }

    public BaseBtFileExplorerActivity$a(BaseBtFileExplorerActivity baseBtFileExplorerActivity, ParseResult parseResult) {
        this.a = baseBtFileExplorerActivity;
        this.b = parseResult;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        BaseBtFileExplorerActivity$b baseBtFileExplorerActivity$b;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.layout_task_detail_bt_list_item, null);
            baseBtFileExplorerActivity$b = new BaseBtFileExplorerActivity$b(this.a);
            baseBtFileExplorerActivity$b.b = (ZHTextView) view.findViewById(R.id.titleTextView);
            baseBtFileExplorerActivity$b.c = (TextView) view.findViewById(R.id.tagSize);
            baseBtFileExplorerActivity$b.a = (ImageView) view.findViewById(R.id.iconImageView);
            baseBtFileExplorerActivity$b.e = (TextView) view.findViewById(R.id.tagEpisode);
            baseBtFileExplorerActivity$b.d = (ImageView) view.findViewById(R.id.edit_mode_select_btn);
            view.setTag(baseBtFileExplorerActivity$b);
        }
        baseBtFileExplorerActivity$b = (BaseBtFileExplorerActivity$b) view.getTag();
        BaseBtFileExplorerActivity$c baseBtFileExplorerActivity$c = (BaseBtFileExplorerActivity$c) BaseBtFileExplorerActivity.d(this.a).get(i);
        baseBtFileExplorerActivity$b.b.setText(baseBtFileExplorerActivity$c.mFileName);
        baseBtFileExplorerActivity$b.b.requestLayout();
        baseBtFileExplorerActivity$b.c.setText(ConvertUtil.byteConvert(baseBtFileExplorerActivity$c.mFileSize));
        baseBtFileExplorerActivity$b.a.setImageResource(XLFileTypeUtil.getFileIconResId(baseBtFileExplorerActivity$c.mFileName));
        if (BaseBtFileExplorerActivity.e(this.a).contains(baseBtFileExplorerActivity$c)) {
            baseBtFileExplorerActivity$b.d.setImageResource(R.drawable.big_selected);
        } else {
            baseBtFileExplorerActivity$b.d.setImageResource(R.drawable.big_unselected);
        }
        if (TextUtils.isEmpty(baseBtFileExplorerActivity$c.a)) {
            baseBtFileExplorerActivity$b.e.setVisibility(8);
        } else {
            baseBtFileExplorerActivity$b.e.setVisibility(0);
            baseBtFileExplorerActivity$b.e.setText(baseBtFileExplorerActivity$c.a);
        }
        return view;
    }
}
