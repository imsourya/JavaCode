package duega.algo;

class TOH
{
	static int [] countList;
	static void towerOfHanoi(int n, char from_rod,
			char to_rod, char aux_rod)
	{
		if (n == 1)
		{
			System.out.println("Move disk 1 from rod "+
					from_rod+" to rod "+to_rod);
			countList[n]++;
			return;
		}
		
		towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
		System.out.println("Move disk "+ n + " from rod " +
				from_rod +" to rod " + to_rod );
		countList[n]++;
		towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
	}

	//Driver code
	public static void  main(String args[])
	{
		int n = 5; // Number of disks
		countList = new int[n+1];
		towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
		for(int i=1;i<=n;i++) {
			System.out.println(i+" = "+countList[i]);
		}
	}
}
