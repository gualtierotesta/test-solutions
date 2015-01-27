/*
 * Copyright 2015 Gualtiero Testa <www.gualtierotesta.it>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.gualtierotesta.mockitousage.abstractclasses;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

/**
 * Case 3 unit test
 *
 * @author Gualtiero Testa <www.gualtierotesta.it>
 */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(AbstractCase3.class)
public class AbstractCase3Test {

    @Test
    public void testFalseTypeWithCountLessThen10() {
        // given
        AbstractCase3 sut = Mockito.mock(AbstractCase3.class);
        Mockito.doCallRealMethod().when(sut).methodToBeTested();
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("Type is false", result);
    }

    @Test
    public void testTrueTypeWithCountLessThen10() {
        // given
        AbstractCase3 sut = Mockito.mock(AbstractCase3.class);
        Mockito.doCallRealMethod().when(sut).methodToBeTested();
        sut.type = true;
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("Type is true", result);
    }

    @Test
    public void testCountGreaterThen10WithSetter() {
        // given
        AbstractCase3 sut = Mockito.mock(AbstractCase3.class);
        Mockito.doCallRealMethod().when(sut).methodToBeTested();
        Mockito.doCallRealMethod().when(sut).setCount(Mockito.anyInt());
        sut.setCount(15);
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("Too many times", result);
    }

    @Test
    public void testWithPowerMock() {
        // given
        AbstractCase3 sut = PowerMockito.mock(AbstractCase3.class);
        PowerMockito.doCallRealMethod().when(sut).methodToBeTested();
        Whitebox.setInternalState(sut, "count", 15);
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("Too many times", result);
    }

}
