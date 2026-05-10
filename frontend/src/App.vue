<template>
  <div class="min-h-screen bg-white font-sans text-gray-900">

    <!-- TOP BAR -->
    <div class="bg-[#1a237e] text-white text-sm py-2 px-4 flex justify-end gap-4">
      <a href="tel:02266002027" class="hover:text-orange-300 transition flex items-center gap-1">📞 Hemen Ara</a>
      <a href="https://wa.me/902266002027?text=Merhaba,%20servis%20hakkında%20bilgi%20almak%20istiyorum." class="hover:text-orange-300 transition flex items-center gap-1">💬 WhatsApp</a>
    </div>

    <!-- NAV -->
    <nav class="bg-white border-b border-gray-100 px-6 py-4 flex justify-between items-center sticky top-0 z-50 shadow-sm">
      <div class="flex items-center gap-3">
        <div class="bg-[#1a237e] text-white p-2 rounded-lg text-lg font-bold">🔧</div>
        <div>
          <div class="text-[#1a237e] font-extrabold text-lg leading-none tracking-tight">AKINCI TEKNİK SERVİS</div>
          <div class="text-gray-400 text-xs">Yalova Beyaz Eşya Teknik Servisi</div>
        </div>
      </div>
      <div class="flex items-center gap-3">
        <a href="tel:02266002027" class="hidden md:block bg-[#1a237e] text-white px-5 py-2 rounded-full text-sm font-bold hover:bg-blue-900 transition">
          📞 0226 600 20 27
        </a>
        <a href="https://wa.me/902266002027?text=Merhaba,%20servis%20hakkında%20bilgi%20almak%20istiyorum." class="hidden md:block bg-green-500 text-white px-5 py-2 rounded-full text-sm font-bold hover:bg-green-600 transition">
          WhatsApp'tan Yaz
        </a>
        <template v-if="!user">
          <button @click="isLoginOpen = true" class="border border-[#1a237e] text-[#1a237e] px-5 py-2 rounded-full text-sm font-bold hover:bg-blue-50 transition">
            Giriş
          </button>
        </template>
        <template v-else>
          <span class="text-sm font-semibold text-gray-600">{{ user.ad }}</span>
          <button @click="logout" class="text-xs text-red-400 hover:text-red-600 border border-red-300 px-3 py-1 rounded-full transition">Çıkış</button>
        </template>
      </div>
    </nav>

    <!-- ===== GUEST VIEW ===== -->
    <div v-if="!user">

      <!-- HEMEN SERVİS ÇAĞIR sticky button -->
      <a href="tel:02266002027"
        class="fixed bottom-6 right-6 z-50 bg-orange-500 text-white px-6 py-3 rounded-full font-bold shadow-2xl hover:bg-orange-600 transition text-sm flex items-center gap-2">
        📞 HEMEN SERVİS ÇAĞIR
      </a>

      <!-- MODERN HERO -->
      <section class="relative overflow-hidden bg-gradient-to-br from-[#0f172a] via-[#1a237e] to-[#111827] text-white">
        <div class="absolute inset-0 opacity-20">
          <div class="absolute -top-24 -right-24 w-96 h-96 bg-orange-400 rounded-full blur-3xl"></div>
          <div class="absolute bottom-0 -left-24 w-80 h-80 bg-blue-400 rounded-full blur-3xl"></div>
        </div>

        <div class="relative max-w-7xl mx-auto px-6 py-24 grid grid-cols-1 lg:grid-cols-2 gap-12 items-center">
          <div>
            <div class="inline-flex items-center gap-2 bg-white/10 border border-white/20 rounded-full px-4 py-2 text-sm text-blue-100 mb-6">
              <span class="w-2 h-2 bg-green-400 rounded-full"></span>
              Yalova ve çevresinde aynı gün servis
            </div>

            <h1 class="text-4xl md:text-6xl font-extrabold leading-tight mb-6">
              Beyaz eşya arızalarında hızlı, şeffaf ve güvenilir servis.
            </h1>

            <p class="text-blue-100 text-lg leading-relaxed mb-8 max-w-xl">
              Akıncı Teknik Servis; buzdolabı, çamaşır makinesi, bulaşık makinesi, fırın ve ankastre ürünlerde profesyonel arıza tespiti ve onarım hizmeti sunar.
            </p>

            <div class="flex flex-col sm:flex-row gap-4">
              <a href="#servis-talep-formu"
                class="bg-orange-500 hover:bg-orange-600 text-white px-8 py-4 rounded-xl font-extrabold text-center shadow-xl transition">
                Servis Talebi Oluştur
              </a>
              <button @click="isLoginOpen = true"
                class="bg-white/10 hover:bg-white/20 border border-white/20 text-white px-8 py-4 rounded-xl font-bold transition">
                Panel Girişi
              </button>
            </div>
          </div>

          <div class="bg-white/10 backdrop-blur-xl border border-white/20 rounded-3xl p-6 shadow-2xl">
            <div class="bg-white text-gray-900 rounded-2xl p-6">
              <div class="flex items-center justify-between mb-6">
                <div>
                  <p class="text-sm text-gray-400">Bugünkü servis durumu</p>
                  <h3 class="text-2xl font-extrabold text-[#1a237e]">Aktif Operasyon</h3>
                </div>
                <span class="bg-green-100 text-green-700 px-3 py-1 rounded-full text-xs font-bold">CANLI</span>
              </div>

              <div class="space-y-4">
                <div class="flex justify-between items-center border-b pb-3">
                  <span class="text-gray-500 text-sm">Ortalama müdahale</span>
                  <span class="font-bold">Aynı gün</span>
                </div>
                <div class="flex justify-between items-center border-b pb-3">
                  <span class="text-gray-500 text-sm">Garanti</span>
                  <span class="font-bold">1 yıl işçilik</span>
                </div>
                <div class="flex justify-between items-center border-b pb-3">
                  <span class="text-gray-500 text-sm">Fiyatlandırma</span>
                  <span class="font-bold">Şeffaf fatura</span>
                </div>
                <div class="flex justify-between items-center">
                  <span class="text-gray-500 text-sm">Destek</span>
                  <span class="font-bold">Telefon / WhatsApp</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- 4 ÖZELLİK KARTLARI -->
      <section class="py-16 px-6 max-w-7xl mx-auto">
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
          <div class="p-6 border border-gray-100 rounded-3xl shadow-sm hover:shadow-xl transition bg-white">
            <div class="w-12 h-12 rounded-2xl bg-blue-50 text-[#1a237e] flex items-center justify-center font-black mb-5">01</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">Garantili Servis</h3>
            <p class="text-gray-500 text-sm leading-relaxed">Parça ve işçilik süreçleri kayıt altına alınır, servis sonrası destek sağlanır.</p>
          </div>

          <div class="p-6 border border-gray-100 rounded-3xl shadow-sm hover:shadow-xl transition bg-white">
            <div class="w-12 h-12 rounded-2xl bg-orange-50 text-orange-600 flex items-center justify-center font-black mb-5">02</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">Hızlı Müdahale</h3>
            <p class="text-gray-500 text-sm leading-relaxed">Yalova ve çevresinde servis talepleri hızlıca değerlendirilir.</p>
          </div>

          <div class="p-6 border border-gray-100 rounded-3xl shadow-sm hover:shadow-xl transition bg-white">
            <div class="w-12 h-12 rounded-2xl bg-green-50 text-green-700 flex items-center justify-center font-black mb-5">03</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">Uzman Teknisyen</h3>
            <p class="text-gray-500 text-sm leading-relaxed">Randevular teknisyen atamasıyla takip edilir, süreç şeffaf yürütülür.</p>
          </div>

          <div class="p-6 border border-gray-100 rounded-3xl shadow-sm hover:shadow-xl transition bg-white">
            <div class="w-12 h-12 rounded-2xl bg-purple-50 text-purple-700 flex items-center justify-center font-black mb-5">04</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">Şeffaf Fatura</h3>
            <p class="text-gray-500 text-sm leading-relaxed">Parça, işçilik ve toplam tutar müşteri panelinde açıkça görüntülenir.</p>
          </div>
        </div>
      </section>

      <!-- SERVİS TALEP FORMU -->
      <section id="servis-talep-formu" class="py-20 px-6 bg-gray-50 border-y border-gray-100">
        <div class="max-w-7xl mx-auto grid grid-cols-1 lg:grid-cols-2 gap-10 items-start">
          <div>
            <p class="text-sm font-bold text-orange-500 uppercase tracking-widest mb-3">Online Servis Talebi</p>
            <h2 class="text-3xl md:text-4xl font-extrabold text-[#1a237e] mb-5">
              Arızanızı bildirin, servis sürecini hemen başlatalım.
            </h2>
            <p class="text-gray-500 leading-relaxed mb-8">
              Formu doldurduktan sonra sistem sizin için bir servis kaydı oluşturur. Daha sonra aynı e-posta ile giriş yaparak servis durumunuzu ve fatura detaylarınızı takip edebilirsiniz.
            </p>

            <div class="bg-white border border-gray-100 rounded-3xl p-6 shadow-sm">
              <h3 class="font-extrabold text-[#1a237e] mb-4">Nasıl çalışır?</h3>
              <div class="space-y-4">
                <div class="flex gap-4">
                  <div class="w-8 h-8 rounded-full bg-blue-50 text-[#1a237e] flex items-center justify-center font-bold text-sm">1</div>
                  <p class="text-sm text-gray-600">Arıza ve iletişim bilgilerinizi gönderirsiniz.</p>
                </div>
                <div class="flex gap-4">
                  <div class="w-8 h-8 rounded-full bg-blue-50 text-[#1a237e] flex items-center justify-center font-bold text-sm">2</div>
                  <p class="text-sm text-gray-600">Sistem servis kaydınızı BEKLEMEDE durumuyla oluşturur.</p>
                </div>
                <div class="flex gap-4">
                  <div class="w-8 h-8 rounded-full bg-blue-50 text-[#1a237e] flex items-center justify-center font-bold text-sm">3</div>
                  <p class="text-sm text-gray-600">Admin panelinden servis süreci yönetilir ve size canlı bildirim gönderilir.</p>
                </div>
              </div>
            </div>
          </div>

          <form @submit.prevent="servisTalebiGonder" class="bg-white border border-gray-100 rounded-3xl shadow-xl p-6 md:p-8">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
              <input v-model="servisTalepFormu.ad" required placeholder="Ad"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
              <input v-model="servisTalepFormu.soyad" required placeholder="Soyad"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
              <input v-model="servisTalepFormu.email" required type="email" placeholder="E-posta"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
              <input v-model="servisTalepFormu.telefon" required placeholder="Telefon"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
              <input v-model="servisTalepFormu.cihazMarka" required placeholder="Cihaz Markası"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
              <input v-model="servisTalepFormu.cihazModel" required placeholder="Cihaz Modeli"
                class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">
            </div>

            <textarea v-model="servisTalepFormu.arizaAciklamasi" required placeholder="Arıza açıklaması"
              class="w-full mt-4 p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm min-h-32"></textarea>

            <button type="submit"
              class="w-full mt-6 bg-orange-500 hover:bg-orange-600 text-white py-4 rounded-xl font-extrabold transition shadow-lg">
              Servis Talebi Oluştur
            </button>

            <p class="text-xs text-gray-400 mt-4 text-center">
              Talep oluşturulduktan sonra e-posta adresinizle giriş yaparak süreci takip edebilirsiniz.
            </p>
          </form>
        </div>
      </section>

      <!-- KAYAN MARKA ŞERİDİ -->
      <div class="bg-gray-50 border-y border-gray-200 py-6 overflow-hidden">
        <p class="text-center text-xs font-bold text-gray-400 uppercase tracking-widest mb-4">Hizmet Verdiğimiz Markalar</p>
        <div class="relative flex overflow-hidden">
          <div class="flex animate-marquee gap-0">
            <span v-for="(marka, i) in [...markalar, ...markalar]" :key="'a'+i"
              class="whitespace-nowrap mx-3 text-xs font-bold text-[#1a237e] border border-blue-200 bg-white px-5 py-2 rounded-full">
              {{ marka }} SERVİSİ
            </span>
          </div>
        </div>
      </div>

      <!-- HİZMETLERİMİZ -->
      <section id="hizmetler" class="py-20 px-6 max-w-6xl mx-auto">
        <h2 class="text-3xl font-extrabold text-[#1a237e] text-center mb-4">Hizmetlerimiz</h2>
        <div class="w-16 h-1 bg-orange-500 mx-auto mb-12 rounded-full"></div>
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-8">
          <div v-for="hizmet in hizmetler" :key="hizmet.baslik"
            class="border border-gray-100 rounded-2xl p-8 hover:border-orange-400 hover:shadow-lg transition group cursor-default">
            <div class="text-5xl mb-5">{{ hizmet.emoji }}</div>
            <h3 class="text-lg font-extrabold text-[#1a237e] mb-3 group-hover:text-orange-500 transition">{{ hizmet.baslik }}</h3>
            <p class="text-gray-500 text-sm leading-relaxed">{{ hizmet.aciklama }}</p>
          </div>
        </div>
      </section>

      <!-- NEDEN AKINCI -->
      <section class="bg-[#1a237e] text-white py-16 px-6">
        <div class="max-w-3xl mx-auto text-center">
          <h2 class="text-3xl font-extrabold mb-6">Neden Akıncı Teknik Servis?</h2>
          <div class="w-16 h-1 bg-orange-500 mx-auto mb-8 rounded-full"></div>
          <p class="text-blue-200 text-base leading-relaxed">
            Yılların tecrübesiyle Yalova bölgesinde beyaz eşya teknik servis hizmeti sunuyoruz. Alanında uzman ekibimiz, en güncel ekipmanlarla arızalarınıza kalıcı çözümler üretir. Müşteri memnuniyeti ve güvenilirlik en temel ilkemizdir.
          </p>
        </div>
      </section>

      <!-- MÜŞTERİ YORUMLARI (kayan) -->
      <section class="py-16 px-6 bg-gray-50 border-y border-gray-200 overflow-hidden">
        <h2 class="text-3xl font-extrabold text-[#1a237e] text-center mb-4">Müşterilerimiz Ne Diyor?</h2>
        <div class="w-16 h-1 bg-orange-500 mx-auto mb-12 rounded-full"></div>
        <div class="relative flex overflow-hidden">
          <div class="flex animate-marquee-slow gap-0">
            <div v-for="(yorum, i) in [...yorumlar, ...yorumlar]" :key="'y'+i"
              class="flex-shrink-0 w-80 mx-4 bg-white border border-gray-100 rounded-2xl shadow-sm p-6 align-top">
              <div class="text-orange-400 text-base mb-3">★★★★★</div>
              <p class="text-gray-600 text-sm leading-relaxed italic mb-4">"{{ yorum.metin }}"</p>
              <div class="font-bold text-sm text-[#1a237e]">{{ yorum.isim }}</div>
              <div class="text-xs text-gray-400">{{ yorum.ilce }}</div>
            </div>
          </div>
        </div>
      </section>

      <!-- HİZMET BÖLGELERİ -->
      <section id="bolgeler" class="py-16 px-6 max-w-6xl mx-auto">
        <h2 class="text-3xl font-extrabold text-[#1a237e] text-center mb-4">Hizmet Verdiğimiz Bölgeler</h2>
        <div class="w-16 h-1 bg-orange-500 mx-auto mb-12 rounded-full"></div>
        <div class="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 gap-3">
          <div v-for="bolge in bolgeler" :key="bolge"
            class="text-center border border-gray-200 rounded-xl px-4 py-4 text-sm font-semibold text-gray-700 hover:bg-[#1a237e] hover:text-white hover:border-[#1a237e] transition cursor-default">
            {{ bolge }}
          </div>
        </div>
      </section>

      <!-- FOOTER -->
      <footer class="bg-gray-900 text-gray-400 text-sm text-center py-8 px-4">
        <p class="text-white font-bold mb-1">AKINCI TEKNİK SERVİS</p>
        <p class="mb-1">Yalova | 📞 <a href="tel:02266002027" class="text-orange-400 hover:underline">0226 600 20 27</a></p>
        <p class="mt-4 text-xs text-gray-600">Copyright © 2025. Her Hakkı Saklıdır.</p>
      </footer>

    </div><!-- end guest view -->

    <!-- ===== ADMIN PANELİ ===== -->
    <div v-else-if="user.rol === 'ADMIN'" class="max-w-7xl mx-auto py-12 px-6">
      <h2 class="text-3xl font-bold mb-2 text-[#1a237e]">Admin Yönetim Paneli</h2>
      <p class="text-gray-400 mb-8 text-sm">
        Tüm servis randevularını buradan yönetebilirsiniz.
      </p>
      <div class="grid grid-cols-1 md:grid-cols-4 gap-4 mb-8">
        <div class="bg-white border border-gray-100 rounded-2xl shadow-sm p-5">
          <p class="text-xs font-bold text-gray-400 uppercase mb-2">Toplam Randevu</p>
          <p class="text-3xl font-extrabold text-[#1a237e]">{{ toplamRandevu }}</p>
        </div>

        <div class="bg-white border border-gray-100 rounded-2xl shadow-sm p-5">
          <p class="text-xs font-bold text-gray-400 uppercase mb-2">Onarımda</p>
          <p class="text-3xl font-extrabold text-blue-600">{{ onarimdakiRandevu }}</p>
        </div>

        <div class="bg-white border border-gray-100 rounded-2xl shadow-sm p-5">
          <p class="text-xs font-bold text-gray-400 uppercase mb-2">Tamamlandı</p>
          <p class="text-3xl font-extrabold text-green-600">{{ tamamlananRandevu }}</p>
        </div>

        <div class="bg-white border border-gray-100 rounded-2xl shadow-sm p-5">
          <p class="text-xs font-bold text-gray-400 uppercase mb-2">Toplam Gelir</p>
          <p class="text-3xl font-extrabold text-orange-600">{{ toplamGelir }} ₺</p>
        </div>
      </div>

      <div class="bg-white rounded-2xl shadow-sm overflow-hidden border">
        <table class="w-full text-left">
          <thead class="bg-gray-50 border-b">
            <tr>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Müşteri</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Cihaz / Arıza</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Durum</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Toplam</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">İşlem</th>
            </tr>
          </thead>

          <tbody>
            <tr v-for="randevu in randevular" :key="randevu.id" class="border-b hover:bg-gray-50 transition">
              <td class="p-4 text-sm">
                {{ randevu.musteri?.ad }} {{ randevu.musteri?.soyad }}
              </td>

              <td class="p-4">
                <div class="font-semibold">{{ randevu.cihazMarka }} {{ randevu.cihazModel }}</div>
                <div class="text-xs text-gray-400 mt-0.5">{{ randevu.arizaAciklamasi }}</div>
              </td>

              <td class="p-4">
                <span class="px-3 py-1 rounded-full text-xs font-bold"
                      :class="{
                        'bg-yellow-100 text-yellow-700': randevu.durum === 'BEKLEMEDE',
                        'bg-blue-100 text-blue-700': randevu.durum === 'ONARIMDA',
                        'bg-green-100 text-green-700': randevu.durum === 'TAMAMLANDI',
                        'bg-red-100 text-red-700': randevu.durum === 'IPTAL'
                      }">
                  {{ randevu.durum }}
                </span>
              </td>

              <td class="p-4 font-bold text-orange-600">
                {{ randevu.toplamTutar }} ₺
              </td>

              <td class="p-4">
                <div class="flex gap-2 flex-wrap">
                  <button @click="durumGuncelle(randevu.id, 'ONARIMDA')"
                    class="bg-blue-500 text-white px-3 py-1 rounded-lg text-xs font-bold hover:bg-blue-600">
                    Onarıma Al
                  </button>

                  <button @click="durumGuncelle(randevu.id, 'TAMAMLANDI')"
                    class="bg-green-500 text-white px-3 py-1 rounded-lg text-xs font-bold hover:bg-green-600">
                    Tamamla
                  </button>

                  <button @click="durumGuncelle(randevu.id, 'IPTAL')"
                    class="bg-red-500 text-white px-3 py-1 rounded-lg text-xs font-bold hover:bg-red-600">
                    İptal
                  </button>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- ===== MÜŞTERİ PANELİ ===== -->
    <div v-else class="max-w-6xl mx-auto py-12 px-6">
      <h2 class="text-3xl font-bold mb-2 text-[#1a237e]">Servis Geçmişim ve Faturalarım</h2>
      <p class="text-gray-400 mb-8 text-sm">Hoş geldin, <span class="font-semibold text-gray-700">{{ user.ad }}</span></p>
      <div class="bg-white border border-gray-100 rounded-3xl shadow-sm p-6 mb-8">
        <div class="flex flex-col md:flex-row md:items-center md:justify-between gap-2 mb-5">
          <div>
            <h3 class="text-xl font-extrabold text-[#1a237e]">Yeni Servis Talebi</h3>
            <p class="text-sm text-gray-400">Yeni bir cihaz arızası için servis kaydı oluşturabilirsiniz.</p>
          </div>
        </div>

        <form @submit.prevent="musteriServisTalebiGonder" class="grid grid-cols-1 md:grid-cols-3 gap-4">
          <input v-model="musteriTalepFormu.cihazMarka" required placeholder="Cihaz Markası"
            class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">

          <input v-model="musteriTalepFormu.cihazModel" required placeholder="Cihaz Modeli"
            class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">

          <input v-model="musteriTalepFormu.arizaAciklamasi" required placeholder="Arıza açıklaması"
            class="p-4 bg-gray-50 border border-gray-200 rounded-xl outline-none focus:ring-2 focus:ring-orange-500 text-sm">

          <button type="submit"
            class="md:col-span-3 bg-orange-500 hover:bg-orange-600 text-white py-4 rounded-xl font-extrabold transition shadow-lg">
            Yeni Servis Talebi Oluştur
          </button>
        </form>
      </div>

      <div v-if="randevular.length === 0" class="text-center py-20 text-gray-400">
        <div class="text-5xl mb-4">📋</div>
        <p>Henüz kayıtlı servis talebiniz bulunmuyor.</p>
      </div>

      <div v-else class="bg-white rounded-2xl shadow-sm overflow-hidden border">
        <table class="w-full text-left">
          <thead class="bg-gray-50 border-b">
            <tr>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Cihaz / Arıza</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Tarih</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Durum</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Parça</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">İşçilik</th>
              <th class="p-4 font-bold text-sm text-[#1a237e]">Toplam</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="randevu in randevular" :key="randevu.id" class="border-b hover:bg-gray-50 transition">
              <td class="p-4">
                <div class="font-semibold">{{ randevu.cihazMarka }} {{ randevu.cihazModel }}</div>
                <div class="text-xs text-gray-400 mt-0.5">{{ randevu.arizaAciklamasi }}</div>
              </td>
              <td class="p-4 text-sm text-gray-600">{{ new Date(randevu.olusturmaTarihi).toLocaleDateString('tr-TR') }}</td>
              <td class="p-4">
                <span class="bg-green-100 text-green-700 px-3 py-1 rounded-full text-xs font-bold">{{ randevu.durum }}</span>
              </td>
              <td class="p-4 text-sm text-gray-600">{{ randevu.parcaUcreti }} ₺</td>
              <td class="p-4 text-sm text-gray-600">{{ randevu.iscilikUcreti }} ₺</td>
              <td class="p-4 font-bold text-orange-600">{{ randevu.toplamTutar }} ₺</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- GİRİŞ MODALI -->
    <div v-if="isLoginOpen" class="fixed inset-0 bg-black/60 backdrop-blur-sm flex items-center justify-center p-4 z-[100]">
      <div class="bg-white p-8 rounded-2xl shadow-2xl w-full max-w-md">
        <div class="text-center mb-8">
          <div class="text-5xl mb-3">🔧</div>
          <h3 class="text-2xl font-bold text-[#1a237e]">Sistem Girişi</h3>
          <p class="text-gray-400 mt-1 text-sm">Servis takibi ve yönetim paneli için giriş yapın.</p>
        </div>
        <div class="space-y-4">
          <input v-model="email" type="email" placeholder="E-posta Adresiniz"
            class="w-full p-4 bg-gray-50 border border-gray-200 rounded-xl focus:ring-2 focus:ring-orange-500 outline-none transition text-sm">
          <input v-model="sifre" type="password" placeholder="Şifreniz"
            class="w-full p-4 bg-gray-50 border border-gray-200 rounded-xl focus:ring-2 focus:ring-orange-500 outline-none transition text-sm">
          <button @click="handleLogin"
            class="w-full bg-[#1a237e] text-white py-4 rounded-xl font-bold text-base hover:bg-blue-900 transition">
            Güvenli Giriş Yap
          </button>
          <button @click="isLoginOpen = false" class="w-full text-gray-400 text-sm hover:text-gray-600 transition">
            İptal Et
          </button>
        </div>
      </div>
    </div>
    <div
      v-if="toastMessage"
      class="fixed top-6 right-6 z-[200] bg-[#1a237e] text-white px-6 py-4 rounded-2xl shadow-2xl border border-blue-300 max-w-sm"
    >
      <div class="font-bold mb-1">Bildirim</div>
      <div class="text-sm text-blue-100">{{ toastMessage }}</div>
    </div>

  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import axios from 'axios'

