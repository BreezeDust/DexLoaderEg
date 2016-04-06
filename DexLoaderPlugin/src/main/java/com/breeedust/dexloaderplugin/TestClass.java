package com.breeedust.dexloaderplugin;

import com.baidu.dexloaderlib.BDClassPlugin;
import com.baidu.dexloaderlib.BDPlugin;

/**
 * Created by BreezeDust on 15/11/15.
 */
public class TestClass extends BDClassPlugin{
    @Override
    public String get() {
        return "这是个测试"+this.getClass().getName();
    }
}
