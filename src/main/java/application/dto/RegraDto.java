package application.dto;

import domain.model.enumeradores.TipoRegra;

public class RegraDto {

    private String descricao;
    private TipoRegra tipoRegra;
    private long quantidade;
    private double pontuacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoRegra getTipoRegra() {
        return tipoRegra;
    }

    public void setTipoRegra(TipoRegra tipoRegra) {
        this.tipoRegra = tipoRegra;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }
}


