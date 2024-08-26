package com.managexr.deviceownertest;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        button.setOnClickListener((view) -> {
            textView.setText("Clearing device owner permissions...");
            DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
            dpm.clearDeviceOwnerApp(getPackageName());
            new Handler().postDelayed(this::updateUi, 500);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        boolean isDeviceOwner = dpm.isDeviceOwnerApp(getPackageName());
        textView.setText("Device Owner: " + isDeviceOwner);
        button.setVisibility(isDeviceOwner ? Button.VISIBLE : Button.GONE);
    }
}