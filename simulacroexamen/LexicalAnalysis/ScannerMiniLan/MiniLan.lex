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
INTEGER=({DIGIT}+)
LETTER=([a-zA-Z])
BLANK=(" "|\t)
COMMENT=("//"({LETTER}|{DIGIT}|{BLANK})*)
REAL=({DIGIT}+"."{DIGIT}*|{DIGIT}*"."{DIGIT}+)
IDENT=({LETTER}+({DIGIT}|{LETTER})*(("_")*({DIGIT}|{LETTER})+)*)
IPNUMBER=(({DIGIT})|([1-9]{DIGIT})|(1{DIGIT}{DIGIT})|(2[0-4]{DIGIT})|(25[0-5]))
IPDIRECCION=({IPNUMBER})"."({IPNUMBER})"."({IPNUMBER})"."({IPNUMBER}))
%%
;			    {System.out.println("SCANNER:: found punctuation symbol SEMICOLON");}
"+"			    {System.out.println("SCANNER:: found Operator ADD");}
-               {System.out.println("SCANNER:: found Operator MINUS");}
"*"             {System.out.println("SCANNER:: found Operator MULT");}
"/"             {System.out.println("SCANNER:: found Operator DIV");}
"("				{System.out.println("SCANNER:: found Symbol LP");}
")"				{System.out.println("SCANNER:: found Symbol RP");}
">"				{System.out.println("SCANNER:: found Operator LR");}
"<"			    {System.out.println("SCANNER:: found Operator LT");}
"=="			{System.out.println("SCANNER:: found Operator EQ");}
"="			    {System.out.println("SCANNER:: found Operator SET");}
print			{System.out.println("SCANNER:: found Reserved Word PRINT");}
begin			{System.out.println("SCANNER:: found Reserved Word BEGIN");}
end				{System.out.println("SCANNER:: found Reserved Word END");}
{IPDIRECCION}	{System.out.println("SCANNER:: found IPDIRECCION <"+ yytext() +">");}		
{IDENT}   	    {System.out.println("SCANNER:: found IDENT <"+ yytext() +">");}
{COMMENT}   	{System.out.println("SCANNER:: found COMMENT LINE <"+ yytext() +">");}
{INTEGER}   	{System.out.println("SCANNER:: found INTEGER <"+ yytext() +">");}
{REAL}   	    {System.out.println("SCANNER:: found REAL <"+ yytext() +">");}
(" "|\t|\n)+    {}
. 	     		{System.out.println("SCANNER:: Unmatched input <"+ yytext() +">");}
