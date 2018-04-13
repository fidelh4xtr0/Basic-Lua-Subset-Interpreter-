public class Id {
    private char ch;
    private LexicalAnalyzer lex;
    public Id(char ch){

        this.ch = ch;

    }

    public Id(LexicalAnalyzer lex)throws LexicalException, ParserException{
        this.lex = lex;
    }

    public Id(){

    }

    public Id getId() throws LexicalException, ParserException{
        Token tok = lex.getNextTok();
        if(tok.getTokType() != TokenType.CONST_TOK && tok.getTokType() != TokenType.ID_TOK){
            throw new ParserException("Identifier expected in line " + tok.getRowNumber() + " column " + tok.getColumnNumber());
        }

        return new Id(tok.getLexeme().charAt(0));

    }
}
