package pom.choucair;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class prueba extends app{
	By LinkLogo = By.xpath("//*[@id=\"masthead\"]/div/div/div/div[1]/a");
	By BuscadorHeader = By.className("d-none");
	By Buscador = By.xpath("//*[@id=\"is-search-input-0\"]"); 
	By Lupa = By.xpath("//*[@id=\"menu-menu-espanol\"]/li[9]/form/button"); 
	By LinkEmpleos = By.linkText("Empleos");
	By PageEmpleos = By.xpath("//img[@srcset=\"https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png 4808w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-300x75.png 300w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-768x192.png 768w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-1024x256.png 1024w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-640x160.png 640w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-830x207.png 830w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-230x57.png 230w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-350x87.png 350w, https://www.choucairtesting.com/wp-content/uploads/2019/07/banner-480x120.png 480w\"]");
	By Busqueda = By.xpath("//*[@id=\"post-344\"]/header/h2/a");
	public prueba(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean FooterLink() {
		List<WebElement> links = findElements(By.tagName("a"));
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
	
	
	public void  EnlaceLogo() {
		click(LinkLogo);
	}
	
	public void BuscadorLupa() {
		click(BuscadorHeader);
		sendKeys("empleos testing",Buscador);
		findElement(Lupa).submit();
	}
	
	public void BuscadorEnter() {
		click(BuscadorHeader);
		sendKeys("empleos testing",Buscador);
		findElement(Buscador).submit();
	}

	
	public String Busqueda() {
		List<WebElement> Busqueda =findElements(Buscador);
		return getTex(Busqueda.get(5));
	}
}
