package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import com.taobao.accs.AccsClientConfig;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent$IChatDateHeaderMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.a;
import java.util.Date;

public class DateHeaderMessage implements IChatMessageContent$IChatDateHeaderMessageContent {
    private Date mDate = null;

    public String content() {
        return "";
    }

    public String previewText() {
        return "";
    }

    public String reportType() {
        return AccsClientConfig.DEFAULT_CONFIGTAG;
    }

    public int type() {
        return 1001;
    }

    public DateHeaderMessage(Date date) {
        this.mDate = date;
    }

    public a checkMyself() {
        return new a(this.mDate != null, this.mDate != null ? "" : "日期不能为空");
    }

    public Date date() {
        return this.mDate;
    }
}
