package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Helpers;

public class PaginaBusqueda {

	@FindBy(xpath = "//*[@class='sc-gkdBiK jsJbXm']")
	private WebElement popups;

	@FindBy(xpath = "//input[@placeholder='Buscar productos']")
	private WebElement inputBuscar;

	@FindBy(xpath = "//form[@class='sc-gGmKaI cKIFnS']/fieldset[@class='sc-iNqMzA hvbeRr']/div[@class='sc-laRQdt eZKOj']/button[1]")
	private WebElement botonBuscar;

	
 
	
	
	public PaginaBusqueda(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void cerrarPopups() {
		this.popups.click();
	}

	public void realizarBusqueda(String texto) {
		Helpers.esperar(3);
		cerrarPopups();
		this.inputBuscar.sendKeys(texto);
		this.botonBuscar.click();
	} 
	

}
