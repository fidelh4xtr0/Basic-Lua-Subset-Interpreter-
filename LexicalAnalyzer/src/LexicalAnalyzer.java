
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class LexicalAnalyzer {

    private List<Token> tokens; //create new Token list to store tokens;
    private List<Token> orgtokens;



    public LexicalAnalyzer(String fileName) throws FileNotFoundException, LexicalException {
        assert (fileName != null); //
        tokens = new ArrayList<Token>();
        orgtokens = new ArrayList<Token>();
        Scanner input = new Scanner(new File(fileName));
        TokenOrg org = new TokenOrg();

        int lineNumber = 0;
        while (input.hasNext()) { //while there is more code to be read
            String line = input.nextLine(); //entire line stored
            processLine(line, lineNumber); // line and lineNumber are sent to processLine
            lineNumber++;
        }
        /*after end of file, add
        EOS token to signify the end of the code*/
        tokens.add(new Token(lineNumber, 1, "EOS", TokenType.EOS_TOK));
        input.close();
        orgtokens = org.TokenOrg(tokens);


    }

    private void processLine(String line, int lineNumber) throws LexicalException {
        /* takes in line and splits it into lexemes to then be used to create a new token with the token type.
           Token is stored in Token list.
         */
        assert (line != null && lineNumber >= 1);
        int index = 0;
        index = skipWhiteSpace(line, index); //ensures no white space is turned into lexeme.
        while (index < line.length()) {

            String lexeme = getLexeme(line, lineNumber, index); //splits line into lexemes
            TokenType tokType = getTokenType(lexeme, lineNumber, index); //gets token type from lexeme stored
            tokens.add(new Token(lineNumber + 1, index + 1, lexeme, tokType)); //stores token
            index += lexeme.length(); //add length of last lexeme added to index so it is not counted more than once
            index = skipWhiteSpace(line, index);
        }

    }

    private TokenType getTokenType(String lexeme, int lineNumber, int columnNumber) throws LexicalException {
        //set conditional statements for token types based on user input
        //if any lexeme is invalid, throw exception
        assert (lexeme != null && lineNumber >= 1 && columnNumber <= 1);
        TokenType tokType = null;
        //if first character is a letter
        if (Character.isLetter(lexeme.charAt(0))) {
            if (lexeme.length() == 1) {
                //keywords
                 if (isValidIdentifier(lexeme)) {
                    tokType = TokenType.ID_TOK;
                } else {
                    throw new LexicalException("invalid lexeme at row number " + (lineNumber + 1) + " column number " + (columnNumber + 1));
                }
            }
            else if (lexeme.length()>1) {
                if (lexeme.equals("if")) {
                    tokType = TokenType.IF_TOK;
                } else if (lexeme.equals("then")) {
                    tokType = TokenType.THEN_TOK;
                } else if (lexeme.equals("else")) {
                    tokType = TokenType.ELSE_TOK;
                } else if (lexeme.equals("while")) {
                    tokType = TokenType.WHILE_TOK;
                } else if (lexeme.equals("do")) {
                    tokType = TokenType.DO_TOK;
                } else if (lexeme.equals("end")) {
                    tokType = TokenType.END_TOK;
                } else if(lexeme.equals("function")){
                    tokType = TokenType.FUNCT_TOK;
                }else if (lexeme.equals("repeat")) {
                    tokType = TokenType.REPEAT_TOK;
                } else if (lexeme.equals("until")) {
                    tokType = TokenType.UNTIL_TOK;
                } else if (lexeme.equals("print")) {
                    tokType = TokenType.PRINT_TOK;
                } else {
                    throw new LexicalException("invalid lexeme at row number " + (lineNumber + 1) + " column number " + (columnNumber + 1));
                }
            }
            else {
                throw new LexicalException("invalid lexeme at row number " + (lineNumber + 1) + " column number " + (columnNumber + 1));
            }
            //digits
        } else if (Character.isDigit(lexeme.charAt(0))) {
            if (allDigits(lexeme)) {
                tokType = TokenType.CONST_TOK;
            } else {
                throw new LexicalException("invalid lexeme at row number " + (lineNumber + 1) + " column number " + (columnNumber + 1));
            }
        }
        //arithmatic
        else if (lexeme.equals("+")) {
            tokType = TokenType.ADDOP_TOK;
        } else if (lexeme.equals("-")) {
            tokType = TokenType.SUBOP_TOK;
        } else if (lexeme.equals("*")) {
            tokType = TokenType.MULTOP_TOK;
        } else if (lexeme.equals("/")) {
            tokType = TokenType.DIVOP_TOK;
        } else if (lexeme.equals("<")) {
            tokType = TokenType.LT_TOK;
        } else if (lexeme.equals("=")) {
            tokType = TokenType.ASSIGN_OP;
        }
        //comparative
        else if (lexeme.equals("<=")) {
            tokType = TokenType.LE_TOK;
        }
        else if (lexeme.equals("==")) {
            tokType = TokenType.EQ_TOK;
        }
        else if (lexeme.equals(">=")) {
            tokType = TokenType.GE_TOK;
        }
        else if (lexeme.equals(">")) {
            tokType = TokenType.GT_TOK;
        }
        else if(lexeme.equals("(")){
            tokType = TokenType.LP_TOK;
        }
        else if(lexeme.equals(")")){
            tokType = TokenType.RP_TOK;
        }
        else {
            throw new LexicalException("invalid lexeme at row number " + (lineNumber + 1) + " column number " + (columnNumber + 1));
        }
        return tokType;
    }

    //Check if lexeme is made up of only digits
    private boolean allDigits(String lexeme) {
        assert (lexeme != null);
        int i = 0;
        while (i < lexeme.length() && Character.isDigit(lexeme.charAt(i))) {
            i++;
        }
        return i == lexeme.length();
    }

    //scans until white space and returns substring of line where it found lexeme
    private String getLexeme(String line, int lineNumber, int index) {

        assert (line != null && lineNumber >= 1 && index >= 0);
        int i = index;
        while (i < line.length() && !Character.isWhitespace(line.charAt(i))) {
            i++;
        }
        return line.substring(index, i);
    }

    //if white space, move the index to the next column
    private int skipWhiteSpace(String line, int index) {
        assert (line != null && index >= 0);
        while (index < line.length() && Character.isWhitespace(line.charAt(index))) {
            index++;
        }
        return index;
    }

    //if identifier is valid return true
    private boolean isValidIdentifier(String s) {

        int b = 0;

        if (s.length() == 0 || s == null) { //if empty return false
            return false;
        }

        if (!Character.isJavaIdentifierPart(s.charAt(0))) { //if letter not java identifier, return false.
            return false;
        }

        return true;
    }


    public Token lookAheadTok()throws LexicalException{

        if(orgtokens.get(0) != null){
            return orgtokens.get(0);
        }
        else
        {
            throw new LexicalException("No more tokens");
        }

    }

    public Token getNextTok() throws LexicalException{
        if(orgtokens.get(0) != null){
            return orgtokens.remove(0);
        }
        else
        {
            throw new LexicalException("No more tokens");
        }

    }

    public Token getCurrentTok() throws LexicalException{
        if(orgtokens.get(0) != null){
            return orgtokens.get(0);
        }
        else{
            throw new LexicalException("No more tokens");
        }
    }



}