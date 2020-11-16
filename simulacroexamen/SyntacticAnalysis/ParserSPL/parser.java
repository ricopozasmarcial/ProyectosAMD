
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Apr 23 20:27:45 CEST 2017
//----------------------------------------------------

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Apr 23 20:27:45 CEST 2017
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\020\000\002\002\005\000\002\002\004\000\002\003" +
    "\006\000\002\004\004\000\002\004\004\000\002\005\006" +
    "\000\002\006\006\000\002\007\004\000\002\007\003\000" +
    "\002\010\006\000\002\011\005\000\002\011\005\000\002" +
    "\011\005\000\002\013\004\000\002\013\002\000\002\012" +
    "\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\004\004\006\001\002\000\004\005\014\001" +
    "\002\000\004\002\012\001\002\000\004\011\007\001\002" +
    "\000\004\014\010\001\002\000\004\012\011\001\002\000" +
    "\004\005\uffff\001\002\000\004\002\000\001\002\000\006" +
    "\005\014\006\051\001\002\000\004\011\045\001\002\000" +
    "\004\005\014\001\002\000\004\013\017\001\002\000\004" +
    "\011\032\001\002\000\006\006\022\013\017\001\002\000" +
    "\006\006\ufff9\013\ufff9\001\002\000\010\005\ufff3\006\ufff3" +
    "\007\ufff3\001\002\000\006\006\ufffa\013\ufffa\001\002\000" +
    "\010\005\ufffc\006\ufffc\007\025\001\002\000\004\011\027" +
    "\001\002\000\010\005\ufff4\006\ufff4\007\ufff4\001\002\000" +
    "\004\014\030\001\002\000\004\012\031\001\002\000\010" +
    "\005\ufff2\006\ufff2\007\ufff2\001\002\000\006\014\033\015" +
    "\034\001\002\000\004\010\042\001\002\000\004\010\037" +
    "\001\002\000\004\012\036\001\002\000\006\006\ufff8\013" +
    "\ufff8\001\002\000\006\014\040\015\041\001\002\000\004" +
    "\012\ufff7\001\002\000\004\012\ufff5\001\002\000\004\015" +
    "\043\001\002\000\004\012\ufff6\001\002\000\006\005\ufffd" +
    "\006\ufffd\001\002\000\004\014\046\001\002\000\004\012" +
    "\047\001\002\000\004\013\ufffb\001\002\000\006\005\ufffe" +
    "\006\ufffe\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\006\002\004\003\003\001\001\000\010\004" +
    "\012\005\014\006\015\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\005\047\006\015\001\001" +
    "\000\002\001\001\000\006\005\043\006\015\001\001\000" +
    "\006\007\017\010\020\001\001\000\002\001\001\000\004" +
    "\010\022\001\001\000\002\001\001\000\004\013\023\001" +
    "\001\000\002\001\001\000\004\012\025\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



public static void main(String args[]) throws Exception {
new parser(new Yylex(System.in)).parse();        } // End Main

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {


		NewHashMap table = new NewHashMap();

  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // comercial ::= AD LP ITEM RP 
            {
              Object RESULT =null;
		 System.out.println(" SPL:: commercial <== AD LP ITEM RP"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("comercial",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // publicity ::= 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: publicity <== lambda"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("publicity",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // publicity ::= publicity comercial 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: publicity <== publicity comercial"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("publicity",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // parameters ::= ACTOR COMMA ACTOR 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: parameters <== ACTOR COMMA ACTOR"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("parameters",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // parameters ::= ITEM COMMA ACTOR 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: parameters <== ITEM COMMA ACTOR"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("parameters",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // parameters ::= ACTOR COMMA ITEM 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: parameters <== ACTOR COMMA ITEM"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("parameters",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // unaction ::= ACTION LP parameters RP 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: unaction <== ACTION LP parameters RP"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("unaction",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // actions ::= unaction 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: actions <== unaction"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("actions",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // actions ::= actions unaction 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: actions <== actions unaction"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("actions",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // title_sketch ::= SKETCH LP ITEM RP 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: title_sketch  <== SKETCH LP ITEM RP"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("title_sketch",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // sketch ::= title_sketch actions END publicity 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: sketch <== title_sketch actions END publicity"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("sketch",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // sketches ::= sketch sketch 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: sketches <== sketch sketch"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("sketches",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // sketches ::= sketches sketch 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: sketches <== sketches sketch"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("sketches",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // title_chapter ::= CHAPTER LP ITEM RP 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: title_chapter <== CHAPTER LP ITEM RP"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("title_chapter",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= chapter EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // chapter ::= title_chapter sketches END 
            {
              Object RESULT =null;
		 System.out.println("	SPL:: chapter <== title_chapter sketches END"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("chapter",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

