import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/store'
import * as types from '../store/type'

import Index from '../page/index'
import Message from '../page/message'
import memberList from '../page/member/member-list'
import memberRegister from '../page/member/member-register'
import memberAddCard from '../page/member/member-card'
import memberCard from '../page/member/card-list'
import visitorAdd from '../page/member/visitor-add'
import consumerList from '../page/member/consumer-list'
import visitorRecord from '../page/member/visitor-record'
import navList from '../page/nav/index-nav'
import coachList from '../page/coach/coach-list'
import coachCard from '../page/coach/coach-card'
import coachStudent from '../page/coach/coach-student'
import cardType from '../page/goods/card-type'
import discountList from '../page/goods/discount-list'
import equipmentList from '../page/goods/equipment-list'
import loginPage from '../page/login/index'
Vue.use(VueRouter);


const routes= [
    {
      name: 'index',
      path: '/',
      component: Index,
      redirect:'/fitness',
      children: [
        {
          name: 'navList',
          path: '/fitness',
          component: navList
        },
        {
          name: 'member-list',
          path: '/member/list',
          component: memberList
        },
        {
          name: 'member-register',
          path: '/member/reg',
          component: memberRegister
        },
        {
          name: 'member-card',
          path: '/member/card',
          component: memberCard
        },
        {
          name: 'member-add-card',
          path: '/member/card-add',
          component: memberAddCard
        },
        {
          name: 'visitor-add',
          path: '/member/visitor-add',
          component: visitorAdd
        },
        {
          name: 'consumer-list',
          path: '/member/consumer',
          component: consumerList
        },
        {
          name: 'visitor-record',
          path: '/member/visitor',
          component: visitorRecord
        },
        {
          name: 'coach-card',
          path: '/coach/card',
          component: coachCard
        },
        {
          name: 'coach-list',
          path: '/coach/list',
          component: coachList
        },
        {
          name: 'coach-student',
          path: '/coach/student',
          component: coachStudent
        },
        {
          name: 'card-type',
          path: '/goods/card',
          component: cardType
        },
        {
          name: 'discount-list',
          path: '/goods/discount',
          component: discountList
        },
        {
          name: 'equipment-list',
          path: '/goods/equipment',
          component: equipmentList
        },
      ]
    },
    {
      name: 'message',
      path: '/message',
      component: Message
    },
    {
      name:'login',
      path:'/login',
      component:loginPage
    }
  ];
const router = new VueRouter({
  linkActiveClass: 'active',
  meta:{requireAuth: true,},
  mode: 'history',
  routes
});

// router.beforeEach((to, from, next) => {
//   if (to.matched.some(r => r.meta.requireAuth)) {
//     if (store.state.token) {
//       next();
//     }
//     else {
//       next({
//         path: '/login',
//         param: {redirect: to.fullPath}
//       })
//     }
//   }
//   else {
//     next();
//   }
// })

export default  router;

// export default new VueRouter({
//   linkActiveClass: 'active',
//   meta:{requireAuth: true,},
//   mode: 'history',
//   routes:routes
// });
