import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../components/Login.vue"
import DailyMenusPageEmployee from "../views/DailyMenusPageEmployee.vue";
import GeneralMenuPageEmployee from "../views/GeneralMenuPageEmployee.vue";
import UserPage from "../views/UserPage";
import CafeteriasPageAdmin from "../views/CafeteriasPageAdmin";
import UsersPageAdmin from "../views/UsersPageAdmin";
import OrderUserPage from "../views/OrderUserPage";
import CafeteriaPageUser from "../views/CafeteriaPageUser";
import MenuPageUser from "../views/MenuPageUser";
import OrderTableEmployee from "../views/OrderTableEmployee";


Vue.use(VueRouter);
const routes = [
  {
    path: "/login",
    name: "Login",
    component: Login
  },
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/dailyMenus",
    name: "DailyMenus",
    component: DailyMenusPageEmployee
  },
  {
    path: "/generalMenuPage",
    name: "GeneralMenuPage",
    component: GeneralMenuPageEmployee
  },
  {
    path: "/userPage",
    name: "UserPage",
    component: UserPage
  },
  {
    path: "/cafeteriaPage",
    name: "CafeteriaPage",
    component: CafeteriasPageAdmin
  },
  {
    path: "/userPageAdmin",
    name: "UserPageAdmin",
    component: UsersPageAdmin
  },
  {
    path: "/orderUserPage",
    name: "OrderUserPage",
    component: OrderUserPage
  },
  {
    path: "/cafeteriaPageUser",
    name: "CafeteriaUserPage",
    component: CafeteriaPageUser
  },
  {
    path: "/menuPageUser/:name",
    name: "menuPageUser",
    component: MenuPageUser
  },
  {
    path: "/orderTableEmployee",
    name: "orderTableEmployee",
    component: OrderTableEmployee
  }
];
const router = new VueRouter({
  mode: "history",
  routes
});

router.beforeEach((to, from, next) => {
  // if (to.matched.some(record => record.meta.requiresAuth)) {
  // this route requires auth, check if logged in
  // if not, redirect to login page.
  if (to.path !== "/login")
    if (localStorage.getItem("access_token") == null) {
      next({
        path: "/login"
      });
    } else {
      next();
    }
  next(); // make sure to always call next()!
});

export default router;
