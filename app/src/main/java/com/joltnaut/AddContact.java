package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.add_contact);

    ImageView toWalletMail = findViewById(R.id.walletMail);

    toWalletMail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(AddContact.this, WalletMail.class);

        startActivity(to);
      }
    });
  }
}
