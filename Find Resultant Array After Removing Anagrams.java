class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();

        res.add(words[0]);

        for(int i=1;i<words.length;i++){
            String cur = words[i];
            String prev = res.get(res.size()-1);

            if(!isAnangram(cur,prev)){
                res.add(cur);
            }
        }

        return res;
    }

    private boolean isAnangram(String s1, String s2){
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }
}
