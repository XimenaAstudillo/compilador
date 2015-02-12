package analizador;
import static analizador.Token.*;
import java_cup.runtime.*;
%%
%class Analizador
%cup
%line
%column

CARACTER=[-]
NUMEROS=[0-9]+
PICHINCHA=[17]+
LOJA=[11]+
ORO=[07]+
WHITE=[ ,\n]
%%

{WHITE} {/*Ignore*/}
{CARACTER} {return new Symbol(sym.CARACTER,yyline,yycolumn,yytext());}
{LOJA} {return new Symbol(sym.DIGITOSLOJA,yyline,yycolumn,yytext());}
{PICHINCHA} {return new Symbol(sym.DIGITOSPICHINCHA,yyline,yycolumn,yytext());}
{ORO} {return new Symbol(sym.DIGITOSORO,yyline,yycolumn,yytext());}
{NUMEROS} {return new Symbol(sym.NUMEROS,yyline,yycolumn,yytext());}
. {System.out.println("Error Solo se permite números\n"+ yyline+"linea\n"+ yycolumn+ "columa\n"); System.exit(1);}

