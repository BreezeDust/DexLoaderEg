package com.breeedust.dexloadermain;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.baidu.dexloaderlib.BDClassPlugin;
import com.baidu.dexloaderlib.BDPlugin;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.to_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });

    }
    private void load(){
        File file = new File(Environment.getExternalStorageDirectory()
                .toString() + File.separator + "src.apk");
        final File optimizedDexOutputPath = getDir("tmp", Context.MODE_PRIVATE);
        DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(),
                optimizedDexOutputPath.getAbsolutePath(), null,
                getClassLoader());
        try {
            Class clazz = classLoader.loadClass("com.breezedust.dexloaderpluginapk.MainLoader");
            BDClassPlugin bdPlugin=(BDClassPlugin)clazz.newInstance();
            Log.e("--->",bdPlugin.get());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
