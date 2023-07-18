package com.joltnaut;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    this.setTheme(R.style.splash);

    setContentView(R.layout.build_up);
  }
}
