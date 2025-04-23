package com.example.dialogi3tp_e;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Przypisanie przycisków
        Button przycisk1 = findViewById(R.id.przycisk1);
        Button przycisk2 = findViewById(R.id.przycisk2);
        Button przycisk3 = findViewById(R.id.przycisk3);
        Button przycisk4 = findViewById(R.id.przycisk4);
        Button przycisk5 = findViewById(R.id.przycisk5);


        przycisk1.setOnClickListener(v -> showAlertDialog());
        przycisk2.setOnClickListener(v -> showListDialog());
        przycisk3.setOnClickListener(v -> showDatePickerDialog());
        przycisk4.setOnClickListener(v -> showTimePickerDialog());
        przycisk5.setOnClickListener(v -> showCustomDialog());
    }
    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prosty AlertDialog");
        builder.setMessage("To jest wiadomosc AlertDialogu");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Kliknięto OK", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Kliknięto Anuluj", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    private void showListDialog(){
        final String[] items = {"Opcja 1","Opcja 2","Opcja 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz opcję");

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Wybrano: " + items[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, "Wybrana data: " + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void showTimePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Wybrana godzina: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }

    private void showCustomDialog(){
        final android.app.Dialog dialog = new android.app.Dialog(this);
        dialog.setContentView(R.layout.custom);

        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Wysłano!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
