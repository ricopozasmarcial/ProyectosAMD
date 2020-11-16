import java.lang.System;
class SPL_Scanner {
public static void main(String argv[])
        throws java.io.IOException {
Yylex yy = new Yylex(System.in);
while (yy.yylex() != null){}
}
}

class Yytoken {Yytoken () {}}

%%
UPPER=[A-Z]
LOWER=[a-z]
DIGIT=([0-9])
INTEGER=({DIGIT}+)
HOUR=(((0|1){DIGIT})|(2[0-3]))
MINUTE=([0-5]{DIGIT})
SEPARATOR=((" "|\t|\n)+)
ACTOR=(({UPPER}{LOWER}*{UPPER})|({UPPER}))
COMMENT=(("//"){HOUR}(":"){MINUTE}(" ")(({UPPER}*{LOWER}*(" ")*)*))
%%
"("             {System.out.println("SPL:: LP");}
")"             {System.out.println("SPL:: RP");}
CHAPTER		    {System.out.println("SPL:: found RESERVED WORD CHAPTER");}
SKETCH		    {System.out.println("SPL:: found RESERVED WORD SKETCH");}
END		        {System.out.println("SPL:: found RESERVED WORD END");}
AD				{System.out.println("SPL:: found RESERVED WORD AD");}
{ACTOR} 	    {System.out.println("SPL:: ACTOR("+yytext()+")");}	
{COMMENT}       {System.out.println("SPL:: COMMENT("+yytext()+")");}
{SEPARATOR}     {}
.               {System.out.println("SPL:: Unmatched input "+ yytext());}
