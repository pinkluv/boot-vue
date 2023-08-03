import { createRouter, createWebHistory } from 'vue-router'
import routes from '@/router/routes'
import { userStore } from '@/stores/user'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
})

router.beforeEach((to, from, next) => {
  const user = userStore()
  if (to.fullPath == '/signup') {
    next()
  } else if (to.fullPath != '/signin' && !user.isLoggedIn) {
    next('/signin')
  } else if (to.fullPath == '/signin' && user.isLoggedIn) {
    next('/')
  } else {
    next()
  }
})

export default router
