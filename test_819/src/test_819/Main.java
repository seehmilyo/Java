package test_819;
import java.util.ArrayList;
//���ͣ�Ƕ���������Ƶ���
public class Main {
public static void main(String[] args) {
	//����㲻д<>,����������ʾ��
	//ArrayList ��ԭʼ���͡�Ӧ�ý���ͨ������ ArrayList<E> �����ò�����
	ArrayList<String> list=new ArrayList<>();
	//���������Ƶ�ArrayList<String> list=new ArrayList<String>();
	list.add("Hello"); //����
	list.add("World");
	System.out.println(list);
	Object L=list.clone();
	int location=list.indexOf("Hello");
	list.remove(location);
	System.out.println(list);
	System.out.println(L);
}
}