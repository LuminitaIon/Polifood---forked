import axios from "axios";
import store from "../store/index";
import { req } from "vuelidate/lib/validators/common";

const AXIOS = axios.create({
  baseURL: `http://localhost:8098/api`,
  timeout: 30000
});

AXIOS.interceptors.response.use(
  function(response) {
    if (response.headers["authorization"] != null) {
      localStorage.setItem("access_token", response.headers["authorization"]);
    }

    if (response.data !== null && response.data.errorType != null) {
      // store.state.errorDialog = true; TODO in state
      // store.state.errorModel = response.data;
    }

    return response;
  },
  function(error) {
    if (error.response.status === 403) {
      //store.state.errorDialog = true; TODO in state
      //store.state.errorModel = {errorType: "Access denied", message: "You have no permission on this action"};
    }
    return Promise.reject(error);
  }
);

AXIOS.interceptors.request.use(
  function(request) {
    if (!request.url.includes("login")) {
      request.headers["authorization"] = localStorage.getItem("access_token");
    } else delete request.headers["authorization"];

    return request;
  },
  function(error) {
    return Promise.reject(error);
  }
);

export default {
  login(email, password) {
    return AXIOS.post("/login", {
      email: email,
      password: password
    });
  },
  getMenu() {
    return AXIOS.get("/menu");
  },
  getMenuElementsFromCafeteria(name) {
    return AXIOS.get("/cafeteria/getMenuFromCafeteria/" + name);
  },
  getMenuElementsFromMenuDay(day, cafeteria) {
    return AXIOS.get(
      "/cafeteria/menuElementsFromMenuDay/" + day + "/" + cafeteria
    );
  },
  getUserWithoutId() {
    return AXIOS.get("/user/getCurrentUser");
  },
  getCafeteriasAdmin() {
    return AXIOS.get("/cafeteria/cafeteriaAdmin");
  },
  getUsers() {
    return AXIOS.get("/user");
  },
  getOrders() {
    return AXIOS.get("/order/getAll");
  },
  add_new_order(id, time) {
    return AXIOS.post("/order/newOrder/" + id + "/" + time)
  }
};
