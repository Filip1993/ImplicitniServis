package com.filipkesteli.implicitniservis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService;
    private Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);
    }

    private void setupListeners() {
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getServiceIntent();
                startService(intent);
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getServiceIntent();
                stopService(intent);
            }
        });
    }

    private Intent getServiceIntent() {
        //implicitni intent FACTORY (Builder):
        Intent intent = new Intent("com.filipkesteli.implicitniservis.SimpleService");
        //package iz MANIFEST-a:
        intent.setPackage("com.filipkesteli.implicitniservis");
        //moramo znat ime Service-a kojeg zelimo implicitno pozvati i ime paketa!!
        return intent;
    }

}
