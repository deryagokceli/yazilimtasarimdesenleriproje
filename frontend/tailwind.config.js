/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'akinci-mavi': '#003366',
        'akinci-gri': '#f4f4f4',
      }
    },
  },
  plugins: [],
}