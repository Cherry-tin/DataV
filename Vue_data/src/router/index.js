import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ChinaMap from '../components/ChinaMap.vue'
import Gender from '../components/Gender.vue'
import Campus from '../components/Campus.vue'
import Yue from '../components/Yue.vue'
import Physics from '../components/Physics.vue'
import History from '../components/History.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }, 
  {
    path: '/chinaMap',
    name: 'ChinaMap',
    component: ChinaMap
  },
  {
    path: '/gender',
    name: 'Gender',
    component: Gender
  },
  {
    path: '/campus',
    name: 'Campus',
    component: Campus
  },
  {
    path: '/yue',
    name: 'yue',
    component: Yue
  },
  {
    path: '/physics',
    name: 'physics',
    component: Physics
  },
  {
    path: '/history',
    name: 'history',
    component: History
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
