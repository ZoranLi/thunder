package com.xunlei.downloadprovider.database.greendao;

import com.alipay.sdk.cons.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.greendao.Property;

public class VideoPlayRecordDao$Properties {
    public static final Property Cid = new Property(11, String.class, "cid", false, "cid");
    public static final Property CoverUrl = new Property(4, String.class, "coverUrl", false, "cover_url");
    public static final Property DownloadUrl = new Property(10, String.class, "downloadUrl", false, "download_url");
    public static final Property Duration = new Property(5, Long.TYPE, SocializeProtocolConstants.DURATION, false, SocializeProtocolConstants.DURATION);
    public static final Property Gcid = new Property(12, String.class, "gcid", false, "gcid");
    public static final Property Id = new Property(0, Long.class, AgooConstants.MESSAGE_ID, true, "_id");
    public static final Property LastPlayTimestamp = new Property(8, Long.TYPE, "lastPlayTimestamp", false, "last_play_timestamp");
    public static final Property MaxPlayedTime = new Property(7, Long.TYPE, "maxPlayedTime", false, "max_played_time");
    public static final Property MovieId = new Property(13, String.class, "movieId", false, "movie_id");
    public static final Property Name = new Property(2, String.class, c.e, false, c.e);
    public static final Property PlayUrl = new Property(3, String.class, "playUrl", false, "play_url");
    public static final Property PlayedTime = new Property(6, Long.TYPE, "playedTime", false, "played_time");
    public static final Property Size = new Property(9, Long.TYPE, "size", false, "size");
    public static final Property TypeTag = new Property(1, String.class, "typeTag", false, "type_tag");
}
