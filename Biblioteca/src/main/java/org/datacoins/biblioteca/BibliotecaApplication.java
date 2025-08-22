package org.datacoins.biblioteca;

import org.datacoins.biblioteca.persistence.entity.Libros;
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

@SpringBootApplication
public class BibliotecaApplication {

	@Autowired
	private ILibroService libroService;

	private static final Logger logger = LoggerFactory.getLogger(BibliotecaApplication.class);

	String sl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Hola Mudno Enpezemos esta webonada");
		SpringApplication.run(BibliotecaApplication.class, args);
		logger.info("Lastima acabo esto weon ");
	}

	@Override
	public void run(String ... args)throws Exception{

		BibliotecaLibroApp();
	}
	private void BibliotecaLibroApp(){
		logger.info("***Aplicacion de Biblioteca A1***");
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			var opcion = mostrarMenu(consola);
			var salir = ejecutarOpciones(consola, opcion);
			logger.info(sl);
		}
	}

	private int mostrarMenu(Scanner consola){
		logger.info("""
					\n ***Menu de BIBLIOTECS****
					1. Listar Libros
					2. Buscar Libros
					3. Modificar Libros
					4. Agregar Libros
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
				logger.info(sl+"**Listado de todos los clientes***");
				List<Libros> libros = libroService.listarLibros();
				libros.forEach( libros1 -> logger.info(libros1.toString()+sl));
			}
			case 2 ->{

				logger.info(sl + "Buscar Cliente por su código" + sl);
				var codigo = Integer.parseInt(consola.nextLine());
				Libros libros = libroService.buscarLibroProId(codigo);
				if (libros != null) {
					logger.info("Libros encontrado: " + sl + libros + sl);
				} else {
					logger.info("Libros no encontrado: " + sl + libros + sl);
				}
			}
			case 3 ->{

				logger.info(sl+"***Agregar nuevo cliente***"+sl);
				logger.info("Ingrese el Titulo: ");
				var titulo = consola.nextLine();
				logger.info("Ingrese la cantidad: ");
				var apellido = Integer.parseInt(consola.nextLine());
				logger.info("Ingrese el telefono: ");
				var telefono = consola.nextLine();
				logger.info("Ingrese el correo: ");
				var correo = consola.nextLine();
				logger.info("Ingrese el genero: ");
				var genero = consola.nextLine();
				logger.info("Ingrese la edad: ");
				var edad = Integer.parseInt(consola.nextLine());
				var cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setTelefono(telefono);
				cliente.setCorreo(correo);
				cliente.setGenero(genero);
				cliente.setEdad(edad);
				clienteService.gurdarCliente(cliente);
				logger.info("Cliente agregado: "+sl +cliente +sl);
			}
			case 4 ->{}
			case 5 ->{}
			case 6 ->{}
			case 7 ->{}
			case 8 ->{}

			default -> logger.info(sl+"Opcion no valida"sl});
		}
	}

}

/*

			case 4 -> {
							logger.info(sl+"*** Modificar ciente***"+sl);
							logger.info("Ingrese el codigo del cliente a editar: ");
							var codigo = Integer.parseInt(consola.nextLine());
							Cliente cliente = clienteService.buscarClienteProId(codigo);
							if (cliente != null){
								logger.info("Ingrese el nombre: ");
								var nombre = consola.nextLine();
								logger.info("Ingrese el apellido: ");
								var apellido = consola.nextLine();
								logger.info("Ingrese el telefono: ");
								var telefono = consola.nextLine();
								logger.info("Ingrese el correo: ");
								var correo = consola.nextLine();
								logger.info("Ingrese el genero: ");
								var genero = consola.nextLine();
								logger.info("Ingrese la edad: ");
								var edad = Integer.parseInt(consola.nextLine());
								cliente.setNombre(nombre);
								cliente.setApellido(apellido);
								cliente.setTelefono(telefono);
								cliente.setCorreo(correo);
								cliente.setGenero(genero);
								cliente.setEdad(edad);
								clienteService.gurdarCliente(cliente);
								logger.info("Cliente agregado: "+sl +cliente +sl);
								}else{
								logger.info("Cliente NO encontrado: "+sl+cliente+sl);
							}

						}
			case 5 -> {
							logger.info(sl+"***Eliminar Cliente***"+sl);
							logger.info("Ingerese el codigo de cliente a eliminar");
							var codigo = Integer.parseInt(consola.nextLine());
							var cliente = clienteService.buscarClienteProId(codigo);
							if (cliente != null){
								clienteService.eliminarCliente(cliente);
								logger.info("Cliente eliminado, adios: "+sl+cliente+sl);
							}else{
								logger.info("Cliente MO econtrado"+ sl + cliente + sl);
							}
						}


			case 6 -> {
							logger.info("Hasta protonto vaquero" + sl + sl);
							salir = true;
						}

			default -> logger.info("Opcion no validad por hoy");
		}
		return salir;
	}

}

/*

