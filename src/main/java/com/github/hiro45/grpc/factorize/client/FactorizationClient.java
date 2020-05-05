package com.github.hiro45.grpc.factorize.client;

import com.proto.primedcomp.DecompositionGrpc;
import com.proto.primedcomp.InputNumber;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;

public class FactorizationClient {

    private void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();

        DecompositionGrpc.DecompositionBlockingStub factorClient = DecompositionGrpc.newBlockingStub(channel);

        Integer numberToDecompose = 120;

        InputNumber N = InputNumber.newBuilder().setNumberToDecompose(numberToDecompose).build();

        List<Integer> decompositionList = new ArrayList<Integer>();
        factorClient.decompose(N).forEachRemaining(
            outputNumbers -> {
            decompositionList.add(outputNumbers.getDecoposedNumbers());
        });

        System.out.println("The number " + numberToDecompose +
                " can be decomposed in: "+ decompositionList);
    }

    public static void main(String[] args) {
        FactorizationClient main = new FactorizationClient();
        main.run();
    }

}
