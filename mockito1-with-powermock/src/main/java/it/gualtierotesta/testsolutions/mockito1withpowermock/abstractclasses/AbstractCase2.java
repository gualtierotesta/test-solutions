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

/**
 * Case 2: method which call internal private method which is a test impediment
 *
 * @author Gualtiero Testa www.gualtierotesta.it
 */
public abstract class AbstractCase2 {

    public abstract int myAbstractMethod();

    public String methodToBeTested() {
        return prefix() + "2";
    }

    // Test impediment
    private String prefix() {
        return "CASE-";
    }

    public AbstractCase2() {
        System.out.println("Constructor");
    }

}
