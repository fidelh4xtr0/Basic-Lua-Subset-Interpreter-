import java.util.EmptyStackException;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TokenOrg {
    public List<Token> TokenOrg(List<Token> tokens) {
        List<Token> token = tokens;
        List<Token> parsedTokens;
        Stack<Token> parseTok;
        Stack<Token> parseTok2;
        parseTok = new Stack<>();
        int[] index = new int[token.size()];

        int size = token.size();
        int px = 0;
        Token temp1;
        Token temp2;
        Token temp3;



        while (px < size) {

            switch (token.get(px).getTokType()) {
                case FUNCT_TOK:
                    parseTok.push(token.get(px));
                    index[px] = px++;
                case ID_TOK:
                    parseTok.push(token.get(px));
                    index[px] =
                            px++;
                    break;
                case CONST_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case ASSIGN_OP:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case ADDOP_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case SUBOP_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case MULTOP_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case DIVOP_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case EQ_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case LT_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                        parseTok.push(temp1);
                        parseTok.push(temp2);
                        parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case LE_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case GT_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case GE_TOK:
                    temp1 = parseTok.pop();
                    temp2 = token.get(px + 1);
                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(token.get(px));
                    temp1 = parseTok.pop();
                    temp2 = parseTok.pop();
                    temp3 = parseTok.pop();

                    parseTok.push(temp1);
                    parseTok.push(temp2);
                    parseTok.push(temp3);
                    px++;
                    px++;
                    break;
                case DO_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case IF_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case LP_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case RP_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case END_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case ELSE_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case THEN_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case PRINT_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case UNTIL_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case WHILE_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case REPEAT_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
                case EOS_TOK:
                    parseTok.push(token.get(px));
                    px++;
                    break;
            }
        }



        parsedTokens = new ArrayList<>(parseTok);

        return parsedTokens;

    }
}
