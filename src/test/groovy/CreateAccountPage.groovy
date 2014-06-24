import geb.*

class CreateAccountPage extends Page {

    static url = "/account/registreren"
    static at = { waitFor { $("form#jobseeker-nieuw-account-form") } }
    static content = {
        newAccountForm { $("form#jobseeker-nieuw-account-form") }
        nextButton(to: CreateAccountContactDetailsPage) { $("button#submit_forward") }
    }
}

class CreateAccountContactDetailsPage extends Page {

    static url = "/account/persoonlijke-gegevens"
    static at = { waitFor { $("form#account-personal-data-form") } }
    static content = {
        contactDetailsForm { $("form#account-personal-data-form") }
        nextButton(to: CreateAccountCareerTargetPage) { $("button#submit_forward") }
    }
}

class CreateAccountCareerTargetPage extends Page {

    static url = "/account/carrieredoel"
    static at = { waitFor { $("form#account-career-target-form") } }
    static content = {
        careerTargetForm { $("form#account-career-target-form") }
        jobCategoriesToggles { $("input[name=preferred_job_category[]]") }
        jobCategories { name -> jobCategoriesToggles.each { toggle -> if (toggle.text() == name) return toggle } }
        nextButton(to: YourAccountPage) { $("button#submit_forward") }
    }
}

class YourAccountPage extends Page {

    static url = "/jouw-pagina"
    static at = { waitFor { $("div.message-header h6", text: ~/.*account is aangemaakt.*/ )}}
}