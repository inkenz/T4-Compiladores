package br.ufscar.dc.compiladores.t4;

import java.util.LinkedList;

public class Escopo {
    private LinkedList<TabelaDeSimbolos> pilhaDeTabelas;

    public Escopo(){
        pilhaDeTabelas = new LinkedList<TabelaDeSimbolos>();
        criarNovoEscopo();
    }

    public void criarNovoEscopo(){
        pilhaDeTabelas.push(new TabelaDeSimbolos());
    }

    public void removerEscopo(){
        pilhaDeTabelas.pop();
    }

    public TabelaDeSimbolos escopoAtual(){
        return pilhaDeTabelas.peek();
    }

    public TabelaDeSimbolos primeiroEscopo(){
        return pilhaDeTabelas.getLast();
    }

    public LinkedList<TabelaDeSimbolos> recuperarTodosEscopos(){
        return pilhaDeTabelas;
    }
}