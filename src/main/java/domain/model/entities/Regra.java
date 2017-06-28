package domain.model.entities;

import domain.model.enumeradores.TipoRegra;

public abstract class Regra {

    public Regra(String descricao, TipoRegra tipoRegra, Password password) {
        this.descricao = descricao;
        this.tipoRegra = tipoRegra;
        this.password = password;
    }

    protected Password password;
    private String descricao;
    private TipoRegra tipoRegra;
    private long quantidade;
    private double pontuacao;

    public Password getPassword() {
        return password;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoRegra getTipoRegra() {
        return tipoRegra;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public abstract long obterQuantidade();

    public abstract double calcularPontuacao();
}
