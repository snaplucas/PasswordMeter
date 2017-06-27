package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class SimbolosSequenciais implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        return true;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(totalSimbolosSequenciais(entity.getTexto()) * 3);
    }

    private double totalSimbolosSequenciais(String password) {
        int totalSymbols = 0;
        String symbols = ")!@#$%^&*()";

        for (int i = 0; i < 8; i++) {
            String forth = symbols.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.toLowerCase().contains(forth) || password.toLowerCase().contains(back)) {
                totalSymbols++;
            }
        }
        return totalSymbols;
    }
}
