%{
// Esta variable determina si el scanner imprime
// mensajes por pantalla (true) o solo devuelve el token 
// al parser (false). Puedes cambiarlo segÃºn te interese
// ver o no lo que hace el scanner.
boolean output = true;
%}

%cup
LETTER = ([a-z]|[A-Z])
DIGIT=([0-9])
INTEGER=({DIGIT}+)
REAL = (({INTEGER}"."{INTEGER})|({INTEGER}".")|("."{INTEGER}))
IDENT = (({LETTER}({LETTER}|{DIGIT}|"_")+({LETTER}|{DIGIT})|{LETTER}))
%%
begin			{
                      	 return new Symbol(sym.BEGIN);}
end			    {
                         return new Symbol(sym.END);}
print			{
                         return new Symbol(sym.PRINT);}
;			{
                         return new Symbol(sym.EOS);}
"("			{
                         return new Symbol(sym.LP);}
")"			{
                         return new Symbol(sym.RP);}
"+"      	     	{
			 return new Symbol(sym.PLUS);}
"-"			{
			 return new Symbol(sym.MINUS);}
"<"			{
			 return new Symbol(sym.LT);}
"!"			{
			 return new Symbol(sym.FACT);}
>			{
			 return new Symbol(sym.GT);}
==			{
			 return new Symbol(sym.EQ);}
= 			{
			 return new Symbol(sym.SET);}
"/"			{
			 return new Symbol(sym.DIV);}
\*      	     	{
			 return new Symbol(sym.MULT);}
{INTEGER}		{
			 return new Symbol(sym.NUMBER, new Double(yytext()));}
{IDENT}			{
			 return new Symbol(sym.IDENT, new String(yytext()));}
{REAL} 			{
			 return new Symbol(sym.NUMBER, new Double(yytext()));}
(" "|\t|\n)+   		{}
.      			{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
