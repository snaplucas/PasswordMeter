package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.specifications.Regra;
import domain.model.enumeradores.TipoRegra;

public class LetrasMaiusculas extends Regra {


    public LetrasMaiusculas(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        return password.totalLetrasMaiusculas();
    }

    @Override
    public double calcularPontuacao() {
        if (obterQuantidade() > 0) {
            return (password.tamanhoTexto() - password.totalLetrasMaiusculas()) * 2;
        }
        return 0;
    }
}
