package com.example.palette_color;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tres);
        crearPaleta(bitmap);
    }

    private void crearPaleta(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {

                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if (vibrant!=null){
                    text1.setBackgroundColor(vibrant.getRgb());
                    text1.setTextColor(vibrant.getTitleTextColor());
                    text1.setText("Vibrant");
                }

                Palette.Swatch muted = palette.getMutedSwatch();
                if (muted!=null){
                    text2.setBackgroundColor(muted.getRgb());
                    text2.setTextColor(muted.getTitleTextColor());
                    text2.setText("Muted");
                }

                Palette.Swatch dominant = palette.getDominantSwatch();
                if (dominant!=null){
                    text3.setBackgroundColor(dominant.getRgb());
                    text3.setTextColor(dominant.getTitleTextColor());
                    text3.setText("Dominant");
                }

                Palette.Swatch darkMuted = palette.getDarkMutedSwatch();
                if (darkMuted!=null){
                    text4.setBackgroundColor(darkMuted.getRgb());
                    text4.setTextColor(darkMuted.getTitleTextColor());
                    text4.setText("DarkMuted");
                }

                Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
                if (darkVibrant!=null){
                    text5.setBackgroundColor(darkVibrant.getRgb());
                    text5.setTextColor(darkVibrant.getTitleTextColor());
                    text5.setText("DarkVibrant");
                }
            }
        });
    }

    private void init() {
        this.text1 = findViewById(R.id.txt1);
        this.text2 = findViewById(R.id.txt2);
        this.text3 = findViewById(R.id.txt3);
        this.text4 = findViewById(R.id.txt4);
        this.text5 = findViewById(R.id.txt5);
    }

}