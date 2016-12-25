package kr.dataguru.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recycleview;

    private Adapter adapter;
    private ArrayList<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        // adapter , arrayList( data )
        data = new ArrayList<Data>();
        adapter = new Adapter( MainActivity.this, data );

        // recycleview
        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setAdapter(adapter);

        Initialization();
    }

    private void Initialization () {
        for ( int i = 0; i < 1000; i++ ) {
            Data data = new Data();
            data.id = i;
            data.name = i+"_name";
            this.data.add(data);
        }
    }

}
