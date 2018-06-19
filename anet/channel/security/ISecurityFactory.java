package anet.channel.security;

/* compiled from: Taobao */
public interface ISecurityFactory {
    ISecurity createNonSecurity(String str);

    ISecurity createSecurity(String str);
}
