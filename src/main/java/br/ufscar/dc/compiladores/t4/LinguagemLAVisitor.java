package br.ufscar.dc.compiladores.t4;

import static br.ufscar.dc.compiladores.t4.LinguagemLAUtils.adicionarErroSemantico;
import static br.ufscar.dc.compiladores.t4.LinguagemLAUtils.verificarTipo;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.Tipo;
import java.util.LinkedList;
public class LinguagemLAVisitor extends LABaseVisitor<Void>{
    Escopo escopos = new Escopo();


    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) { 
        for(var ctxCmd: ctx.corpo().cmd()){
            if(ctxCmd.cmdRetorne() != null){
                adicionarErroSemantico(ctxCmd.cmdRetorne().getStart(),"comando retorne nao permitido nesse escopo");
            }
        }
        
        for(var ctxDec : ctx.declaracoes().decl_local_global()){
            if(ctxDec.declaracao_global() != null){
                if( ctxDec.declaracao_global().tipo_estendido() == null){
                    for(var ctxCmd: ctxDec.declaracao_global().cmd()){
                        if(ctxCmd.cmdRetorne() != null)
                            adicionarErroSemantico(ctxCmd.cmdRetorne().getStart(),"comando retorne nao permitido nesse escopo");
                    }
                }
            }
        }
        return super.visitPrograma(ctx); 
    }

    @Override
    public Void visitDeclaracoes(LAParser.DeclaracoesContext ctx) 
    {
        escopos.criarNovoEscopo();
        return super.visitDeclaracoes(ctx);
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx)
    {
        TabelaDeSimbolos tabela = escopos.escopoAtual();

        if (ctx.DECLARE() != null)
            verificarTipo(tabela, ctx.variavel());       
        
        else if(ctx.TIPO() != null){
            String nomeVar = ctx.IDENT().getText();
            Tipo tipo = verificarTipo(tabela, ctx.tipo());
            
            if(tabela.existe(nomeVar)){
                System.out.println("Erro -> " + nomeVar);
                adicionarErroSemantico(ctx.start, "identificador " + nomeVar + " ja declarado anteriormente");
            }
            else{
                System.out.println("adicionei declaracao local -> " + nomeVar + " " + tipo);
                tabela.inserir(nomeVar, tipo);
            }
        }
        else if(ctx.CONSTANTE() != null){
            String nomeVar = ctx.IDENT().getText();
            Tipo tipo = verificarTipo(tabela, ctx.tipo_basico());
            
            if(tabela.existe(nomeVar)){
                adicionarErroSemantico(ctx.start, "identificador " + nomeVar + " ja declarado anteriormente");
            }
            else{
                tabela.inserir(nomeVar, tipo);
            }
        }


        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx)
    {
        TabelaDeSimbolos tabela = escopos.escopoAtual();

        if (ctx.PROCEDIMENTO() != null){
            String nomeVar = ctx.IDENT().getText();
            if(tabela.existe(nomeVar))
                adicionarErroSemantico(ctx.start, "identificador " + nomeVar + " ja declarado anteriormente");
            for (int i = 0; i < ctx.parametros().parametro().size(); i++){
                verificarTipo(tabela, ctx.parametros().parametro().get(i));
            }
        }

        else if(ctx.FUNCAO() != null){
            String nomeVar = ctx.IDENT().getText();
            if(tabela.existe(nomeVar))
                adicionarErroSemantico(ctx.start, "identificador " + nomeVar + " ja declarado anteriormente");
            for (int i = 0; i < ctx.parametros().parametro().size(); i++){
                verificarTipo(tabela, ctx.parametros().parametro().get(i));
            }
        }

        return super.visitDeclaracao_global(ctx);
    }

    @Override
    public Void visitRegistro(LAParser.RegistroContext ctx){
        TabelaDeSimbolos tabela = escopos.escopoAtual();
            
        if(ctx.getParent().getParent() instanceof LAParser.Declaracao_localContext){
            LAParser.Declaracao_localContext ctxParent = (LAParser.Declaracao_localContext) ctx.getParent().getParent();

            if(ctxParent.TIPO() != null){
                tabela.inserir(ctxParent.IDENT().getText(), Tipo.REGISTRO);

                for(int i = 0; i < ctxParent.tipo().registro().variavel().size(); i++) {
                    Tipo tipo = verificarTipo(tabela, ctxParent.tipo().registro().variavel(i));
                    
                    for(int j = 0; j < ctxParent.tipo().registro().variavel(i).identificador().size(); j++){
                        System.out.println("adicionei registro -> " + ctxParent.IDENT().getText() + "." + ctxParent.tipo().registro().variavel(i).identificador(j).getText() + " " + tipo);
                        tabela.inserir(ctxParent.IDENT().getText() + "." + ctxParent.tipo().registro().variavel(i).identificador(j).getText(), tipo);

                    }
                }
            }
        }

        /*for(int i = 0; i < ctx.variavel().size(); i++){
            System.out.println("Variavel de registro -> " + ctx.variavel().get(i).getText());
            verificarTipo(tabela, ctx.variavel().get(i));
        }*/
        //System.out.println("Aka -> " + ctx.variavel().get(0).getText());

        return super.visitRegistro(ctx);
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        Tipo tipoExp = verificarTipo(escopos, ctx.expressao());
        boolean error = false;
        String nomeVar = ctx.identificador().getText();
        
        if (tipoExp != Tipo.INVALIDO) {
            for(TabelaDeSimbolos escopo : escopos.recuperarTodosEscopos()){
                if (escopo.existe(nomeVar))  {
                    Tipo tipoVar = verificarTipo(escopos, nomeVar);
                    Boolean varNumeric = tipoVar== Tipo.REAL || tipoVar == Tipo.INTEIRO;
                    Boolean expNumeric = tipoExp == Tipo.REAL || tipoExp == Tipo.INTEIRO;
                    
                    if  (!(varNumeric && expNumeric) && tipoVar != tipoExp && tipoExp != Tipo.INVALIDO) {
                        error = true;
                    }
                } 
            }
        } else{
            error = true;
        }
        
        if(ctx.PONTEIRO() != null){
            nomeVar = ctx.PONTEIRO().getText()+nomeVar;
        }

        if(error){
            //System.out.print(ctx.getText()+" "+tipoExp+"\n");
            adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + nomeVar );
        }

        return super.visitCmdAtribuicao(ctx);
    }  
    
    @Override
    public Void visitIdentificador(LAParser.IdentificadorContext ctx) 
    {
        LinkedList<TabelaDeSimbolos> tabelas = escopos.recuperarTodosEscopos();
        String nome = ctx.IDENT(0).getText();
        boolean existeVariavel = false;

        for(int i = 1; i < ctx.IDENT().size(); i++)
            nome += "." + ctx.IDENT(i).getText();

        System.out.println("Novo nome -> " + nome + " "+ ctx.getParent().getParent().getClass());

        for ( TabelaDeSimbolos tabela: tabelas){
            if (tabela.existe(nome)){
                existeVariavel = true;
                break;
            }
        }

        /*if(ctx.getParent().getParent().getParent().getParent() instanceof LAParser.Declaracao_localContext){
            LAParser.Declaracao_localContext ctxParent = (LAParser.Declaracao_localContext) ctx.getParent().getParent().getParent().getParent();
            //System.out.println("AQUI -> " + ctxParent.IDENT());
            for ( TabelaDeSimbolos tabela: tabelas){
                if (tabela.existe(ctxParent.IDENT() + "." + nome)){
                    existeVariavel = true;
                    break;
                }
            }

            System.out.println("verificando se existe -> " + ctxParent.IDENT() + "." + nome);
            
            if(!existeVariavel){
                System.out.println("Erro -> " + ctxParent.IDENT() + "." + nome);
                adicionarErroSemantico(ctx.start, "identificador " + ctxParent.IDENT() + "." + nome + " nao declarado" );
            }
        }*/

        if (!existeVariavel && !(ctx.getParent().getParent() instanceof LAParser.RegistroContext)){
            ctx.IDENT().forEach(ident -> {
                System.out.println("Erro no ctx ident -> " + ident.getText());

            });
            adicionarErroSemantico(ctx.start, "identificador " + nome + " nao declarado" );
            
        }

        return super.visitIdentificador(ctx);
    }
}
