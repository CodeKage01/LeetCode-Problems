class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);

        String smallest = s;

        while(!q.isEmpty()){
            String cur = q.poll();

            if(cur.compareTo(smallest) < 0){
                smallest = cur;
            }

            // operation 1
            char[] chars = cur.toCharArray();
            for(int i=1;i<chars.length;i+=2){
                int digit = (chars[i]-'0' + a) % 10;
                chars[i] = (char)(digit+'0');
            }
            String addStr = new String(chars);

            // operation 2
            String rotateStr = cur.substring(cur.length()-b) + cur.substring(0,cur.length()-b);

            if(!visited.contains(addStr)){
                q.add(addStr);
                visited.add(addStr);
            }

            if(!visited.contains(rotateStr)){
                q.add(rotateStr);
                visited.add(rotateStr);
            }
        }

        return smallest;
    }
}