const isLoginOpen = ref(false)
const email = ref('')
const sifre = ref('')
const user = ref(null)
const randevular = ref([])
const toplamRandevu = computed(() => randevular.value.length)

const tamamlananRandevu = computed(() =>
  randevular.value.filter(r => r.durum === 'TAMAMLANDI').length
)

const onarimdakiRandevu = computed(() =>
  randevular.value.filter(r => r.durum === 'ONARIMDA').length
)

const toplamGelir = computed(() =>
  randevular.value.reduce((toplam, r) => toplam + (r.toplamTutar || 0), 0)
)
const toastMessage = ref('')
let eventSource = null

const servisTalepFormu = ref({
  ad: '',
  soyad: '',
  email: '',
  telefon: '',
  cihazMarka: '',
  cihazModel: '',
  arizaAciklamasi: ''
})
const musteriTalepFormu = ref({
  cihazMarka: '',
  cihazModel: '',
  arizaAciklamasi: ''
})

const markalar = [
  'ARÇELİK','BEKO','VESTEL','PROFİLO','BOSCH','SİEMENS',
  'SAMSUNG','LG','ARİSTON','İNDESİT','ALTUS','REGAL',
  'AEG','ELECTROLUX','WHIRLPOOL','HOTPOINT'
]

const hizmetler = [
  { emoji: '🧺', baslik: 'Çamaşır Makinesi Servisi', aciklama: 'Her marka ve model çamaşır makinesi için arıza tespiti, onarım ve bakım hizmetleri.' },
  { emoji: '🍽️', baslik: 'Bulaşık Makinesi Servisi', aciklama: 'Bulaşık makinenizin su almama, boşaltmama, temiz yıkamama gibi tüm sorunlarına çözüm.' },
  { emoji: '❄️', baslik: 'Buzdolabı Servisi', aciklama: 'Soğutmama, buzlanma, sesli çalışma gibi tüm buzdolabı arızalarında uzman servis.' },
  { emoji: '🔥', baslik: 'Fırın Servisi', aciklama: 'Solo ve ankastre fırınlarınızın ısıtmama, termostat arızası gibi sorunlarını gideriyoruz.' },
  { emoji: '💨', baslik: 'Kurutma Makinesi Servisi', aciklama: 'Kurutma makinenizin performans sorunları, mekanik ve elektronik arızaları için bize ulaşın.' },
  { emoji: '🏠', baslik: 'Ankastre Servisi', aciklama: 'Ankastre fırın, ocak, davlumbaz gibi tüm setlerinizin montaj, bakım ve onarımı.' },
]

