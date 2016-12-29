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
package it.gualtierotesta.testsolutions.mockito1withpowermock.abstractclasses;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Case 4 unit test
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class AbstractCase4Test {

    private class ConcreteCase4 extends AbstractCase4 {

        @Override
        public int myAbstractMethod() {
            return 4;  //Dummy implementation
        }

    }

    @Test
    public void testUsingConcreteClass() {
        // given
        AbstractCase4Test.ConcreteCase4 sut = new AbstractCase4Test.ConcreteCase4();
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("CASE-4", result);
    }

    @Test
    public void testUsingMockitoMock() {
        // given
        AbstractCase4 sut = Mockito.mock(AbstractCase4.class);
        Mockito.doCallRealMethod().when(sut).methodToBeTested();
        Mockito.doReturn(4).when(sut).myAbstractMethod();
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("CASE-4", result);
    }

//    // Mockito 1.10.12+ required
//    @Test
//    public void testUsingMockitoSpy() {
//        // given
//        AbstractCase4 sut = Mockito.spy(AbstractCase4.class);
//        Mockito.doReturn(4).when(sut).myAbstractMethod();
//        // when
//        String result = sut.methodToBeTested();
//        // then
//        Assert.assertEquals("CASE-4", result);
//    }
}
