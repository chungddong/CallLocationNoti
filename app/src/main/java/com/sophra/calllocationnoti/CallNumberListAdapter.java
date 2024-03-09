package com.sophra.calllocationnoti;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CallNumberListAdapter extends RecyclerView.Adapter<CallNumberListAdapter.ViewHolder> {

    private ArrayList<CallNumberClass> items = new ArrayList<CallNumberClass>(); //전화번호 아이템들 담은 리스트
    Dialog dialog; 


    @NonNull
    @Override
    public CallNumberListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CallNumberListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallNumberListAdapter.ViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    public void setList(ArrayList<CallNumberClass> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView CallNumber;
        TextView CallMemo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CallNumber = itemView.findViewById(R.id.list_CallNum);
            CallMemo = itemView.findViewById(R.id.list_CallMemo);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Log.d("CLN", "롱클릭함");
                    
                    int position = getAdapterPosition(); //선택한 위치 값

                    dialog = new Dialog(view.getContext());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setContentView(R.layout.dialog_default);
                    dialog.show();

                    Button btn_confirm = dialog.findViewById(R.id.btn_confirm);
                    Button btn_cancel = dialog.findViewById(R.id.btn_cancel);

                    //삭제 확인
                    btn_confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //해당 번호 리스트 삭제
                            items.remove(position);
                            notifyDataSetChanged();
                            dialog.dismiss();

                            Toast.makeText(view.getContext(), position + "삭제하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    //삭제 취소
                    btn_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    return false;
                }
            });
        }

        void onBind(CallNumberClass list)
        {
            CallNumber.setText(list.getCallNum());
            CallMemo.setText(list.getCallMemo());
        }


    }
}





//전화번호 리스트 클래스
class CallNumberClass {
    String CallNum;
    String CallMemo;

    public CallNumberClass(String CallNum, String CallMemo)
    {
        this.CallNum = CallNum;
        this.CallMemo = CallMemo;
    }


    public String getCallNum() {
        return CallNum;
    }

    public void setCallNum(String callNum) {
        this.CallNum = callNum;
    }

    public String getCallMemo() {
        return CallMemo;
    }

    public void setCallMemo(String callMemo) {
        this.CallMemo = callMemo;
    }
}
