package seleniumRun;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {
	private WebDriver driver;
	@Given("^dado que el usuario esta  en la pagina de empleo$")
	public void confi() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/cromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}
	@Given("^desea ir a la pagina principal de chhoucair cuando haga clic en el logo$")
	public void ProbarEnlaceLogo() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div/div[1]/a"));
		logo.click();
		assertEquals("Choucair Testing", driver.getTitle());
	}

	@Then("^se debe direccionar ala pantalla principal donde finalmente  termina$")
	public void terminar() {
		driver.quit();
	}
}





