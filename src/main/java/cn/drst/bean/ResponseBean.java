package cn.drst.bean;

import cn.drst.base.RetData;

/**
 * 后台给页面的返回结果
 *
 * */
public class ResponseBean<T> {

    private int state;
    private String message;
    private int total;
    private RetData<T> retData;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public RetData<T> getRetData() {
        return retData;
    }

    public void setRetData(RetData<T> retData) {
        this.retData = retData;
    }
}
