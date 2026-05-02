<template>
  <div class="min-h-screen bg-white font-sans text-gray-900">

    <!-- TOP BAR -->
    <div class="bg-[#1a237e] text-white text-sm py-2 px-4 flex justify-end gap-4">
      <a href="tel:02266002027" class="hover:text-orange-300 transition flex items-center gap-1">📞 Hemen Ara</a>
      <a href="https://wa.me/902266002027" class="hover:text-orange-300 transition flex items-center gap-1">💬 WhatsApp</a>
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
        <a href="https://wa.me/902266002027" class="hidden md:block bg-green-500 text-white px-5 py-2 rounded-full text-sm font-bold hover:bg-green-600 transition">
          WhatsApp'tan Yaz
        </a>
        <template v-if="!user">
          <button @click="isLoginOpen = true" class="border border-[#1a237e] text-[#1a237e] px-5 py-2 rounded-full text-sm font-bold hover:bg-blue-50 transition">
            Müşteri Girişi
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

      <!-- HERO / SLIDER AREA -->
      <div class="relative bg-[#1a237e] overflow-hidden">
        <!-- Sliding images -->
        <div class="flex transition-transform duration-700 ease-in-out" :style="{ transform: `translateX(-${sliderIndex * 100}%)` }">
          <div v-for="img in sliderImages" :key="img" class="min-w-full h-72 md:h-96 bg-[#1a237e] flex items-center justify-center overflow-hidden">
            <img :src="img" class="w-full h-full object-cover opacity-60" alt="Beyaz Eşya Servisi" />
          </div>
        </div>
        <!-- Overlay text -->
        <div class="absolute inset-0 flex flex-col items-center justify-center text-white text-center px-4">
          <h1 class="text-3xl md:text-5xl font-extrabold mb-4 drop-shadow-lg">Profesyonel Beyaz Eşya Teknik Servisi</h1>
          <p class="text-lg md:text-xl text-blue-200 mb-8 drop-shadow">Yalova ve çevresinde garantili onarım ve hızlı servis hizmeti.</p>
          <a href="tel:02266002027" class="bg-orange-500 hover:bg-orange-600 text-white px-10 py-4 rounded-full font-extrabold text-lg transition shadow-2xl">
            HEMEN SERVİS ÇAĞIR
          </a>
        </div>
        <!-- Slider dots -->
        <div class="absolute bottom-4 left-1/2 -translate-x-1/2 flex gap-2">
          <button v-for="(_, i) in sliderImages" :key="i"
            @click="sliderIndex = i"
            class="w-2.5 h-2.5 rounded-full transition"
            :class="sliderIndex === i ? 'bg-orange-500' : 'bg-white/50'">
          </button>
        </div>
      </div>

      <!-- 4 ÖZELLİK KARTLARI -->
      <section class="py-16 px-6 max-w-6xl mx-auto">
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-6">
          <div class="text-center p-6 border border-gray-100 rounded-2xl shadow-sm hover:shadow-md transition">
            <div class="text-4xl mb-3">🛡️</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">GARANTİLİ SERVİS</h3>
            <p class="text-gray-500 text-sm">Tüm parça ve işçilik hizmetlerimiz 1 yıl garantilidir.</p>
          </div>
          <div class="text-center p-6 border border-gray-100 rounded-2xl shadow-sm hover:shadow-md transition">
            <div class="text-4xl mb-3">⚡</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">HIZLI MÜDAHALE</h3>
            <p class="text-gray-500 text-sm">Yalova geneline aynı gün yerinde servis sunuyoruz.</p>
          </div>
          <div class="text-center p-6 border border-gray-100 rounded-2xl shadow-sm hover:shadow-md transition">
            <div class="text-4xl mb-3">👨‍🔧</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">UZMAN KADRO</h3>
            <p class="text-gray-500 text-sm">Alanında tecrübeli ve sertifikalı teknisyenler.</p>
          </div>
          <div class="text-center p-6 border border-gray-100 rounded-2xl shadow-sm hover:shadow-md transition">
            <div class="text-4xl mb-3">💰</div>
            <h3 class="font-extrabold text-[#1a237e] text-base mb-2">ŞEFFAF FİYAT</h3>
            <p class="text-gray-500 text-sm">Onarım öncesi net ücret bilgisi, sürpriz maliyet yok.</p>
          </div>
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

    <!-- ===== MÜŞTERİ PANELİ ===== -->
    <div v-else class="max-w-6xl mx-auto py-12 px-6">
      <h2 class="text-3xl font-bold mb-2 text-[#1a237e]">Servis Geçmişim ve Faturalarım</h2>
      <p class="text-gray-400 mb-8 text-sm">Hoş geldin, <span class="font-semibold text-gray-700">{{ user.ad }}</span></p>

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
          <h3 class="text-2xl font-bold text-[#1a237e]">Müşteri Paneli</h3>
          <p class="text-gray-400 mt-1 text-sm">Servis takibi ve faturalarınız için giriş yapın.</p>
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

  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import axios from 'axios'

const isLoginOpen = ref(false)
const email = ref('')
const sifre = ref('')
const user = ref(null)
const randevular = ref([])

// Slider
const sliderIndex = ref(0)
const sliderImages = [
  'https://corluyetkiliservis.com.tr/tema/genel/uploads/urunler/7_1.png',
  'https://corluyetkiliservis.com.tr/tema/genel/uploads/urunler/diger/1_9.png',
  'https://corluyetkiliservis.com.tr/tema/genel/uploads/urunler/diger/9_8.png',
]
let sliderTimer = null
onMounted(() => {
  sliderTimer = setInterval(() => {
    sliderIndex.value = (sliderIndex.value + 1) % sliderImages.length
  }, 3500)
})
onUnmounted(() => clearInterval(sliderTimer))

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
  } catch (error) {
    alert('Hata: Giriş bilgileri geçersiz.')
  }
}

const fetchRandevular = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/randevular/musteri/${user.value.id}`)
    randevular.value = response.data
  } catch (error) {
    console.error('Randevular yüklenemedi')
  }
}

const logout = () => {
  user.value = null
  randevular.value = []
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