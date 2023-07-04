package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ClientWallet extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.client_wallet);

    ImageView toVaultSwap = findViewById(R.id.vaultSwap);

    toVaultSwap.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        Intent to = new Intent(ClientWallet.this, VaultSwap.class);

        startActivity(to);
      }
    });
  }
}
