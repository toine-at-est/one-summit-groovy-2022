import spock.lang.Specification

import java.util.concurrent.TimeUnit

class TimeUnitSpec extends Specification {

    def 'String Format'() {
        expect: '10 Minutes is 600 Seconds'
            TimeUnit.MINUTES.toSeconds(10) == 600
    }
}
