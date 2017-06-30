package domain.model.specifications.deducoes;

import domain.model.entities.Password;
import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;

import java.util.List;

public class CaracteresRepetidos extends Regra {

    public CaracteresRepetidos(String descricao, TipoRegra tipoRegra) {
        super(descricao, tipoRegra);
    }

    @Override
    public long obterQuantidade(Password password) {
        int quantidade = 0;
        List<Character> list = password.getCaracteres();

        for (int a = 0; a < list.size(); a++) {
            boolean caracterExiste = false;
            for (int b = 0; b < list.size(); b++) {
                if (list.get(a) == list.get(b) && a != b) {
                    caracterExiste = true;
                }
            }
            if (caracterExiste) {
                quantidade++;
            }
        }
        return quantidade;
    }

    @Override
    public double calcularPontuacao(Password password) {
        double pontuacao = 0;
        int quantidade = 0;
        List<Character> list = password.getCaracteres();

        for (int a = 0; a < list.size(); a++) {
            boolean caracterExiste = false;
            for (int b = 0; b < list.size(); b++) {
                if (list.get(a) == list.get(b) && a != b) {
                    caracterExiste = true;
                    pontuacao += Math.abs(list.size() / (b - a));
                }
            }
            if (caracterExiste) {
                quantidade++;
                int unicos = list.size() - quantidade;
                pontuacao = unicos > 0 ? Math.ceil(pontuacao / unicos) : Math.ceil(pontuacao);
            }
        }
        return pontuacao;
    }
}
