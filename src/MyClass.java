import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Maks on 07.02.2018.
 */
public class MyClass {

    public static void main(String[]args) throws IOException, java.lang.Exception{

        try {

            //Matrix f = Matrix.InputfileMatrix("Input.txt");
          //f.displayMatrix();

            Matrix f = Matrix.InputfileMatrix("Input.txt");
            int g = Matrix.getStringCount("Input.txt");
            System.out.println("j= "+f.getN());
            int n = Matrix.getColomnCount("Input.txt");
            System.out.println("j= "+f.getM());


            // Matrix arr = new Matrix (Matrix.getStringCount("Input.txt"),
                //        Matrix.getColomnCount("Input.txt") );


            //Matrix x = Matrix.InputfileMatrix("Input2.txt");

           // Matrix mM = Matrix.add(f, x);

       //     mM.displayMatrix();

        }
        catch(IllegalArgumentException e ) {
            System.out.println (e);}
        catch(java.util.InputMismatchException e ) {
            System.out.println ("Упс... что ");}

        //Matrix f = Matrix.InputfileMatrix("Input.txt");
       // f.setElement(1,1,-54);
       // f.displayMatrix();

      //  Matrix arr = new Matrix (Matrix.getStringCount("Input.txt"),
           //     Matrix.getColomnCount("Input.txt") );

       // f.displayMatrix();


         //double[][] A = {{-21, 21, -21}, {18, -11, 11}, {-81, 41, -51}};
      //  double[][] B = {{21, -51, 11}, {-10, 13, -21}, {1, -11, 10}};
       // System.out.println("--------------------------");
       // Matrix x = Matrix.InputfileMatrix("Input2.txt");



      //  x.displayMatrix();

      //  Matrix mM = Matrix.add(f, x);
        System.out.println("--------------------------");
      //  mM.displayMatrix();
    }
}


