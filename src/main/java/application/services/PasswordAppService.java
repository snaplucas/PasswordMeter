package application.services;

import application.dto.PasswordDto;
import application.dto.RegraDto;
import application.enumeradores.Complexidade;
import application.interfaces.IPasswordAppService;
import domain.model.entities.Password;
import domain.model.interfaces.IPasswordService;
import domain.model.specifications.Regra;

import java.util.List;
import java.util.stream.Collectors;

public class PasswordAppService implements IPasswordAppService {

    private final IPasswordService passwordService;
    private Password password;

    public PasswordAppService(IPasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Override
    public PasswordDto avaliarPassword(String texto) {
        Password password = new Password(texto);
        this.password = password;
        PasswordDto passwordDto = new PasswordDto();

        passwordDto.setPontuacao(limitesPontuacao(passwordService.calcularPontuacaoTotal(password)));
        passwordDto.setComplexidade(calcularComplexidade(passwordDto.getPontuacao()));
        passwordDto.setRegras(obterRegrasDto(passwordService.getRegras()));

        return passwordDto;
    }

    private double limitesPontuacao(double pontuacao) {
        if (pontuacao > 100) {
            return 100;
        } else if (pontuacao < 0) {
            return 0;
        }
        return pontuacao;
    }

    private Complexidade calcularComplexidade(double pontuacao) {
        Complexidade complexidade;
        if (pontuacao < 20) {
            complexidade = Complexidade.MUITO_FRACA;
        } else if (pontuacao < 40) {
            complexidade = Complexidade.FRACA;
        } else if (pontuacao < 60) {
            complexidade = Complexidade.BOA;
        } else if (pontuacao < 80) {
            complexidade = Complexidade.FORTE;
        } else {
            complexidade = Complexidade.MUITO_FORTE;
        }
        return complexidade;
    }

    private List<RegraDto> obterRegrasDto(List<Regra> regras) {
        return regras.stream().map(this::adapterRegraDto).collect(Collectors.toList());
    }

    private RegraDto adapterRegraDto(Regra regra) {
        RegraDto regraDto = new RegraDto();
        regraDto.setQuantidade(regra.obterQuantidade(password));
        regraDto.setPontuacao(regra.calcularPontuacao(password));
        regraDto.setDescricao(regra.getDescricao());
        regraDto.setTipoRegra(regra.getTipoRegra());
        return regraDto;
    }
}
