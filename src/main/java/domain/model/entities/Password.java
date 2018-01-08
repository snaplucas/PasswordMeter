package domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    public Password(String texto) {
        this.texto = texto != null ? texto : "";
        caracteres = obterListaCaracteres();
    }

    private String texto;
    private List<Character> caracteres;

    public int tamanhoTexto() {
        return texto.length();
    }

    private List<Character> obterListaCaracteres() {
        return texto.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }

    public int totalCaracteres() {
        return texto.toCharArray().length;
    }

    public long totalLetras() {
        return caracteres.stream().filter(Character::isAlphabetic).count();
    }

    public long totalLetrasMaiusculas() {
        return caracteres.stream().filter(Character::isUpperCase).count();
    }

    public long totalLetrasMinusculas() {
        return caracteres.stream().filter(Character::isLowerCase).count();
    }

    public long totalNumeros() {
        return caracteres.stream().filter(Character::isDigit).count();
    }

    public long totalSimbolos() {
        return caracteres.stream().filter(a -> !Character.isDigit(a) && !Character.isAlphabetic(a)).count();
    }
}
