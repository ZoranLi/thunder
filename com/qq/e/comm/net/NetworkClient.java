package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.util.concurrent.Future;

public interface NetworkClient {

    public enum Priority {
        High(1),
        Mid(2),
        Low(3);
        
        private int a;

        private Priority(int i) {
            this.a = i;
        }

        public final int value() {
            return this.a;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);
}
