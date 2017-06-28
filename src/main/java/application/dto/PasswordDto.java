package application.dto;

import application.enumeradores.Complexidade;
import domain.model.entities.ValidacaoPassword;
import domain.model.specifications.Regra;

import java.util.List;

public class PasswordDto {

    private double pontuacao;
    private Complexidade complexidade;
    private List<Regra> regras;

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Complexidade getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(Complexidade complexidade) {
        this.complexidade = complexidade;
    }

    public List<Regra> getRegras() {
        return regras;
    }

    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }
}
