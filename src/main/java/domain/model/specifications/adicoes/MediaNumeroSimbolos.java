package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

import java.util.List;
import java.util.stream.Collectors;

public class MediaNumeroSimbolos extends Regra {

    private List<Character> characterList;

    public MediaNumeroSimbolos(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
        characterList = caracteresMeio();
    }

    @Override
    public long obterQuantidade() {
        return characterList.stream().filter(a -> Character.isDigit(a) || !Character.isAlphabetic(a)).count();
    }

    @Override
    public double calcularPontuacao() {
        return characterList.stream().filter(a -> Character.isDigit(a) || !Character.isAlphabetic(a)).count() * 2;
    }

    private List<Character> caracteresMeio() {
        characterList = password.getCaracteres().stream().skip(1).collect(Collectors.toList());
        characterList.remove(characterList.size() -1);
        return characterList;
    }
}
