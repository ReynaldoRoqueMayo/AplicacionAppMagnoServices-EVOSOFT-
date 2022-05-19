// Generated by view binder compiler. Do not edit!
package com.example.appmagnoservices.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appmagnoservices.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOpcionesRegistroBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final MaterialButton btnOcionesContinuar;

  @NonNull
  public final MaterialButton btnOpcionesCancelar;

  @NonNull
  public final LinearLayout linLVertical;

  @NonNull
  public final RadioGroup radGroupOpciones;

  @NonNull
  public final MaterialRadioButton rbtnEmpresa;

  @NonNull
  public final MaterialRadioButton rbtnPersona;

  @NonNull
  public final TextView snkBar;

  @NonNull
  public final MaterialTextView tituloOpcionesRegistro;

  private ActivityOpcionesRegistroBinding(@NonNull RelativeLayout rootView,
      @NonNull MaterialButton btnOcionesContinuar, @NonNull MaterialButton btnOpcionesCancelar,
      @NonNull LinearLayout linLVertical, @NonNull RadioGroup radGroupOpciones,
      @NonNull MaterialRadioButton rbtnEmpresa, @NonNull MaterialRadioButton rbtnPersona,
      @NonNull TextView snkBar, @NonNull MaterialTextView tituloOpcionesRegistro) {
    this.rootView = rootView;
    this.btnOcionesContinuar = btnOcionesContinuar;
    this.btnOpcionesCancelar = btnOpcionesCancelar;
    this.linLVertical = linLVertical;
    this.radGroupOpciones = radGroupOpciones;
    this.rbtnEmpresa = rbtnEmpresa;
    this.rbtnPersona = rbtnPersona;
    this.snkBar = snkBar;
    this.tituloOpcionesRegistro = tituloOpcionesRegistro;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOpcionesRegistroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOpcionesRegistroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_opciones_registro, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOpcionesRegistroBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnOcionesContinuar;
      MaterialButton btnOcionesContinuar = ViewBindings.findChildViewById(rootView, id);
      if (btnOcionesContinuar == null) {
        break missingId;
      }

      id = R.id.btnOpcionesCancelar;
      MaterialButton btnOpcionesCancelar = ViewBindings.findChildViewById(rootView, id);
      if (btnOpcionesCancelar == null) {
        break missingId;
      }

      id = R.id.linLVertical;
      LinearLayout linLVertical = ViewBindings.findChildViewById(rootView, id);
      if (linLVertical == null) {
        break missingId;
      }

      id = R.id.radGroupOpciones;
      RadioGroup radGroupOpciones = ViewBindings.findChildViewById(rootView, id);
      if (radGroupOpciones == null) {
        break missingId;
      }

      id = R.id.rbtnEmpresa;
      MaterialRadioButton rbtnEmpresa = ViewBindings.findChildViewById(rootView, id);
      if (rbtnEmpresa == null) {
        break missingId;
      }

      id = R.id.rbtnPersona;
      MaterialRadioButton rbtnPersona = ViewBindings.findChildViewById(rootView, id);
      if (rbtnPersona == null) {
        break missingId;
      }

      id = R.id.snkBar;
      TextView snkBar = ViewBindings.findChildViewById(rootView, id);
      if (snkBar == null) {
        break missingId;
      }

      id = R.id.tituloOpcionesRegistro;
      MaterialTextView tituloOpcionesRegistro = ViewBindings.findChildViewById(rootView, id);
      if (tituloOpcionesRegistro == null) {
        break missingId;
      }

      return new ActivityOpcionesRegistroBinding((RelativeLayout) rootView, btnOcionesContinuar,
          btnOpcionesCancelar, linLVertical, radGroupOpciones, rbtnEmpresa, rbtnPersona, snkBar,
          tituloOpcionesRegistro);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
