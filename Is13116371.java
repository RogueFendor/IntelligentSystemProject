import java.util.*;
import java.io.*;
public class Is13116371 
{
	public static final int popSize =100;
	public static void main(String [] args) throws IOException{
		
		File dataFile = new File("data.txt");
	    Scanner in = new Scanner(dataFile);
        int maxNum = getMaxEdges(in)+1;
        int [][]matrixArray = new int [maxNum][maxNum];

        setToZero(matrixArray,maxNum);

        createMatrix(in,maxNum,matrixArray);
        displayMatrix(matrixArray,maxNum);
        generatePopulation(maxNum);

	}

	public static void setToZero(int [][] matrixArray,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
			  	matrixArray[i][j] = 0;	  
			}
		}
	}
	public static int getMaxEdges(Scanner in) throws IOException{
        String n =""; 
        int max1=0;
        int max2=0;
		while (in.hasNextLine()){
           n =in.nextLine();
           String [] tmp = n.split(" ");
           if(Integer.parseInt(tmp[0]) > max1){
           	max1 = Integer.parseInt(tmp[0]);
           }
           if(Integer.parseInt(tmp[1]) > max1){
           	max2 = Integer.parseInt(tmp[1]);
           }
		}
	    in.close();
	    if (max1 > max2)
	        return max1;
	    else
	    	return max2;
	}
	public static void createMatrix( Scanner in, int n,int [][] matrixArray) throws IOException{
        String currentLine="";
         File dataFile= new File("data.txt");
         in = new Scanner(dataFile);
         while (in.hasNextLine()){
           currentLine =in.nextLine();
           String [] tmp = currentLine.split(" ");
           matrixArray[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] =1;
           matrixArray[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])] =1;
		}
	    in.close();
	}	
	public static void generatePopulation(int maxNum){

		// generate random permutation of string of 0 to max num
           
           /*   
               
            
           */

       int num=0;
     
       int 
       for(int i=0; i<maxNum+1;i++){
           num = randomNum(maxNum);
           System.out.println(num);
       }
	}
    public static void displayMatrix(int [][] matrixArray,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
			  	//System.out.print(matrixArray[i][j]+" ");
			}
			//System.out.println("\n");
		}
	}
	public static int randomNum(int maxNum){

		return (int)(Math.random() * maxNum);
	}
}