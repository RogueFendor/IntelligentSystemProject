import java.util.*;
import java.io.*;
public class Is13116371 
{
	public static final int popSize =100;
	
        public static void main(String [] args) throws IOException{
		 
		 ArrayList<int[]>populations = new ArrayList<int[]>();
         File dataFile = new File("data.txt");
	     Scanner in = new Scanner(dataFile);
         int maxNum = getMaxEdges(in)+1;
         int [][]matrixArray = new int [maxNum][maxNum];

         setToZero(matrixArray,maxNum);

         createMatrix(in,maxNum,matrixArray);
         displayMatrix(matrixArray,maxNum);
         for(int a=0;a<popSize;a++){

            generatePopulation(maxNum,populations,a);
         }
         displayPopulations(populations,maxNum);
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
	public static void arrayHelper(int num,int maxNum,int[]array,int i){
		num= randomNum(maxNum);
		      while(singleArrayHasDublicate(num,array,i)==true){
	               num=randomNum(maxNum); 
		      }
		      array[i]=num;
	}
	public static void createSingleArray(int maxNum,int[] array){
           int num=0;
           for(int i=0;i<maxNum;i++){
	         if(i==0){
	           num= randomNum(maxNum);
	           array[i]=num;
	         }
		     else{
			   arrayHelper(num,maxNum,array,i);
			}
		   }
	}
    public static void generatePopulation(int maxNum, ArrayList<int[]> populations,int a){
    	 // generate random permutation of string of 0 to max num
       int num=0;
       int [] array = new int [maxNum];
       int j =0;
		    createSingleArray(maxNum,array);
		   if(a == 0){
   	         addArray(maxNum,array,populations,a);
   	       }
   	       else{
               while(ArrayHasDublicateArray(array,populations) == true){
               	createSingleArray(maxNum,array);
               }
               addArray(maxNum,array,populations,a);
   	       }
	}
	public static void addArray(int maxNum,int []array, ArrayList<int[]> populations,int a){
	    populations.add(a,array);
	}
    public static void displayMatrix(int [][] matrixArray,int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
			  	//System.out.print(matrixArray[i][j]+" ");
			}
			//System.out.println("\n");
		}
	}
	public static void displayPopulations(ArrayList<int[]> populations,int n){
		int len = populations.size();
		for(int i=0;i<len;i++){
			for(int j=0;j<n;j++){
			  	int [] tmp = populations.get(i);
			  	System.out.print(tmp[j]+" ");
			}
			System.out.println("\n ");
		}
	}
	public static boolean ArrayHasDublicateArray(int [] array,ArrayList<int[]> populations){
		boolean isDouble = false;
		int listLen = populations.size();
		int arrayLen = array.length;
		int ctr=0;
		boolean keepGoing = true;
		for(int i=0;i<listLen && keepGoing;i++){
	      for(int j=0;j<arrayLen;j++){
	      	int [] tmp=populations.get(i);
	      	if(array[j] != tmp[j]){
	            keepGoing = false;
	            break;
	      	} 
	      	else{
	      		isDouble = true;
	      	}
	      }
	    }
		return isDouble;
	}
	public static boolean singleArrayHasDublicate(int num,int []array,int currentCols){
		boolean isDouble = false;
		for(int i=0;i<currentCols;i++){
			if(array[i] == num){
			  isDouble = true;
			  break;
			}
		}
		return isDouble;
	}
	public static int randomNum(int maxNum){

		return (int)(Math.random() * maxNum);
	}
}
