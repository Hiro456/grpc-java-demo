package com.github.hiro45.grpc.factorize.server;

import com.proto.primedcomp.DecompositionGrpc;
import com.proto.primedcomp.InputNumber;
import com.proto.primedcomp.OutputNumbers;
import io.grpc.stub.StreamObserver;

public class FactorizServiceImpl extends DecompositionGrpc.DecompositionImplBase {
    @Override
    public void decompose(InputNumber request, StreamObserver<OutputNumbers> responseObserver) {
        Integer numberToDecompose = request.getNumberToDecompose();
        Integer k = 2;

        while (numberToDecompose > 1){
            if ((numberToDecompose % k) == 0){
                System.out.println("k = " + k);
                numberToDecompose = numberToDecompose / k;
                OutputNumbers factorOfDecomposition = OutputNumbers.newBuilder().setDecoposedNumbers(k).build();
                responseObserver.onNext(factorOfDecomposition);
            }else {
                k = k + 1;
            }
        }
        responseObserver.onCompleted();
    }
}
