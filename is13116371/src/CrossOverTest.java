
import java.util.ArrayList;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anon
 */
public class CrossOverTest {
    public static void main(String [] args){
        
       double [] p1 = {1.0,21.0,28.0,31.0,0.0,18.0,6.0,12.0,22.0,30.0,29.0,27.0,2.0,23.0,10.0,8.0,7.0,9.0,15.0,4.0,25.0,19.0,3.0,5.0,17.0,26.0,14.0,16.0,20.0,24.0,32.0,13.0,11.0}; 
       double [] p2 ={23.0,14.0,15.0,19.0,2.0,1.0,0.0,27.0,9.0,10.0,31.0,11.0,28.0,25.0,30.0,16.0,26.0,22.0,20.0,17.0,3.0,7.0,5.0,12.0,24.0,29.0,13.0,4.0,8.0,18.0,21.0,6.0,32.0};
       double [] p3 ={23.0,14.0,15.0,19.0,2.0,1.0,0.0,27.0,9.0,10.0,31.0,11.0,28.0,25.0,30.0,16.0,26.0,22.0,20.0,17.0,3.0,7.0,5.0,12.0,24.0,29.0,13.0,4.0,8.0,18.0,21.0,6.0,32.0};
       double [] c1 = new double [p1.length];
       double [] c2 = new double [p1.length];
       c1=theBridesChamber(p2, p3, c1);
       c2=theBridesChamber(p3, p2, c2);
       int len = p1.length;
       if(c1[len-1]==c1[len-2]){
         double tmp = c1[len-2];
         c1[len-2] = c2[len-1];
         c2[len-1] = tmp;
       }
       System.out.println("Array1");
       for(int i=0;i<len;i++){
         System.out.print("["+c1[i]+" ");
       
       }
       System.out.println("\nArray2\n\n");
       for(int j=0;j<len;j++){
         System.out.print("["+c2[j]+" ");
       
       }
      
        System.out.println("]\n\n");
    }
   public static double [] theBridesChamber(double [] p1, double []p2,double [] child){
    ArrayList<Double> list = new ArrayList<Double>();
       int len= (p1.length);
        for(int i=0;i<len;i++){
           list.add(i,p1[i]);
           list.add(i+1,p2[i]);
        }
        System.out.println("Test + "+ list.size());
        for(int j=0;j<list.size();j++){
           double n = list.get(j);
           for(int x =j+1;x<list.size();x++){
              // System.out.print("test "+n+ " "+list.get(x)+" ");
            if(n==list.get(x)){
                System.out.println("hit removing"+list.get(x));
              list.remove(x);
            }
           }
        }
       for(int y=0;y<list.size();y++){
          child[y]=list.get(y);
       }
       return child;
      
   }
   public static int streamParent(int i){
       return i++;
   }  
   public static double isDouble(double [] child,double val ,int i,boolean [] cheater,double p1[],double p2[]){
    return 0;
   }
}
