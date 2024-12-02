class Solution {
    public String intToRoman(int num) {
        String[] thousand = {"","M","MM","MMM"};
        String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] one = {"" ,"I","II","III","IV","V","VI","VII","VIII","IX"};

        StringBuilder sb = new StringBuilder();

        sb.append(thousand[num/1000]);
        sb.append(hundred[(num%1000)/100]);
        sb.append(ten[(num%100)/10]);
        sb.append(one[num%10]);

        return sb.toString();
    }
}