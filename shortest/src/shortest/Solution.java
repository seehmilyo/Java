package shortest;

public class Solution {
	//warshell o(n^3)
	/*public static void main(String args[]) {
	int [][] rou=new int[10][10] ;
	int n=3;//���趥�����3��������͵��ֱ��д��3���Ͳ�����������
	int inf=10000;//����Ϊ���޴����
	//��ʼ��
for(int i=1;i<=n;i++) {
	for(int j=1;j<=n;j++) {
		rou[i][j]=inf;
		if(i==j)
			rou[i][i]=0;
	}
}
//�������Ǽ����������������ߣ�����͵��ֱ��д�Ͳ�����������
//rou[1][2]=6��ʾ1->2����6�Դ�����
rou[1][2]=6;
rou[2][3]=8;
rou[1][3]=7;
for(int i=1;i<=n;i++) {
	for(int j=1;j<=n;j++) {
		System.out.printf("%d ",rou[i][j]);
	}
	System.out.println( );
	}
System.out.println( );
//֮ǰ��c����д��������룬˼·�������Ȳ���k��һ�㣬ij��������rou[i][j]С�͸���
 //k��һ��ѭ������ÿ�θ���һ���µĽ��kʹ��rou[i][j]���ԱȽ�
for(int k=1;k<=n;k++) {
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=n;j++) {
			if(rou[i][j]>rou[i][k]+rou[k][j]) {
				rou[i][j]=rou[i][k]+rou[k][j];
			}
		}
	}
}
for(int i=1;i<=n;i++) {
	for(int j=1;j<=n;j++) {
		System.out.printf("%d ",rou[i][j]);
	}
	System.out.println( );
	}
	}
	*/
	//ִ�����������ʱ����������һ�����ԸĽ��ĵط�����������Ϊ��ʼ��rou[i][j]��i�ܲ��ܺ�Ϊ1��
	//Ҳ��˵ֻ�����Դ��1������������бȽϣ��������·��������ܲ��ܽ�ά��һά����
	//�������ĸĽ����������ĵϽ�˹�����㷨��bellman�����Ȩ��
//���Ƚ���bellman�㷨���������Ͽ��Եó�bellman
//���붥�㼰�ߵ�Ȩֵ���������5����5���ߣ����忴mspaint�ϻ���ͼ
public static void main(String args[]) {
int[] dis=new int[10];
int[] u=new int[10];
int[] v=new int[10];
int[] w=new int[10];
int n=5,m=5;
//��һ�����2->3 Ȩֵ2
	u[1]=2;v[1]=3;w[1]=2;
	u[2]=1;v[2]=2;w[2]=-3;
	u[3]=1;v[3]=5;w[3]=5;
	u[4]=4;v[4]=5;w[4]=2;
	u[5]=3;v[5]=4;w[5]=3;
	int inf=10000;
	for(int i=1;i<=n;i++) {
		dis[i]=inf;
	}
	dis[1]=0;
//���Ĵ���o(m*n)
	for(int k=1;k<=n-1;k++)//ȥ���Լ��������
		for(int i=1;i<=m;i++)//��ѭ��m���ߣ���ÿ�����޸�
			if(dis[v[i]]>dis[u[i]]+w[i])//����u[i]������v[i]������ȨֵΪw[i]
				dis[v[i]]=dis[u[i]]+w[i];
//��ӡ
	for(int i=1;i<=n;i++) {
	System.out.println(dis[i]);
}
}

}
