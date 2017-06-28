package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

public class NumerosSequenciais extends Regra {

    public NumerosSequenciais(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
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
    public double calcularPontuacao() {
        return obterQuantidade() * 3;
    }
}
