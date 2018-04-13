

public class Statement{

    private IfStatement If_stmt;
    private WhileStatement while_stmt;
    private LexicalAnalyzer lex;
    private BooleanExpression expr;
    private BinaryExpression binExpr;
    private AssignmentStatement assignStmt;
    private PrintStatement printState;
    private RepeatStatement repeatState;
    public IfStatement if_stmt;
    public LitInteger LitInt;


    public Statement(LexicalAnalyzer lex)throws LexicalException, ParserException{
        this.lex = lex;





    }

    public void add(IfStatement stmt){
        this.if_stmt = stmt;
    }

    public void add(WhileStatement stmt){
        this.while_stmt = stmt;
    }

    public void add(int LitInt){this.LitInt = new LitInteger(LitInt);}

    public void add(BinaryExpression binExpr){
        this.binExpr = binExpr;
    }

    public void add(AssignmentStatement assignStat){
        this.assignStmt = assignStat;
    }

    public void add(PrintStatement printState){
        this.printState = printState;
    }
    public void add(RepeatStatement repeatState){
        this.repeatState = repeatState;
    }




    public IfStatement getIfStatement()throws LexicalException, ParserException{

        Token tok = lex.getNextTok();
        match(tok, TokenType.IF_TOK);
        BooleanExpression expr = new BooleanExpression(lex).getBooleanExpression();
        tok = lex.getNextTok();
        match(tok, TokenType.THEN_TOK);
        Block blk1 = new Block(lex).getBlock();
        tok = lex.getNextTok();
        match(tok, TokenType.ELSE_TOK);
        Block blk2 = new Block (lex).getBlock();
        tok = lex.getNextTok();
        match(tok, TokenType.END_TOK);
        IfStatement iStatement = new IfStatement(expr, blk1, blk2);
        this.If_stmt = iStatement;
        return iStatement;
    }



    public WhileStatement getWhile_stmt() throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        match(tok, TokenType.WHILE_TOK);
        BooleanExpression expr = new BooleanExpression(lex).getBooleanExpression();
        tok = lex.getNextTok();
        match(tok, TokenType.DO_TOK);
        Block blk = new Block(lex).getBlock();
        tok = lex.getNextTok();
        match(tok, TokenType.END_TOK);
        return new WhileStatement(expr, blk);


    }

    public PrintStatement getPrint_stmt() throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        match(tok, TokenType.PRINT_TOK);
        tok = lex.getNextTok();
        match(tok, TokenType.LP_TOK);
        ArithmeticExpression expr = new ArithmeticExpression(lex).getArithmeticExpression();
        tok = lex.getNextTok();
        match(tok, TokenType.RP_TOK);


        return new PrintStatement(expr);
    }

    public RepeatStatement getRepeatStatement()throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        match(tok, TokenType.REPEAT_TOK);
        Block blk = new Block(lex).getBlock();
        tok = lex.getNextTok();
        match(tok, TokenType.UNTIL_TOK);
        BooleanExpression expr = new BooleanExpression(lex).getBooleanExpression();

        return new RepeatStatement(blk, expr);

    }

    public AssignmentStatement getAssignStmt() throws ParserException, LexicalException {

        Id var = new Id(lex).getId();
        Token tok = lex.getNextTok();
        match(tok, TokenType.ASSIGN_OP);
        ArithmeticExpression expr = new ArithmeticExpression(lex).getArithmeticExpression();

        return new AssignmentStatement(var, expr);
    }

    public void match(Token tok, TokenType tokType) throws ParserException
    {
        assert (tok != null);
        assert (tokType != null);
        if (tok.getTokType() != tokType)
            throw new ParserException (tokType + " expected at row " +
                    tok.getRowNumber()  + " and column " + tok.getColumnNumber());
    }

    public boolean isValidStartofStatement(Token tok){
        assert (tok != null);

        return tok.getTokType() == TokenType.PRINT_TOK||
                tok.getTokType() == TokenType.WHILE_TOK||
                tok.getTokType() == TokenType.IF_TOK||
                tok.getTokType() == TokenType.REPEAT_TOK||
                tok.getTokType() == TokenType.ID_TOK;
    }



}
