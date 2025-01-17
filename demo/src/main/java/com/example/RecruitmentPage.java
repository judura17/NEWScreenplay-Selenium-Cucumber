package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage{

    // Elementos de la pagina de recruitment
    private By menuRecruitment = By.xpath(("//span[text()='Recruitment']"));
    private By addButton = By.xpath(("//button[contains(.,'Add')]"));
    private By firstNameField = By.xpath(("//input[@name='firstName']"));
    private By middleNameField = By.xpath(("//input[@name='middleName']"));
    private By lastNameField = By.xpath(("//input[@name='lastName']"));
    private By vacancySelect = By.xpath(("//*[@class='oxd-select-text-input']"));
    private By vacancyPA = By.xpath(("//*[text()='Payroll Administrator']"));
    private By emailField = By.xpath(("//label[contains(text(), 'Email')]//following::input"));
    private By phoneField = By.xpath(("//label[contains(text(), 'Contact Number')]//following::input"));
    private By fileUpload = By.xpath(("//input[@type='file']"));
    private By calendarChoose = By.xpath(("//input[@placeholder='yyyy-dd-mm']"));
    private By todayChoose = By.cssSelector(".\\--today");
    private By sendCandidate = By.xpath(("//button[@type='submit']"));
    private By shortListButton = By.xpath(("//button[contains(.,'Shortlist')]"));
    private By saveButton = By.xpath(("//button[contains(.,'Save')]"));
    private By scheduleIntreviewButton = By.xpath(("//button[contains(.,'Schedule Interview')]"));
    private By intreviewTitleField = By.xpath(("//label[contains(.,'Interview Title')]//following::input"));
    private By intreviewerField = By.xpath(("//label[contains(.,'Interviewer')]//following::input"));
    private By dropdownLocator = By.xpath(("//label[contains(.,'Date')]//preceding::input"));
    private By dateChoose = By.xpath(("//input[@placeholder='yyyy-dd-mm']"));
    private By timeChoose = By.xpath(("//input[@placeholder='hh:mm']"));
    private By markIntreviewPassedButton = By.xpath(("//button[contains(.,'Passed')]"));
    private By offerJobButton = By.xpath(("//button[contains(.,'Offer Job')]"));
    private By hireButton = By.xpath(("//button[contains(.,'Hire')]"));
    private By getStatusMessage = By.xpath(("//p[contains(.,'Status: Hired')]"));
    private By rowSearch = By.xpath(("//div[@role='row']"));


    // Constructor que hereda de la clase BasePage
    public RecruitmentPage(WebDriver driver){
        super(driver);
    }

    // Metodos de interaccion de la pagina recruitment

    public void clickMenuRecruitment() {
        waitForElement(menuRecruitment, Duration.ofSeconds(30));
        click(menuRecruitment);
    }

    public void clickButtonAdd() {
        waitForElement(addButton, Duration.ofSeconds(30));
        click(addButton);
    }

    public void fieldFirstName(String firstName) {
        waitForElement(firstNameField, Duration.ofSeconds(30));
        type(firstNameField, firstName);
    }

    public void fieldMiddleName(String middleName) {
        type(middleNameField, middleName);
    }

    public void fieldLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public void selectVacancy() {
        click(vacancySelect);
        click(vacancyPA);

    }

    public void fieldEmail(String email) {
        type(emailField, email);
    }

    public void fieldContactNumber(String phoneNumber) {
        type(phoneField, phoneNumber);
    }

    public void uploadFile(String pathFile) {
        setImplicitWait(5);
        type(fileUpload, pathFile);
    }

    public void chooseCalendar() {
        click(calendarChoose);
    }

    public void chooseToday() {
        click(todayChoose);
    }

    public void candidateSend() {
        click(sendCandidate);
    }

    public void buttonShortList() {
        waitForElement(shortListButton, Duration.ofSeconds(30));
        click(shortListButton);
    }

    public void buttonSave() {
        waitForElement(saveButton, Duration.ofSeconds(30));
        click(saveButton);
    }

    public void buttonScheduleIntreview() {
        waitForElement(scheduleIntreviewButton, Duration.ofSeconds(30));
        click(scheduleIntreviewButton);
    }

    public void fieldIntreviewTitle(String intreviewTitle) {
        waitForElement(intreviewTitleField, Duration.ofSeconds(30));
        type(intreviewTitleField, intreviewTitle);
    }

    public void fieldIntreviewer(String intreviewer) {
        waitForElement(intreviewerField, Duration.ofSeconds(30));
        type(intreviewerField, intreviewer);
        setImplicitWait(5);
    }

    public void chooseIntreviewer() {
        setImplicitWait(5);
        pressDownAndEnter(dropdownLocator);
    }

    public void chooseDate(String date) {
        click(dateChoose);
        type(dateChoose, date);
    }

    public void chooseTime(String time) {
        type(timeChoose, time);
    }

    public void buttonPassed() {
        waitForElement(markIntreviewPassedButton, Duration.ofSeconds(30));
        click(markIntreviewPassedButton);
    }

    public void buttonOfferJob() {
        waitForElement(offerJobButton, Duration.ofSeconds(30));
        click(offerJobButton);
    }

    public void buttonHire() {
        waitForElement(hireButton, Duration.ofSeconds(30));
        click(hireButton);
    }

    public String messageStatusget(String statusGetMessage) {
        waitForElement(getStatusMessage, Duration.ofSeconds(30));
        return getText(getStatusMessage);

    }

    public void checkRecruitmentFormStatus() {
        waitForElement(rowSearch, Duration.ofSeconds(30));
        System.out.println(rowSearch);
    }


}
