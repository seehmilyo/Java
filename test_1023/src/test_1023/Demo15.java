package test_1023;

public class Demo15 {
	//���������ܣ������پ�̬�����е��ó�Ա�����ͳ�Ա����
	//�����ڳ�Ա�����е��þ�̬���������þ�̬����
	public static void main(String[] args) {
		//���ܶ����� Demo15 �еķǾ�̬���� method1�������о�̬����
		method1();
	}
	public static void method1() {
		method2();
	}
	public void method3() {
		
	}
	public static void method2() {
		//���ܶԷǾ�̬�ֶ� c ���о�̬����
		System.out.println(c.getRadius());
		//����ʵ����������ͨ����
		Demo15 l=new Demo15();
		l.method3();
	}
	static Circle c=new Circle();
}