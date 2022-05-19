// Generated by view binder compiler. Do not edit!
package com.example.appmagnoservices.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appmagnoservices.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPrincipalBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton addImgPrincipal;

  @NonNull
  public final MaterialButton btnPrincipalCitas;

  @NonNull
  public final CoordinatorLayout cordLayo;

  @NonNull
  public final ShapeableImageView imgUsuario;

  @NonNull
  public final LinearLayout lhBtn;

  @NonNull
  public final TextInputLayout menu;

  @NonNull
  public final MaterialTextView tvNombreUsuario;

  private ActivityPrincipalBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton addImgPrincipal, @NonNull MaterialButton btnPrincipalCitas,
      @NonNull CoordinatorLayout cordLayo, @NonNull ShapeableImageView imgUsuario,
      @NonNull LinearLayout lhBtn, @NonNull TextInputLayout menu,
      @NonNull MaterialTextView tvNombreUsuario) {
    this.rootView = rootView;
    this.addImgPrincipal = addImgPrincipal;
    this.btnPrincipalCitas = btnPrincipalCitas;
    this.cordLayo = cordLayo;
    this.imgUsuario = imgUsuario;
    this.lhBtn = lhBtn;
    this.menu = menu;
    this.tvNombreUsuario = tvNombreUsuario;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPrincipalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPrincipalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_principal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPrincipalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addImgPrincipal;
      FloatingActionButton addImgPrincipal = ViewBindings.findChildViewById(rootView, id);
      if (addImgPrincipal == null) {
        break missingId;
      }

      id = R.id.btnPrincipalCitas;
      MaterialButton btnPrincipalCitas = ViewBindings.findChildViewById(rootView, id);
      if (btnPrincipalCitas == null) {
        break missingId;
      }

      id = R.id.cordLayo;
      CoordinatorLayout cordLayo = ViewBindings.findChildViewById(rootView, id);
      if (cordLayo == null) {
        break missingId;
      }

      id = R.id.imgUsuario;
      ShapeableImageView imgUsuario = ViewBindings.findChildViewById(rootView, id);
      if (imgUsuario == null) {
        break missingId;
      }

      id = R.id.lhBtn;
      LinearLayout lhBtn = ViewBindings.findChildViewById(rootView, id);
      if (lhBtn == null) {
        break missingId;
      }

      id = R.id.menu;
      TextInputLayout menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      id = R.id.tvNombreUsuario;
      MaterialTextView tvNombreUsuario = ViewBindings.findChildViewById(rootView, id);
      if (tvNombreUsuario == null) {
        break missingId;
      }

      return new ActivityPrincipalBinding((RelativeLayout) rootView, addImgPrincipal,
          btnPrincipalCitas, cordLayo, imgUsuario, lhBtn, menu, tvNombreUsuario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
