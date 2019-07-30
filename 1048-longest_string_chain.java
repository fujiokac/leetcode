/**
 * Given a list of words, each word consists of English lowercase letters.
 *
 * Let's say word1 is a predecessor of word2 if and only if
 * we can add exactly one letter anywhere in word1 to make it equal to word2.
 * For example, "abc" is a predecessor of "abac".
 *
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1,
 * where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 *
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 */

 class Solution {
    private Map<String, Integer> chainMap = new HashMap<String, Integer>();
    // TreeMap sorted in reverse
    private TreeMap<Integer, ArrayList<String>> wordMap = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder());

    public int longestStrChain(String[] words) {
        // Map words
        parse(words);
        // Find chains
        compute();
        // Check for case of no predecessors
        return chainMap.isEmpty() ? 1 : Collections.max(chainMap.values());
    }
    /**
     * Map words by length (added to a list)
     */
    public void parse(String[] words) {
        for(String word: words) {
            Integer len = word.length();
            ArrayList<String> values = wordMap.get(len);
            if (values == null) {
                values = new ArrayList<String>();
                wordMap.put(len, values);
            }
            values.add(word);
        }
    }

    /**
     * Iterate through words in order of greatest to least length
     * Search words of length-1 to find predecessors
     * Skip previously processed words
     */
    public void compute() {
        for(Integer len : wordMap.keySet()) {
            if(wordMap.containsKey(len-1)) {
                for(String word : wordMap.get(len)) {
                    if(!chainMap.containsKey(word)) {
                        findChain(word, len);
                    }
                }
            }
        }
    }
    /**
     * Determine if a word has predecessors
     * Recursively check for predecessors until either no words of len-1 or 0 length is reached
     * Add predecessor words to map<word, chain length>
     */
    public int findChain(String word, int len) {
        if(len > 1 && wordMap.containsKey(len-1)) {
            for(String pred : wordMap.get(len-1)) {
                if(isPred(pred, word)) {
                    int chain = 1;
                    if(chainMap.containsKey(pred)) {
                        chain += chainMap.get(pred);
                    }
                    else {
                        chain += findChain(pred, len-1);
                    }
                    chainMap.put(word, chain);
                    return chain;
                }
            }
        }

        chainMap.put(word, 1);
        return 1;
    }

    /**
     * Compare characters in a string, allowing for one difference
     * pred.length() should be word.length()-1
     */
    public boolean isPred(String pred, String word) {
        int pLen = pred.length();
        int wLen = word.length();
        boolean diff = false;
        for(int p = 0, w = 0; p < pLen && w < wLen; p++, w++) {
            if(pred.charAt(p) != word.charAt(w)) {
                if(diff) {
                    return false;
                }
                diff = true;
                p--;
            }
        }
        return true;
    }
}