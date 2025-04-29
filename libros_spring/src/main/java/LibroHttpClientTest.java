import com.practica.libros.servicios.LibroHttpClient;

public class LibroHttpClientTest {

	public static void main(String[] args) {
        LibroHttpClient client = new LibroHttpClient();

        try {
            // Probar GET para obtener todos los libros
//            System.out.println("Probando GET todos los libros:");
//            String allLibros = client.getAllLibros();
//            System.out.println(allLibros);

            // Probar POST para crear un libro
            System.out.println("\nProbando POST para crear un libro:");
            String nuevoLibro = client.createLibro(
                    "Cien Años de Soledad", 
                    "Gabriel García Márquez", 
                    "Realismo Mágico", 
                    "1967" 
            );
            System.out.println(nuevoLibro);

            // Probar GET para obtener un libro por ID
           /* System.out.println("\nProbando GET por ID:");
            String libroPorId = client.getLibroById(1L); // Cambia el ID si es necesario
            System.out.println(libroPorId); */

            // Probar PUT para actualizar un libro
//            System.out.println("\nProbando PUT para actualizar un libro:");
//            String libroActualizado = client.updateLibro(
//                    1L, 
//                    "Cien Años de Soledad (Edición Revisada)", 
//                    "Gabriel García Márquez", 
//                    "Realismo Mágico", 
//                    "1970"
//            );
//            System.out.println(libroActualizado);
//
//            // Probar DELETE para eliminar un libro
//            System.out.println("\nProbando DELETE para eliminar un libro:");
//            String libroEliminado = client.deleteLibro(1L); // Cambia el ID si es necesario
//            System.out.println(libroEliminado);

        } catch (Exception e) {
            System.err.println("Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
