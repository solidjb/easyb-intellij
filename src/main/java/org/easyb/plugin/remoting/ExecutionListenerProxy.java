package org.easyb.plugin.remoting;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Stack;

import org.easyb.BehaviorStep;
import org.easyb.domain.Behavior;
import org.easyb.listener.ExecutionListener;
import org.easyb.result.ReportingTag;
import org.easyb.result.Result;
import org.easyb.util.BehaviorStepType;

import static org.easyb.plugin.remoting.EventType.*;
import static org.easyb.plugin.remoting.RemoteUtils.safeWriteObject;

/**
 * Serialize execution events and send them over a socket to a listener on the other end
 */
public class ExecutionListenerProxy implements ExecutionListener {
  private ObjectOutputStream outputStream;

  public ExecutionListenerProxy(int port) throws IOException {
    Socket socket = new Socket(InetAddress.getLocalHost(), port);
    outputStream = new ObjectOutputStream(socket.getOutputStream());
  }

  public void startBehavior(Behavior behavior) {
    safeWriteObject(new Event(START_BEHAVIOR, behavior), outputStream);
  }

  public void startStep(BehaviorStep behaviorStep) {
    safeWriteObject(new Event(START_STEP, behaviorStep), outputStream);
  }

  public void describeStep(String description) {
    safeWriteObject(new Event(DESCRIBE_STEP, description), outputStream);
  }

  public void gotResult(Result result) {
    safeWriteObject(new Event(GOT_RESULT, result), outputStream);
  }

  public void stopStep() {
    safeWriteObject(new Event(STOP_STEP), outputStream);
  }

  public void stopBehavior(BehaviorStep behaviorStep, Behavior behavior) {
    safeWriteObject(new Event(STOP_BEHAVIOR, behavior), outputStream);
  }

  public void tag(ReportingTag tag) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public void completeTesting() {
    safeWriteObject(new Event(COMPLETE_TESTING), outputStream);
//        safeClose(socket);
  }
}
