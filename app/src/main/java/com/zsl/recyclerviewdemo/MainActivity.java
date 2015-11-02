package com.zsl.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zsl.recyclerviewdemo.adapter.MultipleItemAdapter;
import com.zsl.recyclerviewdemo.entity.User;
import com.zsl.recyclerviewdemo.utils.UniversalRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> stringList = new ArrayList<String>();

    //用户数据
    List<User> userList = new ArrayList<User>();

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
        rv_show1 = (RecyclerView) findViewById(R.id.main_rv_show);
    }

    /**
     * 初始化数据
     */
    private void initData() {

        //设置图片集合
        stringList.add("http://img1.imgtn.bdimg.com/it/u=421165063,3498236940&fm=21&gp=0.jpg");
        stringList.add("http://h.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=a1ccc0cf0e3387449c902778643ff5cf/1f178a82b9014a90a1ebd822ab773912b21bee5c.jpg");
        stringList.add("http://img1.imgtn.bdimg.com/it/u=421653212,2998227149&fm=21&gp=0.jpg");
        stringList.add("http://www.touxiang.cn/uploads/20120618/18-073743_592.jpg");
        stringList.add("http://img0.imgtn.bdimg.com/it/u=4199215011,2285916080&fm=21&gp=0.jpg");
        stringList.add("http://www.weiqing120.com/UploadFiles/2013-04/wqyh/2013040511193569515.png");
        stringList.add("http://img5.imgtn.bdimg.com/it/u=1977061024,4114566629&fm=21&gp=0.jpg");
        stringList.add("http://img4.imgtn.bdimg.com/it/u=1991363743,3521862172&fm=21&gp=0.jpg");
        stringList.add("http://img13.poco.cn/mypoco/myphoto/20120801/18/65977259201208011804182254932890640_000.jpg");
        stringList.add("http://img1.3lian.com/gif/more/11/201210/58485e92169cf749dc1fb7a8a9872ef1.jpg");

        //添加数据
        for (int i = 0; i < 1000; i++) {
            int position = (int) (Math.random() * 10);
            User user = new User(i, "Name " + i, stringList.get(position), position % 2 == 0 ? true : false);
            userList.add(user);
        }

//        rv_show1.setLayoutManager(new LinearLayoutManager(this));
        rv_show1.setLayoutManager(new GridLayoutManager(this,2));

//        rv_show1.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.HORIZONTAL));
        /**
         * 初始化普通的adapter
         */
//        final MyShow2Adapter myShow2Adapter = new MyShow2Adapter(this, userList, 0);
//
//        //添加点击事件
//        myShow2Adapter.setOnItemClickListener(new UniversalRecyclerViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View itemView, int position) {
//                if (position == 2) {
//                    //添加
//                    int random = (int) (Math.random() * 10);
//                    User user = new User(2, "Changed Name ", stringList.get(random), random % 2 == 0 ? true : false);
//                    myShow2Adapter.add(user, position);
//                } else {
//                    //更新
//                    User user=userList.get(position);
//                    user.setIsMan(!user.isMan());
//                    myShow2Adapter.update(position);
//                }
//            }
//        });
//
//        //添加adapter
//        rv_show1.setAdapter(myShow2Adapter);

        /**
         * 初始化多item的adapter
         */
        final MultipleItemAdapter multipleItemAdapter=new MultipleItemAdapter(this,userList);

        //添加点击事件
        multipleItemAdapter.setOnItemClickListener(new UniversalRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                if (position == 2) {
                    //添加
                    int random = (int) (Math.random() * 10);
                    User user = new User(2, "Changed Name ", stringList.get(random), random % 2 == 0 ? true : false);
                    multipleItemAdapter.add(user, position);
                } else {
                    //更新
                    User user=userList.get(position);
                    user.setIsMan(!user.isMan());
                    multipleItemAdapter.update(position);
                }
            }
        });

        //设置adapter
        rv_show1.setAdapter(multipleItemAdapter);


    }
}
