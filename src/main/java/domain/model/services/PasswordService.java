package domain.model.services;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.interfaces.IPasswordService;
import domain.model.specifications.Regra;

import java.util.List;

public class PasswordService implements IPasswordService {

    private final List<Regra> regras;

    public PasswordService(List<Regra> regras) {
        this.regras = regras;
    }

    @Override
    public double calcularPontuacaoTotal(Password password) {
        double adicoes = regras.stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.ADICAO)
                .mapToDouble(x -> x.calcularPontuacao(password))
                .sum();

        double deducoes = regras.stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.DEDUCAO)
                .mapToDouble(x -> x.calcularPontuacao(password))
                .sum();

        return adicoes - deducoes;
    }

    @Override
    public List<Regra> getRegras() {
        return regras;
    }
}
