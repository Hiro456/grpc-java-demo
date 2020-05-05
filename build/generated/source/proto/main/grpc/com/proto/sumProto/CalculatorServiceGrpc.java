package com.proto.sumProto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: calculator/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "sumCalc.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.sumProto.SumRequest,
      com.proto.sumProto.Calculations> getCalcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Calc",
      requestType = com.proto.sumProto.SumRequest.class,
      responseType = com.proto.sumProto.Calculations.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.sumProto.SumRequest,
      com.proto.sumProto.Calculations> getCalcMethod() {
    io.grpc.MethodDescriptor<com.proto.sumProto.SumRequest, com.proto.sumProto.Calculations> getCalcMethod;
    if ((getCalcMethod = CalculatorServiceGrpc.getCalcMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getCalcMethod = CalculatorServiceGrpc.getCalcMethod) == null) {
          CalculatorServiceGrpc.getCalcMethod = getCalcMethod =
              io.grpc.MethodDescriptor.<com.proto.sumProto.SumRequest, com.proto.sumProto.Calculations>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Calc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sumProto.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sumProto.Calculations.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("Calc"))
              .build();
        }
      }
    }
    return getCalcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.sumProto.SquareRootRequest,
      com.proto.sumProto.SquareRootResponse> getSquareRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SquareRoot",
      requestType = com.proto.sumProto.SquareRootRequest.class,
      responseType = com.proto.sumProto.SquareRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.sumProto.SquareRootRequest,
      com.proto.sumProto.SquareRootResponse> getSquareRootMethod() {
    io.grpc.MethodDescriptor<com.proto.sumProto.SquareRootRequest, com.proto.sumProto.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getSquareRootMethod = CalculatorServiceGrpc.getSquareRootMethod) == null) {
          CalculatorServiceGrpc.getSquareRootMethod = getSquareRootMethod =
              io.grpc.MethodDescriptor.<com.proto.sumProto.SquareRootRequest, com.proto.sumProto.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sumProto.SquareRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sumProto.SquareRootResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("SquareRoot"))
              .build();
        }
      }
    }
    return getSquareRootMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    return new CalculatorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void calc(com.proto.sumProto.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.sumProto.Calculations> responseObserver) {
      asyncUnimplementedUnaryCall(getCalcMethod(), responseObserver);
    }

    /**
     * <pre>
     *thi rpc go trough an exeption if  the sent number is negative
     * </pre>
     */
    public void squareRoot(com.proto.sumProto.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.sumProto.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSquareRootMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalcMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.sumProto.SumRequest,
                com.proto.sumProto.Calculations>(
                  this, METHODID_CALC)))
          .addMethod(
            getSquareRootMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.sumProto.SquareRootRequest,
                com.proto.sumProto.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractStub<CalculatorServiceStub> {
    private CalculatorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     */
    public void calc(com.proto.sumProto.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.sumProto.Calculations> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *thi rpc go trough an exeption if  the sent number is negative
     * </pre>
     */
    public void squareRoot(com.proto.sumProto.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.sumProto.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.sumProto.Calculations calc(com.proto.sumProto.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalcMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *thi rpc go trough an exeption if  the sent number is negative
     * </pre>
     */
    public com.proto.sumProto.SquareRootResponse squareRoot(com.proto.sumProto.SquareRootRequest request) {
      return blockingUnaryCall(
          getChannel(), getSquareRootMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.sumProto.Calculations> calc(
        com.proto.sumProto.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalcMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *thi rpc go trough an exeption if  the sent number is negative
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.sumProto.SquareRootResponse> squareRoot(
        com.proto.sumProto.SquareRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALC = 0;
  private static final int METHODID_SQUARE_ROOT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALC:
          serviceImpl.calc((com.proto.sumProto.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.sumProto.Calculations>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.proto.sumProto.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.sumProto.SquareRootResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.sumProto.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculatorService");
    }
  }

  private static final class CalculatorServiceFileDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier {
    CalculatorServiceFileDescriptorSupplier() {}
  }

  private static final class CalculatorServiceMethodDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceFileDescriptorSupplier())
              .addMethod(getCalcMethod())
              .addMethod(getSquareRootMethod())
              .build();
        }
      }
    }
    return result;
  }
}
