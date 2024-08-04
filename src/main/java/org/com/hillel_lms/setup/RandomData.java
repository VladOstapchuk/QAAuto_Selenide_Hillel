package org.com.hillel_lms.setup;

import org.apache.commons.lang3.RandomStringUtils;


// Об'єкт який формує, приймає і віддає потрібні дані для реєстрації нового користувача
// Має тільки один сетер - для кода підтвердження і гетери для всіх полів
//конструктор генерить дані при созданії об'єкта
public class RandomData {

    private String randomName;
    private String randomSecondName;
    private String randomPhone;
    private String randomPassword;
    private String randomEmail;
    private String confirmationCode;


    //конструктор создает объект и сразу генерует данные
    public RandomData() {
        this.randomName = randomName();
        this.randomSecondName = randomName();
        this.randomPhone = randomPhone();
        this.randomPassword = randomPassword();
        this.randomEmail = randomEmail();
    }

    public String getRandomName() {
        return randomName;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public String getRandomSecondName() {
        return randomSecondName;
    }

    public String getRandomPhone() {
        return randomPhone;
    }

    public String getRandomPassword() {
        return randomPassword;
    }

    public String getRandomEmail() {
        return randomEmail;
    }

    private String randomName() {
        String firstLetter = RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String generatedString = RandomStringUtils.randomAlphabetic(6);
        String name = firstLetter + generatedString;
        return name;
    }

    private String randomPhone() {
        String phoneNumber = "63" + RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }

    private String randomPassword() {
        String Number = RandomStringUtils.randomNumeric(2);
        String bigLetter = RandomStringUtils.randomAlphabetic(1).toUpperCase();
        String letters = RandomStringUtils.randomAlphabetic(8);
        String password = bigLetter + Number + letters;
        return password;
    }

    private String randomEmail() {
        String letters = RandomStringUtils.randomAlphabetic(4);
        String email = "autotest" + letters + "@mailinator.com";
        return email;
    }


}
