package com.akinciteknik.servis.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private static class IstekBilgisi {
        int sayac;
        long baslangicZamani;

        IstekBilgisi(int sayac, long baslangicZamani) {
            this.sayac = sayac;
            this.baslangicZamani = baslangicZamani;
        }
    }

    private final Map<String, IstekBilgisi> istekKayitlari = new HashMap<>();

    private final int LIMIT = 100;
    private final long ZAMAN_ARALIGI = 60_000; // 60 saniye

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ipAdresi = request.getRemoteAddr();
        long simdi = System.currentTimeMillis();

        IstekBilgisi bilgi = istekKayitlari.get(ipAdresi);

        if (bilgi == null || simdi - bilgi.baslangicZamani > ZAMAN_ARALIGI) {
            istekKayitlari.put(ipAdresi, new IstekBilgisi(1, simdi));
            return true;
        }

        if (bilgi.sayac >= LIMIT) {
            response.setStatus(429);
            response.getWriter().write("Cok fazla istek yaptiniz. Lutfen daha sonra tekrar deneyin.");
            return false;
        }

        bilgi.sayac++;
        return true;
    }
}
