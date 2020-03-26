/*
     _____   _____                 _______  _______  ______
    |     | |     | |     | |\   |    |    |        |
    |-----| |_____| |     | | \  |    |    |____    |______
    |     | |       |     | |  \ |    |    |               |
    |     | |       |_____| |   \|    |    |_______  ______|

*/
package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bt12;
    private Button bt13;
    private Button bt14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.constraint );

        Button bt12 = findViewById(R.id.button12);

        bt12 = findViewById(R.id.button12);
        bt13 = findViewById(R.id.button13);
        bt14 = findViewById(R.id.button14);

        BotonOnClick o = this.new BotonOnClick();

        bt12.setOnClickListener( new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        MainActivity.this.bt14;

                                        bt13.setText("Hola Hola");
                                    }
                                }
                                );

        bt12.setOnClickListener( (x) -> { bt13.setText("Hola Hola")} );

        bt12.setOnClickListener( System.out::println );

        bt12.setOnClickListener( this );

        List<String> list = new ArrayList<>();

        for(String e : list)
        {
            System.out.println( e );
        }

    private void bt12OnClick(View view)
        {

        }


    }



        @Override
        public void onClick(View v)
        {
            switch ( v.getId() )
            {
                case R.id.button12:
                    break;
                case R.id.button13:
                    break;
                case R.id.button14:
                    break;
            }
        }
}




