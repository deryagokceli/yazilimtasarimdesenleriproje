<script setup>
import { ref } from 'vue'
import axios from 'axios'

const isLoginOpen = ref(false)
const email = ref('')
const sifre = ref('')
const user = ref(null)

const handleLogin = async () => {
  try {
    // Senin yazdığın Spring Boot endpoint'ine istek atıyoruz
    const response = await axios.post('http://localhost:8080/api/kullanicilar/login', {
      email: email.value,
      sifre: sifre.value
    })

    user.value = response.data
    alert('Giriş başarılı! Hoş geldin ' + user.value.ad)
    isLoginOpen.value = false
  } catch (error) {
    alert('Hata: ' + (error.response?.data || 'Giriş yapılamadı'))
  }
}
</script>
<template>
  <div class="min-h-screen bg-white">
  <!-- Giriş Modalı -->
      <div v-if="isLoginOpen" class="fixed inset-0 bg-black/50 flex items-center justify-center p-4">
        <div class="bg-white p-8 rounded-xl shadow-2xl w-full max-w-md text-gray-800">
          <h3 class="text-2xl font-bold mb-6 text-akinci-mavi">Müşteri Girişi</h3>
          <div class="space-y-4">
            <input v-model="email" type="email" placeholder="E-posta" class="w-full p-3 border rounded-lg focus:ring-2 focus:ring-akinci-mavi outline-none">
            <input v-model="sifre" type="password" placeholder="Şifre" class="w-full p-3 border rounded-lg focus:ring-2 focus:ring-akinci-mavi outline-none">
            <button @click="handleLogin" class="w-full bg-akinci-mavi text-white py-3 rounded-lg font-bold hover:bg-blue-900 transition">Sisteme Gir</button>
            <button @click="isLoginOpen = false" class="w-full text-gray-500 text-sm">Vazgeç</button>
          </div>
        </div>
      </div>
    <!-- Navigasyon Barı -->
    <nav class="bg-[--color-akinci-mavi] p-4 text-white flex justify-between items-center shadow-lg">
      <h1 class="text-2xl font-bold tracking-widest">AKINCI TEKNİK</h1>
      <div class="space-x-6">
        <a href="#" class="hover:text-orange-400 transition">Ana Sayfa</a>
        <a href="#" class="hover:text-orange-400 transition">Hizmetlerimiz</a>
        <button
              @click="isLoginOpen = true"
              class="bg-orange-500 px-6 py-2 rounded-lg font-bold hover:bg-orange-600 transition shadow-md"
            >
              Giriş Yap
        </button>
      </div>
    </nav>

    <!-- Hero Bölümü -->
    <header class="bg-akinci-gri py-20 px-10 text-center">
      <h2 class="text-4xl md:text-6xl font-extrabold text-akinci-mavi mb-4">
        Hızlı ve Güvenilir Teknik Servis
      </h2>
      <p class="text-lg text-gray-600 mb-8 max-w-2xl mx-auto">
        Buzdolabı, çamaşır makinesi, klima ve daha fazlası... Akıncı Teknik ile cihazlarınız emin ellerde.
      </p>
      <div class="flex justify-center gap-4">
        <button class="bg-akinci-mavi text-white px-8 py-3 rounded-full font-semibold">Randevu Al</button>
        <button class="border-2 border-akinci-mavi text-akinci-mavi px-8 py-3 rounded-full font-semibold">Servis Takibi</button>
      </div>
    </header>
  </div>
</template>
