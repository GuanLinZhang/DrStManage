package cn.drst.entity;

public class Code {
    private String codeId;
    private String typeId;
    private String text;
    private int value;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code = (Code) o;

        if (value != code.value) return false;
        if (codeId != null ? !codeId.equals(code.codeId) : code.codeId != null) return false;
        if (typeId != null ? !typeId.equals(code.typeId) : code.typeId != null) return false;
        if (text != null ? !text.equals(code.text) : code.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeId != null ? codeId.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }
}
