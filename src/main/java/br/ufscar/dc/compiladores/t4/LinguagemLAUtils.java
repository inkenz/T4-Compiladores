package br.ufscar.dc.compiladores.t3;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t3.LAParser.TipoContext;
import br.ufscar.dc.compiladores.t3.LAParser.Tipo_basicoContext;
import br.ufscar.dc.compiladores.t3.LAParser.Tipo_estendidoContext;
import br.ufscar.dc.compiladores.t3.LAParser.VariavelContext;
import br.ufscar.dc.compiladores.t3.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.t3.LAParser.Termo_logicoContext;
import br.ufscar.dc.compiladores.t3.LAParser.Fator_logicoContext;
import br.ufscar.dc.compiladores.t3.LAParser.Parcela_logicaContext;
import br.ufscar.dc.compiladores.t3.LAParser.Exp_relacionalContext;
import br.ufscar.dc.compiladores.t3.LAParser.Exp_aritmeticaContext;
import br.ufscar.dc.compiladores.t3.LAParser.TermoContext;
import br.ufscar.dc.compiladores.t3.LAParser.FatorContext;
import br.ufscar.dc.compiladores.t3.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.t3.LAParser.ParcelaContext;
import br.ufscar.dc.compiladores.t3.LAParser.Parcela_nao_unarioContext;
import br.ufscar.dc.compiladores.t3.LAParser.Parcela_unarioContext;


import br.ufscar.dc.compiladores.t3.TabelaDeSimbolos.Tipo;


