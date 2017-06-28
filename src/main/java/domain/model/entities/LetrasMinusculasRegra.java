package domain.model.entities;

import domain.model.enumeradores.TipoRegra;

public class LetrasMinusculasRegra extends Regra {

    public LetrasMinusculasRegra(String descricao, TipoRegra tipoRegra, Password password) {
        super(descricao, tipoRegra, password);
    }

    @Override
    public long obterQuantidade() {
        this.setQuantidade(password.totalLetrasMinusculas());
        return this.getQuantidade();
    }

    @Override
    public double calcularPontuacao() {
        if (obterQuantidade() > 0) {
            this.setPontuacao((password.tamanhoTexto() - password.totalLetrasMinusculas()) * 2);
            return (password.tamanhoTexto() - password.totalLetrasMinusculas()) * 2;
        }
        this.setPontuacao(0);
        return 0;
    }
}
