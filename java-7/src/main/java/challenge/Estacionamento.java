package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Estacionamento {

    List<Carro> carros = new ArrayList<Carro>();
    int qtdCarrosEstacionados = 0;

    public void estacionar(Carro carro) {
        if (qtdCarrosEstacionados <= 10) {
            carros.add(carro);
            qtdCarrosEstacionados++;
        }
        if (qtdCarrosEstacionados == 10) {
            if (carro.getMotorista().getIdade() < 55) {
                carros.stream().filter(carro1 -> carro1.getMotorista().getIdade() < 55).findFirst().map(carros::remove);
            } else {
                throw new EstacionamentoException("Não há vagas.");
            }
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }
}
