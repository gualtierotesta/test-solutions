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
package it.gualtierotesta.testsolutions.tutorial;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for case 2
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
@RunWith(MockitoJUnitRunner.class)
public class Case2Test {

    @InjectMocks
    private Case2 sut;
    @Mock
    private Case2Dao dao;

    @Test
    public void testNewUserWithMatcher() {
        // given
        String name = RandomStringUtils.randomAlphabetic(8);
        String idUser = RandomStringUtils.randomAlphabetic(16);
        // when
        sut.newUser(name, idUser);
        // then
        verify(dao).saveNewLoggedUser(any(User.class));
    }

    @Test
    public void testNewUserCheckTimeStampLogin() {
        // given
        ArgumentCaptor<User> capture = ArgumentCaptor.forClass(User.class);
        // when
        sut.newUser("", "");
        // then
        verify(dao).saveNewLoggedUser(capture.capture());
        User user = capture.getValue();
        assertThat(user.getTsLogin())
                .isCloseTo(new Date(), TimeUnit.SECONDS.toMillis(2));
    }

}
