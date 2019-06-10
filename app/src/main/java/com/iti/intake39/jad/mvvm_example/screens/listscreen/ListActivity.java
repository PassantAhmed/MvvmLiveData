package com.iti.intake39.jad.mvvm_example.screens.listscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iti.intake39.jad.mvvm_example.R;
import com.iti.intake39.jad.mvvm_example.screens.additemscreen.AddItemActivity;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListRecyclerviewAdapter listAdapter;
    FloatingActionButton addButton;

    ListViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initComponents();
    }

    private void initComponents(){
        recyclerView = findViewById(R.id.recycler_view);
        addButton = findViewById(R.id.addBtn);
        initViewModel();
        initRecyclerviewComponents();
        addButton.setOnClickListener(v -> {
            startActivity(new Intent(ListActivity.this, AddItemActivity.class));
        });
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.getCharacters().observe(this, animatedCharacters -> {
            listAdapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerviewComponents(){
        listAdapter = new ListRecyclerviewAdapter(viewModel.getCharacters().getValue(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

}
