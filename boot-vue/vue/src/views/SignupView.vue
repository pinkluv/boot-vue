<template>
  <div
    class="flex justify-content-center align-content-center align-items-center container"
  >
    <div class="surface-section">
      <div class="grid grid-nogutter">
        <div
          class="col-12 md:col-6 bg-no-repeat bg-cover p-8"
          style="background-image: url('images/contact-2.jpg')"
        >
          <div class="text-white text-2xl font-medium mb-6">Contact Us</div>
          <div class="text-gray-300 line-height-3 mb-6">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua.
          </div>
          <a
            class="inline-flex align-items-center text-blue-300 font-bold no-underline cursor-pointer"
          >
            <span class="mr-3">View Address on Google Maps</span>
            <i class="pi pi-arrow-right"></i>
          </a>
          <ul class="list-none p-0 m-0 mt-6 text-white">
            <li class="flex align-items-center mb-3">
              <i class="pi pi-phone mr-2"></i>
              <span>+123456789</span>
            </li>
            <li class="flex align-items-center mb-3">
              <i class="pi pi-twitter mr-2"></i>
              <span>@prime_ng</span>
            </li>
            <li class="flex align-items-center">
              <i class="pi pi-inbox mr-2"></i>
              <span>contact@primetek.com.tr</span>
            </li>
          </ul>
        </div>
        <div class="col-12 md:col-6">
          <div class="p-fluid formgrid grid px-4 py-8 md:px-6 lg:px-8">
            <div class="field col-12 lg:col-6 mb-4">
              <InputText
                id="id"
                type="text"
                class="py-3 px-2 text-lg"
                placeholder="ID"
                v-model="id"
              />
            </div>
            <div class="field col-12 lg:col-6 mb-4">
              <InputText
                id="pw"
                type="text"
                class="py-3 px-2 text-lg"
                placeholder="Password"
                v-model="pw"
              />
            </div>
            <div class="field col-12 mb-4">
              <InputText
                id="email"
                type="text"
                class="py-3 px-2 text-lg"
                placeholder="Email"
                v-model="email"
              />
            </div>
            <div class="field col-12 mb-4">
              <InputText
                id="phone"
                type="text"
                class="py-3 px-2 text-lg"
                placeholder="Phone"
                v-model="phone"
              />
            </div>
            <div class="field col-12 mb-4">
              <Textarea
                id="message"
                :rows="3"
                :autoResize="true"
                class="py-3 px-2 text-lg"
                placeholder="Message"
                v-model="desc"
              ></Textarea>
            </div>
            <div class="col-12 text-right">
              <Button
                label="Submit"
                icon="pi pi-envelope"
                class="px-5 py-3 w-auto"
                @click="submit"
              ></Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, inject } from 'vue'
import { useRouter } from 'vue-router'

const axios = inject('$axios')
const router = useRouter()

const id = ref('')
const pw = ref('')
const email = ref('')
const phone = ref('')
const desc = ref('')

const submit = () => {
  const params = {
    id: id.value,
    pw: pw.value,
    name: '',
    email: email.value,
    phone: phone.value,
    desc: desc.value,
  }
  axios
    .post('/api/user/signup', params, {
      headers: {
        'Content-Type': `application/x-www-form-urlencoded; charset=UTF-8;`,
      },
    })
    .then(({ data }) => {
      console.log(data)
      if (data === 'success') {
        console.log(router)
        router.push('/login')
      } else {
        console.log('error')
      }
    })
    .catch(e => console.log(e))
}
</script>

<style scoped>
.container {
  height: 100vh;
}
</style>
