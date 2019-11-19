package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    public Button button_1;
    public Button button_2;
    public Button button_3;
    public Button button_4;
    public Button button_5;
    public Button button_6;
    public Button button_7;
    public Button button_8;
    public Button button_9;
    public Button button_10;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText enterText = findViewById(R.id.text_edit);

        button_1 = findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac1();
            }
        });

        button_2 = findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac2();
            }
        });

        button_3 = findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac3();
            }
        });
        button_4 = findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac4();
            }
        });
        button_5 = findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac5();
            }
        });
        button_6 = findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ac6();
            }
        });
        button_7 = findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (!enterText.getText().toString().isEmpty()) {
                    File file = new File(MainActivity.this.getFilesDir(), "text");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    try {
                        File gpxfile = new File(file, "sample");
                        FileWriter writer = new FileWriter(gpxfile);
                        writer.append(enterText.getText().toString());
                        writer.flush();
                        writer.close();
                        Toast.makeText(MainActivity.this, "zapisano", Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e) {
                    }
                }
            }
        });


        Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        button_8 = findViewById(R.id.button_8);
        button_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });



        button_9 = findViewById(R.id.button_9);
        button_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    intent = new Intent(Settings.ACTION_NFC_SETTINGS);
                } else {
                    intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                }
                startActivity(intent);
            }
        });



        button_10 = findViewById(R.id.button_10);
        button_10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            }
        });




    }

    public void ac1() {
        Toast.makeText(this, "słowo", Toast.LENGTH_SHORT).show();
    }

    public void ac2() {
        Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(cameraIntent);
    }

    public void ac3() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void ac4() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        mp.start();
    }

    public void ac5() {
        final TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText("elo mordziaty");
    }

    public void ac6() {
        final NfcAdapter NFC_ADAPTER = NfcAdapter.getDefaultAdapter(this);
        if (NFC_ADAPTER == null) {
            Toast.makeText(this, "nie ma nfc", Toast.LENGTH_SHORT).show();
        } else if (NFC_ADAPTER.isEnabled()) {
            Toast.makeText(this, "NFC wlaczone", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "NFC wylaczone", Toast.LENGTH_SHORT).show();
        }
    }
}