const yorumlar = [
  { metin: 'Buzdolabım aniden bozuldu, aynı gün gelip tamir ettiler. Hızlı ve profesyonel hizmet için teşekkürler.', isim: 'Ahmet Y.', ilce: 'Yalova Merkez' },
  { metin: 'Çamaşır makinem ses yapıyordu. Gelen ekip sorunu hemen tespit edip uygun fiyata çözdü. Kesinlikle tavsiye ederim.', isim: 'Zeynep K.', ilce: 'Çınarcık' },
  { metin: 'Bulaşık makinem temiz yıkamıyordu. Servis sonrası pırıl pırıl oldu. Çok memnun kaldım.', isim: 'Mustafa A.', ilce: 'Altınova' },
  { metin: 'Fırınım ısıtmıyordu, aynı gün geldiler ve sorunsuz çözdüler. Harika hizmet!', isim: 'Ayşe D.', ilce: 'Armutlu' },
  { metin: 'Çamaşır makinem su sızdırıyordu. Servis ekibi çok hızlı geldi ve uygun fiyata tamir etti.', isim: 'Fatma B.', ilce: 'Termal' },
  { metin: 'Buzdolabım sesli çalışıyordu. Teknisyen problemi hemen buldu, teşekkürler.', isim: 'Mehmet S.', ilce: 'Çiftlikköy' },
  { metin: 'Kurutma makinem çalışmıyordu. Çok hızlı müdahale ettiler, memnunum.', isim: 'Elif G.', ilce: 'Yalova Merkez' },
  { metin: 'Bulaşık makinemi tamir ettirdim, şimdi mükemmel çalışıyor. Teşekkürler!', isim: 'Hasan T.', ilce: 'Altınova' },
  { metin: 'Servis ekibi çok nezaketti ve işini iyi biliyor. Kesinlikle tavsiye ederim.', isim: 'Emine Ö.', ilce: 'Çınarcık' },
]

