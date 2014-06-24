import geb.*
import spock.lang.*
import geb.spock.*

class CreateAccountSpec extends GebReportingSpec {

    def "An account can be created successfully"() {
        when:
        to CreateAccountPage

        and:
        newAccountForm.email_address = "test@example.com"
        nextButton.click()

        and:
        at CreateAccountContactDetailsPage
        contactDetailsForm.name_first = "Firstname"
        contactDetailsForm.name_last = "Lastname"
        contactDetailsForm.zipcode = "1017AG"
        contactDetailsForm.phone_number = "0612345678"
        nextButton.click()

        and:
        at CreateAccountCareerTargetPage
        careerTargetForm.career_level = "Leidinggevend"
        careerTargetForm.education_level = "WO"
        careerTargetForm.latest_job = "Punniker"
        careerTargetForm.preferred_job_1 = "Witter"
        careerTargetForm.find(id: "preferred_job_category-100001").click()
        careerTargetForm.find(id: "preferred_job_category-100005").click()
        careerTargetForm.find(id: "preferred_industry-500001").click()
        careerTargetForm.find(id: "preferred_industry-500002").click()
        careerTargetForm.find(id: "drivers_licenses-1").click()
        nextButton.click()

        then:
        at YourAccountPage
    }
}
