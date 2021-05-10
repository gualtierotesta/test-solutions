/*
 * Copyright 2016 Gualtiero Testa.
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
package it.gualtierotesta.testsolutions.mockito2;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

/**
 * Unit Test: how to mock an interface
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
public class AnInterfaceTest {

    // Case 1: interface method not stubbed. Returned value is the default for the type. 0 in our example
    @Test
    public void case1() {
        // given
        AnInterface mock = Mockito.mock(AnInterface.class);
        // when
        Integer res = mock.countElements(ArgumentMatchers.anyList());
        // then
        Assertions.assertThat(res).isZero();
    }

    // Case 2: interface method stubbed
    @Test
    public void case2() {
        // given
        AnInterface mock = Mockito.mock(AnInterface.class);
        BDDMockito.given(mock.countElements(ArgumentMatchers.anyList())).willReturn(3);
        // when
        Integer res = mock.countElements(ArgumentMatchers.anyList());
        // then
        Assertions.assertThat(res).isEqualTo(3);
    }

    // Case 3: interface method stubbed with specific argument
    @Test
    public void case3() {
        // given
        List<String> aList = Arrays.asList("one", "two");
        AnInterface mock = Mockito.mock(AnInterface.class);
        BDDMockito.given(mock.countElements(aList)).willReturn(aList.size());
        // when
        Integer res = mock.countElements(aList);
        // then
        Assertions.assertThat(res).isEqualTo(aList.size());
    }

}
