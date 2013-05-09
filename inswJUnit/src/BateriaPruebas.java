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

	public void testAñadirProducto() throws Exception {
		// Creamos un gestor del almacén
		Gestor gestor = new Gestor();
		
		// Un producto que se pueda añadir en el almacén
		Producto leche = new Producto("leche", 0.79, 60);
		
		// Añadimos el producto al almacén
		boolean resultado = gestor.añadirProducto(leche);
		
		// Comprobamos que el producto se ha añadido corectamente
		assertEquals(true, resultado);
		assertEquals(1, gestor.getAlmacen().size());
	}
	
	public void testAñadirProductoNull() {
		try {
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
			
			// Añadimos null en el almacén
			gestor.añadirProducto(null);
			
			fail("Debería haberse lanzado una excepción. Producto null");
		} catch (Exception e) {
			// Capturamos excepción para que el caso no falle
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
