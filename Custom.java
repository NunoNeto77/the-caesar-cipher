package com.company;

import java.io.*;

public class Custom {

    public String readFile(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/com/company/" + fileName));

        String line = "";
        String result = "";

        while((line = reader.readLine()) != null) {
            result += line + "\n";
        }


        reader.close();
        return line;
    }


    public void writeOnFile(String fileName, String content) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/company/" + fileName));
        writer.write(content);
        writer.close();
    }

    ////////////////----------------------------------------------------



    public String encrypt(String message, int rotation) {
    // letters of alphabet = 26

        if (rotation > 26) {
            rotation = rotation % 26;  // ex: 60 % 26 = 8. /  26 - uma volta. / 26+26 = 52 (2 voltas). / 52+8 = 60.  se a letra for ' a ', vai mudar pra ' i '
        }

            else if (rotation < 0) {
                rotation = (rotation % 26) + 26; // (-10 % 26) = -10 + 26 = 16
        }

        String encodedMessage = "";

        for (int i = 0; i < message.length(); i++) {  // percorrer cada caracter da mensagem
            char ch = message.charAt(i); // cada caracter

            if (Character.isLetter(ch)) {  // só queremos letras, não numeros nem caracteres especiais
                if (Character.isLowerCase(ch)) { // se a letra for minúscula
                    char c = (char) (ch + rotation);  // fazer o cast (char) pra n dar o ASCII code

                    if (c > 'z') { // se a letra estiver depois do z, deve  voltar ao 'a'
                        encodedMessage += (char) (ch - (26 - rotation));
                    }
                        else {
                            encodedMessage += c;
                    }

                }

                    else if (Character.isUpperCase(ch)) {
                        char c = (char) (ch + rotation);  // fazer o cast (char) pra n dar o ASCII code

                        if (c > 'Z') { // se a letra estiver depois do z, deve  voltar ao 'a'
                        encodedMessage += (char) (ch - (26 - rotation));
                    }
                            else {
                                encodedMessage += c;
                    }
                }
            }
                else {
                    encodedMessage += ch;
            }

        }
        return encodedMessage;


    }

    // --------------------------------- DECRYPT ----------------------------------------------------------

    public String decrypt(String message, int rotation) {
        // letters of alphabet = 26

        if (rotation > 26) {
            rotation = rotation % 26;
        }

        else if (rotation < 0) {
            rotation = (rotation % 26) + 26;
        }

        String decryptedMessage = "";

        for (int i = 0; i < message.length(); i++) {  // percorrer cada caracter da mensagem
            char ch = message.charAt(i); // cada caracter

            if (Character.isLetter(ch)) {  // só queremos letras, não numeros nem caracteres especiais
                if (Character.isLowerCase(ch)) { // se a letra for minúscula
                    char c = (char) (ch - rotation);  // fazer o cast (char) pra n dar o ASCII code

                    if (c < 'a') {
                        decryptedMessage += (char) (ch + (26 - rotation));
                    }
                    else {
                        decryptedMessage += c;
                    }

                }

                else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch - rotation);  // fazer o cast (char) pra n dar o ASCII code

                    if (c < 'A') {
                        decryptedMessage += (char) (ch + (26 - rotation));
                    }
                    else {
                        decryptedMessage += c;
                    }
                }
            }
            else {
                decryptedMessage += ch;
            }

        }
       return decryptedMessage;

    }
}

/*
The Caesar cipher is a basic encryption technique used by Julius Caesar to securely communicate with his generals.
 Each letter is replaced by another letter N positions down the english alphabet.
 For example, for a rotation of 5,
 the letter 'c' would be replaced by an 'h'. In case of a 'z', the alphabet rotates and it is transformed into a 'd'.
Implement an encoder/decoder for the Caesar cipher.

Your program should allow the user to:
Choose the rotation for encoding/decoding
Save the encoded text to a file with a given name
Load an encoded file from the file system and decode it
Non english alphabet characters should stay the same

Bonus points if:
It autodecodes the file (without the user specifying the rotation)
It allows the user to encrypt the text with Caesar cypher on steroids:
The rotation for each character is equal to the amount of times that character is in the text.
Example: "THESE STEROIDS WILL MAKE ME SUPER BUFF. THANKS, BRUTUS. WHAT'S WITH THE KNIFE?"
"T" will have a rotation a 7. "H" will have a rotation of 5.

We need to have the encoder/decoder ready for our campaign in Gaul, so crack on. Hail, Caesar!


 */