package is13116371;

import java.util.*;
import java.io.*;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
public class is13116371 
{
        
        public static class God{

       
                private double crossOverProbability;
                private double mutationProbabilty;
                private double reproductionProbabilty;
                private ArrayList<double[]> myCreation;

        
                
                public God(double cp,double mp,double rp){
                   this.crossOverProbability =cp;
                   this.mutationProbabilty=mp;
                   this.reproductionProbabilty=rp;
                }
                
                public void iAmTheLigthAndTheTruth(){
                    double philosophersStone =  (double)(Math.random() * 1);
                    System.out.println(philosophersStone);
                
                }
                public ArrayList<double[]> getMyCreation() {
                    return myCreation;
                }

                public void setMyCreation(ArrayList<double[]> myCreation) {
                    this.myCreation = myCreation;
                }
                public double getCrossOverProbability() {
                    return crossOverProbability;
                }

                public void setCrossOverProbability(double crossOverProbability) {
                    this.crossOverProbability = crossOverProbability;
                }

                public double getMutationProbabilty() {
                    return mutationProbabilty;
                }

                public void setMutationProbabilty(double mutationProbabilty) {
                    this.mutationProbabilty = mutationProbabilty;
                }

                public double getReproductionProbabilty() {
                    return reproductionProbabilty;
                }

                public void setReproductionProbabilty(double reproductionProbabilty) {
                    this.reproductionProbabilty = reproductionProbabilty;
                }
                
        
        }
        public static  class MySorter {
     
            private double array[];
            private ArrayList<double[]>pops;
            private int length;
            public void testFitnessArray(){
              for(int i = 0;i<array.length;i++){
                System.out.println("Fitness Sort Test: "+array[i]);
              }
            }
            public void testPopulationsArray(){
             double[] array = new double [pops.get(0).length];
             String res="";
             for (int j=0;j<pops.size();j++){
              res+="Test fitness val for Population: "+j+" value:  "+this.array[j];
              array = pops.get(j);
              for(int i = 0;i<array.length;i++){
                res+= "Test: "+array[i];             
              }
              res+="\n";
             }
             System.out.println(res);
            }
            public void sort(double[] inputArr,ArrayList<double[]> populations) {

                if (inputArr == null || inputArr.length == 0) {
                    return;
                }
                this.array = inputArr;
                this.pops = populations;
                length = inputArr.length;
                quickSort(0, length - 1);
            }
            public void Darwin(ArrayList<double[]> populations){
                       int len =populations.size();
                       int breakUp =len / 3 ;
                       int switcher = len - breakUp;
                       double [] array1;
                       for (int i=0;i<breakUp;i++){
                       //System.out.println("Test Valuse here: "+i);
                       //System.out.println("getting the array from list");
                         array1 = populations.get(i);
                         //System.out.println("the length is "+array1.length);
                         //System.out.println("Removing index_ "+(switcher + i));
                          this.pops.remove(switcher + i);
                          //System.out.println("adding index_"+(switcher + i));
                         this.pops.add((switcher + i),array1);
                         //System.out.println("taking value at array index "+i+" value is "+this.array[i]);
                         double tmp = this.array[i];
                         //System.out.println("switching value at array index "+(switcher+i)+" the value I take out  is "+this.array[switcher+i]);
                         this.array[switcher + i] =tmp;
                         //System.out.println("new value at array index "+(switcher+i)+" should be "+this.array[i]+" = "+tmp);
                       }  
            }
            public void quickSort(int lowerIndex, int higherIndex) {
                int i = lowerIndex;
                int j = higherIndex;
                // calculate pivot number, I am taking pivot as middle index number
                double pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
                // Divide into two arrays
                while (i <= j) {
                    while (array[i] < pivot) {
                        i++;
                    }
                    while (array[j] > pivot) {
                        j--;
                    }
                    if (i <= j) {
                        exchangeNumbers(i, j);
                        exchangeArrays(i,j);
                        i++;
                        j--;
                    }
                }
                // call quickSort() method recursively
                if (lowerIndex < j)
                    quickSort(lowerIndex, j);
                if (i < higherIndex)
                    quickSort(i, higherIndex);
            }
            private void exchangeNumbers(int i, int j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
             private void exchangeArrays(int i, int j) {
                double [] temp = this.pops.get(i);
                double [] temp2 = this.pops.get(j);
                this.pops.remove(i);
                this.pops.add(i,temp2);
                this.pops.remove(j);
                this.pops.add(j,temp);
            }
        }
        public static class AI extends JFrame{
	    public  int v=0;  // number of nodes
	    public  int [][] adj;  // the adjacency matrix 
	    public  double [] ordering_last_result;
	
