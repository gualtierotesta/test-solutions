package it.gualtierotesta.testsolutions.general.beans;

import com.google.common.testing.EqualsTester;
import com.google.common.testing.SerializableTester;
import org.junit.Test;
import org.mutabilitydetector.unittesting.MutabilityAssert;


/**
 * Unit test
 */
public class LombokImmutableBeanTest {

    @Test
    public void testClassIsImmutable() {
        MutabilityAssert.assertImmutable(LombokImmutableBean.class);
    }

    @Test
    public void testClassEqualsHashCode() {
        new EqualsTester()
            .addEqualityGroup(LombokImmutableBean.of("hi", 5), LombokImmutableBean.of("hi", 5))
            .addEqualityGroup(LombokImmutableBean.of(null, 0), LombokImmutableBean.of(null, 0))
            .testEquals();
    }

    @Test
    public void testClassIsSerializable() {
        SerializableTester.reserializeAndAssert(LombokImmutableBean.of("hi", 5));
    }


}
