package br.ufscar.dc.compiladores.t3;

import java.util.HashMap;


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
}
