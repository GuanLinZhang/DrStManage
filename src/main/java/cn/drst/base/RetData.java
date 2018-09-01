package cn.drst.base;

import java.util.List;

public class RetData<T> {

    private List<T> listData;

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
