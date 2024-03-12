package ru.rodipit.mb5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.rec);
        ArrayList<Item> data = new ArrayList<>(Arrays.asList(
                new Item(R.drawable.cat, "Cat"),
                new Item(R.drawable.dog, "Dog"),
                new Item(R.drawable.fish, "Fish"),
                new Item(R.drawable.hamster, "Hamster"),
                new Item(R.drawable.parrot, "Parrot"),
                new Item(R.drawable.pow, "Pow"),
                new Item(R.drawable.turtle, "Turtle")
            )
        );

        MainAdapter adapter = new MainAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}