// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index'
// import Vuex from 'vuex';
import store from './store/store'
import{fetch,post,patch,put} from './utils/http'
import axios from './utils/http'
// import Qs from ''
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import $ from 'jquery'
Vue.use(ElementUI);
Vue.prototype.$fetch = fetch;
Vue.prototype.$post = post;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;
Vue.prototype.$axios = axios;

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  components: { App },
  router,
  store,
  template: '<App/>'
})
