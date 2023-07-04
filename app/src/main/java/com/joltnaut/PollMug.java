package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PollMug extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.poll_mug);

    TextView toPullin = findViewById(R.id.pullin);

    toPullin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(PollMug.this, PullMug.class);

        startActivity(to);
      }
    });
  }
}
