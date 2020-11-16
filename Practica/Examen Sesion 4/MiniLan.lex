import java.lang.System;
class Scanner {
   public static void main(String argv[])
        throws java.io.IOException {
        Yylex yy = new Yylex(System.in);
        while (yy.yylex() != null){}
   }
}

class Yytoken {   Yytoken () {} }
%%
DIGIT=([0-9])
INTEGER = ({DIGIT}+)
LETTER = ([a-z]|[A-Z])
BLANK = (" "|\t)
COMMENT = ("//"({LETTER}|{BLANK}|{INTEGER})+)
HEXA = ("0x"({INTEGER}|[a-f])+)
REAL = (({INTEGER}"."{INTEGER})|({INTEGER}".")|("."{INTEGER}))
IDENT = (({LETTER}|{DIGIT})+)
STRING =(\"(({IDENT}|{BLANK}|{INTEGER}|{REAL})+)\")
EMAIL = ({IDENT}"@"{IDENT}"."{IDENT})
%%
;			{System.out.println("SCANNER:: found punctuation symbol SEMICOLON");}
"("			{System.out.println("SCANNER:: found Symbol LP");}
")"			{System.out.println("SCANNER:: found Symbol RP");}
"+"			{System.out.println("SCANNER:: found Operator ADD");}
-			{System.out.println("SCANNER:: found Operator MINUS");}
"*"			{System.out.println("SCANNER:: found Operator MULT");}
/			{System.out.println("SCANNER:: found Operator DIV");}
"<"			{System.out.println("SCANNER:: found Operator LT");}
>			{System.out.println("SCANNER:: found Operator GT");}
= 			{System.out.println("SCANNER:: found Operator SET");}
==			{System.out.println("SCANNER:: found Reserved Word BEGIN");}
print			{System.out.println("SCANNER:: found Operator EQ");}
begin			{System.out.println("SCANNER:: found Reserved Word PRINT");}
end        		{System.out.println("SCANNER:: found Reserved Word END");} 
{LETTER} 		{System.out.println("SCANNER:: found LETTER");}
{REAL}			{System.out.println("SCANNER:: found REAL <"+ yytext() +">");}
{INTEGER}   		{System.out.println("SCANNER:: found NUMBER <"+ yytext() +">");}
{COMMENT}   		{System.out.println("SCANNER:: found comment line <"+ yytext() +">");}
{HEXA}			{System.out.println("SCANNER:: found HEXA <"+ yytext() +">");}
{IDENT}			{System.out.println("SCANNER:: found IDENT <"+ yytext() +">");}
{STRING}		{System.out.println("SCANNER:: found STRING <"+ yytext() +">");}
{EMAIL}			{System.out.println("SCANNER:: found EMAIL<"+ yytext() +">");}

(" "|\t|\n)+   		{}
. 	     		{System.out.println("SCANNER:: Unmatched input <"+ yytext() +">");}
