package com.coyc.objecthttpdemo.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.coyc.objecthttp.Adapter.SignAdapter;
import com.coyc.objecthttp.Listener.OnNetResponseListener;
import com.coyc.objecthttp.Manager.ObjectHttpManager;
import com.coyc.objecthttpdemo.Net.Entity.Request_get_demo;
import com.coyc.objecthttpdemo.R;
import com.coyc.objecthttpdemo.Utils.MD5;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObjectHttp();

        new Request_get_demo().request(new OnNetResponseListener() {
            @Override
            public void onGetData(Object o) {
                //当成功的转换为目标对象，这里属于下篇文章内容
                Log.i("demo","onGetData");
            }

            @Override
            public void onDataError(String s) {
                //当没有成功的转换为目标对象，会回调服务器传来的参数
                //在本文中由于没有绑定目标对象，故服务器参数都将在该接口中回调
                Log.i("demo","demo result: "+s);
            }

            @Override
            public void onNetError() {
                //当网络发生错误
                Log.i("demo","onNetError");
            }
        });

    }

    private void initObjectHttp() {
        ObjectHttpManager.getInstance().setUrl("http://118.178.182.177/nny_php/api/AppApi/receive/");

        ObjectHttpManager.getInstance().makeSignAble(new SignAdapter() {
            @Override
            public void sign(Map<String, String> prams, Map<String, File> map1) {

                //prams参数即为网络请求对象构造是传入的值

                //如果需要对 文件进行签名使用map1参数获取相应信息
                //开始定义签名规则
                ArrayList<String > strings = new ArrayList<>();
                Iterator iterator = prams.entrySet().iterator();
                while (iterator.hasNext())
                {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    strings.add((String) entry.getKey());
                }
                Collections.sort(strings);
                String md5 = "";
                for(int i = 0;i<strings.size();i++)
                {
                    md5 += strings.get(i)+prams.get(strings.get(i));
                }
                String sign = MD5.Md5(md5 + MD5.Md5("miaotaoKJ"));
                //签名规则结束
                //以上代码是构造签名，其规则根据各自需求进行签名


                prams.put("sign",sign);//关键是要在构造好签名后将其填充到prams参数中
            }
        });
    }
}
