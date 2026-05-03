package com.akinciteknik.servis.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private final Map<String, Integer> istekSayilari = new HashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ipAdresi = request.getRemoteAddr();
        int mevcutIstekSayisi = istekSayilari.getOrDefault(ipAdresi, 0);

        if (mevcutIstekSayisi >= 20) {
            response.setStatus(429);
            response.getWriter().write("Cok fazla istek yaptiniz. Lutfen daha sonra tekrar deneyin.");
            return false;
        }

        istekSayilari.put(ipAdresi, mevcutIstekSayisi + 1);
        return true;
    }
}
