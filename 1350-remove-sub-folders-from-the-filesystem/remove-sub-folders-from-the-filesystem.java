
        // REAL REAL REAL SOLUTION
        // sort alphabetically, this will get them in order n stuff
        // this will get the shortest keys first naturally, so it will be /a before /a/b
        // examples: "/a/b", "/a/b/c/d", "/a/c", "/a/e", "/a/e/f"
        // because it's sorted like this, we only need to keep track of one "root"
        // the roots in this case are "/a/b", "/a/c", "/a/e" since they are not subfolders of "root" before
        // and if it's different from the original, we add it to an output list (easy enough)
        // so basically, we save 1 string of the root. we then compare every object after
        // the isseu ith using a string is that what if it's like "/a/b/c" and the root is "b/c"
        // AFTER RESEARCH: can use "startsWith" function, which means this is fine to use 
        // the  contains each 'folder' in order
        // TO COMPARE
        // we compare this string to each element of the next in the string
        // if it srtarts with something differemt, then that's bad, its not a subfolder
        // we break and make that the new root, and add it to output
        // if it's not differet, oh well!!! just keep going 

class Solution {
    public List<String> removeSubfolders(String[] folder) {

        // sort alphabetically, hint was given in recitation, makes it so all roots come first
        Arrays.sort(folder); // use collections sort, this is O(n log n) i think
        
        List<String> resultList = new ArrayList<>(); // submit an array list
        
        String root = ""; // this will be our root
        String currentFolder = ""; // this is thing we compare root to

        for (int i = 0; i < folder.length; i++) { // iterate through
            currentFolder = folder[i]; // get a golder
            if (root.isEmpty() || !currentFolder.startsWith(root + "/")) { 
                // if the root is empty (aka, first element) or if current folder does NOT have the root before it 
                // (plus a slash, bc otherwise would be true for "a/b/ca" AND "a/b/c/a")
                resultList.add(currentFolder); // add this 
                root = currentFolder; // the current folder is the root #awesome 
            }
        }
        
        return resultList;
    }
}