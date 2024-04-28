import java.util.Arrays;
import java.util.List;

public class DesencriptadorPorFuerzaBruta {
    private Desencriptador desencriptador = new Desencriptador();

    public boolean comprobarTexto(String textoAComprobar) {
        // Lista de palabras en español
        List<String> palabrasEspanol = Arrays.asList("el", "la", "los", "las", "un", "una", "unos", "unas", "y", "o",
                "pero", "si", "porque", "que", "de", "del", "al", "a", "en", "con", "para", "como", "más", "mucho",
                "mucha", "poco", "poca", "bien", "mal", "sí", "no", "yo", "tú", "él", "ella", "nosotros", "vosotros",
                "ellos", "ellas", "este", "esta", "estos", "estas", "ese", "esa", "esos", "esas", "aquí", "ahí", "allí",
                "cuando", "donde", "quién", "cómo", "qué", "cuál", "cuáles", "cual", "cuales", "cuyo", "cuya", "cuyos",
                "cuyas", "sobre", "bajo", "entre", "hacia", "desde", "ante", "tras", "sin", "para", "durante", "según",
                "aunque", "siempre", "nunca", "también", "además", "aun", "hasta", "por", "porque", "como", "para", "si",
                "entonces", "así", "entonces", "tan", "tanto", "tanta", "tan", "tal", "también", "tampoco", "todavía",
                "ya", "sólo", "solamente", "quizá", "quizás", "acaso", "aunque", "pues", "así", "luego", "entonces",
                "después", "antes", "primero", "segundo", "tercero", "cuarto", "quinto", "sexto", "séptimo", "octavo",
                "noveno", "décimo", "tercer");

        // Dividimos el texto en palabras
        // no funciona si el texto esta todo junto
        String[] palabras = textoAComprobar.split("\\s+");

        // Contamos el número de palabras en español
        int contador = 0;
        for (String palabra : palabras) {
            if (palabrasEspanol.contains(palabra)) {
                contador++;
            }
        }

        // Si el número de palabras en español supera un umbral, consideramos que el texto está en español
        int umbral = 15;
        return contador >= umbral;
    }

    String desencriptarPorFuerzaBruta(String textoEncriptado) {
        String textoMinusculas = textoEncriptado.toLowerCase(); //Para poder trabajar con textos en mayusculas
        int contadorClave = 1;
        while (!comprobarTexto(textoMinusculas)) {
            textoEncriptado = desencriptador.desencriptar(textoEncriptado, ++contadorClave);
            textoMinusculas = textoEncriptado.toLowerCase();
            if (contadorClave > Character.MAX_VALUE) {
                System.out.println("\nNO FUE POSIBLE DECODIFICAR EL MENSAJE\n");
                return "no se pudo";
            }
        }
        return textoEncriptado;
    }
}