package it.gualtierotesta.testsolutions.general.beans;

import com.google.common.testing.SerializableTester;
import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

/**
 * Unit test
 */
public class GoodBeanTest {

    @Test
    public void testClassIsGoodBean() {
        assertThat(GoodBean.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCodeFor("anInt"),
                hasValidBeanEqualsFor("anInt"),
                hasValidBeanToString()
        ));
    }

    @Test
    public void testClassIsSerializable() {
        SerializableTester.reserializeAndAssert(new GoodBean());
    }



}