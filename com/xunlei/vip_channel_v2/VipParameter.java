package com.xunlei.vip_channel_v2;

public class VipParameter {

    public static class AccResBtFileInfo {
        public int nBtFileIdx;
        public long nFileSize;
        public String sCid = "";
        public String sFileName = "";
        public String sGcid = "";

        public void fillEmptyString() {
            if (this.sFileName == null) {
                this.sFileName = "";
            }
            if (this.sGcid == null) {
                this.sGcid = "";
            }
            if (this.sCid == null) {
                this.sCid = "";
            }
        }
    }

    public static class AccResBtInfo {
        public String sBtTitle = "";
        public String sInfoHash = "";

        public void fillEmptyString() {
            if (this.sInfoHash == null) {
                this.sInfoHash = "";
            }
            if (this.sBtTitle == null) {
                this.sBtTitle = "";
            }
        }
    }

    public static class AccResDcdnHttpGather {
        public int nPriority;
        public int nReportTime;
        public int nResult;
        public long nTaskId;
        public String sResMsg;
        public AccResDcdnUrl[] szResList;

        public AccResDcdnHttpGather(int i, String str, int i2, int i3, long j) {
            this.nResult = i;
            this.sResMsg = str;
            this.nPriority = i2;
            this.nReportTime = i3;
            this.nTaskId = j;
        }
    }

    public static class AccResDcdnPeer {
        public int nCapabilityFlag;
        public long nFileBlockSize;
        public long nFilePos;
        public int nIp;
        public int nResLevel;
        public int nResPriority;
        public short nTcpPort;
        public short nUdpPort;
        public String sPeerId;

        public AccResDcdnPeer(String str, int i, short s, short s2, int i2, int i3, int i4, long j, long j2) {
            this.sPeerId = str;
            this.nIp = i;
            this.nTcpPort = s;
            this.nUdpPort = s2;
            this.nResLevel = i2;
            this.nResPriority = i3;
            this.nCapabilityFlag = i4;
            this.nFilePos = j;
            this.nFileBlockSize = j2;
        }
    }

    public static class AccResDcdnPeerGather {
        public int nPriority;
        public int nReportTime;
        public int nResult;
        public long nTaskId;
        public String sResMsg;
        public AccResDcdnPeer[] szResList;

        public AccResDcdnPeerGather(int i, String str, int i2, int i3, long j) {
            this.nResult = i;
            this.sResMsg = str;
            this.nPriority = i2;
            this.nReportTime = i3;
            this.nTaskId = j;
        }
    }

    public static class AccResDcdnUrl {
        public String sUrl;

        public AccResDcdnUrl(String str) {
            this.sUrl = str;
        }
    }

    public static class AccResGaosuGather {
        public int nMaxSpeed;
        public int nPriority;
        public int nResult;
        public long nValidTime;
        public String sAccessKey;
        public String sCheckOut;
        public String sCookie;
        public String sPublickKey;
        public String sResMsg;
        public AccResGaosuPeer[] szResList;

        public String makeVipAuthStr(String str) {
            return String.format("gcid=%s&public_key=%s&access_key=%s&valid_time=%d&max_speed=%d&cookie=%s&access_checkout=%s", new Object[]{str, this.sPublickKey, this.sAccessKey, Long.valueOf(this.nValidTime), Integer.valueOf(this.nMaxSpeed), this.sCookie, this.sCheckOut});
        }

        public AccResGaosuGather(int i, String str, int i2, String str2, String str3, long j, int i3, String str4, String str5) {
            this.nResult = i;
            this.sResMsg = str;
            this.nPriority = i2;
            this.sPublickKey = str2;
            this.sAccessKey = str3;
            this.nValidTime = j;
            this.nMaxSpeed = i3;
            this.sCheckOut = str4;
            this.sCookie = str5;
        }
    }

    public static class AccResGaosuPeer {
        public int nCdnType;
        public int nIp;
        public int nPeerAbility;
        public int nResLevel;
        public int nResPriority;
        public short nTcpPort;
        public short nUdpPort;
        public String sPeerId;

