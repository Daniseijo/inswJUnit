import junit.framework.TestCase;
import AlmacenProductos.Gestor;
import AlmacenProductos.Producto;


public class BateriaPruebas extends TestCase {
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(Gestor.class);
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
	
	public void testPrecioCero() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0, 60);
					
			// Añadimos el producto al almacén
			boolean resultado = gestor.añadirProducto(leche);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			
		} catch (Exception e) {
			
		}	
	}
	
	public void testPrecioNegativo() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", -50, 60);
					
			// Añadimos el producto al almacén
			boolean resultado = gestor.añadirProducto(leche);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
			
		} catch (Exception e) {
			
		}	
	}

	public void testCantidadNegativa() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
				
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, -1000);
				
			// Añadimos el producto al almacén
			boolean resultado = gestor.añadirProducto(leche);
		
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail("Salta excepción");
		}	
	}
	
	public void testCantidadPermitida() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, 150);
					
			// Añadimos el producto al almacén
			boolean resultado = gestor.añadirProducto(leche);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			assertEquals(150, gestor.getCantidadTotal());
		
		} catch (Exception e) {
			fail("Salta excepción");
		}	
	}
	
	public void testCantidadMasDe300() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, 301);
					
			// Añadimos el producto al almacén
			boolean resultado = gestor.añadirProducto(leche);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(false, resultado);
			assertEquals(0, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail("Salta excepción");
		}	
	}
	
	public void testProductoRepetido() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, 150);
					
			// Añadimos el producto al almacén
			gestor.añadirProducto(leche);
			
			leche = new Producto("leche", 0.79, 200);
			
			boolean resultado = gestor.añadirProducto(leche);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
			assertEquals(200, gestor.getCantidadTotal());
		
		} catch (Exception e) {
			fail("Salta excepción");
		}	
	}
	
	public void testQuitarXProducto() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, 150);
					
			// Añadimos el producto al almacén
			gestor.añadirProducto(leche);
			gestor.añadirProducto(leche);
			
			boolean resultado = gestor.quitarXProducto(leche, 2);
			//resultado = gestor.quitarXProducto(leche, 1);
			
			// Comprobamos que el producto se ha añadido corectamente
			assertEquals(true, resultado);
			assertEquals(1, gestor.getAlmacen().size());
		
		} catch (Exception e) {
			fail(""+e);
		}	
	}

	public void testQuitarProductoNegativo() {
		try{
			// Creamos un gestor del almacén
			Gestor gestor = new Gestor();
					
			// Un producto que se pueda añadir en el almacén
			Producto leche = new Producto("leche", 0.79, 50);
					
			// Añadimos el producto al almacén
			gestor.añadirProducto(leche);
			
			gestor.quitarXProducto(leche, -49);
			
			fail("No Salta excepción");
		
		} catch (Exception e) {
			// Salta excepción
		}	
	}

	public void testGetCantidadTotal() {
		fail("Not yet implemented");
	}

}
