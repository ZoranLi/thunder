package com.alipay.android.phone.mrpc.core;

import com.umeng.message.util.HttpRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public final class j extends a {
    private g g;

    public j(g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, HttpRequest.CONTENT_TYPE_FORM, z);
        this.g = gVar;
    }

    public final Object a() {
        t oVar = new o(this.g.a());
        oVar.a(this.b);
        oVar.a(this.e);
        oVar.a(this.f);
        oVar.a(AgooConstants.MESSAGE_ID, String.valueOf(this.d));
        oVar.a("operationType", this.c);
        oVar.a("gzip", String.valueOf(this.g.d()));
        oVar.a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.g.c().b();
        if (!(b == null || b.isEmpty())) {
            for (Header a : b) {
                oVar.a(a);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("threadid = ");
        stringBuilder.append(Thread.currentThread().getId());
        stringBuilder.append("; ");
        stringBuilder.append(oVar.toString());
        try {
            u uVar = (u) this.g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new RpcException(Integer.valueOf(9), "response is null");
        } catch (Throwable e) {
            throw new RpcException(Integer.valueOf(13), "", e);
        } catch (Throwable e2) {
            Throwable cause = e2.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(Integer.valueOf(9), "", e2);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
                default:
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        } catch (Throwable e22) {
            throw new RpcException(Integer.valueOf(13), "", e22);
        }
    }
}
