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

/**
 * Case 2
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class Case2 {

    private final Case2Dao dao;

    public Case2(final Case2Dao pDao) {
        this.dao = pDao;
    }

    public void newUser(String pName, String pIdUser) {
        User user = new User(pName, pIdUser);
        dao.saveNewLoggedUser(user);
    }

}
