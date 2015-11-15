package com.breeedust.dexloaderplugin;

/**
 * Created by BreezeDust on 15/11/15.
 */
public class TestClass implements PluginInterface{
    @Override
    public String get() {
        return "这是个测试"+this.getClass().getName();
    }
}
