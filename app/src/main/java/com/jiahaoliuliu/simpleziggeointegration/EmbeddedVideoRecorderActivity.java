package com.jiahaoliuliu.simpleziggeointegration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ziggeo.androidsdk.Ziggeo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
        mZiggeo = new Ziggeo(APIKeys.ZIGGEO_API_KEY);
        long maxVideoDutaion = 1000 * 60 * 5; //for ex. 5 mins.

        mZiggeo.attachRecorder(getFragmentManager(), R.id.content_frame_layout, MainActivity.MAX_TIME_ALLOWED, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Video embedded failed ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.v(TAG, "Video correctly uploaded " + response);
            }
        });
    }
}
