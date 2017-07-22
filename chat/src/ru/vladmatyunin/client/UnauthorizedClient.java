package ru.vladmatyunin.client;

import ru.vladmatyunin.chat.Chat;
import ru.vladmatyunin.entity.Credentials;
import ru.vladmatyunin.entity.User;
import ru.vladmatyunin.scp.Command;
import ru.vladmatyunin.scp.SCPFactory;
import ru.vladmatyunin.scp.SCProtocol;
import ru.vladmatyunin.scp.SCProtocolType;
import ru.vladmatyunin.scp.exceptions.ScpParseException;
import ru.vladmatyunin.server.ServerContext;
import ru.vladmatyunin.server.exceptions.UserNotFoundException;
import ru.vladmatyunin.server.user.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * First of all This is the next step, where each connected Client enters
 * The main process here is Authorization or registration, after which
 * user enters chat or being disconnected because of auth or registration failure
 */
public class UnauthorizedClient extends Thread {
    private Socket socket;
    private UserService userService = (UserService) ServerContext.lookUpService(UserService.class);

    public UnauthorizedClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String text = reader.readLine();
            SCProtocol protocol = SCPFactory.getSCP(text);

            // only complex type can be used for auth or reg
            if (protocol.type.equals(SCProtocolType.COMPLEX)) {

                //get credentials for client, not approved yet
                Credentials credentials = SCPFactory.getCredentials(protocol);

                //try to register user and create client for it
                if (protocol.getCommand().get().equals(Command.REGISTER)) {
                    new Client(socket, userService.registerUser(credentials)).start();

                }
                //try to auth and authenticate user and create client
                else if (protocol.getCommand().get().equals(Command.AUTHORIZE)) {
                    new Client(socket, userService.loginUser(credentials));
                }
                //TODO Customize Exception
                else throw new Exception();
            }
            //TODO Customize Exception if needed
            else throw new Exception();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
