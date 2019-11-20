package com.example.birdwatcherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BirdsByZipcode extends AppCompatActivity implements View.OnClickListener {

    EditText editTextZipCode;
    Button buttonSubmitZipCode;
    TextView textViewBird, textViewZipCode, textViewPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_by_zipcode);

        editTextZipCode = findViewById(R.id.editTextZipCode);
        buttonSubmitZipCode = findViewById(R.id.buttonSubmitZipCode);
        textViewBird = findViewById(R.id.textViewBird);
        textViewPerson = findViewById(R.id.textViewPerson);
        textViewZipCode = findViewById(R.id.textViewZipCode);

        buttonSubmitZipCode.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.dropdown, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.zipcode_menu_item) {
            Toast.makeText(this, "You are already here", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.main_activity_menu_item) {
            Intent MainIntent = new Intent(this, MainActivity.class);
            startActivity(MainIntent);

            return super.onOptionsItemSelected(item);
        }



}