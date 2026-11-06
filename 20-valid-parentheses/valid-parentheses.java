class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> parenthesis = new LinkedList<Character>();
        for(char a : s.toCharArray()){
            if(a == '(' || a == '{' || a == '['){
                parenthesis.addFirst((Character)a); // add to top -> using as Queue
            } else if (!parenthesis.isEmpty()){
                Character currentHead = parenthesis.peek(); // look at top
                if(currentHead == '(' && a == ')'){
                    parenthesis.pop(); //-> remove top
                } else if (currentHead == '{' && a == '}'){
                    parenthesis.pop();
                } else if (currentHead == '[' && a == ']') {
                    parenthesis.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return parenthesis.isEmpty();
    }
}