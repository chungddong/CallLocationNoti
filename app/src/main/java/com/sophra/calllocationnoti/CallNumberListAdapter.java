package com.sophra.calllocationnoti;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CallNumberListAdapter extends RecyclerView.Adapter<CallNumberListAdapter.ViewHolder> {
    @NonNull
    @Override
    public CallNumberListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CallNumberListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
                    return false;
                }
            });
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
