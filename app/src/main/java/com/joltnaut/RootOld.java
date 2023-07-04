package com.joltnaut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RootOld extends RecyclerView.Adapter<RootOld.SelfViewHolder> {

  private final Context now;

  RootOld (Context now) {

    this.now = now;
  }

  @NonNull
  @Override
  public RootOld.SelfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int sort) {

    final View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.root_old, parent, false);

    final SelfViewHolder hold = new SelfViewHolder(inflater);

    return hold;
  }

  @Override
  public void onBindViewHolder(@NonNull RootOld.SelfViewHolder holder, int place) {

  }

  @Override
  public int getItemCount() {
    return 1;
  }

  static class SelfViewHolder extends RecyclerView.ViewHolder {

    public SelfViewHolder(@NonNull View rootOld) {

      super(rootOld);
    }
  }
}
