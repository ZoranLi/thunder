package com.xunlei.tdlive.protocol;

public class XLLiveGetRemindTaskRequest extends XLLiveRequest {
    protected String onGetURL() {
        return "http://active.live.xunlei.com/caller?c=task&a=getReminderTaskNew";
    }
}
