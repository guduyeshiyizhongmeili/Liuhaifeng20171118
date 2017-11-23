package com.bwie.test.liuhaifeng20171118;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.liuhaifeng20171118.model.utils.DownloadUtil;



public class DownLoadActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar mProgressBar;
    private Button start;
    private Button pause;


    private TextView total;
    private int max;
    private DownloadUtil mDownloadUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        total= (TextView) findViewById(R.id.textView);
        start= (Button) findViewById(R.id.start);
        pause= (Button) findViewById(R.id.delete);
        mProgressBar= (ProgressBar) findViewById(R.id.progressBar);
        String urlString = "http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4";
        String localPath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/aaaaaaaaa";
        mDownloadUtil = new DownloadUtil(4, localPath, "adc.mp4", urlString,
                this);
        mDownloadUtil.setOnDownloadListener(new DownloadUtil.OnDownloadListener() {

            @Override
            public void downloadStart(int fileSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "fileSize::" + fileSize);
                Toast.makeText(DownLoadActivity.this, "开始下载", Toast.LENGTH_SHORT).show();
                max = fileSize;
                mProgressBar.setMax(fileSize);
            }

            @Override
            public void downloadProgress(int downloadedSize) {
                // TODO Auto-generated method stub
                Log.w(TAG, "Compelete::" + downloadedSize);
                mProgressBar.setProgress(downloadedSize);
                total.setText((int) downloadedSize * 100 / max + "%");
            }

            @Override
            public void downloadEnd() {
                // TODO Auto-generated method stub
                Log.w(TAG, "ENd");
                Toast.makeText(DownLoadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        });
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil.start();

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDownloadUtil.pause();
                Toast.makeText(DownLoadActivity.this, "下载已暂停", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
