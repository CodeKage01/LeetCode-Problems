class Solution {
    public int totalMoney(int n) {
        int day = 0;
        int money = 0;
        int mondayBase = 1;

        while(day < n){
            int cur = mondayBase;
            for(int i=0;i<7 && day < n;i++){
                money+= cur;
                cur++;
                day++;
            }
            mondayBase++;
        }

        return money;
    }
}
