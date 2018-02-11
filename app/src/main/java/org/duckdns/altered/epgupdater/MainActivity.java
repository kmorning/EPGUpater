package org.duckdns.altered.epgupdater;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Intent mServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register for the broadcast based on ACTION string
        IntentFilter filter = new IntentFilter(Constants.BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister broadcast receiver when application is paused
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    public void launchEPGUpdateService() {
        // hard code xml url for now
        String xmlUrl = "https://raw.githubusercontent.com/kens13/epg/master/guide_kens.xml";

        mServiceIntent = new Intent(this, EPGUpdateService.class);
        mServiceIntent.setData(Uri.parse(xmlUrl));
        //try {
        startService(mServiceIntent);
        //}
        //catch (Exception ex) {
        //    Log.e("Error starting service", ex.getMessage());
        //}
    }

    public void updateEPG(View view) {
        launchEPGUpdateService();
    }

    // Define the callback for broadcast data received
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int statusCode = intent.getIntExtra(Constants.EXTENDED_DATA_STATUS,
                    Constants.STATE_ACTION_FAILED);
            TextView textView = findViewById(R.id.textView);

            switch (statusCode) {
                case Constants.STATE_ACTION_STARTED:
                    textView.setText(getString(R.string.status_start));
                case Constants.STATE_ACTION_CONNECTING:
                    textView.setText(getString(R.string.status_connect));
                case Constants.STATE_ACTION_DOWNLOADING:
                    textView.setText(getString(R.string.status_download));
                case Constants.STATE_ACTION_DOWNLOAD_COMPLETE:
                    textView.setText(getString(R.string.status_download_done));
                case Constants.STATE_ACTION_FAILED:
                    textView.setText(getString(R.string.status_fail));
                default:
            }
        }
    };
}
