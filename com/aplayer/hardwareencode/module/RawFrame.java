package com.aplayer.hardwareencode.module;

public class RawFrame {
    public long pts;
    public byte[] rawData;
    public int trackID;

    public RawFrame(byte[] bArr, long j, int i) {
        this.rawData = bArr;
        this.pts = j;
        this.trackID = i;
    }
}
