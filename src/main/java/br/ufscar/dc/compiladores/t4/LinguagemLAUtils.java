package br.ufscar.dc.compiladores.t4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import br.ufscar.dc.compiladores.t4.LAParser.TipoContext;
import br.ufscar.dc.compiladores.t4.LAParser.Tipo_basicoContext;
import br.ufscar.dc.compiladores.t4.LAParser.Tipo_estendidoContext;
import br.ufscar.dc.compiladores.t4.LAParser.VariavelContext;
import br.ufscar.dc.compiladores.t4.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.t4.LAParser.Termo_logicoContext;
import br.ufscar.dc.compiladores.t4.LAParser.Fator_logicoContext;
import br.ufscar.dc.compiladores.t4.LAParser.Parcela_logicaContext;
import br.ufscar.dc.compiladores.t4.LAParser.Exp_relacionalContext;
import br.ufscar.dc.compiladores.t4.LAParser.Exp_aritmeticaContext;
import br.ufscar.dc.compiladores.t4.LAParser.TermoContext;
import br.ufscar.dc.compiladores.t4.LAParser.FatorContext;
import br.ufscar.dc.compiladores.t4.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.t4.LAParser.ParametroContext;
import br.ufscar.dc.compiladores.t4.LAParser.ParcelaContext;
import br.ufscar.dc.compiladores.t4.LAParser.Parcela_nao_unarioContext;
import br.ufscar.dc.compiladores.t4.LAParser.Parcela_unarioContext;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.Tipo;


public class LinguagemLAUtils {
    public static List<String> errosSemanticos = new ArrayList<>();
    
    public static void adicionarErroSemantico(Token t, String mensagem) 
    {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }

