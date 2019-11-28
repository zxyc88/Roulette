import Vue from "vue";
import Router from "vue-router";
import MainPage from "./components/mainPage.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "mainPage",
      component: MainPage
    },
     {
       path: '/index.html',
       name: 'mainPage',
       component: MainPage
     }
  ]
});