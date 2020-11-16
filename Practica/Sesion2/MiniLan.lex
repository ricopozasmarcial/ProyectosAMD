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
%%
;			{System.out.println("SCANNER:: found punctuation symbol SEMICOLON");}
"+"			{System.out.println("SCANNER:: found Operator ADD");}
-			{System.out.println("SCANNER:: found Operator MINUS");}
"*"			{System.out.println("SCANNER:: found Operator MULT");}
/			{System.out.println("SCANNER:: found Operator DIV");}
"("			{System.out.println("SCANNER:: found Symbol LP");}
")"			{System.out.println("SCANNER:: found Symbol RP");}
begin			{System.out.println("SCANNER:: found Reserved Word BEGIN");}
print
{INTEGER}    		{System.out.println("SCANNER:: found NUMBER <"+ yytext() +">");}
(" "|\t|\n)+   		{}
. 	     		{System.out.println("SCANNER:: Unmatched input <"+ yytext() +">");}
