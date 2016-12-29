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

/**
 * Stubbing vs Verification example
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
public class StubbingVsVerification {

    private final Dependency dependency;

    public class Dependency {

        public String doSomething(int calc) {
            return "something";
        }
    }

    public StubbingVsVerification(Dependency dependency) {
        this.dependency = dependency;
    }

    public String delegation(int num) {

        // call dependency
        final String out = dependency.doSomething(num);

        // return value
        return out;
    }

    public String callAndProcess(int num) {

        // call dependency
        String str = dependency.doSomething(num);

        // process results
        String out = str.toUpperCase();

        // return value
        return out;
    }

    public String processAndCall(int num) {

        // process data
        int calc = num * 2;

        // call dependency
        String out = dependency.doSomething(calc);

        // return value
        return out;
    }

    public String all(int num) {

        // process data
        int calc = num * 2;

        // call dependency
        String str = dependency.doSomething(calc);

        // process results
        String out = str.toUpperCase();

        // return value
        return out;
    }

}
