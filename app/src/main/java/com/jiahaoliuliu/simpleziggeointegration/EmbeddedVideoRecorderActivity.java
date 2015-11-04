package com.jiahaoliuliu.simpleziggeointegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ziggeo.androidsdk.Ziggeo;

public class EmbeddedVideoRecorderActivity extends AppCompatActivity {

    private Ziggeo mZiggeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embedded_video_recorder);

        // Initialize the variables
        mZiggeo = new Ziggeo(APIKeys.ZIGGEO_APPLICATION_TOKEN);

        // Embed the fragment
        mZiggeo.attachRecorder(getFragmentManager(), R.id.content_frame_layout, MainActivity.MAX_TIME_ALLOWED);
    }
}