const bolgeler = [
  'Yalova Merkez Yetkili Servisi',
  'Çınarcık Yetkili Servisi',
  'Altınova Yetkili Servisi',
  'Armutlu Yetkili Servisi',
  'Termal Yetkili Servisi',
  'Çiftlikköy Yetkili Servisi',
  'Karamürsel Yetkili Servisi',
  'Gemlik Yetkili Servisi',
  'Orhangazi Yetkili Servisi',
  'Mudanya Yetkili Servisi',
  'İznik Yetkili Servisi',
  'Gölcük Yetkili Servisi',
]

const handleLogin = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/kullanicilar/login', {
      email: email.value,
      sifre: sifre.value
    })
    user.value = response.data
    isLoginOpen.value = false
    fetchRandevular()
    if (user.value?.rol === 'MUSTERI') {

      eventSource = new EventSource(
        'http://localhost:8080/api/notifications/subscribe'
      )

      eventSource.addEventListener('randevu-guncelleme', (event) => {
        showToast(event.data)
        fetchRandevular()
      })
    }
  } catch (error) {
    alert('Hata: Giriş bilgileri geçersiz.')
  }
}

const fetchRandevular = async () => {
  try {
    let response

    if (user.value?.rol === 'ADMIN') {
      response = await axios.get('http://localhost:8080/api/randevular')
    } else {
      response = await axios.get(`http://localhost:8080/api/randevular/musteri/${user.value.id}`)
    }
    const yeniRandevular = response.data
    randevular.value = yeniRandevular
  } catch (error) {
    console.error('Randevular yüklenemedi')
  }
}

