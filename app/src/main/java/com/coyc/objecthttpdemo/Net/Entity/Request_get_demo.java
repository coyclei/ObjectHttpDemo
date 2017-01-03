package com.coyc.objecthttpdemo.Net.Entity;

import com.coyc.objecthttp.ObjectHttp.ObjectHttp_Get;

/**
 * Created by leipe on 2017/1/3.
 */

public class Request_get_demo extends ObjectHttp_Get {

    public Request_get_demo()
    {
        prams.put("route","Index_getIndex");
        prams.put("version","1");
    }

    @Override
    protected void bindObject() {

    }
}
