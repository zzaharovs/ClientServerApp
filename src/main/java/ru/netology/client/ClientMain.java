package ru.netology.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {


    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8081;
        Scanner sc = new Scanner(System.in);


        try (Socket client = new Socket(host, port);
             PrintWriter output = new
                     PrintWriter(client.getOutputStream(), true);
             BufferedReader input = new
                     BufferedReader(new InputStreamReader(client.getInputStream()))) {

            //Печатаем запрос имени
            System.out.println(input.readLine());

            //Отправляем имя
            output.println(sc.nextLine());

            //Печатаем запрос возраста
            System.out.println(input.readLine());

            //Отправляем возраст
            output.println(sc.nextLine());

            //Принимаем итоговое сообщение
            String resp = input.readLine();
            System.out.println(resp);

        } catch (IOException ex) {

            ex.printStackTrace();

        }
    }
}
