package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PullMug extends AppCompatActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.pull_mug);

    TextView toPollin = findViewById(R.id.pollin);

    toPollin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(PullMug.this, PollMug.class);

        startActivity(to);
      }
    });
  }
}
