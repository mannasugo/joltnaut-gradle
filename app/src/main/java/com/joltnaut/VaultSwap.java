package com.joltnaut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class VaultSwap extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.vault_swap);

    ImageView toVaultStamp = findViewById(R.id.vaultStamp);

    toVaultStamp.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        final BottomSheetDialog vaultStampDialog = new BottomSheetDialog(VaultSwap.this);

        View inflater = LayoutInflater.from(getApplicationContext()).inflate(R.layout.stamp, (LinearLayout) findViewById(R.id.floats));

        vaultStampDialog.setContentView(inflater);

        vaultStampDialog.show();
      }
    });
  }
}
