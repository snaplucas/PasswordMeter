package domain.model.entities;

import domain.model.enumeradores.TipoRegra;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoPassword {

    public ValidacaoPassword(Password password) {
        regras = new ArrayList<>();

        Regra letrasMaiusculas = new LetrasMaiusculasRegra("Letras Maiusculas", TipoRegra.ADICAO, password);
        Regra letrasMinusculas = new LetrasMinusculasRegra("Letras Minusculas", TipoRegra.ADICAO, password);

        regras.add(letrasMaiusculas);
        regras.add(letrasMinusculas);
    }

    private List<Regra> regras;

    public List<Regra> getRegras() {
        return regras;
    }

    public double pontuacaoTotal() {
        regras.forEach(Regra::obterQuantidade);

        double adicoes = regras
                .stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.ADICAO)
                .mapToDouble(Regra::calcularPontuacao).sum();

        double deducoes = regras
                .stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.DEDUCAO)
                .mapToDouble(Regra::calcularPontuacao).sum();

        return adicoes - deducoes;
    }
}
