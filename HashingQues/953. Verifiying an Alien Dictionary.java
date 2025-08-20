class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[]map = new int[26];
        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a']=i;
        }


        for(int i=0;i<words.length-1;i++){
            if(!correct(words[i],words[i+1],map)){
                return false;
            }
        }
        return true;
    }


    public boolean correct(String word1, String word2, int[] map){
        int n = Math.min(word1.length(), word2.length());

        for(int i=0;i<n;i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if(c1!=c2){
                if(map[c1-'a']> map[c2-'a']){
                    return false;
                }
                return true;
            }
        }

        return word1.length()<= word2.length();
    }
}
