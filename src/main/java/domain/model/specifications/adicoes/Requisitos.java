package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Requisitos extends Regra {

    public Requisitos(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        int itensRequeridos;
        itensRequeridos = +password.totalCaracteres() >= 8 ? 1 : 0;
        itensRequeridos += password.totalLetrasMaiusculas() > 0 ? 1 : 0;
        itensRequeridos += password.totalLetrasMinusculas() > 0 ? 1 : 0;
        itensRequeridos += password.totalNumeros() > 0 ? 1 : 0;
        itensRequeridos += password.totalSimbolos() > 0 ? 1 : 0;
        return itensRequeridos;
    }

    @Override
    public double calcularPontuacao() {
        int min = verificarRequisitosMinimos();
        long quantidade = obterQuantidade();
        if (quantidade > min) {
            return quantidade * 2;
        }
        return 0;
    }

    private int verificarRequisitosMinimos() {
        int min;
        if (password.totalCaracteres() >= 8) {
            min = 3;
        } else {
            min = 4;
        }
        return min;
    }
}
