/*******************************************************************************
 * Copyright (C) 2013 Snowdream Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.github.snowdream.android.apps.downloader;

import android.app.Activity;
import android.os.Bundle;

import com.github.snowdream.android.app.DownloadListener;
import com.github.snowdream.android.app.DownloadManager;
import com.github.snowdream.android.app.DownloadTask;

import net.simonvt.menudrawer.MenuDrawer;
/**
 * 
 *
 * @author snowdream <yanghui1986527@gmail.com>
 * @date Sep 29, 2013
 * @version v1.0
 */
//@EActivity(R.layout.activity_main)
public class HelloAndroidActivity extends Activity{
    private MenuDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.activity_main);
        mDrawer = MenuDrawer.attach(this);
        mDrawer.setContentView(R.layout.activity_sample);
        mDrawer.setMenuView(R.layout.menu_sample);

        DownloadTask task = new DownloadTask(this);
        task.setUrl("http://www.appchina.com/market/d/1019394/cop.baidu_0/com.hd.explorer.apk");
        task.setPath("/mnt/sdcard/10120702.apk");
        DownloadManager.add(task);
        DownloadManager.start(task, new DownloadListener<Integer, DownloadTask>());
    }
}
