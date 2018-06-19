package com.xunlei.downloadprovider.vod.recordpublish.topicsearch;

import java.util.ArrayList;

public class VideoTagSearchResponse {
    public ArrayList<VideoTagDTO> tags;

    public static class VideoTagDTO {
        public String backgroundUrl;
        public long followCount;
        public boolean isFollowed;
        public String key;
        public long newCount;
        public String rowkey;
        public long videoCount;

        public void setRowkey(String str) {
            this.rowkey = str;
        }

        public String getRowkey() {
            return this.rowkey;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        public void setBackgroundUrl(String str) {
            this.backgroundUrl = str;
        }

        public String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        public void setFollowed(boolean z) {
            this.isFollowed = z;
        }

        public boolean getFollowed() {
            return this.isFollowed;
        }

        public void setNewCount(long j) {
            this.newCount = j;
        }

        public long getNewCount() {
            return this.newCount;
        }

        public void setFollowCount(long j) {
            this.followCount = j;
        }

        public long getFollowCount() {
            return this.followCount;
        }

        public void setVideoCount(long j) {
            this.videoCount = j;
        }

        public long getVideoCount() {
            return this.videoCount;
        }
    }

    public void setTags(ArrayList<VideoTagDTO> arrayList) {
        this.tags = arrayList;
    }

    public ArrayList<VideoTagDTO> getTags() {
        return this.tags;
    }
}
