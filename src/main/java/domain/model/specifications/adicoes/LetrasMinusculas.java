package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.specifications.Regra;
import domain.model.enumeradores.TipoRegra;

public class LetrasMinusculas extends Regra {

    public LetrasMinusculas(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        return password.totalLetrasMinusculas();
    }

    @Override
    public double calcularPontuacao() {
        if (obterQuantidade() > 0 && password.totalCaracteres() != password.totalLetrasMinusculas()) {
            return (password.tamanhoTexto() - password.totalLetrasMinusculas()) * 2;
        }
        return 0;
    }
}
