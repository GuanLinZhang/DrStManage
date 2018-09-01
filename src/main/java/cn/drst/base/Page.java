package cn.drst.base;

public class Page {

    private int everyPage;         // 1.每页显示数量
    private int totalCount;        // 2.总记录数
    private int totalPage;         // 3.总页数
    private int currentPage;       // 4.当前页
    private int beginIndex;        // 5.起始点
    private boolean hasPrePage;    // 6.是否有上一页
    private boolean hasNextPage;   // 7.是否有下一页

    //构造函数
    public Page(int everyPage, int totalCount, int totalPage, int currentPage,
                int beginIndex, boolean hasPrePage, boolean hasNextPage) {
        this.everyPage = everyPage;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.beginIndex = beginIndex;
        this.hasPrePage = hasPrePage;
        this.hasNextPage = hasNextPage;
    }

    //构造函数，默认
    public Page() {
    }

    //构造方法，对所有属性进行设置
    public int getEveryPage() {
        return everyPage;
    }
    public void setEveryPage(int everyPage) {
        this.everyPage = everyPage;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getBeginIndex() {
        return beginIndex;
    }
    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }
    public boolean isHasPrePage() {
        return hasPrePage;
    }
    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }
    public boolean isHasNextPage() {
        return hasNextPage;
    }
    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
