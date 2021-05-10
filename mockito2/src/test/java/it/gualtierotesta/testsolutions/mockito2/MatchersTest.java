package it.gualtierotesta.testsolutions.mockito2;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit Test
 */
@RunWith(MockitoJUnitRunner.class)
public class MatchersTest {

    @InjectMocks
    private Matchers sut;

    @Mock
    private Matchers.Dependency dependency;

    @Test
    public void testAnyInt() throws Exception {
        // given
        Mockito.when(dependency.toString(ArgumentMatchers.anyInt())).thenReturn("any-int");
        //BDDMockito.given(dependency.toString(ArgumentMatchers.anyInt())).willReturn("any-int");
        // when
        final String res = sut.info(5);
        // then
        Assertions.assertThat(res).isEqualTo("ANY-INT");
        Mockito.verify(dependency, Mockito.times(1)).toString(ArgumentMatchers.anyInt());
        //BDDMockito.verify(dependency, Mockito.times(1)).toString(ArgumentMatchers.anyInt());
    }

    @Test
    public void testEq() throws Exception {
        // given
        int num = 5;
        BDDMockito.given(dependency.toString(ArgumentMatchers.eq(num * 2))).willReturn("ten");
        // when
        final String res = sut.info(num);
        // then
        Assertions.assertThat(res).isEqualTo("TEN");
    }

}
