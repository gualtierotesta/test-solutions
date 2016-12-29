package it.gualtierotesta.testsolutions.general.beans;

import java.io.Serializable;

/**
 * A good JavaBean example
 */
public class GoodBean implements Serializable{

    private String aStr;
    private int anInt;

    public String getaStr() {
        return aStr;
    }

    public void setaStr(String aStr) {
        this.aStr = aStr;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodBean goodBean = (GoodBean) o;

        return anInt == goodBean.anInt;

    }

    @Override
    public int hashCode() {
        return anInt;
    }

    @Override
    public String toString() {
        return "GoodBean{" +
                "aStr='" + aStr + '\'' +
                ", anInt=" + anInt +
                '}';
    }
}
