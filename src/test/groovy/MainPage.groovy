import geb.*

class MainPage extends Page {

    static url = "/"
    static at = { title.contains("NationaleVacaturebank.nl") }
    static content = {
        searchField { $("input[name=query]") }
        locationField { $("input[name=location]") }
        searchButton(to: SearchResultsPage) { $("button[name=search-submit]") }
        createAccount(to: CreateAccountPage) { $("a#account-nieuw-register") }
    }

    void search(String searchTerm) {
        searchField.value searchTerm
        searchButton.click()
    }

    void search(String searchTerm, String location) {
        searchField.value searchTerm
        locationField.value location
        searchButton.click()
    }
}