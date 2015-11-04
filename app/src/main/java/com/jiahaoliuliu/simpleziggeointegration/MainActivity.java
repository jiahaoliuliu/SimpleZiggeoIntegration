package com.jiahaoliuliu.simpleziggeointegration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ziggeo.androidsdk.Ziggeo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final int MAX_TIME_ALLOWED = 1000 * 60 * 2; // 2 minutes

    // Views
    private Button mStartFullScreenVideoRecordingButton;
    private Button mStartEmbeddedVideoRecordingButton;

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
        mStartFullScreenVideoRecordingButton = (Button)findViewById(R.id.start_full_screen_video_recording_button);
        mStartFullScreenVideoRecordingButton.setOnClickListener(mOnClickListener);

        mStartEmbeddedVideoRecordingButton = (Button) findViewById(R.id.start_embedded_video_recording_button);
        mStartEmbeddedVideoRecordingButton.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.start_full_screen_video_recording_button:
                    mZiggeo.createVideo(mContext, MAX_TIME_ALLOWED);
                    break;
                case R.id.start_embedded_video_recording_button:
                    Intent startEmbeddedVideoRecorderActivityIntent = new Intent(mContext, EmbeddedVideoRecorderActivity.class);
                    startActivity(startEmbeddedVideoRecorderActivityIntent);
                    break;
            }
        }
    };
}
