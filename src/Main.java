import java.util.Scanner;
public class Main {

    private static void ejecutaSeleccion(String seleccion){
        Scanner console = new Scanner(System.in);
        switch (seleccion) {
            case "1", "encriptar" -> {
                System.out.print("Ingrese la clave de codificación para cifrado cesar: ");
                int clave = console.nextInt();

                System.out.print("Ingrese el nombre del archivo que desea encriptar: ");

                String archivoParaEncriptar = new Scanner(System.in).nextLine();

                System.out.println(archivoParaEncriptar);

                System.out.println("se está encriptando el archivo " + archivoParaEncriptar + "...");

                Encriptador.encriptarArchivo(clave, archivoParaEncriptar);

                System.out.println("Archivo encriptado con éxito");
            }
            case "2", "desencriptar" -> {

                System.out.println("se está desencriptando tu archivo...");
//                Thread.sleep(1000);
                System.out.println("Archivo desencriptado con éxito");
//                Thread.sleep(500);
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