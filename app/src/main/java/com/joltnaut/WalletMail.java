package com.joltnaut;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class WalletMail extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.wallet_mail);

    RecyclerView walletMailOld = findViewById(R.id.walletMailOld);

    RecyclerView.Adapter all = new WalletMailOld(getApplicationContext());

    walletMailOld.setLayoutManager(new LinearLayoutManager(this));

    walletMailOld.setAdapter(all);
  }
}
