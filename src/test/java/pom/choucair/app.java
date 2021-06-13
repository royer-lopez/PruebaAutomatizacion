package pom.choucair;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class app {
	private WebDriver driver;
	
	public app(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver DriverChrome() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/cromeDriver/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public void sendKeys(String inputT, By locator) {
		driver.findElement(locator).sendKeys(inputT);
	}
	public String getTex(WebElement element) {
		return element.getText();
	}
	
	public String getTex(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean FooterLink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String url = "";
		List<String> brokenLinks = new ArrayList<String>();
		List<String> okLinks = new ArrayList<String>();
		
		HttpURLConnection httpConection = null;
		Iterator<WebElement> it = links.iterator();
		int response = 200;
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println(url + "url no encontrada");
				continue;
			}
			try {
				httpConection = (HttpURLConnection)(new URL(url).openConnection());
				httpConection.setRequestMethod("HEAD");
				httpConection.connect();
				response = httpConection.getResponseCode();
				if(response>=400) {
					System.out.println("ERROR en el link "+url);
					brokenLinks.add(url);
				}else {
					System.out.println("LiNK valido "+url);
					okLinks.add(url);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("El total de  link son"+ okLinks.size());
		System.out.println("El total de  link son"+ brokenLinks.size());
		if (brokenLinks.size()>0) {
			System.out.println("**********Lista de lin malos************");
			for (int i = 0; i<brokenLinks.size(); i++) {
				System.out.println(brokenLinks.get(i));
			}
			return false;
		}else {
			return true;
		}
		
	}
	
	public void visit(String url) {
		driver.get(url);
	}
}


