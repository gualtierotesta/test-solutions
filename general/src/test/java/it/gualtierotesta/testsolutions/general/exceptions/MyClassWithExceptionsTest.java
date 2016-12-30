package it.gualtierotesta.testsolutions.general.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

/**
 * Unit test to show how to use jUnit Rule ExpectedException
 */
public class MyClassWithExceptionsTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void convertNameWhenNameIsCorrectShouldReturnInUpperCase() throws Exception {
        final MyClassWithExceptions sut = new MyClassWithExceptions();
        final String res = sut.convertNameToUpperCase("mario");
        assertEquals("MARIO", res);
    }

    @Test
    public void convertNameWhenNameIsTooShortShouldThrowException() throws Exception {
        final MyClassWithExceptions sut = new MyClassWithExceptions();
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(containsString("is too short"));
        sut.convertNameToUpperCase("aa");
    }

    @Test
    public void convertNameWhenNameIsNullShouldThrowException() throws Exception {
        final MyClassWithExceptions sut = new MyClassWithExceptions();
        thrown.expect(NullPointerException.class);
        sut.convertNameToUpperCase(null);
    }

}