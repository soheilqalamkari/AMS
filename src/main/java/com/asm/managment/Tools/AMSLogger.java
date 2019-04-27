////package com.asm.managment.Tools;
////
////import org.apache.log4j.Logger;
////import org.apache.log4j.MDC;
////
////public class AMSLogger extends Logger {
////
////    private Logger rootLogger;
////
////    public AMSLogger(String name) {
////        super(name);
////        this.rootLogger = Logger.getLogger(name);
////    }
////
////    public void trace(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        rootLogger.trace(message);
////    }
////
////    public void debug(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        rootLogger.debug(message);
////    }
////
////
////    public void error(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        rootLogger.error(message);
////    }
////
////    public void fatal(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        rootLogger.fatal(message);
////    }
////
////
////    public void info(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        rootLogger.info(message);
////    }
////
////
////    public void warn(Object message,String subSystem,String userName) {
////        MDC.put("subSystem",subSystem);
////        MDC.put("userName",userName);
////        super.warn(message);
////    }
//}