	// v is the size of the graph, or size of each ordering 
	// adjacency_matrix is the matrix or 2D array which you initially read it from the txt file.
	// ordering is the 1D array which contains the very last ordering

	
	public AI()  // this method must have same name as the class above.
	{
		setTitle("AI");
		setSize(960,960);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
        public void setMatrix(int [][] mat){
          this.adj  = mat;
        }
        public void setOrderingLastResult(double[] res){
          this.ordering_last_result = res;
          this.v = this.ordering_last_result.length;
        }
	public void paint(Graphics g)
	{
		int radius =100;
		int mov =200;
		
		double w = Math.sqrt((double)v);
		if(Math.floor(w)<w)
		{
			w=Math.floor(w);
			w++;
		}		
		for(int i=0;i<v;i++)
		{
			for(int j=i+1;j<v;j++)
			{ 
				if(adj[i][j]==1)  
				{
                                    g.drawLine(
                                    (int)(((double) ordering_last_result[i] % w)*radius + mov), 
                                    (int)(((double) ordering_last_result[i] / w)*radius+mov), 
                                    (int)(((double) ordering_last_result[j] % w)*radius + mov),
                                    (int)(((double) ordering_last_result[j] / w)*radius+mov));
				}
			}
		}
	}
    
    }
	public static final int popSize =100;
        
        public static class Coordinates{
           
            private int i_vertex_x;
            private int j_vertex_x;
            private int i_vertex_y;
            private int j_vertex_y;

            public void Coordinates(){
              
            }
            public int getI_vertex_x() {
                return i_vertex_x;
            }

            public void setI_vertex_x(int i_vertex_x) {
                this.i_vertex_x = i_vertex_x;
            }

            public int getJ_vertex_x() {
                return j_vertex_x;
            }

            public void setJ_vertex_x(int j_vertex_x) {
                this.j_vertex_x = j_vertex_x;
            }

            public int getI_vertex_y() {
                return i_vertex_y;
            }

            public void setI_vertex_y(int i_vertex_y) {
                this.i_vertex_y = i_vertex_y;
            }

            public int getJ_vertex_y() {
                return j_vertex_y;
            }

            public void setJ_vertex_y(int j_vertex_y) {
                this.j_vertex_y = j_vertex_y;
            }
                                  
            
        
        }
        public static class SquareTable{ 

              private double [][] populationString;
              private int newSize;               
             
              public SquareTable(){
                           
              }
              public int getNewSize() {
                 return newSize;
              }

              public void setNewSize(int newSize) {
                this.newSize = this.populationString.length;
              }
              public double[][] getPopulationString() {
               return populationString;
              }

              public void setPopulationString(double[] populationString) {
                 
                   this.setMatrix(populationString.length);
                   this.calculate(populationString);
                   
              }

     
              public int [] getVertex(int row,int col,int val){
                  //System.out.println("getVertex "+ row+" "+col);
                  int [] multiplex = new int [4];
                  int len = this.getNewSize();
                  for(int i = 0;i< len;i++){
                    for (int j = 0;j < len;j++){
                       if(populationString[i][j]==row){
                         multiplex[0]=i;
                         multiplex[1]=j;
                       }
                        if(populationString[i][j]==col){
                         multiplex[2]=i;
                         multiplex[3]=j;
                       }
                    }
                  }
                return multiplex;
              }
              public void calculate(double[] populationString){
              // System.out.println("In calculate");
              String res="";
               int c_ctr =0;
               int len = this.populationString.length;
               int len2 = populationString.length;
                for(int i=0;i<len;i++){
                   for(int j=0;j<len;j++){
                     if(c_ctr< len2){
                        this.populationString[i][j]=populationString[c_ctr];
                        res+=""+this.populationString[i][j]+" ";
                        c_ctr++;
                     }
                   }
                   res+="\n";   
                }
                //System.out.println(res);
              }
              public void newMatrixPop(){
                  // System.out.println("In calculate");
                String res="";
                 int c_ctr =0;
                 int len = this.populationString.length;
                 for(int i=0;i<len;i++){
                   for(int j=0;j<len;j++){
                     if(c_ctr< len){
                        res+=""+this.populationString[i][j]+" ";
                     }
                   }
                   res+="\n";   
                }
                 System.out.println(res);
              }
              public void setMatrix(int index) {
                 
                 int len = (int)Math.round(Math.sqrt(index));
                 this.populationString = new double [len][len];
                 this.setNewSize(len);
                 
                 
              }

            }
            public static void main(String [] args){

               ArrayList<double[]>populations = new ArrayList<double[]>();
                if(args.length!=1){
                  System.out.println("is131163 usage: java is13116371 <enter file name>");
                  System.exit(1);
                }
                try{
                  File dataFile = new File(args[0]);
                  Scanner in = new Scanner(dataFile);
                  int maxNum = getMaxEdges(in)+1;
                  int [][]matrixArray = new int [maxNum][maxNum];
                  double [] fitnesseFunc = new double[popSize];
                  setToZero(matrixArray,maxNum);
                  createMatrix(dataFile,in,maxNum,matrixArray);
                  //displayMatrix(matrixArray,maxNum);
                  for(int a=0;a<popSize;a++){
                    generatePopulation2(maxNum,populations,a);
                  }
                  //displayPopulations(populations,maxNum);
                  runFitnessFunction(populations,maxNum,matrixArray,fitnesseFunc);
                  MySorter betterSorting = new MySorter();
                  betterSorting.sort(fitnesseFunc, populations);     
                  AI visualization = new AI();
                  visualization.setMatrix(matrixArray);
                  visualization.setOrderingLastResult(populations.get(0));
                  visualization.repaint();
                  betterSorting.Darwin(populations);
                 // betterSorting.testPopulationsArray();
                 God god =new God(0.10,0.05,0.85);
                 for(int i=0;i<1000;i++){
                     god.iAmTheLigthAndTheTruth();
                 }
                  
                  
                  
                }
                catch( IOException e){
                    System.out.println("ERROR\nthis file does not exists!\nDid you specify the path?");
                }
	    }
            