        public AccResGaosuPeer(String str, int i, short s, short s2, int i2, int i3, int i4, int i5) {
            this.sPeerId = str;
            this.nIp = i;
            this.nTcpPort = s;
            this.nUdpPort = s2;
            this.nResLevel = i2;
            this.nResPriority = i3;
            this.nPeerAbility = i4;
            this.nCdnType = i5;
        }
    }

    public static class AccResLixianGather {
        public int nPriority;
        public int nResult;
        public String sCookie;
        public String sResMsg;
        public AccResLixianUrl[] szResList;

        public AccResLixianGather(int i, String str, int i2, String str2) {
            this.nResult = i;
            this.sResMsg = str;
            this.nPriority = i2;
            this.sCookie = str2;
        }
    }

    public static class AccResLixianUrl {
        public int nResPriority;
        public String sUrl;

        public AccResLixianUrl(String str, int i) {
            this.sUrl = str;
            this.nResPriority = i;
        }
    }

    public static class AccResResult {
        public long nFluxCapacity;
        public long nFluxNeed;
        public long nFluxRemain;
        public int nResult;
        public int nSpeedDuration;
        public String sResMsg;
        public AccResTaskInfo[] szTaskInfoList;

        public void SetData(int i, String str, long j, long j2, long j3, int i2) {
            this.nResult = i;
            this.sResMsg = str;
            this.nFluxCapacity = j;
            this.nFluxRemain = j2;
            this.nFluxNeed = j3;
            this.nSpeedDuration = i2;
        }
    }

    public static class AccResTaskInfo {
        public int nResult;
        public String sGcid;
        public String sResMsg;
        public AccResDcdnHttpGather stDcdnHttpGather;
        public AccResDcdnPeerGather stDcdnPeerGather;
        public AccResGaosuGather stGaosuGather;
        public AccResLixianGather stLixianGather;

        public AccResTaskInfo(int i, String str, String str2) {
            this.nResult = i;
            this.sResMsg = str;
            this.sGcid = str2;
        }
    }

    public static class ChannelStatInfo {
        public int nConnErrCode;
        public int nHttpRespCode;
        public int nResult;
        public int nRetryCnt;

        public void SetData(int i, int i2, int i3, int i4) {
            this.nResult = i;
            this.nRetryCnt = i2;
            this.nConnErrCode = i3;
            this.nHttpRespCode = i4;
        }
    }

    public static class ComUrlFileInfo {
        public long nFileSize;
        public String sCid = "";
        public String sCookies = "";
        public String sFileName = "";
        public String sGcid = "";
        public String sRefUrl = "";
        public String sUrl = "";

        public void fillEmptyString() {
            if (this.sUrl == null) {
                this.sUrl = "";
            }
            if (this.sFileName == null) {
                this.sFileName = "";
            }
            if (this.sRefUrl == null) {
                this.sRefUrl = "";
            }
            if (this.sCookies == null) {
                this.sCookies = "";
            }
            if (this.sGcid == null) {
                this.sGcid = "";
            }
            if (this.sCid == null) {
                this.sCid = "";
            }
        }
    }

    public static class OfflineSubmitResult {
        public int nResult;
        public String sResMsg;

        public void SetData(int i, String str) {
            this.nResult = i;
            this.sResMsg = str;
        }
    }

    public static class TrialCommitResult {
        public int nResult;
        public String sGcid;
        public String sResMsg;
        public String sTrialVerifyInfo;

        public void SetData(int i, String str, String str2, String str3) {
            this.nResult = i;
            this.sResMsg = str;
            this.sGcid = str2;
            this.sTrialVerifyInfo = str3;
        }
    }

    public static class TrialQueryResult {
        public int nResult;
        public int nTrialLeftTimes;
        public int nTrialRefreshTime;
        public int nTrialUsedTimes;
        public String sGcid;
        public String sResMsg;
        public String sTrialKey;

        public void SetData(int i, String str, String str2, String str3, int i2, int i3, int i4) {
            this.nResult = i;
            this.sResMsg = str;
            this.sGcid = str2;
            this.sTrialKey = str3;
            this.nTrialUsedTimes = i2;
            this.nTrialLeftTimes = i3;
            this.nTrialRefreshTime = i4;
        }
    }
}
