package com.iti.intake39.jad.mvvm_example.screens.additemscreen;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.iti.intake39.jad.mvvm_example.R;
import com.iti.intake39.jad.mvvm_example.screens.additemscreen.ListItemViewModel;

public class AddItemActivity extends AppCompatActivity {

    Button addCharacterBtn;
    EditText characterNameET;
    EditText characterImageET;
    ProgressBar progressBar;

    ListItemViewModel listItemViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initComponents();
    }

    private void initComponents(){
        characterImageET = findViewById(R.id.characterImageET);
        characterNameET = findViewById(R.id.characterNameET);
        progressBar = findViewById(R.id.progress_bar);
        addCharacterBtn = findViewById(R.id.addCharBtn);

        characterNameET.setText("Bart Simpson");
        characterImageET.setText("https://sketchok.com/images/articles/01-cartoons/001-simpsons/20/14.jpg");

        listItemViewModel = ViewModelProviders.of(this).get(ListItemViewModel.class);
        listItemViewModel.getIsPlacesUpdating().observe(this, aBoolean -> {
            if(aBoolean){
                showProgressBar();
            } else{
                hideProgressBar();
                finish();
            }
        });

        addCharacterBtn.setOnClickListener(v ->
                listItemViewModel.addNewCharacter(characterNameET.getText().toString(),characterImageET.getText().toString()));
    }

    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }

}
