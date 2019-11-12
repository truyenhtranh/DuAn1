package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    GridView gvTruyenHot;
    ViewFlipper vfSlideShow;
    truyenTranhAdapter adapter;
    ArrayList<truyenTranh> truyenTranhArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addlist();
        anhxa();
        setup();
        addslide();
    }
    public void truyenhot(View view) {
        Intent intent = new Intent(HomeActivity.this, TruyenHotActivity.class);
        startActivity(intent);
    }

    public void addslide() {

        ArrayList<String>   slide = new ArrayList<>();

        slide.add("https://media.motgame.vn/2017/10/wofdevil/sbfb.jpg");
        slide.add("https://image.thanhnien.vn/660/uploaded/game/upload/image/article/2015/09/30/132c254b87e370d3d0423fcc5539cf23.jpg");
        slide.add("https://1.bp.blogspot.com/-iSLu0uKIeqc/W7mAI5J0F_I/AAAAAAAAN6w/aT9xDcrs8MgZmBgIyJZjG5r9W6qPo8nzQCHMYCw/s0/1.jpg");
        slide.add("https://i0.wp.com/agaming.vn/wp-content/uploads/2019/05/tinh-th%E1%BA%A7n-bi%E1%BA%BFn.jpg?fit=1920%2C1080&ssl=1");

        for (int i = 0; i < slide.size(); i++) {
            ImageView imageView = new ImageView(this);
            Glide.with(this).load(slide.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            vfSlideShow.addView(imageView);
        }
        vfSlideShow.setFlipInterval(3000);
        vfSlideShow.setAutoStart(true);


    }
    public void addlist() {

        truyenTranhArrayList = new ArrayList<>();

        truyenTranhArrayList.add(new truyenTranh("Chapter 155", "Kim Bài Điềm Thê", "https://st.nettruyen.com/data/comics/178/kim-bai-diem-the.jpg"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 94", "Xú Nữ Đích Hậu Cung", "https://3.bp.blogspot.com/-H2FvKQHrO70/Wo6k77wZZ9I/AAAAAAAANWw/Guhs6Gw9DAATY6YGTKAHWvg5joPhCkqWgCHMYCw/xu-nu-dich-hau-cung"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 207", "Tu Chân Giả Tại Dị Thế", "https://3.bp.blogspot.com/-rp49zPFln94/XCLzlolhyzI/AAAAAAAAbiU/yEhYWCOb91QbQ7pFff2-DxV4yq84nE2cgCHMYCw/tu-chan-gia-tai-di-the"));
        truyenTranhArrayList.add(new truyenTranh("Chapter 114", "Manh Sư Tại Thượng", "https://st.nettruyen.com/data/comics/129/manh-su-tai-thuong.jpg"));

        adapter = new truyenTranhAdapter(this, 0, truyenTranhArrayList);


    }


    public void anhxa() {
        gvTruyenHot = findViewById(R.id.gvTruyenHot);
        vfSlideShow = findViewById(R.id.vfSlideShow);

    }


    public void setup() {

        gvTruyenHot.setAdapter(adapter);

    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


}
