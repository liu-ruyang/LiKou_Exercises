package org.example.greedy_question;

public class Question860 {

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        // int count20 = 0;
        // 5 10 20分别是需要0 5 15找零
        // 15 有两种组合5+10，5+5+5

        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    count5++;
                    break;
                case 10:
                    count10++;
                    if (count5 >= 1)
                        count5--;
                    else return false;
                    break;
                case 20:
                    if (count10 >= 1 && count5 >= 1) {
                        count10--;
                        count5--;
                    } else if (count5 >= 3) {
                        count5 -= 3;
                    } else return false;
                    break;
            }
        }
        return true;
    }
}
