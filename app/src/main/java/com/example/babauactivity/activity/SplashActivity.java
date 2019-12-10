package com.example.babauactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.babauactivity.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SplashActivity extends AppCompatActivity {
    Intent t;
    String db_name = "babau.db";
    String db_path = "/databases/";
    InputStream is;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        xuLiSaoChepCSDL();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                t = new Intent(SplashActivity.this, MainActivity.class);

                startActivity(t);
                finish();
            }
        }, 500);

    }
    public void xuLiSaoChepCSDL() {
//       check file database đã tồn tại chưa? nếu chưa thì coppy vào
        if (!getDatabasePath(this.db_name).exists()) {
            try {
                copyCSDLtuAssetvaoApp();
                System.out.println("thanh cong");
            } catch (Exception e) {
                System.out.println("loi:" + e.toString());
            }
        }
    }

    public void copyCSDLtuAssetvaoApp() {
        try {
            this.is = getAssets().open(this.db_name);
            File f = new File(getApplicationInfo().dataDir + this.db_path);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream os = new FileOutputStream(getUrl());
            byte[] buffer = new byte[1024];
            while (true) {
                int length = this.is.read(buffer);
                if (length > 0) {
                    os.write(buffer, 0, length);
                }
                else {
                    os.flush();
                    os.close();
                    this.is.close();
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("loi:" + e.toString());
        }
    }

    public String getUrl() {
        return getApplicationInfo().dataDir + this.db_path + this.db_name;
    }


}