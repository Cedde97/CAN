package com.example.joshi.can;

import com.example.joshi.can.Connection.Client;
import com.example.joshi.can.Connection.Server;
import com.example.joshi.can.Exception.XMustBeLargerThanZeroException;
import com.example.joshi.can.Exception.YMustBeLargerThanZeroException;
import com.example.joshi.can.Logic.Corner;
import com.example.joshi.can.Logic.Node;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test_Node_checkIfInMyZone_True()
    {
        Node node = new Node();
        try {
            Corner bottomLeftCorner = new Corner(0.0, 0.0);
            Corner bottomRightCorner= new Corner(1.0, 0.0);
            Corner topLeftCorner    = new Corner(0.0, 1.0);
            Corner topRightCorner   = new Corner(1.0, 1.0);
            node.setBottomLeftCorner(bottomLeftCorner);
            node.setBottomRightCorner(bottomRightCorner);
            node.setTopLeftCorner(topLeftCorner);
            node.setTopRightCorner(topRightCorner);
        }catch( XMustBeLargerThanZeroException e)
        {

        }catch (YMustBeLargerThanZeroException e)
        {

        }
        System.out.print("IP: 192.111.23.4 = " + node.hashX("192.111.23.4") + ", " + node.hashY("192.111.23.4") + "\n");
        System.out.print("IP: 255.255.255.255 = " +node.hashX("255.255.255.255") + ", " + node.hashY("255.255.255.255") + "\n");
        System.out.print("IP: 180.1.23.123 = " +node.hashX("180.1.23.123") + ", " + node.hashY("180.1.23.123") + "\n");
        System.out.print("IP: 12.191.3.255 = " +node.hashX("12.191.3.255") + ", " + node.hashY("12.191.3.255") + "\n");
        System.out.print("IP: 1.111.223.34 = " +node.hashX("1.111.223.34") + ", " + node.hashY("1.111.223.34") + "\n");
        System.out.print("IP: 0.0.0.0 = " +node.hashX("0.0.0.0") + ", " + node.hashY("0.0.0.0") + "\n");
        System.out.print("IP: 78.31.3.129 = " +node.hashX("78.31.3.129") + ", " + node.hashY("78.31.3.129") + "\n");
        System.out.print("IP: 111.111.111.111 = " +node.hashX("111.111.111.111") + ", " + node.hashY("111.111.111.111") + "\n");
        System.out.print("IP: 222.222.222.222 = " +node.hashX("222.222.222.222") + ", " + node.hashY("222.222.222.222") + "\n");
        System.out.print("IP: 12.191.10.255 = " +node.hashX("12.191.10.255") + ", " + node.hashY("12.191.10.255") + "\n");
        System.out.print("IP: 12.191.11.255 = " +node.hashX("12.191.11.255") + ", " + node.hashY("12.191.11.255") + "\n");
        System.out.print("IP: 12.191.12.255 = " +node.hashX("12.191.12.255") + ", " + node.hashY("12.191.12.255") + "\n");
        System.out.print("IP: 12.255.255.255 = " +node.hashX("12.191.13.255") + ", " + node.hashY("12.191.13.255") + "\n");

        assertEquals(true, node.checkIfInMyZone(node.hashX("192.111.23.4"), node.hashY("192.111.23.4")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("180.1.23.123"), node.hashY("180.1.23.123")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("12.191.3.255"), node.hashY("12.191.3.255")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("1.111.223.34"), node.hashY("1.111.223.34")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("255.255.255.255"), node.hashY("255.255.255.255")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("0.0.0.0"), node.hashY("0.0.0.0")));
        assertEquals(true, node.checkIfInMyZone(node.hashX("78.31.3.129"), node.hashY("78.31.3.129")));
    }
    @Test
    public void test_Node_checkIfInMyZone_False()
    {
        Node node = new Node();
        try {
            Corner bottomLeftCorner = new Corner(0.6, 0.4);
            Corner bottomRightCorner= new Corner(0.9, 0.4);
            Corner topLeftCorner    = new Corner(0.6, 0.9);
            Corner topRightCorner   = new Corner(0.9, 0.9);
            node.setBottomLeftCorner(bottomLeftCorner);
            node.setBottomRightCorner(bottomRightCorner);
            node.setTopLeftCorner(topLeftCorner);
            node.setTopRightCorner(topRightCorner);
        }catch( XMustBeLargerThanZeroException e)
        {

        }catch (YMustBeLargerThanZeroException e)
        {

        }
        System.out.print(node.hashX("192.111.23.4") + ", " + node.hashY("192.111.23.4") + "\n");
        System.out.print(node.hashX("255.255.255.255") + ", " + node.hashY("255.255.255.255") + "\n");
        System.out.print(node.hashX("0.0.0.0") + ", " + node.hashY("0.0.0.0") + "\n");
        System.out.print(node.hashX("78.31.3.129") + ", " + node.hashY("78.31.3.129") + "\n");
        assertEquals(false, node.checkIfInMyZone(node.hashX("192.111.23.4"), node.hashY("192.111.23.4")));
        assertEquals(false, node.checkIfInMyZone(node.hashX("255.255.255.255"), node.hashY("255.255.255.255")));
        assertEquals(false, node.checkIfInMyZone(node.hashX("0.0.0.0"), node.hashY("0.0.0.0")));
        assertEquals(false, node.checkIfInMyZone(node.hashX("78.31.3.129"), node.hashY("78.31.3.129")));
    }

    @Test
    public void test_ComputeDistance()
    {
        Node node = new Node();
        double x = node.hashX("192.111.23.4");
        double y = node.hashY("192.111.23.4");
        System.out.println(node.computeDistance(node.hashX("12.191.25.255"),node.hashY("12.191.25.255") ,node.hashX("12.191.10.255"),node.hashY("12.191.10.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.9.255"),node.hashY("12.191.9.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("1.1.1.100"),node.hashY("1.1.1.100")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.10.255"),node.hashY("12.191.10.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.11.255"),node.hashY("12.191.11.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.12.255"),node.hashY("12.191.12.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.13.255"),node.hashY("12.191.13.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("0.0.0.0"),node.hashY("0.0.0.0")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("255.255.255.255"),node.hashY("255.255.255.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("78.31.3.129"),node.hashY("78.31.3.129")));
    }

    @Test
    public void test_CompareValues()
    {
        Node node = new Node();
        double x = node.hashX("192.111.23.4");
        double y = node.hashY("192.111.23.4");
        double dis[] = new double[4];
        dis [0] = node.computeDistance(x ,y ,node.hashX("12.191.10.255"),node.hashY("12.191.10.255"));
        dis [1] = node.computeDistance(x ,y ,node.hashX("12.191.11.255"),node.hashY("12.191.11.255"));
        dis [2] = node.computeDistance(x ,y ,node.hashX("12.191.12.255"),node.hashY("12.191.12.255"));
        dis [3] = node.computeDistance(x ,y ,node.hashX("12.191.13.255"),node.hashY("12.191.13.255"));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.10.255"),node.hashY("12.191.10.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.11.255"),node.hashY("12.191.11.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.12.255"),node.hashY("12.191.12.255")));
        System.out.println(node.computeDistance(x ,y ,node.hashX("12.191.13.255"),node.hashY("12.191.13.255")));
        System.out.println(node.compareValues(dis));
        assertEquals(1, node.compareValues(dis));
    }

    @Test
    public void testSendIPAddress() throws IOException {
        Client client = new Client();
        try{
            client.sendeAlles("127.0.0.1","hashX","192.101.101.1",0.3,0.88766,2);

        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void receivingServer() throws IOException {
        Server server = new Server();
        server.start();

    }


    @Test
    public void test_hash() {

        class hashf {
            public void start(String ip) {
                double x = Math.random();
                double y = Math.random();

                System.out.println("IP: " + ip);
                System.out.println("X = " + x + " und Y = " + y);
                //System.out.println(x);
            }

            /*private double hashX(String str) {
                double i = 0;
                for (int j = 0; j < str.length(); j++) {
                    i += str.charAt(j) % 64+ j + (i/48);

                }
                return i / 1000;
            }

            private double hashY(String str) {
                double i = 0;
                for (int j = 0; j < str.length(); j++) {
                    i += str.charAt(j) % 32 + j + (i/8);

                }
                return i / 1000;
            }


            private String umkehren( String ip )
            {
                String umgekehrt = new String();

                for ( int j = ip.length()-1; j >= 0; j-- )
                    umgekehrt += ip.charAt(j);

                return umgekehrt;
            }*/

        }


        hashf h = new hashf();
        h.start("2.3.5.6");
        h.start("245.52.63.86");
        h.start("5.36.32.72");
        h.start("37.83.96.255");
        h.start("2.3.1.4");
        h.start("255.255.255.255");
        h.start("0.0.0.0");
    }
}