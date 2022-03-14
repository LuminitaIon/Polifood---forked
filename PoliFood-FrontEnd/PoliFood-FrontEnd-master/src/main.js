import "@babel/polyfill";
import "mutationobserver-shim";
import "./plugins/bootstrap-vue";
import "./registerServiceWorker";
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import store from "./store";
import vueCookies from "vue-cookies";
import VueSimpleAlert from "vue-simple-alert";
import '@mdi/font/css/materialdesignicons.css';
import 'vue-search-select/dist/VueSearchSelect.css';

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vuetify,
  vueCookies,
  VueSimpleAlert,
  render: h => h(App)
}).$mount("#app");
