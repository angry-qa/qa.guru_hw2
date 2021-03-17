package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void basicScenario() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("QA");
        $("#userEmail").setValue("test@test.ru");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue("Saint-Petersburg, Singer House");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".table").shouldHave(text("Test"),
                text("QA"),
                text("test@test.ru"),
                text("Male"),
                text("0123456789"),
                text("1 January,1980"),
                text("English, Hindi"),
                text("Sports"),
                text("test.png"),
                text("Saint-Petersburg, Singer House"),
                text("NCR Delhi"));
    }
}

