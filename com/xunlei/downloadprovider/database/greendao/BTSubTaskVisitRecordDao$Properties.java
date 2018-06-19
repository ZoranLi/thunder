package com.xunlei.downloadprovider.database.greendao;

import org.android.agoo.common.AgooConstants;
import org.greenrobot.greendao.Property;

public class BTSubTaskVisitRecordDao$Properties {
    public static final Property Id = new Property(0, Long.class, AgooConstants.MESSAGE_ID, true, "_id");
    public static final Property InfoHash = new Property(2, String.class, "infoHash", false, "bt_info_hash");
    public static final Property SubIndex = new Property(3, Integer.TYPE, "subIndex", false, "bt_sub_index");
    public static final Property TaskId = new Property(1, Long.TYPE, "taskId", false, "bt_task_id");
}
