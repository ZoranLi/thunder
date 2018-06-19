package com.huawei.hms.support.api.client;

public abstract class Result {
    private Status a = Status.FAILURE;

    public Status getStatus() {
        return this.a;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.a = status;
        }
    }
}
