class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> s = new HashMap<>();
        Map<Character,Integer> g = new HashMap<>();
        int bulls=0;
        int cows=0;

        for(int i=0;i<secret.length();i++){
            char ch = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if(ch== ch2){
                bulls++;
            }
            else{
                s.put(ch, s.getOrDefault(ch,0)+1);
                g.put(ch2, g.getOrDefault(ch2,0)+1);


            }
        }
        for(char c:s.keySet()){
                    if(g.containsKey(c)){
                        cows+= Math.min(s.get(c),g.get(c));
                    }
                }

        return bulls+"A"+cows+"B";
    }
}
