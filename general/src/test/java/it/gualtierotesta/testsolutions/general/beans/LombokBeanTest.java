package it.gualtierotesta.testsolutions.general.beans;

import com.google.common.testing.SerializableTester;
import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;


/**
 * Unit test
 */
public class LombokBeanTest {

    @Test
    public void testClassIsGoodBean() {
        assertThat(LombokBean.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals()
                // commented out due to a possible bug hasValidBeanToString()
        ));
    }

    @Test
    public void testClassIsSerializable() {
        SerializableTester.reserializeAndAssert(new LombokBean());
    }


}