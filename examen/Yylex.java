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
		/* 20 */ YY_NOT_ACCEPT,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NOT_ACCEPT,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NOT_ACCEPT,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NOT_ACCEPT,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NOT_ACCEPT,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NOT_ACCEPT,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NOT_ACCEPT,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NOT_ACCEPT,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NOT_ACCEPT,
		/* 41 */ YY_NOT_ACCEPT,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NOT_ACCEPT,
		/* 44 */ YY_NOT_ACCEPT,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NOT_ACCEPT,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NOT_ACCEPT,
		/* 51 */ YY_NOT_ACCEPT,
		/* 52 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"27:9,25,26,27:2,0,27:18,25,27:2,23,27:2,12,27,21,22,27:6,24:10,27,20,27:5,2" +
"4:5,14,24:13,18,24:6,27:6,11,1,24,6,2,17,3,24,4,24:2,15,24,5,10,7,24,8,16,9" +
",19,24:5,27,13,27:3,28:2")[0];

	private int yy_rmap[] = unpackFromString(1,53,
"0,1,2:3,3,2:7,4,2:6,5,6,7,2,8,9,10,11,12,13,14,15,16,17,4,18,19,20,21,22,23" +
",24,25,26,27,28,29,30,31,32,33,34,35")[0];

	private int yy_nxt[][] = unpackFromString(36,29,
"-1,1,21,23:2,25,23,27,23,29,31,46,33,35,37,23:2,52,49,23,2,3,4,39,23,5:2,23" +
",6,-1:2,20,-1:80,5:2,-1:3,13:11,-1:2,13:6,-1:4,13:2,-1:6,47,-1:30,22,-1:29," +
"10,-1:31,11,-1:29,24,-1:22,36,-1:32,26,-1:39,38,-1:17,28,-1:26,12,-1:30,7,-" +
"1:35,40,-1:25,8,-1:29,9,-1:20,43,-1:34,32,-1:19,14,-1:49,34,-1:21,44,-1:14," +
"15,-1:31,16,-1:32,17,-1:21,18,-1:28,19,-1:31,30,-1:27,42,-1:43,41,-1:17,48," +
"-1:36,45,-1:27,50,-1:24,51,-1:17");

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
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
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
						{}
					case -6:
						break;
					case 6:
						
					case -7:
						break;
					case 7:
						{if (output) System.out.println("SCANNER:: OR");
		 return new Symbol(sym.OR);}
					case -8:
						break;
					case 8:
						{if (output) System.out.println("SCANNER:: AND");
		 return new Symbol(sym.AND);}
					case -9:
						break;
					case 9:
						{if (output) System.out.println("SCANNER:: OR");
		 return new Symbol(sym.OR);}
					case -10:
						break;
					case 10:
						{if (output) System.out.println("SCANNER:: END");
		 return new Symbol(sym.END);}
					case -11:
						break;
					case 11:
						{if (output) System.out.println("SCANNER:: NOT");
		 return new Symbol(sym.NOT);}
					case -12:
						break;
					case 12:
						{if (output) System.out.println("SCANNER:: AND");
		 return new Symbol(sym.AND);}
					case -13:
						break;
					case 13:
						{System.out.println("SCANNER::  COMMENT LINE -- ignoring:"+yytext());}
					case -14:
						break;
					case 14:
						{if (output) System.out.println("SCANNER:: TRUE");
		 return new Symbol(sym.TRUE);}
					case -15:
						break;
					case 15:
						{if (output) System.out.println("SCANNER:: TRUE");
		 return new Symbol(sym.TRUE);}
					case -16:
						break;
					case 16:
						{if (output) System.out.println("SCANNER:: BEGIN");
		 return new Symbol(sym.BEGIN);}
					case -17:
						break;
					case 17:
						{if (output) System.out.println("SCANNER:: PRINT");
		 return new Symbol(sym.PRINT);}
					case -18:
						break;
					case 18:
						{if (output) System.out.println("SCANNER:: FALSE");
		 return new Symbol(sym.FALSE);}
					case -19:
						break;
					case 19:
						{if (output) System.out.println("SCANNER:: FALSE");
		 return new Symbol(sym.FALSE);}
					case -20:
						break;
					case 21:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -21:
						break;
					case 23:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -22:
						break;
					case 25:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -23:
						break;
					case 27:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -24:
						break;
					case 29:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -25:
						break;
					case 31:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -26:
						break;
					case 33:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -27:
						break;
					case 35:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -28:
						break;
					case 37:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -29:
						break;
					case 39:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -30:
						break;
					case 46:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -31:
						break;
					case 49:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -32:
						break;
					case 52:
						{if (output) System.out.println("SCANNER:: Unmatched input "+ yytext());}
					case -33:
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
