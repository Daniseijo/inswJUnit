import junit.framework.TestCase;
import AlmacenProductos.Gestor;
import AlmacenProductos.Producto;


public class BateriaPruebas extends TestCase {
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Gestor.class);
	}

	public void testGestor() {
		fail("Not yet implemented");
	}

	public void testA�adirProducto() throws Exception {
		// Creamos un gestor del almac�n
		Gestor gestor = new Gestor();
		
		// Un producto que se pueda a�adir en el almac�n
		Producto leche = new Producto("leche", 0.79, 60);
		
		// A�adimos el producto al almac�n
		boolean resultado = gestor.a�adirProducto(leche);
		
		// Comprobamos que el producto se ha a�adido corectamente
		assertEquals(true, resultado);
		assertEquals(1, gestor.getAlmacen().size());
	}
	
	public void testA�adirProductoNull() {
		try {
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
			
			// A�adimos null en el almac�n
			gestor.a�adirProducto(null);
			
			fail("Deber�a haberse lanzado una excepci�n. Producto null");
		} catch (Exception e) {
			// Capturamos excepci�n para que el caso no falle
		}
	}

	public void testQuitarXProducto() {
		fail("Not yet implemented");
	}

	public void testGetAlmacen() {
		fail("Not yet implemented");
	}

	public void testGetCantidadTotal() {
		fail("Not yet implemented");
	}

}
