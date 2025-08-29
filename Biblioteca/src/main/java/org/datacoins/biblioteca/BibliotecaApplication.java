package org.datacoins.biblioteca;


import org.datacoins.biblioteca.dominio.service.IGeneroService;
import org.datacoins.biblioteca.dominio.service.IUbicacionService;
import org.datacoins.biblioteca.persistence.entity.Generos;
import org.datacoins.biblioteca.persistence.entity.Ubicacion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.datacoins.biblioteca.dominio.service.LibroService;
import org.datacoins.biblioteca.dominio.service.ILibroService;
import java.util.List;
import java.util.Scanner;
import org.datacoins.biblioteca.persistence.entity.Libros;

//@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;

	@Autowired
	private IGeneroService generoService;

	@Autowired
	private IUbicacionService ubicacionService;

	private static final Logger logger = LoggerFactory.getLogger(BibliotecaApplication.class);

	String sl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Hola Mudno Enpezemos esta webonada");
		SpringApplication.run(BibliotecaApplication.class, args);
		logger.info("Lastima acabo esto weon ");
	}

	@Override
	public void run(String ... args) throws Exception{
		BibliotecaLibroApp();
	}

	private void BibliotecaLibroApp(){
		logger.info("***Aplicacion de Biblioteca A1***");
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			var opcion = mostrarMenu(consola);
			salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
					\n ***Menu de BIBLIOTECS****
					1. Listar Libros
					2. Buscar Libros
					3. Agrega Libros
					4. Modifica Libros
					5. eliminar Libros
					6. Listar Generos
					7. Listar Ubicaciones
					8. Salir
					
					Elije una Opcion: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion){
			case 1 ->{
				logger.info(sl+"**Listado de todos los Libros***");
				List<Libros> libros = libroService.listarLibros();
				libros.forEach( libros1 -> logger.info(libros1.toString()+sl));
			}
			case 2 ->{

				logger.info(sl + "Buscar Libro por su código" + sl);
				var codigo = Integer.parseInt(consola.nextLine());
				Libros libros = libroService.buscarLibroProId(codigo);
				if (libros != null) {
					logger.info("Libros encontrado: " + sl + libros + sl);
				} else {
					logger.info("Libros no encontrado: " + sl + libros + sl);
				}
			}
			case 3 ->{

				logger.info(sl+"***Agregar nuevo Libro***"+sl);
				logger.info("Ingrese el Titulo: ");
				var titulo = consola.nextLine();
				logger.info("Ingrese la cantidad: ");
				var cantidad = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el autor: ");
				var autor = consola.nextLine();
				logger.info("Ingrese el codig del Genero: ");
				logger.info(sl+"**Listado de todos los Generos***");
				List<Generos> generos = generoService.listarGeneros();
				generos.forEach( generos1 -> logger.info(generos1.toString()+sl));
				var codigoGenero = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el codigo de la Ubicacion: ");
				logger.info(sl+"**Listado de todos las Ubicaciones***");
				List<Ubicacion> ubicacions = ubicacionService.listarUbicaciones();
				ubicacions.forEach( ubicacion1 -> logger.info(ubicacion1.toString()+sl));
				var codigoUbicacion = Integer.parseInt(consola.nextLine());

				var libros = new Libros();
				libros.setTitulo(titulo);
				libros.setCantidad(cantidad);
				libros.setAutor(autor);
				libros.setCodigoGenero(codigoGenero);
				libros.setCodigoUbicacion(codigoUbicacion);
				libroService.guardarLibro(libros);
				logger.info("Libro agregado: "+sl +libros +sl);
			}
			case 4 ->{
						logger.info(sl+"*** Modificar Libro***"+sl);
						logger.info("Ingrese el codigo del Libro a editar: ");
						var codigo = Integer.parseInt(consola.nextLine());
						Libros libros = libroService.buscarLibroProId(codigo);
						if (libros != null){
							logger.info("Ingrese el Titulo: ");
							var titulo = consola.nextLine();
							logger.info("Ingrese la cantidad: ");
							var cantidad = Integer.parseInt(consola.nextLine());
							logger.info("Ingrese el autor: ");
							var autor = consola.nextLine();
							logger.info("Ingrese el codig del Genero: ");
							logger.info(sl+"**Listado de todos los Generos***");
							List<Generos> generos = generoService.listarGeneros();
							generos.forEach( generos1 -> logger.info(generos1.toString()+sl));
							var codigoGenero = Integer.parseInt(consola.nextLine());
							logger.info("Ingrese el codigo de la Ubicacion: ");
							logger.info(sl+"**Listado de todos las Ubicaciones***");
							List<Ubicacion> ubicacions = ubicacionService.listarUbicaciones();
							ubicacions.forEach( ubicacion1 -> logger.info(ubicacion1.toString()+sl));
							var codigoUbicacion = Integer.parseInt(consola.nextLine());
							libros.setTitulo(titulo);
							libros.setCantidad(cantidad);
							libros.setAutor(autor);
							libros.setCodigoGenero(codigoGenero);
							libros.setCodigoUbicacion(codigoUbicacion);
							libroService.guardarLibro(libros);
							logger.info("Libro agregado: "+sl +libros +sl);
						}else{
							logger.info("Libro NO encontrado: "+sl+libros+sl);
						}
					}
			case 5 ->{
						logger.info(sl+"***Eliminar Libro***"+sl);
						logger.info("Ingerese el codigo de Libro a eliminar");
						var codigo = Integer.parseInt(consola.nextLine());
						var libros = libroService.buscarLibroProId(codigo);
						if (libros != null){
							libroService.eliminarLibro(libros);
							logger.info("Libro eliminado, adios: "+sl+libros+sl);
						}else{
							logger.info("Libro MO econtrado"+ sl + libros + sl);
						}
					}
			case 6 ->{

						logger.info(sl+"**Listado de todos los Generos***");
						List<Generos> generos = generoService.listarGeneros();
						generos.forEach( generos1 -> logger.info(generos1.toString()+sl));
					}
			case 7 ->{

						logger.info(sl+"**Listado de todos las Ubicaciones***");
						List<Ubicacion> ubicacions = ubicacionService.listarUbicaciones();
						ubicacions.forEach( ubicacion1 -> logger.info(ubicacion1.toString()+sl));

					}
			case 8 ->{

						logger.info("Hasta protonto vaquero" + sl + sl);
						salir = true;
					}

			default -> logger.info(sl+"Opcion no valida"+sl);
		}
        return salir;
    }

}

/*/*


 */




