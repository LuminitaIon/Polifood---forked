<template>
  <div id="login" >
    <v-form id="login_form" v-model="isFormValid">
      <h1 style="color: black; font-size: 100px;">PoliFood</h1>
      <br />
      <v-text-field
        v-model="email"
        :rules="emailRules"
        label="Email"
        filled
        dense
      ></v-text-field>
      <v-text-field
        v-model="password"
        :rules="passwordRules"
        type="password"
        label="Password"
        filled
        dense
      ></v-text-field>
      <v-btn
        color="white"
        width="50%"
        :disabled="!isFormValid"
        v-on:click.prevent="loginFunc()"
        >Log in</v-btn
      >
    </v-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data: () => ({
    email: "",
    emailRules: [
      v => !!v || "Email is required",
      v => /.+@.+\..+/.test(v) || "Email must be valid",
      v => (v && v.length <= 100) || "Email must be less than 10 characters"
    ],
    password: "",
    passwordRules: [
      v => !!v || "Password is required",
      v => (v && v.length <= 100) || "Password must be less than 10 characters"
    ],
    isFormValid: false
  }),
  methods: {
    loginFunc() {
      this.$store
        .dispatch("login", { email: this.email, password: this.password })
        .then(() => {
          this.$router.push("/");
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>

<style>
#login {
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  position: absolute;
  background-color: #bd711b;
  display: flex;
  align-items: center;
  background-image: url("https://image.freepik.com/free-photo/white-empty-plate-center-fresh-raw-greens-vegetables-healthy-clean-eating-vegan-dieting-food-concept-white-background-top-view-copy-space_89816-10417.jpg") !important;
  background-repeat: no-repeat !important;
  background-attachment: fixed !important;
  background-size: cover !important;
}

#login_form {
  margin: auto;
  width: 60%;
  padding: 0 15%;
}
</style>
