import java.util.Scanner;
public class Main {

    private static void ejecutaSeleccion(String seleccion){
        Scanner console = new Scanner(System.in);
        switch (seleccion) {
            case "1", "encriptar" -> {
                System.out.print("Ingrese el nombre del archivo que desea encriptar: ");

                String archivoParaEncriptar = new Scanner(System.in).nextLine();

                ////LEER ARCHIVO ESPECIFICADO A ENCRIPTAR Y CONVERTIR SU CONTENIDO EN UNA CADENA
                String textoDeArchivo = LectorDeArchivo.leerArchivoTexto(archivoParaEncriptar);

                System.out.print("Ingrese la clave de codificación para cifrado cesar: ");
                int clave = console.nextInt();

                //ENCRIPTAR ARCHIVO
                System.out.println("se está encriptando el archivo " + archivoParaEncriptar + "...");
                //CodificadorDeCaracteres codificador = new CodificadorDeCaracteres();
                Encriptador encriptador = new Encriptador();
                String textoEncriptado = encriptador.encriptar(textoDeArchivo, clave);

                //ESCRIBIR ARCHIVO CON EL TEXTO ENCRIPTADO
                LectorDeArchivo.escribirArchivoDeTexto(textoEncriptado);

//                        Encriptador.encriptarArchivo(clave, archivoParaEncriptar);

                System.out.println("Archivo encriptado con éxito");
            }
            case "2", "desencriptar" -> {

                System.out.print("Ingrese el nombre del archivo que desea desencriptar: ");

                //LEER ARCHIVO ESPECIFICADO A DESENCRIPTAR Y CONVERTIR SU CONTENIDO EN UNA CADENA
                String archivoParaDesencriptar = new Scanner(System.in).nextLine();
                String textoDeArchivo = LectorDeArchivo.leerArchivoTexto(archivoParaDesencriptar);

                System.out.println("\n\nse está desencriptando el texto " + "en \"archivocopy.txt\"" + "...\n");


                //DESENCRIPTADO POR FUERZA BRUTA
                DesencriptadorPorFuerzaBruta desencriptador = new DesencriptadorPorFuerzaBruta();
                String textoDesencriptado = desencriptador.desencriptarPorFuerzaBruta(textoDeArchivo);

                //FALLA?
                if(textoDesencriptado.equals("no se pudo")){
                    System.out.println("\nNO FUE POSIBLE DECODIFICAR EL MENSAJE\n");
                    return;}

                //IMPRIMIR TEXTO EN PANTALLA
                System.out.println("El texto encriptado es: \n");
                 System.out.println(textoDesencriptado);

                //ESCRIBIR ARCHIVO DESENCRIPTADO
                LectorDeArchivo.escribirArchivoDeTexto(textoDesencriptado);

                System.out.println("\n\nArchivo desencriptado con éxito en \"archivo.copy.txt\"\n");

            }
            case "0", "salir" -> {
                System.out.println("Hasta pronto!");
                return;
            }
            default -> System.out.println("Opción invalida, intente de nuevo por favor.");
        }
        System.out.println("Pulsa \"enter\" para regresar al menú.");
        new Scanner(System.in).nextLine();
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String seleccion;

        System.out.println("Programa que encripta un archivo .txt");
        do {
            System.out.println("""
                        1.- Encriptar
                        2.- Desencriptar
                        0.- salir
                    """);
            System.out.print("Elige una opción: ");
            seleccion = console.nextLine().toLowerCase();

            ejecutaSeleccion(seleccion);

        }while(!(seleccion.equals("0") || seleccion.equals("salir")));
    }
}