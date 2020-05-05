package com.github.hiro45.grpc.calculator.client;

import com.proto.sumProto.Calculator;
import com.proto.sumProto.CalculatorServiceGrpc;
import com.proto.sumProto.SquareRootRequest;
import com.proto.sumProto.SumRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

    private void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");
        CalculatorServiceGrpc.CalculatorServiceBlockingStub calcClient = CalculatorServiceGrpc.newBlockingStub(channel);

        Integer firstNumber = 1;
        Integer secondNumber = 12;

        SumRequest toBeSummed = SumRequest.newBuilder()
                .setFirstNumber(firstNumber)
                .setSecondNumber(secondNumber)
                .build();

        Integer sum = calcClient.calc(toBeSummed).getSumResponse();
        Integer molt = calcClient.calc(toBeSummed).getMoltResponse();

        System.out.println(firstNumber + "+" + secondNumber + "="  + sum);
        System.out.println(firstNumber + "+" + secondNumber + "="  + molt);

        SquareRootRequest sqrtNRequest = SquareRootRequest.newBuilder().setNumber(firstNumber).build();
        Double sqrtN = calcClient.squareRoot(sqrtNRequest).getSquareNumber();
        System.out.println("The sqrt of the number " + firstNumber +" is " + sqrtN);

    }

    public static void main(String[] args) {
        System.out.println("Hello I'm the Client");
        CalculatorClient main = new CalculatorClient();
        main.run();
    }

}
