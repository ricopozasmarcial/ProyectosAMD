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
INTEGER=({DIGIT}|[1-9]{DIGIT}*)
REAL=({DIGIT}+"."{DIGIT}*|{DIGIT}*"."{DIGIT}+)
LETTER=([a-zA-Z])
BLANK=(" "|\t)
COMENT=("//"({DIGIT}|{LETTER}|{BLANK})*)
IDENT=({LETTER}({DIGIT}|[a-z])*|"$"({LETTER}|{DIGIT})*"$")
%%

;			{System.out.println("SCANNER:: found punctuation symbol SEMICOLON");}
"+"			{System.out.println("SCANNER:: found Operator ADD");}
"-"			{System.out.println("SCANNER:: found Operator MINUS");}
"*"			{System.out.println("SCANNER:: found Operator MULT");}
"/"			{System.out.println("SCANNER:: found Operator DIV");}
"("			{System.out.println("SCANNER:: found Symbol LP");}
")"			{System.out.println("SCANNER:: found Symbol RP");}
"<"			{System.out.println("SCANNER:: found Operator LT");}
">"			{System.out.println("SCANNER:: found Operator GT");}
"=="			{System.out.println("SCANNER:: found Operator EQ");}
"="			{System.out.println("SCANNER:: found Operator SET");}
begin			{System.out.println("SCANNER:: found Reserved Word BEGIN");}
print			{System.out.println("SCANNER:: found Reserved Word PRINT");}
end			{System.out.println("SCANNER:: found Reserved Word END");}
(" "|\t|\n)+   		{}
{COMENT}    		{System.out.println("SCANNER:: COMENT LINE <"+ yytext() +">");}
{DIGIT}    		{System.out.println("SCANNER:: found DIGIT <"+ yytext() +">");}
{INTEGER}    		{System.out.println("SCANNER:: found INTEGER <"+ yytext() +">");}
{REAL}    		{System.out.println("SCANNER:: found REAL <"+ yytext() +">");}
{IDENT}    		{System.out.println("SCANNER:: found IDENT <"+ yytext() +">");}
. 	     		{System.out.println("SCANNER:: Unmatched input "+ yytext());}
