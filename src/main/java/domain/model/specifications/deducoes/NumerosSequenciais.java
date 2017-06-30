package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class NumerosSequenciais extends Regra {

    public NumerosSequenciais(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int totalNumeros = 0;
        String numbers = "0123456789";

        for (int i = 0; i < 8; i++) {
            String forth = numbers.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.getTexto().toLowerCase().contains(forth) || password.getTexto().toLowerCase().contains(back)) {
                totalNumeros++;
            }
        }
        return totalNumeros;
    }

    @Override
    public double calcularPontuacao(Password password) {
        return obterQuantidade(password) * 3;
    }
}
