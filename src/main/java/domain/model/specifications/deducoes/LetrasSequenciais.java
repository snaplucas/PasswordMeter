package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class LetrasSequenciais extends Regra {

    public LetrasSequenciais(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int totalAlphas = 0;
        String alphas = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 23; i++) {
            String forth = alphas.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.getTexto().toLowerCase().contains(forth) || password.getTexto().toLowerCase().contains(back)) {
                totalAlphas++;
            }
        }
        return totalAlphas;
    }

    @Override
    public double calcularPontuacao(Password password) {
        return obterQuantidade(password) * 3;
    }
}
