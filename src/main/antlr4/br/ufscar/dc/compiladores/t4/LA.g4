grammar LA;

//
// LÉXICO
//


//Palavras Chave
ALGORITMO: 'algoritmo';
FIM_ALGORITMO: 'fim_algoritmo';
DECLARE: 'declare';
LEIA: 'leia';
ESCREVA: 'escreva';
NAO: 'nao';
E: 'e';
OU: 'ou';
VERDADEIRO: 'verdadeiro';
FALSO: 'falso';
REGISTRO: 'registro';
FIM_REGISTRO: 'fim_registro';
PROCEDIMENTO: 'procedimento';
FIM_PROCEDIMENTO: 'fim_procedimento';
FUNCAO: 'funcao';
FIM_FUNCAO: 'fim_funcao';
VAR: 'var';
SE: 'se';
FIM_SE: 'fim_se';
SENAO: 'senao';
ENTAO: 'entao';
CASO: 'caso';
FIM_CASO: 'fim_caso';
SEJA: 'seja';
PARA: 'para';
FIM_PARA: 'fim_para';
ATE: 'ate';
FACA: 'faca';
ENQUANTO: 'enquanto';
FIM_ENQUANTO: 'fim_enquanto';
RETORNE: 'retorne';

//Tipos
TIPO: 'tipo';
CONSTANTE: 'constante';
LITERAL: 'literal';
INTEIRO: 'inteiro';
REAL: 'real';
LOGICO: 'logico';

//Operadores
SOMA: '+';
SUBTRACAO: '-';
MULTIPLICACAO: '*';
DIVISAO: '/';
PORCENTO: '%';
IGUAL: '=';
DIFERENTE: '<>';
MENORIGUAL: '<=';
MAIORIGUAL: '>=';
MENOR: '<';
MAIOR: '>';

//Simbolos
PONTO: '.';
DOISPONTOS: ':';
VIRGULA: ',';
ABREPAR: '(';
FECHAPAR: ')';
ABREBAR: '[';
FECHABAR: ']';
SEQ: '..';
SETA: '<-';
PONTEIRO: '^';
ENDERECO: '&';

//Definições
IDENT: [a-zA-Z]([a-zA-Z0-9]* | [a-zA-Z0-9]*'_'[a-zA-Z0-9]* );
NUM_INT: ('0'..'9')+;
NUM_REAL: ('0'..'9')+ '.' ('0'..'9')+;

CADEIA:
    '"' ~('"'|'\n'|'\r'|'\t')* '"';
CADEIA_NAO_FECHADA:
    '"' ~('"'|'\n'|'\r'|'\t')*;
COMENTARIO:
    '{' ~('{'|'}'|'\n'|'\r'|'\t')* '}' {skip();};
COMENTARIO_NAO_FECHADO:
    '{' ~('{'|'}'|'\n'|'\r'|'\t')*;
ERRO:
    ( '!' | '|' | '@' |'$' | '~' | CADEIA'}' | '}');

IGNORE:
    ( ' ' | '\t' | '\r' | '\n' ) {skip();};

//
// SINTÁXE
//

// FORMATO DO PROGRAMA
programa: 
    declaracoes ALGORITMO corpo FIM_ALGORITMO EOF
;

// DECLARAÇÕES DE VARIÁVEL
declaracoes:
    (decl_local_global)*
;
decl_local_global:
    declaracao_local| declaracao_global
;
declaracao_local:
    DECLARE variavel
    | CONSTANTE IDENT DOISPONTOS tipo_basico IGUAL valor_constante
    | TIPO IDENT DOISPONTOS tipo
;
declaracao_global:
    PROCEDIMENTO IDENT ABREPAR (parametros)? FECHAPAR (declaracao_local)* (cmd)* FIM_PROCEDIMENTO
    | FUNCAO IDENT ABREPAR (parametros)? FECHAPAR DOISPONTOS tipo_estendido (declaracao_local)* (cmd)* FIM_FUNCAO
