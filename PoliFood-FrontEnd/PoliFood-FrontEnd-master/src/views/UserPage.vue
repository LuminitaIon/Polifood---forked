<template>
  <v-card class="mx-auto" max-width="230" tile>
    <v-img
      height="100%"
      src="https://format-com-cld-res.cloudinary.com/image/private/s--3lZKmA3v--/c_crop,h_579,w_1500,x_0,y_421/c_fill,g_center,h_440,w_1140/fl_keep_iptc.progressive,q_95/v1/3166de8c85cdf32962078bab48f68692/ramen-1.jpg"
    >
      <v-row align="end" class="fill-height">
        <v-col align-self="start" class="pa-0" cols="12">
          <v-avatar class="profile" color="black" size="80" tile>
            <v-img
              src="https://image.freepik.com/free-vector/cartoon-chef-show-ok_61878-753.jpg"
              v-if="$store.state.role === 'CAFETERIA'"
            ></v-img>
            <v-img
              src="https://mpng.subpng.com/20180723/jji/kisspng-computer-icons-system-administrator-clip-art-administrator-icon-5b55e5abe6c9b4.2869445815323560119453.jpg"
              v-if="$store.state.role === 'ADMIN'"
            ></v-img>
            <v-img
                src="http://getdrawings.com/free-icon/student-icon-66.png"
                v-if="$store.state.role === 'USER'"
            ></v-img>
          </v-avatar> </v-col
        >s
        <v-col class="py-0">
          <v-list-item color="rgba(0, 0, 0, .4)" dark>
            <v-list-item-content>
              <v-list-item-title class="title">
                {{ this.lastName }} {{ this.firstName }}
              </v-list-item-title>
              <v-list-item-subtitle>{{ this.email }}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-col>
      </v-row>
    </v-img>
  </v-card>
</template>

<script>
import api from "../components/backend-api.js";

export default {
  name: "userPage",
  data() {
    return {
      UserInfo: [],
      firstName: "",
      lastName: "",
      email: ""
    };
  },

  methods: {
    displayUser() {
      this.firstName = this.UserInfo.firstName;
      this.lastName = this.UserInfo.lastName;
      this.email = this.UserInfo.email;
    }
  },
  beforeCreate() {
    api
      .getUserWithoutId()
      .then(response => {
        console.log(response.data);
        this.firstName = response.data.firstName;
        this.lastName = response.data.lastName;
        this.email = response.data.email;
      })
      .catch(error => {
        this.errors.push(error);
      });
  }
};
</script>
<style>
::-webkit-scrollbar {
  width: 0;
  background: yellow;
  display: inline !important;
}
.pass_show {
  position: relative;
}
.pass_show .ptxt {
  position: absolute;
  top: 50%;
  right: 10px;
  z-index: 1;
  color: #f36c01;
  margin-top: -10px;
  cursor: pointer;
  transition: 0.3s ease all;
}
.pass_show .ptxt:hover {
  color: #333333;
}
</style>
