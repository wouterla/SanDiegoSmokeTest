import geb.*
import spock.lang.*
import geb.spock.*

class SearchFromMainPageSpec extends GebReportingSpec {

    def "An empty search should have results"() {
        when:
        to MainPage

        and:
        search ""

        then:
        at SearchResultsPage

        and:
        hasResults()
    }

    def "Top search result for test contains test in title"() {
        when:
        to MainPage

        and:
        search "test"

        then:
        at SearchResultsPage

        and:
        topResultTitle.toLowerCase().contains("test")
    }

    def "Searching on Amsterdam gets top result in Amsterdam"() {
        when:
        to MainPage

        and:
        search("test", "Amsterdam")

        then:
        at SearchResultsPage

        and:
        topResultLocation.toLowerCase().contains("amsterdam")
    }
}
