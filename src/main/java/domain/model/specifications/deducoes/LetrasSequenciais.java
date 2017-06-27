package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class LetrasSequenciais implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        return true;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(totalLetrasSequenciais(entity.getTexto()) * 3);
    }

    private double totalLetrasSequenciais(String password) {
        int totalAlphas = 0;
        String alphas = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 23; i++) {
            String forth = alphas.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.toLowerCase().contains(forth) || password.toLowerCase().contains(back)) {
                totalAlphas++;
            }
        }
        return totalAlphas;
    }
}
