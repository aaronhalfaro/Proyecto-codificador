import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodificadorDeCaracteres {
    char encriptar(char letraSinEncriptar, int clave){
        int codigoLetraEncriptada = letraSinEncriptar + clave;
        char letraEncriptada = (char) codigoLetraEncriptada;
        return letraEncriptada;
    }
    String encriptar(String textoSinEncriptar, int clave){
        StringBuilder creadorDeCadenas = new StringBuilder();
        for (int i = 0; i < textoSinEncriptar.length(); i++) {
            char caracterSinEncriptar = textoSinEncriptar.charAt(i);
            char letraEncriptada = encriptar(caracterSinEncriptar, clave);
            creadorDeCadenas.append(letraEncriptada);
        }
        String textoEncriptado = creadorDeCadenas.toString();
        return textoEncriptado;
    }
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
                "noveno", "décimo", "primero", "segundo", "tercer", "cuarto", "quinto", "sexto", "séptimo", "octavo",
                "noveno", "décimo", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        // Dividimos el texto en palabras
        String[] palabras = textoAComprobar.split("\\s+");

        // Contamos el número de palabras en español
        int contador = 0;
        for (String palabra : palabras) {
            if (palabrasEspanol.contains(palabra)) {
                contador++;
            }
        }

        // Si el número de palabras en español supera un umbral, consideramos que el texto está en español
        int umbral = 5; // Puedes ajustar este valor según sea necesario
        return contador >= umbral;
    }
}
