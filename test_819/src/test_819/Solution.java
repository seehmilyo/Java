package test_819;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list;
        // list ��һ�����ã�List ���͵Ľӿ����� ��java �﷨��
        // list �߼�����һ�����Ա�
        // ���Ա���Ԫ�������� List<Integer>
        //            (java �﷨) List ���͵Ľӿ�����
        //                        Ԫ�������� Integer �����͵�����
        //                        Integer �� int �İ�װ��
        list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>(100));
        }

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = list.get(i);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1)
                        + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
	}
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list;
        // list ��һ�����ã�List ���͵Ľӿ����� ��java �﷨��
        // list �߼�����һ�����Ա�
        // ���Ա���Ԫ�������� List<Integer>
        //            (java �﷨) List ���͵Ľӿ�����
        //                        Ԫ�������� Integer �����͵�����
        //                        Integer �� int �İ�װ��
        list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = list.get(i);
            nums.add(1);
            for (int j = 1; j < i; j++) {
                int num = list.get(i - 1).get(j - 1)
                        + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }
        return list;
    }


    private static void printPascalsTriangle(Solution s, int n) {
        System.out.println(s.generate(n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution, 10);
    }
}