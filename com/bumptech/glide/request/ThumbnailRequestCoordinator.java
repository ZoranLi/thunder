package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
    private RequestCoordinator coordinator;
    private Request full;
    private Request thumb;

    public ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(RequestCoordinator requestCoordinator) {
        this.coordinator = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public boolean canSetImage(Request request) {
        return (!parentCanSetImage() || (request.equals(this.full) == null && this.full.isResourceSet() != null)) ? null : true;
    }

    private boolean parentCanSetImage() {
        if (this.coordinator != null) {
            if (!this.coordinator.canSetImage(this)) {
                return false;
            }
        }
        return true;
    }

    public boolean canNotifyStatusChanged(Request request) {
        return (parentCanNotifyStatusChanged() && request.equals(this.full) != null && isAnyResourceSet() == null) ? true : null;
    }

    private boolean parentCanNotifyStatusChanged() {
        if (this.coordinator != null) {
            if (!this.coordinator.canNotifyStatusChanged(this)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnyResourceSet() {
        if (!parentIsAnyResourceSet()) {
            if (!isResourceSet()) {
                return false;
            }
        }
        return true;
    }

    public void onRequestSuccess(Request request) {
        if (request.equals(this.thumb) == null) {
            if (this.coordinator != null) {
                this.coordinator.onRequestSuccess(this);
            }
            if (this.thumb.isComplete() == null) {
                this.thumb.clear();
            }
        }
    }

    private boolean parentIsAnyResourceSet() {
        return this.coordinator != null && this.coordinator.isAnyResourceSet();
    }

    public void begin() {
        if (!this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (!this.full.isRunning()) {
            this.full.begin();
        }
    }

    public void pause() {
        this.full.pause();
        this.thumb.pause();
    }

    public void clear() {
        this.thumb.clear();
        this.full.clear();
    }

    public boolean isPaused() {
        return this.full.isPaused();
    }

    public boolean isRunning() {
        return this.full.isRunning();
    }

    public boolean isComplete() {
        if (!this.full.isComplete()) {
            if (!this.thumb.isComplete()) {
                return false;
            }
        }
        return true;
    }

    public boolean isResourceSet() {
        if (!this.full.isResourceSet()) {
            if (!this.thumb.isResourceSet()) {
                return false;
            }
        }
        return true;
    }

    public boolean isCancelled() {
        return this.full.isCancelled();
    }

    public boolean isFailed() {
        return this.full.isFailed();
    }

    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }
}
