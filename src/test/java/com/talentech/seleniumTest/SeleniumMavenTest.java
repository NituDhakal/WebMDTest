package com.talentech.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMavenTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
		driver.get("https://www.webmd.com/");
		driver.manage().window().maximize();
		WebElement signIn = driver.findElement(By.xpath("//*[@id=\"ContentPane1\"]/nav/div[1]/div[3]/ul/li[1]/a"));
		signIn.click();
		WebElement email = driver.findElement(By.xpath("//input[@class='email']"));
		WebElement password = driver
				.findElement(By.xpath("//*[@id=\"signinForm\"]/div/div/div/div/form/fieldset/div[3]/div[1]/input"));
		WebElement submitButton = driver
				.findElement(By.xpath("//*[@id=\"signinForm\"]/div/div/div/div/form/fieldset/div[6]/span[1]/input"));
		email.sendKeys("NitaDk@gmail.com");
		password.sendKeys("12345678");
		submitButton.click();
		WebElement errorMessage = driver
				.findElement(By.xpath("//*[@id=\"signinForm\"]/div/div/div/div/form/fieldset/div[3]/div[2]/span"));
		String error = errorMessage.getText().trim();

		if (error.equals("Your combination of email address and password is incorrect.")) {
			System.out.println("It is Passed!");
		} else {
			System.out.println("It is failed!");
		}
		Thread.sleep(4000);
		driver.close();

	}

}
