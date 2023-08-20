package com.joltnaut;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.joltnaut.Splash.Journal;

public class Root extends AppCompatActivity {

  public static SharedPreferences.Editor Journalise = Journal.edit();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.root);

    Toast.makeText(Root.this, Journal.getString("md", null), Toast.LENGTH_SHORT).show();

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