            public static void runFitnessFunction(ArrayList<double[]> populations,int n,int [][]matrixArray, double [] fitnesseFunc){
                SquareTable[] tables = new SquareTable[popSize];
                SquareTable squareTable;
                Coordinates vertexHelper = new Coordinates(); ;
                double fitness=0;
                int returnMultiplex[];
                double len1;
                double len2;
                
                /**
                 * create individual population matrix and store in array of SquareTable type.
                 */
                
                for(int i=0;i<populations.size();i++){   
                  squareTable = new SquareTable();
                  squareTable.setPopulationString(populations.get(i));
                  tables[i]=squareTable;
                  // testRun to see what is being created here
                  // tables[i].newMatrixPop();
                }
                for(int x= 0;x<popSize;x++){
                    for(int row = 0; row< matrixArray.length;row++){

                       for(int col=0;col<n;col++){
                          if(matrixArray[row][col]==1){

                           returnMultiplex= tables[x].getVertex(row, col, col);
                          // System.out.println("Test MP "+returnMultiplex[0]+" "+returnMultiplex[1]+returnMultiplex[2]+" "+returnMultiplex[3]);
                              vertexHelper.setI_vertex_x(returnMultiplex[0]);
                              vertexHelper.setI_vertex_y(returnMultiplex[1]);
                              vertexHelper.setJ_vertex_x(returnMultiplex[2]);
                              vertexHelper.setJ_vertex_y(returnMultiplex[3]);
                              len1 = Math.pow((vertexHelper.getI_vertex_x())-(vertexHelper.getJ_vertex_x()),2);
                              len2 = Math.pow((vertexHelper.getI_vertex_y())-(vertexHelper.getJ_vertex_y()),2);
                              len1 = Math.sqrt(len1 + len2);
                              fitness = fitness + len1;
                          }
                       }
                    }
                    fitnesseFunc[x]=fitness;
                    fitness = 0;  
                }
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
            public static void createMatrix(File dataFile, Scanner in, int n,int [][] matrixArray) throws IOException{
            String currentLine="";


             in = new Scanner(dataFile);

             while (in.hasNextLine()){

               currentLine =in.nextLine();
               String [] tmp = currentLine.split(" ");
               matrixArray[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] =1;
               matrixArray[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])] =1;
                    }
                in.close();
            }	
            public static void arrayHelper2(int num,int maxNum,double[]array,int i){
                    num= randomNum(maxNum);
                          while(singleArrayHasDublicate2(num,array,i)==true){
                           num=randomNum(maxNum); 
                          }
                          array[i]=num;
            }
            public static void createSingleArray2(int maxNum,double[] array){
               int num=0;
               for(int i=0;i<maxNum;i++){
                     if(i==0){
                       num= randomNum(maxNum);
                       array[i]=num;
                     }
                         else{
                               arrayHelper2(num,maxNum,array,i);
                            }
                       }
            }
            public static void generatePopulation2(int maxNum, ArrayList<double[]> populations,int a){
                    // generate random permutation of string of 0 to max num
                  int num=0;
                  double [] array = new double[maxNum];
                  int j =0;
                  createSingleArray2(maxNum,array);
                  if(a == 0){
                     addArray2(maxNum,array,populations,a);
                  }
                   else{
                      while(ArrayHasDublicateArray2(array,populations) == true){
                       createSingleArray2(maxNum,array);
                   }
                   addArray2(maxNum,array,populations,a);
                   }
            }
            public static void addArray2(int maxNum,double []array, ArrayList<double[]> populations,int a){
	      populations.add(a,array);
            }
            public static void displayPopulations2(ArrayList<double[]> populations,int n){
		int len = populations.size();
		for(int i=0;i<len;i++){
			for(int j=0;j<n;j++){
			  	double [] tmp = populations.get(i);
			  	System.out.print(tmp[j]+" ");
			}
			System.out.println("\n ");
		}
	    }
            public static boolean ArrayHasDublicateArray2(double [] array,ArrayList<double[]> populations){
		boolean isDouble = false;
		int listLen = populations.size();
		int arrayLen = array.length;
		int ctr=0;
		boolean keepGoing = true;
		for(int i=0;i<listLen && keepGoing;i++){
                    for(int j=0;j<arrayLen;j++){
                      double [] tmp=populations.get(i);
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
            public static boolean singleArrayHasDublicate2(int num,double []array,int currentCols){
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
