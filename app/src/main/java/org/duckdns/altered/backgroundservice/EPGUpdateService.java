package org.duckdns.altered.backgroundservice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by kmorning on 2018-02-10.
 */

public class EPGUpdateService extends IntentService {
    public EPGUpdateService() {
        // Worker thread name which is only important for debugging
        super("EPGUpdateService");
    }
    @Override
    protected void onHandleIntent(Intent workIntent) {

    }
}
