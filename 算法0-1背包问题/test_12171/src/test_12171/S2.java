
package test_12171;

 

//0-1背包问题

public class S2 {

	

	public static int knapsack(int[] weight, int[] value, int maxweight){

 

		int n = weight.length;

		//最大价值数组为maxvalue[N+1][maxWeight+1]，因为我们要从0开始保存

		int[][] maxvalue = new int[n+1][maxweight + 1];

		

		//重量和物品为0时，价值为0

		for (int i = 0; i < maxweight + 1; i++) {

			maxvalue[0][i] = 0;

			

		}

		for (int i = 0; i < n + 1; i++) {

			maxvalue[i][0] = 0;

			

		}

		

		//i：只拿前i件物品（这里的i因为取了0，所以对应到weight和value里面都是i-1号位置）      

		//j：假设能取的总重量为j

		//n是物品件数

		for (int i = 1; i <= n ; i++) {

			for (int j = 1; j <= maxweight; j++) {

				//当前最大价值等于放上一件的最大价值

				maxvalue[i][j] = maxvalue[i-1][j];

				//如果当前件的重量小于总重量，可以放进去或者拿出别的东西再放进去

				if (weight[i-1] <= j) {

					//比较（不放这个物品的价值）和

					//（这个物品的价值 加上 当前能放的总重量减去当前物品重量时取前i-1个物品时的对应重量时候的最高价值）

					if(maxvalue[i-1][j - weight[i-1]] + value[i-1]>maxvalue[i-1][j]) {

						maxvalue[i][j] = maxvalue[i-1][j - weight[i-1]] + value[i-1];

					}

				}

			}

		}

		return maxvalue[n][maxweight];

	}
//动态规划法
	public static void main(String[] args) {
		int xunhuan=100;
		while(xunhuan>0) {
		int n=100;//物品数
		int weight[] = new int[n];
		int value[] = new int[n];
		int sumWeight=0;
		for(int i=0;i<n;i++) {
			weight[i]=(int) (Math.random()*10+1);
			sumWeight+=weight[i];
			value[i]=(int)(Math.random()*100+1);
		}
		int maxWeight=sumWeight*2/3;
		
		long a=System.nanoTime();
		knapsack(weight, value, maxWeight);
		//System.out.println(knapsack(weight, value, maxWeight));
		long b=System.nanoTime();
		System.out.print((b-a)+" ");
		xunhuan--;
		}
	}

 

}
