import java.io.FileNotFoundException;
import java.util.List;


public class Parser {

    private LexicalAnalyzer lex;
    private String fileName;

    Parser(String Filename) throws FileNotFoundException, LexicalException, ParserException {
        this.fileName = Filename;
        LexicalAnalyzer lex = new LexicalAnalyzer(Filename);
        this.lex = lex;
        Program();

    }

    public void Program()throws LexicalException, ParserException, FileNotFoundException{
        Token tok;
        tok=lex.getNextTok();
        match(tok, TokenType.FUNCT_TOK);
        tok = lex.lookAheadTok();
        match(tok, TokenType.ID_TOK);
        String Id = getId();
        tok=lex.getNextTok();
        match(tok, TokenType.LP_TOK);
        tok=lex.getNextTok();
        match(tok,TokenType.RP_TOK);
        Block blk = new Block(lex).getBlock();
        tok=lex.getNextTok();
        match(tok, TokenType.END_TOK);
    }


    private String getId() throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        if(tok.getTokType() != TokenType.ID_TOK){
            throw new ParserException("Identifier expected in line " + tok.getRowNumber() + " column " + tok.getColumnNumber());
        }

        return tok.getLexeme();

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