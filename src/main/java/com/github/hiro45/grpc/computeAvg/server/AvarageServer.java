package com.github.hiro45.grpc.computeAvg.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class AvarageServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(50051).addService(new AvarageServiceImpl()).build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            server.shutdown();
        }));
        server.awaitTermination();

    }

}
