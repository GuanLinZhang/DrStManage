package cn.drst.entity;

import java.io.Serializable;

public class CodePK implements Serializable {
    private String codeId;
    private String typeId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodePK codePK = (CodePK) o;

        if (codeId != null ? !codeId.equals(codePK.codeId) : codePK.codeId != null) return false;
        if (typeId != null ? !typeId.equals(codePK.typeId) : codePK.typeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeId != null ? codeId.hashCode() : 0;
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        return result;
    }
}
