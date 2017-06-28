package application.dto;

import application.enumeradores.Complexidade;
import domain.model.entities.ValidacaoPassword;

public class PasswordDto {

    private double pontuacao;
    private Complexidade complexidade;
    private ValidacaoPassword validacaoPassword;

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }
}
