package com.example.medialarmas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Slide
import androidx.transition.TransitionManager
import android.view.Gravity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AlertDialog

class Medicamentos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicamentos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainLayout = findViewById<ConstraintLayout>(R.id.main)
        val buttonToggle = findViewById<Button>(R.id.button_toggle)
        val layoutCollapsible = findViewById<LinearLayout>(R.id.layout_collapsible)

        buttonToggle.setOnClickListener {
            val transition = Slide(Gravity.TOP)
            transition.duration = 300 // Duración en milisegundos
            TransitionManager.beginDelayedTransition(mainLayout, transition)

            layoutCollapsible.visibility = if (layoutCollapsible.visibility == View.GONE) View.VISIBLE else View.GONE

            // Cambiar el drawableEnd del botón según el estado
            val drawableRes = if (layoutCollapsible.visibility == View.VISIBLE) R.drawable.chevron_down else R.drawable.chevron_up
            buttonToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRes, 0)
        }

        val buttonDelete = findViewById<Button>(R.id.btnDelete)

        buttonDelete.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("¿Está seguro que quiere eliminar Neosaldina 300mg?")
                .setMessage("Cuidado - Después de realizar esta acción  no se podrá dar macha atrás y eliminará las alertas creadas")
                .setIcon(R.drawable.exclamation_triangle_fill)
                .setPositiveButton("Eliminar", null)
                .setNegativeButton("Cancelar", null)
                .show()
        }

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}