package com.joltnaut;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.joltnaut.Splash.Journal;

public class Wallet2Wallet extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.wallet_2_wallet);

    TextView inlet = findViewById(R.id.inlet);

    inlet.setText(Journal.getString("inlet", null));
  }
}
