package cn.luoyanze.as.aop;

import cn.luoyanze.as.mapper.SessionKeyDao;
import cn.luoyanze.as.mapper.SessionMapper;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2021/4/23 9:19 下午
 */
@Data
@Aspect
@Component
public class SessionPointCut {
    private final HttpServletResponse response;
    //private final SessionKeyDao sessionKeyDao;
    private final SessionMapper session;

    public SessionPointCut(HttpServletResponse response, SessionMapper session) {
        this.response = response;
        this.session = session;
    }

    @Pointcut("execution(* cn.luoyanze.as.controller.AsController.*(..))")
    public void point() {
    }

    @Around("point()")
    public Object sessionIdError(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        if (validation(args, argNames)) {
            return joinPoint.proceed(args);
        } else {
            System.out.println("sessionId not found");
            return null;
        }
    }

    private boolean validation(Object[] args, String[] argNames) throws IOException {
        for (int i = 0; i < argNames.length; i++) {
            if ("sessionId".equalsIgnoreCase(argNames[i])) {
                if (null == session.getSession((String) args[i])) {
                    response.setStatus(403);
                    response.getWriter().close();
                    return false;
                }
            }
        }
        return true;
    }
}
