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
 * Case 1
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class Case1 {

    private final Case1Dao dao;

    public Case1(final Case1Dao pDao) {
        this.dao = pDao;
    }

    public String loggerUsersMessage() {
        String res;
        int num = 0; // Default
        try {
            num = dao.countLoggedUsers();
        } catch (Exception ex) {
            // Logging
        }
        switch (num) {
            case 0:
                res = "Nessun utente connesso";
                break;
            case 1:
                res = "1 utente connesso";
                break;
            default:
                res = num + " utenti connessi";
        }
        return res;
    }

}
