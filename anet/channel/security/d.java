package anet.channel.security;

/* compiled from: Taobao */
final class d implements ISecurityFactory {
    d() {
    }

    public final ISecurity createSecurity(String str) {
        return new b(str);
    }

    public final ISecurity createNonSecurity(String str) {
        return new a(str);
    }
}