const showToast = (message) => {
  toastMessage.value = message

  setTimeout(() => {
    toastMessage.value = ''
  }, 3500)
}

const durumGuncelle = async (id, yeniDurum) => {
  try {
    await axios.put(`http://localhost:8080/api/randevular/${id}/durum?durum=${yeniDurum}`)
    await fetchRandevular()
  } catch (error) {
    alert('Durum güncellenemedi.')
  }
}

const servisTalebiGonder = async () => {
  try {
    await axios.post('http://localhost:8080/api/randevular/servis-talebi', {
      ...servisTalepFormu.value,
      parcaId: 7,
      saat: 2,
      stratejiTipi: 'STANDART'
    })

    showToast('Servis talebiniz başarıyla oluşturuldu. Giriş yaparak servis sürecinizi takip edebilirsiniz.')

    servisTalepFormu.value = {
      ad: '',
      soyad: '',
      email: '',
      telefon: '',
      cihazMarka: '',
      cihazModel: '',
      arizaAciklamasi: ''
    }
  } catch (error) {
    showToast('Servis talebi oluşturulamadı. Lütfen bilgileri kontrol edin.')
  }
}
const musteriServisTalebiGonder = async () => {
  try {
    await axios.post('http://localhost:8080/api/randevular/servis-talebi', {
      ad: user.value.ad,
      soyad: user.value.soyad,
      email: user.value.email,
      telefon: '',
      cihazMarka: musteriTalepFormu.value.cihazMarka,
      cihazModel: musteriTalepFormu.value.cihazModel,
      arizaAciklamasi: musteriTalepFormu.value.arizaAciklamasi,
      parcaId: 7,
      saat: 2,
      stratejiTipi: 'STANDART'
    })

    showToast('Yeni servis talebiniz oluşturuldu.')
    musteriTalepFormu.value = {
      cihazMarka: '',
      cihazModel: '',
      arizaAciklamasi: ''
    }

    await fetchRandevular()
  } catch (error) {
    showToast('Servis talebi oluşturulamadı.')
  }
}

const logout = () => {
  user.value = null
  randevular.value = []

  if (eventSource) {
    eventSource.close()
    eventSource = null
  }
}
</script>

<style>
@keyframes marquee {
  0%   { transform: translateX(0); }
  100% { transform: translateX(-50%); }
}
@keyframes marquee-slow {
  0%   { transform: translateX(0); }
  100% { transform: translateX(-50%); }
}
.animate-marquee {
  animation: marquee 20s linear infinite;
  width: max-content;
}
.animate-marquee-slow {
  animation: marquee-slow 40s linear infinite;
  width: max-content;
  display: flex;
}
</style>