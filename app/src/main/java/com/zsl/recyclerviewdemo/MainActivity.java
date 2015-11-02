package com.zsl.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsl.recyclerviewdemo.adapter.MyShow1Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> stringList=new ArrayList<String>();


    RecyclerView rv_show1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }


    /**
     * 初始化View
     */
    private void initView() {
        rv_show1= (RecyclerView) findViewById(R.id.main_rv_show);
    }

    /**
     * 初始化数据
     */
    private void initData() {

        stringList.add("Android");
        stringList.add("Java");
        stringList.add("JavaScript");
        stringList.add("NoteJS");
        stringList.add("Go");
        stringList.add("Swift");
        stringList.add("C");
        stringList.add("C#");
        stringList.add("C++");

        stringList.add("Android");
        stringList.add("Java");
        stringList.add("JavaScript\nJavaScriptJavaScriptJavaScriptJavaScriptJavaScript" +
                "JavaScript" +
                "JavaScript" +
                "JavaScript" +
                "JavaScript" +
                "JavaScript" +
                "JavaScript");
        stringList.add("NoteJS");
        stringList.add("Go");
        stringList.add("Swift");
        stringList.add("C");
        stringList.add("C#");
        stringList.add("C++");

        stringList.add("Android");
        stringList.add("Java");
        stringList.add("JavaScript");
        stringList.add("NoteJS");
        stringList.add("Go");
        stringList.add("Swift");
        stringList.add("C");
        stringList.add("C#");
        stringList.add("C++");

        rv_show1.setLayoutManager(new LinearLayoutManager(this));
//        rv_show1.setLayoutManager(new GridLayoutManager(this,2));
//        rv_show1.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        rv_show1.setAdapter(new MyShow1Adapter(this,stringList));
    }
}
