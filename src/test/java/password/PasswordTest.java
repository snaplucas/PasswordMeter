package password;

import application.dto.PasswordDto;
import application.enumeradores.Complexidade;
import application.interfaces.IPasswordAppService;
import domain.model.entities.Password;
import domain.model.interfaces.IPasswordService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import port.adapter.AppStart;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {AppStart.class})
public class PasswordTest {

    @Autowired
    private IPasswordService passwordService;

    @Autowired
    private IPasswordAppService passwordAppService;

    @Test
    public void pontuacaoTest_1() {
        Password password = new Password("aasdsq1231ascas");
        double pontuacao = passwordService.calcularPontuacaoTotal(password);
        Assert.assertEquals(63.0, pontuacao, 0.0);
    }

    @Test
    public void pontuacaoTest_2() {
        Password password = new Password("23421qw$");
        double pontuacao = passwordService.calcularPontuacaoTotal(password);
        Assert.assertEquals(72.0, pontuacao, 0.0);
    }

    @Test
    public void pontuacaoTest_3() {
        Password password = new Password("123qw");
        double pontuacao = passwordService.calcularPontuacaoTotal(password);
        Assert.assertEquals(33, pontuacao, 0.0);
    }

    @Test
    public void complexidadeTest_1() {
        PasswordDto passwordDto = passwordAppService.avaliarPassword("aaa");
        Assert.assertEquals(passwordDto.getPontuacao(), 0.0, 0.0);
        Assert.assertEquals(passwordDto.getComplexidade(), Complexidade.MUITO_FRACA);
    }

    @Test
    public void complexidadeTest_2() {
        PasswordDto passwordDto = passwordAppService.avaliarPassword("¨GJ(*");
        Assert.assertEquals(passwordDto.getPontuacao(), 44.0, 0.0);
        Assert.assertEquals(passwordDto.getComplexidade(), Complexidade.BOA);
    }

    @Test
    public void complexidadeTest_3() {
        PasswordDto passwordDto = passwordAppService.avaliarPassword("a@ne0124nq34Q");
        Assert.assertEquals(passwordDto.getPontuacao(), 100.0, 0.0);
        Assert.assertEquals(passwordDto.getComplexidade(), Complexidade.MUITO_FORTE);
    }
}
