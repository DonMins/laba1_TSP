import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Maks on 07.02.2018.
 */
public class Matrix {
    int n, m;
    double[][] mainMatrix;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.mainMatrix = new double[this.n][this.m];
    }

    public int getN() {return this.n; }

    public int getM() { return this.m; }

    public double getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }
    public  void setElement(int n, int m, double value)
    {
        this.mainMatrix[n][m] = value;
    }

    public void fillRandomValues()
    {
        Random rand = new Random();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                mainMatrix[i][j] = rand.nextInt(10);
            }
        }
    }
    public static void OutfileMatrix( Matrix mat,String file) throws IOException {

        BufferedWriter filewriter = new BufferedWriter(new FileWriter(file));
        try {
            for (int i = 0; i < mat.getN(); ++i) {
                for (int j = 0; j < mat.getM(); ++j) {
                    filewriter.write(mat.mainMatrix[i][j] + " ");
                }
                filewriter.newLine();
            }
            filewriter.flush();
            filewriter.close();

        } catch (IOException e) {
            System.err.println("Oops ... something went wrong with reading Output(" + e);
        }
        catch (NullPointerException e){
            System.err.println("Oops ... some");}

    }

    public static int getStringCount(String file) // кол - во строк в файле
    {
        int i=0;
        String line=null;
        BufferedReader bufferedReader = null;
        try{
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            while(line!=null) {
                if (!line.equals("")) {
                    i++;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch(IOException e){
            System.err.println("Oops ... something went wrong with reading String (" +e);
        }
        return i;
    }

    public static int getColomnCount(String file){  // кол - во столбцов в файле
        int  j=0;
        String line=null;
        BufferedReader bufferedReader = null;
        try{
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            line= bufferedReader.readLine();
            j = line.split(" +").length;

        } catch (IOException e) {
            System.err.println("Oops ... something went wrong with reading Colomn (" + e);
        } catch (NullPointerException e) {
            System.err.println("Oops ... empty file Colomn(" + e);
        }
        return j;

    }

    public static Matrix InputfileMatrix(String file) {
        Scanner sc = null;
        Matrix mA = null;
        try {
            sc = new Scanner(new File(file));
            int n1 = getStringCount(file);
            int m1 = getColomnCount(file);

            mA = new Matrix(n1, m1);
            double f = 0;

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    mA.setElement(i, j, sc.nextDouble());
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!  " + e);
        } catch (InputMismatchException e) {
            System.err.println("Oops ... something went wrong with reading Input(" + e);
        } catch (NoSuchElementException e) {
            System.err.println("Oops ... superfluous enterter (" + e);
        }
        return mA;
    }

    public static Matrix add(Matrix first, Matrix second) {
        if(first.getM() != second.getM() ||
                first.getN() != second.getN()) {
            throw new IllegalArgumentException("The dimensions of the matrices must be compatible!!");
        } else {
            Matrix tmpMatrix = new Matrix(first.getN(), second.getM());
            for (int i = 0; i < tmpMatrix.getN(); i++) {
                for (int j = 0; j < tmpMatrix.getM(); j++) {
                    tmpMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }

            return tmpMatrix;
        }
    }
    public void displayMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}