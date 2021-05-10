package it.gualtierotesta.testsolutions.general.beans;

import java.io.Serializable;

/**
 * A good IMMUTABLE bean
 */
public final class ImmutableBean implements Serializable {

    private final String aStr;
    private final int anInt;

    public ImmutableBean(String aStr, int anInt) {
        this.aStr = aStr;
        this.anInt = anInt;
    }

    public String getAStr() {
        return aStr;
    }

    public int getAnInt() {
        return anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImmutableBean that = (ImmutableBean) o;

        if (anInt != that.anInt) return false;
        return aStr != null ? aStr.equals(that.aStr) : that.aStr == null;

    }

    @Override
    public int hashCode() {
        int result = aStr != null ? aStr.hashCode() : 0;
        result = 31 * result + anInt;
        return result;
    }

    @Override
    public String toString() {
        return "ImmutableBean{" +
            "aStr='" + aStr + '\'' +
            ", anInt=" + anInt +
            '}';
    }
}
