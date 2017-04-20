package br.grupointegrado.bhpachulski.todoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.grupointegrado.bhpachulski.todoproject.bd.DataBase;
import br.grupointegrado.bhpachulski.todoproject.model.ToDo;

public class MainActivity extends AppCompatActivity {

    private ListView lvToDo;
    private DataBase db;

    private List<ToDo> listToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBase(this);
        lvToDo = (ListView) findViewById(R.id.lvTodo);


        lvToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                alterar(listToDo.get(position));

            }

        });


    }

    public void alterar(ToDo toDo) {
        Intent i = new Intent(this, RegisterToDoActivity.class);
        i.putExtra("ToDo", toDo);

        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        listToDo = db.getTodos();

        ArrayAdapter<ToDo> la =
                new ArrayAdapter<ToDo>(this, android.R.layout.simple_list_item_1, listToDo);

        lvToDo.setAdapter(la);
    }

    public void gotoAddToDo(View v) {

        Intent i = new Intent(this, RegisterToDoActivity.class);
        startActivity(i);

    }


}
