package domain.model.entities;

import domain.model.enumeradores.TipoRegra;
import domain.model.specifications.Regra;
import domain.model.specifications.adicoes.*;
import domain.model.specifications.deducoes.*;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoPassword {

    public ValidacaoPassword(Password password) {
        regras = new ArrayList<>();

        Regra letrasMaiusculas = new LetrasMaiusculas("Letras Maiusculas", TipoRegra.ADICAO, password);
        Regra letrasMinusculas = new LetrasMinusculas("Letras Minusculas", TipoRegra.ADICAO, password);
        Regra mediaNumerosSimbolos = new MediaNumeroSimbolos("Media Numeros e Simbolos", TipoRegra.ADICAO, password);
        Regra numeroCaracteres = new NumeroCaracteres("Numero Caracteres", TipoRegra.ADICAO, password);
        Regra numeros = new Numeros("Numeros", TipoRegra.ADICAO, password);
        Regra requisitos = new Requisitos("Requisitos", TipoRegra.ADICAO, password);
        Regra Simbolos = new Simbolos("Simbolos", TipoRegra.ADICAO, password);

        Regra caracteresRepetidos = new CaracteresRepetidos("Caracteres Repetidos", TipoRegra.DEDUCAO, password);
        Regra letrasConsecutivasMaiusculas = new LetrasConsecutivasMaiusculas("Letras Consecutivas Maiusculas", TipoRegra.DEDUCAO, password);
        Regra letrasConsecutivasMinusculas = new LetrasConsecutivasMinusculas("Letras Consecutivas Minusculas", TipoRegra.DEDUCAO, password);
        Regra letrasSequenciais = new LetrasSequenciais("Letras Sequenciais", TipoRegra.DEDUCAO, password);
        Regra numerosConsecutivos = new NumerosConsecutivos("Numeros Consecutivos", TipoRegra.DEDUCAO, password);
        Regra numerosSequenciais = new NumerosSequenciais("Numeros Sequenciais", TipoRegra.DEDUCAO, password);
        Regra simbolosSequenciais = new SimbolosSequenciais("Simbolos Sequenciais", TipoRegra.DEDUCAO, password);
        Regra somenteLetras = new SomenteLetras("Somente Letras", TipoRegra.DEDUCAO, password);
        Regra somenteNumeros = new SomenteNumeros("Somente Numeros", TipoRegra.DEDUCAO, password);

        regras.add(letrasMaiusculas);
        regras.add(letrasMinusculas);
        regras.add(mediaNumerosSimbolos);
        regras.add(numeroCaracteres);
        regras.add(numeros);
        regras.add(requisitos);
        regras.add(Simbolos);
        regras.add(caracteresRepetidos);
        regras.add(letrasConsecutivasMaiusculas);
        regras.add(letrasConsecutivasMinusculas);
        regras.add(letrasSequenciais);
        regras.add(numerosConsecutivos);
        regras.add(numerosSequenciais);
        regras.add(simbolosSequenciais);
        regras.add(somenteLetras);
        regras.add(somenteNumeros);
    }

    private List<Regra> regras;

    public List<Regra> getRegras() {
        return regras;
    }

    public double pontuacaoTotal() {
        double adicoes = regras.stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.ADICAO)
                .mapToDouble(Regra::calcularPontuacao)
                .sum();

        double deducoes = regras.stream()
                .filter(a -> a.getTipoRegra() == TipoRegra.DEDUCAO)
                .mapToDouble(Regra::calcularPontuacao)
                .sum();

        return adicoes - deducoes;
    }
}
