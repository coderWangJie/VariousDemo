package com.wangj.variousdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioGroupActivity extends AppCompatActivity {

    private RadioGroup group1;
    private RadioGroup group2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);

        group1 = findViewById(R.id.group1);
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup group, final int checkedId) {
                Log.d("WangJ", "--1--onCheckedChanged()");

                new AlertDialog.Builder(RadioGroupActivity.this)
                        .setMessage("对话框")
                        .setPositiveButton("点击", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                /* 使用RadioGroup.clearCheck()会发2次RadioGroup的onCheckedChanged()方法 */
//                                group.clearCheck();

                                /* 使用RadioButton.setChecked(boolean)视情况而定：
                                    如果传入false会再次触发RadioGroup的onCheckedChanged()一次；
                                    如果传入true，因为之前就是true，所以不会触发RadioGroup的onCheckedChanged()*/
                                ((RadioButton)group.findViewById(checkedId)).setChecked(false);
                            }
                        }).create().show();
            }
        });





        group2 = findViewById(R.id.group2);
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final RadioGroup group, final int checkedId) {
                Log.d("WangJ", "--2--onCheckedChanged()");

                /**
                 * 方案一：
                 * 上边尝试过RadioButton.setChecked(false)会再次触发RadioGroup.onCheckedChanged()方法
                 * 此时可以加额外条件来防止对话框再次弹出 —> 通过radioButton.isPressed()是否为True来判断，当setChecked(false)是虽然触发了onCheckedChanged()方法，但是isPressed()为false;
                 */
//                if (group.findViewById(checkedId).isPressed()) {
//                    new AlertDialog.Builder(RadioGroupActivity.this)
//                            .setMessage("对话框")
//                            .setPositiveButton("点击", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    ((RadioButton) group.findViewById(checkedId)).setChecked(false);
//                                }
//                            }).create().show();
//                }


                /**
                 * 方案二：
                 * 上边尝试过RadioGroup.clearCheck()会再触发RadioGroup.onCheckedChanged()方法2次
                 * 此时可以像方案一一样加radioButton.isPressed()是否为True来过滤;
                 * !!! 另外要加checkedId != -1
                 * 因为第二次触发时候checkId为-1，此时直接findViewById(int)为null
                 */
                if (checkedId != -1
                        && group.findViewById(checkedId).isPressed()) {
                    new AlertDialog.Builder(RadioGroupActivity.this)
                            .setMessage("对话框")
                            .setPositiveButton("点击", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    group.clearCheck();
                                }
                            }).create().show();
                }
            }
        });
    }
}
