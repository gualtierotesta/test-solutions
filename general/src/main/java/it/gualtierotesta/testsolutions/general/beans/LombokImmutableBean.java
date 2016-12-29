package it.gualtierotesta.testsolutions.general.beans;

import lombok.Value;

import java.io.Serializable;

/**
 * A good IMMUTABLE bean with builder
 */
@Value(staticConstructor = "of")
public class LombokImmutableBean implements Serializable {

    String aStr;
    int anInt;

}
