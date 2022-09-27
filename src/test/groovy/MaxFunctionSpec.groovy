import spock.lang.Specification

class MaxFunctionSpec extends Specification {


    def 'Maximum calculation with integers.'() {
        when: ' we calculate the maximum number of 1 and 2'
            def result = Math.max(1,2)
        then: 'it returns 2'
            assert result == 2
    }


    def 'empty'() {
        expect:
            !(aString==null || aString.isBlank())  == false
        where:
            aString << [null, "", " ", "         "]
    }



}
