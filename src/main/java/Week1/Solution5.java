package Week1;

class Solution5 {
    public static int multiply(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        }

        if (num1 < 0 && num2 < 0) {
            num1 = num1 - (num1 + num1);
            num2 = num2 - (num2 + num2);
        }

        if (num2 < 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        return num1 + multiply(num1, num2 - 1);
    }
}
