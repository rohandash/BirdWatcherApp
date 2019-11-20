package com.example.birdwatcherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //declare objects in the UI

    EditText editTextBirdName, editTextZipCode, editTextPersonReporting;
    Button buttonSubmit;

    public MainActivity(String createBirdName, String createPersonReporting, Integer createZipCode) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the UI to the code
        editTextBirdName = findViewById(R.id.editTextBirdName);
        editTextZipCode = findViewById(R.id.editTextZipCode);
        editTextPersonReporting = findViewById(R.id.editTextPersonReporting);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);




    }
    public void onClick(View view) {

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        if(view == buttonSubmit) { //when the submit button is pressed, the following information
            // will be stored in a string from the editText fields
            String createBirdName = editTextBirdName.getText().toString();
            String createPersonReporting = editTextPersonReporting.getText().toString();
            Integer createZipCode = Integer.parseInt((editTextZipCode.getText().toString()));

            // create new class newSighting to store data in database
            MainActivity newSighting = new MainActivity(createBirdName, createPersonReporting, createZipCode);

            myRef.push().setValue(newSighting);

        }

        if(view == buttonSubmit) {
            Toast.makeText(this, "A new record has been saved. Thank you.", Toast.LENGTH_SHORT).show();


            }


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.dropdown, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //if Bird Sighting (id main_activity_menu_item) is pressed nothing should happen so bc you
        //are already here (show Toast)
        if(item.getItemId() == R.id.main_activity_menu_item) {
            Toast.makeText(this, "You are already here", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.zipcode_menu_item) {
            Intent ZipCodeIntent = new Intent(this, BirdsByZipcode.class);
            startActivity(ZipCodeIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}








