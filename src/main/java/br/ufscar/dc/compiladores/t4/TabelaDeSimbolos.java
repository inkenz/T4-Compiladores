package br.ufscar.dc.compiladores.t4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TabelaDeSimbolos {
    public enum Tipo {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        REGISTRO,
        PONTEIRO,
        FUNCAO,
        PROCEDIMENTO,
        INVALIDO
    }
    
    class EntradaTabelaDeSimbolos {
        Tipo tipo;
       
        private EntradaTabelaDeSimbolos(Tipo tipo) {
            this.tipo = tipo;
        }
    }
    
    private final HashMap<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos(){
        tabela = new HashMap<>();
    }
    
    public void inserir(String nome, Tipo tipo){
        EntradaTabelaDeSimbolos etds = new EntradaTabelaDeSimbolos(tipo);
        
        tabela.put(nome,etds);
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
    public Tipo verificar(String nome) {
        return tabela.get(nome).tipo;
    }   

    public List<String> retornar_todas_occorencias(String nome){
        List<String> nomes = new ArrayList<>();

        for(String variavel : tabela.keySet()){
            if(variavel.contains(nome))
                nomes.add(variavel);
        }

        return nomes;
    }
}