    public static Void verificar(Escopo escopos, ExpressaoContext ctxExpressao, Exp_aritmeticaContext ctx){
        Tipo tipo;

        if(ctx.getText().contains("(") && escopos.primeiroEscopo().existe(ctx.getText().split("\\(")[0]))
            tipo = Tipo.FUNCAO;
        else
            tipo = verificarTipo(escopos, ctx);

        if(tipo == Tipo.FUNCAO){
            List<LAParser.ExpressaoContext> expressaoParametros = ctxExpressao.termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0).termo(0).fator(0).parcela(0).parcela_unario().expressao();
            LinkedList<TabelaDeSimbolos> escopoList = escopos.recuperarTodosEscopos();
            String nomeFuncao = ctx.getText().split("\\(")[0];

            boolean achouFuncao = false;
            int contador = 0;

            while(!achouFuncao && contador < escopoList.size()){
                if(escopoList.get(contador).existe(nomeFuncao))
                    achouFuncao = true;
                else
                    contador++;
            }

            if(!achouFuncao)
                adicionarErroSemantico(ctx.start, "identificador " + nomeFuncao + " nao declarado" );
            else{
                TabelaDeSimbolos escopoFuncao = escopoList.get(contador);
                List<Tipo> tipoParametrosFuncao = escopoFuncao.retornar_todos_parametros_funcao(nomeFuncao); 


                if(tipoParametrosFuncao.size() != expressaoParametros.size()){
                    //System.out.println("Aqui erro " + tipoParametrosFuncao + " " + expressaoParametros.size());
                    adicionarErroSemantico(expressaoParametros.get(0).start, "incompatibilidade de parametros na chamada de " + nomeFuncao);
                }
                else{
                    for(int i = 0; i < expressaoParametros.size(); i++){
                        Tipo tipoParametro = verificarTipo(escopos, expressaoParametros.get(i));
                        //System.out.println("AQUI -> " + tipoParametrosFuncao.get(i) +  " " + expressaoParametros.get(i).getText() + " " + tipoParametro);

                        if(tipoParametro == Tipo.FUNCAO){
                            //System.out.println("👀👀 -> " + verificarTipo(escopos, expressaoParametros.get(i)));
                        }
                        else if(tipoParametro != tipoParametrosFuncao.get(i)){
                            adicionarErroSemantico(expressaoParametros.get(i).start, "incompatibilidade de parametros na chamada de " + nomeFuncao);
                        }
                    }
                }
            }
        }
        return null;
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
        if(ctx.VERDADEIRO() != null || ctx.FALSO() != null) return Tipo.LOGICO;
        
        
        return verificarTipo(escopos, ctx.exp_relacional());
    }
    
    public static Tipo verificarTipo(Escopo escopos, Exp_relacionalContext ctx) {
        Tipo ret = null;
        
        if(ctx.op_relacional() != null) return Tipo.LOGICO;
        
        for (Exp_aritmeticaContext ta : ctx.exp_aritmetica()) {
            Tipo aux = verificarTipo(escopos, ta); 
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
            if(aux == Tipo.FUNCAO){
                for(TabelaDeSimbolos escopo : escopos.recuperarTodosEscopos()){
                    if(!escopo.equals(escopos.primeiroEscopo()) && escopo.existe(ta.getText().split("\\(")[0])){
                        // Buscando o tipo do return da função
                        aux = escopo.verificar(ta.getText().split("\\(")[0]+".return");
                    }
                }
            }
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
            // Tipo ret = null;
            // ret = verificarTipo(escopos, ctx.IDENT().getText());
            // for (ExpressaoContext fa : ctx.expressao()) {
            //     Tipo aux = verificarTipo(escopos, fa);
            //     if (ret == null) {
            //         ret = aux;
            //     } else if (ret != aux && aux != Tipo.INVALIDO) {
            //         ret = Tipo.INVALIDO;
            //     }
            // }
            return Tipo.FUNCAO;
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
        if(ctx.ENDERECO() != null) return Tipo.PONTEIRO;
        else return Tipo.LITERAL;    
    }
    
    public static Tipo verificarTipo(Tipo_estendidoContext ctx){
        if(ctx.tipo_basico() != null){
            if(ctx.tipo_basico().getText().toUpperCase().equals("LITERAL"))
                return Tipo.LITERAL;
            if(ctx.tipo_basico().getText().toUpperCase().equals("INTEIRO"))
                return Tipo.INTEIRO;
            if(ctx.tipo_basico().getText().toUpperCase().equals("REAL"))
                return Tipo.REAL;
            return Tipo.LOGICO;
        }
        return null; // caso onde seja uma identificador, talvez seja melhor elaborar ele
    }
    
    public static Tipo verificarTipo(Escopo escopos, String nomeVar) {
        Tipo tipo = null;
        
        for(TabelaDeSimbolos tabela : escopos.recuperarTodosEscopos()){
            if(tabela.existe(nomeVar))
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

    public static Tipo verificarTipo(Escopo escopos, Tipo_estendidoContext ctx)
    {
        Tipo tipo;
        TabelaDeSimbolos tabela = escopos.escopoAtual();
        // Caso haja o simbolo de ponteiro antes é declarado como ponteiro.
        if (ctx.PONTEIRO() != null){
            return Tipo.PONTEIRO;
        }
        else if (ctx.IDENT() != null) {
            if (tabela.existe(ctx.IDENT().getText()))
            {
                tipo = tabela.verificar(ctx.IDENT().getText());
            }
            // Verificando no ultimo escopo, ou seja, no escopo global
            else if(escopos.primeiroEscopo().existe(ctx.IDENT().getText())){
                tipo = escopos.primeiroEscopo().verificar(ctx.IDENT().getText());
            }
            else
            {
                tipo = Tipo.INVALIDO;
            }
        }
        else {
            tipo = verificarTipo(tabela, ctx.tipo_basico());
        }

        
        return tipo;
    }

    

    public static Tipo verificarTipo(Escopo escopos,TipoContext ctx)
    {
       if(ctx.tipo_estendido() != null) return verificarTipo(escopos, ctx.tipo_estendido());
       
       return Tipo.REGISTRO;
    }

    public static Tipo verificarTipo(Escopo escopos, VariavelContext ctx)
    {
        TabelaDeSimbolos tabela = escopos.escopoAtual();
        Tipo tipo = verificarTipo(escopos, ctx.tipo());
        ctx.identificador().forEach(ident -> {
            //System.out.println("verificando ident -> " +ident.getText());
            if (tabela.existe(ident.getText())  || escopos.primeiroEscopo().existe(ident.getText()) /*verificando se existe no primeiro escopo, ou seja, no escopo global*/){
                //System.out.println("Erro -> " + ident.getText());
                adicionarErroSemantico(
                    ident.start,
                    "identificador " + ident.getText() + " ja declarado anteriormente"
                    );
            }
            else{
                tabela.inserir(ident.getText(), tipo);
                if(tipo == Tipo.REGISTRO){
                    TabelaDeSimbolos tabelaRegistro = null;

                    if(tabela.existe(ctx.tipo().getText()))
                        tabelaRegistro = tabela;
                    else if(escopos.primeiroEscopo().existe(ctx.tipo().getText()))
                        tabelaRegistro = escopos.primeiroEscopo();

                    if (tabelaRegistro != null){
                        String tipoRegistro = ctx.tipo().getText();
                        
                        List<String> variaveis = tabelaRegistro.retornar_todas_occorencias_registro(tipoRegistro);
                        //System.out.println(tipoRegistro + " " + variaveis);

                        for(String variavel : variaveis){
                            //System.out.println("🙄🙄🙄🙄 -> " + ident.getText() + "." + variavel+ " " + tabelaRegistro.verificar(variavel));
                            tabela.inserir(ident.getText() + "." + variavel.split("\\.")[1], tabelaRegistro.verificar(variavel));
                            
                        }

                    }
                    else if(ctx.tipo().registro() != null){
                        for(int i = 0; i < ctx.tipo().registro().variavel().size(); i++){
                            Tipo tipoRegistro = verificarTipo(escopos, ctx.tipo().registro().variavel(i).tipo());
                            for(int j = 0; j < ctx.tipo().registro().variavel(i).identificador().size(); j++){
                                //System.out.println("AQUI Registro -> " + ident.getText() + "." + ctx.tipo().registro().variavel(i).identificador(j).getText()+ " " + tipoRegistro);
                                tabela.inserir(ident.getText() + "." + ctx.tipo().registro().variavel(i).identificador(j).getText(), tipoRegistro);
                            }
                        }
                    }
                }
            }
        });

        if (tipo == Tipo.INVALIDO && ctx.tipo() != null){
            adicionarErroSemantico(ctx.tipo().start, "tipo " + ctx.tipo().getText() + " nao declarado" );
        }

        return tipo;
    }

    public static Tipo verificarTipo(Escopo escopos, ParametroContext ctx)
    {
        TabelaDeSimbolos tabela = escopos.escopoAtual();
        Tipo tipo = verificarTipo(escopos, ctx.tipo_estendido());

        ctx.identificador().forEach(ident -> {
            //System.out.println("ident -> " +ident.getText());
            if (tabela.existe(ident.getText())){
                adicionarErroSemantico(
                    ident.start,
                    "identificador " + ident.getText() + " ja declarado anteriormente"
                    );
            }
            else{
                //System.out.println("adicionei variavel -> " + ident.getText() + " " + tipo);
                tabela.inserir(ident.getText(), tipo);
                if(tipo == Tipo.REGISTRO){
                    TabelaDeSimbolos tabelaRegistro = null;
                    if (tabela.existe(ctx.tipo_estendido().getText()))
                        tabelaRegistro = tabela;
                    else if(escopos.primeiroEscopo().existe(ctx.tipo_estendido().getText()))
                        tabelaRegistro = escopos.primeiroEscopo();
                    
                    if(tabelaRegistro != null){
                        String tipoRegistro = ctx.tipo_estendido().getText();

                        List<String> variaveis = tabelaRegistro.retornar_todas_occorencias_registro(tipoRegistro);
                        //System.out.println(tipoRegistro + " " + variaveis);

                        for(String variavel : variaveis){
                            //System.out.println("AQUI ADICIONANDO -> " + ident.getText() + "." + variavel.split("\\.")[1] + " " + tabelaRegistro.verificar(variavel));
                            tabela.inserir(ident.getText() + "." + variavel.split("\\.")[1], tabelaRegistro.verificar(variavel));
                            
                        }

                    }
                }
            }
        });

        if (tipo == Tipo.INVALIDO && ctx.tipo_estendido() != null){
            adicionarErroSemantico(ctx.tipo_estendido().start, "tipo " + ctx.tipo_estendido().getText() + " nao declarado" );
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
