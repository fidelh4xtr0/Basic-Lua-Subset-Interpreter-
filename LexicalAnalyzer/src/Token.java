//Takes in lexeme, token type, row number and column number from LexicalAnalyzer class to create a token table.
public class Token{
    //initialize rowNumber, columnNumber, lexeme and tokType variables.
    private int rowNumber;
    private int columnNumber;
    private String lexeme;
    private TokenType tokType;




    public Token(int rowNumber, int columnNumber, String lexeme, TokenType tokType){
        /*ensure at no point are any negative numbers submitted for a row or column numbers and no invalid
        characters are used */
        if (rowNumber <=0){
            throw new IllegalArgumentException ("Invalid row number argument");
        }
        if (columnNumber <= 0){
            throw new IllegalArgumentException("Invalid column number argument");
        }
        if (lexeme == null || lexeme.length()==0){
            throw new IllegalArgumentException("Invalid lexeme argument");
        }
        if (tokType == null){
            throw new IllegalArgumentException("Invalid tokType argument");
        }
        //if it passes all preconditions, store all values within the class.
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.lexeme = lexeme;
        this.tokType = tokType;
    }
    //to be used in parser to send use with context table.
    public int getRowNumber(){
        return rowNumber;
    }

    public int getColumnNumber(){
        return columnNumber;
    }

    public String getLexeme(){
        return lexeme;
    }

    public TokenType getTokType() {
        return tokType;
    }

    public void printToken(){
        System.out.print(lexeme + "," + tokType);
    }
}
