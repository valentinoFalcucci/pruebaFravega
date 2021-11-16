package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert; 
import helpers.Helpers;

public class PaginaGrilla {

	@FindBy(xpath = "//*[@class='ProductCard__Card-shopping-ui__sc-5j43vf-2 dHykQs']")
	private List<WebElement> listadoHeladera;

	@FindBy(xpath = "//span[contains(text(),'Siguiente >')]")
	private WebElement botonSiguiente;

	int cantidad = 0;	
	boolean bandera=true;

	
	
	public int getCantidad() {
		return cantidad;
	}

 

	public boolean getBandera() {
		return bandera;
	}
	
	
	
	
	public PaginaGrilla(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void irSiguiente() {
		this.botonSiguiente.click();
	}

	public int getCantidadHeladeras() {
		return listadoHeladera.size();
	}

	public List<WebElement> getListado() {
		return listadoHeladera;
	}

	
	public void validarMarca(String nombre) {

		cantidad += getCantidadHeladeras();
		validarTitulo(nombre); 
		Helpers.esperar(3);
		irSiguiente();
		Helpers.esperar(3);
		cantidad += getCantidadHeladeras();
		validarTitulo(nombre); 
	}
	 
	
	
	public boolean validarTitulo(String texto) { 
		for (WebElement elemento : listadoHeladera) {
			if (!elemento.getText().toLowerCase().contains(texto.toLowerCase()))
		 bandera=false;
			break;
		}
		return bandera;
	}
	 
 

}
