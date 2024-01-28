package com.example.testartapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.testartapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder().build();

        binding.textViewStatic.setText(R.string.text_view_static);
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> messages = new ArrayList<>();
                messages.add("For sure!");
                messages.add("100%");
                messages.add("Of course");
                binding.textViewActive.setText(messages.get(new Random().nextInt(messages.size())));
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.red) {
            findViewById(R.id.textViewActive).setBackgroundColor(getColor(R.color.red));
            return true;
        }
        if (id == R.id.green) {
            findViewById(R.id.textViewActive).setBackgroundColor(getColor(R.color.green));
            return true;
        }
        if (id == R.id.blue) {
            findViewById(R.id.textViewActive).setBackgroundColor(getColor(R.color.blue));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}