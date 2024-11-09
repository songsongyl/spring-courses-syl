package org.example.backendexamples.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.backendexamples.component.JWTComponent;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final JWTComponent jwtComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null){
            throw XException.builder().code(Code.UNAUTHORIZED).build();
        }
        DecodedJWT decode = jwtComponent.decode(token);
        String uid = decode.getClaim("uid").asString();
        String role = decode.getClaim("role").asString();
        request.setAttribute("uid", uid);
        request.setAttribute("role", role);
        return true;
    }
}
