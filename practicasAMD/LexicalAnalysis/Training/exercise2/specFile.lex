import java.lang.System;
class Scanner {
public static void main(String argv[])
        throws java.io.IOException {
Yylex yy = new Yylex(System.in);
while (yy.yylex() != null){}
}
}

class Yytoken {Yytoken () {}}
%%

%%
;			    {System.out.println("SCANNER:: SEMICOLON");}
"+"      	    {System.out.println("SCANNER:: PLUS");}
BEGIN|begin		{System.out.println("SCANNER:: BEGIN");}
END|end|End		{System.out.println("SCANNER:: END");}
(" "|\t|\n)+   	{}
[0-9]+    		{System.out.println("SCANNER:: (0-9");}
. 	     		{System.out.println("SCANNER:: Unmatched String ("+yytext()+")");}
