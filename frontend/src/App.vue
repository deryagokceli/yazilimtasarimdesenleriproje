<template>
  <div class="min-h-screen bg-white">
    <!-- Navigasyon Barı -->
    <nav class="bg-[--color-akinci-mavi] p-4 text-white flex justify-between items-center shadow-lg">
      <h1 class="text-2xl font-bold tracking-widest">AKINCI TEKNİK</h1>
      <div class="space-x-6">
        <a href="#" class="hover:text-orange-400 transition">Ana Sayfa</a>
        <a href="#" class="hover:text-orange-400 transition">Hizmetlerimiz</a>
        <button class="bg-orange-500 px-4 py-2 rounded font-bold hover:bg-orange-600">Giriş Yap</button>
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
