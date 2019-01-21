// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './assets/css/basic.css'
import a from 'jquery'
// import './assets/js/basic'
import {
  Container,
  Header,
  Aside,
  Main,
  Footer,
  Form,
  Input,
  FormItem,
  Icon,
  Button,
  ButtonGroup,
  Carousel,
  CarouselItem,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Tabs,
  TabPane,
  // MessageBox
} from 'element-ui'

Vue.use(Container);
Vue.use(Header);
Vue.use(Aside);
Vue.use(Main);
Vue.use(Footer);
Vue.use(Form);
Vue.use(FormItem,);
Vue.use(Input);
Vue.use(Icon);
Vue.use( Button);
Vue.use( ButtonGroup);
Vue.use(Carousel);
Vue.use(CarouselItem);
Vue.use(Dropdown);
Vue.use(DropdownMenu);
Vue.use(DropdownItem);
Vue.use(Tabs);
Vue.use(TabPane)
// Vue.use(MessageBox);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  router,
  template: '<App/>'
})
