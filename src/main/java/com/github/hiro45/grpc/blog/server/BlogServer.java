package com.github.hiro45.grpc.blog.server;

import com.github.hiro45.grpc.greating.server.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class BlogServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");


        Server server = ServerBuilder.forPort(50051)
                .addService(new BlogServerImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();

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
