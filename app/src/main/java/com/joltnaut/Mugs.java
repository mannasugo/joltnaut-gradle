package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Mugs extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.mugs);

    ImageView toAddContact = findViewById(R.id.addContact);

    toAddContact.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(Mugs.this, AddContact.class);

        startActivity(to);
      }
    });
  }
}
