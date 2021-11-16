package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Helpers;

public class PaginaListado {
 
 
	@FindBy(xpath ="//a[@href='/l/heladeras-freezers-y-cavas/heladeras/?keyword=Heladera']")
	private WebElement linkHeladera;

	@FindBy(xpath ="//div[@id='brand-filter-checkbox-patrick-Patrick-22']")
	private WebElement checkboxPatrick;

	
	@FindBy(xpath ="//span[contains(text(),'Patrick (22)')]")
	private WebElement textCheckbox;
	
	

	@FindBy(xpath ="//ol[@itemtype='https://schema.org/BreadcrumbList']")
	private List<WebElement> listBreadcrumb;
	

	
	public PaginaListado(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void buscarLink() {
		this.linkHeladera.click();
	}

	
	
	public void buscarMarca() {
		this.checkboxPatrick.click();
	}
	
	public void realizarBusquedaPatrick() {
		Helpers.esperar(3);
		buscarLink();
		Helpers.esperar(3);
		buscarMarca();
	}
	 
	public int getCantidadLink() {
		String link=this.textCheckbox.getText(); 
		return  Integer.parseInt(link.substring(9,11));
	}

	
	public boolean validarBreadcrumb(String texto) {
		for(WebElement elemento:listBreadcrumb)
		 {
			 if(elemento.getText().contains(texto))
				 return true;			 
		 }
		return false;
	}
	
	
	
	
}
