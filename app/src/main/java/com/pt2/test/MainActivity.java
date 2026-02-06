package com.pt2.test;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker data_picker;
    private TimePicker czas_picker;
    private Button button;
    private  Button button2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        data_picker = findViewById(R.id.data_picker);
        czas_picker = findViewById(R.id.czas_picker);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int godzina = czas_picker.getHour();
                        int minuta = czas_picker.getMinute();
                        int rok = data_picker.getYear();

                        Toast.makeText(MainActivity.this, "Godzina: " + godzina + " minuta: " + minuta + " rok: " + rok, Toast.LENGTH_SHORT).show();

                        Date date = new Date();
                        Toast.makeText(MainActivity.this, ""+date, Toast.LENGTH_SHORT).show();

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, data_picker.getYear());
                        calendar.set(Calendar.MINUTE, czas_picker.getMinute());
                        Toast.makeText(MainActivity.this, "" + calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                new DatePickerDialog.OnDateSetListener(){
                                    @Override
                                    public void onDateSet(DatePicker, data_picker, int i, int i1, int i2){
                                        Toast //... i1, i2, i
                                    }
                                }
                        );
                    }
                }
        );
    }
}