import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedList;
 
public class Vyrazy {
    public static class Variables {
        private final Map<String, Integer> values;
 
        public Variables() {
            values = new HashMap<>();
        } 

        //na políčku "_" je uložen poslední výsledek řádku
 
        public int get(String name) {
            Integer res = values.get(name);
            if (res == null) {
                throw new IllegalArgumentException(String.format("Unknown variable '%s'.", name));
            }
            return res;
        }
 
        public void set(String name, int value) {
            values.put(name, value);
        }
    }//get se kouká do již nastavených proměnných, set přidává nové proměnné
 
    public static interface Node /*uzel*/{
        public static final String INDENT = "  ";
        public int compute();
        public String format();
        public void tree(String indent);
    }
 
    public static class Number implements Node {
        private final int value;
 
        public Number(int v) {
            value = v;
        }
 
        @Override
        public int compute() {
            return value;
        }
 
        @Override
        public String format() {
            return Integer.toString(value);
        }
 
        @Override
        public void tree(String indent) {
            System.out.printf("%s%d\n", indent, value);
        }
    }
 
    public static class Variable implements Node {//přiřadí proměnnou tomu, co je za ní, za "="
        private final String name;
        private final Variables values;
 
        public Variable(Variables vars, String n) {
            values = vars;
            name = n;
        }
 
        @Override
        public int compute() {
            return values.get(name);
        }
 
        @Override
        public String format() {
            return name;
        }
 
        @Override
        public void tree(String indent) {
            System.out.printf("%s%s\n", indent, name);
        }
    }
 
    public static class Assignment implements Node { //"=" říká hodnotu proměnné
        private final String name;
        private final Variables values;
        private final Node right;
 
        public Assignment(Variables vars, String n, Node r) {
            values = vars;
            name = n;
            right = r;
        }
 
        @Override
        public int compute() {
            int value = right.compute();
            values.set(name, value);
            return value;
        }
 
        @Override
        public String format() {
            return String.format("%s = %s", name, right.format());
        }
 
        @Override
        public void tree(String indent) {
            System.out.printf("%s%s ASSIGN\n", indent, name);
            right.tree(indent + INDENT);
        }
    }
 
    public static abstract class BinaryOp implements Node {
        private final Node left;
        private final Node right;
        private final String formatter;
        private final String name;
 
        public BinaryOp(Node l, Node r, String fmt, String longName) {
            left = l;
            right = r;
            formatter = fmt;
            name = longName;
        }
 
        protected abstract int compute(int left, int right);
 
        @Override
        public int compute() {
            return compute(left.compute(), right.compute());
        }
 
        @Override
        public String format() {
            return String.format(formatter, left.format(), right.format());
        }
 
        @Override
        public void tree(String indent) {
            System.out.printf("%s%s\n", indent, name);
            left.tree(indent + INDENT);
            right.tree(indent + INDENT);
        }
    }
 
    public static class Sum extends BinaryOp {
        public Sum(Node l, Node r) {
            super(l, r, "(%s + %s)", "PLUS");
        }
 
        @Override
        public int compute(int left, int right) {
            return left + right;
        }
    }
 
    public static class Product extends BinaryOp {
        public Product(Node l, Node r) {
            super(l, r, "%s * %s", "KRAT");
        }
 
        @Override
        public int compute(int left, int right) {
            return left * right;
        }
    }
 
 
    public static enum TokenType {
        NUMBER, VARIABLE, ASSIGNMENT, SUM, PRODUCT, EOF, PSTART, PEND
    }
 
    public static class Token {
        private final TokenType type;
        private final int number;
        private final String variable;
 
        private Token(TokenType t, int num, String var) {
            type = t;
            number = num;
            variable = var;
        }
        public static Token makeNumber(int value) {
            return new Token(TokenType.NUMBER, value, "");
        }
        public static Token makeVariable(String name) {
            return new Token(TokenType.VARIABLE, 0, name);
        }
        public static Token makeAssign() {
            return new Token(TokenType.ASSIGNMENT, 0, "");
        }
        public static Token makeSum() {
            return new Token(TokenType.SUM, 0, "");
        }
        public static Token makeProduct() {
            return new Token(TokenType.PRODUCT, 0, "");
        }
        public static Token makePStart() {
            return new Token(TokenType.PSTART, 0, "");
        }
        public static Token makePEnd() {
            return new Token(TokenType.PEND, 0, "");
        }
        public static Token makeEof() {
            return new Token(TokenType.EOF, 0, "");
        }
        public TokenType getType() {
            return type;
        }
        public int getNumber() {
            if (type != TokenType.NUMBER) {
                throw new IllegalStateException("Not a number.");
            }
            return number;
        }
        public String getVariableName() {
            if (type != TokenType.VARIABLE) {
                throw new IllegalStateException("Not a number.");
            }
            return variable;
        }
    }
 
    public static class Lexer {
        private final List<Token> tokens = new LinkedList<>();
 
