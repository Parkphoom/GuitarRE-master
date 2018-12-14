package com.example.famtanakit.guitar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.famtanakit.guitar.adapter.ChordListAdapter;
import com.example.famtanakit.guitar.db.DatabaseHelper;
import com.example.famtanakit.guitar.model.ChordItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.famtanakit.guitar.db.DatabaseHelper.COL_ID;
import static com.example.famtanakit.guitar.db.DatabaseHelper.COL_IMAGE;
import static com.example.famtanakit.guitar.db.DatabaseHelper.COL_NUMBER;
import static com.example.famtanakit.guitar.db.DatabaseHelper.COL_TITLE;
import static com.example.famtanakit.guitar.db.DatabaseHelper.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<ChordItem> mChordItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DatabaseHelper(MainActivity.this);
        mDb = mHelper.getWritableDatabase();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadPhoneData();
        setupListView();
    }
    private void loadPhoneData() {
        Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

        mChordItemList = new ArrayList<>();
        while (c.moveToNext()) {
            long id = c.getLong(c.getColumnIndex(COL_ID));
            String chord_name = c.getString(c.getColumnIndex(COL_TITLE));
            String key_chord = c.getString(c.getColumnIndex(COL_NUMBER));
            String image = c.getString(c.getColumnIndex(COL_IMAGE));

            ChordItem item = new ChordItem(id, chord_name, key_chord, image);
            mChordItemList.add(item);
        }
        c.close();
    }
    private void setupListView() {
        ChordListAdapter adapter = new ChordListAdapter(
                MainActivity.this,
                R.layout.item_chord,
                mChordItemList
        );
        ListView lv = findViewById(R.id.result_list_view);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //PhoneItem item = mPhoneItemList.get(position);
                final ChordItem chordItem = mChordItemList.get(position);
                Intent intent = new Intent(MainActivity.this, ChordShowActivity.class);
                intent.putExtra("chord_name", chordItem.chord_name);
                intent.putExtra("key_chord", chordItem.key_chord);
                intent.putExtra("id", chordItem._id);
                intent.putExtra("image",chordItem.image);
                startActivity(intent);

            }
        });
    }

}
