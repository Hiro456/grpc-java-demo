package com.github.hiro45.grpc.greating.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.File;
import java.io.IOException;

public class Greetingserver {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");


        //created the server using the GreetServiceImple which is an override of the
        // function greet created by the greet.proto
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .build();

        //for production use secureChannel
//        Server server = ServerBuilder.forPort(50051)
//                .addService(new GreetServiceImpl())
//                .useTransportSecurity(
//                        new File("ssl/server.crt"),
//                        new File("ssl/server.pem")
//                ).build();


        server.start();

        // to stop the server gracefully
        Runtime.getRuntime().addShutdownHook(new Thread( () ->{
                System.out.println("Received Shutdown Request");
                server.shutdown();
                System.out.println("Successfully stopped the server");
                }
            )
        ); //whenever the java recive shutownon

        server.awaitTermination();
    }
}
