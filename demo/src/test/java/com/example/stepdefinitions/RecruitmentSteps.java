package com.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example.RecruitmentPage;
import com.example.context.SharedContext;

public class RecruitmentSteps {

    private final SharedContext sharedContext;
    private final LoginSteps loginSteps;
    private RecruitmentPage recruitmentPage;

    // Llamado al metodo Hooks
    public RecruitmentSteps(SharedContext sharedContext) {
        this.sharedContext = sharedContext;
        this.loginSteps = new LoginSteps(sharedContext);
    }

    // Dado
    @Given("Este logueado en la aplicacion")
    public void i_am_logged_into_the_application() {
        loginSteps.i_am_on_the_login_page();
        loginSteps.i_login_with_ussername_and_password();
        loginSteps.i_should_be_in_the_dashboard();
        recruitmentPage = new RecruitmentPage(sharedContext.driver);
    }

    // Cuando
    @When("Se ingrese al portal de reclutamiento")
    public void i_be_in_the_dashboard() {

        recruitmentPage.clickMenuRecruitment();

    }

    // Y
    @And("Se postule el candidato")
    public void the_candidate_will_be_postulate() {
        // Proceso de postulacion
        recruitmentPage.clickButtonAdd();
        recruitmentPage.fieldFirstName("Oscar");
        recruitmentPage.fieldMiddleName("Julian");
        recruitmentPage.fieldLastName("Duque Ramos");
        recruitmentPage.selectVacancy();
        recruitmentPage.fieldEmail("ojduque172@gmail.com");
        recruitmentPage.fieldContactNumber("3126983500");
        recruitmentPage.uploadFile(
                "C:\\Users\\JAIRO ALONSO\\Documents\\PROGRAMACION OJDR\\NEWScreenplay-Selenium-Cucumber\\demo\\src\\test\\resources\\TestCargaDocumento.txt");
        recruitmentPage.chooseCalendar();
        recruitmentPage.chooseToday();
        recruitmentPage.candidateSend();
        recruitmentPage.buttonShortList();
        recruitmentPage.buttonSave();
    }

    // Y
    @And("Se agende entrevista al candidato")
    public void the_iterview_was_successfull() throws InterruptedException {
        // Proceso de agendamiento de entrevista
        recruitmentPage.buttonScheduleIntreview();
        recruitmentPage.fieldIntreviewTitle("Test Titulo Entrevista");
        recruitmentPage.fieldIntreviewer("Orange");
        Thread.sleep(5000);
        recruitmentPage.chooseIntreviewer();
        recruitmentPage.chooseDate("2025-04-20");
        recruitmentPage.chooseTime("08:00 AM");
        recruitmentPage.buttonSave();
        recruitmentPage.buttonPassed();
        recruitmentPage.buttonSave();
        recruitmentPage.buttonOfferJob();
        recruitmentPage.buttonSave();
        recruitmentPage.buttonHire();
        recruitmentPage.buttonSave();
        assertEquals(recruitmentPage.messageStatusget(""), "Status: Hired");
    }

    // Luego
    @Then("Se contrata el candidato")
    public void the_candidate_will_be_hired() {
        // Proceso de validacion de postulado contratado
        recruitmentPage.clickMenuRecruitment();
        recruitmentPage.checkRecruitmentFormStatus();

    }

}
