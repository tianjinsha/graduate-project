import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../components/index'
import News from '../components/news'
import IT from '../components/IT'
import Live from '../components/live'
import Aware from '../components/aware'
import ResetPassword from '../components/reset-password'
import ItTags from '../components/ItTags'
import LiveTags from '../components/liveTags'
import AwareTags from '../components/awareTags'

Vue.use(VueRouter)

export default new VueRouter({
  linkActiveClass: 'active',
  mode: 'history',
  routes: [{
    name: 'index',
    path: '/',
    component: Index
  },
    {
      name: 'news',
      path: '/news',
      component: News
    },
    {
      name: 'it',
      path: '/it',
      component: IT
    },
    {
      name: 'live',
      path: '/live',
      component: Live
    },
    {
      name: 'aware',
      path: '/aware',
      component: Aware
    },
    {
      name: 'reset-password',
      path: '/reset-password',
      component: ResetPassword
    },
    {
      name:'itTags',
      path: '/itTags',
      component: ItTags
    },
    {
      name:'liveTags',
      path:'/liveTags',
      component:LiveTags
    },
    {
      name:'awareTags',
      path:'/awareTags',
      component:AwareTags
    }
  ]
})


