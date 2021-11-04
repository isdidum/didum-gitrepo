package com.djava;

public class DiamondCmdLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Type 5 in command line prompt
		//int N = Integer.parseInt(args[0]);
		int N = 4;
        for (int i = -N; i <= N; i++) {
            for (int j = -N; j <= N; j++) {
                if (Math.abs(i) + Math.abs(j) <= N) 
                	System.out.print("* ");
                else                                
                	System.out.print(". ");
            }
            System.out.println();
        }
	}

}