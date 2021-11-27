package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        String text  = "This is some message";
        Custom cipher = new Custom();

        String encryptedMessage = cipher.encrypt(text, 5);
        System.out.println(encryptedMessage);

        String desencryptedMessage = cipher.decrypt(encryptedMessage, 5);
        System.out.println(desencryptedMessage);

        // to write on a file
        cipher.writeOnFile("bananas.txt", encryptedMessage);

        cipher.writeOnFile("bananas2.txt", desencryptedMessage);

    }
}
