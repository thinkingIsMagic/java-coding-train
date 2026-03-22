package leetcode.easy;

public class String_leetcode415 {

    // 思路：模拟
    // 进位、指针指向尾部、while循环、加数求值
    // 时间复杂度：O(n) 空间复杂度：O(n)
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int a = i>=0 ? (num1.charAt(i)-'0') : 0;
            int b = j>=0 ? (num2.charAt(j)-'0') : 0;
            
            int sum = a+b+carry;
            carry = sum/10;
            sb.append(sum%10);

            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}