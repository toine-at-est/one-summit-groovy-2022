import spock.lang.Specification

class MapRetainSpec extends Specification {

    def 'Map Retain.'() {
        given: 'a map with 2 elements'
            Map<String, Integer> myMap = [A:1, B:2, C:3, D:4]
        when: 'retain A and C'
            myMap.keySet().retainAll(['A','C'])
        then:
            assert myMap.size() == 2
            assert myMap.keySet().contains('A')
            assert myMap.keySet().contains('C')
            myMap.keySet().iterator().next()
    }
}
