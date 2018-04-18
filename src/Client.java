import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) throws InterruptedException,IOException {
        Matrix a;
        /*String[] args=new String[3];
        args[0]="Input.txt";
        args[1]="Input2.txt";
        args[2]="matrix.txt";*/

        Matrix b;
        Matrix c = null;
        Socket socket = null;
        DataOutputStream out;
        DataInputStream in;
        String mess = null;

        try {
            try {
                a = Matrix.InputfileMatrix(args[0]);
                b = Matrix.InputfileMatrix(args[1]);

                try {
                    socket = new Socket("localhost", 3345);

                    int n = Matrix.getStringCount(args[0]);
                    int m = Matrix.getColomnCount(args[0]);

                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeInt(n);
                    out.writeInt(m);


                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            out.writeDouble(a.getElement(i, j));

                        }
                    }

                    int n2 = Matrix.getStringCount(args[1]);
                    int m2 = Matrix.getColomnCount(args[1]);

                    out.writeInt(n2);
                    out.writeInt(m2);

                    for (int i = 0; i < n2; i++) {
                        for (int j = 0; j < m2; j++) {
                            out.writeDouble(b.getElement(i, j));
                        }
                    }

                    in = new DataInputStream(socket.getInputStream());

                    boolean flag = in.readBoolean();
                    if (flag) {
                        int n3 = in.readInt();
                        int m3 = in.readInt();
                        c = new Matrix(n3, m3);

                        for (int i = 0; i < n3; i++) {
                            for (int j = 0; j < m3; j++) {
                                c.setElement(i, j, in.readDouble());
                            }
                        }
                    } else
                        mess = "Problem with dimensions";

                } catch (UnknownHostException ex) {
                    mess = "Unknown host ";
                }

            } catch (FileNotFoundException ex) {
                mess = "File not found ";
            } catch (IOException ex) {
                mess = ex.getMessage();
            }

            try {
                if (mess == null)
                    Matrix.OutfileMatrix(c, args[2]);
                else {
                    FileWriter f = new FileWriter(args[2]);
                    f.write(mess);
                    f.close();
                }

            } catch (IOException ex) {
                System.err.println("I / O error when trying to write the result");
            }

        }catch (ArrayIndexOutOfBoundsException t) {
            System.err.println("empty parameters");
        }

    }
}
