package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RedPacketConditionsInfo implements Serializable {
    public String count_down;
    public String detatil_page_image;
    public String detatil_page_subtitle;
    public String detatil_page_title;
    public int download_type = 0;
    public long limitSpeed = 0;
    public String list_page_image;
    public String list_page_title;
    public String name;
    public List<String> redpack_type = new ArrayList();
    public String task_finish_count;
    public String user_type;
}
