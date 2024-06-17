

public class Diamond {
     public static void main(String args[]){

          int n = 3;

          for (int i = 0; i <n ; i++) {

                //Spaces
               for (int j = 0; j <n-i; j++) {
                   
                    System.out.print(" ");
               }

               //Stars
               for (int j = 0; j <= i; j++) {
                    System.out.print(" *");
               }

               System.out.println();
               
          }

          for (int i = n; i >=0 ; i--) {

               //Spaces
              for (int j = 0; j <n-i; j++) {
                  
                   System.out.print(" ");
              }

              //Stars
              for (int j = 0; j <= i; j++) {
                   System.out.print(" *");
              }

              System.out.println();
              
         }
     }
}
