package com.jiahaoliuliu.simpleziggeointegration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ziggeo.androidsdk.Ziggeo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int MAX_TIME_ALLOWED = 1000 * 6 * 2; // 2 minutes

    // Views
    private Button mStartVideoRecordingButton;

    // Others
    private Context mContext;
    private Ziggeo mZiggeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Ziggeo
        mContext = this;
        mZiggeo = new Ziggeo(APIKeys.ZIGGEO_APPLICATION_TOKEN);

        // Link the views
        mStartVideoRecordingButton = (Button)findViewById(R.id.start_video_recording_button);
        mStartVideoRecordingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mZiggeo.createVideo(mContext, MAX_TIME_ALLOWED);
            }
        });
    }
}
