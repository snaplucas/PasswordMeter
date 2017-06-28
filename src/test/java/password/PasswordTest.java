package password;

import domain.model.entities.Password;
import domain.model.entities.ValidacaoPassword;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordTest {

    @Test
    public void removerMedio() {
        List<Character> list = Arrays.asList('a', 'b', '1', '1', 'a', 'b');
        List<Character> characterList = list.stream().skip(1).collect(Collectors.toList());
        characterList.remove(characterList.size() - 1);

        System.out.println(characterList);
    }

    @Test
    public void minusculasConsecutivas() {
        List<Character> list = Arrays.asList('a', 'b', 'c', '1', '1', 'a', 'b', 'd', 'E');

        int ocorrencias = 0;
        int minusculas = -1;

        for (Character c : list) {
            if (Character.isLowerCase(c)) {
                minusculas++;
            } else {
                minusculas = -1;
            }

            if (minusculas > 0) {
                ocorrencias++;
            }
        }
        System.out.println(ocorrencias);
    }

    @Test
    public void pontuacaoTest() {
        Password password = new Password("aaaA");

        ValidacaoPassword validacaoPassword = new ValidacaoPassword(password);

        System.out.println(validacaoPassword.calcularPontuacaoTotal());
    }
}
