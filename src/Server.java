import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, Exception {
        Socket client;
        ServerSocket server = null;
        DataInputStream in;
        DataOutputStream  out;
        Matrix a ;
        Matrix b;
        Matrix c = null;
        try {
            server = new ServerSocket(3345);
        } catch (IOException ex) {
            System.out.println("Could not connect!");
            System.exit(-1);
        }

        while (true) {

            boolean flag= false;

            try {
                client = server.accept(); // ожидаем подключение
                System.out.println("Client connect");

                in = new DataInputStream(client.getInputStream()); // канал чтения из соке

                int n =  in.readInt();
                int m =  in.readInt();
                a= new Matrix(n,m);


                for(int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        a.setElement(i,j, in.readDouble());
                    }
                }

                int n2 =  in.readInt();
                int m2 = in.readInt();
                b= new Matrix(n2,m2);

                for(int i = 0; i < n2; i++) {
                    for (int j = 0; j < m2; j++) {
                        b.setElement(i,j, in.readDouble());
                    }
                }
                int n3=0;
                int m3=0;

                if ((a.getN()==b.getN())&&(a.getM()==b.getM())) {
                    try {
                        c = Matrix.add(a, b);
                        n3 = c.getN();
                        m3 = c.getM();
                    }
                    catch (IllegalArgumentException e){
                        System.err.println("Oops ... (" + e);
                    }

                    flag = true;
                }
                out = new DataOutputStream(client.getOutputStream());
                out.writeBoolean(flag);
                if (flag){

                    out.writeInt(n3);
                    out.writeInt(m3);

                    for (int i = 0; i < n3; i++) {
                        for (int j = 0; j < m3; j++) {
                            out.writeDouble(c.getElement(i, j));
                        }
                    }
                }

                in.close();
                out.close();
                client.close();

            } catch (IOException e) {
                e.getMessage();
            }

        }
    }
}