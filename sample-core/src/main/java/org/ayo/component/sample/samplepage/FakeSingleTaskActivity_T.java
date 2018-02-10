package org.ayo.component.sample.samplepage;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/5/21.
 */

public class FakeSingleTaskActivity_T extends BaseFakeActivity {
    public static void start(Activity a, boolean newTask){
        Intent intent = new Intent(a, FakeSingleTaskActivity_T.class);
        if(newTask) intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        a.startActivity(intent);
    }
    @Override
    protected String getTopTitle() {
        return "SingleTask-透明";
    }
}
