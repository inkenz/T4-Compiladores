package br.ufscar.dc.compiladores.t4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        /*
        System.out.print("NOME: "+nome+"\n");
        for(String key: tabela.keySet()){
            System.out.print(key+"\n");
        }
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        */
        return tabela.get(nome).tipo;
    }   

    public List<Tipo> retornar_todos_parametros_funcao(String nomeFuncao){
        List<Tipo> parametrosTipo = new ArrayList<>();

        for(String parametro : tabela.keySet()){
            if(!parametro.equals(nomeFuncao) && !parametro.contains("return"))
                parametrosTipo.add(tabela.get(parametro).tipo);
        }

        return parametrosTipo;
    }

    public List<String> retornar_todas_occorencias_registro(String nome){
        List<String> nomes = new ArrayList<>();

        for(String variavel : tabela.keySet()){
            if(variavel.contains(nome + "."))
                nomes.add(variavel);
        }

        return nomes;
    }

    public String existe_array(String nome){
        for(String variavel : tabela.keySet()){
            if(variavel.contains(nome+"["))
                return variavel;
        }

        return null;
    }
}
