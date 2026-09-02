class Solution {
    public ArrayList<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        // start with left, have limit for right and left facing being n
        // right can only be placed if right < left and rightamt <= n
        // left can only be placed if leftamt <= n
        // find some way to iterate through, maybe recursion? 
        // if recursion, it creates branching paths every time theres a valid selection
        // once a whole thing is done then it adds completed thing to list
        // (()) ()()
        // (((()))) (())(()) ((()))() ()((())) (())()() ()()(()) (()()()) ((()())) ()()()()
        
        StringBuilder str = new StringBuilder();
        str.append("(");
        recurFunction(str,1,0,n);
        return list;
        // recursion: base case and function

        
    }

    // base case: adds to string and returns
    // starts with (, adds ) or (, then branches from there
    public void recurFunction(StringBuilder s, int l, int r, int n){
        if (r == n){
            list.add(s.toString());
            return;
        }


        if (l < n) {
            StringBuilder st = new StringBuilder();
            st.append(s);
            st.append("(");
            recurFunction(st,l+1,r,n);
        }

        if (r < n && r < l){
            StringBuilder sta = new StringBuilder();
            sta.append(s);
            sta.append(")");
            recurFunction(sta,l,r+1,n);
        }
        
        return;
        //base case: list.add(s.toString()), then return
        // if ((l == r) && (l == n)){
            // list.add(s.toString());
        // }
        // return;
    }
}
