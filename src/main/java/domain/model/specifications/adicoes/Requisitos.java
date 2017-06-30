package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class Requisitos extends Regra {

    public Requisitos(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int itensRequeridos;
        itensRequeridos = +password.totalCaracteres() >= 8 ? 1 : 0;
        itensRequeridos += password.totalLetrasMaiusculas() > 0 ? 1 : 0;
        itensRequeridos += password.totalLetrasMinusculas() > 0 ? 1 : 0;
        itensRequeridos += password.totalNumeros() > 0 ? 1 : 0;
        itensRequeridos += password.totalSimbolos() > 0 ? 1 : 0;
        return itensRequeridos;
    }

    @Override
    public double calcularPontuacao(Password password) {
        int min = verificarRequisitosMinimos(password.totalCaracteres());
        long quantidade = obterQuantidade(password);
        if (quantidade > min) {
            return quantidade * 2;
        }
        return 0;
    }

    private int verificarRequisitosMinimos(int totalCaracteres) {
        int min;
        if (totalCaracteres >= 8) {
            min = 3;
        } else {
            min = 4;
        }
        return min;
    }
}
