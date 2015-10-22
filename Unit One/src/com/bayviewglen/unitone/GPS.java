package com.bayviewglen.unitone;

public class GPS {

	public static void main(String[] args) {
		double[][] points = {
				{-1,3},
				{-1,-1},
				{1,1},
				{2,0.5},
				{2,-1},
				{3,3},
				{4,2},
				{4,-0.5}
		};	
		String s = "";
		double distance = Double.MAX_VALUE;
		
		
		for(int i = 0; i<points.length; i++){
			for(int j = 0; j<points.length; j++){
				if(distance(points[i],points[j])<distance&&i!=j){
					s = "The closest two points are (" + points[i][0]
							+ ", " + points[i][1] + ") and (" +  points[j][0]
									+ ", " + points[j][1] + ")." + " Distance: " + distance(points[i],points[j]);
					distance = distance(points[i],points[j]);
				}
			}
		}
	System.out.println(s);
		
	}
	public static double distance(double[] x1y1, double[] x0y0){
		return Math.sqrt(Math.pow(x1y1[0]-x0y0[0], 2)+Math.pow(x1y1[1]-x0y0[1], 2));
	}
	
}
