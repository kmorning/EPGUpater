package org.duckdns.altered.epgupdater;

/**
 * Created by kmorning on 2018-02-10.
 *
 * Constants used by multiple classes in this package
 */

public class Constants {
    // Defines a custom Intent action
    public static final String BROADCAST_ACTION = "org.duckdns.altered.epgupdater.BROADCAST";

    // Defines the key for the status "extra" in an Intent
    public static final String EXTENDED_DATA_STATUS = "org.duckdns.altered.epgupdater.STATUS";

    // Defines the key for the log "extra" in an Intent
    public static final String EXTENDED_STATUS_LOG = "org.duckdns.altered.epgupdater.LOG";

    // Defines the key for the log "extra" in an Intent
    public static final String EXTENDED_STATUS_PROGRESS = "org.duckdns.altered.epgupdater.PROGRESS"

    // Status values to broadcast

    // The download is starting
    public static final int STATE_ACTION_STARTED = 0;

    // The background thread is connecting to the RSS feed
    public static final int STATE_ACTION_CONNECTING = 1;

    // The background thread is parsing the RSS feed
    public static final int STATE_ACTION_PARSING = 2;

    // The background thread is writing data to the content provider
    public static final int STATE_ACTION_WRITING = 3;

    // The background thread is done
    public static final int STATE_ACTION_COMPLETE = 4;

    // The background thread is doing logging
    public static final int STATE_LOG = -1;

}
