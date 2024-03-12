package ru.rodipit.mb5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import ru.rodipit.mb5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> categories = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.categories)));
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        binding.listView.setAdapter(categoryAdapter);
        binding.listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = categories.get(position);
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("category", selectedItem);
            startActivity(intent);
        });

        binding.recBtn.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RecyclerActivity.class);
            startActivity(intent);
        });
        binding.scrollSpinnerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ScrollActivity.class);
            startActivity(intent);
        });


    }
}