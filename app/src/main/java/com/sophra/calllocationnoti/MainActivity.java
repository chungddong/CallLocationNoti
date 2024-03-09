package com.sophra.calllocationnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_main; //리사이클러뷰
    ArrayList<CallNumberClass> items = new ArrayList<CallNumberClass>(); //전화번로 리스트 클래스
    CallNumberListAdapter rvAdapter;

    Button btn_add;
    Button btn_caution;
    Dialog dialog;
    String CallNum = "";
    String CallMemo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 바인딩
        btn_add = findViewById(R.id.btn_add);
        btn_caution = findViewById(R.id.btn_caution);

        //리스트뷰 바인딩
        rv_main = findViewById(R.id.rv_main);
        rvAdapter = new CallNumberListAdapter();

        rv_main.setAdapter(rvAdapter);
        rv_main.setLayoutManager(new LinearLayoutManager(this));

        items.add(new CallNumberClass("1111","대충메모"));
        items.add(new CallNumberClass("2222","대충메모"));
        items.add(new CallNumberClass("3333","대충메모"));
        items.add(new CallNumberClass("4444","대충메모"));
        items.add(new CallNumberClass("5555","대충메모"));
        items.add(new CallNumberClass("6666","대충메모"));
        items.add(new CallNumberClass("7777","대충메모"));
        items.add(new CallNumberClass("8888","대충메모"));


        rvAdapter.setList(items);


        
        //버튼 기능 정의
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(view.getContext());
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_addnum);
                dialog.show();

                Button btn_confirm;
                Button btn_cancel;
                
                EditText et_dialog;
                TextView tv_dialog;

                //다이얼로그 요소 바인딩
                btn_confirm = dialog.findViewById(R.id.btn_confirm);
                btn_cancel = dialog.findViewById(R.id.btn_cancel);
                et_dialog = dialog.findViewById(R.id.et_dialog);
                tv_dialog = dialog.findViewById(R.id.tv_dialog);



                //다이얼로그 버튼 기능 정의
                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //전화번호를 적지 않은 맨 초기 상황
                        if(CallNum.isEmpty())
                        {
                            //전화번호 칸이 비어있지 않다면
                            if(!et_dialog.getText().toString().isEmpty())
                            {
                                CallNum = et_dialog.getText().toString();
                                tv_dialog.setText("해당 번호에 대한 메모를 입력해주세요");
                                et_dialog.setText("");
                                et_dialog.setHint("메모를 입력해주세요");
                                et_dialog.setInputType(InputType.TYPE_CLASS_TEXT);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"전화번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else //전화번호 적은 후
                        {
                            //메모 칸이 비어있지 않다면
                            if(!et_dialog.getText().toString().isEmpty())
                            {
                                CallMemo = et_dialog.getText().toString();
                                Log.d("CLN", CallNum + "번과 " + CallMemo + "내용을 추가함");
                                Toast.makeText(getApplicationContext(),"추가하였습니다", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                                CallNum = "";
                                CallMemo = "";
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"메모를 입력해주세요", Toast.LENGTH_SHORT).show();
                            }
                        }




                    }
                });

                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        CallNum = "";
                        CallMemo = "";
                    }
                });
            }
        });


    }
}