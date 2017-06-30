package application.dto;

import application.enumeradores.Complexidade;

import java.util.List;

public class PasswordDto {

    private double pontuacao;
    private Complexidade complexidade;
    private List<RegraDto> regras;

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

    public List<RegraDto> getRegras() {
        return regras;
    }

    public void setRegras(List<RegraDto> regras) {
        this.regras = regras;
    }
}
