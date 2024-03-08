package com.sophra.calllocationnoti;

public class CallNumberListAdapter {
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
