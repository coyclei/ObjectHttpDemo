package com.coyc.objecthttpdemo.Net.Entity;

import com.coyc.objecthttp.ObjectHttp.ObjectHttp_Post;

/**
 * Created by leipe on 2017/1/3.
 */

public class Request_post_demo extends ObjectHttp_Post {

    public Request_post_demo()
    {
        prams.put("user_name","13484011011");
        prams.put("pwd","123123");
        prams.put("round","12345");
        prams.put("route","User_login");
        prams.put("version","1");
        prams.put("sign","d25bc221688a6887cdfefc410633a188");
    }

    @Override
    protected void bindObject() {

    }
}
