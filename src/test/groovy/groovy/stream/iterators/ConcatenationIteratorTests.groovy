/*
 * Copyright 2013 the original author or authors.
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

package groovy.stream.iterators

class ConcatenationIteratorTests extends spock.lang.Specification {

    def list  = [ 1, 2 ]
    def list2 = [ null, 4 ]
    ConcatenationIterator iter

    def setup() {
        iter = new ConcatenationIterator( list.iterator(), list2.iterator() )
    }

    def "collect should return values"() {
        when:
            def result = iter.collect()
        then:
            result == [ 1, 2, null, 4 ]
    }

    def "call to next with no hasNext should work"() {
        expect:
            iter.next() == 1
            iter.hasNext() == true
    }

    def "remove should throw UnsupportedOperationException"() {
        when:
            iter.remove()
        then:
            UnsupportedOperationException ex = thrown()
    }

    def "Test NoSuchElementException"() {
        when:
            def result = iter.collect()
            iter.next()

        then:
            NoSuchElementException ex = thrown()
    }
}