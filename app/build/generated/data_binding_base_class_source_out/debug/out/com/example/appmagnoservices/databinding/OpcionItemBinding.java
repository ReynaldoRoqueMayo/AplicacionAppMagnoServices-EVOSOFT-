// Generated by view binder compiler. Do not edit!
package com.example.appmagnoservices.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.appmagnoservices.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class OpcionItemBinding implements ViewBinding {
  @NonNull
  private final TextView rootView;

  private OpcionItemBinding(@NonNull TextView rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public TextView getRoot() {
    return rootView;
  }

  @NonNull
  public static OpcionItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OpcionItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.opcion_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OpcionItemBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new OpcionItemBinding((TextView) rootView);
  }
}
