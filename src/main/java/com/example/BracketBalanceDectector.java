package com.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BracketBalanceDectector {
    public String isBalanced(String s){
        Deque<Character> openerStack = new ArrayDeque<>();
        List<Character> openers = Arrays.asList('{', '[', '(' );
        List<Character> closers = Arrays.asList('}', ']', ')' );


        for(int i = 0; i < s.length(); i++) {
            char possibleBracket = s.charAt(i);

            if(openers.contains(possibleBracket)){
                openerStack.push(possibleBracket);
            } else if (closers.contains(possibleBracket)){
                if(openerStack.isEmpty()){
                    return "NO";
                }

                char lastOpener = openerStack.pop();

                if(lastOpener != openers.get(closers.indexOf(possibleBracket))) {
                    return "NO";
                }
            }
        }

        return openerStack.isEmpty() ? "YES" : "NO";
    }
}
