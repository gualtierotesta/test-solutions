package it.gualtierotesta.testsolutions.general.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * A good bean
 */
@Data
public class LombokBean implements Serializable {

    String aStr;
    int anInt;

}
