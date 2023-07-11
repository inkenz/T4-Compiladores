package br.ufscar.dc.compiladores.t4;

import static br.ufscar.dc.compiladores.t4.LinguagemLAUtils.adicionarErroSemantico;
import static br.ufscar.dc.compiladores.t4.LinguagemLAUtils.verificarTipo;
import br.ufscar.dc.compiladores.t4.TabelaDeSimbolos.Tipo;
import java.util.LinkedList;
public class LinguagemLAVisitor extends LABaseVisitor<Void>{
    Escopo escopos = new Escopo();

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
                adicionarErroSemantico(ctx.start, "identificador " + nomeVar + " ja declarado anteriormente");
            }
            else{
                tabela.inserir(nomeVar, tipo);
            }
        }

        return super.visitDeclaracao_local(ctx);
    }

    @Override
    public Void visitRegistro(LAParser.RegistroContext ctx){
        TabelaDeSimbolos tabela = escopos.escopoAtual();
               
        for(int i = 0; i < ctx.variavel().size(); i++){
            System.out.println("Variavel de registro -> " + ctx.variavel().get(i).getText());
            verificarTipo(tabela, ctx.variavel().get(i));
        }
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
        String nome = ctx.IDENT().get(0).getText();
        boolean existeVariavel = false;

        for ( TabelaDeSimbolos tabela: tabelas){
            if (tabela.existe(nome)){
                existeVariavel = true;
                break;
            }
        }

        if (!existeVariavel){
            adicionarErroSemantico(ctx.start, "identificador " + nome + " nao declarado" );
        }

        return super.visitIdentificador(ctx);
    }
}
