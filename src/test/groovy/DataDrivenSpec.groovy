import spock.lang.Specification

class DataDrivenSpec extends  Specification {

    def 'Maximum of #a and #b = #c.'() {
        expect: Math.max(a,b) == c

        where: 'the following values are used'
            a  | b  || c
            5  | 10 || 10
            0  | 0  || 0
            -1 | 0  || 0
    }

    def 'my test using an assert closure'() {
        given:
            def i = 23
        when:
            i++
        then:
            myAssert(i)
    }


    def myAssert(int i) {
        assert i > 0
    }
}