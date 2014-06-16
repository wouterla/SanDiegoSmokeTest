import geb.*

class SearchResultsPage extends Page {
    static url = "/vacature/zoeken/"
    static at = { waitFor { getTitle().contains("vacatures gevonden voor") } }
    static content = {
        results(wait: true) { $("li.result-item") }
        result { index -> results[index] }
        resultLink { index -> results[index].find("a.result-item-link") }
        resultTitle { index -> results[index].find("h2.result-item-title").text() }
        resultLocation { index -> results[index].find("div.result-item-city").text() }
        topResultTitle { resultTitle(0) }
        topResultLocation { resultLocation(0) }
    }

    boolean hasResults() {
        return results.size() > 0
    }
}
