/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package groovy.stream

class SkipTests extends spock.lang.Specification {
    @spock.lang.Unroll( "Skipping #n elements from #input should yield #result" )
    def "Test simple skip"() {
        setup:
            def stream = Stream.from input skip n

        expect:
            stream.collect() == result

        where:
            input | n  | result
            1..10 | 0  | 1..10
            1..10 | 1  | 2..10
            1..10 | 2  | 3..10
            1..10 | 3  | 4..10
            1..10 | 4  | 5..10
            1..10 | 5  | 6..10
            1..10 | 6  | 7..10
            1..10 | 7  | 8..10
            1..10 | 8  | 9..10
            1..10 | 9  | [ 10 ]
            1..10 | 10 | []
            1..10 | 11 | []
    }
}