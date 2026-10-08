package exercise09;

import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        boolean isValid = false;

        // Nhập N là số nguyên dương, nếu không hợp lệ thì bắt nhập lại liên tục
        while (!isValid) {
            System.out.print("Nhập một số nguyên dương N: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    isValid = true;
                } else {
                    System.out.println("Số nhập vào không hợp lệ");
                }
            } else {
                System.out.println("Số nhập vào không hợp lệ");
                scanner.next(); // Loại bỏ giá trị không hợp lệ trong bộ nhớ đệm
            }
        }

        System.out.print("Các số Armstrong từ 0 đến " + n + " là: ");
        boolean first = true;

        // Duyệt qua các số từ 0 đến N
        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();

        scanner.close();
    }

    // Phương thức kiểm tra số Armstrong
    public static boolean isArmstrong(int num) {
        if (num < 0) return false;
        if (num == 0) return true;

        int temp = num;
        int digits = 0;

        // Đếm số chữ số (k) của số
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;
        int sum = 0;

        // Tính tổng lũy thừa bậc k của từng chữ số
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == num;
    }
}