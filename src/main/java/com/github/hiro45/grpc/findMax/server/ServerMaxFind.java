package com.github.hiro45.grpc.findMax.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerMaxFind {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(50051).addService(new FindMaxServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.shutdown();
        }));

        server.awaitTermination();
    }

}
