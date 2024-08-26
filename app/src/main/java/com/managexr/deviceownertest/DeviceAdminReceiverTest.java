package com.managexr.deviceownertest;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DeviceAdminReceiverTest extends DeviceAdminReceiver {
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
        Log.w("DeviceAdminReceiverTest", "onEnabled");
    }
}
