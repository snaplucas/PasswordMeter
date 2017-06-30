package domain.model.specifications;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;

public abstract class Regra {

    public Regra(String descricao, TipoRegra tipoRegra) {
        this.descricao = descricao;
        this.tipoRegra = tipoRegra;
    }

    private String descricao;
    private TipoRegra tipoRegra;

    public String getDescricao() {
        return descricao;
    }

    public TipoRegra getTipoRegra() {
        return tipoRegra;
    }

    public abstract long obterQuantidade(Password password);

    public abstract double calcularPontuacao(Password password);
}
