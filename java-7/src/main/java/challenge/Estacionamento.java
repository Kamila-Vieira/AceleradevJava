package challenge;

import java.util.Objects;
import java.util.List;
import java.util.ArrayList;


public class Estacionamento {

    List <Carro> estacionados = new ArrayList<Carro>();
    int qtdCarros = -1;

    public void estacionar(Carro carro) throws EstacionamentoException {
        if (carro.getMotorista() == null)
            throw new EstacionamentoException("São permitidos somente carros não autonomos!");
        if (carro.getMotorista().getIdade() < 18)
            throw new EstacionamentoException("Somente motoristas maiores de idade!");
        if (carro.getMotorista().getPontos() > 20)
            throw new EstacionamentoException("Somente motoristas sem habilitação suspensa!");

        if (estacionados.size() < 10) {
            this.estacionados.add(carro);

            for(int i = 0; i < estacionados.size(); i++) {
                if (estacionados.get(i).getMotorista().getIdade() < 55) {
                    qtdCarros = i;
                    estacionados.remove(i);
                    estacionados.add(carro);
                        break;
                } else if (qtdCarros == 10) {
                    throw new EstacionamentoException("Estacionamento lotado!");
                } else {
                    qtdCarros++;
                }
            }
        }
    }

    public int carrosEstacionados() {

        return (int) estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {

        return estacionados.contains(carro);
    }

}
