package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task6Activity extends AppCompatActivity {

    static ArrayList<Map<String, Object>> filmsList;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner) this.findViewById(R.id.spinner);

        Film[] films = {
                new Film("Интерстеллар", "Фантастика", 2015),
                new Film("Человек-муравей", "Фэнтези", 2015),
                new Film("Выживший", "Драма", 2015),
                new Film("Рейд-2", "Боевик", 2014),
                new Film("Хоббит: Пустошь Смауга", "Фэнтези", 2013)
        };

        if(filmsList == null) {
            filmsList = new ArrayList<>();
            for (int i = 0; i < films.length; i++) {
                this.addFilmToList(films[i]);
            }
        }

        simpleAdapter = new SimpleAdapter(
                this,
                filmsList,
                R.layout.spinner_item,
                new String[]{"Title", "Genre", "Year"},
                new int[]{ R.id.tvTitle, R.id.tvGenre, R.id.tvYear } );
        simpleAdapter.setDropDownViewResource(R.layout.spinner_item);

        spinner.setAdapter(simpleAdapter);

    }

    void addFilmToList(Film film) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Title", film.title);
        hashMap.put("Genre", film.genre);
        hashMap.put("Year", film.year);
        filmsList.add(hashMap);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnAddClick(View view) {
        EditText editTitle = this.findViewById(R.id.editName);
        EditText editGende = this.findViewById(R.id.editGenre);
        EditText editYear = this.findViewById(R.id.editYear);
        Editable title = editTitle.getText();
        Editable genre = editGende.getText();
        Editable year = editYear.getText();
        if(title.length() < 1 || genre.length() < 1 || year.length() < 4) {
            Toast.makeText(this, "All fiels are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        this.addFilmToList(new Film(title.toString(), genre.toString(), Integer.parseInt(year.toString())));
        simpleAdapter.notifyDataSetChanged();
        editTitle.setText("");
        editGende.setText("");
        editYear.setText("");
        Toast.makeText(this, "Succesfully added!", Toast.LENGTH_SHORT).show();
    }
}
