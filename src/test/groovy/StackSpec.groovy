import spock.lang.Specification

class StackSpec extends Specification {
    def objectUnderTest = new Stack()

    def 'Default size.'() {
        expect: 'initial size of stack is 0'
            objectUnderTest.size() == 0
    }

    def 'Push something on the stack.'() {
        when: 'something is pushed on the stack'
            objectUnderTest.push('something')
        then: 'the stack size increases by 1'
            objectUnderTest.size() == old(objectUnderTest.size()) + 1
        and: 'peek can be used to see what is on the stack'
            objectUnderTest.peek() == 'something'
    }

    def 'Pop with an empty stack.'() {
        when: 'try to pop something from an empty stack'
            objectUnderTest.pop()
        then: 'an exception is thrown'
            def thrownException = thrown(EmptyStackException)
            assert thrownException.message == null
    }

}
