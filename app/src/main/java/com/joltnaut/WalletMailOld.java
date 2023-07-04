package com.joltnaut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WalletMailOld extends RecyclerView.Adapter<WalletMailOld.SelfViewHolder> {

  private final Context now;

  WalletMailOld (Context now) {

    this.now = now;
  }

  @NonNull
  @Override
  public SelfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int sort) {

    final View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallet_mail_old, parent, false);

    final SelfViewHolder hold = new SelfViewHolder(inflater);

    return hold;
  }

  @Override
  public void onBindViewHolder(@NonNull SelfViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 1;
  }

  static class SelfViewHolder extends RecyclerView.ViewHolder {

    public SelfViewHolder(@NonNull View walletMailOld) {

      super(walletMailOld);
    }
  }
}
