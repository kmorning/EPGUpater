package org.duckdns.altered.epgupdater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.duckdns.altered.backgroundservice.EPGUpdateService;

public class MainActivity extends Activity {
    private Intent mServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchEPGUpdateService() {
        mServiceIntent = new Intent(this, EPGUpdateService.class);
        startService(mServiceIntent);
    }
}
