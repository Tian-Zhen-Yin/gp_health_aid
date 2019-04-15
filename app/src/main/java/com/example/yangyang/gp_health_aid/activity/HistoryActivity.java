package com.example.yangyang.gp_health_aid.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.adapter.HistoryAdapter;
import com.example.yangyang.gp_health_aid.adapter.PassageAdapter;
import com.example.yangyang.gp_health_aid.bean.History;
import com.example.yangyang.gp_health_aid.bean.Passage;
import com.example.yangyang.gp_health_aid.db.MyDB;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class HistoryActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<History> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = findViewById(R.id.list);
        initData();
        HistoryAdapter adapter = new HistoryAdapter(getContext(), list);
        listView.setAdapter(adapter);
    }

    private void initData() {

        list.add(new History("今日清明，养生要点","http://mp.weixin.qq.com/s?__biz=MzA5ODM0ODgzMA==&mid=2651222075&idx=1&sn=00d8ca84806d6710e304f646913352e9&chksm=8b602a4abc17a35c035df9ccb1d9c65ad1ae84e0e2e53bc505337a20ab22402cb5183d4b32e3&mpshare=1&scene=23&srcid=0408oEXtXf5c0V4jztEKhuJe#rd"));
        list.add(new History("养生长寿“十字诀","http://mp.weixin.qq.com/s?__biz=MjM5MDUwNTEyMw==&mid=2247493810&idx=1&sn=dd311f4b46589cff2866138bf01d34d7&chksm=a641697e9136e068f150c4dad88788ee528f091753c302f2b2eac8d637d618ac49fe7665dc48&mpshare=1&scene=23&srcid=0408M1ltLA0Ng00oPbDXm95Z#rd"));
        list.add(new History("保养后背 = 保命，比养脸更重要！","http://mp.weixin.qq.com/s?__biz=MjM5OTgyODIwMQ==&mid=2653003748&idx=1&sn=293cf27ac9d4983424d55b2659d9afbb&chksm=bce0b0628b97397407941b6c2401e408579182bbbb432ba3b02fb19cf2fef76ec777a7431892&mpshare=1&scene=23&srcid=0408VcLqG7LNhPSXTaQIAXS4#rd"));
        list.add(new History("什么叫养生？","http://mp.weixin.qq.com/s?__biz=MzAwOTQwMTIyNg==&mid=2654649439&idx=1&sn=8f31c68375251b6893eadc307d3ee25e&chksm=80ae3abab7d9b3acccce3cd74855e5affa0a54bbc45dad9c34cbeb22ec48a068557dbe2dac22&mpshare=1&scene=23&srcid=0408evNAIoaQyvGhn01hUBOV#rd"));
    }
}
