package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class SimbolosSequenciais extends Regra {

    public SimbolosSequenciais(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
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
    public double calcularPontuacao() {
        return obterQuantidade() * 3;
    }
}
