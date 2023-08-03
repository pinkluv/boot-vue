<template>
  <div
    class="flex justify-content-center align-content-center align-items-center container"
  >
    <div class="surface-card p-4 shadow-2 border-round w-full lg:w-6">
      <div class="text-center mb-5">
        <!-- <img
          src="images/blocks/logos/hyper.svg"
          alt="Image"
          height="50"
          class="mb-3"
        /> -->
        <div class="text-900 text-3xl font-medium mb-3">Welcome Back</div>
        <span class="text-600 font-medium line-height-3"
          >Don't have an account?</span
        >
        <a
          class="font-medium no-underline ml-2 text-blue-500 cursor-pointer"
          @click="signup"
          >Create today!</a
        >
      </div>

      <div>
        <label for="email1" class="block text-900 font-medium mb-2"
          >Email</label
        >
        <InputText
          id="email1"
          type="text"
          placeholder="Email address"
          class="w-full mb-3"
          v-model="email"
        />

        <label for="password1" class="block text-900 font-medium mb-2"
          >Password</label
        >
        <InputText
          id="password1"
          type="password"
          placeholder="Password"
          class="w-full mb-3"
          v-model="pw"
        />

        <div class="flex align-items-center justify-content-between mb-6">
          <div class="flex align-items-center">
            <Checkbox
              id="rememberme1"
              :binary="true"
              v-model="rememberme"
              class="mr-2"
            ></Checkbox>
            <label for="rememberme1">Remember me</label>
          </div>
          <a
            class="font-medium no-underline ml-2 text-blue-500 text-right cursor-pointer"
            >Forgot password?</a
          >
        </div>

        <Button
          label="Sign In"
          icon="pi pi-user"
          class="w-full"
          @click="signin"
        ></Button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, inject } from 'vue'
import { useRouter } from 'vue-router'
import { userStore } from '@/stores/user'

const axios = inject('$axios')
const router = useRouter()
const user = userStore()

const email = ref('')
const pw = ref('')
const rememberme = ref()

const signup = () => {
  console.log('signup called.....')
  router.push({ name: 'Signup' })
}

const signin = () => {
  // console.log('called signin......')
  const params = { email: email.value, pw: pw.value }
  axios
    .post('/api/user/signin', params, {
      headers: {
        'Content-Type': `application/x-www-form-urlencoded; charset=UTF-8;`,
      },
    })
    .then(({ data }) => {
      console.log(data.result)
      if (data.result == true) {
        console.log(data.user)

        user.setUser(data.result)

        console.log(`User Id : ${user.id}`)

        // console.log(router)
        // router.push('/')
      } else {
        console.log('error')
        router.push('/singup')
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
