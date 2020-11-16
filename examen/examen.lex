// Version para inicial para el Analisis Sintactico 
import java.lang.System;
import java_cup.runtime.Symbol;

%%

%{
// Esta variable determina si el scanner imprime
// mensajes por pantalla (true) o solo devuelve el token 
// al parser (false). Puedes cambiarlo según te interese
// ver o no lo que hace el scanner.
boolean output = false;
%}

%cup
DIGIT=([0-9])
LETTER=([a-zA-Z])
ALPHANUM=({LETTER}|{DIGIT})
BLANK=(" "|\t)
COMMENT=("##"({ALPHANUM}|{BLANK})+)
%%
begin		{if (output) System.out.println("SCANNER:: BEGIN");
		 return new Symbol(sym.BEGIN);}
end		{if (output) System.out.println("SCANNER:: END");
		 return new Symbol(sym.END);}
print		{if (output) System.out.println("SCANNER:: PRINT");
		 return new Symbol(sym.PRINT);}
not		{if (output) System.out.println("SCANNER:: NOT");
		 return new Symbol(sym.NOT);}
and		{if (output) System.out.println("SCANNER:: AND");
		 return new Symbol(sym.AND);}
"&&"		{if (output) System.out.println("SCANNER:: AND");
		 return new Symbol(sym.AND);}
or		{if (output) System.out.println("SCANNER:: OR");
		 return new Symbol(sym.OR);}
"||"		{if (output) System.out.println("SCANNER:: OR");
		 return new Symbol(sym.OR);}
False		{if (output) System.out.println("SCANNER:: FALSE");
		 return new Symbol(sym.FALSE);}
false		{if (output) System.out.println("SCANNER:: FALSE");
		 return new Symbol(sym.FALSE);}
True		{if (output) System.out.println("SCANNER:: TRUE");
		 return new Symbol(sym.TRUE);}
true		{if (output) System.out.println("SCANNER:: TRUE");
		 return new Symbol(sym.TRUE);}
";"		{if (output) System.out.println("SCANNER:: EOS");
		 return new Symbol(sym.EOS);}
"("		{if (output) System.out.println("SCANNER:: LP");
		 return new Symbol(sym.LP);}
")"		{if (output) System.out.println("SCANNER:: RP");
		 return new Symbol(sym.RP);}
{COMMENT}       {System.out.println("SCANNER::  COMMENT LINE -- ignoring:"+yytext());}
(" "|\t|\n)+ 	{}
.      		{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}



































