package com.verily.example.greeting;

import static org.assertj.core.api.Assertions.assertThat;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:/com/verily/example/greeting/test.properties")
public class GreetingApplicationTests {
  private ManagedChannel channel;

  @Before
  public void setup() {
    channel = InProcessChannelBuilder.forName("test-server").build();
  }

  @After
  public void teardown() {
    channel.shutdownNow();
  }

  @Test
  public void contextLoads() {
    // Make sure Application Context starts.
  }

  @Test
  public void testGreeting() {
    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);
    GreetingResponse response = stub.greet(GreetingRequest.newBuilder().setName("Ray").build());

    assertThat(response).isNotNull();
    assertThat(response.getGreeting().contains("Ray, I am feeling lucky @")).isTrue();
  }
}
