package com.example.yangyang.gp_health_aid.fragment;

import android.Manifest;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yangyang.gp_health_aid.R;
import com.example.yangyang.gp_health_aid.adapter.PassageAdapter;
import com.example.yangyang.gp_health_aid.bean.Passage;
import com.example.yangyang.gp_health_aid.db.MyDB;

import org.litepal.LitePal;

import java.util.ArrayList;

public class ReadFragment extends Fragment {
    private ListView listView;
    private ArrayList<Passage> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read, container, false);
        listView = view.findViewById(R.id.lv_passage);
        Passage passage = new Passage();
        passage.setPic_uri("https://ss0.baidu.com/73t1bjeh1BF3odCf/it/u=877382831,2770056495&fm=85&s=6B7A7ADAD81077FD1B9D975A0300D076");
        passage.setTitle("123");
        passage.setPassage_uri("https://tieba.baidu.com");
        data.add(passage);

//        ActivityCompat.requestPermissions(getActivity(),
//                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                1);

        LitePal.deleteAll(Passage.class);
        MyDB.formPassage();
        data = (ArrayList<Passage>) LitePal.findAll(Passage.class);


        PassageAdapter adapter = new PassageAdapter(getContext(),data);
        listView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
