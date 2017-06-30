package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasMaiusculas extends Regra {


    public LetrasMaiusculas(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return password.totalLetrasMaiusculas();
    }

    @Override
    public double calcularPontuacao(Password password) {
        if (obterQuantidade(password) > 0 && password.totalCaracteres() != password.totalLetrasMaiusculas()) {
            return (password.tamanhoTexto() - password.totalLetrasMaiusculas()) * 2;
        }
        return 0;
    }
}
