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

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for Case 1
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class Case1Test {

    private Case1 sut;
    private Case1Dao dao;

    @Before
    public void setUp() {
        dao = Mockito.mock(Case1Dao.class);
        sut = new Case1(dao);
    }

    @Test
    public void testNoUsers() {
        // given

        // when
        String res = sut.loggerUsersMessage();
        // then
        assertThat(res).isEqualTo("Nessun utente connesso");
    }

    @Test
    public void testOneUser() throws Exception {
        // given
        Mockito.when(dao.countLoggedUsers()).thenReturn(1);
        //BDDMockito.given(dao.countLoggedUsers()).willReturn(1);
        // when
        String res = sut.loggerUsersMessage();
        // then
        assertThat(res).isEqualTo("1 utente connesso");
    }

    @Test
    public void testNUsers() throws Exception {
        // given
        Random random = new Random();
        int num = random.nextInt();
        Mockito.when(dao.countLoggedUsers()).thenReturn(num);
        // when
        String res = sut.loggerUsersMessage();
        // then
        assertThat(res).endsWith("utenti connessi").startsWith(String.valueOf(num));
    }

    @Test
    public void testRaisedException() throws Exception {
        // given
        Mockito.when(dao.countLoggedUsers()).thenThrow(Exception.class);
        // when
        String res = sut.loggerUsersMessage();
        // then
        assertThat(res).isEqualTo("Nessun utente connesso");
    }

}
