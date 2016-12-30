package it.gualtierotesta.testsolutions.general.exceptions;

import java.util.Objects;

/**
 * Class which can generated some exceptions
 */
public class MyClassWithExceptions {

    public String convertNameToUpperCase(final String pName) {
        Objects.requireNonNull(pName, "Name cannot be null");
        if (pName.length() < 3) {
            throw  new IllegalStateException(String.format("Name %s is too short", pName));
        }
        return pName.toUpperCase();
    }
}
