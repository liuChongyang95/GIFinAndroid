package fina.com.gifinandroidgia;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GifDrawable gifDrawable0;
    private GifDrawable gifDrawable;
    private MediaController mediaController;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GifImageView drawable = findViewById(R.id.gifTest_drawable);
//        GifImageView files=findViewById(R.id.gifTest_files);
//        GifImageView input=findViewById(R.id.inputStream);
        GifImageView assets = findViewById(R.id.gifTest_assets);
        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        Button reset = findViewById(R.id.reset);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        reset.setOnClickListener(this);
        try {
            //            从assets读取
            gifDrawable = new GifDrawable(getAssets(), "longmao.jpg");
            assets.setImageDrawable(gifDrawable);

//            从drawable读取
            gifDrawable0 = new GifDrawable(getResources(), R.drawable.longmao);
            drawable.setImageDrawable(gifDrawable0);

//            从文件中读取
//            File gifFile = new File(getFilesDir(), "longmao.jpg");
//            GifDrawable gifDrawable1=new GifDrawable(gifFile);
//            files.setImageDrawable(gifDrawable1);

//            InputStream inputStream = new FileInputStream(gifFile);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 100 * 100);
//            GifDrawable gifDrawable2=new GifDrawable(bufferedInputStream);
//            input.setImageDrawable(gifDrawable2);

            mediaController = new MediaController(this);
            mediaController.setAnchorView(assets);
            mediaController.setMediaPlayer((MediaController.MediaPlayerControl) assets.getDrawable());
            assets.setOnClickListener(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                gifDrawable0.start();
                break;
            case R.id.stop:
                gifDrawable0.stop();
                break;
            case R.id.reset:
                gifDrawable0.reset();
                break;
            case R.id.gifTest_assets:
                mediaController.show();
                break;
        }
    }
}
