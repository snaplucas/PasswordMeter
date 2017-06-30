package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasMinusculas extends Regra {

    public LetrasMinusculas(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return password.totalLetrasMinusculas();
    }

    @Override
    public double calcularPontuacao(Password password) {
        if (obterQuantidade(password) > 0 && password.totalCaracteres() != password.totalLetrasMinusculas()) {
            return (password.tamanhoTexto() - password.totalLetrasMinusculas()) * 2;
        }
        return 0;
    }
}
