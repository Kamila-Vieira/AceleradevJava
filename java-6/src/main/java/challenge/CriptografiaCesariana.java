package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (texto.equals("")){throw new IllegalArgumentException();}
        int chave=3;
        String cripto="";

       // StringBuider cripto = new StringBuider();

        for (char letra : texto.toLowerCase().toCharArray()) {
            if ((letra >= 'a') && (letra <= 'z')) {
                cripto = cripto + (char) (letra + chave);
            } else {
                cripto = cripto + letra;
            }
        }
            return cripto; //.toString()
    }
    @Override
    public String descriptografar(String texto) {
        if (texto.equals("")){throw new IllegalArgumentException();}

        int chave=3;
        String descripto="";

       // StringBuider descripto = new StringBuider();


        for (char letra : texto.toLowerCase().toCharArray()) {
            if ((letra >= 'a') && (letra <= 'z')) {
                descripto = descripto + (char)(letra - chave);
            } else {
                descripto = descripto + letra;

            }
        }
        return descripto; //.toString();

    }

}
