package com.coyc.objecthttpdemo.Net.Entity;

import com.coyc.objecthttp.ObjectHttp.ObjectHttp_Get;

/**
 * Created by leipe on 2016/12/30.
 */

public class Request_mainPage extends ObjectHttp_Get {

    public Request_mainPage() {
        prams.put("route","Index_getIndex");
        prams.put("version","1");
    }

    @Override
    protected void bindObject() {

    }
}
