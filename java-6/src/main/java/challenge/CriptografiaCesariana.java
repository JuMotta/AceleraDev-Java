package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("A string é nula");
        }
        else if (texto.isEmpty()) {
            throw new IllegalArgumentException("A string está vazia.");
        }

        int tamanho = texto.length();
        int i;
        String textoCrip = "";
        String textoMin = texto.toLowerCase();

        for (i = 0; i < tamanho; i++) {
            if (textoMin.charAt(i) >= '0' && textoMin.charAt(i) <= '9') {
                textoCrip += textoMin.charAt(i);
            }
            else if (textoMin.charAt(i) == (char) 32) {
                textoCrip += textoMin.charAt(i);
            }
            else if ((textoMin.charAt(i) >= 'a') && (textoMin.charAt(i) <= 'z')) {
                textoCrip += (char)((int) textoMin.charAt(i) + 3);
            }

        }
        return textoCrip;
    }

    @Override
    public String descriptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("A string é nula");
        }
        else if (texto.isEmpty()) {
            throw new IllegalArgumentException("A string está vazia.");
        }

        int tamanho = texto.length();
        int i;
        String textoDescrip = "";
        String textoMin = texto.toLowerCase();

        for (i = 0; i < tamanho; i++) {
            if (textoMin.charAt(i) >= '0' && textoMin.charAt(i) <= '9') {
                textoDescrip += textoMin.charAt(i);
            }
            else if (textoMin.charAt(i) == (char) 32) {
                textoDescrip += textoMin.charAt(i);
            }
            else if ((textoMin.charAt(i) >= 'a') && (textoMin.charAt(i) <= 'z')) {
                textoDescrip += (char)((int) textoMin.charAt(i) - 3);
            }

        }
        return textoDescrip;
    }
}
