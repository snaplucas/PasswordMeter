package domain.model.specifications;

import domain.model.entities.Password;
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

    public void setPassword(Password password) {
        this.password = password;
    }

    public long getQuantidade() {
        return obterQuantidade();
    }

    public double getPontuacao() {
        return calcularPontuacao();
    }

    public abstract long obterQuantidade();

    public abstract double calcularPontuacao();
}
