package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

public class NumerosSequenciais implements ISpecification<Password> {

    @Override
    public boolean isSatisfiedBy(Password entity) {
        return true;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return -(totalNumerosSequenciais(entity.getTexto()) * 3);
    }

    private double totalNumerosSequenciais(String password) {
        int totalNumbers = 0;
        String numbers = "0123456789";

        for (int i = 0; i < 8; i++) {
            String forth = numbers.substring(i, i + 3);
            String back = new StringBuffer(forth).reverse().toString();
            if (password.toLowerCase().contains(forth) || password.toLowerCase().contains(back)) {
                totalNumbers++;
            }
        }
        return totalNumbers;
    }
}
