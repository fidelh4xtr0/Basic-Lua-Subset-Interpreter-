//enumerator to hold different token types
public enum TokenType {

    ID_TOK, FUNCT_TOK,
    //Keyword Tokens
    END_TOK, IF_TOK, THEN_TOK, ELSE_TOK, WHILE_TOK, DO_TOK,
    REPEAT_TOK, UNTIL_TOK, PRINT_TOK, CONST_TOK,

    //single or double character tokens
    LE_TOK, LT_TOK, GE_TOK, GT_TOK, EQ_TOK, RP_TOK, LP_TOK,

    //arithmatic tokens
    ADDOP_TOK, SUBOP_TOK, MULTOP_TOK, DIVOP_TOK, ASSIGN_OP,

    //end of file token
    EOS_TOK
}

