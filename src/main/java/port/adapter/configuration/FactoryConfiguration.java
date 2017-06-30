package port.adapter.configuration;

import application.interfaces.IPasswordAppService;
import application.services.PasswordAppService;
import domain.model.enumeradores.TipoRegra;
import domain.model.interfaces.IPasswordService;
import domain.model.services.PasswordService;
import domain.model.specifications.Regra;
import domain.model.specifications.adicoes.*;
import domain.model.specifications.deducoes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class FactoryConfiguration {

    @Bean
    public IPasswordAppService getPasswordAppService(IPasswordService passwordService) {
        return new PasswordAppService(passwordService);
    }

    @Bean
    public IPasswordService getPasswordService() {
        return new PasswordService(getRegras());
    }

    @Bean
    public List<Regra> getRegras(){
        return Arrays.asList( new NumeroCaracteres("Numero Caracteres", TipoRegra.ADICAO),
                 new LetrasMaiusculas("Letras Maiusculas", TipoRegra.ADICAO),
                 new LetrasMinusculas("Letras Minusculas", TipoRegra.ADICAO),
                 new Numeros("Numeros", TipoRegra.ADICAO),
                 new Simbolos("Simbolos", TipoRegra.ADICAO),
                 new MediaNumeroSimbolos("Media Numeros e Simbolos", TipoRegra.ADICAO),
                 new Requisitos("Requisitos", TipoRegra.ADICAO),
                 new SomenteLetras("Somente Letras", TipoRegra.DEDUCAO),
                 new SomenteNumeros("Somente Numeros", TipoRegra.DEDUCAO),
                 new CaracteresRepetidos("Caracteres Repetidos", TipoRegra.DEDUCAO),
                 new LetrasConsecutivasMaiusculas("Letras Consecutivas Maiusculas", TipoRegra.DEDUCAO),
                 new LetrasConsecutivasMinusculas("Letras Consecutivas Minusculas", TipoRegra.DEDUCAO),
                 new NumerosConsecutivos("Numeros Consecutivos", TipoRegra.DEDUCAO),
                 new LetrasSequenciais("Letras Sequenciais", TipoRegra.DEDUCAO),
                 new NumerosSequenciais("Numeros Sequenciais", TipoRegra.DEDUCAO),
                 new SimbolosSequenciais("Simbolos Sequenciais", TipoRegra.DEDUCAO));
    }

}
