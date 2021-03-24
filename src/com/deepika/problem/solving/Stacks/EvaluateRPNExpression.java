package com.deepika.problem.solving.Stacks;

import java.util.*;

public class EvaluateRPNExpression {
    public static int evaluatePostExpression(String s) {
        Deque<Integer> main = new LinkedList<>();
        String[] allpass = s.split(",");
        for (String token : allpass) {
            if (token.length() == 1 && "+-*/".contains(token)) {
                Integer first = main.removeFirst();
                Integer second = main.removeFirst();
                switch (token) {
                    case "*":
                        main.addFirst(first * second);
                        break;
                    case "/":
                        main.addFirst(first / second);
                        break;
                    case "+":
                        main.addFirst(first + second);
                        break;
                    case "-":
                        main.addFirst(first - second);
                        break;
                    default:
                        throw new IllegalStateException("Invalid char:" + token);
                }
            } else {
                main.addFirst(Integer.parseInt(token));
            }
        }
        return main.removeFirst();
    }

    public static int evaluatePreExpression(String s) {
        Stack<Integer> ss = new Stack<>();
        String[] allPass = s.split(",");
        for (int j = allPass.length - 1; j >= 0; j--) {
            if (allPass[j].length() == 1 && "+-*/".contains(allPass[j])) {
                Integer first = ss.pop();
                Integer second = ss.pop();
                switch (allPass[j]) {
                    case "*":
                        ss.push(first * second);
                        break;
                    case "/":
                        ss.push(first / second);
                        break;
                    case "+":
                        ss.push(first + second);
                        break;
                    case "-":
                        ss.push(first - second);
                        break;
                    default:
                        throw new IllegalStateException("Invalid char:" + allPass[j]);
                }
            } else {
                ss.push(Integer.parseInt(allPass[j]));
            }
        }
        return ss.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluatePreExpression("+,*,/,3,4,2,1"));
        simplifyPath("/home/");
    }

    public static String simplifyPath(String path) {
        if (path.equals("")) {
            return "";
        }
        String[] allToken = path.split("/+");
        Deque<String> main = new LinkedList<String>();
        if (path.startsWith("/")) {
            main.addFirst("/");
        }
        for (String token : allToken) {
            if (token.equals("..")) {
                if (main.isEmpty() || main.peekFirst().equals("..")) {
                    main.addFirst(token);
                } else if (main.peekFirst().equals("/")) {
                    continue;
                }
                main.removeFirst();
            } else if (!token.equals(".") && !token.equals("")) {
                main.addFirst(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!main.isEmpty()) {
            Iterator<String> prev = main.descendingIterator();
            String pk = prev.next();
            sb.append(pk);
            while (prev.hasNext()) {
                if (!pk.equals("/")) {
                    sb.append("/");
                }
                pk = prev.next();
                sb.append(pk);
            }
        }
        return sb.toString();

    }
}