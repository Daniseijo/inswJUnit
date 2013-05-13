import junit.framework.TestCase;
import AlmacenProductos.Gestor;
import AlmacenProductos.Producto;


public class BateriaPruebas extends TestCase {
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Gestor.class);
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
	
	public void testPrecioCero() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0, 60);
					
			// A�adimos el producto al almac�n
			boolean resultado = gestor.a�adirProducto(leche);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			
		} catch (Exception e) {
			
		}	
	}
	
	public void testPrecioNegativo() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", -50, 60);
					
			// A�adimos el producto al almac�n
			boolean resultado = gestor.a�adirProducto(leche);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
			
		} catch (Exception e) {
			
		}	
	}

	public void testCantidadNegativa() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
				
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, -1000);
				
			// A�adimos el producto al almac�n
			boolean resultado = gestor.a�adirProducto(leche);
		
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail("Salta excepci�n");
		}	
	}
	
	public void testCantidadPermitida() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, 150);
					
			// A�adimos el producto al almac�n
			boolean resultado = gestor.a�adirProducto(leche);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			assertEquals(150, gestor.getCantidadTotal());
		
		} catch (Exception e) {
			fail("Salta excepci�n");
		}	
	}
	
	public void testCantidadMasDe300() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, 301);
					
			// A�adimos el producto al almac�n
			boolean resultado = gestor.a�adirProducto(leche);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail("Salta excepci�n");
		}	
	}
	
	public void testProductoRepetido() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, 150);
					
			// A�adimos el producto al almac�n
			gestor.a�adirProducto(leche);
			
			leche = new Producto("leche", 0.79, 200);
			
			boolean resultado = gestor.a�adirProducto(leche);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			assertEquals(200, gestor.getCantidadTotal());
		
		} catch (Exception e) {
			fail("Salta excepci�n");
		}	
	}
	
	public void testQuitarXProducto() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, 150);
					
			// A�adimos el producto al almac�n
			gestor.a�adirProducto(leche);
			gestor.a�adirProducto(leche);
			
			boolean resultado = gestor.quitarXProducto(leche, 2);
			//resultado = gestor.quitarXProducto(leche, 1);
			
			// Comprobamos que el producto se ha a�adido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail(""+e);
		}	
	}

	public void testQuitarProductoNegativo() {
		try{
			// Creamos un gestor del almac�n
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda a�adir en el almac�n
			Producto leche = new Producto("leche", 0.79, 50);
					
			// A�adimos el producto al almac�n
			gestor.a�adirProducto(leche);
			
			gestor.quitarXProducto(leche, -49);
			
			fail("No Salta excepci�n");
		
		} catch (Exception e) {
			// Salta excepci�n
		}	
	}

	public void testGetCantidadTotal() {
		fail("Not yet implemented");
	}

}
