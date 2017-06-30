package domain.model.specifications.adicoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

import java.util.List;
import java.util.stream.Collectors;

public class MediaNumeroSimbolos extends Regra {

    public MediaNumeroSimbolos(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        return caracteresMeio(password.getCaracteres()).stream().filter(a -> Character.isDigit(a) || !Character.isAlphabetic(a)).count();
    }

    @Override
    public double calcularPontuacao(Password password) {
        return caracteresMeio(password.getCaracteres()).stream().filter(a -> Character.isDigit(a) || !Character.isAlphabetic(a)).count() * 2;
    }

    private List<Character> caracteresMeio(List<Character> caracteres) {
        List<Character> characterList = caracteres.stream().skip(1).collect(Collectors.toList());
        if (characterList.size() > 0) characterList.remove(characterList.size() - 1);
        return characterList;
    }
}
