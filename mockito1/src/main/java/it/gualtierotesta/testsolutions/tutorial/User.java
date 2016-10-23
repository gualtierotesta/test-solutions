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

/**
 * POJO for logged users data
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public class User {

    private final String name;
    private final String idUser;
    private final Date tsLogin;

    public User(String pName, String pIdUser) {
        this.name = pName;
        this.idUser = pIdUser;
        this.tsLogin = new Date();
    }

    public String getName() {
        return name;
    }

    public String getIdUser() {
        return idUser;
    }

    public Date getTsLogin() {
        return tsLogin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.idUser != null ? this.idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.idUser == null) ? (other.idUser != null) : !this.idUser.equals(other.idUser)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", idUser=" + idUser + ", tsLogin=" + tsLogin + '}';
    }

}
