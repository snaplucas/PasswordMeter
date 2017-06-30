package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class SimbolosSequenciais extends Regra {

    public SimbolosSequenciais(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int totalSymbols = 0;
        String symbols = ")!@#$%^&*()";

        for (int i = 0; i < 8; i++) {
            String forth = symbols.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.getTexto().toLowerCase().contains(forth) || password.getTexto().toLowerCase().contains(back)) {
                totalSymbols++;
            }
        }
        return totalSymbols;
    }

    @Override
    public double calcularPontuacao(Password password) {
        return obterQuantidade(password) * 3;
    }
}
