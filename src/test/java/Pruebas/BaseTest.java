package Pruebas; 
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest; 
import PageObjects.PaginaBusqueda;
import PageObjects.PaginaGrilla;
import PageObjects.PaginaListado;

public class BaseTest {


    protected WebDriver driver; 
    protected PaginaBusqueda paginaBusqueda;
    protected PaginaListado paginaListado;
    protected PaginaGrilla paginaGrilla;
    
    private void iniciarPagina(WebDriver driver) {
    	paginaBusqueda = new PaginaBusqueda(driver);
    	paginaListado=new PaginaListado(driver);  
    	paginaGrilla=new PaginaGrilla(driver);
    }
	

    @BeforeTest
    public void abrirNavegador() {
        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.navigate().to("http://fravega.com"); 
        iniciarPagina(driver);

    }

    @AfterTest
    public void cerrarDriver() {
        driver.quit();

    }
    
}
