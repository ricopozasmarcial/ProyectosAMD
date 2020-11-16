// MiniLanInicialS1.lex
// Version para inicial para el Analisis Sintactico 
import java.lang.System;
import java_cup.runtime.Symbol;


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

// Esta variable determina si el scanner imprime
// mensajes por pantalla (true) o solo devuelve el token 
// al parser (false). Puedes cambiarlo según te interese
// ver o no lo que hace el scanner.
boolean output = false;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NOT_ACCEPT,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"26:9,24,25,26:2,0,26:18,24,26:7,11,12,18,16,26,17,21,19,20:10,26,10,13,15,1" +
"4,26:2,22:26,26:4,23,26,22,1,22,6,2,22,3,22,4,22:4,5,22,7,22,8,22,9,22:6,26" +
":5,27:2")[0];

	private int yy_rmap[] = unpackFromString(1,35,
"0,1,2:5,3,2:3,4,5,6,7,2:2,8,9:4,10,6,2,11,12,13,14,15,16,9,17,9,18")[0];

	private int yy_nxt[][] = unpackFromString(19,28,
"-1,1,27,33:4,34,33:2,2,3,4,5,6,7,8,9,10,11,12,13,33,24,14:2,24,15,-1,33,30," +
"33:7,-1:10,31,-1,33,21,-1:47,16,-1:31,17,-1:28,12,23,-1:26,23,-1:31,14:2,-1" +
":3,17:9,-1:10,17,-1,17,-1,17,-1:4,33:9,-1:10,31,-1,33,21,-1:5,33:5,18,33:3," +
"-1:10,31,-1,33,21,-1:5,33:4,19,33:4,-1:10,31,-1,33,21,-1:5,33:8,20,-1:10,31" +
",-1,33,21,-1:5,33:4,22,33:4,-1:10,31,-1,33,21,-1:5,33:3,25,33:5,-1:10,31,-1" +
",33,21,-1:5,33:4,26,33:4,-1:10,31,-1,33,21,-1:5,33:2,28,33:6,-1:10,31,-1,33" +
",21,-1:5,33:3,29,33:5,-1:10,31,-1,33,21,-1:5,33:7,32,33,-1:10,31,-1,33,21,-" +
"1:4");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -2:
						break;
					case 2:
						{if (output) System.out.println("SCANNER:: EOS");
                         return new Symbol(sym.EOS);}
					case -3:
						break;
					case 3:
						{if (output) System.out.println("SCANNER:: LP");
                         return new Symbol(sym.LP);}
					case -4:
						break;
					case 4:
						{if (output) System.out.println("SCANNER:: RP");
                         return new Symbol(sym.RP);}
					case -5:
						break;
					case 5:
						{if (output) System.out.println("SCANNER:: LT");
                         return new Symbol(sym.LT);}
					case -6:
						break;
					case 6:
						{if (output) System.out.println("SCANNER:: GT");
                         return new Symbol(sym.GT);}
					case -7:
						break;
					case 7:
						{if (output) System.out.println("SCANNER:: SET");
                         return new Symbol(sym.SET);}
					case -8:
						break;
					case 8:
						{if (output) System.out.println("SCANNER:: PLUS");
						 return new Symbol(sym.PLUS);}
					case -9:
						break;
					case 9:
						{if (output) System.out.println("SCANNER:: MINUS");
						 return new Symbol(sym.MINUS);}
					case -10:
						break;
					case 10:
						{if (output) System.out.println("SCANNER:: MULT");
						 return new Symbol(sym.MULT);}
					case -11:
						break;
					case 11:
						{if (output) System.out.println("SCANNER:: DIV");
						 return new Symbol(sym.DIV);}
					case -12:
						break;
					case 12:
						{if (output) System.out.println("SCANNER:: NUMBER <"+yytext()+">");
										 return new Symbol(sym.NUMBER, new Double(yytext()));}
					case -13:
						break;
					case 13:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -14:
						break;
					case 14:
						{}
					case -15:
						break;
					case 15:
						
					case -16:
						break;
					case 16:
						{if (output) System.out.println("SCANNER:: EQ");
                         return new Symbol(sym.EQ);}
					case -17:
						break;
					case 17:
						{if (output) System.out.println("SCANNER:: COMMENT <"+yytext()+">");}
					case -18:
						break;
					case 18:
						{if (output) System.out.println("SCANNER:: END");
                         return new Symbol(sym.END);}
					case -19:
						break;
					case 19:
						{if (output) System.out.println("SCANNER:: BEGIN");
                         return new Symbol(sym.BEGIN);}
					case -20:
						break;
					case 20:
						{if (output) System.out.println("SCANNER:: PRINT");
                         return new Symbol(sym.PRINT);}
					case -21:
						break;
					case 22:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -22:
						break;
					case 23:
						{if (output) System.out.println("SCANNER:: NUMBER <"+yytext()+">");
										 return new Symbol(sym.NUMBER, new Double(yytext()));}
					case -23:
						break;
					case 24:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -24:
						break;
					case 25:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -25:
						break;
					case 26:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -26:
						break;
					case 27:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -27:
						break;
					case 28:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -28:
						break;
					case 29:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -29:
						break;
					case 30:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -30:
						break;
					case 31:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -31:
						break;
					case 32:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -32:
						break;
					case 33:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -33:
						break;
					case 34:
						{if (output) System.out.println("SCANNER:: IDENT <"+yytext()+">");
										 return new Symbol(sym.IDENT, yytext());}
					case -34:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
