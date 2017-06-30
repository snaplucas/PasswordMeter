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
        List<Character> listaCaracteres = password.getCaracteres();
        double tamanhoLista = listaCaracteres.size();

        for (int a = 0; a < tamanhoLista; a++) {
            boolean caracterExiste = false;
            for (int b = 0; b < tamanhoLista; b++) {
                if (listaCaracteres.get(a) == listaCaracteres.get(b) && a != b) {
                    caracterExiste = true;
                    pontuacao += Math.abs(tamanhoLista / (b - a));
                }
            }
            if (caracterExiste) {
                quantidade++;
                double unicos = tamanhoLista - quantidade;
                pontuacao = unicos > 0 ? Math.ceil(pontuacao / unicos) : Math.ceil(pontuacao);
            }
        }
        return pontuacao;
    }
}
