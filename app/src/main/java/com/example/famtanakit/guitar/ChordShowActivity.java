package com.example.famtanakit.guitar;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ChordShowActivity extends AppCompatActivity {

    private TextView eChord;
    private TextView eNameChord;
    private ImageView imageView;



    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_show);

        Intent intent = getIntent();
        String chord = intent.getStringExtra("chord_name");
        String keyChord = intent.getStringExtra("key_chord");
        String image = intent.getStringExtra("image");

        mId = intent.getLongExtra("id", 0);

        eChord = findViewById(R.id.chord_text);
        eNameChord = findViewById(R.id.name_chord_text);
        imageView =(ImageView)findViewById(R.id.chord_edit_view);

        eChord.setText(chord);
        eNameChord.setText(keyChord);


       AssetManager am = getAssets();
        try {
            InputStream is = am.open(image);
            Drawable drawable = Drawable.createFromStream(is,"");

            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
