package com.coyc.objecthttpdemo.Net.Entity;

import com.coyc.objecthttp.ObjectHttp.ObjectHttp_Post;
import com.coyc.objecthttp.ObjectHttp.ObjectHttp_PostFile;

import java.io.File;

/**
 * Created by leipe on 2017/1/3.
 */

public class Request_post_file_demo extends ObjectHttp_PostFile {

    public Request_post_file_demo(File image)
    {
        prams.put("id","1");
        prams.put("route","User_editUserImage");
        prams.put("version","1");
        prams.put("sign","8f6a172788f76695fe4838762bbcbb7d");
        prams.put("token","37186a96319d57e119d48562639e3ab9");

        prams_file.put("image",image);
    }

    @Override
    protected void bindObject() {

    }
}
