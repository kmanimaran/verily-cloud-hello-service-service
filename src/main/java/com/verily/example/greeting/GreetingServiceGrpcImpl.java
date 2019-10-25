package com.verily.example.greeting;

import io.grpc.stub.StreamObserver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class GreetingServiceGrpcImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
  private static Logger logger = LoggerFactory.getLogger(GreetingServiceGrpcImpl.class);
  private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

  @Override
  public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
    Date date = new Date();

    responseObserver.onNext(
        GreetingResponse.newBuilder()
            .setGreeting(request.getName() + ", I am feeling lucky @" + sdf.format(date))
            .build());
    responseObserver.onCompleted();
  }
}
