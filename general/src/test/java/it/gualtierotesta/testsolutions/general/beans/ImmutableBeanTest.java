package it.gualtierotesta.testsolutions.general.beans;

import com.google.common.testing.EqualsTester;
import com.google.common.testing.SerializableTester;
import org.junit.Test;

import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

/**
 * Unit test
 */
public class ImmutableBeanTest {

    @Test
    public void testClassIsImmutable() {
        assertImmutable(ImmutableBean.class);
    }

    @Test
    public void testClassEqualsHashCode() {
        new EqualsTester()
            .addEqualityGroup(new ImmutableBean("hi", 5), new ImmutableBean("hi", 5))
            .addEqualityGroup(new ImmutableBean(null, 0), new ImmutableBean(null, 0))
            .testEquals();
    }

    @Test
    public void testClassIsSerializable() {
        SerializableTester.reserializeAndAssert(new ImmutableBean("hi", 5));
    }


}
