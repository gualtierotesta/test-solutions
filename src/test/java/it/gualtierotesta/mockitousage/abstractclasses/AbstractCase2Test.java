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
package it.gualtierotesta.mockitousage.abstractclasses;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Case 2 unit test
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AbstractCase2.class)
public class AbstractCase2Test {

    @Test
    public void testWithPowerMock() throws Exception {
        // given
        AbstractCase2 sut = PowerMockito.mock(AbstractCase2.class);
        PowerMockito.doCallRealMethod().when(sut).methodToBeTested();
        PowerMockito.doReturn("TESTCASE-").when(sut, "prefix");
        // when
        String result = sut.methodToBeTested();
        // then
        Assert.assertEquals("TESTCASE-2", result);
    }
}
