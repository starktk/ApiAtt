package br.com.fundatec.core

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun errorMessages( view: View , message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}