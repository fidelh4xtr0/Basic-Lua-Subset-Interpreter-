public class Block {

    private Block blk;
    private LexicalAnalyzer lex;
    private Statement stmt;
    private IfStatement if_stmt;
    private WhileStatement while_stmt;
    private LitInteger LitInt;
    private BinaryExpression BinExpr;
    public Token currTok;



    public Block(LexicalAnalyzer lex)throws LexicalException, ParserException{

        this.lex = lex;



    }


    public Block getBlock() throws LexicalException, ParserException{
        Block blk = new Block(lex);
        Token tok = lex.lookAheadTok();
        while(isValidStartofStatement(tok)){
            if(tok.getTokType() == TokenType.IF_TOK){
                Statement stmts = new Statement(lex);
                IfStatement stmt = stmts.getIfStatement();
                blk.add(stmt);
            }
            else if(tok.getTokType() == TokenType.WHILE_TOK){
                Statement stmts = new Statement(lex);
                WhileStatement stmt = stmts.getWhile_stmt();
                blk.add(stmt);
            }
            else if(tok.getTokType() == TokenType.PRINT_TOK){
                Statement stmt = new Statement(lex);
                PrintStatement stmts = stmt.getPrint_stmt();
                stmt.add(stmts);
                blk.add(stmt);
            }
            else if(tok.getTokType() == TokenType.REPEAT_TOK){
                Statement stmt = new Statement (lex);
                RepeatStatement stmts = stmt.getRepeatStatement();
                stmt.add(stmts);
                blk.add(stmt);
            }
            else if(tok.getTokType() == TokenType.ID_TOK){
                Statement stmt = new Statement(lex);
                AssignmentStatement stmts = stmt.getAssignStmt();
                stmt.add(stmts);
                blk.add(stmt);
            }

            tok = lex.lookAheadTok();

        }

        this.blk = blk;

        return blk;

    }


    public void add(Statement stmt){

        this.stmt = stmt;
    }

    public void add(IfStatement stmt){

        this.if_stmt = stmt;
    }

    public void add(WhileStatement stmt){
        this.while_stmt = stmt;
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
                tok.getTokType() == TokenType.ID_TOK||
                tok.getTokType() == TokenType.THEN_TOK;


    }


}


