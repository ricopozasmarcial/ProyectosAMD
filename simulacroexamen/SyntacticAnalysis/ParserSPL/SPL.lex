// MiniLanInicialS1.lex
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
ACTION=("TO_"{UPPERLETTER}*)
UPPERLETTER=([A-Z])
LOWERLETTER=([a-z])
ITEM=({LOWERLETTER}+(" "{LOWERLETTER}+)*)
BLANK=((" "|\t|\n)+)
ACTOR=(({UPPERLETTER}{LOWERLETTER}*)(" "+({UPPERLETTER}{LOWERLETTER}*))*)

%%
		 
CHAPTER				{if (output) System.out.println("SPL:: RESERVED WORD <CHAPTER>");
						return new Symbol(sym.CHAPTER);}
SKETCH				{if (output) System.out.println("SPL:: RESERVED WORD <SKETCH>");
						return new Symbol(sym.SKETCH);}
END					{if (output) System.out.println("SPL:: RESERVED WORD <END>");
						return new Symbol(sym.END);}
AD					{if (output) System.out.println("SPL:: RESERVED WORD <AD>");
						return new Symbol(sym.AD);}
"("					{if (output) System.out.println("SPL:: LP");
						return new Symbol(sym.LP);}
")"					{if (output) System.out.println("SPL:: RP");
						return new Symbol(sym.RP);}
","					{if (output) System.out.println("SPL:: COMMA");
						return new Symbol(sym.COMMA);}
{ACTION}			{if (output) System.out.println("SPL:: ACTION <" + yytext() + ">");
						return new Symbol(sym.ACTION, yytext());}
{ITEM}				{if (output) System.out.println("SPL:: ITEM <" + yytext() + ">");
						return new Symbol(sym.ITEM, yytext());}
{ACTOR}				{if (output) System.out.println("SPL:: ACTOR <" + yytext() + ">");
						return new Symbol(sym.ACTOR, yytext());}
{BLANK} 	  	{}
.      				{if (output) System.out.println("SPL:: Unmatched input "+ yytext());}