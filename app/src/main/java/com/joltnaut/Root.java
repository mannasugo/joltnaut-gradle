package com.joltnaut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Root extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.root);

    ImageView toClientWallet = findViewById(R.id.clientWallet);

    ImageView toMugs = findViewById(R.id.mugs);

    ImageView toWalletServer = findViewById(R.id.walletServer);

    toClientWallet.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(Root.this, ClientWallet.class);

        startActivity(to);
      }
    });

    toMugs.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(Root.this, Mugs.class);

        startActivity(to);
      }
    });

    toWalletServer.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent to = new Intent(Root.this, WalletServer.class);

        startActivity(to);
      }
    });

    RecyclerView rootOld = findViewById(R.id.rootOld);

    RecyclerView.Adapter all = new RootOld(getApplicationContext());

    rootOld.setLayoutManager(new LinearLayoutManager(this));

    rootOld.setAdapter(all);
  }
}
