package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import port.adapter.specification.pattern.interfaces.ISpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MediaNumeroSimbolos implements ISpecification<Password> {

    private List<Character> characterList = new ArrayList<>();

    @Override
    public boolean isSatisfiedBy(Password entity) {
        characterList = entity.getCaracteres().stream().skip(0).collect(Collectors.toList());
        characterList.remove(characterList.size());
        return characterList.stream().filter(a -> Character.isDigit(a) || Character.isAlphabetic(a)).count() > 0;
    }

    @Override
    public double calcularPontuacao(Password entity) {
        return characterList.stream().filter(a -> Character.isDigit(a) || Character.isAlphabetic(a)).count() * 2;
    }
}
