//approach1 Brute Force
//create combinations of all words and see if those exist, if so, them just add it to result
//TC: O(2^n) - choose ot choose
//SC: O(h) - stack space


/*
Approach 2: 

1. Let's take prefix, and check by that - want to find the prefix length?
2. Prefix length - go to the word array and find the minmum legth of the word. 
3. Now go through every wodrd, and see the prefix of defined length exists in set. ; if so, recursvey look for the rest of the part of the word. edge case -- make sure to not use same word as prefix!! - cat, cat not correct! but catcat is correct.
4. once all words are done, retrn the list!! - we dont have to check for duplicates, why? Re-read problem statement.
5. note: if min word length is 3; the combination of any two words will always be more than or equal to (3*2)
TC: O()
SC: O(h) ?
*/

class Solution {
    List<String> result;
    Set<String> set;
    int len;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
       
        if(words == null) return new ArrayList<>();
        
        //System.out.println(words.length);
        result = new ArrayList<>();
        set = new HashSet<>();
        
        //find minimum length - that will be the prefix length! and also add those in set!
        len = Integer.MAX_VALUE;
        //Arrays.sort(words);
        
        for(String word : words)
        {
            len = Math.min(len, word.length());
            
            set.add(word);
        }
       //System.out.println("Prefix : "+len);
       
        //now go through the words array! 
        for(String word : words)
        {
            if(word.length() < 2*len) continue; // wedon't look for the prefix words itself! ex: cat, cats, dog, dogs
            
            if((isValidWord(word)))
                result.add(word);
        }
        return result;
    }
    
    private boolean isValidWord(String word)
    {
        //logic
        if(word.length() <2*len)
        {
           return set.contains(word);
        }
        
        //for-loop based recursion
        for(int i=0; i< word.length()-len; i++)
        {
            String prefix = word.substring(0,i+len);
            String suffix = word.substring(i+len);

            if(!set.contains(prefix)) continue;
            else if( set.contains(prefix) && (set.contains(suffix)  || isValidWord(suffix)))
                    return true;
        }
        return false; // if we exited the for loop and couldn't find anything, just return false!
        
    }
}