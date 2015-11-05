package com.jiahaoliuliu.simpleziggeointegration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.common.eventbus.Subscribe;
import com.ziggeo.androidsdk.Ziggeo;
import com.ziggeo.androidsdk.eventbus.BusProvider;
import com.ziggeo.androidsdk.eventbus.events.CreateVideoErrorEvent;
import com.ziggeo.androidsdk.eventbus.events.VideoSentEvent;

public class EmbeddedVideoRecorderActivity extends AppCompatActivity {

    private static final String TAG = "EmbeddedVideoRecorderActivity";

    private Ziggeo mZiggeo;

    // Internal variables
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embedded_video_recorder);

        // Initialize the variables
        mContext = this;
        mZiggeo = new Ziggeo(APIKeys.ZIGGEO_APPLICATION_TOKEN);
        BusProvider.getInstance().register(this);

        // Embed the fragment
        mZiggeo.attachRecorder(getFragmentManager(), R.id.content_frame_layout, MainActivity.MAX_TIME_ALLOWED);
    }

    @Subscribe
    public void onVideoSent(VideoSentEvent event) {
        Log.v(TAG, "The video has been correctly sent " + event.getVideoToken());
        Toast.makeText(mContext, R.string.video_uploaded_correctly, Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void onCreateVideoError(CreateVideoErrorEvent event) {
        Log.e(TAG, "Error creating video");
        Toast.makeText(mContext, R.string.error_create_video, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }
}
