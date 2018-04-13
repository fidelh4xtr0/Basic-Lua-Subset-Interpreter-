
public class BinaryExpression {

    private BinaryExpression.ArithmeticOp op;
    private ArithmeticExpression expr1;
    private ArithmeticExpression expr2;
    private BinaryExpression expr;


    public enum ArithmeticOp{
        ADD_OP,
        SUB_OP,
        MULT_OP,
        DIV_OP,
        ASSIGN_OP
    }

    public BinaryExpression(BinaryExpression.ArithmeticOp op, ArithmeticExpression expr1, ArithmeticExpression expr2){
        this.op = op;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public BinaryExpression(){

    }

    public BinaryExpression.ArithmeticOp getArithmeticOp(LexicalAnalyzer lex) throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        if(tok.getTokType() == TokenType.ADDOP_TOK){
            op = ArithmeticOp.ADD_OP;
        }
        else if(tok.getTokType() == TokenType.SUBOP_TOK){
            op = ArithmeticOp.SUB_OP;
        }
        else if(tok.getTokType() == TokenType.MULTOP_TOK){
            op = ArithmeticOp.MULT_OP;
        }
        else if(tok.getTokType() == TokenType.DIVOP_TOK){
            op = ArithmeticOp.DIV_OP;
        } else if (tok.getTokType() == TokenType.ASSIGN_OP) {

            op = ArithmeticOp.ASSIGN_OP;
        }
        return op;
    }

    public BinaryExpression getBinaryExpression(LexicalAnalyzer lex)throws LexicalException, ParserException{
        BinaryExpression.ArithmeticOp op = new BinaryExpression().getArithmeticOp(lex);
        ArithmeticExpression expr1 = new ArithmeticExpression(lex).getArithmeticExpression();
        ArithmeticExpression expr2 = new ArithmeticExpression(lex).getArithmeticExpression();

        return new BinaryExpression(op, expr1, expr2);
    }
}
