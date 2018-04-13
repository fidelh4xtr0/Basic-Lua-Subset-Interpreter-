
public class BooleanExpression {

    private LexicalAnalyzer lex;
    private BooleanExpression.RelationalOp op;
    private ArithmeticExpression expr;
    private ArithmeticExpression expr2;



    public enum RelationalOp{

        LT_Expr,
        LE_Expr,
        EQ_Expr,
        GE_Expr,
        GT_Expr
    }

    public BooleanExpression(LexicalAnalyzer lex)throws ParserException, LexicalException{
        this.lex = lex;

    }


    public BooleanExpression(BooleanExpression.RelationalOp op,ArithmeticExpression expr1, ArithmeticExpression expr2){
        this.op = op;
        this.expr = expr1;
        this.expr2 = expr2;



    }



    public BooleanExpression.RelationalOp getRelationalOp(LexicalAnalyzer lex)throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        if(tok.getTokType() == TokenType.LT_TOK){
            op = RelationalOp.LT_Expr;
        }
        else if(tok.getTokType() == TokenType.LE_TOK){
            op = RelationalOp.LE_Expr;
        }
        else if(tok.getTokType() == TokenType.EQ_TOK){
            op = RelationalOp.EQ_Expr;
        }
        else if(tok.getTokType() == TokenType.GT_TOK){
            op = RelationalOp.GT_Expr;
        }
        else if(tok.getTokType() == TokenType.GE_TOK){
            op = RelationalOp.GE_Expr;
        }
        return op;
    }

    public BooleanExpression getBooleanExpression()throws LexicalException, ParserException{
        BooleanExpression.RelationalOp op = getRelationalOp(lex);
        ArithmeticExpression expr1 = new ArithmeticExpression(lex).getArithmeticExpression();
        ArithmeticExpression expr2 = new ArithmeticExpression(lex).getArithmeticExpression();


        return new BooleanExpression(op, expr1, expr2);


    }





}
