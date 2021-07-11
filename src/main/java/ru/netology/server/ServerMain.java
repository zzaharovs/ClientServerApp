package ru.netology.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {

        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new
                     BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("New connection accepted");

            //Отправляем запрос имени
            out.println("Write you name");
            //Принимаем имя
            final String name = in.readLine();

            //Запрашиваем возраст
            out.println("Are you an adult? yes/no");
            //Принимаем возраст
            final String adult = in.readLine();

            //Открываем доступ к нужной категории в зависимости от ответа
            if ("yes".equals(adult)) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest," +
                        " or a good working day", name));

            } else if ("no".equals(adult)) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));

            } else {
                out.println("Access denied, wrong message ");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}