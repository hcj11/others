package Btrace;
/**
 * Created by hcj on 18-3-11
 */

import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Duration;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class TraceMethodArgsAndReturn {
//  static{
//    println("---------------------------JVM properties:---------------------------");
//    printVmArguments();
//    println("---------------------------System properties:------------------------");
//    printProperties();
//    println("---------------------------OS properties:----------------------------");
//    printEnv();
//    exit();
//  }

  @OnMethod(
      // 测量方法调用的时间 对move方法进行测量  hanoi.
      clazz = "hanoi.HanoiDemo",
      method = "move",
      location = @Location(Kind.RETURN) // 方法返回值。
  )
  public static void traceExecute(
      @ProbeClassName String classname,
      @ProbeMethodName String methodname,
      @Duration long duration
  ) {
    // 秒
    // 监控超过2ms的方法名和类型名
    long l = duration / 1000000;
    if (l > 2) {
      println(strcat("duration(ms): " + classname +":"+ methodname, str(l)));

    }
  }

//  }
//  public static void traceExecute(
//      @Duration long duration
//     ){
//    // 纳秒
//    println(strcat("duration(nanos): ", str(duration)));
//    // 秒
//    println(strcat("duration(ms): ", str(duration / 1000000)));
//  }
//

}

