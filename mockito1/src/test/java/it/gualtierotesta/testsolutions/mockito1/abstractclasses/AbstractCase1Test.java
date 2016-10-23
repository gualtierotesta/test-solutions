/*
 * Copyright 2015 Gualtiero Testa www.gualtierotesta.it.
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
package it.gualtierotesta.testsolutions.mockito1.abstractclasses;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Case 1 unit test
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class AbstractCase1Test {

    private class ConcreteCase1 extends AbstractCase1 {

        @Override
        public int myAbstractMethod() {
            return 0;  //Dummy implementation
        }

    }

    @Test
    public void testUsingConcreteClass() {
        // given
        ConcreteCase1 sut = new ConcreteCase1();
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("CASE-1", result);
    }

    // Mockito 1.10.12+ required
//    @Test
//    public void testUsingMockitoSpy() {
//        // given
//        AbstractCase1 sut = Mockito.spy(AbstractCase1.class);
//        // when
//        String result = sut.methodToBeTested();
//        // then
//        Assert.assertEquals("CASE-1", result);
//    }
    @Test
    public void testUsingMockitoMock() {
        // given
        AbstractCase1 sut = Mockito.mock(AbstractCase1.class);
        Mockito.doCallRealMethod().when(sut).methodToBeTested();
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("CASE-1", result);
    }

}
