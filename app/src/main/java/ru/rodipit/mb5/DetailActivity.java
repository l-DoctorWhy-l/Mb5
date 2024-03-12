package ru.rodipit.mb5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import ru.rodipit.mb5.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int categoryId = R.array.milk;
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            switch (Objects.requireNonNull(bundle.getString("category"))){
                case "Сыр":
                    categoryId = R.array.cheese;
                    break;
                case "Молочка":
                    categoryId = R.array.milk;
                    break;
                case "Бакалея":
                    categoryId = R.array.bakaleya;
                    break;
                case "Колбаса":
                    categoryId = R.array.sausage;
                    break;
                case "Чай":
                    categoryId = R.array.tea;
                    break;
                case "Выпечка":
                    categoryId = R.array.backed;
                    break;
                case "Мороженое":
                    categoryId = R.array.ice_cream;
                    break;
            }
        }
        ArrayList<String> goods = new ArrayList<>(Arrays.asList(getResources().getStringArray(categoryId)));
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, goods);
        binding.listView.setAdapter(categoryAdapter);

        binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                goods.remove(position);
                categoryAdapter.notifyDataSetChanged();
                return false;
            }
        });
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.editText.getText() != null && !binding.editText.getText().toString().isEmpty()){
                    goods.add(binding.editText.getText().toString());
                    categoryAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(v.getContext(), "Введите продукт", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}