public class LinguagemLAUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) 
    {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    
    public static TabelaDeSimbolos.Tipo verificarTipo(Escopo escopos, ExpressaoContext ctx) {
        Tipo ret = null;
        for (Termo_logicoContext ta : ctx.termo_logico()) {
            Tipo aux = verificarTipo(escopos, ta);
            if (ret == null) {
                ret = aux;
            } if(ret == Tipo.LOGICO){
                return Tipo.LOGICO;
            }else if (ret != aux && aux != Tipo.INVALIDO) {
 
                ret = Tipo.INVALIDO;
            }
        }

        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, Termo_logicoContext ctx) {
        Tipo ret = null;
        for (Fator_logicoContext ta : ctx.fator_logico()) {
            Tipo aux = verificarTipo(escopos, ta);
            //System.out.print(ctx.getText() + " 1 " + aux +"    \n");
            if (ret == null) {
                ret = aux;
            } if(ret == Tipo.LOGICO){
                return Tipo.LOGICO;
            }else if (ret != aux && aux != Tipo.INVALIDO) {
                ret = Tipo.INVALIDO;
            }
        }

        //SemanticoUtils.adicionarErroSemantico(ctx.start, "8" +ctx.getText() + ret);
        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, Fator_logicoContext ctx) {
        if(ctx.NAO() != null) return Tipo.LOGICO;
        
        return verificarTipo(escopos, ctx.parcela_logica());
    }
    
    public static Tipo verificarTipo(Escopo escopos, Parcela_logicaContext ctx) {
        Tipo ret = null;
        
        if(ctx.VERDADEIRO() != null || ctx.FALSO() != null) return Tipo.LOGICO;
        
        
        return verificarTipo(escopos, ctx.exp_relacional());
    }
    
    public static Tipo verificarTipo(Escopo escopos, Exp_relacionalContext ctx) {
        Tipo ret = null;
        
        if(ctx.op_relacional() != null) return Tipo.LOGICO;
        
        for (Exp_aritmeticaContext ta : ctx.exp_aritmetica()) {
            Tipo aux = verificarTipo(escopos, ta);
            //System.out.print(ctx.getText() + " 3 " + aux +"    \n");
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tipo.INVALIDO) {
                
                ret = Tipo.INVALIDO;
            }
        }

        
        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, Exp_aritmeticaContext ctx) {
        Tipo ret = null;
        for (TermoContext ta : ctx.termo()) {
            Tipo aux = verificarTipo(escopos, ta);
            //System.out.print(ctx.getText() + " 4 " + aux +"    \n");
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tipo.INVALIDO) {
                ret = Tipo.INVALIDO;
            }
        }

        //SemanticoUtils.adicionarErroSemantico(ctx.start, "8" +ctx.getText() + ret);
        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, TermoContext ctx) {
        Tipo ret = null;
        for (FatorContext ta : ctx.fator()) {
            Tipo aux = verificarTipo(escopos, ta);
            //System.out.print(ctx.getText() + " 5 " + aux +"    ");
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tipo.INVALIDO) {
                //System.out.print(ctx.getText() +"  "+ret+"      "+aux+"\n");
                if(ret == Tipo.REAL && aux == Tipo.INTEIRO) ret = Tipo.REAL;
                else ret = Tipo.INVALIDO;
            }
        }

        //SemanticoUtils.adicionarErroSemantico(ctx.start, "8" +ctx.getText() + ret);
        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, FatorContext ctx) {
        Tipo ret = null;
        for (ParcelaContext ta : ctx.parcela()) {
            Tipo aux = verificarTipo(escopos, ta);
            if (ret == null) {
                ret = aux;
            } else if (ret != aux && aux != Tipo.INVALIDO) {
                ret = Tipo.INVALIDO;
            }
        }

        //SemanticoUtils.adicionarErroSemantico(ctx.start, "8" +ctx.getText() + ret);
        return ret;
    }
    
    public static Tipo verificarTipo(Escopo escopos, ParcelaContext ctx) {
        if(ctx.parcela_unario() != null) return verificarTipo(escopos, ctx.parcela_unario());
        else return verificarTipo(escopos, ctx.parcela_nao_unario());
    }
    
    public static Tipo verificarTipo(Escopo escopos, Parcela_unarioContext ctx) {
        if(ctx.NUM_INT() != null) return Tipo.INTEIRO;
        else if(ctx.NUM_REAL() != null) return Tipo.REAL;
        else if(ctx.identificador() != null) return verificarTipo(escopos, ctx.identificador());
        else if(ctx.IDENT() != null){
            Tipo ret = null;
            ret = verificarTipo(escopos, ctx.IDENT().getText());
            for (ExpressaoContext fa : ctx.expressao()) {
                Tipo aux = verificarTipo(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != Tipo.INVALIDO) {
                    ret = Tipo.INVALIDO;
                }
            }
            return ret;
        } else{
            Tipo ret = null;
            for (ExpressaoContext fa : ctx.expressao()) {
                Tipo aux = verificarTipo(escopos, fa);
                if (ret == null) {
                    ret = aux;
                } else if (ret != aux && aux != Tipo.INVALIDO) {
                    ret = Tipo.INVALIDO;
                }
            }
            return ret;
        } 
    }
    
    public static Tipo verificarTipo(Escopo escopos, Parcela_nao_unarioContext ctx) {
        Tipo ret = null;
        if(ctx.ENDERECO() != null) return Tipo.PONTEIRO;
        else return Tipo.LITERAL;    
    }
    
    public static Tipo verificarTipo(Escopo escopos, String nomeVar) {
        Tipo tipo = null;
        
        for(TabelaDeSimbolos tabela : escopos.recuperarTodosEscopos()){
            tipo = tabela.verificar(nomeVar);
            if(tipo != null) break;
        }
        return tipo;
    }
    
    public static Tipo verificarTipo(TabelaDeSimbolos tabela, Tipo_basicoContext ctx)
    {
        if (ctx.LITERAL() != null){
            return Tipo.LITERAL;
        }
        else if (ctx.INTEIRO() != null){
            return Tipo.INTEIRO;
        }
        else if (ctx.LOGICO() != null){
            return Tipo.LOGICO;
        }
        else if (ctx.REAL() != null){
            return Tipo.REAL;
        }
        else {
            return Tipo.INVALIDO;
        }
    }

    public static Tipo verificarTipo(TabelaDeSimbolos tabela, Tipo_estendidoContext ctx)
    {
        Tipo tipo;

        // Caso haja o simbolo de ponteiro antes é declarado como ponteiro.
        if (ctx.PONTEIRO() != null){
            return Tipo.PONTEIRO;
        }

        // Caso seja um identificador, é um registro,
        // então é necessário ver se o tipo de registro existe.
        else if (ctx.IDENT() != null) {
            if (!tabela.existe(ctx.IDENT().getText())){
                return Tipo.INVALIDO;
            }
            else{
                tipo = Tipo.REGISTRO;
            }
        }
        
        // É uma variável de tipo básico.
        else {
            tipo = verificarTipo(tabela, ctx.tipo_basico());
        }

        
        return tipo;
    }

    public static Tipo verificarTipo(TabelaDeSimbolos tabela,TipoContext ctx)
    {
        // if (ctx.tipo_variavel() != null){
            return verificarTipo(tabela, ctx.tipo_estendido());
        // }
        // else{
        //     return verificarTipo(tabela, ctx.registro());
        // }
    }

    public static Tipo verificarTipo(TabelaDeSimbolos tabela, VariavelContext ctx)
    {
        Tipo tipo = verificarTipo(tabela, ctx.tipo());

        ctx.identificador().forEach(ident -> {
            if (tabela.existe(ident.getText())){
                System.out.print(ctx.getText());
                adicionarErroSemantico(
                    ident.start,
                    "identificador " + ident.getText() + " ja declarado anteriormente"
                    );
            }
            else{
                tabela.inserir(ident.getText(), tipo);
            }
        });

        if (tipo == Tipo.INVALIDO){
            adicionarErroSemantico(ctx.tipo().start, "tipo " + ctx.tipo().getText() + " nao declarado" );
        }

        return tipo;
    }
    
    public static Tipo verificarTipo(Escopo escopos, IdentificadorContext ctx) {
        String nomeVar = "";
        Tipo ret = Tipo.INVALIDO;
        for(int i = 0; i < ctx.IDENT().size(); i++){
            nomeVar += ctx.IDENT(i).getText();
            if(i != ctx.IDENT().size() - 1){
                nomeVar += ".";
            }
        }
        for(TabelaDeSimbolos tabela : escopos.recuperarTodosEscopos()){
            if (tabela.existe(nomeVar)) {
                ret = verificarTipo(escopos, nomeVar);
                if(ret != null) break;
            }
        }
        //System.out.println(nomeVar);
        return ret;
    }
    
}
