package domain.model.entities;

import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;
import domain.model.specifications.adicoes.LetrasMaiusculas;
import domain.model.specifications.adicoes.LetrasMinusculas;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoPassword {

    public ValidacaoPassword(Password password) {
        regras = new ArrayList<>();

        Regra letrasMaiusculas = new LetrasMaiusculas("Letras Maiusculas", TipoRegra.ADICAO, password);
        Regra letrasMinusculas = new LetrasMinusculas("Letras Minusculas", TipoRegra.ADICAO, password);

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