        public Lexer(String input) {
            lexIt(input + " ");
        }
 
        private void lexIt(String input) {
            // Expects input terminates with blank space
            boolean insideNumber = false;
            boolean insideVariable = false;
            int number = 0;
            String name = "";
            for (char c : input.toCharArray()) {
                if (insideVariable) {
                    if (((c >= '0') && (c <= '9')) || (c == '_') || ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {        
                        name += c;
                        continue;
                    } else {
                        insideVariable = false;
                        tokens.add(Token.makeVariable(name));
                    }
                }
                if ((c >= '0') && (c <= '9')) {
                    insideNumber = true;
                    number = number*10 + (c - '0');
                    continue;
                }
 
                if (insideNumber) {
                    tokens.add(Token.makeNumber(number));
                    number = 0;
                    insideNumber = false;
                }
                if (c == '+') {
                    tokens.add(Token.makeSum());
                } else if (c == '*') {
                    tokens.add(Token.makeProduct());
                } else if ((c == ' ') || (c == '\t')) {
                    // Skip.
                } else if (c == '=') {
                    tokens.add(Token.makeAssign());
                } else if (c == '('){
                    tokens.add(Token.makePStart());
                } else if (c == ')'){
                    tokens.add(Token.makePEnd());
                } else if (c == '#') {
                    tokens.add(Token.makeEof());
                    return;
                } else if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')) || (c == '_')) {
                    insideVariable = true;
                    name = String.format("%c", c);
                } else {
                    throw new IllegalArgumentException("Wrong input.");
                }
            }
            tokens.add(Token.makeEof());
        }
 
        public TokenType peek() {
            return peek(0);
        }
 
        public TokenType peek(int offset) {
            if (offset > tokens.size()) {
                return TokenType.EOF;
            } else {
                return tokens.get(offset).getType();
            }
        }
 
        public Token next() {
            return tokens.remove(0);
        }
    }
 
    public static class Parser {
        private final Variables variables;
        private final Lexer lexer;
 
        private Parser(Variables vars, Lexer lexer) {
            variables = vars;
            this.lexer = lexer;
        }
 
        public static Node parse(Variables vars, Lexer lexer) {
            Parser parser = new Parser(vars, lexer);
            return parser.parse();
        }
 
        private void expect(TokenType expected) {
            TokenType actual = lexer.peek();
            if (actual != expected) {
                String message = String.format("Expected %s, got %s.",
                        expected, actual);
                throw new IllegalArgumentException(message);
            }
        }
 
        private boolean nextTypesAre(TokenType... types) {//kontroluje, co následuje za tokeny
            for (int i = 0; i < types.length; i++) {
                if (lexer.peek(i) != types[i]) {
                    return false;
                }
            }
            return true;
        }
 
        private Node parse() {//přiřadí proměnnou její hodnotě
            Node result;
            if (nextTypesAre(TokenType.VARIABLE, TokenType.ASSIGNMENT)) {
                Token target = lexer.next();
                lexer.next();
                Node expr = expression();
                result = new Assignment(variables, target.getVariableName(), expr);
            } else {
                result = expression();
            }
            expect(TokenType.EOF);
            return result;
        }
 
        private Node expression() {//E = F + E / E = F
            Node left = factor();
            if (nextTypesAre(TokenType.SUM)) {
                lexer.next();
                Node right = expression();
                return new Sum(left, right);
            } else {
                return left;
            }
        }
 
        private Node factor() {//F = N * F / F = N
            Node left = number();
            if (nextTypesAre(TokenType.PRODUCT)) {
                lexer.next();
                Node right = factor();
                return new Product(left, right);
            } else {
                return left;
            }
        }
 
        private Node number() {//N
            if (nextTypesAre(TokenType.NUMBER)) {
                Token tok = lexer.next();
                return new Number(tok.getNumber());
            } else if (nextTypesAre(TokenType.VARIABLE)) {
                Token tok = lexer.next();
                return new Variable(variables, tok.getVariableName());
            } else if (nextTypesAre(TokenType.PSTART)) {
                lexer.next();
                Node n = expression();
                if (lexer.next().type != TokenType.PEND) {
                    String message = String.format("Expected %s, got %s.",
                        TokenType.PEND, lexer.peek());
                    throw new IllegalArgumentException(message);
                }
                return n;
            } else {
                String message = String.format("Expected %s or %s, got %s.",
                        TokenType.NUMBER, TokenType.VARIABLE, lexer.peek());
                throw new IllegalArgumentException(message);
            }
        }
    }
 
    public static void main(String[] args) {
        Variables vars = new Variables();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Lexer lexer = new Lexer(line);
            Node ast = Parser.parse(vars, lexer);
            ast.tree("");
            int val = ast.compute();
            vars.set("_", val);
            System.out.printf("'%s' => '%s' = %d\n", line, ast.format(), val);
        }
    }
}