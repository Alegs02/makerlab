package com.example.makerlab;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class JavClient {
    private Socket soc;
    private DataOutputStream dout;
    String ip;

    /**
     * Initialise a connection to the socket server
     * !! Match the IP with the server
     * TODO:: Could make a parameter which will take the value from the Android app UI so IP can be changed all the time
     */
    public void initConBuffer() {
        try {
            this.soc = new Socket("127.0.0.1", 1234);
            this.dout = new DataOutputStream(soc.getOutputStream());
        } catch (IOException eio) {
            System.out.println("Error on connecting to the server");
        }
    }

    public void initConBufferActual(String ip) {
        try {
            this.soc = new Socket(ip, 9914);
            this.dout = new DataOutputStream(soc.getOutputStream());
        } catch (IOException eio) {
            System.out.println("Error on connecting to the server");
        }
    }

    /**
     * For sending test command to the server (Test the LED and connection)
     */
    public void sendTestCommand(){
        try{
            this.dout.writeUTF("TEST");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends Happy Emoji
     */
    public void sendHappy(){
        try{
            this.dout.writeUTF("SHOW HAPPY");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends OK Emoji
     */
    public void sendOK(){
        try{
            this.dout.writeUTF("SHOW OK");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends Alone Emoji
     */
    public void sendAlone(){
        try{
            this.dout.writeUTF("SHOW ALONE");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends Sad Emoji
     */
    public void sendSad(){
        try{
            this.dout.writeUTF("SHOW SAD");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends Book Emoji
     */
    public void sendBook(){
        try{
            this.dout.writeUTF("SHOW BUDDY_STUDY");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Sends Fitness Emoji
     */
    public void sendFitness(){
        try{
            this.dout.writeUTF("SHOW BUDDY_GYM");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * For sending test command to the server (Test the LED and connection)
     */
    public void sendEmergency(){
        try{
            this.dout.writeUTF("SHOW EMERGENCY");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * For sending show text (Show the text that is generated from SHOWTEXT command)
     */
    public void sendShowTextCommand(){
        try{
            this.dout.writeUTF("SHOWTEXT");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * For generating a text to PPM file for displaying
     * @param word: Word to be generate
     * @param red: Color valur for red 0-255
     * @param green: Color value for green 0-255
     * @param blue: Color value for blue 0-255
     * TODO:: Could change the colour value to string and then make a static value for each colors
     */
    public void sendGenTextCommand(String word,int red,int green,int blue){
        try{
            this.dout.writeUTF("GENTEXT " + word + red +" " + green + " " + blue);
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * Do the swapping between text and sign
     */
    public void sendSwapCommand(){
        try{
            this.dout.writeUTF("SWAP");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }

    /**
     * For stopping any running LED command
     */
    public void sendStop(){
        try{
            this.dout.writeUTF("STOP");
            this.dout.flush();
        } catch (IOException ioe){
            System.out.println("Error sending message");
        }
    }
}


