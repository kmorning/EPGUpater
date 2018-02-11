package org.duckdns.altered.backgroundservice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by kmorning on 2018-02-10.
 *
 * This service pulls xmltv data from a web site URL contained in the incoming Intent (see
 * onHandleIntent()).  As it runs, it broadcasts it's status using LocalBroadcast Manger; any
 * component that wants to see the staus should implement a subclass of BroadcastReceiver and
 * register to receive broadcast Intents with category = CATEGORY_DEFAULT and action
 * Constants.BROADCAST_ACTION.
 *
 * Note:  maybe URL should come from a saved data file somewhere instead of passed through
 * Intent.
 */

public class EPGUpdateService extends IntentService {
    // Used to write to the system log from this class.
    public static final String LOG_TAG = "EPGUpdateService";


    public EPGUpdateService() {
        // Worker thread name which is only important for debugging
        super("EPGUpdateService");
    }

    /**
     * In an IntentService, onHandleIntent is run on a background thread.  As it
     * runs, it broadcasts its current status using the LocalBroadcastManager.
     * @param workIntent The Intent that starts the IntentService. This Intent contains the
     * URL of the web site from which the RSS parser gets data.
     */
    @Override
    protected void onHandleIntent(Intent workIntent) {

    }
}
