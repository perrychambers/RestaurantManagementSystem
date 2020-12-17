import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/menu',
    name: 'Menu',
    component: () => import('../components/Menu.vue')
  },
  {
      path: '/newOrder',
      name: 'NewOrder',
      component: () => import('../components/NewOrder.vue')
  },
  {
      path: '/newRecipe',
      name: 'NewRecipe',
      component: () => import('../components/AddRecipe.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
