package pom.choucair;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



public class Empleos_test {
	private WebDriver driver;
	prueba Prueba;
	@Before
	public void setUp() throws Exception {
		Prueba = new prueba(driver);
		driver = Prueba.DriverChrome();
		Prueba.visit("https://www.choucairtesting.com/empleos-testing/");
	}
	//cerrar navegador
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	//valida la pagina de empleo
	@Test
	public void visitar() {
		Prueba.visit("https://www.choucairtesting.com/empleos-testing/");
	}
    //escribe y busca con un click en el icono de la lupa
	@Test
	public void test() throws InterruptedException {
		Prueba.BuscadorLupa();
		assertEquals("Resultados de búsqueda para “empleos testing” – Choucair Testing", driver.getTitle());
	}
	//escribe en el buscador y busca con un enter
	@Test
	public void test2() throws InterruptedException {
		Prueba.BuscadorEnter();
		assertEquals("Resultados de búsqueda para “empleos testing” – Choucair Testing", driver.getTitle());
	}
	// click en el logo de choucair
	@Test
	public void test3() throws InterruptedException {
		Prueba.EnlaceLogo();
		assertEquals("Choucair Testing", driver.getTitle());
	}
	//check links in the page
	@Test
	public void test4() throws InterruptedException {
		Prueba.FooterLink();
	}

}
