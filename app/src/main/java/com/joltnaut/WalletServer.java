package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WalletServer extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.wallet_server);

    ImageView toWalletServe = findViewById(R.id.walletServe);

    ImageView ifReserveVia = findViewById(R.id.ifReserve);

    ifReserveVia.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        Intent via = new Intent(WalletServer.this, AddWalletServer.class);

        startActivity(via);

      }
    });

    toWalletServe.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(WalletServer.this, WalletServe.class);

        startActivity(to);
      }
    });
  }
}