;
variavel:
    identificador (VIRGULA identificador)* DOISPONTOS tipo
;
identificador:
    IDENT (PONTO IDENT)* dimensao
;
dimensao:
    (ABREBAR exp_aritmetica FECHABAR)*
;
corpo:
    (declaracao_local)* (cmd)*
;

// TIPOS
tipo:
    registro | tipo_estendido
;
tipo_basico:
    LITERAL | INTEIRO | REAL | LOGICO
;
tipo_estendido:
    (PONTEIRO)? (tipo_basico | IDENT)
;

valor_constante:
    CADEIA | NUM_INT | NUM_REAL | VERDADEIRO | FALSO
;


// ESTRUTURA DOS COMANDOS
registro:
    REGISTRO (variavel)* FIM_REGISTRO
;
cmd:
    cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto
   | cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne
;
cmdLeia:
    LEIA ABREPAR (PONTEIRO)? identificador (VIRGULA (PONTEIRO)? identificador)* FECHAPAR
;
cmdEscreva:
    ESCREVA ABREPAR expressao (VIRGULA expressao)* FECHAPAR
;
cmdSe:
    SE expressao ENTAO (cmd)* (SENAO (cmd)*)? FIM_SE
;
cmdCaso:
    CASO exp_aritmetica SEJA selecao (SENAO (cmd)*)? FIM_CASO
;
cmdPara:
    PARA IDENT SETA exp_aritmetica ATE exp_aritmetica FACA (cmd)* FIM_PARA
;
cmdEnquanto:
    ENQUANTO expressao FACA (cmd)* FIM_ENQUANTO
;
cmdFaca:
    FACA (cmd)* ATE expressao
;
cmdAtribuicao: 
    (PONTEIRO)? identificador SETA expressao
;
cmdChamada:
    IDENT ABREPAR expressao (VIRGULA expressao)* FECHAPAR
;
cmdRetorne:
    RETORNE expressao
;

// EXPRESSÕES, PARÂMETROS E OPERADORES
parametro:
    (VAR)? identificador (VIRGULA identificador)* DOISPONTOS tipo_estendido
;
parametros:
    parametro (VIRGULA parametro)*
;
selecao:
    (item_selecao)*
;
item_selecao:
    constantes DOISPONTOS (cmd)*
;
constantes:
    numero_intervalo (VIRGULA numero_intervalo)*
;
numero_intervalo:
    (op_unario)? NUM_INT (SEQ (op_unario)? NUM_INT)?
;
op_unario:
    SUBTRACAO
;
exp_aritmetica:
    termo (op1 termo)*
;
termo:
    fator (op2 fator)*
;
fator:
    parcela (op3 parcela)*
;
op1:
    SOMA | SUBTRACAO
;
op2:
    MULTIPLICACAO | DIVISAO
;
op3:
    PORCENTO
;
parcela:
    (op_unario)? parcela_unario | parcela_nao_unario
;
parcela_unario:
    (PONTEIRO)? identificador
    | IDENT ABREPAR expressao (VIRGULA expressao)* FECHAPAR
    | NUM_INT
    | NUM_REAL
    | ABREPAR expressao FECHAPAR
;
parcela_nao_unario:
    ENDERECO identificador | CADEIA;
exp_relacional:
    exp_aritmetica (op_relacional exp_aritmetica)?
;
op_relacional:
    IGUAL | DIFERENTE | MAIORIGUAL | MENORIGUAL | MAIOR | MENOR
;
expressao:
    termo_logico (op_logico_1 termo_logico)*
;
termo_logico:
    fator_logico (op_logico_2 fator_logico)*
;
fator_logico:
    (NAO)? parcela_logica
;
parcela_logica:
    (VERDADEIRO | FALSO) | exp_relacional
;
op_logico_1: 
    OU
;
op_logico_2: 
    E
;   
