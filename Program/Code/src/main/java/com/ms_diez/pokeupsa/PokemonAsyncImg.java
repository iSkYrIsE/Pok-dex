package com.ms_diez.pokeupsa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;

public class PokemonAsyncImg extends AsyncTask<String, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        final String url = strings[0];
        Bitmap bitmap = null;

        try{
            InputStream inputStream = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
        return bitmap;
    }
}
