import Vue from "vue";
import Vuex from "vuex";
import api from "../components/backend-api";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    login: {
      email: null,
      password: null,
      loading: false,
      role: null,
      cafeteria_name: null
    }
  },
  mutations: {
    login_success(state, payload) {
      state.login.loading = false;
      state.login.email = payload.email;
      state.login.password = payload.password;
      state.login.role = payload.role;
      state.login.cafeteria_name = payload.cafeteria_name;
    },
    logout(state, payload) {
      state.login.email = null;
      state.login.password = null;
      state.login.role = null;
      state.login.cafeteria_name = null;
    }
  },
  actions: {
    login({ commit }, { email, password }) {
      return new Promise((resolve, reject) => {
        this.state.login.loading = true;

        api
          .login(email, password)
          .then(response => {
            if (response.status === 200) {
              localStorage.setItem("role", response.data.role);
              localStorage.setItem("cafeteria_name", response.data.cafeteria);

              console.log(response.data.role + " " + response.data.cafeteria);

              commit("login_success", {
                email: email,
                password: password,
                role: response.data.role,
                cafeteria_name: response.data.cafeteria
              });
            }

            resolve(response);
          })
          .catch(() => {
            //TODO save error
            reject("Failed to login");
          });
      });
    },
    logout({ commit }) {
      localStorage.removeItem("role");
      localStorage.removeItem("cafeteria_name");
      localStorage.removeItem("access_token");

      commit("logout", {});
    }
  },
  modules: {},
  getters: {
    getRole: state => this.state.login.role,
    getEmail: state => this.state.login.email
  }
});
