package com.wangj.variousdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wangj.variousdemo.adapter.DemoListAdapter;
import com.wangj.variousdemo.entity.DemoVo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<DemoVo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        list = new ArrayList<>();

        DemoListAdapter adapter = new DemoListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        DemoVo demoVo;

        demoVo = new DemoVo("radioGroup", "RadioGroup中onCheckedChanged()被触发多次的问题");
        list.add(demoVo);

        demoVo = new DemoVo("banner", "Banner");
        list.add(demoVo);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch (list.get(position).getDemoNo()) {
            case "radioGroup":
                intent = new Intent(this, RadioGroupActivity.class);
                startActivity(intent);
                break;
            case "banner":
                break;
        }
    }
}
