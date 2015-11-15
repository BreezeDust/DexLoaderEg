package com.breeedust.dexloadermain;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

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
                File file = new File(Environment.getExternalStorageDirectory()
                        .toString() + File.separator + "classes.jar");
                final File optimizedDexOutputPath = getDir("tmp", Context.MODE_PRIVATE);
                DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(),
                        optimizedDexOutputPath.getAbsolutePath(), null,
                        getClassLoader());
                Class<?> clazz = null;
                try {
                    clazz = classLoader.loadClass("com.breeedust.dexloaderplugin.TestClass");
                    Method method = clazz.getMethod("get");
                    String data = (String) method.invoke(clazz.newInstance());
                    Log.e("-->", data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
