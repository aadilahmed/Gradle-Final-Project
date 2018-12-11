package com.example.jokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle bundle = getIntent().getExtras();

        String joke = bundle.getString("joke");

        TextView joke_tv = findViewById(R.id.joke_text);
        joke_tv.setText(joke);
    }
}
