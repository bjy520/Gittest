package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.list_release)
    ImageView listRelease;
    @Bind(R.id.list_unrelease)
    ImageView listUnrelease;
    @Bind(R.id.list_show)
    ListView listShow;
    @Bind(R.id.Refresh_main)
    PullToRefreshLayout RefreshMain;
    private List<Message> lists;
    private Adapter adapter;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化数据并数据放入
        init();
        //加载更多
        load();
    }
    private void load(){
        RefreshMain.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.addb(lists);
                        // 结束刷新
                        RefreshMain.finishRefresh();
                    }
                }, 2000);
            }
            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束加载更多
                        adapter.adda(lists);
                        RefreshMain.finishLoadMore();
                    }
                }, 2000);
            }
        });
    }
    private void init() {
        lists = new ArrayList<Message>();
        adapter = new Adapter(this);
        Random random = new Random();
        int a=random.nextInt(20);
        for (int ic=0;ic<20;ic++){
            message=new Message();
            message.setMsg_people("sd");
            message.setMsg_time("2018年4月14日 9:30:13");
            if(a==ic){
                message.setMsg_type("0");
                lists.add(message);

            }else {
                message.setMsg_type("1");
                lists.add(message);
            }
            message=null;
        }
        adapter.adda(lists);
        listShow.setAdapter(adapter);

    }

    @OnClick({R.id.list_release, R.id.list_unrelease})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.list_release:
                listRelease.setImageResource(R.drawable.list_release_);
                listUnrelease.setImageResource(R.drawable.list_unrelease);
                break;
            case R.id.list_unrelease:
                listRelease.setImageResource(R.drawable.list_release);
                listUnrelease.setImageResource(R.drawable.list_unrelease_);
                break;
        }
    }
}
