import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products.vue'
import ProductDetail from '@/views/ProductDetail.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/product/:id',
    name: 'product-detail',
    component: ProductDetail
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
