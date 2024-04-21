import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static void ejecutaSeleccion(String s) throws InterruptedException {
        if (s.equals("1") || s.equals("encriptar")){

            System.out.println("se está encriptando tu archivo...");
            Thread.sleep(1000);
            System.out.println("Archivo encriptado con éxito");
            Thread.sleep(500);

        } else if (s.equals("2") || s.equals("desencriptar")) {

            System.out.println("se está desencriptando tu archivo...");
            Thread.sleep(1000);
            System.out.println("Archivo desencriptado con éxito");
            Thread.sleep(500);
        }else if (s.equals("0") || s.equals("salir")) {
            System.out.println("Hasta pronto!");
            return;
        }else{
            System.out.println("Opción invalida, intente de nuevo por favor.");
        }
        System.out.println("Pulsa \"enter\" para regresar al menú.");
        new Scanner(System.in).nextLine();
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String seleccion;
        do {
            System.out.println("1.- Encriptar\n" +
                                "2.- Desencriptar\n" +
                                "0.- salir\n");
            System.out.print("Elige una opción: ");
            seleccion = console.nextLine().toLowerCase();

            try {
                ejecutaSeleccion(seleccion);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }while(!(seleccion.equals("0") || seleccion.equals("salir")));
    }
}