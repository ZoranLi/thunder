package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;

public class i extends h {
    public MtopResponse a;

    public i(MtopResponse mtopResponse) {
        this.a = mtopResponse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopFinishEvent [");
        stringBuilder.append("mtopResponse");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
