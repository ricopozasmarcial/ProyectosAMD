import java.lang.System;
import java_cup.runtime.Symbol;

%%
%{
boolean output = false;
%}
%cup
SEPARATORS=((" "|\t|\n)+)
COMMENT=("//"({LOWER}|{UPPER}|" ")*)
UPPER=[A-Z]
LOWER=[a-z]
ACTION=(TO_{UPPER}{UPPER}+)
ACTOR=({UPPER}{LOWER}*(" "+{UPPER}{LOWER}*)*)
ITEM=({LOWER}+(" "+{LOWER}+)*)
%%
CHAPTER     		{if (output) System.out.println("SCANNER:: CHAPTER");
                            return new Symbol(sym.CHAPTER);}
SKETCH    		{if (output) System.out.println("SCANNER:: SKETCH");
                            return new Symbol(sym.SKETCH);}
END    		        {if (output) System.out.println("SCANNER:: END");
                            return new Symbol(sym.END);}
AD	                {if (output) System.out.println("SCANNER:: AD");
                            return new Symbol(sym.AD);}
FOR	                {if (output) System.out.println("SCANNER:: FOR");
                            return new Symbol(sym.FOR);}
"("     	        {if (output) System.out.println("SCANNER:: LP");
                            return new Symbol(sym.LP);}
")"    		        {if (output) System.out.println("SCANNER:: RP");
                            return new Symbol(sym.RP);}
","    		        {if (output) System.out.println("SCANNER:: COMMA");
                            return new Symbol(sym.COMMA);}
{ACTION}	        {if (output) System.out.println("SCANNER:: ACTION("+yytext()+")");
                            return new Symbol(sym.ACTION);}
{ACTOR} 	        {if (output) System.out.println("SCANNER:: ACTOR("+yytext()+")");
                            return new Symbol(sym.ACTOR);}
{ITEM}                  {if (output) System.out.println("SCANNER:: ITEM("+yytext()+")");
                            return new Symbol(sym.ITEM);}
{COMMENT}               {if (output) System.out.println("SCANNER:: COMMENT("+yytext()+")");}
{SEPARATORS}   		{}
. 	     		{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}