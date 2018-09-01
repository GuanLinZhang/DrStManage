package cn.drst.entity;

public class MobileManageImages {
    private int id;
    private String name;
    private int type;
    private int sore;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSore() {
        return sore;
    }

    public void setSore(int sore) {
        this.sore = sore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileManageImages that = (MobileManageImages) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (sore != that.sore) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + sore;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
