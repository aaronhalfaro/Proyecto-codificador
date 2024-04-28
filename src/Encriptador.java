public class Encriptador {
    private CodificadorDeCaracteres codificador = new CodificadorDeCaracteres();
    public  String encriptar(String textoParaEsencriptar, int clave) {
//        int claveNegada = -clave;
        String TextoEncriptado = codificador.recorrerLetra(textoParaEsencriptar, clave);
        return TextoEncriptado;
    }

}
