package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class TruyenHotActivity extends AppCompatActivity {

    GridView gvDSTruyen;
    EditText edtTimKiem;
    truyenTranhAdapter adapter;
    ArrayList<truyenTranh> truyenTranhArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_hot);

        addlist();
        anhxa();
        setup();
        setclick();

    }

    public void addlist() {

        truyenTranhArrayList = new ArrayList<>();

        truyenTranhArrayList.add(new truyenTranh("Chapter 155", "Kim Bài Điềm Thê", "https://st.nettruyen.com/data/comics/178/kim-bai-diem-the.jpg"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 94", "Xú Nữ Đích Hậu Cung", "https://3.bp.blogspot.com/-H2FvKQHrO70/Wo6k77wZZ9I/AAAAAAAANWw/Guhs6Gw9DAATY6YGTKAHWvg5joPhCkqWgCHMYCw/xu-nu-dich-hau-cung"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 207", "Tu Chân Giả Tại Dị Thế", "https://3.bp.blogspot.com/-rp49zPFln94/XCLzlolhyzI/AAAAAAAAbiU/yEhYWCOb91QbQ7pFff2-DxV4yq84nE2cgCHMYCw/tu-chan-gia-tai-di-the"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 114", "Manh Sư Tại Thượng", "https://st.nettruyen.com/data/comics/129/manh-su-tai-thuong.jpg"));

        truyenTranhArrayList.add(new truyenTranh("Chapter 155", "Kim Bài Điềm Thê", "https://st.nettruyen.com/data/comics/178/kim-bai-diem-the.jpg"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 94", "Xú Nữ Đích Hậu Cung", "https://3.bp.blogspot.com/-H2FvKQHrO70/Wo6k77wZZ9I/AAAAAAAANWw/Guhs6Gw9DAATY6YGTKAHWvg5joPhCkqWgCHMYCw/xu-nu-dich-hau-cung"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 207", "Tu Chân Giả Tại Dị Thế", "https://3.bp.blogspot.com/-rp49zPFln94/XCLzlolhyzI/AAAAAAAAbiU/yEhYWCOb91QbQ7pFff2-DxV4yq84nE2cgCHMYCw/tu-chan-gia-tai-di-the"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 114", "Manh Sư Tại Thượng", "https://st.nettruyen.com/data/comics/129/manh-su-tai-thuong.jpg"));

        adapter = new truyenTranhAdapter(this, 0, truyenTranhArrayList);
    }

    public void anhxa() {

        gvDSTruyen = findViewById(R.id.gvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);

    }

    ;

    public void setup() {
        gvDSTruyen.setAdapter(adapter);
    }

    public void setclick() {

        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = edtTimKiem.getText().toString();
                adapter.nhantext(text);
            }
        });

    }
}
