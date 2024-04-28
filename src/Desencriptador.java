public class Desencriptador {
    private CodificadorDeCaracteres codificador = new CodificadorDeCaracteres();

    public  String desencriptar(String textoParaDesencriptar, int clave) {
        int claveNegada = -clave;
        String TextoDesencriptado = codificador.recorrerLetra(textoParaDesencriptar, claveNegada);
        return TextoDesencriptado;
    }
}
