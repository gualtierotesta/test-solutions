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
 * ArgumentMatchers use cases example
 *
 * @author Gualtiero Testa <http://www.gualtierotesta.it>
 */
public class Matchers {

    private Dependency dependency;

    public class Dependency {

        public String toString(int calc) {
            return "something";
        }
    }

    public Matchers(Dependency dependency) {
        this.dependency = dependency;
    }

    public String info(int num) {
        int calc = num * 2;
        return dependency.toString(calc).toUpperCase();
    }
}
