package Pruebas;

import org.testng.Assert;
import org.testng.annotations.Test; 
import helpers.Helpers;

public class CompraTest extends BaseTest {

	private int cantidad = 0;
 

	@Test
	public void busqueda() {  
		
		paginaBusqueda.realizarBusqueda("Heladera");  
		paginaListado.realizarBusquedaPatrick(); 
		Helpers.esperar(3);
		paginaGrilla.validarMarca("Patrick"); 
		Assert.assertEquals(paginaGrilla.getCantidad(),paginaListado.getCantidadLink(),"El total de heladeras Patrick debe ser 22");
		Assert.assertTrue(paginaGrilla.getBandera(),"En la descripcion incluir la palabra 'Patrick'");
		Assert.assertTrue(paginaListado.validarBreadcrumb("Heladeras"),"Se debe incluir la palabra Heladeras");

	}

}
