package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;

public abstract class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

    public enum From {
        CHOICENESS("choiceness"),
        LIVE("zhibo"),
        REC_FOLLOW("rec_follow"),
        MY_FOLLOWING_LIST("list_follow"),
        SUB_LIST_REC_FOLLOW("list_rec_follow");
        
        private String from;

        private From(String str) {
            this.from = str;
        }

        public final String toString() {
            return this.from;
        }
    }

    public abstract void a(ap apVar);

    public ViewHolder(View view) {
        super(view);
    }
}
