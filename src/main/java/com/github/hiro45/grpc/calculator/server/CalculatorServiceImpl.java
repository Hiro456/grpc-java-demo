package com.github.hiro45.grpc.calculator.server;

import com.proto.sumProto.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void calc(SumRequest request, StreamObserver<Calculations> responseObserver) {
        // Extract the fields we needs
        Integer firstNumber = request.getFirstNumber();
        Integer secondNumber = request.getSecondNumber();

        //create response
        Integer sum = firstNumber + secondNumber;
        Integer molt = firstNumber * secondNumber;

        Calculations calculations = Calculations.newBuilder()
                .setSumResponse(sum)
                .setMoltResponse(molt)
                .build();

        //send response back to the client
        responseObserver.onNext(calculations);

        //complete the gRPC call
        responseObserver.onCompleted();
    }

    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        Integer N = request.getNumber();

        if (N>=0) {
            Double SqrtN = Math.sqrt((double) N);

            SquareRootResponse SqrtNResponse = SquareRootResponse.newBuilder().setSquareNumber(SqrtN).build();
            responseObserver.onNext(SqrtNResponse);

        }else {
            //we construct the exception
            Throwable Erro01 = Status.INVALID_ARGUMENT
                    .withDescription("Error, the number is not positive")
                    .augmentDescription("Number Sent: " + N)
                    .asRuntimeException();
            responseObserver.onError(Erro01);
        }

        responseObserver.onCompleted();

    }
}
