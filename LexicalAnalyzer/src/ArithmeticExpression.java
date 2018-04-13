public class ArithmeticExpression {

    private Id id;
    private int n;
    private  LexicalAnalyzer lex;
    private BinaryExpression b;


    public ArithmeticExpression(LexicalAnalyzer lex){

        this.lex = lex;

    }

    public ArithmeticExpression(){

    }

    public void addId(Id ID){

        this.id = ID;

    }

    public int addConst(int n){
        this.n = n;
        return n;
    }

    public BinaryExpression addBinaryExpr(BinaryExpression b){
        this.b = b;
        return b;
    }

    public ArithmeticExpression getArithmeticExpression()throws LexicalException, ParserException{

        ArithmeticExpression expr = new ArithmeticExpression(lex);
        Token tok = lex.lookAheadTok();
        if(tok.getTokType() == TokenType.ID_TOK){
            expr.addId(new Id(lex).getId());
        }
        else if(tok.getTokType() == TokenType.CONST_TOK){
            int n = Integer.parseInt(tok.getLexeme());
            expr.addConst(n);
            tok = lex.getNextTok();
        }
        else{
            BinaryExpression b = new BinaryExpression();
            expr.addBinaryExpr(b.getBinaryExpression(lex));
        }
        return expr;

    }


}

