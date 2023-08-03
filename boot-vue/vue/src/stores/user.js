import { computed, ref } from 'vue'
import { defineStore } from 'pinia'

export const userStore = defineStore('user', () => {
  const user = ref({})

  const id = computed(() => user.value.id)
  const name = computed(() => user.value.name)
  const isLoggedIn = computed(() => user.value.id != null)

  const setUser = data => {
    console.log(data)
    user.value = data
  }

  return { id, name, isLoggedIn, setUser }
})
