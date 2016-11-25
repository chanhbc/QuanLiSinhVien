package com.chanhbc.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private MyDatabase myDatabase;
    private ArrayList<SinhVien> sinhViens;
    private ListViewAdapter adapter;
    private ListView lvShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        initListener();
        loadListView();
    }

    private void loadListView() {
        sinhViens = getSinhViens();
        adapter = new ListViewAdapter(this, sinhViens);
        lvShowData.setAdapter(adapter);
    }

    private void initListener() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
                loadListView();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
                loadListView();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
                loadListView();
            }
        });
    }

    private void insert() {
        String name = etName.getText().toString();
        String toan = etToan.getText().toString();
        String li = etLi.getText().toString();
        String hoa = etHoa.getText().toString();
        boolean bl = myDatabase.insertData(name, toan, li, hoa);
        if (bl) {
            Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Insert fail", Toast.LENGTH_SHORT).show();
        }
    }

    private void update() {
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        String toan = etToan.getText().toString();
        String li = etLi.getText().toString();
        String hoa = etHoa.getText().toString();
        boolean bl = myDatabase.updateData(id, name, toan, li, hoa);
        if (bl) {
            Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
        }
    }

    private void delete() {
        String id = etId.getText().toString();
        boolean bl = myDatabase.deleteData(id);
        if (bl) {
            Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<SinhVien> getSinhViens() {
        Cursor cursor = myDatabase.getAllData();
        ArrayList<SinhVien> sinhViens = new ArrayList<>();
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String toan = cursor.getString(2);
            String li = cursor.getString(3);
            String hoa = cursor.getString(4);
            SinhVien sinhVien = new SinhVien(id, name, Integer.parseInt(toan), Integer.parseInt(li), Integer.parseInt(hoa));
            sinhViens.add(sinhVien);
            // sinhVien là 1 đối tượng sinh viên
            // sinhViens là 1 danh sách các sinh viên
        }
        return sinhViens;
    }

    private void initView() {
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etToan = (EditText) findViewById(R.id.et_toan);
        etLi = (EditText) findViewById(R.id.et_ly);
        etHoa = (EditText) findViewById(R.id.et_hoa);
        lvShowData = (ListView) findViewById(R.id.lv_show_data);
    }
}
