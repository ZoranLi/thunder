package com.qihoo360.i;

public interface IPlugin {
    IModule query(Class<? extends IModule> cls);
}
