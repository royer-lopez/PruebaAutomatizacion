package choucair;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* -------------------Clase de prueba-------------- */

public class Enlace {
	private WebDriver driver;
	
	@Before
	public void confi() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/cromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}
	
	@Test
	public void Modal() {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500)");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/section[3]/div/div/div[2]/div/div/div/div/div/a"));
		btn.click();
		
	}
	@Test
	public void ProbarBtnLupa() {
		
		WebElement boton = driver.findElement(By.className("d-none"));
		boton.click();
		WebElement buscador = driver.findElement(By.id("is-search-input-0"));
		buscador.sendKeys("empleos testing");
		WebElement b = driver.findElement(By.xpath("//*[@id=\"menu-menu-espanol\"]/li[9]/form/button"));
		
		b.submit();
		
	}
	

	
	@Test
	public void encontrarBuscador() {
		WebElement boton = driver.findElement(By.className("d-none"));
		boton.click();
	}
	public void llenarBuscador() {
		WebElement buscador = driver.findElement(By.id("is-search-input-0"));
		buscador.sendKeys("empleos testing");
		buscador.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void infoBuscador() {
		assertEquals("Resultados de búsqueda para “empleos testing” – Choucair Testing", driver.getTitle());
	}
	
	

	
	@Test
	public void ProbarEnlaceLogo() {
		WebElement logo = driver.findElement(By.className("site-logo"));
		logo.click();
		assertEquals("Choucair Testing", driver.getTitle());
		
	}
	

	
	
	@After
	public void terminar() {
		driver.quit();
	}

}
