package domain.model.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Password {

    private String texto;
    private List<Character> caracteres;

    public Password(String texto) {
        this.texto = texto;
        caracteres = obterListaCaracteres();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Character> getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(List<Character> caracteres) {
        this.caracteres = caracteres;
    }

    public int tamanhoTexto() {
        return texto.length();
    }

    private List<Character> obterListaCaracteres() {
        return texto.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public int totalCaracteres() {
        return texto.toCharArray().length;
    }

    public long letrasMaiusculas() {
        return caracteres.stream().filter(Character::isUpperCase).count();
    }

    public long letrasMinusculas() {
        return caracteres.stream().filter(Character::isLowerCase).count();
    }

    public long numeros() {
        return caracteres.stream().filter(Character::isDigit).count();
    }

    public long simbolos() {
        return caracteres.stream().filter(a -> !Character.isDigit(a) && !Character.isAlphabetic(a)).count();
    }
}
